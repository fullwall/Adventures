package net.citizensnpcs.adventures.dialog.statements;

import java.util.Random;
import java.util.Set;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.LoaderClassPath;
import javassist.NotFoundException;

import javax.script.ScriptException;

import net.citizensnpcs.adventures.dialog.DialogEngine.ParseContext;
import net.citizensnpcs.adventures.dialog.DialogException;
import net.citizensnpcs.adventures.dialog.QueryContext;
import net.citizensnpcs.adventures.dialog.QueryRunnable;
import net.citizensnpcs.adventures.dialog.statements.StatementContext.Locals;
import net.citizensnpcs.api.CitizensAPI;

import com.google.common.collect.Sets;

public class Code implements QueryRunnable {
    private final String extension;
    private final StatementContext statementContext;

    private Code(String extension, StatementContext statementContext) {
        this.extension = extension;
        this.statementContext = statementContext;
    }

    @Override
    public void run(QueryContext context) {
        Locals locals = statementContext.createLocals(context.getQuery());
        String code = locals.getRequired("code", String.class);
        try {
            CitizensAPI.getScriptCompiler().run(code, extension, locals.getMap());
        } catch (ScriptException e) {
            throw new DialogException(e);
        }
    }

    private static class JavaCode implements QueryRunnable {
        private Runnable instance;
        private final StatementContext statementContext;

        public JavaCode(StatementContext statementContext) {
            this.statementContext = statementContext;
        }

        private Class<? extends Runnable> generateClass(String code) throws CannotCompileException, NotFoundException {
            CtClass ct = CLASS_POOL.makeClass(randomIdentifier(10));
            ct.addInterface(CLASS_POOL.get("java.lang.Runnable"));
            CtMethod method = CtNewMethod.make("public void run(){}", ct);
            method.setBody(code);
            ct.addMethod(method);
            @SuppressWarnings("unchecked")
            Class<? extends Runnable> clazz = ct.toClass();
            return clazz;
        }

        @Override
        public void run(QueryContext context) {
            String code = statementContext.getRequired(context.getQuery(), "code", String.class);
            if (instance == null) {
                try {
                    instance = generateClass(code).newInstance();
                } catch (Exception e) {
                    throw new DialogException(e);
                }
            }
            instance.run();
        }

        private static final String LEXICON = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private static final Random RAND = new Random();
        private static final Set<String> USED_IDENTIFIERS = Sets.newHashSet();

        private static String randomIdentifier(int length) {
            StringBuilder builder = new StringBuilder();
            while (builder.toString().length() == 0) {
                for (int i = 0; i < length; i++)
                    builder.append(LEXICON.charAt(RAND.nextInt(LEXICON.length())));
                if (USED_IDENTIFIERS.contains(builder.toString()))
                    builder = new StringBuilder();
            }
            USED_IDENTIFIERS.add(builder.toString());
            System.err.println(builder.toString());
            return builder.toString();
        }
    }

    private static final ClassPool CLASS_POOL = ClassPool.getDefault();

    @StatementBuilder(name = "js|py|lua|rb|clj|scala", arguments = "[code]")
    public static QueryRunnable code(ParseContext parseContext, StatementContext statementContext) {
        return new Code(statementContext.getName(), statementContext);
    }

    @StatementBuilder(name = "java", arguments = "[code]")
    public static QueryRunnable javaCode(ParseContext parseContext, StatementContext statementContext) {
        return new JavaCode(statementContext);
    }

    static {
        CLASS_POOL.appendClassPath(new LoaderClassPath(Code.class.getClassLoader()));
        CLASS_POOL.importPackage("org.bukkit");
    }
}
