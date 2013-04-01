package net.citizensnpcs.adventures.race;

import java.util.List;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.SimpleGoalController;
import net.citizensnpcs.api.npc.NPC;

import com.google.common.collect.Lists;

public class SimpleTribe implements Tribe {
    private final GoalController ai = new SimpleGoalController();
    private final List<NPC> members = Lists.newArrayList();
    private final RaceDescriptor race;

    public SimpleTribe(RaceDescriptor race, Iterable<NPC> initial) {
        this.race = race;
        for (NPC npc : initial)
            members.add(npc);
    }

    @Override
    public Iterable<NPC> getMembers() {
        return members;
    }

    @Override
    public RaceDescriptor getRace() {
        return race;
    }

    @Override
    public GoalController getTribeAI() {
        return ai;
    }
}
