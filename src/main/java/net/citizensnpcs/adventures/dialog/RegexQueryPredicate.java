package net.citizensnpcs.adventures.dialog;

import java.util.regex.Pattern;

import javax.annotation.Nullable;

public class RegexQueryPredicate implements QueryPredicate {
    private final String key;
    private final Pattern regex;

    public RegexQueryPredicate(String key, Pattern regex) {
        this.key = key;
        this.regex = regex;
    }

    @Override
    public boolean apply(@Nullable Query input) {
        Object raw = input.get(key);
        if (!(raw instanceof String))
            throw new DialogException("Expected string for regex but got " + raw);
        return regex.matcher(input.toString()).matches();
    }

    @Override
    public String getQueryKey() {
        return null;
    }

    public static QueryPredicate of(String key, String regex) {
        return new RegexQueryPredicate(key, Pattern.compile(regex));
    }
}
