package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;

import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.SimpleGoalController;
import net.citizensnpcs.api.npc.MetadataStore;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.SimpleMetadataStore;
import net.citizensnpcs.api.util.prtree.Region3D;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import com.google.common.collect.Lists;

public class Tribe implements Runnable {
    private final GoalController ai = new SimpleGoalController();
    private final List<NPC> members = Lists.newArrayList();
    private final MetadataStore metadata = new SimpleMetadataStore();
    private final RaceDescriptor race;

    public Tribe(RaceDescriptor race) {
        this.race = race;
    }

    public void addMember(NPC npc) {
        members.add(npc);
    }

    public void addMembers(Collection<NPC> npcs) {
        members.addAll(npcs);
    }

    public MetadataStore data() {
        return metadata;
    }

    public void destroy() {
        for (NPC npc : members) {
            npc.destroy();
        }
    }

    public Collection<NPC> getMembers() {
        return members;
    }

    public RaceDescriptor getRace() {
        return race;
    }

    public Region3D<Tribe> getRepresentativeLocation() {
        Vector min = null, max = null;
        for (NPC npc : members) {
            if (!npc.isSpawned())
                continue;
            Location loc = npc.getEntity().getLocation(CACHE_LOCATION);
            if (min == null)
                min = loc.toVector();
            if (max == null)
                max = loc.toVector();
            min.setX(Math.min(min.getX(), loc.getX()));
            min.setY(Math.min(min.getY(), loc.getY()));
            min.setZ(Math.min(min.getZ(), loc.getZ()));
            max.setX(Math.max(max.getX(), loc.getX()));
            max.setY(Math.max(max.getY(), loc.getY()));
            max.setZ(Math.max(max.getZ(), loc.getZ()));
        }
        if (min == null || max == null)
            return null;
        return new Region3D<Tribe>(min, max, this);
    }

    public GoalController getTribeAI() {
        return ai;
    }

    public Tribe merge(Tribe other) {
        addMembers(other.members);
        race.getRegistry().deregisterTribe(other);
        return this;
    }

    @Override
    public void run() {
        ai.run();
    }

    private static final Location CACHE_LOCATION = new Location(null, 0, 0, 0);
}
