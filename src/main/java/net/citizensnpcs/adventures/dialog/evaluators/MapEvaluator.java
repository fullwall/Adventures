package net.citizensnpcs.adventures.dialog.evaluators;

import java.util.List;
import java.util.Map;

import net.citizensnpcs.adventures.dialog.DialogParserException;
import net.citizensnpcs.adventures.util.Util;

import com.google.common.collect.Maps;

public class MapEvaluator {
    private static class ConstantMapEvaluator implements Evaluator {
        private final Map<String, Object> value;

        public ConstantMapEvaluator(Map<String, Evaluator> evaluators) {
            List<Class<?>> commonClasses = Util.getCommonSuperClasses(evaluators.values());
            if (commonClasses.size() == 0)
                throw new DialogParserException("No common superclass in map " + evaluators);
            value = Maps.newHashMap();
            for (Map.Entry<String, Evaluator> entry : evaluators.entrySet())
                value.put(entry.getKey(), entry.getValue().get());
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

    private static class DynamicMapEvaluator implements Evaluator {
        private final Map<String, Evaluator> evaluators;

        public DynamicMapEvaluator(Map<String, Evaluator> evaluators) {
            this.evaluators = evaluators;
        }

        @Override
        public Object get() {
            List<Class<?>> commonClasses = Util.getCommonSuperClasses(evaluators.values());
            if (commonClasses.size() == 0)
                throw new DialogParserException("No common superclass in map " + evaluators);
            Map<String, Object> value = Maps.newHashMap();
            for (Map.Entry<String, Evaluator> entry : evaluators.entrySet()) {
                value.put(entry.getKey(), entry.getValue().get());
            }
            return value;
        }

        @Override
        public boolean isConstant() {
            return false;
        }
    }

    public static Evaluator create(Map<String, Evaluator> evaluators) {
        for (Map.Entry<String, Evaluator> entry : evaluators.entrySet()) {
            if (!entry.getValue().isConstant())
                return new DynamicMapEvaluator(evaluators);
        }
        return new ConstantMapEvaluator(evaluators);
    }
}
