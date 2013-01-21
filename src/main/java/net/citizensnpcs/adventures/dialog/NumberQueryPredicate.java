package net.citizensnpcs.adventures.dialog;

import java.util.Comparator;

import javax.annotation.Nullable;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class NumberQueryPredicate implements QueryPredicate {
    private final Predicate<Number> predicate;
    private final String queryKey;

    private NumberQueryPredicate(String queryKey, Predicate<Number> predicate) {
        this.queryKey = queryKey;
        this.predicate = predicate;
    }

    @Override
    public boolean apply(@Nullable Query input) {
        Object object = input.get(queryKey);
        if (object == null)
            return false;
        return predicate.apply(toNumber(object));
    }

    @Override
    public String getQueryKey() {
        return queryKey;
    }

    private static Comparator<Number> DOUBLE_COMPARATOR = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return ((Double) o1).compareTo(o2.doubleValue());
        }
    };

    private static Comparator<Number> FLOAT_COMPARATOR = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return ((Float) o1).compareTo(o2.floatValue());
        }
    };

    private static final Predicate<Integer> GREATER_THAN_OR_EQUAL_PREDICATE = new Predicate<Integer>() {
        @Override
        public boolean apply(@Nullable Integer input) {
            return input >= 0;
        }
    };

    private static final Predicate<Integer> GREATER_THAN_PREDICATE = Predicates.equalTo(1);

    private static Comparator<Number> INTEGER_COMPARATOR = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return ((Integer) o1).compareTo(o2.intValue());
        }
    };

    private static final Predicate<Integer> LESS_THAN_OR_EQUAL_PREDICATE = new Predicate<Integer>() {
        @Override
        public boolean apply(@Nullable Integer input) {
            return input <= 0;
        }
    };

    private static final Predicate<Integer> LESS_THAN_PREDICATE = Predicates.equalTo(-1);

    private static Comparator<Number> LONG_COMPARATOR = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return ((Long) o1).compareTo(o2.longValue());
        }
    };

    private static final Predicate<Integer> NOT_PREDICATE = new Predicate<Integer>() {
        @Override
        public boolean apply(@Nullable Integer input) {
            return input != 0;
        }
    };

    public static QueryPredicate equalTo(String key, final Evaluator evaluator) {
        if (evaluator.isConstant()) {
            return of(key, Predicates.<Number> equalTo(toNumber(evaluator)));
        }
        return of(key, new Predicate<Number>() {
            @Override
            public boolean apply(@Nullable Number input) {
                return toNumber(evaluator).equals(input);
            }
        });
    }

    private static Comparator<Number> getBestComparator(Number number) {
        return number instanceof Long ? LONG_COMPARATOR : number instanceof Integer ? INTEGER_COMPARATOR
                : number instanceof Float ? FLOAT_COMPARATOR : DOUBLE_COMPARATOR;
    }

    private static Predicate<Number> getComparisonPredicate(final Evaluator evaluator, final Predicate<Integer> pred) {
        if (evaluator.isConstant()) {
            final Number number = toNumber(evaluator);
            final Comparator<Number> comparator = getBestComparator(number);
            return new Predicate<Number>() {
                @Override
                public boolean apply(@Nullable Number input) {
                    return pred.apply(comparator.compare(number, input));
                }
            };
        }
        return new Predicate<Number>() {
            @Override
            public boolean apply(@Nullable Number input) {
                final Number number = toNumber(evaluator);
                final Comparator<Number> comparator = getBestComparator(number);
                return pred.apply(comparator.compare(number, input));
            }
        };
    }

    public static QueryPredicate greaterThan(String key, Evaluator evaluator) {
        return of(key, getComparisonPredicate(evaluator, GREATER_THAN_PREDICATE));
    }

    public static QueryPredicate greaterThanOrEqual(String key, Evaluator evaluator) {
        return of(key, getComparisonPredicate(evaluator, GREATER_THAN_OR_EQUAL_PREDICATE));
    }

    public static QueryPredicate lessThan(String key, Evaluator evaluator) {
        return of(key, getComparisonPredicate(evaluator, LESS_THAN_PREDICATE));
    }

    public static QueryPredicate lessThanOrEqual(String key, Evaluator evaluator) {
        return of(key, getComparisonPredicate(evaluator, LESS_THAN_OR_EQUAL_PREDICATE));
    }

    public static QueryPredicate not(String key, Evaluator evaluator) {
        return of(key, getComparisonPredicate(evaluator, NOT_PREDICATE));
    }

    public static <N extends Number & Comparable<N>> QueryPredicate of(String queryKey, Predicate<Number> predicate) {
        return new NumberQueryPredicate(queryKey, predicate);
    }

    private static Number toNumber(Evaluator value) {
        return toNumber(value.get());
    }

    private static Number toNumber(Object object) {
        return object instanceof Number ? (Number) object : object.hashCode();
    }
}
