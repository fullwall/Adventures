package net.citizensnpcs.adventures.race;

import java.io.File;

import org.bukkit.Location;

public class RaceDescriptor {
    private final File folder;
    private final TribeGenerator generator;
    private final String name;
    private final RaceRegistry registry;

    private RaceDescriptor(RaceRegistry registry, String name, TribeGenerator generator, File folder) {
        this.name = name;
        this.generator = generator;
        this.generator.setRace(this);
        this.registry = registry;
        this.folder = folder;
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

    public File getRaceFolder() {
        return folder;
    }

    public RaceRegistry getRegistry() {
        return registry;
    }

    public static class Builder {
        private File folder;
        private TribeGenerator generator;
        private final String name;
        private final RaceRegistry registry;

        private Builder(RaceRegistry registry, String name) {
            this.name = name;
            this.registry = registry;
        }

        public RaceDescriptor build() {
            return new RaceDescriptor(registry, name, generator, folder);
        }

        public Builder folder(File folder) {
            this.folder = folder;
            return this;
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
