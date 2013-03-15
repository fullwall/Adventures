package net.citizensnpcs.adventures.race;

import java.util.Map;

import com.google.common.collect.Maps;

public class RaceRegistry {
    private final Map<String, RaceDescriptor> races = Maps.newHashMap();

    public void register(RaceDescriptor desc) {
        races.put(desc.getName(), desc);
    }
}
