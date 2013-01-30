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
    private final Map<String, Response> responses = Collections.synchronizedMap(Maps.<String, Response> newHashMap());
    private final ListMultimap<String, Rule> rulesByEvent = Multimaps.synchronizedListMultimap(ArrayListMultimap
            .<String, Rule> create());
    private final Map<String, Rule> rulesByName = Collections.synchronizedMap(Maps.<String, Rule> newHashMap());

    @Override
    public Rule getBestRule(Query query) {
        int highestScore = 0;
        int iterations = 0;
        Rule lastMatching = null;
        synchronized (rulesByEvent) {
            for (Rule rule : Iterables.concat(rulesByEvent.get("any"), rulesByEvent.get(query.getEventName()))) {
                if (highestScore > rule.getNumberOfCriteria()) {
                    System.err.println("[q] Skipping rest of rules as highest score > number of criteria ("
                            + highestScore + ">" + rule.getNumberOfCriteria() + ")");
                    break;
                }

                int matches = rule.getNumberOfMatches(query, highestScore);
                if (matches > highestScore) {
                    highestScore = matches;
                    lastMatching = rule;
                    System.err.println("[q] Found a new top score @" + highestScore);
                } else {
                    System.err.println("[q] Number of matches " + matches + " < highest score " + highestScore);
                }
                iterations++;
            }
        }
        System.err.println("[q] Iterated " + iterations + " highest score was " + highestScore);
        return lastMatching;
    }

    @Override
    public Response getResponse(String responseIdentifier) {
        synchronized (responses) {
            return responses.get(responseIdentifier);
        }
    }

    @Override
    public void registerResponse(Response response) {
        Preconditions.checkNotNull(response);
        synchronized (responses) {
            if (responses.containsKey(response.getName()))
                throw new IllegalArgumentException();
            responses.put(response.getName(), response);
        }
    }

    @Override
    public void registerRule(Collection<String> eventNames, Rule rule) {
        Preconditions.checkNotNull(rule);
        Preconditions.checkNotNull(eventNames);
        synchronized (rulesByName) {
            if (rulesByName.containsKey(rule.getName()))
                throw new IllegalArgumentException("A rule already exists with name " + rule.getName());
            rulesByName.put(rule.getName(), rule);
        }
        synchronized (rulesByEvent) {
            for (String eventName : eventNames) {
                rulesByEvent.put(eventName, rule);
                Collections.sort(rulesByEvent.get(eventName));
            }
        }
    }
}
