package net.citizensnpcs.adventures.goap.npc;

import java.util.Collections;
import java.util.List;

import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.Entity;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class NearbyEntitySensor implements Sensor {
    @Inject
    private PlannerAgent agent;
    private List<Entity> nearby = Collections.emptyList();

    public Iterable<Entity> all() {
        return nearby;
    }

    public Iterable<Entity> filtered(Predicate<Entity> predicate) {
        return Iterables.filter(nearby, predicate);
    }

    @Override
    public WorldState generateState() {
        nearby = agent.getNPC().getBukkitEntity().getNearbyEntities(10, 10, 10);
        return WorldState.EMPTY;
    }

    public Iterable<Entity> getByClass(final Class<?>... classes) {
        return Iterables.filter(nearby, new Predicate<Entity>() {
            @Override
            public boolean apply(Entity entity) {
                for (Class<?> clazz : classes) {
                    if (clazz.isAssignableFrom(entity.getClass()))
                        return true;
                }
                return false;
            }
        });
    }
}
