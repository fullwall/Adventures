package net.citizensnpcs.adventures.goap;

import net.citizensnpcs.adventures.astar.Plan;

public class AStarGoapPlan implements Plan {
    private final WorldState end;
    private Action executing;
    private int index = -1;
    private final Action[] plan;

    public AStarGoapPlan(WorldState end, Action[] plan) {
        this.plan = plan;
        this.end = end;
        advancePlan();
    }

    private void advancePlan() {
        if (++index >= plan.length) {
            executing = null;
            return;
        }
        executing = plan[index];
        executing.activate();
    }

    @Override
    public WorldState getWorldStateChanges() {
        return end;
    }

    @Override
    public boolean isComplete() {
        return index >= plan.length;
    }

    @Override
    public void update() {
        if (executing == null)
            return;
        executing.update();
        if (executing.isComplete())
            advancePlan();
    }
}