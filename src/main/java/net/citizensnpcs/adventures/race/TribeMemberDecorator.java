package net.citizensnpcs.adventures.race;

import net.citizensnpcs.api.npc.NPC;

public interface TribeMemberDecorator {
    NPC decorate(Tribe tribe, NPC npc);
}
