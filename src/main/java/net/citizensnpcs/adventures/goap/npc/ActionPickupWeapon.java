package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.WorldState;

public class ActionPickupWeapon extends AbstractAction {
    @Override
    public void activate() {
    }

    @Override
    public boolean evaluateContextPreconditions() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public float getCost() {
        // TODO Auto-generated method stub
        return 0;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub

    }

    private static final WorldState PRECONDITIONS = WorldState.create("hasWeapon", false);
    private static final WorldState EFFECTS = WorldState.create("hasWeapon", true);
}
