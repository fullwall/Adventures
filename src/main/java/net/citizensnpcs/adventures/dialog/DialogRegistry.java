package net.citizensnpcs.adventures.dialog;

import java.util.Collection;

public interface DialogRegistry {
    void registerRule(Collection<String> eventNames, Rule rule);

    void registerResponse(String name, Response value);

    Object getRuleSynchronizationObject();

    Iterable<Rule> getRulesForEventName(String eventName);

    Response getResponse(String responseIdentifier);
}