package net.citizensnpcs.adventures.sensors;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ThreatSensor implements Sensor {
    @Inject
    private PlannerAgent agent;
    private final WorldState state = WorldState.createEmptyState();

    @Override
    public WorldState generateState() {
        List<Entity> filtered = Lists.newArrayList(agent.getSensor(NearbyEntitySensor.class).getByClass(
                Monster.class, Player.class));
        boolean hasThreat = filtered.size() > 0;
        state.put("hasThreat", hasThreat);
        state.put("threats", hasThreat ? filtered : Collections.EMPTY_LIST);
        return state;
    }

    public Collection<Entity> getThreats() {
        Collection<Entity> threats = state.get("threats");
        if (threats == null)
            return Collections.emptyList();
        return threats;
    }

    public boolean hasThreats() {
        return (Boolean) state.get("hasThreat");
    }
}
