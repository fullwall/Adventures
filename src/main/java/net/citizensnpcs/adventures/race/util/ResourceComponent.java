package net.citizensnpcs.adventures.race.util;

import java.util.EnumMap;
import java.util.Map;

import net.citizensnpcs.adventures.race.TribeComponent;
import net.citizensnpcs.api.util.DataKey;

import org.bukkit.Material;

public class ResourceComponent extends TribeComponent {
    private final Map<Material, Integer> resources = new EnumMap<Material, Integer>(Material.class);

    public void addResource(Material material, int amount) {
        resources.put(material, resources.get(material) + amount);
    }

    @Override
    public String getName() {
        return "resources";
    }

    public int getResource(Material material) {
        return resources.get(material);
    }

    @Override
    public void load(DataKey key) {
    }

    @Override
    public void save(DataKey key) {
    }

    public void withdraw(Material material, int amount) {
        resources.put(material, resources.get(material) - amount);
    }
}
