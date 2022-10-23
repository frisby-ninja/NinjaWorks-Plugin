package net.ninjaworks.ninjaworksplugin.commands;

import net.ninjaworks.ninjaworksplugin.data.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args[0] == "add") {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                //Correct
                try {
                    new DataManager().addAdmin(target);
                } catch (Exception e) {
                    sender.sendMessage("Couldn't add " + target + " to the admin list.");
                    return false;
                }
                sender.sendMessage("Made " + target + " an admin.");
                return true;
            } else {
                //Player argument is null
                sender.sendMessage("Please provide a player name!");
                return false;
            }

        } else if (args[0] == "remove") {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                //Correct
                try {
                    new DataManager().removeAdmin(target);
                } catch (Exception e) {
                    sender.sendMessage("Couldn't remove " + target + " from the admin list.");
                    return false;
                }
                sender.sendMessage("Removed " + target + " from the admin list.");
                return true;
            } else {
                //Player argument is null
                sender.sendMessage("Please provide a player name!");
                return false;
            }

        } else if (args[0] == "list") {
            String admins = new DataManager().getAdmins();
            sender.sendMessage("Admins are: " + admins);
            return true;
        } else {
            sender.sendMessage("Please provide a valid argument, here are all of them: /admin add [player], /admin remove [player], or /admin list");
            return false;
        }
    }
}
