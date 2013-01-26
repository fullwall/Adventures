package net.citizensnpcs.adventures.dialog.evaluators;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import net.citizensnpcs.adventures.dialog.DialogParserException;

import com.google.common.collect.Lists;

public class ArrayEvaluator {
    private static class ConstantArrayEvaluator implements Evaluator {
        private final Object[] value;

        public ConstantArrayEvaluator(Evaluator[] evaluators) {
            List<Class<?>> commonClasses = getCommonSuperClasses(evaluators);
            if (commonClasses.size() == 0)
                throw new DialogParserException("No common superclass in array " + Arrays.toString(evaluators));
            value = (Object[]) Array.newInstance(commonClasses.get(0), evaluators.length);
            for (int i = 0; i < evaluators.length; i++)
                value[i] = evaluators[i].get();
        }

        @Override
        public Object get() {
            return value;
        }

        @Override
        public boolean isConstant() {
            return true;
        }
    }

    private static class DynamicArrayEvaluator implements Evaluator {
        private final Evaluator[] evaluators;

        public DynamicArrayEvaluator(Evaluator[] evaluators) {
            this.evaluators = evaluators;
        }

        @Override
        public Object get() {
            List<Class<?>> commonClasses = getCommonSuperClasses(evaluators);
            if (commonClasses.size() == 0)
                throw new DialogParserException("No common superclass in array " + Arrays.toString(evaluators));
            Object[] value = (Object[]) Array.newInstance(getClass(), evaluators.length);
            for (int i = 0; i < value.length; i++) {
                value[i] = evaluators[i].get();
            }
            return value;
        }

        @Override
        public boolean isConstant() {
            return false;
        }
    }

    public static Evaluator create(Evaluator... evaluators) {
        for (Evaluator evaluator : evaluators) {
            if (!evaluator.isConstant())
                return new DynamicArrayEvaluator(evaluators);
        }
        return new ConstantArrayEvaluator(evaluators);
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
                for (Class<?> eachInt : each.getInterfaces()) {
                    nextLevel.add(eachInt);
                }
            }
        } while (!nextLevel.isEmpty());
        return classes;
    }

    private static List<Class<?>> getCommonSuperClasses(Evaluator[] evaluators) {
        Set<Class<?>> rollingIntersect = new LinkedHashSet<Class<?>>(getClassesBfs(evaluators[0].get().getClass()));
        for (int i = 1; i < evaluators.length; i++) {
            rollingIntersect.retainAll(getClassesBfs(evaluators[i].get().getClass()));
        }
        return Lists.newArrayList(rollingIntersect);
    }
}
