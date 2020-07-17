package net.pabszito.simplessentials.commands;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphereCommand implements CommandExecutor {

    @Inject
    @Named("language")
    private Configuration language;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(language.getString("language.not_a_player"));
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("simplessentials.tphere")) {
            player.sendMessage(language.getString("language.no_permissions"));
            return true;
        }

        if (args.length < 1) {
            player.sendMessage(language.getString("language.tphere.usage"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage(language.getString("language.player_not_found"));
            return true;
        }

        target.teleport(player);
        player.sendMessage(language.getString("language.tphere.teleported")
                .replace("%player%", target.getName()));
        return true;
    }
}