package net.citizensnpcs.adventures.race;

import java.util.Collection;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Chunk;

public interface NPCSupplier {
    Collection<NPC> createTribe(RaceDescriptor race, Chunk in);
}
