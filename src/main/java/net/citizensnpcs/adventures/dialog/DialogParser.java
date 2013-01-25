// $ANTLR 3.4 Dialog.g 2013-01-25 23:15:19

package net.citizensnpcs.adventures.dialog;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "QUERY_STRING", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'**'", "'+'", "','", "'-'", "'-p'", "'/'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'criteria'", "'d'", "'events='", "'h'", "'log'", "'m'", "'ms'", "'ns'", "'remember'", "'response'", "'rule'", "'s'", "'then'", "'us'", "'{'", "'}'"
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
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int INTEGER=6;
    public static final int LETTER=7;
    public static final int LINE_COMMENT=8;
    public static final int ML_COMMENT=9;
    public static final int NEWLINE=10;
    public static final int NUMBER=11;
    public static final int QUERY_STRING=12;
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
    // Dialog.g:48:1: program[DialogEngine.ParseContext context] : ( rule[context] | response[context] )* ;
    public final void program(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return rule1 =null;

        Response response2 =null;


        try {
            // Dialog.g:48:45: ( ( rule[context] | response[context] )* )
            // Dialog.g:49:5: ( rule[context] | response[context] )*
            {
            // Dialog.g:49:5: ( rule[context] | response[context] )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==42) ) {
                    alt1=1;
                }
                else if ( (LA1_0==41) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:50:9: rule[context]
            	    {
            	    pushFollow(FOLLOW_rule_in_program81);
            	    rule1=rule(context);

            	    state._fsp--;


            	     context.ruleLoaded((rule1!=null?rule1.eventNames:null), (rule1!=null?rule1.rule:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:51:11: response[context]
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
    // Dialog.g:54:1: name[DialogEngine.ParseContext context] returns [String name] : (i1= IDENT |i2= IDENT '/' i3= IDENT ) ;
    public final String name(DialogEngine.ParseContext context) throws RecognitionException {
        String name = null;


        Token i1=null;
        Token i2=null;
        Token i3=null;

        try {
            // Dialog.g:54:64: ( (i1= IDENT |i2= IDENT '/' i3= IDENT ) )
            // Dialog.g:55:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            {
            // Dialog.g:55:5: (i1= IDENT |i2= IDENT '/' i3= IDENT )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==25) ) {
                    alt2=2;
                }
                else if ( (LA2_1==26||LA2_1==44||LA2_1==46) ) {
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
                    // Dialog.g:56:9: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_name136); 

                     name = context.disambiguateName((i1!=null?i1.getText():null)); 

                    }
                    break;
                case 2 :
                    // Dialog.g:57:11: i2= IDENT '/' i3= IDENT
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
    // Dialog.g:61:1: response[DialogEngine.ParseContext context] returns [Response response] : 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' ;
    public final Response response(DialogEngine.ParseContext context) throws RecognitionException {
        Response response = null;


        String name3 =null;


        try {
            // Dialog.g:61:74: ( 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}' )
            // Dialog.g:62:5: 'response' name[context] '{' ( response_statement[context, builder] ';' )* '}'
            {
             Response.Builder builder = Response.builder(); 

            match(input,41,FOLLOW_41_in_response197); 

            pushFollow(FOLLOW_name_in_response199);
            name3=name(context);

            state._fsp--;


             builder.name(name3); 

            match(input,46,FOLLOW_46_in_response204); 

            // Dialog.g:63:64: ( response_statement[context, builder] ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==36||LA3_0==40) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:63:65: response_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response207);
            	    response_statement(context, builder);

            	    state._fsp--;


            	    match(input,26,FOLLOW_26_in_response210); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,47,FOLLOW_47_in_response214); 

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
    // Dialog.g:67:1: response_statement[DialogEngine.ParseContext context, Response.Builder builder] : ( 'log' expression | remember_statement );
    public final void response_statement(DialogEngine.ParseContext context, Response.Builder builder) throws RecognitionException {
        Evaluator expression4 =null;

        QueryRunnable remember_statement5 =null;


        try {
            // Dialog.g:67:82: ( 'log' expression | remember_statement )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==36) ) {
                alt4=1;
            }
            else if ( (LA4_0==40) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Dialog.g:68:5: 'log' expression
                    {
                    match(input,36,FOLLOW_36_in_response_statement239); 

                    pushFollow(FOLLOW_expression_in_response_statement241);
                    expression4=expression();

                    state._fsp--;


                     builder.statement(Log.logging(expression4)); 

                    }
                    break;
                case 2 :
                    // Dialog.g:69:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_response_statement251);
                    remember_statement5=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement5); 

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
    // Dialog.g:72:1: rule[DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule] : 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' ;
    public final DialogParser.rule_return rule(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        String name6 =null;

        Collection<String> criteria7 =null;


        try {
            // Dialog.g:72:92: ( 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' )
            // Dialog.g:73:5: 'rule' name[context] '{' criteria ';' ( rule_statement[context, builder] ';' )* '}'
            {
             Rule.Builder builder = Rule.builder(); 

            match(input,42,FOLLOW_42_in_rule281); 

            pushFollow(FOLLOW_name_in_rule283);
            name6=name(context);

            state._fsp--;


             builder.name(name6); 

            match(input,46,FOLLOW_46_in_rule288); 

            pushFollow(FOLLOW_criteria_in_rule290);
            criteria7=criteria();

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,26,FOLLOW_26_in_rule294); 

            // Dialog.g:74:113: ( rule_statement[context, builder] ';' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= 40 && LA5_0 <= 41)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:74:114: rule_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule297);
            	    rule_statement(context, builder);

            	    state._fsp--;


            	    match(input,26,FOLLOW_26_in_rule300); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,47,FOLLOW_47_in_rule304); 

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
    // Dialog.g:78:1: rule_statement[DialogEngine.ParseContext context, Rule.Builder builder] : ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement );
    public final void rule_statement(DialogEngine.ParseContext context, Rule.Builder builder) throws RecognitionException {
        Token target=null;
        Token event=null;
        String n =null;

        QueryRunnable remember_statement8 =null;


        try {
            // Dialog.g:78:74: ( ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==41) ) {
                alt8=1;
            }
            else if ( (LA8_0==40) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // Dialog.g:79:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    {
                    // Dialog.g:79:5: ( 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    // Dialog.g:79:6: 'response' n= name[context] ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    {
                    match(input,41,FOLLOW_41_in_rule_statement334); 

                    pushFollow(FOLLOW_name_in_rule_statement338);
                    n=name(context);

                    state._fsp--;


                     CallResponse.Builder responseBuilder = CallResponse.builder(n); 

                    // Dialog.g:80:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==44) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Dialog.g:82:13: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,44,FOLLOW_44_in_rule_statement379); 

                            // Dialog.g:82:20: (target= IDENT |target= NUMBER )
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
                                    // Dialog.g:82:21: target= IDENT
                                    {
                                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement384); 

                                    }
                                    break;
                                case 2 :
                                    // Dialog.g:82:36: target= NUMBER
                                    {
                                    target=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule_statement390); 

                                    }
                                    break;

                            }


                            event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement395); 

                             responseBuilder.callback(new CallEventCallback((target!=null?target.getText():null), (event!=null?event.getText():null))); 

                            }
                            break;

                    }


                     builder.statement(responseBuilder.build()); 

                    }


                    }
                    break;
                case 2 :
                    // Dialog.g:86:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_rule_statement433);
                    remember_statement8=remember_statement();

                    state._fsp--;


                     builder.statement(remember_statement8); 

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



    // $ANTLR start "remember_statement"
    // Dialog.g:89:1: remember_statement returns [QueryRunnable statement] : 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* ;
    public final QueryRunnable remember_statement() throws RecognitionException {
        QueryRunnable statement = null;


        try {
            // Dialog.g:89:54: ( 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* )
            // Dialog.g:90:5: 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )*
            {
             Remember.Builder builder = Remember.builder(); 

            match(input,40,FOLLOW_40_in_remember_statement466); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement468);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:91:45: ( ',' remember_assignment[builder] )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==22) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Dialog.g:91:46: ',' remember_assignment[builder]
            	    {
            	    match(input,22,FOLLOW_22_in_remember_statement472); 

            	    pushFollow(FOLLOW_remember_assignment_in_remember_statement474);
            	    remember_assignment(builder);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // Dialog.g:95:1: remember_assignment[Remember.Builder builder] : QUERY_STRING '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token i1=null;
        Token QUERY_STRING9=null;
        TimeUnit i2 =null;

        Evaluator expression10 =null;


        try {
            // Dialog.g:95:48: ( QUERY_STRING '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )? )
            // Dialog.g:96:5: QUERY_STRING '=' expression (i1= INTEGER i2= time_unit )? ( '-p' )?
            {
             boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; 

            QUERY_STRING9=(Token)match(input,QUERY_STRING,FOLLOW_QUERY_STRING_in_remember_assignment508); 

            match(input,29,FOLLOW_29_in_remember_assignment510); 

            pushFollow(FOLLOW_expression_in_remember_assignment512);
            expression10=expression();

            state._fsp--;


            // Dialog.g:98:9: (i1= INTEGER i2= time_unit )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==INTEGER) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // Dialog.g:99:13: i1= INTEGER i2= time_unit
                    {
                    i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_remember_assignment539); 

                    pushFollow(FOLLOW_time_unit_in_remember_assignment543);
                    i2=time_unit();

                    state._fsp--;


                     expiration = Long.parseLong((i1!=null?i1.getText():null)); unit = i2; 

                    }
                    break;

            }


            // Dialog.g:101:9: ( '-p' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // Dialog.g:102:13: '-p'
                    {
                    match(input,24,FOLLOW_24_in_remember_assignment581); 

                     isPersistent = true; 

                    }
                    break;

            }


             builder.remember((QUERY_STRING9!=null?QUERY_STRING9.getText():null), expression10, ExpirationTime.expiringAt(expiration, unit, isPersistent)); 

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
    // Dialog.g:107:1: criteria returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* ;
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
            // Dialog.g:107:49: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* )
            // Dialog.g:108:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,32,FOLLOW_32_in_criteria636); 

            // Dialog.g:109:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:110:21: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,34,FOLLOW_34_in_criteria660); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria664); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:110:72: ( ',' e2= IDENT )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==22) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // Dialog.g:110:73: ',' e2= IDENT
            	    {
            	    match(input,22,FOLLOW_22_in_criteria670); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria674); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            // Dialog.g:112:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            loop13:
            do {
                int alt13=8;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 29:
                        {
                        alt13=1;
                        }
                        break;
                    case 30:
                        {
                        alt13=2;
                        }
                        break;
                    case 27:
                        {
                        alt13=3;
                        }
                        break;
                    case 28:
                        {
                        alt13=4;
                        }
                        break;
                    case 31:
                        {
                        alt13=5;
                        }
                        break;
                    case 15:
                        {
                        alt13=6;
                        }
                        break;
                    case IDENT:
                    case 26:
                        {
                        alt13=7;
                        }
                        break;

                    }

                }


                switch (alt13) {
            	case 1 :
            	    // Dialog.g:113:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria714); 

            	    match(input,29,FOLLOW_29_in_criteria716); 

            	    pushFollow(FOLLOW_expression_in_criteria720);
            	    op1=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), op1); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:114:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria736); 

            	    match(input,30,FOLLOW_30_in_criteria738); 

            	    pushFollow(FOLLOW_expression_in_criteria742);
            	    op2=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:115:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria758); 

            	    match(input,27,FOLLOW_27_in_criteria760); 

            	    pushFollow(FOLLOW_expression_in_criteria764);
            	    op3=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), op3); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:116:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria780); 

            	    match(input,28,FOLLOW_28_in_criteria782); 

            	    pushFollow(FOLLOW_expression_in_criteria786);
            	    op4=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), op4); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:117:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria802); 

            	    match(input,31,FOLLOW_31_in_criteria804); 

            	    pushFollow(FOLLOW_expression_in_criteria808);
            	    op5=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), op5); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:118:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria824); 

            	    match(input,15,FOLLOW_15_in_criteria826); 

            	    pushFollow(FOLLOW_expression_in_criteria830);
            	    op6=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.not((i6!=null?i6.getText():null), op6);

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:119:11: i7= IDENT
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria846); 

            	     NumberQueryPredicate.of((i7!=null?i7.getText():null), Predicates.<Number>alwaysTrue()); 

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // Dialog.g:122:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:122:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:123:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression877);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:124:5: ( '+' op2= mult | '-' op2= mult )*
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==21) ) {
                    alt14=1;
                }
                else if ( (LA14_0==23) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // Dialog.g:125:5: '+' op2= mult
            	    {
            	    match(input,21,FOLLOW_21_in_expression891); 

            	    pushFollow(FOLLOW_mult_in_expression895);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:126:8: '-' op2= mult
            	    {
            	    match(input,23,FOLLOW_23_in_expression906); 

            	    pushFollow(FOLLOW_mult_in_expression910);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // Dialog.g:129:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term11 =null;


        try {
            // Dialog.g:129:33: ( ( '+' | '-' )* term )
            // Dialog.g:130:5: ( '+' | '-' )* term
            {
            boolean positive = true;

            // Dialog.g:131:5: ( '+' | '-' )*
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==21) ) {
                    alt15=1;
                }
                else if ( (LA15_0==23) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // Dialog.g:131:6: '+'
            	    {
            	    match(input,21,FOLLOW_21_in_unary942); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:131:12: '-'
            	    {
            	    match(input,23,FOLLOW_23_in_unary946); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary956);
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
    // Dialog.g:138:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:138:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:139:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult976);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:140:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop16:
            do {
                int alt16=5;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    alt16=1;
                    }
                    break;
                case 25:
                    {
                    alt16=2;
                    }
                    break;
                case 16:
                    {
                    alt16=3;
                    }
                    break;
                case 20:
                    {
                    alt16=4;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // Dialog.g:141:9: '*' op2= unary
            	    {
            	    match(input,19,FOLLOW_19_in_mult994); 

            	    pushFollow(FOLLOW_unary_in_mult998);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:142:11: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult1012); 

            	    pushFollow(FOLLOW_unary_in_mult1016);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:143:11: '%' op2= unary
            	    {
            	    match(input,16,FOLLOW_16_in_mult1030); 

            	    pushFollow(FOLLOW_unary_in_mult1034);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:144:11: '**' op2= unary
            	    {
            	    match(input,20,FOLLOW_20_in_mult1048); 

            	    pushFollow(FOLLOW_unary_in_mult1052);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

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
        return value;
    }
    // $ANTLR end "mult"



    // $ANTLR start "term"
    // Dialog.g:147:1: term returns [Evaluator value] : ( '(' expression ')' | NUMBER | STRING_LITERAL | QUERY_STRING );
    public final Evaluator term() throws RecognitionException {
        Evaluator value = null;


        Token NUMBER13=null;
        Token STRING_LITERAL14=null;
        Token QUERY_STRING15=null;
        Evaluator expression12 =null;


        try {
            // Dialog.g:147:32: ( '(' expression ')' | NUMBER | STRING_LITERAL | QUERY_STRING )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt17=1;
                }
                break;
            case NUMBER:
                {
                alt17=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt17=3;
                }
                break;
            case QUERY_STRING:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // Dialog.g:148:5: '(' expression ')'
                    {
                    match(input,17,FOLLOW_17_in_term1077); 

                    pushFollow(FOLLOW_expression_in_term1079);
                    expression12=expression();

                    state._fsp--;


                    match(input,18,FOLLOW_18_in_term1081); 

                     value = expression12; 

                    }
                    break;
                case 2 :
                    // Dialog.g:149:7: NUMBER
                    {
                    NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term1091); 

                     value = NumberEvaluator.create((NUMBER13!=null?NUMBER13.getText():null)); 

                    }
                    break;
                case 3 :
                    // Dialog.g:150:7: STRING_LITERAL
                    {
                    STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1101); 

                     value = StringEvaluator.create((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:151:7: QUERY_STRING
                    {
                    QUERY_STRING15=(Token)match(input,QUERY_STRING,FOLLOW_QUERY_STRING_in_term1111); 

                     value = VariableEvaluator.create(variableSource, (QUERY_STRING15!=null?QUERY_STRING15.getText():null)); 

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



    // $ANTLR start "time_unit"
    // Dialog.g:153:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:153:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt18=7;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt18=1;
                }
                break;
            case 45:
                {
                alt18=2;
                }
                break;
            case 38:
                {
                alt18=3;
                }
                break;
            case 43:
                {
                alt18=4;
                }
                break;
            case 37:
                {
                alt18=5;
                }
                break;
            case 35:
                {
                alt18=6;
                }
                break;
            case 33:
                {
                alt18=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // Dialog.g:154:5: 'ns'
                    {
                    match(input,39,FOLLOW_39_in_time_unit1130); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:155:7: 'us'
                    {
                    match(input,45,FOLLOW_45_in_time_unit1140); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:156:7: 'ms'
                    {
                    match(input,38,FOLLOW_38_in_time_unit1150); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:157:7: 's'
                    {
                    match(input,43,FOLLOW_43_in_time_unit1160); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:158:7: 'm'
                    {
                    match(input,37,FOLLOW_37_in_time_unit1170); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:159:7: 'h'
                    {
                    match(input,35,FOLLOW_35_in_time_unit1180); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:160:7: 'd'
                    {
                    match(input,33,FOLLOW_33_in_time_unit1190); 

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


 

    public static final BitSet FOLLOW_rule_in_program81 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_response_in_program96 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_IDENT_in_name136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name153 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_name155 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_name159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_response197 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_response199 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_response204 = new BitSet(new long[]{0x0000811000000000L});
    public static final BitSet FOLLOW_response_statement_in_response207 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_response210 = new BitSet(new long[]{0x0000811000000000L});
    public static final BitSet FOLLOW_47_in_response214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_response_statement239 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_response_statement241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule281 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule283 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_rule288 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_criteria_in_rule290 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rule294 = new BitSet(new long[]{0x0000830000000000L});
    public static final BitSet FOLLOW_rule_statement_in_rule297 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rule300 = new BitSet(new long[]{0x0000830000000000L});
    public static final BitSet FOLLOW_47_in_rule304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule_statement334 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule_statement338 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_rule_statement379 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement384 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement390 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_remember_statement466 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement468 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_remember_statement472 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement474 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_QUERY_STRING_in_remember_assignment508 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_remember_assignment510 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_remember_assignment512 = new BitSet(new long[]{0x0000000001000042L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment539 = new BitSet(new long[]{0x000028EA00000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment543 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_remember_assignment581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_criteria636 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_criteria660 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria664 = new BitSet(new long[]{0x0000000000400022L});
    public static final BitSet FOLLOW_22_in_criteria670 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria674 = new BitSet(new long[]{0x0000000000400022L});
    public static final BitSet FOLLOW_IDENT_in_criteria714 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria716 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria720 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria736 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria738 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria742 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria758 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_criteria760 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria764 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria780 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria782 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria786 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria802 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria804 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria808 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria824 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_criteria826 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria830 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria846 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression877 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_expression891 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_mult_in_expression895 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_23_in_expression906 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_mult_in_expression910 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_unary942 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_23_in_unary946 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_term_in_unary956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult976 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_19_in_mult994 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult998 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_25_in_mult1012 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult1016 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_16_in_mult1030 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult1034 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_20_in_mult1048 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult1052 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_17_in_term1077 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_term1079 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_term1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term1091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_STRING_in_term1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_time_unit1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_time_unit1140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_time_unit1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_time_unit1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_time_unit1170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_time_unit1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_time_unit1190 = new BitSet(new long[]{0x0000000000000002L});

}