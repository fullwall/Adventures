package net.citizensnpcs.adventures.dialog;

import java.util.Collection;

public interface ParseContext {
    void responseLoaded(Response response);

    void ruleLoaded(Collection<String> eventNames, Rule rule);
}
