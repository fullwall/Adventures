package net.citizensnpcs.adventures.goap.npc;

import java.util.Collections;
import java.util.List;

import net.citizensnpcs.adventures.goap.Agent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.Entity;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class NearbyEntitySensor implements Sensor {
    private List<Entity> nearby = Collections.emptyList();
    private Agent agent;

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

    public Iterable<Entity> filtered(Predicate<Entity> predicate) {
        return Iterables.filter(nearby, predicate);
    }

    public Iterable<Entity> all() {
        return nearby;
    }
}
