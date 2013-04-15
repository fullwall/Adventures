package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.SimpleGoalController;
import net.citizensnpcs.api.npc.NPC;

import com.google.common.collect.Lists;

public class Tribe {
    private final GoalController ai = new SimpleGoalController();
    private final List<NPC> members = Lists.newArrayList();
    private final RaceDescriptor race;

    public Tribe(RaceDescriptor race) {
        this.race = race;
    }

    public void addMembers(Collection<NPC> npcs) {
        members.addAll(npcs);
    }

    public Iterable<NPC> getMembers() {
        return members;
    }

    public RaceDescriptor getRace() {
        return race;
    }

    public GoalController getTribeAI() {
        return ai;
    }
}
