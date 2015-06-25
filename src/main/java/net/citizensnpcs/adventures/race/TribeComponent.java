package net.citizensnpcs.adventures.race;

import net.citizensnpcs.api.util.DataKey;

public abstract class TribeComponent {
    private Tribe tribe;

    public abstract String getName();

    protected Tribe getTribe() {
        return tribe;
    }

    public abstract void load(DataKey key);

    public void run() {
    }

    public abstract void save(DataKey key);

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }
}
