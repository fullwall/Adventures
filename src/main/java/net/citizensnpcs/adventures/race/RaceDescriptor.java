package net.citizensnpcs.adventures.race;

import org.bukkit.Location;

public class RaceDescriptor {
    private final TribeGenerator generator;
    private final String name;
    private final RaceRegistry registry;

    private RaceDescriptor(RaceRegistry registry, String name, TribeGenerator generator) {
        this.name = name;
        this.generator = generator;
        this.generator.setRace(this);
        this.registry = registry;
    }

    public Tribe generateAndRegisterTribe(Location at) {
        Tribe tribe = generator == null ? null : generator.generateTribe(at);
        if (tribe == null)
            return null;
        registry.registerTribe(tribe);
        return tribe;
    }

    public TribeGenerator getGenerator() {
        return generator;
    }

    public String getName() {
        return name;
    }

    public RaceRegistry getRegistry() {
        return registry;
    }

    public static class Builder {
        private TribeGenerator generator;
        private final String name;
        private final RaceRegistry registry;

        private Builder(RaceRegistry registry, String name) {
            this.name = name;
            this.registry = registry;
        }

        public RaceDescriptor build() {
            return new RaceDescriptor(registry, name, generator);
        }

        public Builder generator(TribeGenerator gen) {
            this.generator = gen;
            return this;
        }
    }

    public static Builder builder(RaceRegistry registry, String name) {
        return new Builder(registry, name);
    }
}
