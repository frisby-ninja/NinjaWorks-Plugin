package net.ninjaworks.ninjaworksplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveArrowsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player target = Bukkit.getPlayer(args[0]);
        if(target != null) {
            if (Bukkit.getOnlinePlayers().contains(target)) {
                //Correct
                target.setArrowsInBody(0);
                sender.sendMessage("Removed arrows from " + target + "!");
                return true;

            } else {
                //Player not found
                sender.sendMessage("Either the player is offline or doesn't exist.");
                return false;
            }
        } else {
            //Player argument is null
            sender.sendMessage("Please provide a player name!");
            return false;
        }
    }
}