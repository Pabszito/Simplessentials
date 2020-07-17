package net.pabszito.simplessentials.commands;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MemoryCommand implements CommandExecutor {

    @Inject @Named("language")
    private Configuration language;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("simplessentials.memory")) {
            sender.sendMessage(language.getString("language.no_permissions"));
            return true;
        }

        sender.sendMessage(language.getString("language.memory.assigned_memory")
                .replace("%memory%", Runtime.getRuntime().totalMemory() / 1024L / 1024L + ""));

        sender.sendMessage(language.getString("language.memory.max_memory")
                .replace("%memory%", Runtime.getRuntime().maxMemory() / 1024L / 1024L + ""));

        sender.sendMessage(language.getString("language.memory.free_memory")
                .replace("%memory%", Runtime.getRuntime().freeMemory() / 1024L / 1024L + ""));

        Bukkit.getWorlds().forEach((world) -> {
            String type;
            World.Environment environment = world.getEnvironment();
            switch(environment){
                case NORMAL:{
                    type = language.getString("language.memory.types.overworld");
                    break;
                }
                case NETHER:{
                    type = language.getString("language.memory.types.nether");
                    break;
                }
                case THE_END:{
                    type = language.getString("language.memory.types.the_end");
                    break;
                }
                default:{
                    type = language.getString("language.memory.types.unknown");
                    break;
                }
            }

            int tileEntities = 0;
            try{
                for(Chunk chunk : world.getLoadedChunks()){
                    tileEntities += chunk.getTileEntities().length;
                }
            }catch(ClassCastException exception){
                Bukkit.getLogger().warning("[Simplessentials] Could not get chunk data at world "+world.getName());
                exception.printStackTrace();
            }

            sender.sendMessage(language.getString("language.memory.world")
                    .replace("%world%", world.getName())
                    .replace("%type%", type)
                    .replace("%loaded_chunks%", world.getLoadedChunks().length + "")
                    .replace("%entities%", world.getEntities().size() + "")
                    .replace("%tile_entities%", tileEntities + ""));

        });

        return true;
    }
}
