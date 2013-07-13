package net.citizensnpcs.adventures.race;

public class RaceDescriptor {
    private final TribeGenerator generator;
    private final String name;

    private RaceDescriptor(String name, TribeGenerator generator) {
        this.name = name;
        this.generator = generator;
        this.generator.setRace(this);
    }

    public TribeGenerator getGenerator() {
        return generator;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private TribeGenerator generator;
        private final String name;

        private Builder(String name) {
            this.name = name;
        }

        public RaceDescriptor build() {
            return new RaceDescriptor(name, generator);
        }

        public Builder generator(TribeGenerator gen) {
            this.generator = gen;
            return this;
        }
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }
}
