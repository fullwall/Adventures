package net.citizensnpcs.adventures.dialog;


public interface QueryPredicate {
    MatchResult apply(Query query);

    public enum MatchResult {
        CANCEL,
        MATCHED,
        UNMATCHED;
    }
}
