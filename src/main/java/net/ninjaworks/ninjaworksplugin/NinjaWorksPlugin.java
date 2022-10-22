package net.ninjaworks.ninjaworksplugin;

import net.ninjaworks.ninjaworksplugin.commands.RemoveArrowsCommand;
import net.ninjaworks.ninjaworksplugin.registrations.Registrations;
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
        this.getCommand("removearrows").setExecutor(new RemoveArrowsCommand());
    }

    @Override
    public void onDisable() {

        Bukkit.getLogger().info(ChatColor.DARK_RED + "NinjaWorks plugin stopped!");
    }
}