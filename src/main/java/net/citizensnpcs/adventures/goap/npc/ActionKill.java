package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.adventures.sensors.ThreatSensor;

import org.bukkit.entity.LivingEntity;

import com.google.inject.Inject;

public class ActionKill extends AbstractAction {
    @Inject
    private PlannerAgent agent;
    private LivingEntity target;

    @Override
    public void activate() {
        target = (LivingEntity) agent.getSensor(ThreatSensor.class).getThreats().iterator().next();
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
        return target == null || !agent.getSensor(ThreatSensor.class).hasThreats()
                || !agent.getNPC().getNavigator().isNavigating() || target.isDead();
    }

    @Override
    public void update() {
        agent.getNPC().getNavigator().setTarget(target, true);
    }

    private static final WorldState EFFECTS = WorldState.createImmutable("hasThreat", false);
    private static final WorldState PRECONDITIONS = WorldState.createImmutable("hasThreat", true,
            "hasWeapon", true);
}
