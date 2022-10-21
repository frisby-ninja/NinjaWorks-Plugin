package net.ninjaworks.plugins.ninjaworksplugin.managers;

import net.ninjaworks.plugins.ninjaworksplugin.NinjaWorksPlugin;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainEventManager implements Listener {

    public void tick() {
        Bukkit.getScheduler().runTaskTimer(new NinjaWorksPlugin(), new Runnable() {
            @Override
            public void run() {
                MainRunning();
            }
        }, 0, 100);
    }

        public void MainRunning()
        {
    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        p.setArrowsInBody(0);
        }
        }

    public void greetPlayer(Player p) {
        Bukkit.broadcastMessage(ChatColor.AQUA + "Welcome, " + p + "!");
    }

    public void makePlayerFly(Player p) {
        p.playSound(p, Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE, 1f, 1f);
        p.setAllowFlight(true);
        p.setFlying(true);
    }

        public void debugLogoutMSG(){
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Debug logout message, please remove");
        }

}
