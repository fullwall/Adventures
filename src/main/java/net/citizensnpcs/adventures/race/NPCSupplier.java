package net.citizensnpcs.adventures.race;

import java.util.Collection;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Location;

public interface NPCSupplier {
    Collection<NPC> createTribe(RaceDescriptor race, Location at);
}
