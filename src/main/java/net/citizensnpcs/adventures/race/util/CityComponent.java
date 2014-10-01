package net.citizensnpcs.adventures.race.util;

import java.util.Collection;

import net.citizensnpcs.adventures.race.TribeComponent;
import net.citizensnpcs.api.util.DataKey;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class CityComponent extends TribeComponent {
    private final Multimap<String, Building> buildings = ArrayListMultimap.create();

    public Collection<Building> getBuildings(String group) {
        return buildings.get(group);
    }

    @Override
    public String getName() {
        return "city";
    }

    @Override
    public void load(DataKey key) {
    }

    @Override
    public void save(DataKey key) {
    }
}
