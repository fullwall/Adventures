package net.citizensnpcs.adventures.commands;

import org.bukkit.Location;

public class TaggedRegion {
    private final Location max;
    private final Location min;
    private final String name;

    public TaggedRegion(String name, Location min, Location max) {
        this.name = name;
        this.min = min;
        this.max = max;
    }

    public Location getMax() {
        return max;
    }

    public Location getMin() {
        return min;
    }

    public String getName() {
        return name;
    }
}