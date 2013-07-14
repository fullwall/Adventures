package net.citizensnpcs.adventures.util;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import net.citizensnpcs.adventures.Config;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorGoalAdapter;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.ai.tree.Selector;
import net.citizensnpcs.api.ai.tree.Selectors;
import net.citizensnpcs.api.ai.tree.Sequence;
import net.citizensnpcs.api.persistence.PersistenceLoader;
import net.citizensnpcs.api.scripting.Script;
import net.citizensnpcs.api.scripting.ScriptFactory;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Messaging;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

public class BehaviorLoader {
    public static Goal loadBehaviors(File file, DataKey key) {
        Iterator<DataKey> subKeys = key.getSubKeys().iterator();
        if (!subKeys.hasNext())
            return null;
        try {
            final Behavior behavior = loadRecursive(file, subKeys.next());
            if (behavior == null)
                return null;
            return behavior instanceof Goal ? (Goal) behavior : new BehaviorGoalAdapter() {
                @Override
                public void reset() {
                    behavior.reset();
                }

                @Override
                public BehaviorStatus run() {
                    return behavior.run();
                }

                @Override
                public boolean shouldExecute() {
                    return behavior.shouldExecute();
                }
            };
        } catch (Exception e) {
            Throwable root = Throwables.getRootCause(e);
            Messaging.severeTr(Language.ERROR_LOADING_BEHAVIOR, root.getMessage());
            root.printStackTrace();
            return null;
        }
    }

    private static Behavior loadClassBehavior(DataKey key, String name) {
        String namespacedName = name;
        Class<?> clazz = CLASS_CACHE.get(namespacedName);
        if (clazz != null) {
            try {
                clazz = Class.forName(namespacedName);
                CLASS_CACHE.put(namespacedName, clazz);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return (Behavior) PersistenceLoader.load(clazz, key);
    }

    private static Collection<Behavior> loadCompositeGoals(File file, Iterable<DataKey> subKeys) {
        List<Behavior> goals = Lists.newArrayList();
        for (DataKey key : subKeys) {
            Behavior temp = loadRecursive(file, key);
            if (temp == null)
                continue;
            goals.add(temp);
        }
        return goals;
    }

    private static Behavior loadJavascriptBehavior(File file, DataKey key, String name) {
        String fileName = name.replaceFirst("js", "").trim() + ".js";
        File jsFile = new File(file.getParent(), fileName);
        try {
            ScriptFactory factory = CitizensAPI.getScriptCompiler().compile(jsFile).cache(Config.CACHE_SCRIPTS)
                    .beginWithFuture().get();
            if (factory == null)
                throw new IllegalStateException("Couldn't load javascript");

            Script script = factory.newInstance();
            Object res = script.invoke("getBehavior", key);
            Object converted = res == null ? null : script.convertToInterface(res, Behavior.class);

            if (converted == null || !(converted instanceof Behavior))
                throw new IllegalArgumentException("Couldn't convert to Behavior");

            return (Behavior) converted;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Behavior loadRecursive(File file, DataKey key) {
        String name = key.name();
        String first = name.split(" ")[0];
        if (first.equals("sequence")) {
            return loadSequence(file, key, name);
        } else if (first.equals("selector")) {
            return loadSelector(file, key, name);
        } else if (first.equals("js")) {
            return loadJavascriptBehavior(file, key, name);
        } else if (first.isEmpty()) {
            return null;
        } else {
            return loadClassBehavior(key, name);
        }
    }

    private static Behavior loadSelector(File file, DataKey key, String name) {
        Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());
        if (sub.isEmpty())
            return null;

        Selector.Builder builder = Selector.selecting(sub).retryChildren(name.contains("-r"));
        if (name.contains("-p"))
            builder.selectionFunction(Selectors.prioritySelectionFunction());

        return builder.build();
    }

    private static Behavior loadSequence(File file, DataKey key, String name) {
        boolean retry = name.contains("-r");
        Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());

        if (sub.isEmpty())
            return null;

        return retry ? Sequence.createRetryingSequence(sub) : Sequence.createSequence(sub);
    }

    private static final Map<String, Class<?>> CLASS_CACHE = new WeakHashMap<String, Class<?>>();
}
