package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.LivingEntity;

import com.google.inject.Inject;

public class ActionKill extends AbstractAction {
    @Inject
    private PlannerAgent agent;
    private ThreatSensor sensor;
    private LivingEntity target;
    @Override
    public void activate() {
        target = (LivingEntity) sensor.getThreats().iterator().next();
        agent.getNPC().getNavigator().setTarget(target, true);
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
        return target == null || !sensor.hasThreats() || !agent.getNPC().getNavigator().isNavigating()
                || target.isDead();
    }

    @Override
    public void update() {
    }

    private static final WorldState EFFECTS = WorldState.createImmutable("hasThreat", true);

    private static final WorldState PRECONDITIONS = WorldState.createImmutable("hasThreat", false,
            "hasWeapon", true);
}
