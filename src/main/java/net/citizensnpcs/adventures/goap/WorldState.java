package net.citizensnpcs.adventures.goap;

import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class WorldState implements Cloneable {
    private final Map<String, Object> state;

    private WorldState() {
        state = Maps.newHashMap();
    }

    private WorldState(Map<String, Object> newState) {
        state = newState;
    }

    public WorldState apply(WorldState effects) {
        if (effects == EMPTY || effects.state.isEmpty())
            return this;
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

    public boolean contains(WorldState o) {
        return difference(o) == 0;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorldState other = (WorldState) obj;
        if (state == null) {
            if (other.state != null) {
                return false;
            }
        } else if (!state.equals(other.state)) {
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String string) {
        return (T) state.get(string);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    public void put(String key, Object value) {
        state.put(key, value);
    }

    @Override
    public String toString() {
        return state.toString();
    }

    private static WorldState create(Object[] objects) {
        return create(objects, false);
    }

    private static WorldState create(Object[] objects, boolean immutable) {
        Map<String, Object> map = Maps.newHashMap();
        for (int i = 0; i < objects.length; i += 2) {
            map.put((String) objects[i], objects[i + 1]);
        }
        if (immutable)
            map = ImmutableMap.copyOf(map);
        return new WorldState(map);
    }

    public static WorldState create(String firstKey, Object firstValue) {
        return create(new Object[] { firstKey, firstValue });
    }

    public static WorldState create(String firstKey, Object firstValue, String secondKey, Object secondValue) {
        return create(new Object[] { firstKey, firstValue, secondKey, secondValue });
    }

    public static WorldState createEmptyState() {
        return new WorldState();
    }

    public static WorldState createImmutable(String firstKey, Object firstValue) {
        return create(new Object[] { firstKey, firstValue }, true);
    }

    public static WorldState createImmutable(String firstKey, Object firstValue, String secondKey, Object secondValue) {
        return create(new Object[] { firstKey, firstValue, secondKey, secondValue }, true);
    }

    public static final WorldState EMPTY = WorldState.createEmptyState();
}
