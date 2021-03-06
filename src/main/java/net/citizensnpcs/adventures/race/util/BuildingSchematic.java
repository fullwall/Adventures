package net.citizensnpcs.adventures.race.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.EnumMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.SchematicFormat;

import net.citizensnpcs.adventures.commands.TaggedRegion;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.NBTStorage;
import net.citizensnpcs.api.util.Storage;

public class BuildingSchematic {
    private final CuboidClipboard clipboard;
    private final File file;
    private final String name;
    private final Multimap<String, TaggedRegion> tags;

    public BuildingSchematic(String name, CuboidClipboard clipboard, Collection<TaggedRegion> tags) {
        this(name, clipboard, tags, null);
    }

    public BuildingSchematic(String name, CuboidClipboard clipboard, Collection<TaggedRegion> tags, File file) {
        this.clipboard = clipboard;
        this.tags = makeTags(tags);
        this.name = name;
        this.file = file;
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
                BuildingBlock ret = new BuildingBlock(Material.getMaterial(clipboard.getBlock(vector).getId()), x, y,
                        z);
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

    public File getFile() {
        return file;
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

    public String getName() {
        return name;
    }

    public Multiset<Material> getRequiredMaterials() {
        EnumMultiset<Material> set = EnumMultiset.create(Material.class);
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                for (int z = 0; z < getLength(); z++) {
                    Material mat = getMaterialAt(x, y, z);
                    if (mat != Material.AIR) {
                        set.add(mat);
                    }
                }
            }
        }
        return set;
    }

    public Collection<TaggedRegion> getTaggedRegion(String name) {
        return tags.get(name);
    }

    public int getWidth() {
        return clipboard.getWidth();
    }

    private Multimap<String, TaggedRegion> makeTags(Collection<TaggedRegion> tags) {
        Multimap<String, TaggedRegion> ret = ArrayListMultimap.create();
        for (TaggedRegion r : tags) {
            ret.put(r.getName(), r);
        }
        return ret;
    }

    public void save(File file) {
        try {
            SchematicFormat.MCEDIT.save(clipboard, file);
            NBTStorage storage = new NBTStorage(file, "Schematic");
            storage.load();
            saveRegions(storage.getKey("TaggedRegions"), tags);
            storage.save();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
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
            return new BuildingSchematic(file.getName(), clipboard, loadRegions(file), file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DataException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Location loadLocation(DataKey key) {
        return new Location(null, key.getDouble("x"), key.getDouble("y"), key.getDouble("z"));
    }

    private static Collection<TaggedRegion> loadRegions(File file) {
        Collection<TaggedRegion> ret = Lists.newArrayList();
        Storage storage = new NBTStorage(file, "Schematic");
        storage.load();
        for (DataKey sub : storage.getKey("TaggedRegions").getSubKeys()) {
            String name = sub.name();
            for (DataKey sub2 : sub.getIntegerSubKeys()) {
                Location min = loadLocation(sub2.getRelative("min"));
                Location max = loadLocation(sub2.getRelative("max"));
                ret.add(new TaggedRegion(name, min, max));
            }
        }
        return ret;
    }

    private static void saveLocation(DataKey key, Location location) {
        key.setDouble("x", location.getX());
        key.setDouble("y", location.getY());
        key.setDouble("z", location.getZ());
    }

    private static void saveRegion(DataKey key, TaggedRegion value) {
        saveLocation(key.getRelative("min"), value.getMin());
        saveLocation(key.getRelative("max"), value.getMax());
    }

    private static void saveRegions(DataKey key, Multimap<String, TaggedRegion> tags) {
        for (Entry<String, TaggedRegion> entry : tags.entries()) {
            DataKey sub = key.getRelative(entry.getKey());
            int length = sub.getInt("length", 0) + 1;
            sub.setInt("length", length);
            saveRegion(sub.getRelative(length), entry.getValue());
        }
    }
}
