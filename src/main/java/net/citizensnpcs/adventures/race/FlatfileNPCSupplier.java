package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import net.citizensnpcs.adventures.Adventures;
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
    private final NPCParameters parameters;
    private final Random random = new Random();

    public FlatfileNPCSupplier(Storage storage) {
        this.parameters = PersistenceLoader.load(NPCParameters.class, storage.getKey(""));
    }

    @Override
    public Collection<NPC> createTribeMembers(RaceDescriptor race, Location in) {
        Location spawnLocation = findSpawnLocation(in);
        List<NPC> npcs = Lists.newArrayListWithCapacity(parameters.maxNPCs);
        for (int i = 0; i < parameters.maxNPCs; i++) {
            String name = parameters.names.get(random.nextInt(parameters.names.size()));
            EntityType type = parameters.types.get(random.nextInt(parameters.types.size()));
            NPC npc = CitizensAPI.getNamedNPCRegistry(Adventures.REGISTRY_NAME).createNPC(type, name);
            npc.data().setPersistent(NPC.DEFAULT_PROTECTED_METADATA, !parameters.defaultVulnerable);
            npc.spawn(spawnLocation);
            npcs.add(npc);
        }
        return npcs;
    }

    private Location findSpawnLocation(Location in) {
        Block found = findStandableBlock(in.getBlock());
        if (found != null)
            return found.getLocation().add(0, 1, 0);
        Chunk chunk = in.getChunk();
        ChunkSnapshot snap = chunk.getChunkSnapshot(true, false, false);
        // TODO: better randomisation of spawn positions
        for (int x = 0; x < 128; x++) {
            for (int z = 0; z < 128; z++) {
                int y = snap.getHighestBlockYAt(x, z);
                Block block = chunk.getBlock(x, y, z);
                boolean standable = MinecraftBlockExaminer.canStandOn(block);
                while (!standable && block.getY() >= 0) {
                    while (block.getY() > 0 && !block.getType().isSolid()) {
                        block = block.getRelative(BlockFace.DOWN);
                    }
                    standable = MinecraftBlockExaminer.canStandOn(block);
                }
                if (standable) {
                    return block.getLocation().add(0, 1, 0);
                }
            }
        }
        return in.getWorld().getSpawnLocation();
    }

    private Block findStandableBlock(Block block) {
        boolean standable = MinecraftBlockExaminer.canStandOn(block);
        while (!standable && block.getY() >= 0) {
            while (block.getY() > 0 && !block.getType().isSolid()) {
                block = block.getRelative(BlockFace.DOWN);
            }
            standable = MinecraftBlockExaminer.canStandOn(block);
        }
        return standable ? block : null;
    }

    public static class NPCParameters {
        @Persist(value = "members.vulnerable", required = true)
        public boolean defaultVulnerable = true;
        @Persist(value = "tribe.max-size", required = true)
        public int maxNPCs = 10;
        @Persist(value = "members.names", required = true)
        public List<String> names;
        @Persist(value = "members.types", required = true)
        public List<EntityType> types;
    }
}
