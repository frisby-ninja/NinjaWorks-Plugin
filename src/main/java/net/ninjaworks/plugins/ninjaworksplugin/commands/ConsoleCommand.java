package net.ninjaworks.plugins.ninjaworksplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class ConsoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            String command = String.join(" ", Arrays.asList(args).subList(2, 5).toArray(new String[]{}));

            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            Bukkit.dispatchCommand(console, command);

            // If the player (or console) uses our command correctly, we can return true
            return true;
        }
    else {

        return false;

        }
    }
}
