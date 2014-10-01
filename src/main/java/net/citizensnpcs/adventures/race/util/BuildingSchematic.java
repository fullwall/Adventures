package net.citizensnpcs.adventures.race.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

public class BuildingSchematic {
    private final CuboidClipboard clipboard;

    public BuildingSchematic(CuboidClipboard clipboard) {
        this.clipboard = clipboard;
    }

    public Iterator<BuildingBlock> bottomUpBlocks() {
        return new Iterator<BuildingBlock>() {
            Vector vector = new Vector(0, 0, 0);
            int x, y, z;

            @Override
            public boolean hasNext() {
                return y < clipboard.getWidth();
            }

            @Override
            public BuildingBlock next() {
                @SuppressWarnings("deprecation")
                BuildingBlock ret = new BuildingBlock(Material.getMaterial(clipboard.getBlock(vector).getId()), x, y, z);
                if (++z >= clipboard.getLength()) {
                    z = 0;
                    if (++x >= clipboard.getHeight()) {
                        x = 0;
                        ++y;
                    }
                }
                vector.setX(x).setY(y).setZ(z);
                return ret;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public int getHeight() {
        return clipboard.getHeight();
    }

    public int getLength() {
        return clipboard.getLength();
    }

    @SuppressWarnings("deprecation")
    public Material getMaterialAt(int x, int y, int z) {
        return Material.getMaterial(clipboard.getBlock(new com.sk89q.worldedit.Vector(x, y, z)).getType());
    }

    public int getWidth() {
        return clipboard.getWidth();
    }

    public static class BuildingBlock {
        public Material material;
        public int x, y, z;

        public BuildingBlock(Material material, int x, int y, int z) {
            this.material = material;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Block getBlock(Location base) {
            return base.getWorld().getBlockAt((int) base.getX() + x, (int) base.getY() + y, (int) base.getZ() + z);
        }

        public Location getLocation(Location base) {
            return new Location(base.getWorld(), base.getX() + x, base.getY() + y, base.getZ() + z);
        }

        public Material getType(Location base) {
            return base.getBlock().getType();
        }

    }

    public static BuildingSchematic load(File file) {
        try {
            CuboidClipboard clipboard = SchematicFormat.MCEDIT.load(file);
            return new BuildingSchematic(clipboard);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
        return null;
    }
}
