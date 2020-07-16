package net.pabszito.simplessentials.listeners;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @Inject @Named("config")
    private Configuration config;

    @Inject @Named("language")
    private Configuration language;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String joinMessage = language.getString("language.join_message")
                .replace("%player%", player.getName());

        if(!config.getBoolean("config.change_join_message")) return;

        event.setJoinMessage(joinMessage.equalsIgnoreCase("none") ? null : joinMessage);
    }
}
