package net.ninjaworks.ninjaworksplugin.data;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;

public class DataManager {
    public boolean isIllegalBlock(Material m) {
        String illegalMaterials = getIllegalMaterials();

        if (illegalMaterials.contains(m.toString()) == true) {
            return true;
        } else {
            return false;
        }
    }
    public String getIllegalMaterials() {
        return "BEDROCK, COMMAND_BLOCK, BARRIER, STRUCTURE_BLOCK, STRUCTURE_VOID, PETRIFIED_OAK_SLAB";
    }
    String admins = "frisby_ninja, KingofGlandon";
    public void addAdmin(Player newAdmin) throws Exception {
        String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        new DataReaderAndWriter().write(path, "admins.txt", newAdmin.getName());

    }
    public String getAdmins() {
        String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        return new DataReaderAndWriter().read(path, "admins.txt");
    }

    public void removeAdmin(Player p) throws Exception {
        String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
        new DataReaderAndWriter().remove(path, "admins.txt", p.getName());
    }
}