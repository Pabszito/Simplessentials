package net.pabszito.simplessentials.listeners;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @Inject
    @Named("config")
    private Configuration config;

    @Inject
    @Named("language")
    private Configuration language;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String quitMessage = language.getString("language.quit_message")
                .replace("%player%", player.getName());

        if (!config.getBoolean("config.change_quit_message")) return;

        event.setQuitMessage(quitMessage.equalsIgnoreCase("none") ? null : quitMessage);
    }
}
