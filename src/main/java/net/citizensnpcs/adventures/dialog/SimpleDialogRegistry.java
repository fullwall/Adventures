package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import net.citizensnpcs.adventures.util.Debug;

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

    @Override
    public void clear() {
        synchronized (rulesByEvent) {
            rulesByEvent.clear();
        }
        synchronized (responses) {
            responses.clear();
        }
    }

    @Override
    public Rule getBestRule(Query query) {
        int highestScore = 0;
        int iterations = 0;
        Rule lastMatching = null;
        synchronized (rulesByEvent) {
            for (Rule rule : Iterables.concat(rulesByEvent.get("any"), rulesByEvent.get(query.getEventName()))) {
                if (!query.acceptsRule(rule))
                    continue;
                if (highestScore > rule.getNumberOfCriteria()) {
                    Debug.debug("[q] Skipping rest of rules as highest score > number of criteria (" + highestScore
                            + ">" + rule.getNumberOfCriteria() + ")");
                    break;
                }

                int matches = rule.getNumberOfMatches(query, highestScore);
                if (matches > highestScore) {
                    highestScore = matches;
                    lastMatching = rule;
                    Debug.debug("[q] Found a new top score @" + highestScore);
                } else {
                    Debug.debug("[q] Number of matches " + matches + " < highest score " + highestScore);
                }
                iterations++;
            }
        }
        Debug.debug("[q] Iterated " + iterations + " highest score was " + highestScore);
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
        synchronized (rulesByEvent) {
            for (String eventName : eventNames) {
                rulesByEvent.put(eventName, rule);
                Collections.sort(rulesByEvent.get(eventName));
            }
        }
    }
}
