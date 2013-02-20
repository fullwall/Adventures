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
import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.google.common.collect.Maps;
import com.google.common.collect.Lists;
import com.google.common.base.Predicates;
import net.citizensnpcs.adventures.dialog.*;
import net.citizensnpcs.adventures.dialog.statements.*;
import net.citizensnpcs.adventures.dialog.evaluators.*;
}

@members {
/*
@Override
public void reportError(RecognitionException e) {
    throw new RuntimeException(e);
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
/*
@Override
public void reportError(RecognitionException e) {
    e.printStackTrace();
}
*/

private String stripQuotes(String quoted) {
    return quoted.substring(1, quoted.length() - 1);
}
}

program [DialogEngine.ParseContext context] :
    (
        rule[context] { $context.ruleLoaded($rule.eventNames, $rule.rule); }
        | response[context] { $context.responseLoaded($response.response); }
    )*;

name [DialogEngine.ParseContext context] returns [String name] :
    (
        i1=IDENT { $name = context.disambiguateName($i1.text); }
        | i2=IDENT '/' i3=IDENT { $name = $i2.text + '/' + $i3.text; }
    )
    ;

response [DialogEngine.ParseContext context] returns [Response response] :
    { Response.Builder builder = Response.builder(); } 
    'response' name[context] { builder.name($name.name); } '{' (response_statement[context, builder] ';')* '}'
    { $response = builder.build(); }
    ;

response_statement [DialogEngine.ParseContext context, Response.Builder builder] :
    remember_statement { builder.statement($remember_statement.statement); }
    | generic_statement[context] { builder.statement($generic_statement.statement); }
    ;

rule [DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule]:
    { Rule.Builder builder = Rule.builder(); }
    'rule' name[context] { builder.name($name.name); } 
        '{' criteria[builder] { $eventNames = $criteria.eventNames; } ';' 
            (rule_statement[context, builder] ';')* 
        '}'
    { $rule = builder.build(); }
    ;
    
rule_statement [DialogEngine.ParseContext context, Rule.Builder builder] :
    ('response' n=name[context] { CallResponse.Builder responseBuilder = CallResponse.builder($n.name); } 
        (
            // target is a name or number
            'then' (target=IDENT | target=NUMBER) event=IDENT { responseBuilder.callback(new CallEventCallback($target.text, $event.text)); }
        )? 
        { builder.statement(responseBuilder.build()); }
    )
    | remember_statement { builder.statement($remember_statement.statement); }
    | generic_statement[context] { builder.statement($generic_statement.statement); }
    ;

block [DialogEngine.ParseContext context] returns [QueryRunnable statement] : 
    'random {'
        { SequentialRandomSelector.Builder builder = SequentialRandomSelector.builder(); }
        (
            generic_statement[context] ':' NUMBER 
            { builder.choice($generic_statement.statement, Double.parseDouble($NUMBER.text)); }
        )+
    '}';

generic_statement [DialogEngine.ParseContext context] returns [QueryRunnable statement] :
    block[context] { $statement = $block.statement; }
    | { String name; List<Argument> vars = Lists.newArrayList(); }
    i1=IDENT { name = $i1.text; } 
    (
        a1=argument_decl { vars.add($a1.arg); }
        (
            ',' a2=argument_decl { vars.add($a2.arg); }
        )*
    )?
    { $statement = context.buildStatement(name, vars); } { $statement != null }?;
    
argument_decl returns [Argument arg] : 
    i1=IDENT ':' e1=expression { $arg = new Argument($i1.text, $e1.value); }
    | e2=expression { $arg = new Argument(null, $e2.value); };
    
remember_statement returns [QueryRunnable statement] :
    { Remember.Builder builder = Remember.builder(); }
    'remember' remember_assignment[builder] (',' remember_assignment[builder])*
    { $statement = builder.build(); }
    ;

remember_assignment [Remember.Builder builder] :
    { boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; }
    q=query ':' expression 
        (
            i1=INTEGER i2=time_unit { expiration = Long.parseLong($INTEGER.text); unit = $i2.unit; }
        )? 
        (
            '-p' { isPersistent = true; }
        )? 
        { builder.remember($q.value, $expression.value, ExpirationTime.expiringAt(expiration, unit, isPersistent)); } 
    ;
    
