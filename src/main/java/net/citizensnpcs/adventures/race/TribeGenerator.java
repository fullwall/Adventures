package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Location;

import com.google.common.collect.Lists;

public class TribeGenerator {
    private final List<TribeMemberDecorator> decorators = Lists.newArrayList();
    private RaceDescriptor race;
    private NPCSupplier supplier;

    public void addDecorator(TribeMemberDecorator decorator) {
        decorators.add(decorator);
    }

    private NPC decorateNPC(Tribe tribe, NPC npc) {
        for (TribeMemberDecorator decorator : decorators) {
            decorator.decorate(tribe, npc);
        }
        return npc;
    }

    public Tribe generateTribe(Location at) {
        Tribe tribe = new Tribe(race);
        Collection<NPC> canonical = supplier.createTribeMembers(race, at);
        for (NPC npc : canonical) {
            tribe.addMember(npc);
            decorateNPC(tribe, npc);
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
