package net.citizensnpcs.adventures.dialog;

import java.util.Collection;
import java.util.List;

import com.google.common.collect.Lists;

public class Rule implements Comparable<Rule> {
    private final QueryPredicate[] criteria;
    private final QueryRunnable[] statements;

    private Rule(Collection<QueryRunnable> statements, Collection<QueryPredicate> criteria) {
        this.statements = statements.toArray(new QueryRunnable[statements.size()]);
        this.criteria = criteria.toArray(new QueryPredicate[criteria.size()]);
    }

    public void run(QueryContext context) {
        for (QueryRunnable statement : statements) {
            statement.run(context);
        }
    }

    @Override
    public int compareTo(Rule other) {
        return other.criteria.length - criteria.length;
    }

    public int getNumberOfCriteria() {
        return criteria.length;
    }

    // TODO: needs to be abstracted more, perhaps use QueryContext and
    // context.shouldContinueSearch(int matched)
    public int getNumberOfMatches(Query query, int highestScore) {
        int matched = 0;
        for (int i = 0; i < criteria.length; i++) {
            QueryPredicate criterion = criteria[i];
            if (!query.contains(criterion.getQueryKey())) {
                System.err.println("[r] aborted early due to missing key " + criterion.getQueryKey()
                        + ", saved " + (criteria.length - i) + " iterations.");
                return 0;
            }
            if (criterion.apply(query))
                matched++;
            if (highestScore > matched && criteria.length - i < highestScore - matched) {
                System.err.println("[r] aborted search early, saved " + (criteria.length - i)
                        + " iterations.");
                return matched;
            }
        }
        return matched;
    }

    public static class Builder {
        private final List<QueryRunnable> statements = Lists.newArrayList();
        private final List<QueryPredicate> criteria = Lists.newArrayList();

        public Rule build() {
            return new Rule(statements, criteria);
        }

        public Builder statement(QueryRunnable statement) {
            statements.add(statement);
            return this;
        }

        public Builder criterion(QueryPredicate criterion) {
            criteria.add(criterion);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}