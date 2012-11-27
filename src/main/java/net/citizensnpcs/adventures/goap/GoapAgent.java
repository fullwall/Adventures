package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.api.astar.Agent;
import net.citizensnpcs.api.astar.Plan;
import net.citizensnpcs.api.npc.NPC;

public interface GoapAgent extends Agent {
    NPC getNPC();

    void apply(WorldState changes);

    Plan generatePlan(WorldState to);

    Iterable<Action> getAvailableActions();

    float getCostModifierFor(Action action);

    boolean contains(WorldState state);

    <T extends Sensor> T getSensor(Class<T> clazz);
}