criteria [Rule.Builder builder] returns [Collection<String> eventNames]:
    { $eventNames = new ArrayList<String>(); }
    'criteria' (
                    'events=' e1=IDENT  { $eventNames.add($e1.text); } (',' e2=IDENT { $eventNames.add($e2.text); })* 
               )
    (
        i1=query '=' op1=expression r1=require { builder.criterion(NumberQueryPredicate.equalTo($i1.value, $op1.value, $r8.required)); }
        | i2=query '>' op2=expression r2=require { builder.criterion(NumberQueryPredicate.greaterThan($i2.value, $op2.value, $r8.required)); }
        | i3=query '<' op3=expression r3=require { builder.criterion(NumberQueryPredicate.lessThan($i3.value, $op3.value, $r8.required)); }
        | i4=query '<=' op4=expression r4=require { builder.criterion(NumberQueryPredicate.lessThanOrEqual($i4.value, $op4.value, $r8.required)); }
        | i5=query '>=' op5=expression r5=require { builder.criterion(NumberQueryPredicate.greaterThanOrEqual($i5.value, $op5.value, $r8.required)); }
        | i6=query '!=' op6=expression r6=require { builder.criterion(NumberQueryPredicate.not($i6.value, $op6.value, $r8.required)); }
        | i7=query '~=' op7='/' regex=~('/')+ '/' r7=require { builder.criterion(RegexQueryPredicate.of($i7.value, $regex.text, $r8.required)); }
        | i8=query r8=require { builder.criterion(NumberQueryPredicate.of($i8.value, Predicates.<Number>alwaysTrue(), $r8.required)); }
    )*;

require returns [boolean required] :
    ( '!' { $required = true; } )?;
query returns [Evaluator value] :
    q=QUERY_KEY { $value = StringEvaluator.create($q.text, variableSource); }
    ;
    
expression returns [Evaluator value] :
    op1=mult { $value = $op1.value; }
    (
    '+' op2=mult { $value = PlusEvaluator.create($value, $op2.value); }
     | '-' op2=mult { $value = MinusEvaluator.create($value, $op2.value); }
    )*;

unary returns [Evaluator value] :
    { boolean positive = true; }
    ('+' | '-' { positive = !positive; })*
    term {
         $value = $term.value;
         if (!positive)
         	$value = NegationEvaluator.create($value);
         };

mult returns [Evaluator value] :
    op1=unary { $value = $op1.value; }
    (
        '*' op2=unary { $value = MultiplyEvaluator.create($value, $op2.value); }
        | '/' op2=unary { $value = DivideEvaluator.create($value, $op2.value); }
        | '%' op2=unary { $value = ModEvaluator.create($value, $op2.value); }
        | '**' op2=unary { $value = PowerEvaluator.create($value, $op2.value); }
    )*;

term returns [Evaluator value] :
    '(' expression ')' { $value = $expression.value; }
    | b=bool { $value = BooleanEvaluator.create($b.value); }
    | NUMBER { $value = NumberEvaluator.create($NUMBER.text); }
    | STRING_LITERAL { $value = StringEvaluator.create($STRING_LITERAL.text, this.variableSource); }
    | q=query  { $value = VariableEvaluator.create(variableSource, $q.value); }
    | '[' 
            { List<Evaluator> array = Lists.newArrayList(); }
            (
	            exp1=expression { array.add($exp1.value); }
	            (',' exp2=expression { array.add($exp2.value); })* 
            )?
     ']' { $value = ArrayEvaluator.create(array); }
    | '{' 
         { Map<String, Evaluator> vars = Maps.newHashMap(); } 
          (map_pair[vars] (',' map_pair[vars])*)?
      '}' { $value = MapEvaluator.create(vars); }
    ;

bool returns [boolean value] :
    ('true' { $value = true; } | 'false' { $value = false; });
    
map_pair [Map<String, Evaluator> vars] :
    k=STRING_LITERAL ':' expression { vars.put($k.text, $expression.value); };

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

WS :
    (' ' | '\t' | '\n' | '\r')+ { $channel = HIDDEN; };   
    
QUERY_KEY : 
    '$' IDENT ('.' (IDENT | QUERY_KEY_VAR))* { setText(getText().substring(1)); };

IDENT :
    LETTER (LETTER | '_' | DIGIT)*;

NUMBER :
    '-'? DIGIT+ ('.' DIGIT+)?;

STRING_LITERAL :
    '"' .* '"' { setText(stripQuotes(getText())); }
    | '\'' .* '\'' { setText(stripQuotes(getText())); }
    ;
    
fragment NEWLINE :
    '\n' | '\r';
    
fragment QUERY_KEY_VAR :
    '${' IDENT ('.' IDENT)* '}';
    
fragment LETTER :
    ('a'..'z' | 'A'..'Z');

fragment DIGIT :
    ('0'..'9');

fragment INTEGER : 
    DIGIT+;