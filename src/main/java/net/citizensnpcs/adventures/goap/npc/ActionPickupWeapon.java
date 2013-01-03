package net.citizensnpcs.adventures.goap.npc;

import javax.annotation.Nullable;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.adventures.sensors.NearbyEntitySensor;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class ActionPickupWeapon extends AbstractAction {
    @Inject
    private PlannerAgent agent;
    private Item target;

    @Override
    public void activate() {
    }

    @Override
    public boolean evaluateContextPreconditions() {
        Lists.newArrayList(agent.getSensor(NearbyEntitySensor.class).filtered(new Predicate<Entity>() {
            @Override
            public boolean apply(@Nullable Entity input) {
                if (!(input instanceof Item))
                    return false;
                Item item = (Item) input;
                if (item.isValid() && item.getItemStack().getType() == Material.DIAMOND_SWORD) {
                    ActionPickupWeapon.this.target = item;
                    return true;
                }
                return false;
            }
        }));
        return target != null;
    }

    @Override
    public WorldState getEffects() {
        return EFFECTS;
    }

    @Override
    public WorldState getPreconditions() {
        return PRECONDITIONS;
    }

    @Override
    public boolean isComplete() {
        return target.isDead()
                || ((Player) agent.getNPC().getBukkitEntity()).getInventory()
                        .contains(Material.DIAMOND_SWORD);
    }

    @Override
    public void update() {
        if (!agent.getNPC().getNavigator().isNavigating())
            agent.getNPC().getNavigator().setTarget(target.getLocation());
        if (target.getLocation().distanceSquared(agent.getNPC().getBukkitEntity().getLocation()) < 4) {
            ((Player) agent.getNPC().getBukkitEntity()).getInventory().setItemInHand(target.getItemStack());
            target.remove();
        }
    }

    private static final WorldState EFFECTS = WorldState.create("hasWeapon", true);
    private static final WorldState PRECONDITIONS = WorldState.create("hasWeapon", false);
}
