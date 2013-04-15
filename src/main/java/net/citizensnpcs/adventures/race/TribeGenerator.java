package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Chunk;

import com.google.common.collect.Lists;

public class TribeGenerator {
    private final List<TribeMemberDecorator> decorators = Lists.newArrayList();
    private final RaceDescriptor race;
    private NPCSupplier supplier;

    private TribeGenerator(RaceDescriptor race) {
        this.race = race;
    }

    public void addDecorator(TribeMemberDecorator decorator) {
        decorators.add(decorator);
    }

    private NPC decorateNPC(Tribe tribe, NPC npc) {
        for (TribeMemberDecorator decorator : decorators) {
            npc = decorator.decorate(tribe, npc);
            if (npc == null) {
                return null;
            }
        }
        return npc;
    }

    public Tribe generateTribe(Chunk at) {
        Tribe tribe = new Tribe(race);
        Collection<NPC> npcs = supplier.createTribe(race, at);
        Iterator<NPC> itr = npcs.iterator();
        while (itr.hasNext()) {
            NPC npc = itr.next();
            npc = decorateNPC(tribe, npc);
            if (npc != null) {
                npcs.add(npc);
            } else
                itr.remove();
        }
        tribe.addMembers(npcs);
        return tribe;
    }

    public void setNPCSupplier(NPCSupplier supplier) {
        this.supplier = supplier;
    }

    public static TribeGenerator create(RaceDescriptor race) {
        return new TribeGenerator(race);
    }
}
