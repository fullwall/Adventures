package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;

public class SimpleDialogRegistry implements DialogRegistry {
    private final ListMultimap<String, Rule> rulesByEvent = Multimaps
            .synchronizedListMultimap(ArrayListMultimap.<String, Rule> create());
    private final Map<String, Response> responses = Collections.synchronizedMap(Maps
            .<String, Response> newHashMap());

    @Override
    public void registerRule(Collection<String> eventNames, Rule rule) {
        Preconditions.checkNotNull(rule);
        Preconditions.checkNotNull(eventNames);
        synchronized (rulesByEvent) {
            for (String eventName : eventNames) {
                if (rulesByEvent.containsKey(eventName))
                    throw new IllegalStateException();
                rulesByEvent.put(eventName, rule);
            }
        }
    }

    @Override
    public void registerResponse(String name, Response value) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(value);
        synchronized (responses) {
            responses.put(name, value);
        }
    }

    @Override
    public Object getRuleSynchronizationObject() {
        return rulesByEvent;
    }

    @Override
    public Iterable<Rule> getRulesForEventName(String eventName) {
        return Iterables.concat(rulesByEvent.get("any"), rulesByEvent.get(eventName));
    }

    @Override
    public Response getResponse(String responseIdentifier) {
        synchronized (responses) {
            return responses.get(responseIdentifier);
        }
    }
}
