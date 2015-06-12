package net.citizensnpcs.adventures.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;

import net.citizensnpcs.adventures.race.RaceDescriptor;
import net.citizensnpcs.adventures.race.Tribe;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.Composite;
import net.citizensnpcs.api.ai.tree.Selector;
import net.citizensnpcs.api.ai.tree.Selectors;
import net.citizensnpcs.api.ai.tree.Selectors.PrioritySelection;
import net.citizensnpcs.api.ai.tree.Sequence;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.api.persistence.PersistenceLoader;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.Messaging;

public class BehaviorLoader {
    public static class Context {
        public NPC npc;
        public RaceDescriptor race;
        public DataKey redirect;
        public Tribe tribe;

        public Context(Tribe tribe) {
            this(tribe, null);
        }

        public Context(Tribe tribe, NPC npc) {
            this.tribe = tribe;
            this.race = tribe.getRace();
            this.npc = npc;
        }

        public boolean isFirstLoad() {
            return redirect == null;
        }
    }

    private static Class<?> getCachedClass(String name) {
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
        return clazz;
    }

    public static Behavior loadBehaviors(Context context, DataKey key) {
        Iterator<DataKey> subKeys = key.getSubKeys().iterator();
        if (!subKeys.hasNext())
            return null;
        try {
            DataKey sub = subKeys.next();
            final Behavior behavior = loadRecursive(context, sub, sub.name());
            return behavior;
        } catch (Exception e) {
            Throwable root = Throwables.getRootCause(e);
            Messaging.severeTr(Language.ERROR_LOADING_BEHAVIOR, root.getMessage());
            root.printStackTrace();
            return null;
        }
    }

    private static Behavior loadClassBehavior(Context context, DataKey key, String name, String relativePath) {
        Class<?> clazz = getCachedClass(name);
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
            return (Behavior) PersistenceLoader.load(clazz,
                    context.redirect == null ? key : context.redirect.getRelative(relativePath));
        }
        try {
            Object behavior = m.invoke(null, context, key);
            return (Behavior) PersistenceLoader.load(behavior,
                    context.redirect == null ? key : context.redirect.getRelative(relativePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Behavior loadComposite(Context context, DataKey key, String name, String relativePath) {
        try {
            @SuppressWarnings("unchecked")
            Constructor<? extends Composite> constructor = (Constructor<? extends Composite>) getCachedClass(
                    key.name().replaceFirst("composite ", "")).getConstructors()[0];
            constructor.setAccessible(true);
            Composite composite = constructor.newInstance(loadCompositeGoals(context, key.getSubKeys(), relativePath));
            PersistenceLoader.load(composite,
                    context.redirect == null ? key : context.redirect.getRelative(relativePath));
            return composite;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Collection<Behavior> loadCompositeGoals(Context context, Iterable<DataKey> subKeys,
            String relativePath) {
        List<Behavior> goals = Lists.newArrayList();
        for (DataKey key : subKeys) {
            Behavior temp = loadRecursive(context, key, relativePath + (key.name().isEmpty() ? "" : '.' + key.name()));
            if (temp == null)
                continue;
            goals.add(temp);
        }
        return goals;
    }

    private static Behavior loadRecursive(Context context, DataKey key, String relativePath) {
        String name = key.name().trim();
        String first = name.split(" ")[0];
        if (first.equals("sequence")) {
            return loadSequence(context, key, name, relativePath);
        } else if (first.equals("selector")) {
            return loadSelector(context, key, name, relativePath);
        } else if (first.startsWith("composite")) {
            return loadComposite(context, key, name, relativePath);
        } else if (first.isEmpty()) {
            return null;
        } else {
            return loadClassBehavior(context, key, name, relativePath);
        }
    }

    private static Behavior loadSelector(Context context, DataKey key, String name, String relativePath) {
        Collection<Behavior> sub = loadCompositeGoals(context, key.getSubKeys(), relativePath);
        if (sub.isEmpty())
            return null;
        Selector.Builder builder = Selector.selecting(sub).retryChildren(name.contains("-r"));
        if (name.contains("-p")) {
            builder.selectionFunction(Selectors.prioritySelectionFunction());
        }

        return builder.build();
    }

    private static Behavior loadSequence(Context context, DataKey key, String name, String relativePath) {
        boolean retry = name.contains("-r");
        Collection<Behavior> sub = loadCompositeGoals(context, key.getSubKeys(), relativePath);
        if (sub.isEmpty())
            return null;
        return retry ? Sequence.createRetryingSequence(sub) : Sequence.createSequence(sub);
    }

    public static void saveBehaviors(Behavior behavior, Context context, DataKey key) {
        if (behavior instanceof Composite) {
            saveComposite((Composite) behavior, context, key);
        } else {
            String className = behavior.getClass().getName().replace('.', '-');
            PersistenceLoader.save(behavior, key.getRelative(className));
            if (!key.keyExists(className)) {
                key.setString(className, "");
            }
        }
    }

    private static void saveComposite(Composite behavior, Context context, DataKey key) {
        DataKey relative;
        if (behavior instanceof Sequence) {
            relative = key.getRelative("sequence" + (((Sequence) behavior).retryChildren() ? " -r" : ""));
        } else if (behavior instanceof Selector) {
            String sel = "selector";
            Selector selector = (Selector) behavior;
            if (selector.retryChildren()) {
                sel += " -r";
            }
            if (selector.getSelectionFunction() instanceof PrioritySelection) {
                sel += " -p";
            }
            relative = key.getRelative(sel);
        } else {
            relative = key.getRelative("composite " + behavior.getClass().getName().replace('.', '-'));
        }
        for (Behavior sub : behavior.getBehaviors()) {
            saveBehaviors(sub, context, relative);
        }
    }

    private static final Map<String, Class<?>> CLASS_CACHE = new MapMaker().weakValues().makeMap();
    private static final Map<Class<?>, Method> CLASS_METHOD_CACHE = new WeakHashMap<Class<?>, Method>();
}
