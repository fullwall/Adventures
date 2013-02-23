package net.citizensnpcs.adventures.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;

import com.google.common.collect.Lists;

public class Util {
    private static final List<Class<?>> OBJECT = Arrays.<Class<?>> asList(Object.class);

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
}
