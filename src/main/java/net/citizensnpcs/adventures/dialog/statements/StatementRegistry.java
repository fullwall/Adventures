package net.citizensnpcs.adventures.dialog.statements;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.evaluators.Evaluator;
import net.citizensnpcs.api.command.Injector;

import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class StatementRegistry {
    // @DialogStatement(name="log", arguments=""})
    private Injector injector;
    private final ListMultimap<String, DialogStatement> statements = ArrayListMultimap.create();

    public QueryRunnable getMatchingStatement(ParseContext parseContext, String statementName,
            Map<String, Evaluator> vars) {
        Collection<DialogStatement> matchingTopLevel = statements.get(statementName);
        if (matchingTopLevel == null)
            return null;
        for (DialogStatement entry : matchingTopLevel) {
            QueryRunnable runnable = entry.tryMatch(parseContext, statementName, vars);
            if (runnable != null)
                return runnable;
        }
        return null;
    }

    private boolean methodTypesMatch(Class<?> returnType, Class<?>[] parameterTypes) {
        return Arrays.equals(parameterTypes, EXPECTED_PARAMETER_TYPES)
                && QueryRunnable.class.isAssignableFrom(returnType);
    }

    public void register(Class<?> clazz) {
        registerMethods(clazz, injector == null ? null : injector.getInstance(clazz));
    }

    private void registerMethods(Class<?> clazz, Object instance) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!method.isAnnotationPresent(StatementHandler.class))
                continue;
            method.setAccessible(true);

            if (!methodTypesMatch(method.getReturnType(), method.getParameterTypes())) {
                throw new IllegalArgumentException("Illegal method signature: " + method.getName() + " in class "
                        + clazz.getSimpleName());
            }

            if (!Modifier.isStatic(method.getModifiers())) {
                if (instance == null)
                    continue;
            }

            StatementHandler annotation = method.getAnnotation(StatementHandler.class);
            registerStatement(instance, method, annotation);
        }
    }

    private void registerStatement(Object instance, Method method, StatementHandler annotation) {
        ArgumentFormat descriptor = new ArgumentFormat(annotation.arguments());
        DialogStatement stmt = new DialogStatement(instance, method, descriptor);
        for (String name : Splitter.on('|').split(annotation.name())) {
            statements.put(name, stmt);
        }
    }

    public void setInjector(Injector injector) {
        this.injector = injector;
    }

    public class DialogStatement {
        private final ArgumentFormat format;
        private final Object instance;
        private final Method method;

        private DialogStatement(Object instance, Method method, ArgumentFormat format) {
            this.method = method;
            this.instance = instance;
            this.format = format;
        }

        public QueryRunnable tryMatch(ParseContext parseContext, String name, Map<String, Evaluator> vars) {
            StatementContext statementContext = format.createStatementContext(name, vars);
            if (statementContext == null)
                return null;
            try {
                QueryRunnable runnable = (QueryRunnable) method.invoke(instance, parseContext, statementContext);
                return runnable;
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static final Class<?>[] EXPECTED_PARAMETER_TYPES = { ParseContext.class, StatementContext.class };
}
