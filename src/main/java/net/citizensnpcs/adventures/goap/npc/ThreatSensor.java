package net.citizensnpcs.adventures.goap.npc;

import java.util.Collection;

import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ThreatSensor implements Sensor {
    @Inject
    private PlannerAgent agent;
    private final WorldState state = WorldState.createEmptyState();

    @Override
    public WorldState generateState() {
        NearbyEntitySensor sensor = agent.getSensor(NearbyEntitySensor.class);
        Iterable<Entity> filtered = sensor.getByClass(Monster.class, Player.class);
        boolean hasThreat = Iterables.size(filtered) > 0;
        state.put("hasThreat", hasThreat);
        if (hasThreat)
            state.put("threats", filtered);
        else
            state.put("threats", EMPTY);
        return state;
    }

    public Collection<Entity> getThreats() {
        Collection<Entity> threats = state.get("threats");
        if (threats == null)
            return EMPTY;
        return threats;
    }

    public boolean hasThreats() {
        return state.get("hasThreat");
    }

    private static final Collection<Entity> EMPTY = Lists.newArrayList();
}
