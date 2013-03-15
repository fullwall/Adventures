package net.citizensnpcs.adventures.race;

public class RaceDescriptor {
    private final String name;

    private RaceDescriptor(String name) {
        this.name = name;
    }

    public static class Builder {
        private final String name;

        private Builder(String name) {
            this.name = name;
        }

        public RaceDescriptor build() {
            return new RaceDescriptor(name);
        }
    }

    public static Builder builder(String name) {
        return new Builder(name);
    }

    public String getName() {
        return name;
    }
}
