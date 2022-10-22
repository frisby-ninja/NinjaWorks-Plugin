package net.ninjaworks.ninjaworksplugin.registrations;

import net.ninjaworks.ninjaworksplugin.NinjaWorksPlugin;
import net.ninjaworks.ninjaworksplugin.main.MainExecutor;
import net.ninjaworks.ninjaworksplugin.main.MainListener;
import org.bukkit.Bukkit;

public class Registrations {

    public void register() {

        registerListeners();

    }

    public void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new MainExecutor(), new NinjaWorksPlugin());
        Bukkit.getPluginManager().registerEvents(new MainListener(), new NinjaWorksPlugin());

    }
}