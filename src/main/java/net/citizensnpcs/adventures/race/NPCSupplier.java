package net.citizensnpcs.adventures.race;

import java.util.Collection;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Location;

public interface NPCSupplier {
    Collection<NPC> createTribeMembers(RaceDescriptor race, Location at);
}
