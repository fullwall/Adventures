package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;

import org.bukkit.Location;

import com.google.common.collect.Lists;

import net.citizensnpcs.api.npc.NPC;

public class TribeGenerator {
    private final List<TribeDecorator> decorators = Lists.newArrayList();
    private RaceDescriptor race;
    private NPCSupplier supplier;

    public void addDecorator(TribeDecorator decorator) {
        decorators.add(decorator);
    }

    public Tribe generateTribe(Location at) {
        Tribe tribe = new Tribe(race);
        Collection<NPC> canonical = supplier.createTribeMembers(race, at);
        for (NPC npc : canonical) {
            tribe.addMember(npc);
        }
        for (TribeDecorator decorator : decorators) {
            decorator.decorate(tribe);
        }
        return tribe;
    }

    public void setNPCSupplier(NPCSupplier supplier) {
        this.supplier = supplier;
    }

    public void setRace(RaceDescriptor race) {
        this.race = race;
    }
}
