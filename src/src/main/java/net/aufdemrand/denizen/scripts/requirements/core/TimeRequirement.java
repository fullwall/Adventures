package net.aufdemrand.denizen.scripts.requirements.core;

import net.aufdemrand.denizen.exceptions.RequirementCheckException;
import net.aufdemrand.denizen.scripts.requirements.AbstractRequirement;
import net.aufdemrand.denizen.scripts.requirements.RequirementsContext;
import net.aufdemrand.denizen.utilities.arguments.aH;

import java.util.List;

public class TimeRequirement extends AbstractRequirement{
	
	private enum TIME {DAWN, DAY, DUSK, NIGHT }
	
	@Override
	public void onEnable() {
		//nothing to do here
	}

    @Override
    public boolean check(RequirementsContext context, List<String> args) throws RequirementCheckException {
		
		boolean outcome = false;
		TIME time = null;
		
		for (String arg : args){
			if (aH.matchesArg("DAWN, DAY, DUSK, NIGHT", arg)) time = TIME.valueOf(arg);
		}
		
		long worldTime = context.getNPC().getBukkitEntity().getWorld().getTime();
		
		if (time.equals(TIME.DAY) && worldTime >= 0 && worldTime < 12000)
			outcome = true;
		else if (time.equals(TIME.DUSK) && worldTime >= 12000 && worldTime < 23800)
			outcome = true;
		else if (time.equals(TIME.NIGHT) && worldTime >= 23800 && worldTime < 22200)
			outcome = true;
		else if (time.equals(TIME.DAWN) && worldTime >= 22200 && worldTime < 24000)
			outcome = true;
		
		return outcome;
		
	}

}
