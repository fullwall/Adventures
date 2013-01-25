package net.citizensnpcs.adventures.dialog;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import net.citizensnpcs.adventures.dialog.statements.StatementContext;
import net.citizensnpcs.adventures.dialog.statements.StatementHandler;
import net.citizensnpcs.adventures.dialog.statements.StatementRegistry;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

public class FunctionTest {
    private StatementRegistry registry;

    @Before
    public void setUp() {
        registry = new StatementRegistry();
    }

    @Test
    public void checksLegality() {
        try {
            registry.register(Illegal.class);
            fail();
        } catch (IllegalArgumentException iae) {
        }
        try {
            registry.register(Illegal2.class);
            fail();
        } catch (IllegalArgumentException iae) {
        }
    }

    @Test
    public void runs() {
        registry.register(Runs.class);
        assertThat(registry.getMatchingStatement("fake", Sets.newHashSet("test", "opt")), equalTo(null));
        assertThat(registry.getMatchingStatement("test", Sets.newHashSet("opt")), equalTo(null));
        assertThat(registry.getMatchingStatement("test", Sets.newHashSet("test")), not(equalTo(null)));
        assertThat(registry.getMatchingStatement("test", Sets.newHashSet("test", "opt")), not(equalTo(null)));
        assertThat(registry.getMatchingStatement("test2", Sets.newHashSet("a", "b", "c", "d", "e", "f", "g")),
                not(equalTo(null)));
    }

    public static class Illegal {
        @StatementHandler(name = "il", arguments = "legal")
        public static void test() {
        }
    }

    public static class Illegal2 {
        @StatementHandler(name = "il", arguments = "[legal")
        public static void test(QueryContext query, StatementContext statement) {
        }
    }

    public static class Runs {
        @StatementHandler(name = "test", arguments = "[test] (opt)")
        public static void test(QueryContext query, StatementContext statement) {
        }

        @StatementHandler(name = "test2", arguments = "a [b] c [d] [e] f g")
        public static void test2(QueryContext query, StatementContext statement) {
        }
    }
}
