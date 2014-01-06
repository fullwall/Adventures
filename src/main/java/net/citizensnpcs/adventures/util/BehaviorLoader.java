package net.citizensnpcs.adventures.util;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import net.citizensnpcs.adventures.Config;
import net.citizensnpcs.adventures.race.RaceDescriptor;
import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.ForwardingBehaviorGoalAdapter;
import net.citizensnpcs.api.ai.tree.Selector;
import net.citizensnpcs.api.ai.tree.Selectors;
import net.citizensnpcs.api.ai.tree.Sequence;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.PersistenceLoader;
import net.citizensnpcs.api.scripting.Script;
import net.citizensnpcs.api.scripting.ScriptFactory;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Messaging;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

public class BehaviorLoader {
    public static class Context {
        public File file;
        public NPC npc;
        public RaceDescriptor race;
        public Tribe tribe;

        public Context(File file, Tribe tribe) {
            this(file, tribe, null);
        }

        public Context(File file, Tribe tribe, NPC npc) {
            this.file = file;
            this.tribe = tribe;
            this.race = tribe.getRace();
            this.npc = npc;
        }
    }

    public static Goal loadBehaviors(Context context, DataKey key) {
        Iterator<DataKey> subKeys = key.getSubKeys().iterator();
        if (!subKeys.hasNext())
            return null;
        try {
            final Behavior behavior = loadRecursive(context, subKeys.next());
            if (behavior == null)
                return null;
            return behavior instanceof Goal ? (Goal) behavior : new ForwardingBehaviorGoalAdapter(behavior);
        } catch (Exception e) {
            Throwable root = Throwables.getRootCause(e);
            Messaging.severeTr(Language.ERROR_LOADING_BEHAVIOR, root.getMessage());
            root.printStackTrace();
            return null;
        }
    }

    private static Behavior loadClassBehavior(Context context, DataKey key, String name) {
        String namespacedName = name.replace('-', '.');
        Class<?> clazz = CLASS_CACHE.get(namespacedName);
        if (clazz == null) {
            try {
                clazz = Class.forName(namespacedName);
                CLASS_CACHE.put(namespacedName, clazz);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (!CLASS_METHOD_CACHE.containsKey(clazz)) {
            Method method = null;
            try {
                method = clazz.getDeclaredMethod("createInstance", Context.class, DataKey.class);
            } catch (Exception e) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
            CLASS_METHOD_CACHE.put(clazz, method);
        }
        Method m = CLASS_METHOD_CACHE.get(clazz);
        if (m == null) {
            return (Behavior) PersistenceLoader.load(clazz, key);
        }
        try {
            Object behavior = m.invoke(null, context, key);
            return (Behavior) PersistenceLoader.load(behavior, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Collection<Behavior> loadCompositeGoals(Context context, Iterable<DataKey> subKeys) {
        List<Behavior> goals = Lists.newArrayList();
        for (DataKey key : subKeys) {
            Behavior temp = loadRecursive(context, key);
            if (temp == null)
                continue;
            goals.add(temp);
        }
        return goals;
    }

    private static Behavior loadJavascriptBehavior(Context context, DataKey key, String name) {
        String fileName = name.replaceFirst("js", "").trim() + ".js";
        File jsFile = new File(context.file.getParent(), fileName);
        try {
            ScriptFactory factory = CitizensAPI.getScriptCompiler().compile(jsFile).cache(Config.CACHE_SCRIPTS)
                    .beginWithFuture().get();
            if (factory == null)
                throw new IllegalStateException("Couldn't load javascript");

            Script script = factory.newInstance();
            Object res = script.invoke("getBehavior", context, key);
            Object converted = res == null ? null : script.convertToInterface(res, Behavior.class);

            if (converted == null || !(converted instanceof Behavior))
                throw new IllegalArgumentException("Couldn't convert to Behavior");

            return (Behavior) converted;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Behavior loadRecursive(Context context, DataKey key) {
        String name = key.name().trim();
        String first = name.split(" ")[0];
        if (first.equals("sequence")) {
            return loadSequence(context, key, name);
        } else if (first.equals("selector")) {
            return loadSelector(context, key, name);
        } else if (first.equals("js")) {
            return loadJavascriptBehavior(context, key, name);
        } else if (first.isEmpty()) {
            return null;
        } else {
            return loadClassBehavior(context, key, name);
        }
    }

    private static Behavior loadSelector(Context context, DataKey key, String name) {
        Collection<Behavior> sub = loadCompositeGoals(context, key.getSubKeys());
        if (sub.isEmpty())
            return null;

        Selector.Builder builder = Selector.selecting(sub).retryChildren(name.contains("-r"));
        if (name.contains("-p"))
            builder.selectionFunction(Selectors.prioritySelectionFunction());

        return builder.build();
    }

    private static Behavior loadSequence(Context context, DataKey key, String name) {
        boolean retry = name.contains("-r");
        Collection<Behavior> sub = loadCompositeGoals(context, key.getSubKeys());
        if (sub.isEmpty())
            return null;
        return retry ? Sequence.createRetryingSequence(sub) : Sequence.createSequence(sub);
    }

    private static final Map<String, Class<?>> CLASS_CACHE = new MapMaker().weakValues().makeMap();
    private static final Map<Class<?>, Method> CLASS_METHOD_CACHE = new WeakHashMap<Class<?>, Method>();
}
