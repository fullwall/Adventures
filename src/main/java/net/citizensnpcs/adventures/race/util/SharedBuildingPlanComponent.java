package net.citizensnpcs.adventures.race.util;

import java.util.ArrayList;
import java.util.List;

import net.citizensnpcs.adventures.race.TribeComponent;
import net.citizensnpcs.api.util.DataKey;

public class SharedBuildingPlanComponent extends TribeComponent {
    private final List<BuildingPlan> inProgressPlans = new ArrayList<BuildingPlan>();

    public void addBuildingPlan(BuildingPlan plan) {
        inProgressPlans.add(plan);
    }

    @Override
    public String getName() {
        return "shared-building-plans";
    }

    @Override
    public void load(DataKey key) {
        for (DataKey subKey : key.getRelative("inprogress").getSubKeys()) {
            inProgressPlans.add(BuildingPlan.load(subKey));
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < inProgressPlans.size(); i++) {
            if (inProgressPlans.get(i).isComplete()) {
                inProgressPlans.remove(i--);
            }
        }
    }

    @Override
    public void save(DataKey key) {
        for (int i = 0; i < inProgressPlans.size(); i++) {
            inProgressPlans.get(i).save(key.getRelative("inprogress").getRelative(i));
        }
    }
}
