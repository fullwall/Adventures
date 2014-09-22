package net.citizensnpcs.adventures.race;

import net.citizensnpcs.adventures.race.util.Blackboard;
import net.citizensnpcs.api.trait.Trait;

public class TribeTrait extends Trait {
    private final Blackboard blackboard = new Blackboard();
    private Tribe tribe;

    public TribeTrait() {
        super("tribetrait");
    }

    public TribeTrait(Tribe tribe) {
        this();
        this.tribe = tribe;
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public void setTribe(Tribe tribe) {
        this.tribe = tribe;
    }
}
