package net.pabszito.simplessentials.commands;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.Simplessentials;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.Arrays;

public class KickCommand implements CommandExecutor {

    @Inject @Named("language")
    private Configuration language;

    @Inject @Named("config")
    private Configuration config;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(language.getString("language.not_a_player"));
            return true;
        }
        Player player = (Player) sender;
        if(!player.hasPermission("simplessentials.kick")){
            player.sendMessage(language.getString("language.no_permissions"));
            return true;
        }

        if(args.length < 1){
            player.sendMessage(language.getString("language.kick.usage"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if(target == null){
            player.sendMessage(language.getString("language.player_not_found"));
            return true;
        }

        if(target.hasPermission("simplessentials.kick.ignore")){
            player.sendMessage(language.getString("language.kick.unable_to_kick"));
            return true;
        }

        String reason = config.getString("config.default_kick_reason");
        if(args.length > 1){
            reason = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        }

        player.kickPlayer(language.getString("language.kick.kicked_screen")
                .replace("%staff%", player.getName())
                .replace("%reason%", reason));
        return true;
    }
}
