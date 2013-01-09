package net.citizensnpcs.adventures.dialog;

import java.util.Collection;

public interface DialogRegistry {
    void registerRule(Collection<String> eventNames, Rule rule);

    void registerResponse(String name, Response value);

    Response getResponse(String responseIdentifier);

    Rule getBestRule(Query query);
}