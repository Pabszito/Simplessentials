package net.pabszito.simplessentials.manager;

import me.yushust.inject.Inject;
import net.pabszito.simplessentials.Simplessentials;
import net.pabszito.simplessentials.commands.EnderchestCommand;
import net.pabszito.simplessentials.commands.InvseeCommand;
import net.pabszito.simplessentials.commands.KickCommand;
import net.pabszito.simplessentials.commands.WorkbenchCommand;
import net.pabszito.simplessentials.commands.TphereCommand;
import net.pabszito.simplessentials.commands.MemoryCommand;
import net.pabszito.simplessentials.commands.BroadcastCommand;

public class CommandManager {

    @Inject
    private InvseeCommand invseeCommand;

    @Inject
    private KickCommand kickCommand;

    @Inject
    private WorkbenchCommand workbenchCommand;

    @Inject
    private EnderchestCommand enderchestCommand;

    @Inject
    private TphereCommand tphereCommand;

    @Inject
    private MemoryCommand memoryCommand;
    
    @Inject
    private BroadcastCommand broadcastCommand;

    @Inject
    private Simplessentials plugin;

    public void setup() {
        plugin.getCommand("invsee").setExecutor(invseeCommand);
        plugin.getCommand("kick").setExecutor(kickCommand);
        plugin.getCommand("workbench").setExecutor(workbenchCommand);
        plugin.getCommand("enderchest").setExecutor(enderchestCommand);
        plugin.getCommand("tphere").setExecutor(tphereCommand);
        plugin.getCommand("memory").setExecutor(memoryCommand);
        plugin.getCommand("broadcast").setExecutor(broadcastCommand);
    }
}
