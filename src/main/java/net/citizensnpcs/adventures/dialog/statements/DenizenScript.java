package net.citizensnpcs.adventures.dialog.statements;

import net.aufdemrand.denizen.objects.dNPC;
import net.aufdemrand.denizen.objects.dPlayer;
import net.aufdemrand.denizen.scripts.ScriptRegistry;
import net.aufdemrand.denizen.scripts.containers.core.TaskScriptContainer;
import net.aufdemrand.denizen.utilities.DenizenAPI;
import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.statements.StatementContext.Locals;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DenizenScript implements QueryRunnable {
    private final StatementContext statementContext;

    public DenizenScript(StatementContext statementContext) {
        this.statementContext = statementContext;
    }

    private dNPC parseDenizen(Object unsafe) {
        if (unsafe instanceof dNPC)
            return (dNPC) unsafe;
        if (unsafe instanceof NPC)
            return DenizenAPI.getDenizenNPC((NPC) unsafe);
        if (unsafe instanceof String) {
            try {
                return DenizenAPI.getDenizenNPC(CitizensAPI.getNPCRegistry().getById(
                        Integer.parseInt(unsafe.toString())));
            } catch (NumberFormatException swallow) {
            }
        }
        if (unsafe instanceof Integer) {
            return DenizenAPI.getDenizenNPC(CitizensAPI.getNPCRegistry().getById((Integer) unsafe));
        }
        return null;
    }

    private Player parsePlayer(Object unsafe) {
        if (unsafe instanceof Player)
            return (Player) unsafe;
        if (unsafe instanceof String)
            return Bukkit.getPlayerExact(unsafe.toString());
        return null;
    }

    @Override
    public void run(QueryContext context) {
        Locals locals = statementContext.createLocals(context.getQuery());
        dNPC denizen = parseDenizen(locals.getUnsafe("denizen"));
        Player player = parsePlayer(locals.getUnsafe("player"));
        if (player == null && denizen == null) {
            throw new DialogException("Couldn't parse a player or a denizen");
        }
        String name = locals.getRequired("name", String.class);
        TaskScriptContainer task = ScriptRegistry.getScriptContainerAs(name, TaskScriptContainer.class);
        if (task == null)
            throw new DialogException("Couldn't find a task script by that name");
        task.runTaskScript(dPlayer.valueOf(player.getName()), denizen, null);
    }

    @StatementBuilder(name = "dtask", arguments = "[name] [denizen] (player)")
    public static QueryRunnable buildDenizen(ParseContext parseContext, StatementContext statementContext) {
        return new DenizenScript(statementContext);
    }

    @StatementBuilder(name = "dtask", arguments = "[name] [player] (denizen)")
    public static QueryRunnable buildPlayer(ParseContext parseContext, StatementContext statementContext) {
        return new DenizenScript(statementContext);
    }
}
