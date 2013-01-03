package net.citizensnpcs.adventures.goap.npc;

import com.google.inject.AbstractModule;

public class SimplePlannerModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ActionPlanner.class).to(SimpleActionPlanner.class);
    }
}
