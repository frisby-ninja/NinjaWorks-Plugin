package net.ninjaworks.ninjaworksplugin.main;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class MainExecutor implements Listener {

        public void removeArrowsFrom(Player p)
        {
            p.setArrowsInBody(0);
        }

        public void greetPlayer(Player p) {
        Bukkit.broadcastMessage(ChatColor.AQUA + "Welcome, " + p + "!");
        }

        public void playSoundToPlayer(Player p, Sound sound, float volume, float pitch) {
        p.playSound(p, sound, volume, pitch);
        }

        public void makePlayerFly(Player p) {
        p.setAllowFlight(true);
        p.setFlying(true);
        }

        public void logoutMSG(Player p){
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Debug logout message, please remove");
        }



}
