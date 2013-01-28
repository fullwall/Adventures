package net.aufdemrand.denizen.scripts.commands.core;

import net.aufdemrand.denizen.exceptions.CommandExecutionException;
import net.aufdemrand.denizen.exceptions.InvalidArgumentsException;
import net.aufdemrand.denizen.scripts.ScriptEntry;
import net.aufdemrand.denizen.scripts.commands.AbstractCommand;
import net.aufdemrand.denizen.utilities.arguments.aH;
import net.aufdemrand.denizen.utilities.arguments.aH.ArgumentType;
import net.aufdemrand.denizen.utilities.debugging.dB;
import net.aufdemrand.denizen.utilities.debugging.dB.Messages;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;

/**
 * Configures the LookClose Trait for a NPC.
 * 
 * @author Jeremy Schroeder
 */

public class LookcloseCommand extends AbstractCommand {

	/* LOOKCLOSE [TOGGLE:TRUE|FALSE] (RANGE:#.#) (REALISTIC)  */

	/* 
	 * Arguments: [] - Required, () - Optional
	 * 
	 */

    boolean toggle;
    boolean realistic;
    Double range;
    NPC npc;

	@Override
	public void parseArgs(ScriptEntry scriptEntry) throws InvalidArgumentsException {

		// Set some defaults based on the scriptEntry
	    npc = null;
	    range = null;
	    realistic = false;
	    toggle = true;
	    if (scriptEntry.getNPC() != null) npc = scriptEntry.getNPC().getCitizen();
	    
	    // Parse Arguments
		for (String arg : scriptEntry.getArguments()) {

			if (aH.matchesArg("REALISTIC", arg)) {
				realistic = true;
				dB.echoDebug(Messages.DEBUG_SET_TYPE, arg);

            }   else if (aH.matchesValueArg("RANGE", arg, ArgumentType.Double)) {
                range = aH.getDoubleFrom(arg);
                dB.echoDebug(Messages.DEBUG_SET_RANGE, String.valueOf(range));

            }   else if (aH.matchesToggle(arg)) {
                toggle = aH.getBooleanFrom(arg);
                dB.echoDebug(Messages.DEBUG_TOGGLE, String.valueOf(toggle));

            }	else throw new InvalidArgumentsException(Messages.ERROR_UNKNOWN_ARGUMENT, arg);
		}
	}
	
	String[] realisticArgs = "/npc lookclose -r".split(" ");

    // TODO: Fix this.

	@Override
	public void execute(ScriptEntry scriptEntry) throws CommandExecutionException {
		if (npc == null) throw new CommandExecutionException(Messages.ERROR_NO_NPCID);
		
		// Get the instance of the trait that belongs to the target NPC
		LookClose trait = npc.getTrait(LookClose.class);
		trait.lookClose(toggle);
		if (realistic) {
		    // trait.configure(new CommandContext(realisticArgs));
		}
		if (range != null) {
		    String[] rangeArgs = ("npc lookclose --range " + range).split(" ");
		    // trait.configure(new CommandContext(rangeArgs));
		}
	}
	
    @Override
    public void onEnable() {
        
    }
}