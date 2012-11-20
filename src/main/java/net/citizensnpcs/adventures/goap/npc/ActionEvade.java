package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.WorldState;

public class ActionEvade extends AbstractAction {
    @Override
    public void activate() {
    }

    @Override
    public WorldState getEffects() {
        return EFFECTS;
    }

    @Override
    public WorldState getPreconditions() {
        return PRECONDITIONS;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public void update() {
    }

    private static final WorldState PRECONDITIONS = WorldState.create("hasThreat", false);
    private static final WorldState EFFECTS = WorldState.create("hasThreat", true);
}
