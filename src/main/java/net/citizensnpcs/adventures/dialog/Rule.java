package net.citizensnpcs.adventures.dialog;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class Rule implements Comparable<Rule> {
    private final QueryPredicate[] criteria;
    private final String name;
    private final QueryRunnable[] statements;

    private Rule(String name, Collection<QueryRunnable> statements, Collection<QueryPredicate> criteria) {
        this.name = name;
        this.statements = statements.toArray(new QueryRunnable[statements.size()]);
        this.criteria = criteria.toArray(new QueryPredicate[criteria.size()]);
    }

    @Override
    public int compareTo(Rule other) {
        return other.criteria.length - criteria.length;
    }

    public String getFileName() {
        return name.split("/")[0];
    }

    public String getName() {
        return name;
    }

    public int getNumberOfCriteria() {
        return criteria.length;
    }

    // TODO: needs to be abstracted more, perhaps use QueryContext and
    // context.shouldContinueSearch(int matched)
    public int getNumberOfMatches(Query query, int highestScore) {
        if (criteria.length == 0)
            return 1;
        int matched = 0;
        for (int i = 0; i < criteria.length; i++) {
            QueryPredicate criterion = criteria[i];
            switch (criterion.apply(query)) {
                case CANCEL:
                    System.err.println("[r] aborted early due to cancellation, saved " + (criteria.length - i)
                            + " iterations.");
                    return 0;
                case UNMATCHED:
                    break;
                case MATCHED:
                    matched++;
                    break;
            }
            if (highestScore > matched && criteria.length - i < highestScore - matched) {
                System.err.println("[r] aborted search early, saved " + (criteria.length - i) + " iterations.");
                return matched;
            }
        }
        return matched;
    }

    public void run(QueryContext context) {
        for (QueryRunnable statement : statements) {
            statement.run(context);
        }
    }

    @Override
    public String toString() {
        return "Rule [criteria=" + Arrays.toString(criteria) + ", name=" + name + ", statements="
                + Arrays.toString(statements) + "]";
    }

    public static class Builder {
        private final List<QueryPredicate> criteria = Lists.newArrayList();
        private String name;
        private final List<QueryRunnable> statements = Lists.newArrayList();

        public Rule build() {
            Preconditions.checkNotNull(name);
            return new Rule(name, statements, criteria);
        }

        public Builder criterion(QueryPredicate criterion) {
            criteria.add(criterion);
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder statement(QueryRunnable statement) {
            statements.add(statement);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}