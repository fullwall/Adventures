package net.citizensnpcs.adventures.util;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import com.google.common.collect.Lists;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;

public class Util {
    public static <T> T createUnsafeInstance(Class<? extends T> clazz) {
        @SuppressWarnings("unchecked")
        Constructor<? extends T> cache = (Constructor<? extends T>) CONSTRUCTOR_CACHE.get(clazz);
        if (cache == null) {
            try {
                cache = clazz.getDeclaredConstructor();
                cache.setAccessible(true);
                CONSTRUCTOR_CACHE.put(clazz, cache);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        try {
            return cache.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Set<Class<?>> getClassesBfs(Class<?> clazz) {
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        Set<Class<?>> nextLevel = new LinkedHashSet<Class<?>>();
        nextLevel.add(clazz);
        do {
            classes.addAll(nextLevel);
            Set<Class<?>> thisLevel = new LinkedHashSet<Class<?>>(nextLevel);
            nextLevel.clear();
            for (Class<?> each : thisLevel) {
                Class<?> superClass = each.getSuperclass();
                if (superClass != null && superClass != Object.class) {
                    nextLevel.add(superClass);
                }
                nextLevel.addAll(Arrays.asList(each.getInterfaces()));
            }
        } while (!nextLevel.isEmpty());
        return classes;
    }

    public static List<Class<?>> getCommonSuperClasses(VariableSource variables, Collection<Evaluator> evaluators) {
        if (evaluators.isEmpty())
            return OBJECT;

        Iterator<Evaluator> itr = evaluators.iterator();
        Set<Class<?>> rollingIntersect = new LinkedHashSet<Class<?>>(
                getClassesBfs(itr.next().get(variables).getClass()));
        while (itr.hasNext()) {
            rollingIntersect.retainAll(getClassesBfs(itr.next().get(variables).getClass()));
        }
        return Lists.newArrayList(rollingIntersect);
    }

    public static List<Class<?>> getCommonSuperClasses(VariableSource variables, Evaluator... evaluators) {
        return getCommonSuperClasses(variables, Arrays.asList(evaluators));
    }

    public static EntityType getRandomLivingType() {
        EntityType[] types = EntityType.values();
        Random random = new Random();
        EntityType chosen = null;
        while (chosen == null || !LivingEntity.class.isAssignableFrom(chosen.getEntityClass())) {
            chosen = types[random.nextInt(types.length)];
        }
        return chosen;
    }

    private static final Map<Class<?>, Constructor<?>> CONSTRUCTOR_CACHE = new HashMap<Class<?>, Constructor<?>>();
    private static final List<Class<?>> OBJECT = Arrays.<Class<?>> asList(Object.class);
}
