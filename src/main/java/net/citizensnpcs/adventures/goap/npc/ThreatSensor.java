package net.citizensnpcs.adventures.goap.npc;

import java.util.Collection;
import java.util.Collections;

import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;

import com.google.common.collect.Iterables;

public class ThreatSensor implements Sensor {
    private final NPCAgent agent;
    private final WorldState state = WorldState.createEmptyState();

    public ThreatSensor(NPCAgent agent) {
        this.agent = agent;
    }

    @Override
    public WorldState generateState() {
        Iterable<Entity> filtered = agent.getSensor(NearbyEntitySensor.class).getByClass(Monster.class,
                Player.class);
        boolean hasThreat = Iterables.size(filtered) > 0;
        state.put("hasThreat", hasThreat);
        if (hasThreat)
            state.put("threats", filtered);
        else
            state.put("threats", Collections.EMPTY_LIST);
        return state;
    }

    public boolean hasThreats() {
        return state.get("hasThreat");
    }

    @SuppressWarnings("unchecked")
    public Collection<Entity> getThreats() {
        Collection<Entity> threats = state.get("threats");
        return (Collection<Entity>) (threats == null ? Collections.emptyList() : threats);
    }
}
