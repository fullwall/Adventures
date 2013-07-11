package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.astar.pathfinder.MinecraftBlockExaminer;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.Persist;
import net.citizensnpcs.api.persistence.PersistenceLoader;
import net.citizensnpcs.api.util.Storage;

import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;

import com.google.common.collect.Lists;

public class FlatfileNPCSupplier implements NPCSupplier {
    private final int maxNPCs;
    private final NPCParameters parameters;
    private Random random;

    public FlatfileNPCSupplier(Storage storage) {
        this.parameters = PersistenceLoader.load(NPCParameters.class, storage.getKey(""));
        this.maxNPCs = storage.getKey("").getInt("tribe.max-size");
    }

    @Override
    public Collection<NPC> createTribe(RaceDescriptor race, Chunk in) {
        Location spawnLocation = findSpawnLocation(in);
        List<NPC> npcs = Lists.newArrayListWithCapacity(maxNPCs);
        for (int i = 0; i < maxNPCs; i++) {
            String name = parameters.names.get(random.nextInt(parameters.names.size()));
            EntityType type = parameters.types.get(random.nextInt(parameters.types.size()));
            NPC npc = CitizensAPI.getNPCRegistry().createNPC(type, name);
            npc.spawn(spawnLocation);
            npcs.add(CitizensAPI.getNPCRegistry().createNPC(type, name));
        }
        return npcs;
    }

    private Location findSpawnLocation(Chunk in) {
        ChunkSnapshot snap = in.getChunkSnapshot(true, false, false);
        for (int x = 0; x < 128; x++) {
            for (int z = 0; z < 128; z++) {
                int y = snap.getHighestBlockYAt(x, z);
                Block block = in.getBlock(x, y, z);
                boolean standable = MinecraftBlockExaminer.canStandOn(block);
                while (!standable && block.getY() >= 0) {
                    while (block.getY() > 0 && !block.getType().isSolid()) {
                        block = block.getRelative(BlockFace.DOWN);
                    }
                    standable = MinecraftBlockExaminer.canStandOn(block);
                }
                if (standable) {
                    return block.getLocation();
                }
            }
        }
        return in.getWorld().getSpawnLocation();
    }

    private static class NPCParameters {
        @Persist(value = "members.names", required = true)
        private List<String> names;

        @Persist(value = "members.types", required = true)
        private List<EntityType> types;
    }
}
