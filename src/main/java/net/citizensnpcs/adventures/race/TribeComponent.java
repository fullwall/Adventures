package net.citizensnpcs.adventures.race;

import net.citizensnpcs.api.util.DataKey;

public abstract class TribeComponent {
    public abstract String getName();

    public abstract void load(DataKey key);

    public abstract void save(DataKey key);
}
