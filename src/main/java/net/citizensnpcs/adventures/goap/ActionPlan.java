package net.citizensnpcs.adventures.goap;

import java.util.Arrays;

import net.citizensnpcs.api.astar.Agent;
import net.citizensnpcs.api.astar.Plan;

public class ActionPlan implements Plan, Comparable<Plan> {
    private final float cost;
    private final WorldState end;
    private Action executing;
    private int index = -1;
    private final Action[] plan;

    ActionPlan(WorldState end, Action[] plan, float cost) {
        this.plan = plan;
        this.end = end;
        this.cost = cost;
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
    public int compareTo(Plan o) {
        return (int) (this.cost - ((ActionPlan) o).cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        ActionPlan other = (ActionPlan) obj;
        return Float.floatToIntBits(cost) == Float.floatToIntBits(other.cost)
                && Arrays.equals(plan, other.plan);
    }

    public WorldState getWorldStateChanges() {
        return end;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime * (prime + Float.floatToIntBits(cost)) + Arrays.hashCode(plan);
    }

    @Override
    public boolean isComplete() {
        return index >= plan.length;
    }

    @Override
    public void update(Agent agent) {
        if (executing == null)
            return;
        executing.update();
        if (executing.isComplete())
            advancePlan();
    }
}