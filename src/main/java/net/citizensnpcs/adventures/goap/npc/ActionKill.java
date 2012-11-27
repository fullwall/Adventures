package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.AbstractAction;
import net.citizensnpcs.adventures.goap.GoapAgent;
import net.citizensnpcs.adventures.goap.WorldState;

import org.bukkit.entity.LivingEntity;

import com.google.inject.Inject;

public class ActionKill extends AbstractAction {
    private LivingEntity target;
    @Inject
    private GoapAgent agent;
    private ThreatSensor sensor;
    private static final WorldState PRECONDITIONS = WorldState.createImmutable("hasThreat", false,
            "hasWeapon", true);
    private static final WorldState EFFECTS = WorldState.createImmutable("hasThreat", true);

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
}
