package net.citizensnpcs.adventures.dialog.statements;

import java.util.Collection;

import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class SequentialRandomSelector implements QueryRunnable {
    private final RandomEntry[] choices;

    private SequentialRandomSelector(Collection<RandomEntry> choices) {
        this.choices = choices.toArray(new RandomEntry[choices.size()]);
    }

    @Override
    public void run(QueryContext context) {
        for (RandomEntry choice : choices) {
            if (Math.random() < choice.probability) {
                choice.choice.run(context);
                break;
            }
        }
    }

    public static class Builder {
        private final Collection<RandomEntry> choices = Lists.newArrayList();

        public SequentialRandomSelector build() {
            return new SequentialRandomSelector(choices);
        }

        public Builder choice(QueryRunnable choice, double probability) {
            Preconditions.checkArgument(probability <= 1.0 && probability >= 0.0,
                    "probability must be a number between 0 and 1");
            choices.add(new RandomEntry(choice, probability));
            return this;
        }
    }

    private static class RandomEntry {
        QueryRunnable choice;

        double probability;
        private RandomEntry(QueryRunnable choice, double probability) {
            this.choice = choice;
            this.probability = probability;
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
