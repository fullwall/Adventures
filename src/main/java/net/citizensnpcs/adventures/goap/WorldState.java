package net.citizensnpcs.adventures.goap;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

public class WorldState implements Cloneable {
    private final Map<String, Object> state;

    public WorldState() {
        state = Maps.newHashMap();
    }

    private WorldState(Map<String, Object> newState) {
        state = newState;
    }

    public WorldState apply(WorldState effects) {
        Map<String, Object> newState = Maps.newHashMap(effects.state);
        for (Entry<String, Object> entry : state.entrySet()) {
            if (!newState.containsKey(entry.getKey()))
                newState.put(entry.getKey(), entry.getValue());
        }
        return new WorldState(newState);
    }

    @Override
    public WorldState clone() {
        try {
            return (WorldState) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int difference(WorldState goal) {
        int differences = 0;
        for (Entry<String, Object> entry : goal.state.entrySet()) {
            Object value = state.get(entry.getKey());
            if (value == null) {
                continue;
            }
            if (!value.equals(entry.getValue())) {
                differences++;
                continue;
            }
        }
        return differences;
    }

    public void put(String key, Object value) {
        state.put(key, value);
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
