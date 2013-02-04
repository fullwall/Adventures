package net.citizensnpcs.adventures.goap;

public abstract class AbstractAction implements Action {
    @Override
    public boolean evaluateContextPreconditions() {
        return true;
    }

    @Override
    public float getCost() {
        return 1F;
    }
}
