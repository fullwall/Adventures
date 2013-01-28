package net.aufdemrand.denizen.scripts.requirements.core;

import net.aufdemrand.denizen.exceptions.RequirementCheckException;
import net.aufdemrand.denizen.scripts.requirements.AbstractRequirement;
import net.aufdemrand.denizen.scripts.requirements.RequirementsContext;

import java.util.List;

public class SunnyRequirement extends AbstractRequirement {

	@Override
	public void onEnable() {
		// nothing to do here
	}


    @Override
    public boolean check(RequirementsContext context, List<String> args) throws RequirementCheckException {
        boolean outcome = false;

		/*
		 * (-)SUNNY
		 */
		
		if (!context.getPlayer().getWorld().hasStorm()) outcome = true;
		
		return outcome;
	}

}
