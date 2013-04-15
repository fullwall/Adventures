package net.citizensnpcs.adventures.util;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.citizensnpcs.adventures.Config;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.Goal;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.BehaviorGoalAdapter;
import net.citizensnpcs.api.ai.tree.BehaviorStatus;
import net.citizensnpcs.api.ai.tree.Selector;
import net.citizensnpcs.api.ai.tree.Selectors;
import net.citizensnpcs.api.ai.tree.Sequence;
import net.citizensnpcs.api.scripting.Script;
import net.citizensnpcs.api.scripting.ScriptFactory;
import net.citizensnpcs.api.util.DataKey;

import com.google.common.collect.Lists;

public class BehaviorLoader {
    public static Goal loadBehaviors(File file, DataKey key) {
        Iterator<DataKey> subKeys = key.getSubKeys().iterator();
        if (!subKeys.hasNext())
            return null;
        final Behavior behavior = loadRecursive(file, subKeys.next());
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

    private static Behavior loadRecursive(File file, DataKey key) {
        String name = key.name();
        String first = name.split(" ")[0];
        if (first.equals("sequence")) {
            boolean retry = name.contains("-r");
            Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());
            return retry ? Sequence.createRetryingSequence(sub) : Sequence.createSequence(sub);
        } else if (first.equals("selector")) {
            Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());
            Selector.Builder builder = Selector.selecting(sub).retryChildren(name.contains("-r"));
            if (name.contains("-p"))
                builder.selectionFunction(Selectors.prioritySelectionFunction());
            return builder.build();
        } else if (first.equals("js")) {
            try {
                ScriptFactory factory = CitizensAPI.getScriptCompiler()
                        .compile(new File(file.getParent(), name.replaceFirst("js", ""))).cache(Config.CACHE_SCRIPTS)
                        .beginWithFuture().get();
                if (factory == null)
                    throw new IllegalStateException("Couldn't load javascript");
                Script s = factory.newInstance();
                Object o = s.convertToInterface(s.invoke("getBehavior", (Object[]) null), Behavior.class);
                if (o == null || !(o instanceof Behavior))
                    throw new IllegalArgumentException("Couldn't convert to Behavior");
                return (Behavior) o;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            String namespacedName = name;
            try {
                Class<?> clazz = Class.forName(namespacedName);
                return (Behavior) clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
