package net.citizensnpcs.adventures.dialog;

import com.google.common.base.Predicate;

public interface QueryPredicate extends Predicate<Query> {
    String getQueryKey();
}
