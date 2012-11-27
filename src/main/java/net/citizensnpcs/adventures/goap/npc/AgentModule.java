package net.citizensnpcs.adventures.goap.npc;

import net.citizensnpcs.adventures.goap.GoapAgent;
import net.citizensnpcs.adventures.goap.Sensor;
import net.citizensnpcs.api.astar.Agent;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;

public class AgentModule extends AbstractModule {
    private final GoapAgent instance;

    public AgentModule(GoapAgent agent) {
        instance = agent;
    }

    @Override
    protected void configure() {
        bind(Agent.class).toInstance(instance);
        bind(Planner.class).to(NPCPlanner.class);
        SensorProvider sensorProvider = new SensorProvider();
        bind(Sensor.class).toProvider(sensorProvider);
        bindListener(Matchers.any(), sensorProvider);
    }

    private class SensorProvider implements Provider<Sensor>, TypeListener {
        private Class<? extends Sensor> last;

        @Override
        public Sensor get() {
            return instance.getSensor(last);
        }

        @Override
        public <I> void hear(TypeLiteral<I> type, TypeEncounter<I> encounter) {
            if (Sensor.class.isAssignableFrom(type.getRawType()))
                last = type.getRawType().asSubclass(Sensor.class);
        }
    }
}
