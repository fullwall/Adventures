package net.citizensnpcs.adventures.race;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import net.citizensnpcs.adventures.Adventures;
import net.citizensnpcs.adventures.util.BehaviorLoader;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.GoalController;
import net.citizensnpcs.api.ai.GoalController.GoalEntry;
import net.citizensnpcs.api.ai.SimpleGoalController;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.npc.MetadataStore;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.npc.NPCRegistry;
import net.citizensnpcs.api.npc.SimpleMetadataStore;
import net.citizensnpcs.api.util.DataKey;
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

    public void load(DataKey key) {
        NPCRegistry registry = CitizensAPI.getNamedNPCRegistry(Adventures.REGISTRY_NAME);
        for (DataKey root : key.getRelative("npcs").getIntegerSubKeys()) {
            String id = root.getString("id");
            NPC npc = registry.getByUniqueIdGlobal(UUID.fromString(id));
            if (npc == null)
                continue;
            Context context = new Context(this, npc);
            context.redirect = root.getRelative("behavior");
            Behavior behavior = BehaviorLoader.loadBehaviors(context, root.getRelative("behavior"));
            if (behavior != null) {
                npc.getDefaultGoalController().addBehavior(behavior, 1);
            }
            members.add(npc);
        }

        if (key.keyExists("behavior")) {
            DataKey behaviorKey = key.getRelative("behavior");
            Context context = new Context(this);
            context.redirect = behaviorKey;
            Behavior rootGoal = BehaviorLoader.loadBehaviors(context, key);
            if (rootGoal != null) {
                ai.addBehavior(rootGoal, 1);
            }
        }

        metadata.loadFrom(key.getRelative("metadata"));
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

    public void save(DataKey key) {
        int i = 0;
        for (NPC npc : members) {
            key.setString("npcs." + i + ".id", npc.getUniqueId().toString());
            for (GoalEntry entry : npc.getDefaultGoalController()) {
                BehaviorLoader.saveBehaviors(entry.getBehavior(), new Context(this, npc),
                        key.getRelative("npcs." + i + ".behavior"));
            }
            i++;
        }
        metadata.saveTo(key.getRelative("metadata"));
        for (GoalEntry entry : ai) {
            BehaviorLoader.saveBehaviors(entry.getBehavior(), new Context(this), key.getRelative("behavior"));
        }
    }

    private static final Location CACHE_LOCATION = new Location(null, 0, 0, 0);
}
