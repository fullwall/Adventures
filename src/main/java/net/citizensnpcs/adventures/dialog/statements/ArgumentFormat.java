package net.citizensnpcs.adventures.dialog.statements;

import java.util.Map;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ArgumentFormat {
    private final Set<String> optionalArguments = Sets.newHashSet();
    private final Set<String> requiredArguments = Sets.newHashSet();

    public ArgumentFormat(String argumentFormat) {
        for (String part : argumentFormat.split(" ")) {
            char start = part.charAt(0), last = part.charAt(part.length() - 1);
            if (start == '[') {
                Preconditions.checkArgument(last == ']');
                requiredArguments.add(part.substring(1, part.length() - 1));
            } else if (start == '(') {
                Preconditions.checkArgument(last == ')');
                optionalArguments.add(part.substring(1, part.length() - 1));
            } else {
                requiredArguments.add(part);
            }
        }
    }

    public StatementContext createStatementContext(Map<String, Evaluator> vars) {
        if (!vars.keySet().containsAll(requiredArguments))
            throw new DialogException("Variables did not contain all required arguments " + requiredArguments);
        Set<String> union = Sets.union(optionalArguments, requiredArguments);
        Map<String, Object> map = Maps.newHashMap();
        for (Map.Entry<String, Evaluator> entry : vars.entrySet()) {
            String key = entry.getKey();
            Evaluator value = entry.getValue();
            if (union.contains(key)) {
                map.put(key, value.isConstant() ? value.get() : value);
            }
        }
        return new StatementContext(map);
    }
}
