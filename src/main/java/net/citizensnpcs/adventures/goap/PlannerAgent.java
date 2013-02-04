package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.api.astar.Agent;
import net.citizensnpcs.api.astar.Plan;

public interface PlannerAgent extends Agent {
    void apply(WorldState changes);

    boolean contains(WorldState state);

    Plan generatePlan(WorldState to);

    Iterable<Action> getAvailableActions();

    float getCostModifierFor(Action action);

    <T extends Sensor> T getSensor(Class<T> clazz);
}
