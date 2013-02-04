package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;

public interface ActionPlanner {
    Iterable<Action> getAvailableActions();

    float getCostModifierFor(Action action);

    void reset();

    boolean shouldExecute();

    BehaviorStatus update();
}
