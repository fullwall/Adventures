package net.citizensnpcs.adventures.races.test;

import java.util.Collection;

import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.adventures.util.BehaviorLoader.Context;
import net.citizensnpcs.api.ai.EntityTarget;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Messaging;

import org.bukkit.entity.Entity;

public class AttackOtherTribe implements Behavior {
    private final Context context;
    private Tribe enemyTribe;
    private Collection<NPC> enemyTribeMembers;
    private Collection<NPC> members;
    private boolean won;

    private AttackOtherTribe(Context context) {
        this.context = context;
    }

    private boolean isThreat(NPC enemy) {
        return enemy.isSpawned() && enemy.getBukkitEntity().getHealth() > 5;
    }

    @Override
    public void reset() {
        if (this.won) {
            context.tribe.merge(this.enemyTribe);
            this.won = false;
            Messaging.log('w');
        }
        context.tribe.data().set("executing", false);
    }

    @Override
    public BehaviorStatus run() {
        int friendlyCount = 0;
        int enemyThreatCount = -1;
        for (NPC member : this.members) {
            if (!member.isSpawned())
                continue;
            friendlyCount++;
            if (member.getNavigator().isNavigating()) {
                EntityTarget target = member.getNavigator().getEntityTarget();
                if (target != null && target.getTarget().getHealth() <= 5) {
                    member.getNavigator().cancelNavigation();
                } else {
                    continue;
                }
            }
            for (NPC enemy : this.enemyTribeMembers) {
                if (!this.isThreat(enemy))
                    continue;
                member.getNavigator().setTarget((Entity) enemy.getBukkitEntity(), true);
                break;
            }
        }
        if (friendlyCount == 0)
            return BehaviorStatus.FAILURE;
        enemyThreatCount = 0;
        for (NPC enemy : this.enemyTribeMembers) {
            if (this.isThreat(enemy)) {
                enemyThreatCount++;
            }
        }
        if (enemyThreatCount == 0) {
            this.won = true;
            return BehaviorStatus.SUCCESS;
        }
        return BehaviorStatus.RUNNING;
    }

    @Override
    public boolean shouldExecute() {
        Collection<Tribe> otherTribes = context.registry.getTribesByRace(context.race, context.tribe);
        if (otherTribes.size() > 0) {
            this.enemyTribe = otherTribes.iterator().next();
            this.enemyTribeMembers = this.enemyTribe.getMembers();
            this.members = context.tribe.getMembers();
            for (NPC member : this.members) {
                member.getDefaultGoalController().cancelCurrentExecution();
            }
            context.tribe.data().set("executing", true);
            return true;
        }
        return false;
    }

    public static AttackOtherTribe createInstance(Context context, DataKey key) {
        return new AttackOtherTribe(context);
    }
}
