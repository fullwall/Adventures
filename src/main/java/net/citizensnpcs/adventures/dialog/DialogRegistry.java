package net.citizensnpcs.adventures.dialog;

import java.util.Collection;

public interface DialogRegistry {
    void clear();

    Rule getBestRule(Query query);

    Response getResponse(String responseIdentifier);

    void registerResponse(Response response);

    void registerRule(Collection<String> eventNames, Rule rule);
}