package net.citizensnpcs.adventures.dialog;

import java.util.Comparator;

import javax.annotation.Nullable;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class NumberQueryPredicate implements QueryPredicate {
    private final Predicate<Number> predicate;
    private final Evaluator queryKey;
    private final boolean required;

    private NumberQueryPredicate(Evaluator queryKey, Predicate<Number> predicate, boolean required) {
        this.queryKey = queryKey;
        this.predicate = predicate;
        this.required = required;
    }

    @Override
    public MatchResult apply(Query input) {
        Object object = input.get((String) queryKey.get());
        if (object == null)
            return MatchResult.CANCEL;
        return predicate.apply(toNumber(object)) ? MatchResult.MATCHED : required ? MatchResult.CANCEL
                : MatchResult.UNMATCHED;
    }

    @Override
    public String toString() {
        return "NumberQueryPredicate [predicate=" + predicate + ", queryKey=" + queryKey + "]";
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

        @Override
        public String toString() {
            return "NumberQueryPredicate [>=]";
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

        @Override
        public String toString() {
            return "NumberQueryPredicate [<=]";
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

        @Override
        public String toString() {
            return "NumberQueryPredicate [!=]";
        }
    };

    public static QueryPredicate equalTo(Evaluator key, final Evaluator evaluator, boolean required) {
        if (evaluator.isConstant()) {
            return of(key, Predicates.<Number> equalTo(toNumber(evaluator)), required);
        }
        return of(key, new Predicate<Number>() {
            @Override
            public boolean apply(@Nullable Number input) {
                return toNumber(evaluator).equals(input);
            }

            @Override
            public String toString() {
                return "NumberQueryPredicate [==]";
            }
        }, required);
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

                @Override
                public String toString() {
                    return "DelegatingPredicate [" + pred + "]";
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

            @Override
            public String toString() {
                return "DelegatingPredicate [" + pred + "]";
            }
        };
    }

    public static QueryPredicate greaterThan(Evaluator key, Evaluator evaluator, boolean required) {
        return of(key, getComparisonPredicate(evaluator, GREATER_THAN_PREDICATE), required);
    }

    public static QueryPredicate greaterThanOrEqual(Evaluator key, Evaluator evaluator, boolean required) {
        return of(key, getComparisonPredicate(evaluator, GREATER_THAN_OR_EQUAL_PREDICATE), required);
    }

    public static QueryPredicate lessThan(Evaluator key, Evaluator evaluator, boolean required) {
        return of(key, getComparisonPredicate(evaluator, LESS_THAN_PREDICATE), required);
    }

    public static QueryPredicate lessThanOrEqual(Evaluator key, Evaluator evaluator, boolean required) {
        return of(key, getComparisonPredicate(evaluator, LESS_THAN_OR_EQUAL_PREDICATE), required);
    }

    public static QueryPredicate not(Evaluator key, Evaluator evaluator, boolean required) {
        return of(key, getComparisonPredicate(evaluator, NOT_PREDICATE), required);
    }

    public static QueryPredicate of(Evaluator queryKey, Predicate<Number> predicate, boolean required) {
        return new NumberQueryPredicate(queryKey, predicate, required);
    }

    private static Number toNumber(Evaluator value) {
        return toNumber(value.get());
    }

    private static Number toNumber(Object object) {
        return object == null ? 0 : object instanceof Number ? (Number) object : object.hashCode();
    }
}
