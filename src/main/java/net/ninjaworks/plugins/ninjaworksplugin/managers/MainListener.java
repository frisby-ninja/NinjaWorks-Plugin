package net.ninjaworks.plugins.ninjaworksplugin.managers;

import net.ninjaworks.plugins.ninjaworksplugin.NinjaWorksPlugin;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    public void tick() {
        Bukkit.getScheduler().runTaskTimer(new NinjaWorksPlugin(), new Runnable() {
            @Override
            public void run() {
                MainListening();
            }
        }, 0, 100);
    }

        public void MainListening()
        {
    for (Player p : Bukkit.getServer().getOnlinePlayers()) {
        p.setArrowsInBody(0);
        }
        }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Bukkit.broadcastMessage(ChatColor.AQUA + "Welcome, " + event.getPlayer().getName() + "!");

        Player p = event.getPlayer();
        Location l = p.getLocation();
        Bukkit.broadcastMessage(ChatColor.AQUA + "Welcome, " + event.getPlayer().getName() + "!");

        if (p.getGameMode() == GameMode.CREATIVE) {
            if (p.getName() == "frisby_ninja") {
                p.playSound(p, Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE, 1f, 1f);
                p.setFlySpeed(50);
            }
        }
    }

        @EventHandler
        public void onPlayerLeave(PlayerQuitEvent event){
            Bukkit.broadcastMessage(ChatColor.YELLOW + "Debug logout message, please remove");
        }

}
