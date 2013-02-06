// $ANTLR 3.4 Dialog.g 2013-02-06 15:15:26

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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DialogParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "QUERY", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'**'", "'+'", "','", "'-'", "'-p'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'criteria'", "'d'", "'events='", "'false'", "'h'", "'m'", "'ms'", "'ns'", "'random {'", "'remember'", "'response'", "'rule'", "'s'", "'then'", "'true'", "'us'", "'{'", "'}'", "'~='"
    };

    public static final int EOF=-1;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int INTEGER=6;
    public static final int LETTER=7;
    public static final int LINE_COMMENT=8;
    public static final int ML_COMMENT=9;
    public static final int NEWLINE=10;
    public static final int NUMBER=11;
    public static final int QUERY=12;
    public static final int STRING_LITERAL=13;
    public static final int WS=14;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public DialogParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public DialogParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return DialogParser.tokenNames; }
    public String getGrammarFileName() { return "Dialog.g"; }


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



    // $ANTLR start "program"
    // Dialog.g:59:1: program[DialogEngine.ParseContext context] : ( rule[context] | response[context] )* ;
    public final void program(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return rule1 =null;

        Response response2 =null;


        try {
            // Dialog.g:59:45: ( ( rule[context] | response[context] )* )
            // Dialog.g:60:5: ( rule[context] | response[context] )*
            {
            // Dialog.g:60:5: ( rule[context] | response[context] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==46) ) {
                    alt1=1;
                }
                else if ( (LA1_0==45) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:61:9: rule[context]
            	    {
            	    pushFollow(FOLLOW_rule_in_program81);
            	    rule1=rule(context);

            	    state._fsp--;


            	     context.ruleLoaded((rule1!=null?rule1.eventNames:null), (rule1!=null?rule1.rule:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:62:11: response[context]
            	    {
            	    pushFollow(FOLLOW_response_in_program96);
            	    response2=response(context);

            	    state._fsp--;


            	     context.responseLoaded(response2); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "program"



    // $ANTLR start "name"
    // Dialog.g:65:1: name[DialogEngine.ParseContext context] returns [String name] : (i1= IDENT |i2= IDENT '/' i3= IDENT ) ;
    public final String name(DialogEngine.ParseContext context) throws RecognitionException {
        String name = null;


        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // Dialog.g:65:64: ( (i1= IDENT |i2= IDENT '/' i3= IDENT ) )
            // Dialog.g:66:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            {
            // Dialog.g:66:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==25) ) {
                    alt2=2;
                }
                else if ( (LA2_1==27||LA2_1==48||LA2_1==51) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Dialog.g:67:9: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_name136); 

                     name = context.disambiguateName((i1!=null?i1.getText():null)); 

                    }
                    break;
                case 2 :
                    // Dialog.g:68:11: i2= IDENT '/' i3= IDENT
                    {
                    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_name152); 

                    match(input,25,FOLLOW_25_in_name154); 

                    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_name158); 

                     name = (i2!=null?i2.getText():null) + '/' + (i3!=null?i3.getText():null); 

                    }
                    break;

            }


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return name;
    }
    // $ANTLR end "name"



    // $ANTLR start "response"
    // Dialog.g:72:1: response[DialogEngine.ParseContext context] returns [Response response] : 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' ;
    public final Response response(DialogEngine.ParseContext context) throws RecognitionException {
        Response response = null;


        String name3 =null;


        try {
            // Dialog.g:72:74: ( 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' )
            // Dialog.g:73:5: 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}'
            {
             Response.Builder builder = Response.builder(); 

            match(input,45,FOLLOW_45_in_response196); 

            pushFollow(FOLLOW_name_in_response198);
            name3=name(context);

            state._fsp--;


             builder.name(name3); 

            match(input,51,FOLLOW_51_in_response203); 

            // Dialog.g:74:64: ( response_statement[context, builder] ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT||(LA3_0 >= 43 && LA3_0 <= 44)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:74:65: response_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response206);
            	    response_statement(context, builder);

            	    state._fsp--;


            	    match(input,27,FOLLOW_27_in_response209); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,52,FOLLOW_52_in_response213); 

             response = builder.build(); 

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return response;
    }
    // $ANTLR end "response"



    // $ANTLR start "response_statement"
    // Dialog.g:78:1: response_statement[DialogEngine.ParseContext context, Response.Builder builder] : ( remember_statement | generic_statement[context] );
    public final void response_statement(DialogEngine.ParseContext context, Response.Builder builder) throws RecognitionException {
        QueryRunnable remember_statement4 =null;

        QueryRunnable generic_statement5 =null;


        try {
            // Dialog.g:78:82: ( remember_statement | generic_statement[context] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==44) ) {
                alt4=1;
            }
            else if ( (LA4_0==IDENT||LA4_0==43) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Dialog.g:79:5: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_response_statement238);
                    remember_statement4=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement4); 

                    }
                    break;
                case 2 :
                    // Dialog.g:80:7: generic_statement[context]
                    {
                    pushFollow(FOLLOW_generic_statement_in_response_statement248);
                    generic_statement5=generic_statement(context);

                    state._fsp--;


                     builder.statement(generic_statement5); 

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "response_statement"


    public static class rule_return extends ParserRuleReturnScope {
        public Collection<String> eventNames;
        public Rule rule;
    };


    // $ANTLR start "rule"
    // Dialog.g:83:1: rule[DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule] : 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}' ;
    public final DialogParser.rule_return rule(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        String name6 =null;

        Collection<String> criteria7 =null;


        try {
            // Dialog.g:83:92: ( 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}' )
            // Dialog.g:84:5: 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}'
            {
             Rule.Builder builder = Rule.builder(); 

            match(input,46,FOLLOW_46_in_rule279); 

            pushFollow(FOLLOW_name_in_rule281);
            name6=name(context);

            state._fsp--;


             builder.name(name6); 

            match(input,51,FOLLOW_51_in_rule295); 

            pushFollow(FOLLOW_criteria_in_rule297);
            criteria7=criteria(builder);

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,27,FOLLOW_27_in_rule302); 

            // Dialog.g:87:13: ( rule_statement[context, builder] ';' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||(LA5_0 >= 43 && LA5_0 <= 45)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:87:14: rule_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule318);
            	    rule_statement(context, builder);

            	    state._fsp--;


            	    match(input,27,FOLLOW_27_in_rule321); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,52,FOLLOW_52_in_rule334); 

             retval.rule = builder.build(); 

            }

            retval.stop = input.LT(-1);


        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"



    // $ANTLR start "rule_statement"
    // Dialog.g:92:1: rule_statement[DialogEngine.ParseContext context, Rule.Builder builder] : ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] );
    public final void rule_statement(DialogEngine.ParseContext context, Rule.Builder builder) throws RecognitionException {
        Token target=null;
        Token event=null;
        String n =null;

        QueryRunnable remember_statement8 =null;

        QueryRunnable generic_statement9 =null;


        try {
            // Dialog.g:92:74: ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt8=1;
                }
                break;
            case 44:
                {
                alt8=2;
                }
                break;
            case IDENT:
            case 43:
                {
                alt8=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // Dialog.g:93:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    {
                    // Dialog.g:93:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    // Dialog.g:93:6: 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    {
                    match(input,45,FOLLOW_45_in_rule_statement364); 

                    pushFollow(FOLLOW_name_in_rule_statement368);
                    n=name(context);

                    state._fsp--;


                     CallResponse.Builder responseBuilder = CallResponse.builder(n); 

                    // Dialog.g:94:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==48) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Dialog.g:96:13: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,48,FOLLOW_48_in_rule_statement409); 

                            // Dialog.g:96:20: (target= IDENT |target= NUMBER )
                            int alt6=2;
                            int LA6_0 = input.LA(1);

                            if ( (LA6_0==IDENT) ) {
                                alt6=1;
                            }
                            else if ( (LA6_0==NUMBER) ) {
                                alt6=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 0, input);

                                throw nvae;

                            }
                            switch (alt6) {
                                case 1 :
                                    // Dialog.g:96:21: target= IDENT
                                    {
                                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement414); 

                                    }
                                    break;
                                case 2 :
                                    // Dialog.g:96:36: target= NUMBER
                                    {
                                    target=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule_statement420); 

                                    }
                                    break;

                            }


                            event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement425); 

                             responseBuilder.callback(new CallEventCallback((target!=null?target.getText():null), (event!=null?event.getText():null))); 

                            }
                            break;

                    }


                     builder.statement(responseBuilder.build()); 

                    }


                    }
                    break;
                case 2 :
                    // Dialog.g:100:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_rule_statement463);
                    remember_statement8=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement8); 

                    }
                    break;
                case 3 :
                    // Dialog.g:101:7: generic_statement[context]
                    {
                    pushFollow(FOLLOW_generic_statement_in_rule_statement473);
                    generic_statement9=generic_statement(context);

                    state._fsp--;


                     builder.statement(generic_statement9); 

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rule_statement"



    // $ANTLR start "block"
    // Dialog.g:104:1: block[DialogEngine.ParseContext context] returns [QueryRunnable statement] : 'random {' ( generic_statement[context] ':' NUMBER )+ '}' ;
    public final QueryRunnable block(DialogEngine.ParseContext context) throws RecognitionException {
        QueryRunnable statement = null;


        Token NUMBER11=null;
        QueryRunnable generic_statement10 =null;


        try {
            // Dialog.g:104:77: ( 'random {' ( generic_statement[context] ':' NUMBER )+ '}' )
            // Dialog.g:105:5: 'random {' ( generic_statement[context] ':' NUMBER )+ '}'
            {
            match(input,43,FOLLOW_43_in_block500); 

             SequentialRandomSelector.Builder builder = SequentialRandomSelector.builder(); 

            // Dialog.g:107:9: ( generic_statement[context] ':' NUMBER )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT||LA9_0==43) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Dialog.g:108:13: generic_statement[context] ':' NUMBER
            	    {
            	    pushFollow(FOLLOW_generic_statement_in_block534);
            	    generic_statement10=generic_statement(context);

            	    state._fsp--;


            	    match(input,26,FOLLOW_26_in_block537); 

            	    NUMBER11=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_block539); 

            	     builder.choice(generic_statement10, Double.parseDouble((NUMBER11!=null?NUMBER11.getText():null))); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input,52,FOLLOW_52_in_block571); 

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "block"



    // $ANTLR start "generic_statement"
    // Dialog.g:113:1: generic_statement[DialogEngine.ParseContext context] returns [QueryRunnable statement] : ( block[context] |i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?);
    public final QueryRunnable generic_statement(DialogEngine.ParseContext context) throws RecognitionException {
        QueryRunnable statement = null;


        Token i1=null;
        Argument a1 =null;

        Argument a2 =null;

        QueryRunnable block12 =null;


        try {
            // Dialog.g:113:89: ( block[context] |i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?)
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==43) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENT) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Dialog.g:114:5: block[context]
                    {
                    pushFollow(FOLLOW_block_in_generic_statement589);
                    block12=block(context);

                    state._fsp--;


                     statement = block12; 

                    }
                    break;
                case 2 :
                    // Dialog.g:115:7: i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?
                    {
                     String name; List<Argument> vars = Lists.newArrayList(); 

                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_generic_statement608); 

                     name = (i1!=null?i1.getText():null); 

                    // Dialog.g:117:5: (a1= argument_decl ( ',' a2= argument_decl )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDENT||(LA11_0 >= NUMBER && LA11_0 <= STRING_LITERAL)||LA11_0==17||LA11_0==21||LA11_0==23||LA11_0==33||LA11_0==38||LA11_0==49||LA11_0==51) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Dialog.g:118:9: a1= argument_decl ( ',' a2= argument_decl )*
                            {
                            pushFollow(FOLLOW_argument_decl_in_generic_statement629);
                            a1=argument_decl();

                            state._fsp--;


                             vars.add(a1); 

                            // Dialog.g:119:9: ( ',' a2= argument_decl )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==22) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // Dialog.g:120:13: ',' a2= argument_decl
                            	    {
                            	    match(input,22,FOLLOW_22_in_generic_statement655); 

                            	    pushFollow(FOLLOW_argument_decl_in_generic_statement659);
                            	    a2=argument_decl();

                            	    state._fsp--;


                            	     vars.add(a2); 

                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }


                     statement = context.buildStatement(name, vars); 

                    if ( !(( statement != null )) ) {
                        throw new FailedPredicateException(input, "generic_statement", " $statement != null ");
                    }

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "generic_statement"



    // $ANTLR start "argument_decl"
    // Dialog.g:125:1: argument_decl returns [Argument arg] : (i1= IDENT ':' e1= expression |e2= expression );
    public final Argument argument_decl() throws RecognitionException {
        Argument arg = null;


        Token i1=null;
        Evaluator e1 =null;

        Evaluator e2 =null;


        try {
            // Dialog.g:125:38: (i1= IDENT ':' e1= expression |e2= expression )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENT) ) {
                alt13=1;
            }
            else if ( ((LA13_0 >= NUMBER && LA13_0 <= STRING_LITERAL)||LA13_0==17||LA13_0==21||LA13_0==23||LA13_0==33||LA13_0==38||LA13_0==49||LA13_0==51) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // Dialog.g:126:5: i1= IDENT ':' e1= expression
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_argument_decl710); 

                    match(input,26,FOLLOW_26_in_argument_decl712); 

                    pushFollow(FOLLOW_expression_in_argument_decl716);
                    e1=expression();

                    state._fsp--;


                     arg = new Argument((i1!=null?i1.getText():null), e1); 

                    }
                    break;
                case 2 :
                    // Dialog.g:127:7: e2= expression
                    {
                    pushFollow(FOLLOW_expression_in_argument_decl728);
                    e2=expression();

                    state._fsp--;


                     arg = new Argument(null, e2); 

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return arg;
    }
    // $ANTLR end "argument_decl"



    // $ANTLR start "remember_statement"
    // Dialog.g:129:1: remember_statement returns [QueryRunnable statement] : 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* ;
    public final QueryRunnable remember_statement() throws RecognitionException {
        QueryRunnable statement = null;


        try {
            // Dialog.g:129:54: ( 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* )
            // Dialog.g:130:5: 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )*
            {
             Remember.Builder builder = Remember.builder(); 

            match(input,44,FOLLOW_44_in_remember_statement756); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement758);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:131:45: ( ',' remember_assignment[builder] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Dialog.g:131:46: ',' remember_assignment[builder]
            	    {
            	    match(input,22,FOLLOW_22_in_remember_statement762); 

            	    pushFollow(FOLLOW_remember_assignment_in_remember_statement764);
            	    remember_assignment(builder);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


             statement = builder.build(); 

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return statement;
    }
    // $ANTLR end "remember_statement"



    // $ANTLR start "remember_assignment"
    // Dialog.g:135:1: remember_assignment[Remember.Builder builder] :q= QUERY ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token q=null;
        Token i1=null;
        TimeUnit i2 =null;

        Evaluator expression13 =null;


        try {
            // Dialog.g:135:48: (q= QUERY ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )? )
            // Dialog.g:136:5: q= QUERY ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )?
            {
             boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; 

            q=(Token)match(input,QUERY,FOLLOW_QUERY_in_remember_assignment800); 

            match(input,26,FOLLOW_26_in_remember_assignment802); 

            pushFollow(FOLLOW_expression_in_remember_assignment804);
            expression13=expression();

            state._fsp--;


            // Dialog.g:138:9: (i1= INTEGER i2= time_unit )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==INTEGER) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // Dialog.g:139:13: i1= INTEGER i2= time_unit
                    {
                    i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_remember_assignment831); 

                    pushFollow(FOLLOW_time_unit_in_remember_assignment835);
                    i2=time_unit();

                    state._fsp--;


                     expiration = Long.parseLong((i1!=null?i1.getText():null)); unit = i2; 

                    }
                    break;

            }


            // Dialog.g:141:9: ( '-p' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Dialog.g:142:13: '-p'
                    {
                    match(input,24,FOLLOW_24_in_remember_assignment873); 

                     isPersistent = true; 

                    }
                    break;

            }


             builder.remember((q!=null?q.getText():null), expression13, ExpirationTime.expiringAt(expiration, unit, isPersistent)); 

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "remember_assignment"



    // $ANTLR start "criteria"
    // Dialog.g:147:1: criteria[Rule.Builder builder] returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= QUERY '=' op1= expression |i2= QUERY '>' op2= expression |i3= QUERY '<' op3= expression |i4= QUERY '<=' op4= expression |i5= QUERY '>=' op5= expression |i6= QUERY '!=' op6= expression |i7= QUERY '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= QUERY )* ;
    public final Collection<String> criteria(Rule.Builder builder) throws RecognitionException {
        Collection<String> eventNames = null;


        Token e1=null;
        Token e2=null;
        Token i1=null;
        Token i2=null;
        Token i3=null;
        Token i4=null;
        Token i5=null;
        Token i6=null;
        Token i7=null;
        Token op7=null;
        Token regex=null;
        Token i8=null;
        Evaluator op1 =null;

        Evaluator op2 =null;

        Evaluator op3 =null;

        Evaluator op4 =null;

        Evaluator op5 =null;

        Evaluator op6 =null;


        try {
            // Dialog.g:147:72: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= QUERY '=' op1= expression |i2= QUERY '>' op2= expression |i3= QUERY '<' op3= expression |i4= QUERY '<=' op4= expression |i5= QUERY '>=' op5= expression |i6= QUERY '!=' op6= expression |i7= QUERY '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= QUERY )* )
            // Dialog.g:148:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= QUERY '=' op1= expression |i2= QUERY '>' op2= expression |i3= QUERY '<' op3= expression |i4= QUERY '<=' op4= expression |i5= QUERY '>=' op5= expression |i6= QUERY '!=' op6= expression |i7= QUERY '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= QUERY )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,35,FOLLOW_35_in_criteria930); 

            // Dialog.g:149:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:150:21: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,37,FOLLOW_37_in_criteria954); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria958); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:150:72: ( ',' e2= IDENT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==22) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Dialog.g:150:73: ',' e2= IDENT
            	    {
            	    match(input,22,FOLLOW_22_in_criteria964); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria968); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            // Dialog.g:152:5: (i1= QUERY '=' op1= expression |i2= QUERY '>' op2= expression |i3= QUERY '<' op3= expression |i4= QUERY '<=' op4= expression |i5= QUERY '>=' op5= expression |i6= QUERY '!=' op6= expression |i7= QUERY '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= QUERY )*
            loop19:
            do {
                int alt19=9;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUERY) ) {
                    switch ( input.LA(2) ) {
                    case 30:
                        {
                        alt19=1;
                        }
                        break;
                    case 31:
                        {
                        alt19=2;
                        }
                        break;
                    case 28:
                        {
                        alt19=3;
                        }
                        break;
                    case 29:
                        {
                        alt19=4;
                        }
                        break;
                    case 32:
                        {
                        alt19=5;
                        }
                        break;
                    case 15:
                        {
                        alt19=6;
                        }
                        break;
                    case 53:
                        {
                        alt19=7;
                        }
                        break;
                    case QUERY:
                    case 27:
                        {
                        alt19=8;
                        }
                        break;

                    }

                }


                switch (alt19) {
            	case 1 :
            	    // Dialog.g:153:9: i1= QUERY '=' op1= expression
            	    {
            	    i1=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1008); 

            	    match(input,30,FOLLOW_30_in_criteria1010); 

            	    pushFollow(FOLLOW_expression_in_criteria1014);
            	    op1=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), op1)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:154:11: i2= QUERY '>' op2= expression
            	    {
            	    i2=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1030); 

            	    match(input,31,FOLLOW_31_in_criteria1032); 

            	    pushFollow(FOLLOW_expression_in_criteria1036);
            	    op2=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), op2)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:155:11: i3= QUERY '<' op3= expression
            	    {
            	    i3=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1052); 

            	    match(input,28,FOLLOW_28_in_criteria1054); 

            	    pushFollow(FOLLOW_expression_in_criteria1058);
            	    op3=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), op3)); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:156:11: i4= QUERY '<=' op4= expression
            	    {
            	    i4=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1074); 

            	    match(input,29,FOLLOW_29_in_criteria1076); 

            	    pushFollow(FOLLOW_expression_in_criteria1080);
            	    op4=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), op4)); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:157:11: i5= QUERY '>=' op5= expression
            	    {
            	    i5=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1096); 

            	    match(input,32,FOLLOW_32_in_criteria1098); 

            	    pushFollow(FOLLOW_expression_in_criteria1102);
            	    op5=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), op5)); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:158:11: i6= QUERY '!=' op6= expression
            	    {
            	    i6=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1118); 

            	    match(input,15,FOLLOW_15_in_criteria1120); 

            	    pushFollow(FOLLOW_expression_in_criteria1124);
            	    op6=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.not((i6!=null?i6.getText():null), op6)); 

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:159:11: i7= QUERY '~=' op7= '/' (regex=~ ( '/' ) )+ '/'
            	    {
            	    i7=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1140); 

            	    match(input,53,FOLLOW_53_in_criteria1142); 

            	    op7=(Token)match(input,25,FOLLOW_25_in_criteria1146); 

            	    // Dialog.g:159:38: (regex=~ ( '/' ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( ((LA18_0 >= DIGIT && LA18_0 <= 24)||(LA18_0 >= 26 && LA18_0 <= 53)) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // Dialog.g:159:38: regex=~ ( '/' )
            	    	    {
            	    	    regex=(Token)input.LT(1);

            	    	    if ( (input.LA(1) >= DIGIT && input.LA(1) <= 24)||(input.LA(1) >= 26 && input.LA(1) <= 53) ) {
            	    	        input.consume();
            	    	        state.errorRecovery=false;
            	    	    }
            	    	    else {
            	    	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	    	        throw mse;
            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);


            	    match(input,25,FOLLOW_25_in_criteria1156); 

            	     builder.criterion(RegexQueryPredicate.of((i7!=null?i7.getText():null), (regex!=null?regex.getText():null))); 

            	    }
            	    break;
            	case 8 :
            	    // Dialog.g:160:11: i8= QUERY
            	    {
            	    i8=(Token)match(input,QUERY,FOLLOW_QUERY_in_criteria1172); 

            	     builder.criterion(NumberQueryPredicate.of((i8!=null?i8.getText():null), Predicates.<Number>alwaysTrue())); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return eventNames;
    }
    // $ANTLR end "criteria"



    // $ANTLR start "expression"
    // Dialog.g:163:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:163:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:164:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression1203);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:165:5: ( '+' op2= mult | '-' op2= mult )*
            loop20:
            do {
                int alt20=3;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==21) ) {
                    alt20=1;
                }
                else if ( (LA20_0==23) ) {
                    alt20=2;
                }


                switch (alt20) {
            	case 1 :
            	    // Dialog.g:166:5: '+' op2= mult
            	    {
            	    match(input,21,FOLLOW_21_in_expression1217); 

            	    pushFollow(FOLLOW_mult_in_expression1221);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:167:8: '-' op2= mult
            	    {
            	    match(input,23,FOLLOW_23_in_expression1232); 

            	    pushFollow(FOLLOW_mult_in_expression1236);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "expression"



    // $ANTLR start "unary"
    // Dialog.g:170:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term14 =null;


        try {
            // Dialog.g:170:33: ( ( '+' | '-' )* term )
            // Dialog.g:171:5: ( '+' | '-' )* term
            {
             boolean positive = true; 

            // Dialog.g:172:5: ( '+' | '-' )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==21) ) {
                    alt21=1;
                }
                else if ( (LA21_0==23) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // Dialog.g:172:6: '+'
            	    {
            	    match(input,21,FOLLOW_21_in_unary1268); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:172:12: '-'
            	    {
            	    match(input,23,FOLLOW_23_in_unary1272); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary1282);
            term14=term();

            state._fsp--;



                     value = term14;
                     if (!positive)
                     	value = NegationEvaluator.create(value);
                     

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "unary"



    // $ANTLR start "mult"
    // Dialog.g:179:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:179:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:180:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult1302);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:181:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop22:
            do {
                int alt22=5;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    alt22=1;
                    }
                    break;
                case 25:
                    {
                    alt22=2;
                    }
                    break;
                case 16:
                    {
                    alt22=3;
                    }
                    break;
                case 20:
                    {
                    alt22=4;
                    }
                    break;

                }

                switch (alt22) {
            	case 1 :
            	    // Dialog.g:182:9: '*' op2= unary
            	    {
            	    match(input,19,FOLLOW_19_in_mult1320); 

            	    pushFollow(FOLLOW_unary_in_mult1324);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:183:11: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult1338); 

            	    pushFollow(FOLLOW_unary_in_mult1342);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:184:11: '%' op2= unary
            	    {
            	    match(input,16,FOLLOW_16_in_mult1356); 

            	    pushFollow(FOLLOW_unary_in_mult1360);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:185:11: '**' op2= unary
            	    {
            	    match(input,20,FOLLOW_20_in_mult1374); 

            	    pushFollow(FOLLOW_unary_in_mult1378);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "mult"



    // $ANTLR start "term"
    // Dialog.g:188:1: term returns [Evaluator value] : ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= QUERY | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' );
    public final Evaluator term() throws RecognitionException {
        Evaluator value = null;


        Token q=null;
        Token NUMBER16=null;
        Token STRING_LITERAL17=null;
        boolean b =false;

        Evaluator exp1 =null;

        Evaluator exp2 =null;

        Evaluator expression15 =null;


        try {
            // Dialog.g:188:32: ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= QUERY | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' )
            int alt27=7;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt27=1;
                }
                break;
            case 38:
            case 49:
                {
                alt27=2;
                }
                break;
            case NUMBER:
                {
                alt27=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt27=4;
                }
                break;
            case QUERY:
                {
                alt27=5;
                }
                break;
            case 33:
                {
                alt27=6;
                }
                break;
            case 51:
                {
                alt27=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }

            switch (alt27) {
                case 1 :
                    // Dialog.g:189:5: '(' expression ')'
                    {
                    match(input,17,FOLLOW_17_in_term1403); 

                    pushFollow(FOLLOW_expression_in_term1405);
                    expression15=expression();

                    state._fsp--;


                    match(input,18,FOLLOW_18_in_term1407); 

                     value = expression15; 

                    }
                    break;
                case 2 :
                    // Dialog.g:190:7: b= bool
                    {
                    pushFollow(FOLLOW_bool_in_term1419);
                    b=bool();

                    state._fsp--;


                     value = BooleanEvaluator.create(b); 

                    }
                    break;
                case 3 :
                    // Dialog.g:191:7: NUMBER
                    {
                    NUMBER16=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term1429); 

                     value = NumberEvaluator.create((NUMBER16!=null?NUMBER16.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:192:7: STRING_LITERAL
                    {
                    STRING_LITERAL17=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1439); 

                     value = StringEvaluator.create((STRING_LITERAL17!=null?STRING_LITERAL17.getText():null), this.variableSource); 

                    }
                    break;
                case 5 :
                    // Dialog.g:193:7: q= QUERY
                    {
                    q=(Token)match(input,QUERY,FOLLOW_QUERY_in_term1451); 

                     value = VariableEvaluator.create(variableSource, (q!=null?q.getText():null)); 

                    }
                    break;
                case 6 :
                    // Dialog.g:194:7: '[' (exp1= expression ( ',' exp2= expression )* )? ']'
                    {
                    match(input,33,FOLLOW_33_in_term1462); 

                     List<Evaluator> array = Lists.newArrayList(); 

                    // Dialog.g:196:13: (exp1= expression ( ',' exp2= expression )* )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0 >= NUMBER && LA24_0 <= STRING_LITERAL)||LA24_0==17||LA24_0==21||LA24_0==23||LA24_0==33||LA24_0==38||LA24_0==49||LA24_0==51) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // Dialog.g:197:14: exp1= expression ( ',' exp2= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_term1508);
                            exp1=expression();

                            state._fsp--;


                             array.add(exp1); 

                            // Dialog.g:198:14: ( ',' exp2= expression )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==22) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // Dialog.g:198:15: ',' exp2= expression
                            	    {
                            	    match(input,22,FOLLOW_22_in_term1526); 

                            	    pushFollow(FOLLOW_expression_in_term1530);
                            	    exp2=expression();

                            	    state._fsp--;


                            	     array.add(exp2); 

                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,34,FOLLOW_34_in_term1557); 

                     value = ArrayEvaluator.create(array); 

                    }
                    break;
                case 7 :
                    // Dialog.g:201:7: '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}'
                    {
                    match(input,51,FOLLOW_51_in_term1567); 

                     Map<String, Evaluator> vars = Maps.newHashMap(); 

                    // Dialog.g:203:11: ( map_pair[vars] ( ',' map_pair[vars] )* )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==STRING_LITERAL) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // Dialog.g:203:12: map_pair[vars] ( ',' map_pair[vars] )*
                            {
                            pushFollow(FOLLOW_map_pair_in_term1593);
                            map_pair(vars);

                            state._fsp--;


                            // Dialog.g:203:27: ( ',' map_pair[vars] )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==22) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // Dialog.g:203:28: ',' map_pair[vars]
                            	    {
                            	    match(input,22,FOLLOW_22_in_term1597); 

                            	    pushFollow(FOLLOW_map_pair_in_term1599);
                            	    map_pair(vars);

                            	    state._fsp--;


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,52,FOLLOW_52_in_term1612); 

                     value = MapEvaluator.create(vars); 

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "term"



    // $ANTLR start "bool"
    // Dialog.g:207:1: bool returns [boolean value] : ( 'true' | 'false' ) ;
    public final boolean bool() throws RecognitionException {
        boolean value = false;


        try {
            // Dialog.g:207:30: ( ( 'true' | 'false' ) )
            // Dialog.g:208:5: ( 'true' | 'false' )
            {
            // Dialog.g:208:5: ( 'true' | 'false' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==49) ) {
                alt28=1;
            }
            else if ( (LA28_0==38) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }
            switch (alt28) {
                case 1 :
                    // Dialog.g:208:6: 'true'
                    {
                    match(input,49,FOLLOW_49_in_bool1636); 

                     value = true; 

                    }
                    break;
                case 2 :
                    // Dialog.g:208:34: 'false'
                    {
                    match(input,38,FOLLOW_38_in_bool1642); 

                     value = false; 

                    }
                    break;

            }


            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "bool"



    // $ANTLR start "map_pair"
    // Dialog.g:210:1: map_pair[Map<String, Evaluator> vars] : k= STRING_LITERAL ':' expression ;
    public final void map_pair(Map<String, Evaluator> vars) throws RecognitionException {
        Token k=null;
        Evaluator expression18 =null;


        try {
            // Dialog.g:210:40: (k= STRING_LITERAL ':' expression )
            // Dialog.g:211:5: k= STRING_LITERAL ':' expression
            {
            k=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_pair1665); 

            match(input,26,FOLLOW_26_in_map_pair1667); 

            pushFollow(FOLLOW_expression_in_map_pair1669);
            expression18=expression();

            state._fsp--;


             vars.put((k!=null?k.getText():null), expression18); 

            }

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "map_pair"



    // $ANTLR start "time_unit"
    // Dialog.g:213:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:213:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt29=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt29=1;
                }
                break;
            case 50:
                {
                alt29=2;
                }
                break;
            case 41:
                {
                alt29=3;
                }
                break;
            case 47:
                {
                alt29=4;
                }
                break;
            case 40:
                {
                alt29=5;
                }
                break;
            case 39:
                {
                alt29=6;
                }
                break;
            case 36:
                {
                alt29=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // Dialog.g:214:5: 'ns'
                    {
                    match(input,42,FOLLOW_42_in_time_unit1687); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:215:7: 'us'
                    {
                    match(input,50,FOLLOW_50_in_time_unit1697); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:216:7: 'ms'
                    {
                    match(input,41,FOLLOW_41_in_time_unit1707); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:217:7: 's'
                    {
                    match(input,47,FOLLOW_47_in_time_unit1717); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:218:7: 'm'
                    {
                    match(input,40,FOLLOW_40_in_time_unit1727); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:219:7: 'h'
                    {
                    match(input,39,FOLLOW_39_in_time_unit1737); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:220:7: 'd'
                    {
                    match(input,36,FOLLOW_36_in_time_unit1747); 

                     unit = TimeUnit.DAYS; 

                    }
                    break;

            }
        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return unit;
    }
    // $ANTLR end "time_unit"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_program81 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_response_in_program96 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_IDENT_in_name136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name152 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_name154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_name158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_response196 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_response198 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_response203 = new BitSet(new long[]{0x0010180000000020L});
    public static final BitSet FOLLOW_response_statement_in_response206 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_response209 = new BitSet(new long[]{0x0010180000000020L});
    public static final BitSet FOLLOW_52_in_response213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_response_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule279 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule281 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_rule295 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_criteria_in_rule297 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule302 = new BitSet(new long[]{0x0010380000000020L});
    public static final BitSet FOLLOW_rule_statement_in_rule318 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule321 = new BitSet(new long[]{0x0010380000000020L});
    public static final BitSet FOLLOW_52_in_rule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule_statement364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule_statement368 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_48_in_rule_statement409 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement414 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_rule_statement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_block500 = new BitSet(new long[]{0x0000080000000020L});
    public static final BitSet FOLLOW_generic_statement_in_block534 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_block537 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_in_block539 = new BitSet(new long[]{0x0010080000000020L});
    public static final BitSet FOLLOW_52_in_block571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_generic_statement589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_generic_statement608 = new BitSet(new long[]{0x000A004200A23822L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement629 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_generic_statement655 = new BitSet(new long[]{0x000A004200A23820L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement659 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_IDENT_in_argument_decl710 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_argument_decl712 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_argument_decl716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument_decl728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_remember_statement756 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement758 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_remember_statement762 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement764 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_QUERY_in_remember_assignment800 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_remember_assignment802 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_remember_assignment804 = new BitSet(new long[]{0x0000000001000042L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment831 = new BitSet(new long[]{0x0004879000000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment835 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_remember_assignment873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_criteria930 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_criteria954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria958 = new BitSet(new long[]{0x0000000000401002L});
    public static final BitSet FOLLOW_22_in_criteria964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria968 = new BitSet(new long[]{0x0000000000401002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1008 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria1010 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1014 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1030 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria1032 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1036 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1052 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria1054 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1058 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1074 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria1076 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1080 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1096 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_criteria1098 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1102 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1118 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_criteria1120 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_criteria1124 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1140 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_criteria1142 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_criteria1146 = new BitSet(new long[]{0x003FFFFFFDFFFFF0L});
    public static final BitSet FOLLOW_set_in_criteria1150 = new BitSet(new long[]{0x003FFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_25_in_criteria1156 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_QUERY_in_criteria1172 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_mult_in_expression1203 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_expression1217 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_mult_in_expression1221 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_23_in_expression1232 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_mult_in_expression1236 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_unary1268 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_23_in_unary1272 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_term_in_unary1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult1302 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_19_in_mult1320 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_unary_in_mult1324 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_25_in_mult1338 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_unary_in_mult1342 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_16_in_mult1356 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_unary_in_mult1360 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_20_in_mult1374 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_unary_in_mult1378 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_17_in_term1403 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_term1405 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_term1407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_term1419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_in_term1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_term1462 = new BitSet(new long[]{0x000A004600A23800L});
    public static final BitSet FOLLOW_expression_in_term1508 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_22_in_term1526 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_term1530 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_34_in_term1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_term1567 = new BitSet(new long[]{0x0010000000002000L});
    public static final BitSet FOLLOW_map_pair_in_term1593 = new BitSet(new long[]{0x0010000000400000L});
    public static final BitSet FOLLOW_22_in_term1597 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_map_pair_in_term1599 = new BitSet(new long[]{0x0010000000400000L});
    public static final BitSet FOLLOW_52_in_term1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_bool1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_bool1642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_map_pair1665 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_map_pair1667 = new BitSet(new long[]{0x000A004200A23800L});
    public static final BitSet FOLLOW_expression_in_map_pair1669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_time_unit1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_time_unit1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_time_unit1707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_time_unit1717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_time_unit1727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_time_unit1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_time_unit1747 = new BitSet(new long[]{0x0000000000000002L});

}