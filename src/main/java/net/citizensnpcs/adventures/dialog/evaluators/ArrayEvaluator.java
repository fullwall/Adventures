package net.citizensnpcs.adventures.dialog.evaluators;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import net.citizensnpcs.adventures.dialog.DialogParserException;
import net.citizensnpcs.adventures.util.Util;

public class ArrayEvaluator {
    private static class DynamicArrayEvaluator implements Evaluator {
        private final Evaluator[] evaluators;

        public DynamicArrayEvaluator(Evaluator[] evaluators) {
            this.evaluators = evaluators;
        }

        @Override
        public Object get() {
            List<Class<?>> commonClasses = Util.getCommonSuperClasses(evaluators);
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

    public static Evaluator create(Evaluator[] evaluators) {
        for (Evaluator evaluator : evaluators) {
            if (!evaluator.isConstant())
                return new DynamicArrayEvaluator(evaluators);
        }
        List<Class<?>> commonClasses = Util.getCommonSuperClasses(evaluators);
        if (commonClasses.size() == 0)
            throw new DialogParserException("No common superclass in array " + Arrays.toString(evaluators));
        Object[] value = (Object[]) Array.newInstance(commonClasses.get(0), evaluators.length);
        for (int i = 0; i < evaluators.length; i++)
            value[i] = evaluators[i].get();
        return ConstantEvaluator.create(value);
    }

    public static Evaluator create(Collection<Evaluator> array) {
        return create(array.toArray(new Evaluator[array.size()]));
    }
}
