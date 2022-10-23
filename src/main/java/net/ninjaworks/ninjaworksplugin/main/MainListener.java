package net.ninjaworks.ninjaworksplugin.main;


import net.ninjaworks.ninjaworksplugin.data.DataManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        new MainExecutor().greetPlayer(event.getPlayer());
        new MainExecutor().makePlayerFly(event.getPlayer());

        if (p.getGameMode() == GameMode.CREATIVE) {
            if (p.getName() == "frisby_ninja") {
                new MainExecutor().playSoundToPlayer(p, Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 1f, 1f);
                new MainExecutor().makePlayerFly(p);
            }
        }

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        Player p = event.getPlayer();

        new MainExecutor().logoutMSG(p);

    }
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {

        Player p = event.getPlayer();

        new MainExecutor().removeArrowsFrom(p);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player p = event.getPlayer();
        Block b = event.getBlockPlaced();
        Location l = b.getLocation();
        boolean isAllowed = new MainExecutor().isBlockPlacementAllowed(p, l);
        if(isAllowed == false) {
            new MainExecutor().removeBlock(l);
        }
    }
}