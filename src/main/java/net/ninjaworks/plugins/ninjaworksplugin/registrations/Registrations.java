package net.ninjaworks.plugins.ninjaworksplugin.registrations;

import net.ninjaworks.plugins.ninjaworksplugin.NinjaWorksPlugin;
import net.ninjaworks.plugins.ninjaworksplugin.commands.ConsoleCommand;
import net.ninjaworks.plugins.ninjaworksplugin.managers.MainListener;
import net.ninjaworks.plugins.ninjaworksplugin.managers.SecondaryListener;
import org.bukkit.Bukkit;

public class Registrations {

    public void register() {

        registerListeners();

    }

    public void registerListeners() {

        Bukkit.getPluginManager().registerEvents(new MainListener(), new NinjaWorksPlugin());
        Bukkit.getPluginManager().registerEvents(new SecondaryListener(), new NinjaWorksPlugin());
        new MainListener().MainListening();

    }
}
