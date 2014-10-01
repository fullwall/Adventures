package net.citizensnpcs.adventures.race.util;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class Building {
    private final BlockFace facingDir;
    private final Location offset;
    private final BuildingSchematic schematic;

    public Building(Location offset, BlockFace facingDir, BuildingSchematic schematic) {
        this.offset = offset;
        this.facingDir = facingDir;
        this.schematic = schematic;
    }

    public BlockFace getFacing() {
        return facingDir;
    }

    public Location getOffset() {
        return offset;
    }

    public BuildingSchematic getSchematic() {
        return schematic;
    }
}
