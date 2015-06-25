package net.citizensnpcs.adventures.util;

import org.bukkit.Material;

public interface MaterialHolder {
    /**
     * Adds the specified number of materials to the holder, returning the amount that was rejected.
     *
     * @param material
     * @param count
     * @return The amount of material rejected, in the range (0, count)
     */
    public int addMaterial(Material material, int count);
}
