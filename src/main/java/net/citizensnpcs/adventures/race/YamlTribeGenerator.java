package net.citizensnpcs.adventures.race;

import net.citizensnpcs.api.util.DataKey;

public class YamlTribeGenerator implements TribeGenerator {
    @SuppressWarnings("unused")
    private final RaceRegistry registry;

    public YamlTribeGenerator(RaceRegistry registry, DataKey key) {
        this.registry = registry;
    }
}
