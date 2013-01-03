package net.citizensnpcs.adventures;

import net.citizensnpcs.api.trait.Trait;

import com.google.inject.Inject;

public class AdventuresTrait extends Trait {
    @Inject
    private AISystem ai;

    public AdventuresTrait() {
        super("adventurestrait");
    }

    @Override
    public void run() {
        ai.run();
    }
}
