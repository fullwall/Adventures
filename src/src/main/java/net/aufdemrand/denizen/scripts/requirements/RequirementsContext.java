package net.aufdemrand.denizen.scripts.requirements;

import net.citizensnpcs.api.npc.NPC;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Press
 * Date: 1/16/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class RequirementsContext {

    protected RequirementsMode mode;
    protected List<String> list;

    private Map<String, Object> objects = new HashMap<String, Object>();

    protected Player player = null;
    protected NPC npc = null;
    protected String scriptName;

    public RequirementsContext(RequirementsMode mode, List<String> list, String scriptName) {
        this.mode = mode;
        this.list = list;
        this.scriptName = scriptName;
    }

    public RequirementsContext attachPlayer(Player player) {
        this.player = player;
        return this;
    }

    public RequirementsContext attachNPC(NPC npc) {
        this.npc = npc;
        return this;
    }

    public NPC getNPC() {
        return npc;
    }

    public Player getPlayer() {
        return player;
    }

    public String getScript() {
        return scriptName;
    }

    public RequirementsContext addObject(String key, Object obj) {
        key = key.toUpperCase();
        objects.put(key, obj);
        return this;
    }

    public boolean hasObject(String key) {
        key = key.toUpperCase();
        return objects.containsKey(key);
    }

    public Object getObject(String key) {
        key = key.toUpperCase();
        if (objects.containsKey(key)) return objects.get(key);
        return null;
    }

}
