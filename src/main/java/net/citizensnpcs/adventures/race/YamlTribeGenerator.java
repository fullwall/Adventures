package net.citizensnpcs.adventures.race;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.ai.tree.Behavior;
import net.citizensnpcs.api.ai.tree.Selector;
import net.citizensnpcs.api.ai.tree.Sequence;
import net.citizensnpcs.api.scripting.Script;
import net.citizensnpcs.api.scripting.ScriptFactory;
import net.citizensnpcs.api.util.DataKey;
import net.citizensnpcs.api.util.YamlStorage;

import com.google.common.collect.Lists;

@SuppressWarnings("unused")
class YamlTribeGenerator implements TribeGenerator {
    private final RaceDescriptor race;
    private final YamlStorage storage;

    private YamlTribeGenerator(RaceDescriptor race, YamlStorage storage) {
        this.race = race;
        this.storage = storage;
    }

    static TribeGenerator create(RaceDescriptor race, YamlStorage storage) {
        return new YamlTribeGenerator(race, storage);
    }

    private static Behavior loadBehaviors(File file, DataKey key) {
        Iterator<DataKey> subKeys = key.getSubKeys().iterator();
        if (!subKeys.hasNext())
            return null;
        return loadRecursive(file, subKeys.next());
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
        if (name.startsWith("sequence")) {
            boolean retry = name.contains("retry");
            Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());
            return retry ? Sequence.createRetryingSequence(sub) : Sequence.createSequence(sub);
        } else if (name.startsWith("selector")) {
            Collection<Behavior> sub = loadCompositeGoals(file, key.getSubKeys());
            return Selector.selecting(sub).retryChildren(name.contains("retry")).build();
        } else if (name.startsWith("js")) {
            try {
                ScriptFactory[] factories = CitizensAPI.getScriptCompiler()
                        .compile(new File(file.getParent(), name.replaceFirst("js", ""))).beginWithFuture().get();
                if (factories.length != 1)
                    throw new IllegalStateException("Couldn't load javascript");
                Script s = factories[0].newInstance();
                Object o = s.convertToInterface(null, Behavior.class);
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
