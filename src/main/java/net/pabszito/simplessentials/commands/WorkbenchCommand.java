package net.pabszito.simplessentials.commands;

import me.yushust.inject.Inject;
import me.yushust.inject.name.Named;
import net.pabszito.simplessentials.utils.Configuration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCommand implements CommandExecutor {

    @Inject
    @Named("language")
    private Configuration language;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(language.getString("language.not_a_player"));
            return false;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("simplessentials.workbench")) {
            player.sendMessage(language.getString("language.no_permissions"));
            return true;
        }

        player.openWorkbench(player.getLocation(), true);
        return true;
    }
}
