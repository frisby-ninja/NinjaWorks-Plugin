package net.ninjaworks.plugins.ninjaworksplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class NinjaWorksPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("[Debug] Ninja_Works plugin started!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        System.out.println("[Debug] Ninja_Works plugin has stopped!");
    }
}
