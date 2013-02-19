package net.citizensnpcs.adventures.dialog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class RuleTest {
    private DialogEngine engine;

    @Before
    public void setUp() {
        engine = new DialogEngine();
    }

    @Test
    public void testy() {
        String parse = "rule saidHi {\n" + "    criteria events=onchat $message=\"Hi!\";\n" + "    response sayHi;\n"
                + "}\n" + "response sayHi {\n" + "    say message:\"Hello, ${sender.name}!\", target:$sender;\n" + "}";
        engine.parse(parse);
        Map<String, Object> query = Maps.newHashMap();
        query.put("message", "Hi!");
        query.put("sender", "log");
        query.put("sender.name", "log");
        boolean success = engine.execute(new AbstractQuery("onchat", query) {
            @Override
            public void remember(String key, Object value, ExpirationTime time) {
            }
        });
        assertThat(success, is(true));
    }

    @Test
    public void testCompetingQuery() {
        String parse = "rule test {" + "\n  criteria events=onchat $message='test';" + "\n  response test2;" + "\n}"
                + "\nrule test2 {" + "\n  criteria events=onchat $message='test' $test=1;" + "\n  response test2;"
                + "\n}" + "\nresponse test2 {" + "\n  say 'Hello, dialog world!', target:\"log\";" + "\n}";
        engine.parse(parse);
        Map<String, Object> query = Maps.newHashMap();
        query.put("message", "test");
        query.put("test", 1);
        boolean success = engine.execute(new AbstractQuery("onchat", query) {
            @Override
            public void remember(String key, Object value, ExpirationTime time) {
            }
        });
        assertThat(success, is(true));
    }

    @Test
    public void testRemember() {
        String parse = "rule test {" + "\ncriteria events=onchat $message='test';" + "\nresponse test2;" + "\n  }"
                + "\nresponse test2 {" + "\nremember $r:true;" + "\n}";
        engine.parse(parse);
        final Map<String, Object> query = Maps.newHashMap();
        query.put("message", "test");
        boolean success = engine.execute(new AbstractQuery("onchat", query) {
            @Override
            public void remember(String key, Object value, ExpirationTime time) {
                query.put(key, value);
            }
        });
        assertThat(success, is(true));
        assertThat(query.containsKey("r"), is(true));
    }

    @Test
    public void testSimpleQuery() {
        String parse = "rule test {" + "\ncriteria events=onchat $message='test';" + "\nresponse test2;" + "\n  }"
                + "\nresponse test2 {" + "\nsay 'Hello, dialog world!', target:\"log\";" + "\n}";
        engine.parse(parse);
        Map<String, Object> query = Maps.newHashMap();
        query.put("message", "test");
        boolean success = engine.execute(new AbstractQuery("onchat", query) {
            @Override
            public void remember(String key, Object value, ExpirationTime time) {
            }
        });
        assertThat(success, is(true));
    }
}
