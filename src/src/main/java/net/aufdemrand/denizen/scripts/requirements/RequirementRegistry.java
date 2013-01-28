package net.aufdemrand.denizen.scripts.requirements;

import net.aufdemrand.denizen.Denizen;
import net.aufdemrand.denizen.interfaces.DenizenRegistry;
import net.aufdemrand.denizen.interfaces.RegistrationableInstance;
import net.aufdemrand.denizen.scripts.requirements.core.*;
import net.aufdemrand.denizen.utilities.debugging.dB;

import java.util.HashMap;
import java.util.Map;

public class RequirementRegistry implements DenizenRegistry {

    public Denizen denizen;

    private Map<String, AbstractRequirement> instances = new HashMap<String, AbstractRequirement>();

    private Map<Class<? extends AbstractRequirement>, String> classes = new HashMap<Class<? extends AbstractRequirement>, String>();
    public RequirementRegistry(Denizen denizen) {
        this.denizen = denizen;
    }

    @Override
	public void disableCoreMembers() {
		for (RegistrationableInstance member : instances.values())
			try { 
				member.onDisable(); 
			} catch (Exception e) {
				dB.echoError("Unable to disable '" + member.getClass().getName() + "'!");
				if (dB.showStackTraces) e.printStackTrace();
			}
	}

    @Override
    public <T extends RegistrationableInstance> T get(Class<T> clazz) {
        if (classes.containsKey(clazz)) return (T) clazz.cast(instances.get(classes.get(clazz)));
        else return null;
    }

    @Override
    public AbstractRequirement get(String requirementName) {
        if (instances.containsKey(requirementName.toUpperCase())) return instances.get(requirementName);
        else return null;
    }

    @Override
    public Map<String, AbstractRequirement> list() {
        return instances;
    }

    @Override
    public boolean register(String requirementName, RegistrationableInstance requirementClass) {
        this.instances.put(requirementName.toUpperCase(), (AbstractRequirement) requirementClass);
        this.classes.put(((AbstractRequirement) requirementClass).getClass(), requirementName.toUpperCase());
        return true;
    }

	@Override
    public void registerCoreMembers() {
        new EnchantedRequirement().activate().as("ENCHANTED").withOptions("(ITEMINHAND)", 1);
        new FlaggedRequirement().activate().as("FLAGGED").withOptions("NO ARGS", 0);
        new InGroupRequirement().activate().as("INGROUP").withOptions("[GROUP]", 1);
        new PermissionRequirement().activate().as("PERMISSION").withOptions("[PERMISSION]", 1);
        new HoldingRequirement().activate().as("HOLDING").withOptions("[ITEMNAME]", 1);
        new LiquidRequirement().activate().as("ISLIQUID").withOptions("[LOCATION:x,y,z,world]", 1);
        new MoneyRequirement().activate().as("MONEY").withOptions("[QTY:#]", 1);
        new OwnerRequirement().activate().as("OWNER").withOptions("NONE", 0);
        new OwnerRequirement().activate().as("OP").withOptions("NONE", 0);
        new PoweredRequirement().activate().as("ISPOWERED").withOptions("[LOCATION:x,y,z,world]", 1);
        new ScriptRequirement().activate().as("SCRIPT").withOptions("TBD", 0);
        new SneakingRequirement().activate().as("SNEAKING").withOptions("NONE", 0);
        new StormRequirement().activate().as("STORMING").withOptions("NONE", 0);
        new SunnyRequirement().activate().as("SUNNY").withOptions("NONE", 0);
		new TimeRequirement().activate().as("TIME").withOptions("[DAWN, DAY, DUSK, NIGHT]", 1);
        new WorldGuardRegionRequirement().activate().as("INREGION").withOptions("[NAME:regionname]", 1);
        dB.echoApproval("Loaded core requirements: " + instances.keySet().toString());
    }

}
