package net.citizensnpcs.adventures.dialog;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

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

    private Number toNumber(Object toConvert) {
        return toConvert instanceof Number ? (Number) toConvert : toConvert.hashCode();
    }

    public static QueryPredicate of(String queryKey, Predicate<Number> predicate) {
        return new NumberQueryPredicate(queryKey, predicate);
    }

    @Override
    public String getQueryKey() {
        return queryKey;
    }
}
