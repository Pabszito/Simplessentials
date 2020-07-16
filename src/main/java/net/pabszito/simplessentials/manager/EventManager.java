package net.pabszito.simplessentials.manager;

import me.yushust.inject.Inject;
import net.pabszito.simplessentials.Simplessentials;
import net.pabszito.simplessentials.listeners.PlayerJoinListener;
import net.pabszito.simplessentials.listeners.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventManager {

    @Inject
    private Simplessentials plugin;

    @Inject
    private PlayerJoinListener playerJoinListener;

    @Inject
    private PlayerQuitListener playerQuitListener;

    public void setup(){
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(playerJoinListener, plugin);
        pluginManager.registerEvents(playerQuitListener, plugin);
    }
}
