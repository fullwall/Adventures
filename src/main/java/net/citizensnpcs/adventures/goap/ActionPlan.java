package net.citizensnpcs.adventures.goap;

import java.util.Arrays;

import net.citizensnpcs.api.astar.Agent;
import net.citizensnpcs.api.astar.Plan;

public class ActionPlan implements Plan, Comparable<Plan> {
    private final float cost;
    private final WorldState end;
    private Action executing;
    int hashcode = -1;
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
        if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
            return false;
        if (plan.length != other.plan.length)
            return false;
        for (int i = 0; i < plan.length; i++) {
            if (plan[i].getClass() != other.plan[i].getClass())
                return false;
        }
        return true;
    }

    public WorldState getWorldStateChanges() {
        return end;
    }

    @Override
    public int hashCode() {
        if (hashcode != -1)
            return hashcode;
        final int prime = 31;
        return (hashcode = prime * (prime + Float.floatToIntBits(cost)) + Arrays.hashCode(plan));
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