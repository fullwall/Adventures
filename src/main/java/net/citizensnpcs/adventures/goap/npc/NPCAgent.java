package net.citizensnpcs.adventures.goap.npc;

import java.util.Map;

import net.citizensnpcs.adventures.goap.AStarGoapGoal;
import net.citizensnpcs.adventures.goap.AStarGoapNode;
import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.Agent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.api.astar.AStarGoal;
import net.citizensnpcs.api.astar.AStarMachine;
import net.citizensnpcs.api.astar.AStarNode;
import net.citizensnpcs.api.astar.Plan;
import net.citizensnpcs.api.trait.Trait;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class NPCAgent extends Trait implements Agent {

    private final AStarMachine machine = AStarMachine.createWithDefaultStorage();
    @Inject
    private Planner planner;
    private final Injector injector;
    private final Map<Class<? extends Sensor>, Sensor> sensors = Maps.newHashMap();
    private final WorldState worldState = WorldState.createEmptyState();

    public NPCAgent() {
        super("npcagent");
        injector = Guice.createInjector(new AgentModule(this));
        injector.injectMembers(this);
    }

    @Override
    public void apply(WorldState changes) {
        worldState.apply(changes);
    }

    @Override
    public Plan generatePlan(WorldState to) {
        AStarNode root = AStarGoapNode.create(this, worldState);
        AStarGoal goal = AStarGoapGoal.createWithGoalState(to);
        return machine.run(goal, root);
    }

    @Override
    public Iterable<Action> getAvailableActions() {
        return planner.getAvailableActions();
    }

    @Override
    public float getCostModifierFor(Action action) {
        return planner.getCostModifierFor(action);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Sensor> T getSensor(Class<T> clazz) {
        return (T) sensors.get(clazz);
    }

    @Override
    public void run() {
        updateSensors();
        planner.update();
    }

    private void updateSensors() {
        for (Sensor sensor : sensors.values())
            worldState.apply(sensor.generateState());
    }

    @Override
    public boolean contains(WorldState state) {
        return worldState.contains(state);
    }

    public <T> T getState(String string) {
        return worldState.get(string);
    }
}
