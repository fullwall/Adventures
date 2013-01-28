package net.aufdemrand.denizen.scripts.requirements.core;

import net.aufdemrand.denizen.exceptions.RequirementCheckException;
import net.aufdemrand.denizen.scripts.requirements.AbstractRequirement;
import net.aufdemrand.denizen.scripts.requirements.RequirementsContext;
import net.aufdemrand.denizen.utilities.arguments.aH;
import net.aufdemrand.denizen.utilities.arguments.aH.ArgumentType;
import net.aufdemrand.denizen.utilities.debugging.dB;

import java.util.List;

public class EnchantedRequirement extends AbstractRequirement{

	private enum CheckType { ITEMINHAND }

    @Override
	public boolean check(RequirementsContext context, List<String> args) throws RequirementCheckException {
		
		boolean outcome = false;
		CheckType checkType = null;

//	    HOW DO YOU WANT TO HANDLE NO ARGS IN REQUIREMENTS?
//		if (arguments == null)
//			throw new RequirementMissingException("Must provide arguments!");

		/* Get arguments */

		for (String thisArg : args) {

			if (aH.matchesValueArg("ITEMINHAND", thisArg, ArgumentType.Custom)) {
				checkType = CheckType.ITEMINHAND;
				dB.echoDebug("...will check item in hand");
			}

			else dB.echoError("Could not match argument '%s'!", thisArg);
		}

		if (checkType != null) {
			switch (checkType) {

			case ITEMINHAND:
				if (!context.getPlayer().getItemInHand().getEnchantments().isEmpty()) outcome = true;
				break;

			}
		}

		if (outcome == true) dB.echoDebug("...item is enchanted.");
		else dB.echoDebug("...item is not enchanted!");

		return outcome;
	}
}
