package net.citizensnpcs.adventures.races.test;

import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.adventures.race.util.CityComponent;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.util.DataKey;

public class CreateTribeHome implements Behavior {
    private final Tribe tribe;

    public CreateTribeHome(Tribe tribe) {
        this.tribe = tribe;
    }

    @Override
    public void reset() {
    }

    @Override
    public BehaviorStatus run() {
        // pick town center location
        // gather materials
        // build and assign leader
        // add city component
        return BehaviorStatus.RUNNING;
    }

    @Override
    public boolean shouldExecute() {
        return !tribe.hasComponent(CityComponent.class);
    }

    public static Behavior createInstance(Context context, DataKey key) {
        return new CreateTribeHome(context.tribe);
    }
}
