package net.citizensnpcs.adventures.dialog.statements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javassist.Modifier;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.api.command.Injector;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;

public class StatementRegistry {

    // @DialogStatement(name="log", arguments=""})
    private Injector injector;
    private final Map<Method, Object> instances = Maps.newHashMap();
    private final ListMultimap<String, DialogStatement> statements = ArrayListMultimap.create();

    public void register(Class<?> clazz) {
        registerMethods(clazz, injector == null ? null : injector.getInstance(clazz));
    }

    public DialogStatement getMatchingStatement(String statementName, Set<String> keys) {
        if (!statements.containsKey(statementName))
            return null;
        for (DialogStatement entry : statements.values()) {
            if (entry.format.matches(keys))
                return entry;
        }
        return null;
    }

    private void registerMethods(Class<?> clazz, Object instance) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(StatementHandler.class))
                continue;
            method.setAccessible(true);

            if (!methodTypesMatch(method.getParameterTypes())) {
                throw new IllegalArgumentException("Illegal method parameters: " + method.getName() + " in class "
                        + clazz.getSimpleName());
            }

            if (!Modifier.isStatic(method.getModifiers())) {
                if (instance == null)
                    continue;
                instances.put(method, instance);
            }

            StatementHandler annotation = method.getAnnotation(StatementHandler.class);
            registerStatement(method, annotation);
        }
    }

    private static final Class<?>[] EXPECTED_PARAMETER_TYPES = { QueryContext.class, StatementContext.class };

    private boolean methodTypesMatch(Class<?>[] parameterTypes) {
        return Arrays.equals(parameterTypes, EXPECTED_PARAMETER_TYPES);
    }

    private void registerStatement(Method method, StatementHandler annotation) {
        ArgumentFormat descriptor = new ArgumentFormat(annotation.arguments());
        statements.put(annotation.name(), new DialogStatement(method, descriptor));
    }

    public void setInjector(Injector injector) {
        this.injector = injector;
    }

    public class DialogStatement {
        private final Method method;
        private final ArgumentFormat format;

        private DialogStatement(Method method, ArgumentFormat format) {
            this.method = method;
            this.format = format;
        }

        public boolean execute(QueryContext context, Map<String, Evaluator> vars) {
            try {
                method.invoke(instances.get(method), context, format.createStatementContext(vars));
                return true;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
