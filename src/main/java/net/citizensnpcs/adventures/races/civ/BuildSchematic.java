package net.citizensnpcs.adventures.races.civ;

import java.io.File;
import java.util.Iterator;

import net.citizensnpcs.adventures.race.RaceDescriptor;
import net.citizensnpcs.adventures.race.TribeTrait;
import net.citizensnpcs.adventures.race.util.Blackboard.PropertySubscriber;
import net.citizensnpcs.adventures.race.util.BuildingSchematic;
import net.citizensnpcs.adventures.race.util.BuildingSchematic.BuildingBlock;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.event.CancelReason;
import net.citizensnpcs.api.ai.event.NavigatorCallback;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.astar.pathfinder.MinecraftBlockExaminer;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.util.PlayerAnimation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BuildSchematic implements Behavior, PropertySubscriber<String> {
    private Location baseLocation;
    private Iterator<BuildingBlock> blocks;
    private BuildingSchematic building;
    private BuildingBlock current;
    private boolean executing = false;
    private final NPC npc;
    private final RaceDescriptor race;

    public BuildSchematic(RaceDescriptor race, NPC npc) {
        this.race = race;
        this.npc = npc;
        npc.getTrait(TribeTrait.class).getBlackboard().subscribe("buildschematic.schematic", this);
    }

    @Override
    public void onChanged(String oldState, String newState) {
        if (newState == null)
            return;
        File currentSchematic = new File(race.getRaceFolder(), newState + ".schematic");
        building = BuildingSchematic.load(currentSchematic);
        baseLocation = npc.getEntity().getLocation();
        blocks = building.bottomUpBlocks();
        current = blocks.next();
        executing = true;
    }

    @Override
    public void reset() {
        current = null;
        blocks = null;
        executing = false;
    }

    @Override
    public BehaviorStatus run() {
        if (!npc.isSpawned())
            return BehaviorStatus.FAILURE;
        if (!npc.getNavigator().isNavigating()) {
            if (!blocks.hasNext()) {
                return BehaviorStatus.SUCCESS;
            }
            current = blocks.next();
            while (current.material == Material.AIR) {
                if (current.getType(baseLocation) == Material.AIR) {
                    current = blocks.next();
                }
            }

            Location location = current.getLocation(baseLocation);
            Location target = MinecraftBlockExaminer.findValidLocation(location, 3);
            npc.getNavigator().setTarget(target);
            npc.getNavigator().getLocalParameters().stationaryTicks(50);
            npc.getNavigator().getLocalParameters().addSingleUseCallback(new NavigatorCallback() {
                @Override
                public void onCompletion(CancelReason cancelReason) {
                    current.getBlock(baseLocation).setType(current.material);
                    if (npc.getEntity() instanceof Player) {
                        PlayerAnimation.ARM_SWING.play((Player) npc.getEntity());
                    }
                }
            });
        }
        return BehaviorStatus.RUNNING;
    }

    @Override
    public boolean shouldExecute() {
        return executing;
    }

    public static Behavior createInstance(Context context, DataKey key) {
        return new BuildSchematic(context.race, context.npc);
    }
}
