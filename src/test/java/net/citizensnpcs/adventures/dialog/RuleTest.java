package net.citizensnpcs.adventures.dialog;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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
    public void testSimpleQuery() {
        String parse = "rule test {" + "\ncriteria events=onchat message='test';" + "\nresponse test2;" + "\n  }"
                + "\nresponse test2 {" + "\nlog 'Hello, dialog world!';" + "\n}";
        engine.load(parse);
        Map<String, Object> query = Maps.newHashMap();
        query.put("message", "test");
        boolean success = engine.execute(new AbstractQuery("onchat", query) {
            @Override
            public void remember(String key, Object value, long expiration, TimeUnit unit) {
            }
        });
        assertThat(success, is(true));
    }
}
