package net.ninjaworks.plugins.ninjaworksplugin.managers;


import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MainListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        new MainEventManager().greetPlayer(event.getPlayer());
        new MainEventManager().makePlayerFly(event.getPlayer());

        if (p.getGameMode() == GameMode.CREATIVE) {
            if (p.getName() == "frisby_ninja") {
                new MainEventManager().makePlayerFly(p);
            }
        }

    }

}