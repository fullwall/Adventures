package net.citizensnpcs.adventures.dialog;

import java.util.Comparator;

import javax.annotation.Nullable;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.adventures.dialog.evaluators.VariableSource;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

public class NumberQueryPredicate implements QueryPredicate {
    private final Matcher predicate;
    private final Evaluator queryKey;
    private final boolean required;

    private NumberQueryPredicate(Evaluator queryKey, Matcher predicate, boolean required) {
        this.queryKey = queryKey;
        this.predicate = predicate;
        this.required = required;
    }

    @Override
    public MatchResult apply(Query input) {
        Object object = input.get((String) queryKey.get(input));
        if (object == null)
            return MatchResult.CANCEL;
        if (object instanceof Evaluator)
            object = ((Evaluator) object).get(input);
        return predicate.matches(input, object) ? MatchResult.MATCHED : required ? MatchResult.CANCEL
                : MatchResult.UNMATCHED;
    }

    @Override
    public String toString() {
        return "NumberQueryPredicate [predicate=" + predicate + ", queryKey=" + queryKey + "]";
    }

    private static interface Matcher {
        boolean matches(VariableSource variables, Object variable);
    }

    private static final Matcher ALWAYS_TRUE = new Matcher() {
        @Override
        public boolean matches(VariableSource variables, Object variable) {
            return true;
        }
    };

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

    public static QueryPredicate alwaysTrue(Evaluator evaluator, boolean required) {
        return of(evaluator, ALWAYS_TRUE, required);
    }

    public static QueryPredicate equalTo(Evaluator key, final Evaluator evaluator, boolean required) {
        if (evaluator.isConstant()) {
            final Object constant = evaluator.get(null);
            return of(key, new Matcher() {
                @Override
                public boolean matches(VariableSource variables, Object variable) {
                    return variable.equals(constant);
                }

                @Override
                public String toString() {
                    return "NumberQueryPredicate [==]";
                }
            }, required);
        }
        return of(key, new Matcher() {
            @Override
            public boolean matches(VariableSource variables, Object variable) {
                return variable.equals(evaluator.get(variables));
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

    private static Matcher getComparisonPredicate(final Evaluator evaluator, final Predicate<Integer> pred) {
        if (evaluator.isConstant()) {
            final Number number = toNumber(evaluator.get(null));
            final Comparator<Number> comparator = getBestComparator(number);
            return new Matcher() {
                @Override
                public boolean matches(VariableSource variables, Object variable) {
                    return pred.apply(comparator.compare(toNumber(variable), number));
                }

                @Override
                public String toString() {
                    return "DelegatingPredicate [" + pred + "]";
                }
            };
        }
        return new Matcher() {

            @Override
            public boolean matches(VariableSource variables, Object variable) {
                final Number number = toNumber(variable);
                final Comparator<Number> comparator = getBestComparator(number);
                return pred.apply(comparator.compare(number, toNumber(evaluator.get(variables))));
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

    public static QueryPredicate of(Evaluator queryKey, Matcher predicate, boolean required) {
        return new NumberQueryPredicate(queryKey, predicate, required);
    }

    private static Number toNumber(Object object) {
        return object == null ? 0 : object instanceof Number ? (Number) object : object.hashCode();
    }
}
