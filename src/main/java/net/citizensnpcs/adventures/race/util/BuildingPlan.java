package net.citizensnpcs.adventures.race.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;

import net.citizensnpcs.adventures.race.util.BuildingSchematic.BuildingBlock;
import net.citizensnpcs.adventures.util.MaterialHolder;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.npc.BlockBreaker;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.LocationPersister;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.util.DataKey;

public class BuildingPlan implements MaterialHolder {
    private Iterator<BuildingBlock> blockIterator;
    private final List<Behavior> inProgress = new ArrayList<Behavior>();
    private Multiset<Material> inventory;
    @Persist(value = "origin")
    private final Location origin;
    private final BuildingSchematic schematic;

    public BuildingPlan(BuildingSchematic schematic, Location location) {
        this.schematic = schematic;
        this.origin = location;
    }

    @Override
    public int addMaterial(Material mat, int count) {
        Multiset<Material> required = schematic.getRequiredMaterials();
        int remaining = required.count(mat) - (inventory.count(mat) + count);
        if (remaining < 0) {
            inventory.add(mat, count - Math.abs(remaining));
            return Math.abs(remaining);
        }
        inventory.add(mat, count);
        return 0;
    }

    private Location getFirstClearingLocation() {
        for (int y = schematic.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < schematic.getWidth(); x++) {
                for (int z = 0; z < schematic.getLength(); z++) {
                    if (origin.clone().add(x, y, z).getBlock().getType() != schematic.getMaterialAt(x, y, z)) {
                        return origin.clone().add(x, y, z);
                    }
                }
            }
        }
        return null;
    }

    private Multiset<Material> getMissingMaterials() {
        Multiset<Material> required = schematic.getRequiredMaterials();
        return Multisets.difference(required, inventory);
    }

    public Behavior getNextBuildingTask(NPC npc) {
        Multiset<Material> required = getMissingMaterials();
        if (required.size() != 0) {
            return new GatherMaterialTask(this, required.iterator().next(), npc);
        }
        if (blockIterator == null) {
            Location toClear = getFirstClearingLocation();
            if (toClear != null) {
                return new ClearBlockLocationTask(npc, toClear);
            } else {
                blockIterator = schematic.bottomUpBlocks();
            }
        }
        while (blockIterator.hasNext()) {
            BuildingBlock block = blockIterator.next();
            Location offset = origin.clone().add(block.x, block.y, block.z);
            if (offset.getBlock().getType() == block.material)
                continue;
            Behavior task = new PlaceMaterialTask(npc, block.material, offset);
            inProgress.add(task);
            return task;
        }
        return null;
    }

    public boolean isComplete() {
        for (int x = 0; x < schematic.getWidth(); x++) {
            for (int z = 0; z < schematic.getLength(); z++) {
                for (int y = 0; y < schematic.getHeight(); y++) {
                    if (schematic.getMaterialAt(x, y, z) != origin.clone().add(x, y, z).getBlock().getType()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void save(DataKey key) {
        key.removeKey("inventory");
        DataKey inventoryKey = key.getRelative("inventory");
        for (Material type : inventory.elementSet()) {
            inventoryKey.setInt(type.name(), inventory.count(type));
        }

        key.setString("schematic", schematic.getFile().getAbsolutePath());
    }

    private static class ClearBlockLocationTask implements Behavior {
        private BlockBreaker blockBreaker;
        private final Location location;
        private final NPC npc;

        public ClearBlockLocationTask(NPC npc, Location location) {
            this.location = location;
            this.npc = npc;
        }

        @Override
        public void reset() {
            if (blockBreaker != null) {
                blockBreaker.reset();
            }
        }

        @Override
        public BehaviorStatus run() {
            if (npc.getStoredLocation().distanceSquared(location) > 3 * 3) {
                if (!npc.getNavigator().isNavigating()) {
                    npc.getNavigator().setTarget(location);
                }
                return BehaviorStatus.RUNNING;
            }
            if (blockBreaker == null) {
                blockBreaker = npc.getBlockBreaker(location.getBlock(), BlockBreaker.EMPTY_CONFIG);
            }
            return blockBreaker.run();
        }

        @Override
        public boolean shouldExecute() {
            return location.getBlock().getType() != Material.AIR && npc.isSpawned();
        }
    }

    private static class PlaceMaterialTask implements Behavior {
        private final Location location;
        private final Material material;
        private final NPC npc;

        public PlaceMaterialTask(NPC npc, Material material, Location location) {
            this.npc = npc;
            this.material = material;
            this.location = location;
        }

        @Override
        public void reset() {
        }

        @Override
        public BehaviorStatus run() {
            if (npc.getStoredLocation().distanceSquared(location) < 3 * 3) {
                if (!npc.getNavigator().isNavigating()) {
                    npc.getNavigator().setTarget(location);
                }
                return BehaviorStatus.RUNNING;
            }
            location.getBlock().setType(material);
            return BehaviorStatus.SUCCESS;
        }

        @Override
        public boolean shouldExecute() {
            return npc.isSpawned();
        }
    }

    public static BuildingPlan load(DataKey subKey) {
        BuildingSchematic schematic = BuildingSchematic.load(new File(subKey.getString("schematic")));
        Location origin = new LocationPersister().create(subKey.getRelative("origin"));
        BuildingPlan plan = new BuildingPlan(schematic, origin);
        for (DataKey sub : subKey.getRelative("inventory").getSubKeys()) {
            plan.inventory.add(Material.valueOf(sub.name()), sub.getInt(""));
        }
        return plan;
    }
}
