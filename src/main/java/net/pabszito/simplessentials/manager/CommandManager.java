package net.pabszito.simplessentials.manager;

import me.yushust.inject.Inject;
import net.pabszito.simplessentials.Simplessentials;
import net.pabszito.simplessentials.commands.*;

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
    private Simplessentials plugin;

    public void setup(){
        plugin.getCommand("invsee").setExecutor(invseeCommand);
        plugin.getCommand("kick").setExecutor(kickCommand);
        plugin.getCommand("workbench").setExecutor(workbenchCommand);
        plugin.getCommand("enderchest").setExecutor(enderchestCommand);
        plugin.getCommand("tphere").setExecutor(tphereCommand);
        plugin.getCommand("memory").setExecutor(memoryCommand);
    }
}
