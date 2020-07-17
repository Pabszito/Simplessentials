package net.pabszito.simplessentials.commands;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {

    @Inject @Named("language")
    private Configuration language;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!sender.hasPermission("simplessentials.broadcast")){
            sender.sendMessage(language.getString("language.no_permissions"));
            return true;
        }

        if(args.length < 1){
            sender.sendMessage(language.getString("language.broadcast.usage"));
            return true;
        }

        String text = ChatColor.translateAlternateColorCodes('&', String.join(" ", args));
        Bukkit.broadcastMessage(language.getString("language.broadcast.format").replace("%text%", text));
        return false;
    }
}
