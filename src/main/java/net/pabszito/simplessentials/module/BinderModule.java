package net.pabszito.simplessentials.module;

import lombok.RequiredArgsConstructor;
import me.yushust.inject.bind.AbstractModule;
import net.pabszito.simplessentials.Simplessentials;
import net.pabszito.simplessentials.utils.Configuration;

@RequiredArgsConstructor
public class BinderModule extends AbstractModule {

    private final Simplessentials plugin;

    @Override
    protected void configure() {
        bind(Simplessentials.class).toInstance(plugin);
        bind(Configuration.class).named("config").toInstance(new Configuration(plugin, "config"));
        bind(Configuration.class).named("language").toInstance(new Configuration(plugin, "language"));
    }
}
