package net.ninjaworks.ninjaworksplugin.data;

import org.bukkit.Material;
import org.bukkit.block.Block;

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

    public String getAdmins() {
        return "frisby_ninja, KingofGlandon";
    }
}