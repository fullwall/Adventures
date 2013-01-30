package net.citizensnpcs.adventures.dialog.statements;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.DialogException;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ArgumentFormat {
    private final Set<String> orderedArguments = Sets.newLinkedHashSet();
    private final Set<String> requiredArguments = Sets.newHashSet();

    public ArgumentFormat(String argumentFormat) {
        for (String part : argumentFormat.split(" ")) {
            char start = part.charAt(0), last = part.charAt(part.length() - 1);
            if (start == '[') {
                Preconditions.checkArgument(last == ']');
                part = part.substring(1, part.length() - 1);
                requiredArguments.add(part);
            } else if (start == '(') {
                Preconditions.checkArgument(last == ')');
                part = part.substring(1, part.length() - 1);
            } else {
                requiredArguments.add(part);
            }
            orderedArguments.add(part);
        }
    }

    public StatementContext createStatementContext(String name, Collection<Argument> vars) {
        Set<String> remaining = Sets.newLinkedHashSet(orderedArguments);
        Map<String, Object> map = Maps.newHashMap();
        for (Argument arg : vars) {
            if (remaining.size() == 0)
                break;
            if (arg.name != null) {
                remaining.remove(arg.name);
                map.put(arg.name, arg.value.isConstant() ? arg.value.get() : arg.value);
                continue;
            } else {
                Iterator<String> itr = remaining.iterator();
                String next = itr.next();
                map.put(next, arg.value);
                itr.remove();
            }
        }
        Set<String> intersection = Sets.intersection(remaining, requiredArguments);
        if (intersection.size() > 0)
            throw new DialogException("Missing required arguments " + intersection);
        return new StatementContext(name, map);
    }
}
