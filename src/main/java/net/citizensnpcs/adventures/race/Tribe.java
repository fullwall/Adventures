package net.citizensnpcs.adventures.race;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.npc.NPC;

public interface Tribe {
    Iterable<NPC> getMembers();

    RaceDescriptor getRace();

    GoalController getTribeAI();
}
