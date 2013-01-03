package net.citizensnpcs.adventures.goap.npc;

import java.util.Map;

import net.citizensnpcs.adventures.AISystem;
import net.citizensnpcs.adventures.goap.Action;
import net.citizensnpcs.adventures.goap.PlannerAgent;
import net.citizensnpcs.adventures.goap.PlannerGoal;
import net.citizensnpcs.adventures.goap.PlannerNode;
import net.citizensnpcs.adventures.goap.WorldState;
import net.citizensnpcs.adventures.sensors.EquipmentSensor;
import net.citizensnpcs.adventures.sensors.NearbyEntitySensor;
import net.citizensnpcs.adventures.sensors.Sensor;
import net.citizensnpcs.adventures.sensors.ThreatSensor;
import net.citizensnpcs.api.astar.AStarGoal;
import net.citizensnpcs.api.astar.AStarMachine;
import net.citizensnpcs.api.astar.Plan;
import net.citizensnpcs.api.trait.Trait;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GoapAISystem extends Trait implements PlannerAgent, AISystem {
    private final Injector injector;
    private final AStarMachine<PlannerNode, Plan> machine = AStarMachine.createWithDefaultStorage();
    @Inject
    private ActionPlanner planner;
    private final Map<Class<? extends Sensor>, Sensor> sensors = Maps.newHashMap();
    private WorldState worldState = WorldState.createEmptyState();

    public GoapAISystem() {
        super("g");
        injector = Guice.createInjector(new AgentModule(this));
        injector.injectMembers(this);
        sensors.put(EquipmentSensor.class, injector.getInstance(EquipmentSensor.class));
        sensors.put(ThreatSensor.class, injector.getInstance(ThreatSensor.class));
        sensors.put(NearbyEntitySensor.class, injector.getInstance(NearbyEntitySensor.class));
    }

    @Override
    public void apply(WorldState changes) {
        worldState.apply(changes);
    }

    @Override
    public boolean contains(WorldState state) {
        return worldState.contains(state);
    }

    @Override
    public Plan generatePlan(WorldState to) {
        PlannerNode root = PlannerNode.create(this, worldState);
        AStarGoal<PlannerNode> goal = PlannerGoal.createWithGoalState(to);
        return machine.runFully(goal, root);
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

    public <T> T getState(String string) {
        return worldState.get(string);
    }

    @Override
    public void run() {
        updateSensors();
        planner.update();
    }

    private void updateSensors() {
        for (Sensor sensor : sensors.values())
            worldState = worldState.apply(sensor.generateState());
    }
}
