package net.citizensnpcs.adventures.dialog;

import java.util.regex.Pattern;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

public class RegexQueryPredicate implements QueryPredicate {
    private final Evaluator key;
    private final Pattern regex;
    private final boolean required;

    public RegexQueryPredicate(Evaluator key, Pattern regex, boolean required) {
        this.key = key;
        this.regex = regex;
        this.required = required;
    }

    @Override
    public MatchResult apply(Query input) {
        Object raw = input.get((String) key.get(input));
        if (raw == null)
            return MatchResult.CANCEL;
        if (!(raw instanceof String))
            throw new DialogException("Expected string for regex but got " + raw);
        return regex.matcher(input.toString()).matches() ? MatchResult.MATCHED : required ? MatchResult.CANCEL
                : MatchResult.UNMATCHED;
    }

    public static QueryPredicate of(Evaluator key, String regex, boolean required) {
        return new RegexQueryPredicate(key, Pattern.compile(regex), required);
    }
}
