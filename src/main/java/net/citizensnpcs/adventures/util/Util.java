package net.citizensnpcs.adventures.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

import com.google.common.collect.Lists;

public class Util {
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
                for (Class<?> eachInt : each.getInterfaces()) {
                    nextLevel.add(eachInt);
                }
            }
        } while (!nextLevel.isEmpty());
        return classes;
    }

    public static List<Class<?>> getCommonSuperClasses(Evaluator... evaluators) {
        return getCommonSuperClasses(Arrays.asList(evaluators));
    }

    public static List<Class<?>> getCommonSuperClasses(Collection<Evaluator> evaluators) {
        List<Evaluator> list = evaluators instanceof List ? (List<Evaluator>) evaluators : Lists
                .newArrayList(evaluators);
        Set<Class<?>> rollingIntersect = new LinkedHashSet<Class<?>>(getClassesBfs(list.get(0).getClass()));
        for (int i = 1; i < evaluators.size(); i++) {
            rollingIntersect.retainAll(getClassesBfs(list.get(i).getClass()));
        }
        return Lists.newArrayList(rollingIntersect);
    }
}
