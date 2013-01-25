package net.citizensnpcs.adventures.dialog.statements;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface StatementHandler {
    String name();

    String arguments();
}
