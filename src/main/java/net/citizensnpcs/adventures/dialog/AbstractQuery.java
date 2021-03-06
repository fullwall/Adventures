package net.citizensnpcs.adventures.dialog;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public abstract class AbstractQuery implements Query {
    private final String eventName;
    private final Map<String, Object> queryVariables;

    public AbstractQuery(String eventName, Map<String, Object> queryMap) {
        this.queryVariables = queryMap == null ? Collections.<String, Object> emptyMap() : queryMap;
        this.eventName = eventName;
    }

    @Override
    public boolean acceptsRule(Rule rule) {
        return true;
    }

    @Override
    public boolean contains(String key) {
        return queryVariables.containsKey(key);
    }

    private Method findGetterMethod(Object source, String methodName) {
        Class<?> sourceClass = source.getClass();
        String upper = Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
        Method test = getMethod(sourceClass, "get" + upper);
        if (test != null)
            return test;
        test = getMethod(sourceClass, "is" + upper);
        if (test != null)
            return test;
        return getMethod(sourceClass, methodName);
    }

    @Override
    public void forget(String... keys) {
        for (String key : keys) {
            queryVariables.remove(key);
        }
    }

    @Override
    public Object get(String key) {
        Object quickPath = queryVariables.get(key);
        if (quickPath != null)
            return quickPath;
        return slowGet(key);
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    private Method getMethod(Class<?> source, String name) {
        Method ret = null;
        try {
            ret = source.getMethod(name, (Class<?>[]) null);
            if (ret.getReturnType() == null || Modifier.isStatic(ret.getModifiers()))
                return null;

            ret.setAccessible(true);

        } catch (Exception e) {
        }

        return ret;
    }

    @Override
    public Object getVariable(String key) {
        return get(key);
    }

    private Object slowGet(String key) {
        int dotIndex;
        Object current = null;
        List<String> parts = Lists.newArrayListWithCapacity(4);
        while (current == null && (dotIndex = key.lastIndexOf('.')) != -1) {
            parts.add(key.substring(dotIndex + 1));
            key = key.substring(0, dotIndex);
            current = queryVariables.get(key);
        }
        if (current == null)
            return null;
        for (String part : parts) {
            key += part;
            Method cached = METHOD_CACHE.get(key);
            if (cached == null)
                cached = findGetterMethod(current, part);
            if (cached == null)
                return null;
            try {
                current = cached.invoke(current, (Object[]) null);
            } catch (Exception e) {
                return null;
            }
        }
        return current;
    }

    private static final Map<String, Method> METHOD_CACHE = Maps.newHashMap();
}
