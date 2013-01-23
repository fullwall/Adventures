grammar Dialog;

options {
    language     = Java;
}
@rulecatch {
catch (RecognitionException e) {
    throw e;
}
}

@header {
package net.citizensnpcs.adventures.dialog;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import com.google.common.base.Predicates;
import net.citizensnpcs.adventures.dialog.*;
import net.citizensnpcs.adventures.dialog.statements.*;
import net.citizensnpcs.adventures.dialog.evaluators.*;
}

@members {
/*  @Override
    public void reportError(RecognitionException e) {
        throw e;
    }
*/
private VariableSource variableSource;

public void setVariableSource(VariableSource source) {
    this.variableSource = source;
}
}

@lexer::header {
package net.citizensnpcs.adventures.dialog;
import java.util.concurrent.TimeUnit;
}

@lexer::members {
/*  @Override
    public void reportError(RecognitionException e) {
        throw e;
    }
*/
}

program [DialogEngine.ParseContext context] :
    (
        rule[context] { $context.ruleLoaded($rule.eventNames, $rule.rule); }
        | response[context] { $context.responseLoaded($response.response); }
    )*;

response [DialogEngine.ParseContext context] returns [Response response] :
    { Response.Builder builder = Response.builder(); } 
    'response' IDENT { builder.name(context.disambiguateName($IDENT.text)); } '{' (response_statement[context, builder] ';')* '}'
    { $response = builder.build(); }
    ;

response_statement [DialogEngine.ParseContext context, Response.Builder builder] :
    'log' expression { builder.statement(Log.logging($expression.value)); }
    | remember_statement { builder.statement($remember_statement.statement); } 
    ;

rule [DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule]:
    { Rule.Builder builder = Rule.builder(); }
    'rule' IDENT { builder.name(context.disambiguateName($IDENT.text)); } '{' criteria { $eventNames = $criteria.eventNames; } ';' (rule_statement[context, builder] ';')* '}'
    { $rule = builder.build(); }
    ;
    
rule_statement [DialogEngine.ParseContext context, Rule.Builder builder] :
    ('response' n=IDENT { CallResponse.Builder responseBuilder = CallResponse.builder(context.disambiguateName($n.text)); } 
        ('then' (target=IDENT | target=NUMBER) event=IDENT { responseBuilder.callback(new CallEventCallback(context.disambiguateName($target.text), $event.text)); })? 
        { builder.statement(responseBuilder.build()); })
    | remember_statement { builder.statement($remember_statement.statement); }
    ;

remember_statement returns [QueryRunnable statement] :
    { Remember.Builder builder = Remember.builder(); }
    'remember' remember_assignment[builder] (',' remember_assignment[builder])*
    { $statement = builder.build(); }
    ;

remember_assignment [Remember.Builder builder] :
    { boolean isPersistent = false; }
    QUERY_STRING '=' expression i1=INTEGER i2=time_unit ('-p' { isPersistent = true; })? 
        { builder.remember($QUERY_STRING.text, $expression.value, ExpirationTime.expiringAt(Long.parseLong($INTEGER.text), $i2.unit, isPersistent)); } 
    ;
    
criteria returns [Collection<String> eventNames]:
    { $eventNames = new ArrayList<String>(); }
    'criteria' ('events=' e1=IDENT  { $eventNames.add($e1.text); } (',' e2=IDENT { $eventNames.add($e2.text); })* )
    (
        i1=IDENT '=' op1=expression { NumberQueryPredicate.equalTo($i1.text, $op1.value); }
        | i2=IDENT '>' op2=expression { NumberQueryPredicate.greaterThan($i2.text, $op2.value); }
        | i3=IDENT '<' op3=expression { NumberQueryPredicate.lessThan($i3.text, $op3.value); }
        | i4=IDENT '<=' op4=expression { NumberQueryPredicate.lessThanOrEqual($i4.text, $op4.value); }
        | i5=IDENT '>=' op5=expression { NumberQueryPredicate.greaterThanOrEqual($i5.text, $op5.value); }
        | i6=IDENT '!=' op6=expression { NumberQueryPredicate.not($i6.text, $op6.value);}
        | i7=IDENT { NumberQueryPredicate.of($i7.text, Predicates.<Number>alwaysTrue()); }
    )*;
    
expression returns [Evaluator value] :
    op1=mult { $value = $op1.value; }
    (
    '+' op2=mult { $value = PlusEvaluator.create($value, $op2.value); }
     | '-' op2=mult { $value = MinusEvaluator.create($value, $op2.value); }
    )*;

unary returns [Evaluator value] :
    {boolean positive = true;}
    ('+' | '-' { positive = !positive; })*
    term {
         $value = $term.value;
         if (!positive)
         	$value = NegationEvaluator.create($value);
         };

mult returns [Evaluator value] :
    op1=unary { $value = $op1.value; }
    ('*' op2=unary { $value = MultiplyEvaluator.create($value, $op2.value); }
        | '/' op2=unary { $value = DivideEvaluator.create($value, $op2.value); }
        | '%' op2=unary { $value = ModEvaluator.create($value, $op2.value); }
        | '**' op2=unary { $value = PowerEvaluator.create($value, $op2.value); }
    )*;

term returns [Evaluator value] :
    '(' expression ')' { $value = $expression.value; }
    | NUMBER { $value = NumberEvaluator.create($NUMBER.text); }
    | STRING_LITERAL { $value = StringEvaluator.create($STRING_LITERAL.text); }
    | QUERY_STRING  { $value = VariableEvaluator.create(variableSource, $QUERY_STRING.text); };

time_unit returns [TimeUnit unit] :
    'ns' { $unit = TimeUnit.NANOSECONDS; }
    | 'us' { $unit = TimeUnit.MICROSECONDS; }
    | 'ms' { $unit = TimeUnit.MILLISECONDS; }
    | 's' { $unit = TimeUnit.SECONDS; }
    | 'm' { $unit = TimeUnit.MINUTES; }
    | 'h' { $unit = TimeUnit.HOURS; }
    | 'd' { $unit = TimeUnit.DAYS; }
    ;
    
ML_COMMENT :
    '/*' (options { greedy=false; }: .)* '*/' { $channel = HIDDEN; };

LINE_COMMENT :
    '//' ~NEWLINE* { $channel = HIDDEN; };

fragment NEWLINE :
    '\n'
    | '\r';

WS :
    (' ' | '\t' | '\n' | '\r')+ { $channel = HIDDEN; };

IDENT :
    LETTER (LETTER | '_' | DIGIT)*;
    
fragment QUERY_STRING :
    IDENT ('.' IDENT)*;

fragment LETTER :
    ('a'..'z' | 'A'..'Z');

fragment DIGIT :
    ('0'..'9');

fragment INTEGER : 
    DIGIT+;

NUMBER :
    '-'? DIGIT+ ('.' DIGIT+)?;

STRING_LITERAL :
    '"' .+ '"'
    | '\'' .+ '\'';
