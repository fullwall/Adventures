package net.citizensnpcs.adventures.dialog;

import java.util.regex.Pattern;

import javax.annotation.Nullable;

import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;

public class RegexQueryPredicate implements QueryPredicate {
    private final Evaluator key;
    private final Pattern regex;

    public RegexQueryPredicate(Evaluator key, Pattern regex) {
        this.key = key;
        this.regex = regex;
    }

    @Override
    public boolean apply(@Nullable Query input) {
        Object raw = input.get((String) key.get());
        if (!(raw instanceof String))
            throw new DialogException("Expected string for regex but got " + raw);
        return regex.matcher(input.toString()).matches();
    }

    @Override
    public String getQueryKey() {
        return null;
    }

    public static QueryPredicate of(Evaluator key, String regex) {
        return new RegexQueryPredicate(key, Pattern.compile(regex));
    }
}
