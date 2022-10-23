package net.ninjaworks.ninjaworksplugin.main;

import net.ninjaworks.ninjaworksplugin.data.DataManager;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
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


        public String getBlockTypeAt(Location l) {
                Block b = l.getBlock();
                if (b.isEmpty() == true) {
                        //Empty
                        return "Empty";
                } else if(b.isLiquid() == true) {
                        //Liquid
                        return "Liquid";
                } else {
                        //Solid
                        return "Solid";
                }
        }

        public boolean canSafelyRemoveBlockAt(String blockType, Location l) {
                if(blockType == "Empty") {
                        //Block is already empty
                        return false;
                } else if (l.getBlockY() == -256) {
                        //It's at the floor
                                if (!(l.getWorld().getEnvironment() == World.Environment.THE_END)) {
                                        //It's not in the end
                                        return false;
                                } else {
                                        //It's in the end
                                       return true;
                                }
                        } else if (l.getBlockY() == 256) {
                        if (l.getWorld().getEnvironment() == World.Environment.NETHER) {
                                //It's in the nether and it's the roof
                                return false;
                        } else {
                                //It's ok to remove it
                                return true;
                        }
                } else {
                        //It's ok to remove it
                        return true;
                }

        }

        public boolean isIllegalBlockPlacementAllowed(Player p, Location l) {
                String admins = new DataManager().getAdmins();
                boolean isPlayerAdmin = admins.contains(p.getName());
                if (isPlayerAdmin == false) {
                        //Player is not an admin

                        String blockType = new MainExecutor().getBlockTypeAt(l);

                        if (blockType == "Solid") {

                                boolean isIllegalBlock = new DataManager().isIllegalBlock(l.getBlock().getType());

                                if (isIllegalBlock == true) {
                                        //It's illegal
                                        return false;
                                } else {
                                        //It's not illegal
                                        return true;
                                }

                        } else {
                                //Block isn't solid (weird, but just in case)
                                return true;
                        }
                } else {
                        //Player is an admin
                        return true;
                }
        }

        public void removeBlock(Location l) {
                Block b = l.getBlock();
                if(b.isEmpty() == false) {
                        b.breakNaturally();
                }
        }

        public void logoutMSG(Player p){
            Bukkit.broadcastMessage(ChatColor.YELLOW + "[Debug logout message, please remove]");
        }



}
