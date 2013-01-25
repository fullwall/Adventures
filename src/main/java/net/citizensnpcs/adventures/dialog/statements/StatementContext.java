package net.citizensnpcs.adventures.dialog.statements;

import java.util.Map;

import net.citizensnpcs.adventures.dialog.DialogException;

public class StatementContext {
    private final Map<String, Object> map;

    public StatementContext(Map<String, Object> map) {
        this.map = map;
    }

    public <T> T safeGet(String key, Class<? extends T> keyClass) throws DialogException {
        Object raw = map.get(key);
        if (raw == null)
            return null;
        try {
            return keyClass.cast(raw);
        } catch (ClassCastException ex) {
            throw new DialogException("Expected " + keyClass.getSimpleName() + " but got "
                    + raw.getClass().getSimpleName() + " for key " + key);
        }
    }
}
