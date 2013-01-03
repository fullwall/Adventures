package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.Action;

public interface ActionPlanner {
    Iterable<Action> getAvailableActions();

    float getCostModifierFor(Action action);

    void update();
}
