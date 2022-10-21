package net.ninjaworks.plugins.ninjaworksplugin.registrations;

import net.ninjaworks.plugins.ninjaworksplugin.NinjaWorksPlugin;
import net.ninjaworks.plugins.ninjaworksplugin.managers.MainEventManager;
import net.ninjaworks.plugins.ninjaworksplugin.managers.MainListener;
import org.bukkit.Bukkit;

public class Registrations {

    public void register() {

        registerListeners();

    }

    public void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new MainEventManager(), new NinjaWorksPlugin());
        Bukkit.getPluginManager().registerEvents(new MainListener(), new NinjaWorksPlugin());
        new MainEventManager().tick();

    }
}
