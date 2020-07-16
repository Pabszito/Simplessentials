package net.pabszito.simplessentials;

import me.yushust.inject.Inject;
import me.yushust.inject.Injector;
import me.yushust.inject.InjectorFactory;
import net.pabszito.simplessentials.manager.EventManager;
import net.pabszito.simplessentials.module.BinderModule;
import org.bukkit.plugin.java.JavaPlugin;

public class Simplessentials extends JavaPlugin {

    @Inject
    private EventManager eventManager;

    @Override
    public void onEnable() {
        setupInjector();
        setupListeners();

        getLogger().info("Simplessentials version " + getDescription().getVersion() + " has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Simplessentials has been disabled.");
    }

    private void setupInjector(){
        Injector injector = InjectorFactory.create(new BinderModule(this));
        injector.injectMembers(this);
    }

    private void setupListeners(){
        eventManager.setup();
    }
}
