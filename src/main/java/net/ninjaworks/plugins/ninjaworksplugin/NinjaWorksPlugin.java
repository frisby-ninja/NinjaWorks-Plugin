package net.ninjaworks.plugins.ninjaworksplugin;

import net.ninjaworks.plugins.ninjaworksplugin.commands.ConsoleCommand;
import net.ninjaworks.plugins.ninjaworksplugin.registrations.Registrations;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class NinjaWorksPlugin extends JavaPlugin{

    @Override
    public void onEnable() {

        Bukkit.getLogger().info(ChatColor.DARK_GREEN + "Ninja_Works plugin started!");

        new Registrations().register();
        registerCommands();

    }

    public void registerCommands() {
        this.getCommand("console").setExecutor(new ConsoleCommand());

    }

    @Override
    public void onDisable() {

        Bukkit.getLogger().info(ChatColor.DARK_RED + "NinjaWorks plugin stopped!");
    }
}