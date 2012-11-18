package net.citizensnpcs.adventures.astar;

import net.citizensnpcs.adventures.goap.WorldState;

public interface Plan {

    WorldState getWorldStateChanges();

    boolean isComplete();

    void update();

}
