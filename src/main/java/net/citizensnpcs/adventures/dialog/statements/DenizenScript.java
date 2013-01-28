package net.citizensnpcs.adventures.dialog.statements;

import net.aufdemrand.denizen.npc.dNPC;
import net.aufdemrand.denizen.utilities.DenizenAPI;
import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class DenizenScript implements QueryRunnable {
    private final String name;
    private final StatementContext statementContext;

    public DenizenScript(StatementContext statementContext) {
        this.name = statementContext.getRequired("name", String.class);
        this.statementContext = statementContext;
    }

    @Override
    public void run(QueryContext context) {
        dNPC denizen = parseDenizen(statementContext.getUnsafe("denizen"));
        Player player = parsePlayer(statementContext.getUnsafe("player"));
        if (player == null && denizen == null) {
            throw new DialogException("Couldn't parse a player or a denizen");
        }
        DenizenAPI.getCurrentInstance().getScriptEngine().getScriptBuilder().runTaskScript(denizen, player, name);
    }

    private Player parsePlayer(Object unsafe) {
        if (unsafe instanceof Player)
            return (Player) unsafe;
        if (unsafe instanceof String)
            return Bukkit.getPlayerExact(unsafe.toString());
        return null;
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
        return null;
    }

    @StatementBuilder(name = "dtask", arguments = "[name] [player] (denizen)")
    public static QueryRunnable buildPlayer(ParseContext parseContext, StatementContext statementContext) {
        return new DenizenScript(statementContext);
    }

    @StatementBuilder(name = "dtask", arguments = "[name] [denizen] (player)")
    public static QueryRunnable buildDenizen(ParseContext parseContext, StatementContext statementContext) {
        return new DenizenScript(statementContext);
    }
}
