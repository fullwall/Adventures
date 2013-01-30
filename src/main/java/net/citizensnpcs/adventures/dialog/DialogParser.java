// $ANTLR 3.4 Dialog.g 2013-01-30 20:02:15

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'**'", "'+'", "','", "'-'", "'-p'", "'.'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'criteria'", "'d'", "'events='", "'false'", "'h'", "'m'", "'ms'", "'ns'", "'remember'", "'response'", "'rule'", "'s'", "'then'", "'true'", "'us'", "'{'", "'}'", "'~='"
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
    public static final int T__52=52;
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
    // Dialog.g:68:1: response[DialogEngine.ParseContext context] returns [Response response] : 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' ;
    public final Response response(DialogEngine.ParseContext context) throws RecognitionException {
        Response response = null;


        String name3 =null;


        try {
            // Dialog.g:68:74: ( 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' )
            // Dialog.g:69:5: 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}'
            {
             Response.Builder builder = Response.builder(); 

            match(input,44,FOLLOW_44_in_response196); 

            pushFollow(FOLLOW_name_in_response198);
            name3=name(context);

            state._fsp--;


             builder.name(name3); 

            match(input,50,FOLLOW_50_in_response203); 

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


            match(input,51,FOLLOW_51_in_response213); 

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
                    pushFollow(FOLLOW_remember_statement_in_response_statement238);
                    remember_statement4=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement4); 

                    }
                    break;
                case 2 :
                    // Dialog.g:76:7: generic_statement[context]
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
    // Dialog.g:79:1: rule[DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule] : 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}' ;
    public final DialogParser.rule_return rule(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        String name6 =null;

        Collection<String> criteria7 =null;


        try {
            // Dialog.g:79:92: ( 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}' )
            // Dialog.g:80:5: 'rule' name[context] '{' criteria[builder] ';' ( rule_statement[context, builder] ';' )* '}'
            {
             Rule.Builder builder = Rule.builder(); 

            match(input,45,FOLLOW_45_in_rule279); 

            pushFollow(FOLLOW_name_in_rule281);
            name6=name(context);

            state._fsp--;


             builder.name(name6); 

            match(input,50,FOLLOW_50_in_rule295); 

            pushFollow(FOLLOW_criteria_in_rule297);
            criteria7=criteria(builder);

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,27,FOLLOW_27_in_rule302); 

            // Dialog.g:83:13: ( rule_statement[context, builder] ';' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||(LA5_0 >= 43 && LA5_0 <= 44)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:83:14: rule_statement[context, builder] ';'
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


            match(input,51,FOLLOW_51_in_rule334); 

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
    // Dialog.g:88:1: rule_statement[DialogEngine.ParseContext context, Rule.Builder builder] : ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] );
    public final void rule_statement(DialogEngine.ParseContext context, Rule.Builder builder) throws RecognitionException {
        Token target=null;
        Token event=null;
        String n =null;

        QueryRunnable remember_statement8 =null;

        QueryRunnable generic_statement9 =null;


        try {
            // Dialog.g:88:74: ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement | generic_statement[context] )
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
                    // Dialog.g:89:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    {
                    // Dialog.g:89:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    // Dialog.g:89:6: 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    {
                    match(input,44,FOLLOW_44_in_rule_statement364); 

                    pushFollow(FOLLOW_name_in_rule_statement368);
                    n=name(context);

                    state._fsp--;


                     CallResponse.Builder responseBuilder = CallResponse.builder(n); 

                    // Dialog.g:90:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==47) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Dialog.g:92:13: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,47,FOLLOW_47_in_rule_statement409); 

                            // Dialog.g:92:20: (target= IDENT |target= NUMBER )
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
                                    // Dialog.g:92:21: target= IDENT
                                    {
                                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement414); 

                                    }
                                    break;
                                case 2 :
                                    // Dialog.g:92:36: target= NUMBER
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
                    // Dialog.g:96:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_rule_statement463);
                    remember_statement8=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement8); 

                    }
                    break;
                case 3 :
                    // Dialog.g:97:7: generic_statement[context]
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



    // $ANTLR start "generic_statement"
    // Dialog.g:100:1: generic_statement[DialogEngine.ParseContext context] returns [QueryRunnable statement] :i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?;
    public final QueryRunnable generic_statement(DialogEngine.ParseContext context) throws RecognitionException {
        QueryRunnable statement = null;


        Token i1=null;
        Argument a1 =null;

        Argument a2 =null;


        try {
            // Dialog.g:100:89: (i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?)
            // Dialog.g:101:5: i1= IDENT (a1= argument_decl ( ',' a2= argument_decl )* )? {...}?
            {
             String name; List<Argument> vars = Lists.newArrayList(); 

            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_generic_statement507); 

             name = (i1!=null?i1.getText():null); 

            // Dialog.g:103:5: (a1= argument_decl ( ',' a2= argument_decl )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT||(LA10_0 >= NUMBER && LA10_0 <= STRING_LITERAL)||LA10_0==16||LA10_0==20||LA10_0==22||LA10_0==33||LA10_0==38||LA10_0==48||LA10_0==50) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Dialog.g:104:9: a1= argument_decl ( ',' a2= argument_decl )*
                    {
                    pushFollow(FOLLOW_argument_decl_in_generic_statement528);
                    a1=argument_decl();

                    state._fsp--;


                     vars.add(a1); 

                    // Dialog.g:105:9: ( ',' a2= argument_decl )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==21) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // Dialog.g:106:13: ',' a2= argument_decl
                    	    {
                    	    match(input,21,FOLLOW_21_in_generic_statement554); 

                    	    pushFollow(FOLLOW_argument_decl_in_generic_statement558);
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
    // Dialog.g:111:1: argument_decl returns [Argument arg] : (i1= IDENT '=' e1= expression |e2= expression );
    public final Argument argument_decl() throws RecognitionException {
        Argument arg = null;


        Token i1=null;
        Evaluator e1 =null;

        Evaluator e2 =null;


        try {
            // Dialog.g:111:38: (i1= IDENT '=' e1= expression |e2= expression )
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
                    // Dialog.g:112:5: i1= IDENT '=' e1= expression
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_argument_decl609); 

                    match(input,30,FOLLOW_30_in_argument_decl611); 

                    pushFollow(FOLLOW_expression_in_argument_decl615);
                    e1=expression();

                    state._fsp--;


                     arg = new Argument((i1!=null?i1.getText():null), e1); 

                    }
                    break;
                case 2 :
                    // Dialog.g:113:7: e2= expression
                    {
                    pushFollow(FOLLOW_expression_in_argument_decl627);
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
    // Dialog.g:115:1: remember_statement returns [QueryRunnable statement] : 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* ;
    public final QueryRunnable remember_statement() throws RecognitionException {
        QueryRunnable statement = null;


        try {
            // Dialog.g:115:54: ( 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* )
            // Dialog.g:116:5: 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )*
            {
             Remember.Builder builder = Remember.builder(); 

            match(input,43,FOLLOW_43_in_remember_statement655); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement657);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:117:45: ( ',' remember_assignment[builder] )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Dialog.g:117:46: ',' remember_assignment[builder]
            	    {
            	    match(input,21,FOLLOW_21_in_remember_statement661); 

            	    pushFollow(FOLLOW_remember_assignment_in_remember_statement663);
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
    // Dialog.g:121:1: remember_assignment[Remember.Builder builder] :q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token i1=null;
        DialogParser.query_return q =null;

        TimeUnit i2 =null;

        Evaluator expression10 =null;


        try {
            // Dialog.g:121:48: (q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? )
            // Dialog.g:122:5: q= query '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )?
            {
             boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; 

            pushFollow(FOLLOW_query_in_remember_assignment699);
            q=query();

            state._fsp--;


            match(input,30,FOLLOW_30_in_remember_assignment701); 

            pushFollow(FOLLOW_expression_in_remember_assignment703);
            expression10=expression();

            state._fsp--;


            // Dialog.g:124:9: (i1= INTEGER i2= time_unit )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==INTEGER) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // Dialog.g:125:13: i1= INTEGER i2= time_unit
                    {
                    i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_remember_assignment730); 

                    pushFollow(FOLLOW_time_unit_in_remember_assignment734);
                    i2=time_unit();

                    state._fsp--;


                     expiration = Long.parseLong((i1!=null?i1.getText():null)); unit = i2; 

                    }
                    break;

            }


            // Dialog.g:127:9: ( '-p' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // Dialog.g:128:13: '-p'
                    {
                    match(input,23,FOLLOW_23_in_remember_assignment772); 

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
    // Dialog.g:133:1: criteria[Rule.Builder builder] returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= IDENT )* ;
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
            // Dialog.g:133:72: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= IDENT )* )
            // Dialog.g:134:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= IDENT )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,35,FOLLOW_35_in_criteria829); 

            // Dialog.g:135:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:136:21: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,37,FOLLOW_37_in_criteria853); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria857); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:136:72: ( ',' e2= IDENT )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==21) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // Dialog.g:136:73: ',' e2= IDENT
            	    {
            	    match(input,21,FOLLOW_21_in_criteria863); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria867); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            // Dialog.g:138:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT '~=' op7= '/' (regex=~ ( '/' ) )+ '/' |i8= IDENT )*
            loop17:
            do {
                int alt17=9;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 30:
                        {
                        alt17=1;
                        }
                        break;
                    case 31:
                        {
                        alt17=2;
                        }
                        break;
                    case 28:
                        {
                        alt17=3;
                        }
                        break;
                    case 29:
                        {
                        alt17=4;
                        }
                        break;
                    case 32:
                        {
                        alt17=5;
                        }
                        break;
                    case 14:
                        {
                        alt17=6;
                        }
                        break;
                    case 52:
                        {
                        alt17=7;
                        }
                        break;
                    case IDENT:
                    case 27:
                        {
                        alt17=8;
                        }
                        break;

                    }

                }


                switch (alt17) {
            	case 1 :
            	    // Dialog.g:139:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria907); 

            	    match(input,30,FOLLOW_30_in_criteria909); 

            	    pushFollow(FOLLOW_expression_in_criteria913);
            	    op1=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), op1)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:140:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria929); 

            	    match(input,31,FOLLOW_31_in_criteria931); 

            	    pushFollow(FOLLOW_expression_in_criteria935);
            	    op2=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), op2)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:141:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria951); 

            	    match(input,28,FOLLOW_28_in_criteria953); 

            	    pushFollow(FOLLOW_expression_in_criteria957);
            	    op3=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), op3)); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:142:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria973); 

            	    match(input,29,FOLLOW_29_in_criteria975); 

            	    pushFollow(FOLLOW_expression_in_criteria979);
            	    op4=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), op4)); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:143:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria995); 

            	    match(input,32,FOLLOW_32_in_criteria997); 

            	    pushFollow(FOLLOW_expression_in_criteria1001);
            	    op5=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), op5)); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:144:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria1017); 

            	    match(input,14,FOLLOW_14_in_criteria1019); 

            	    pushFollow(FOLLOW_expression_in_criteria1023);
            	    op6=expression();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.not((i6!=null?i6.getText():null), op6)); 

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:145:11: i7= IDENT '~=' op7= '/' (regex=~ ( '/' ) )+ '/'
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria1039); 

            	    match(input,52,FOLLOW_52_in_criteria1041); 

            	    op7=(Token)match(input,25,FOLLOW_25_in_criteria1045); 

            	    // Dialog.g:145:38: (regex=~ ( '/' ) )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( ((LA16_0 >= DIGIT && LA16_0 <= 24)||(LA16_0 >= 26 && LA16_0 <= 52)) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // Dialog.g:145:38: regex=~ ( '/' )
            	    	    {
            	    	    regex=(Token)input.LT(1);

            	    	    if ( (input.LA(1) >= DIGIT && input.LA(1) <= 24)||(input.LA(1) >= 26 && input.LA(1) <= 52) ) {
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
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);


            	    match(input,25,FOLLOW_25_in_criteria1055); 

            	     builder.criterion(RegexQueryPredicate.of((i7!=null?i7.getText():null), (regex!=null?regex.getText():null))); 

            	    }
            	    break;
            	case 8 :
            	    // Dialog.g:146:11: i8= IDENT
            	    {
            	    i8=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria1071); 

            	     builder.criterion(NumberQueryPredicate.of((i8!=null?i8.getText():null), Predicates.<Number>alwaysTrue())); 

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
        return eventNames;
    }
    // $ANTLR end "criteria"



    // $ANTLR start "expression"
    // Dialog.g:149:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:149:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:150:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression1102);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:151:5: ( '+' op2= mult | '-' op2= mult )*
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
            	    // Dialog.g:152:5: '+' op2= mult
            	    {
            	    match(input,20,FOLLOW_20_in_expression1116); 

            	    pushFollow(FOLLOW_mult_in_expression1120);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:153:8: '-' op2= mult
            	    {
            	    match(input,22,FOLLOW_22_in_expression1131); 

            	    pushFollow(FOLLOW_mult_in_expression1135);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop18;
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
    // Dialog.g:156:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term11 =null;


        try {
            // Dialog.g:156:33: ( ( '+' | '-' )* term )
            // Dialog.g:157:5: ( '+' | '-' )* term
            {
             boolean positive = true; 

            // Dialog.g:158:5: ( '+' | '-' )*
            loop19:
            do {
                int alt19=3;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==20) ) {
                    alt19=1;
                }
                else if ( (LA19_0==22) ) {
                    alt19=2;
                }


                switch (alt19) {
            	case 1 :
            	    // Dialog.g:158:6: '+'
            	    {
            	    match(input,20,FOLLOW_20_in_unary1167); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:158:12: '-'
            	    {
            	    match(input,22,FOLLOW_22_in_unary1171); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary1181);
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
    // Dialog.g:165:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:165:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:166:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult1201);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:167:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop20:
            do {
                int alt20=5;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt20=1;
                    }
                    break;
                case 25:
                    {
                    alt20=2;
                    }
                    break;
                case 15:
                    {
                    alt20=3;
                    }
                    break;
                case 19:
                    {
                    alt20=4;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // Dialog.g:168:9: '*' op2= unary
            	    {
            	    match(input,18,FOLLOW_18_in_mult1219); 

            	    pushFollow(FOLLOW_unary_in_mult1223);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:169:11: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult1237); 

            	    pushFollow(FOLLOW_unary_in_mult1241);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:170:11: '%' op2= unary
            	    {
            	    match(input,15,FOLLOW_15_in_mult1255); 

            	    pushFollow(FOLLOW_unary_in_mult1259);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:171:11: '**' op2= unary
            	    {
            	    match(input,19,FOLLOW_19_in_mult1273); 

            	    pushFollow(FOLLOW_unary_in_mult1277);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

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
    // $ANTLR end "mult"



    // $ANTLR start "term"
    // Dialog.g:174:1: term returns [Evaluator value] : ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' );
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
            // Dialog.g:174:32: ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' )
            int alt25=7;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt25=1;
                }
                break;
            case 38:
            case 48:
                {
                alt25=2;
                }
                break;
            case NUMBER:
                {
                alt25=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt25=4;
                }
                break;
            case IDENT:
                {
                alt25=5;
                }
                break;
            case 33:
                {
                alt25=6;
                }
                break;
            case 50:
                {
                alt25=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // Dialog.g:175:5: '(' expression ')'
                    {
                    match(input,16,FOLLOW_16_in_term1302); 

                    pushFollow(FOLLOW_expression_in_term1304);
                    expression12=expression();

                    state._fsp--;


                    match(input,17,FOLLOW_17_in_term1306); 

                     value = expression12; 

                    }
                    break;
                case 2 :
                    // Dialog.g:176:7: b= bool
                    {
                    pushFollow(FOLLOW_bool_in_term1318);
                    b=bool();

                    state._fsp--;


                     value = BooleanEvaluator.create(b); 

                    }
                    break;
                case 3 :
                    // Dialog.g:177:7: NUMBER
                    {
                    NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term1328); 

                     value = NumberEvaluator.create((NUMBER13!=null?NUMBER13.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:178:7: STRING_LITERAL
                    {
                    STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1338); 

                     value = StringEvaluator.create((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null), this.variableSource); 

                    }
                    break;
                case 5 :
                    // Dialog.g:179:7: q= query
                    {
                    pushFollow(FOLLOW_query_in_term1350);
                    q=query();

                    state._fsp--;


                     value = VariableEvaluator.create(variableSource, (q!=null?input.toString(q.start,q.stop):null)); 

                    }
                    break;
                case 6 :
                    // Dialog.g:180:7: '[' (exp1= expression ( ',' exp2= expression )* )? ']'
                    {
                    match(input,33,FOLLOW_33_in_term1361); 

                     List<Evaluator> array = Lists.newArrayList(); 

                    // Dialog.g:182:13: (exp1= expression ( ',' exp2= expression )* )?
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==IDENT||(LA22_0 >= NUMBER && LA22_0 <= STRING_LITERAL)||LA22_0==16||LA22_0==20||LA22_0==22||LA22_0==33||LA22_0==38||LA22_0==48||LA22_0==50) ) {
                        alt22=1;
                    }
                    switch (alt22) {
                        case 1 :
                            // Dialog.g:183:14: exp1= expression ( ',' exp2= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_term1407);
                            exp1=expression();

                            state._fsp--;


                             array.add(exp1); 

                            // Dialog.g:184:14: ( ',' exp2= expression )*
                            loop21:
                            do {
                                int alt21=2;
                                int LA21_0 = input.LA(1);

                                if ( (LA21_0==21) ) {
                                    alt21=1;
                                }


                                switch (alt21) {
                            	case 1 :
                            	    // Dialog.g:184:15: ',' exp2= expression
                            	    {
                            	    match(input,21,FOLLOW_21_in_term1425); 

                            	    pushFollow(FOLLOW_expression_in_term1429);
                            	    exp2=expression();

                            	    state._fsp--;


                            	     array.add(exp2); 

                            	    }
                            	    break;

                            	default :
                            	    break loop21;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,34,FOLLOW_34_in_term1456); 

                     value = ArrayEvaluator.create(array); 

                    }
                    break;
                case 7 :
                    // Dialog.g:187:7: '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}'
                    {
                    match(input,50,FOLLOW_50_in_term1466); 

                     Map<String, Evaluator> vars = Maps.newHashMap(); 

                    // Dialog.g:189:11: ( map_pair[vars] ( ',' map_pair[vars] )* )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==STRING_LITERAL) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // Dialog.g:189:12: map_pair[vars] ( ',' map_pair[vars] )*
                            {
                            pushFollow(FOLLOW_map_pair_in_term1492);
                            map_pair(vars);

                            state._fsp--;


                            // Dialog.g:189:27: ( ',' map_pair[vars] )*
                            loop23:
                            do {
                                int alt23=2;
                                int LA23_0 = input.LA(1);

                                if ( (LA23_0==21) ) {
                                    alt23=1;
                                }


                                switch (alt23) {
                            	case 1 :
                            	    // Dialog.g:189:28: ',' map_pair[vars]
                            	    {
                            	    match(input,21,FOLLOW_21_in_term1496); 

                            	    pushFollow(FOLLOW_map_pair_in_term1498);
                            	    map_pair(vars);

                            	    state._fsp--;


                            	    }
                            	    break;

                            	default :
                            	    break loop23;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,51,FOLLOW_51_in_term1511); 

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
    // Dialog.g:193:1: bool returns [boolean value] : ( 'true' | 'false' ) ;
    public final boolean bool() throws RecognitionException {
        boolean value = false;


        try {
            // Dialog.g:193:30: ( ( 'true' | 'false' ) )
            // Dialog.g:194:5: ( 'true' | 'false' )
            {
            // Dialog.g:194:5: ( 'true' | 'false' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==48) ) {
                alt26=1;
            }
            else if ( (LA26_0==38) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // Dialog.g:194:6: 'true'
                    {
                    match(input,48,FOLLOW_48_in_bool1535); 

                     value = true; 

                    }
                    break;
                case 2 :
                    // Dialog.g:194:34: 'false'
                    {
                    match(input,38,FOLLOW_38_in_bool1541); 

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
    // Dialog.g:196:1: map_pair[Map<String, Evaluator> vars] : k= STRING_LITERAL ':' expression ;
    public final void map_pair(Map<String, Evaluator> vars) throws RecognitionException {
        Token k=null;
        Evaluator expression15 =null;


        try {
            // Dialog.g:196:40: (k= STRING_LITERAL ':' expression )
            // Dialog.g:197:5: k= STRING_LITERAL ':' expression
            {
            k=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_pair1564); 

            match(input,26,FOLLOW_26_in_map_pair1566); 

            pushFollow(FOLLOW_expression_in_map_pair1568);
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
    // Dialog.g:199:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:199:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt27=7;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt27=1;
                }
                break;
            case 49:
                {
                alt27=2;
                }
                break;
            case 41:
                {
                alt27=3;
                }
                break;
            case 46:
                {
                alt27=4;
                }
                break;
            case 40:
                {
                alt27=5;
                }
                break;
            case 39:
                {
                alt27=6;
                }
                break;
            case 36:
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
                    // Dialog.g:200:5: 'ns'
                    {
                    match(input,42,FOLLOW_42_in_time_unit1586); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:201:7: 'us'
                    {
                    match(input,49,FOLLOW_49_in_time_unit1596); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:202:7: 'ms'
                    {
                    match(input,41,FOLLOW_41_in_time_unit1606); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:203:7: 's'
                    {
                    match(input,46,FOLLOW_46_in_time_unit1616); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:204:7: 'm'
                    {
                    match(input,40,FOLLOW_40_in_time_unit1626); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:205:7: 'h'
                    {
                    match(input,39,FOLLOW_39_in_time_unit1636); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:206:7: 'd'
                    {
                    match(input,36,FOLLOW_36_in_time_unit1646); 

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
    // Dialog.g:209:1: query : IDENT ( '.' IDENT )* ;
    public final DialogParser.query_return query() throws RecognitionException {
        DialogParser.query_return retval = new DialogParser.query_return();
        retval.start = input.LT(1);


        try {
            // Dialog.g:209:7: ( IDENT ( '.' IDENT )* )
            // Dialog.g:210:5: IDENT ( '.' IDENT )*
            {
            match(input,IDENT,FOLLOW_IDENT_in_query1667); 

            // Dialog.g:210:11: ( '.' IDENT )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==24) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Dialog.g:210:12: '.' IDENT
            	    {
            	    match(input,24,FOLLOW_24_in_query1670); 

            	    match(input,IDENT,FOLLOW_IDENT_in_query1672); 

            	    }
            	    break;

            	default :
            	    break loop28;
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
    public static final BitSet FOLLOW_IDENT_in_name152 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_name154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_name158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_response196 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_response198 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_response203 = new BitSet(new long[]{0x0008080000000020L});
    public static final BitSet FOLLOW_response_statement_in_response206 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_response209 = new BitSet(new long[]{0x0008080000000020L});
    public static final BitSet FOLLOW_51_in_response213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_response_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule279 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule281 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_rule295 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_criteria_in_rule297 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule302 = new BitSet(new long[]{0x0008180000000020L});
    public static final BitSet FOLLOW_rule_statement_in_rule318 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rule321 = new BitSet(new long[]{0x0008180000000020L});
    public static final BitSet FOLLOW_51_in_rule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule_statement364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule_statement368 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_47_in_rule_statement409 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement414 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_rule_statement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_generic_statement507 = new BitSet(new long[]{0x0005004200511822L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement528 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_generic_statement554 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement558 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_IDENT_in_argument_decl609 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_argument_decl611 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_argument_decl615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument_decl627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_remember_statement655 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement657 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_21_in_remember_statement661 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement663 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_query_in_remember_assignment699 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_remember_assignment701 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_remember_assignment703 = new BitSet(new long[]{0x0000000000800042L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment730 = new BitSet(new long[]{0x0002479000000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment734 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_remember_assignment772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_criteria829 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_criteria853 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria857 = new BitSet(new long[]{0x0000000000200022L});
    public static final BitSet FOLLOW_21_in_criteria863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria867 = new BitSet(new long[]{0x0000000000200022L});
    public static final BitSet FOLLOW_IDENT_in_criteria907 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria909 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria913 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria929 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria931 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria935 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria951 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria953 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria957 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria973 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria975 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria979 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria995 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_criteria997 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria1001 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria1017 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_criteria1019 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_criteria1023 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria1039 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_criteria1041 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_criteria1045 = new BitSet(new long[]{0x001FFFFFFDFFFFF0L});
    public static final BitSet FOLLOW_set_in_criteria1049 = new BitSet(new long[]{0x001FFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_25_in_criteria1055 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria1071 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression1102 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_20_in_expression1116 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_mult_in_expression1120 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_22_in_expression1131 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_mult_in_expression1135 = new BitSet(new long[]{0x0000000000500002L});
    public static final BitSet FOLLOW_20_in_unary1167 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_22_in_unary1171 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_term_in_unary1181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult1201 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_18_in_mult1219 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1223 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_25_in_mult1237 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1241 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_15_in_mult1255 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1259 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_19_in_mult1273 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_unary_in_mult1277 = new BitSet(new long[]{0x00000000020C8002L});
    public static final BitSet FOLLOW_16_in_term1302 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_term1304 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term1306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_term1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_term1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_term1361 = new BitSet(new long[]{0x0005004600511820L});
    public static final BitSet FOLLOW_expression_in_term1407 = new BitSet(new long[]{0x0000000400200000L});
    public static final BitSet FOLLOW_21_in_term1425 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_term1429 = new BitSet(new long[]{0x0000000400200000L});
    public static final BitSet FOLLOW_34_in_term1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_term1466 = new BitSet(new long[]{0x0008000000001000L});
    public static final BitSet FOLLOW_map_pair_in_term1492 = new BitSet(new long[]{0x0008000000200000L});
    public static final BitSet FOLLOW_21_in_term1496 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_map_pair_in_term1498 = new BitSet(new long[]{0x0008000000200000L});
    public static final BitSet FOLLOW_51_in_term1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_bool1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_bool1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_map_pair1564 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_map_pair1566 = new BitSet(new long[]{0x0005004200511820L});
    public static final BitSet FOLLOW_expression_in_map_pair1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_time_unit1586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_time_unit1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_time_unit1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_time_unit1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_time_unit1626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_time_unit1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_time_unit1646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_query1667 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_query1670 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_query1672 = new BitSet(new long[]{0x0000000001000002L});

}