package net.citizensnpcs.adventures.races.test;

import java.io.File;

import org.bukkit.Location;
import org.bukkit.block.Block;

import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.adventures.race.util.BuildingPlan;
import net.citizensnpcs.adventures.race.util.BuildingSchematic;
import net.citizensnpcs.adventures.race.util.CityComponent;
import net.citizensnpcs.adventures.race.util.SharedBuildingPlanComponent;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.DataKey;

public class CreateTribeHome implements Behavior {
    private final BuildingSchematic firstBuilding;
    private final Tribe tribe;

    public CreateTribeHome(Tribe tribe, BuildingSchematic first) {
        this.tribe = tribe;
        this.firstBuilding = first;
    }

    private Location pickCenterLocation() {
        NPC first = tribe.getMembers().iterator().next();
        Block origin = first.getStoredLocation().getBlock();

        int min = Integer.MAX_VALUE;
        Location buildLocation = null;
        for (int dx = -20; dx < 20; dx++) {
            for (int dz = -2; dz < 20; dz++) {
                if (dz == 0 && dx == 0)
                    continue;
                int centerY = origin.getWorld().getHighestBlockYAt(origin.getX() + dx, origin.getZ() + dz);
                int heightDifferenceSum = 0;
                for (int i = 0; i <= firstBuilding.getWidth(); i++) {
                    for (int k = 0; k <= firstBuilding.getLength(); k++) {
                        heightDifferenceSum += Math.abs(centerY
                                - origin.getWorld().getHighestBlockYAt(origin.getX() + dx + i, origin.getZ() + dz + k));
                    }
                }
                if (min > heightDifferenceSum) {
                    min = heightDifferenceSum;
                    buildLocation = origin.getRelative(dx, 0, dz).getLocation();
                }
            }
        }
        return buildLocation;
    }

    @Override
    public void reset() {
    }

    @Override
    public BehaviorStatus run() {
        if (tribe.getDefaultedComponent(CityComponent.class).getBuildings("town-center").size() > 0)
            return BehaviorStatus.SUCCESS;
        return BehaviorStatus.RUNNING;
    }

    @Override
    public boolean shouldExecute() {
        boolean shouldExecute = tribe.getDefaultedComponent(CityComponent.class).getBuildings("town-center")
                .size() == 0;
        if (shouldExecute) {
            Location location = pickCenterLocation();
            tribe.getDefaultedComponent(SharedBuildingPlanComponent.class)
                    .addBuildingPlan(new BuildingPlan(firstBuilding, location));
        }
        return shouldExecute;
    }

    public static Behavior createInstance(Context context, DataKey key) {
        return new CreateTribeHome(context.tribe,
                BuildingSchematic.load(new File(context.race.getRaceFolder(), key.getString("town-center"))));
    }
}
