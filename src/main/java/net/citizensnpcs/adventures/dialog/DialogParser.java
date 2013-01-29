// $ANTLR 3.4 Dialog.g 2013-01-29 20:10:30

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'**'", "'+'", "','", "'-'", "'-p'", "'.'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'criteria'", "'d'", "'events='", "'false'", "'h'", "'m'", "'ms'", "'ns'", "'remember'", "'response'", "'rule'", "'s'", "'then'", "'true'", "'us'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__14=14;
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
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int INTEGER=6;
    public static final int LETTER=7;
    public static final int LINE_COMMENT=8;
    public static final int ML_COMMENT=9;
    public static final int NEWLINE=10;
    public static final int NUMBER=11;
    public static final int STRING_LITERAL=12;
    public static final int WS=13;

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


    /*  @Override
        public void reportError(RecognitionException e) {
            throw e;
        }
    */
    private VariableSource variableSource;

    public void setVariableSource(VariableSource source) {
        this.variableSource = source;
    }



    // $ANTLR start "program"
    // Dialog.g:55:1: program[DialogEngine.ParseContext context] : ( rule[context] | response[context] )* ;
    public final void program(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return rule1 =null;

        Response response2 =null;


        try {
            // Dialog.g:55:45: ( ( rule[context] | response[context] )* )
            // Dialog.g:56:5: ( rule[context] | response[context] )*
            {
            // Dialog.g:56:5: ( rule[context] | response[context] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==45) ) {
                    alt1=1;
                }
                else if ( (LA1_0==44) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:57:9: rule[context]
            	    {
            	    pushFollow(FOLLOW_rule_in_program81);
            	    rule1=rule(context);

            	    state._fsp--;


            	     context.ruleLoaded((rule1!=null?rule1.eventNames:null), (rule1!=null?rule1.rule:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:58:11: response[context]
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
    // Dialog.g:61:1: name[DialogEngine.ParseContext context] returns [String name] : (i1= IDENT |i2= IDENT '/' i3= IDENT ) ;
    public final String name(DialogEngine.ParseContext context) throws RecognitionException {
        String name = null;


        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // Dialog.g:61:64: ( (i1= IDENT |i2= IDENT '/' i3= IDENT ) )
            // Dialog.g:62:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            {
            // Dialog.g:62:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==25) ) {
                    alt2=2;
                }
                else if ( (LA2_1==27||LA2_1==47||LA2_1==50) ) {
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
                    // Dialog.g:63:9: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_name136); 

                     name = context.disambiguateName((i1!=null?i1.getText():null)); 

                    }
                    break;
                case 2 :
                    // Dialog.g:64:11: i2= IDENT '/' i3= IDENT
                    {
                    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_name153); 

                    match(input,25,FOLLOW_25_in_name155); 

                    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_name159); 

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
    // Dialog.g:68:1: response[DialogEngine.ParseContext context] returns [Response response] : 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' ;
    public final Response response(DialogEngine.ParseContext context) throws RecognitionException {
        Response response = null;


        String name3 =null;


        try {
            // Dialog.g:68:74: ( 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' )
            // Dialog.g:69:5: 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}'
            {
             Response.Builder builder = Response.builder(); 

            match(input,44,FOLLOW_44_in_response197); 

            pushFollow(FOLLOW_name_in_response199);
            name3=name(context);

            state._fsp--;


             builder.name(name3); 

            match(input,50,FOLLOW_50_in_response204); 

            // Dialog.g:70:64: ( response_statement[context, builder] ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT||LA3_0==43) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:70:65: response_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response207);
            	    response_statement(context, builder);

            	    state._fsp--;


            	    match(input,27,FOLLOW_27_in_response210); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,51,FOLLOW_51_in_response214); 

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
    // Dialog.g:74:1: response_statement[DialogEngine.ParseContext context, Response.Builder builder] : ( remember_statement | generic_statement[context] );
    public final void response_statement(DialogEngine.ParseContext context, Response.Builder builder) throws RecognitionException {
        QueryRunnable remember_statement4 =null;

        QueryRunnable generic_statement5 =null;


        try {
            // Dialog.g:74:82: ( remember_statement | generic_statement[context] )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==43) ) {
                alt4=1;
            }
            else if ( (LA4_0==IDENT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Dialog.g:75:5: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_response_statement239);
                    remember_statement4=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement4); 

                    }
                    break;
                case 2 :
                    // Dialog.g:76:7: generic_statement[context]
                    {
                    pushFollow(FOLLOW_generic_statement_in_response_statement249);
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
    // Dialog.g:79:1: rule[DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule] : 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' ;
    public final DialogParser.rule_return rule(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        String name6 =null;

        Collection<String> criteria7 =null;


        try {
            // Dialog.g:79:92: ( 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' )
            // Dialog.g:80:5: 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}'
            {
             Rule.Builder builder = Rule.builder(); 

            match(input,45,FOLLOW_45_in_rule280); 

            pushFollow(FOLLOW_name_in_rule282);
            name6=name(context);

            state._fsp--;


             builder.name(name6); 

            match(input,50,FOLLOW_50_in_rule287); 

            pushFollow(FOLLOW_criteria_in_rule289);
            criteria7=criteria();

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,27,FOLLOW_27_in_rule293); 

            // Dialog.g:81:113: ( rule_statement[context, builder] ';' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||(LA5_0 >= 43 && LA5_0 <= 44)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:81:114: rule_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule296);
            	    rule_statement(context, builder);

            	    state._fsp--;


            	    match(input,27,FOLLOW_27_in_rule299); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,51,FOLLOW_51_in_rule303); 

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
    // Dialog.g:85:1: rule_statement[DialogEngine.ParseContext context, Rule.Builder builder] : ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] );
    public final void rule_statement(DialogEngine.ParseContext context, Rule.Builder builder) throws RecognitionException {
        Token target=null;
        Token event=null;
        String n =null;

        QueryRunnable remember_statement8 =null;

        QueryRunnable generic_statement9 =null;


        try {
            // Dialog.g:85:74: ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] )
            int alt8=3;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt8=1;
                }
                break;
            case 43:
                {
                alt8=2;
                }
                break;
            case IDENT:
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
                    // Dialog.g:86:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    {
                    // Dialog.g:86:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    // Dialog.g:86:6: 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    {
                    match(input,44,FOLLOW_44_in_rule_statement333); 

                    pushFollow(FOLLOW_name_in_rule_statement337);
                    n=name(context);

                    state._fsp--;


                     CallResponse.Builder responseBuilder = CallResponse.builder(n); 

                    // Dialog.g:87:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==47) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Dialog.g:89:13: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,47,FOLLOW_47_in_rule_statement378); 

                            // Dialog.g:89:20: (target= IDENT |target= NUMBER )
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
                                    // Dialog.g:89:21: target= IDENT
                                    {
                                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement383); 

                                    }
                                    break;
                                case 2 :
                                    // Dialog.g:89:36: target= NUMBER
                                    {
                                    target=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule_statement389); 

                                    }
                                    break;

                            }


                            event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement394); 

                             responseBuilder.callback(new CallEventCallback((target!=null?target.getText():null), (event!=null?event.getText():null))); 

                            }
                            break;

                    }


                     builder.statement(responseBuilder.build()); 

                    }


                    }
                    break;
                case 2 :
                    // Dialog.g:93:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_rule_statement432);
                    remember_statement8=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement8); 

                    }
                    break;
                case 3 :
                    // Dialog.g:94:7: generic_statement[context]
                    {
                    pushFollow(FOLLOW_generic_statement_in_rule_statement442);
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



    // $ANTLR start "generic_statement"
    // Dialog.g:97:1: generic_statement[DialogEngine.ParseContext context] returns [QueryRunnable statement] :i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?;
    public final QueryRunnable generic_statement(DialogEngine.ParseContext context) throws RecognitionException {
        QueryRunnable statement = null;


        Token i1=null;
        Argument a1 =null;

        Argument a2 =null;


        try {
            // Dialog.g:97:89: (i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?)
            // Dialog.g:98:5: i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?
            {
             String name; List<Argument> vars = Lists.newArrayList(); 

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_generic_statement476); 

             name = (i1!=null?i1.getText():null); 

            // Dialog.g:100:5: (a1= argument_decl ( ',' a2= argument_decl )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT||(LA10_0 >= NUMBER && LA10_0 <= STRING_LITERAL)||LA10_0==16||LA10_0==20||LA10_0==22||LA10_0==33||LA10_0==38||LA10_0==48||LA10_0==50) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Dialog.g:101:9: a1= argument_decl ( ',' a2= argument_decl )*
                    {
                    pushFollow(FOLLOW_argument_decl_in_generic_statement497);
                    a1=argument_decl();

                    state._fsp--;


                     vars.add(a1); 

                    // Dialog.g:102:9: ( ',' a2= argument_decl )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Dialog.g:103:13: ',' a2= argument_decl
                    	    {
                    	    match(input,21,FOLLOW_21_in_generic_statement523); 

                    	    pushFollow(FOLLOW_argument_decl_in_generic_statement527);
                    	    a2=argument_decl();

                    	    state._fsp--;


                    	     vars.add(a2); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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
    // Dialog.g:108:1: argument_decl returns [Argument arg] : (i1= IDENT '=' e1= expression |e2= expression );
    public final Argument argument_decl() throws RecognitionException {
        Argument arg = null;


        Token i1=null;
        Evaluator e1 =null;

        Evaluator e2 =null;


        try {
            // Dialog.g:108:38: (i1= IDENT '=' e1= expression |e2= expression )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENT) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==30) ) {
                    alt11=1;
                }
                else if ( (LA11_1==15||(LA11_1 >= 18 && LA11_1 <= 22)||(LA11_1 >= 24 && LA11_1 <= 25)||LA11_1==27) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else if ( ((LA11_0 >= NUMBER && LA11_0 <= STRING_LITERAL)||LA11_0==16||LA11_0==20||LA11_0==22||LA11_0==33||LA11_0==38||LA11_0==48||LA11_0==50) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // Dialog.g:109:5: i1= IDENT '=' e1= expression
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_argument_decl578); 

                    match(input,30,FOLLOW_30_in_argument_decl580); 

                    pushFollow(FOLLOW_expression_in_argument_decl584);
                    e1=expression();

                    state._fsp--;


                     arg = new Argument((i1!=null?i1.getText():null), e1); 

                    }
                    break;
                case 2 :
                    // Dialog.g:110:7: e2= expression
                    {
                    pushFollow(FOLLOW_expression_in_argument_decl596);
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
    // Dialog.g:112:1: remember_statement returns [QueryRunnable statement] : 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* ;
    public final QueryRunnable remember_statement() throws RecognitionException {
        QueryRunnable statement = null;


        try {
            // Dialog.g:112:54: ( 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* )
            // Dialog.g:113:5: 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )*
            {
             Remember.Builder builder = Remember.builder(); 

            match(input,43,FOLLOW_43_in_remember_statement624); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement626);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:114:45: ( ',' remember_assignment[builder] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Dialog.g:114:46: ',' remember_assignment[builder]
            	    {
            	    match(input,21,FOLLOW_21_in_remember_statement630); 

            	    pushFollow(FOLLOW_remember_assignment_in_remember_statement632);
            	    remember_assignment(builder);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // Dialog.g:118:1: remember_assignment[Remember.Builder builder] :q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token i1=null;
        DialogParser.query_return q =null;

        TimeUnit i2 =null;

        Evaluator expression10 =null;


        try {
            // Dialog.g:118:48: (q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? )
            // Dialog.g:119:5: q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )?
            {
             boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; 

            pushFollow(FOLLOW_query_in_remember_assignment668);
            q=query();

            state._fsp--;


            match(input,30,FOLLOW_30_in_remember_assignment670); 

            pushFollow(FOLLOW_expression_in_remember_assignment672);
            expression10=expression();

            state._fsp--;


            // Dialog.g:121:9: (i1= INTEGER i2= time_unit )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INTEGER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Dialog.g:122:13: i1= INTEGER i2= time_unit
                    {
                    i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_remember_assignment699); 

                    pushFollow(FOLLOW_time_unit_in_remember_assignment703);
                    i2=time_unit();

                    state._fsp--;


                     expiration = Long.parseLong((i1!=null?i1.getText():null)); unit = i2; 

                    }
                    break;

            }


            // Dialog.g:124:9: ( '-p' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Dialog.g:125:13: '-p'
                    {
                    match(input,23,FOLLOW_23_in_remember_assignment741); 

                     isPersistent = true; 

                    }
                    break;

            }


             builder.remember((q!=null?input.toString(q.start,q.stop):null), expression10, ExpirationTime.expiringAt(expiration, unit, isPersistent)); 

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
    // Dialog.g:130:1: criteria returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* ;
    public final Collection<String> criteria() throws RecognitionException {
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
        Evaluator op1 =null;

        Evaluator op2 =null;

        Evaluator op3 =null;

        Evaluator op4 =null;

        Evaluator op5 =null;

        Evaluator op6 =null;


        try {
            // Dialog.g:130:49: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* )
            // Dialog.g:131:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,35,FOLLOW_35_in_criteria796); 

            // Dialog.g:132:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:133:21: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,37,FOLLOW_37_in_criteria820); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria824); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:133:72: ( ',' e2= IDENT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==21) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Dialog.g:133:73: ',' e2= IDENT
            	    {
            	    match(input,21,FOLLOW_21_in_criteria830); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria834); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            // Dialog.g:135:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            loop16:
            do {
                int alt16=8;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 30:
                        {
                        alt16=1;
                        }
                        break;
                    case 31:
                        {
                        alt16=2;
                        }
                        break;
                    case 28:
                        {
                        alt16=3;
                        }
                        break;
                    case 29:
                        {
                        alt16=4;
                        }
                        break;
                    case 32:
                        {
                        alt16=5;
                        }
                        break;
                    case 14:
                        {
                        alt16=6;
                        }
                        break;
                    case IDENT:
                    case 27:
                        {
                        alt16=7;
                        }
                        break;

                    }

                }


                switch (alt16) {
            	case 1 :
            	    // Dialog.g:136:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria874); 

            	    match(input,30,FOLLOW_30_in_criteria876); 

            	    pushFollow(FOLLOW_expression_in_criteria880);
            	    op1=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), op1); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:137:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria896); 

            	    match(input,31,FOLLOW_31_in_criteria898); 

            	    pushFollow(FOLLOW_expression_in_criteria902);
            	    op2=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:138:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria918); 

            	    match(input,28,FOLLOW_28_in_criteria920); 

            	    pushFollow(FOLLOW_expression_in_criteria924);
            	    op3=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), op3); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:139:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria940); 

            	    match(input,29,FOLLOW_29_in_criteria942); 

            	    pushFollow(FOLLOW_expression_in_criteria946);
            	    op4=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), op4); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:140:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria962); 

            	    match(input,32,FOLLOW_32_in_criteria964); 

            	    pushFollow(FOLLOW_expression_in_criteria968);
            	    op5=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), op5); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:141:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria984); 

            	    match(input,14,FOLLOW_14_in_criteria986); 

            	    pushFollow(FOLLOW_expression_in_criteria990);
            	    op6=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.not((i6!=null?i6.getText():null), op6);

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:142:11: i7= IDENT
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria1006); 

            	     NumberQueryPredicate.of((i7!=null?i7.getText():null), Predicates.<Number>alwaysTrue()); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // Dialog.g:145:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:145:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:146:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression1037);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:147:5: ( '+' op2= mult | '-' op2= mult )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==20) ) {
                    alt17=1;
                }
                else if ( (LA17_0==22) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // Dialog.g:148:5: '+' op2= mult
            	    {
            	    match(input,20,FOLLOW_20_in_expression1051); 

            	    pushFollow(FOLLOW_mult_in_expression1055);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:149:8: '-' op2= mult
            	    {
            	    match(input,22,FOLLOW_22_in_expression1066); 

            	    pushFollow(FOLLOW_mult_in_expression1070);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // Dialog.g:152:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term11 =null;


        try {
            // Dialog.g:152:33: ( ( '+' | '-' )* term )
            // Dialog.g:153:5: ( '+' | '-' )* term
            {
             boolean positive = true; 

            // Dialog.g:154:5: ( '+' | '-' )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==20) ) {
                    alt18=1;
                }
                else if ( (LA18_0==22) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // Dialog.g:154:6: '+'
            	    {
            	    match(input,20,FOLLOW_20_in_unary1102); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:154:12: '-'
            	    {
            	    match(input,22,FOLLOW_22_in_unary1106); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary1116);
            term11=term();

            state._fsp--;



                     value = term11;
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
    // Dialog.g:161:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:161:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:162:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult1136);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:163:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop19:
            do {
                int alt19=5;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt19=1;
                    }
                    break;
                case 25:
                    {
                    alt19=2;
                    }
                    break;
                case 15:
                    {
                    alt19=3;
                    }
                    break;
                case 19:
                    {
                    alt19=4;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // Dialog.g:164:9: '*' op2= unary
            	    {
            	    match(input,18,FOLLOW_18_in_mult1154); 

            	    pushFollow(FOLLOW_unary_in_mult1158);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:165:11: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult1172); 

            	    pushFollow(FOLLOW_unary_in_mult1176);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:166:11: '%' op2= unary
            	    {
            	    match(input,15,FOLLOW_15_in_mult1190); 

            	    pushFollow(FOLLOW_unary_in_mult1194);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:167:11: '**' op2= unary
            	    {
            	    match(input,19,FOLLOW_19_in_mult1208); 

            	    pushFollow(FOLLOW_unary_in_mult1212);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

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
        return value;
    }
    // $ANTLR end "mult"



    // $ANTLR start "term"
    // Dialog.g:170:1: term returns [Evaluator value] : ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' );
    public final Evaluator term() throws RecognitionException {
        Evaluator value = null;


        Token NUMBER13=null;
        Token STRING_LITERAL14=null;
        boolean b =false;

        DialogParser.query_return q =null;

        Evaluator exp1 =null;

        Evaluator exp2 =null;

        Evaluator expression12 =null;


        try {
            // Dialog.g:170:32: ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' )
            int alt24=7;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt24=1;
                }
                break;
            case 38:
            case 48:
                {
                alt24=2;
                }
                break;
            case NUMBER:
                {
                alt24=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt24=4;
                }
                break;
            case IDENT:
                {
                alt24=5;
                }
                break;
            case 33:
                {
                alt24=6;
                }
                break;
            case 50:
                {
                alt24=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // Dialog.g:171:5: '(' expression ')'
                    {
                    match(input,16,FOLLOW_16_in_term1237); 

                    pushFollow(FOLLOW_expression_in_term1239);
                    expression12=expression();

                    state._fsp--;


                    match(input,17,FOLLOW_17_in_term1241); 

                     value = expression12; 

                    }
                    break;
                case 2 :
                    // Dialog.g:172:7: b= bool
                    {
                    pushFollow(FOLLOW_bool_in_term1253);
                    b=bool();

                    state._fsp--;


                     value = BooleanEvaluator.create(b); 

                    }
                    break;
                case 3 :
                    // Dialog.g:173:7: NUMBER
                    {
                    NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term1263); 

                     value = NumberEvaluator.create((NUMBER13!=null?NUMBER13.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:174:7: STRING_LITERAL
                    {
                    STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1273); 

                     value = StringEvaluator.create((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null), this.variableSource); 

                    }
                    break;
                case 5 :
                    // Dialog.g:175:7: q= query
                    {
                    pushFollow(FOLLOW_query_in_term1285);
                    q=query();

                    state._fsp--;


                     value = VariableEvaluator.create(variableSource, (q!=null?input.toString(q.start,q.stop):null)); 

                    }
                    break;
                case 6 :
                    // Dialog.g:176:7: '[' (exp1= expression ( ',' exp2= expression )* )? ']'
                    {
                    match(input,33,FOLLOW_33_in_term1296); 

                     List<Evaluator> array = Lists.newArrayList(); 

                    // Dialog.g:178:13: (exp1= expression ( ',' exp2= expression )* )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==IDENT||(LA21_0 >= NUMBER && LA21_0 <= STRING_LITERAL)||LA21_0==16||LA21_0==20||LA21_0==22||LA21_0==33||LA21_0==38||LA21_0==48||LA21_0==50) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // Dialog.g:179:14: exp1= expression ( ',' exp2= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_term1342);
                            exp1=expression();

                            state._fsp--;


                             array.add(exp1); 

                            // Dialog.g:180:14: ( ',' exp2= expression )*
                            loop20:
                            do {
                                int alt20=2;
                                int LA20_0 = input.LA(1);

                                if ( (LA20_0==21) ) {
                                    alt20=1;
                                }


                                switch (alt20) {
                            	case 1 :
                            	    // Dialog.g:180:15: ',' exp2= expression
                            	    {
                            	    match(input,21,FOLLOW_21_in_term1360); 

                            	    pushFollow(FOLLOW_expression_in_term1364);
                            	    exp2=expression();

                            	    state._fsp--;


                            	     array.add(exp2); 

                            	    }
                            	    break;

                            	default :
                            	    break loop20;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,34,FOLLOW_34_in_term1391); 

                     value = ArrayEvaluator.create(array); 

                    }
                    break;
                case 7 :
                    // Dialog.g:183:7: '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}'
                    {
                    match(input,50,FOLLOW_50_in_term1401); 

                     Map<String, Evaluator> vars = Maps.newHashMap(); 

                    // Dialog.g:185:11: ( map_pair[vars] ( ',' map_pair[vars] )* )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==STRING_LITERAL) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // Dialog.g:185:12: map_pair[vars] ( ',' map_pair[vars] )*
                            {
                            pushFollow(FOLLOW_map_pair_in_term1427);
                            map_pair(vars);

                            state._fsp--;


                            // Dialog.g:185:27: ( ',' map_pair[vars] )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==21) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // Dialog.g:185:28: ',' map_pair[vars]
                            	    {
                            	    match(input,21,FOLLOW_21_in_term1431); 

                            	    pushFollow(FOLLOW_map_pair_in_term1433);
                            	    map_pair(vars);

                            	    state._fsp--;


                            	    }
                            	    break;

                            	default :
                            	    break loop22;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,51,FOLLOW_51_in_term1446); 

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
    // Dialog.g:189:1: bool returns [boolean value] : ( 'true' | 'false' ) ;
    public final boolean bool() throws RecognitionException {
        boolean value = false;


        try {
            // Dialog.g:189:30: ( ( 'true' | 'false' ) )
            // Dialog.g:190:5: ( 'true' | 'false' )
            {
            // Dialog.g:190:5: ( 'true' | 'false' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==48) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // Dialog.g:190:6: 'true'
                    {
                    match(input,48,FOLLOW_48_in_bool1470); 

                     value = true; 

                    }
                    break;
                case 2 :
                    // Dialog.g:190:34: 'false'
                    {
                    match(input,38,FOLLOW_38_in_bool1476); 

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
    // Dialog.g:192:1: map_pair[Map<String, Evaluator> vars] : k= STRING_LITERAL ':' expression ;
    public final void map_pair(Map<String, Evaluator> vars) throws RecognitionException {
        Token k=null;
        Evaluator expression15 =null;


        try {
            // Dialog.g:192:40: (k= STRING_LITERAL ':' expression )
            // Dialog.g:193:5: k= STRING_LITERAL ':' expression
            {
            k=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_pair1499); 

            match(input,26,FOLLOW_26_in_map_pair1501); 

            pushFollow(FOLLOW_expression_in_map_pair1503);
            expression15=expression();

            state._fsp--;


             vars.put((k!=null?k.getText():null), expression15); 

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
    // Dialog.g:195:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:195:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt26=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt26=1;
                }
                break;
            case 49:
                {
                alt26=2;
                }
                break;
            case 41:
                {
                alt26=3;
                }
                break;
            case 46:
                {
                alt26=4;
                }
                break;
            case 40:
                {
                alt26=5;
                }
                break;
            case 39:
                {
                alt26=6;
                }
                break;
            case 36:
                {
                alt26=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // Dialog.g:196:5: 'ns'
                    {
                    match(input,42,FOLLOW_42_in_time_unit1521); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:197:7: 'us'
                    {
                    match(input,49,FOLLOW_49_in_time_unit1531); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:198:7: 'ms'
                    {
                    match(input,41,FOLLOW_41_in_time_unit1541); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:199:7: 's'
                    {
                    match(input,46,FOLLOW_46_in_time_unit1551); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:200:7: 'm'
                    {
                    match(input,40,FOLLOW_40_in_time_unit1561); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:201:7: 'h'
                    {
                    match(input,39,FOLLOW_39_in_time_unit1571); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:202:7: 'd'
                    {
                    match(input,36,FOLLOW_36_in_time_unit1581); 

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


    public static class query_return extends ParserRuleReturnScope {
    };


    // $ANTLR start "query"
    // Dialog.g:205:1: query : IDENT ( '.' IDENT )* ;
    public final DialogParser.query_return query() throws RecognitionException {
        DialogParser.query_return retval = new DialogParser.query_return();
        retval.start = input.LT(1);


        try {
            // Dialog.g:205:7: ( IDENT ( '.' IDENT )* )
            // Dialog.g:206:5: IDENT ( '.' IDENT )*
            {
            match(input,IDENT,FOLLOW_IDENT_in_query1602); 

            // Dialog.g:206:11: ( '.' IDENT )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==24) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Dialog.g:206:12: '.' IDENT
            	    {
            	    match(input,24,FOLLOW_24_in_query1605); 

            	    match(input,IDENT,FOLLOW_IDENT_in_query1607); 

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


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
    // $ANTLR end "query"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_program81 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_response_in_program96 = new BitSet(new long[]{0x0000300000000002L});
    public static final BitSet FOLLOW_IDENT_in_name136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name153 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_name155 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_name159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_response197 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_response199 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_response204 = new BitSet(new long[]{0x0008080000000020L});
    public static final BitSet FOLLOW_response_statement_in_response207 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_response210 = new BitSet(new long[]{0x0008080000000020L});
    public static final BitSet FOLLOW_51_in_response214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_response_statement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule280 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule282 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_rule287 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_criteria_in_rule289 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule293 = new BitSet(new long[]{0x0008180000000020L});
    public static final BitSet FOLLOW_rule_statement_in_rule296 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule299 = new BitSet(new long[]{0x0008180000000020L});
    public static final BitSet FOLLOW_51_in_rule303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule_statement333 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule_statement337 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_rule_statement378 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement383 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement389 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_rule_statement442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_generic_statement476 = new BitSet(new long[]{0x0005004200511822L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement497 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_generic_statement523 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement527 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_IDENT_in_argument_decl578 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_argument_decl580 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_argument_decl584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument_decl596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_remember_statement624 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement626 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_remember_statement630 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement632 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_query_in_remember_assignment668 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_remember_assignment670 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_remember_assignment672 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment699 = new BitSet(new long[]{0x0002479000000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment703 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_remember_assignment741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_criteria796 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_criteria820 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria824 = new BitSet(new long[]{0x0000000000200022L});
    public static final BitSet FOLLOW_21_in_criteria830 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria834 = new BitSet(new long[]{0x0000000000200022L});
    public static final BitSet FOLLOW_IDENT_in_criteria874 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria876 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria880 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria896 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria898 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria902 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria918 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria920 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria924 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria940 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria942 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria946 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria962 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_criteria964 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria968 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria984 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_criteria986 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria990 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria1006 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression1037 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_20_in_expression1051 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_mult_in_expression1055 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_22_in_expression1066 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_mult_in_expression1070 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_20_in_unary1102 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_22_in_unary1106 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_term_in_unary1116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult1136 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_18_in_mult1154 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1158 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_25_in_mult1172 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1176 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_15_in_mult1190 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1194 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_19_in_mult1208 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1212 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_16_in_term1237 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_term1239 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term1241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_term1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_term1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_term1296 = new BitSet(new long[]{0x0005004600511820L});
    public static final BitSet FOLLOW_expression_in_term1342 = new BitSet(new long[]{0x0000000400200000L});
    public static final BitSet FOLLOW_21_in_term1360 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_term1364 = new BitSet(new long[]{0x0000000400200000L});
    public static final BitSet FOLLOW_34_in_term1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_term1401 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_map_pair_in_term1427 = new BitSet(new long[]{0x0008000000200000L});
    public static final BitSet FOLLOW_21_in_term1431 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_map_pair_in_term1433 = new BitSet(new long[]{0x0008000000200000L});
    public static final BitSet FOLLOW_51_in_term1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_bool1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_bool1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_map_pair1499 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_map_pair1501 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_map_pair1503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_time_unit1521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_time_unit1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_time_unit1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_time_unit1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_time_unit1561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_time_unit1571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_time_unit1581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_query1602 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_query1605 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_query1607 = new BitSet(new long[]{0x0000000001000002L});

}