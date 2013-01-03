package net.citizensnpcs.adventures.goap.npc;

import java.util.Collection;
import java.util.Random;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.adventures.sensors.ThreatSensor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;

import com.google.inject.Inject;

public class ActionEvade extends AbstractAction {
    private Collection<Entity> currentThreats;
    boolean failed = true;
    @Inject
    private PlannerAgent agent;

    @Override
    public void activate() {
        currentThreats = agent.getSensor(ThreatSensor.class).getThreats();
        Location location = agent.getNPC().getBukkitEntity().getLocation();
        int rootX = location.getBlockX();
        int rootY = location.getBlockY();
        int rootZ = location.getBlockZ();
        int maxX = 10;
        int maxY = 4;
        Random random = new Random();
        double max = Integer.MIN_VALUE;
        Location targetL = null;
        for (int i = 0; i < 10; i++) {
            int newX = (random.nextInt(2 * maxX) - maxX) + rootX;
            int newY = (random.nextInt(2 * maxY) - maxY) + rootY;
            int newZ = (random.nextInt(2 * maxX) - maxX) + rootZ;
            int id = location.getWorld().getBlockTypeIdAt(newX, newY, newZ);
            if (Material.getMaterial(id).isSolid()) {
                Location target = new Location(location.getWorld(), newX, newY, newZ);
                double found = 0;
                for (Entity entity : currentThreats) {
                    found += target.distanceSquared(entity.getLocation());
                }
                if (found > max) {
                    max = found;
                    targetL = target;
                }
            }
        }
        if (targetL != null) {
            agent.getNPC().getNavigator().setTarget(targetL);
            failed = false;
        }
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
    public float getCost() {
        return 5F;
    }

    @Override
    public boolean isComplete() {
        if (failed)
            return true;
        double min = Double.MAX_VALUE;
        for (Entity entity : currentThreats) {
            double distance = agent.getNPC().getBukkitEntity().getLocation()
                    .distanceSquared(entity.getLocation());
            if (min > distance) {
                min = distance;
            }
        }
        return min >= 25;
    }

    @Override
    public void update() {
    }

    private static final WorldState EFFECTS = WorldState.create("hasThreat", false);
    private static final WorldState PRECONDITIONS = WorldState.create("hasThreat", true);
}
