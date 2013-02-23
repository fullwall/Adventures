package net.citizensnpcs.adventures.dialog.statements;

import java.util.Map;

import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;

import com.google.common.collect.ForwardingMap;

public class StatementContext {
    private final Map<String, Object> map;
    private final String name;

    public StatementContext(String name, Map<String, Object> map) {
        this.map = map;
        this.name = name;
    }

    public Locals createLocals(VariableSource variables) {
        return new Locals(variables);
    }

    public Map<String, Object> getMap(final VariableSource variables) {
        return new ForwardingMap<String, Object>() {
            @Override
            protected Map<String, Object> delegate() {
                return map;
            }

            @Override
            public Object get(Object key) {
                Object value = map.get(key);
                return value != null && value instanceof Evaluator ? ((Evaluator) value).get(variables) : null;
            }
        };
    }

    public String getName() {
        return name;
    }

    public <T> T getRequired(VariableSource variables, String key, Class<? extends T> keyClass) throws DialogException {
        T unknown = getSafe(variables, key, keyClass);
        if (unknown == null)
            throw new DialogException("Expected a value for key " + key);
        return unknown;
    }

    public <T> T getSafe(VariableSource variables, String key, Class<? extends T> keyClass) throws DialogException {
        Object raw = map.get(key);
        if (raw == null)
            return null;
        if (raw instanceof Evaluator)
            raw = ((Evaluator) raw).get(variables);
        try {
            return keyClass.cast(raw);
        } catch (ClassCastException ex) {
            throw new DialogException("Expected " + keyClass.getSimpleName() + " but got "
                    + raw.getClass().getSimpleName() + " for key " + key);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getUnsafe(VariableSource variables, String key) {
        Object obj = map.get(key);
        if (obj != null && obj instanceof Evaluator)
            obj = ((Evaluator) obj).get(variables);
        return (T) obj;
    }

    public class Locals {
        private final VariableSource variables;

        public Locals(VariableSource variables) {
            this.variables = variables;
        }

        public Map<String, Object> getMap() {
            return StatementContext.this.getMap(variables);
        }

        public <T> T getRequired(String key, Class<? extends T> keyClass) throws DialogException {
            return StatementContext.this.getRequired(variables, key, keyClass);
        }

        public <T> T getSafe(String key, Class<? extends T> keyClass) throws DialogException {
            return StatementContext.this.getSafe(variables, key, keyClass);
        }

        public <T> T getUnsafe(String key) throws DialogException {
            return StatementContext.this.getUnsafe(variables, key);
        }
    }
}
