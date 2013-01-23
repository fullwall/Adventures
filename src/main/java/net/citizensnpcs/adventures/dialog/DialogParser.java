// $ANTLR 3.4 Dialog.g 2013-01-23 22:45:31

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



    // $ANTLR start "response"
    // Dialog.g:54:1: response[DialogEngine.ParseContext context] returns [Response response] : 'response' IDENT '{' ( response_statement[context, builder] ';' )* '}' ;
    public final Response response(DialogEngine.ParseContext context) throws RecognitionException {
        Response response = null;


        Token IDENT3=null;

        try {
            // Dialog.g:54:74: ( 'response' IDENT '{' ( response_statement[context, builder] ';' )* '}' )
            // Dialog.g:55:5: 'response' IDENT '{' ( response_statement[context, builder] ';' )* '}'
            {
             Response.Builder builder = Response.builder(); 

            match(input,41,FOLLOW_41_in_response131); 

            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_response133); 

             builder.name(context.disambiguateName((IDENT3!=null?IDENT3.getText():null))); 

            match(input,46,FOLLOW_46_in_response137); 

            // Dialog.g:56:83: ( response_statement[context, builder] ';' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==36||LA2_0==40) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Dialog.g:56:84: response_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response140);
            	    response_statement(context, builder);

            	    state._fsp--;


            	    match(input,26,FOLLOW_26_in_response143); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            match(input,47,FOLLOW_47_in_response147); 

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
    // Dialog.g:60:1: response_statement[DialogEngine.ParseContext context, Response.Builder builder] : ( 'log' expression | remember_statement );
    public final void response_statement(DialogEngine.ParseContext context, Response.Builder builder) throws RecognitionException {
        Evaluator expression4 =null;

        QueryRunnable remember_statement5 =null;


        try {
            // Dialog.g:60:82: ( 'log' expression | remember_statement )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==36) ) {
                alt3=1;
            }
            else if ( (LA3_0==40) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // Dialog.g:61:5: 'log' expression
                    {
                    match(input,36,FOLLOW_36_in_response_statement172); 

                    pushFollow(FOLLOW_expression_in_response_statement174);
                    expression4=expression();

                    state._fsp--;


                     builder.statement(Log.logging(expression4)); 

                    }
                    break;
                case 2 :
                    // Dialog.g:62:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_response_statement184);
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
    // Dialog.g:65:1: rule[DialogEngine.ParseContext context] returns [Collection<String> eventNames, Rule rule] : 'rule' IDENT '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' ;
    public final DialogParser.rule_return rule(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        Token IDENT6=null;
        Collection<String> criteria7 =null;


        try {
            // Dialog.g:65:92: ( 'rule' IDENT '{' criteria ';' ( rule_statement[context, builder] ';' )* '}' )
            // Dialog.g:66:5: 'rule' IDENT '{' criteria ';' ( rule_statement[context, builder] ';' )* '}'
            {
             Rule.Builder builder = Rule.builder(); 

            match(input,42,FOLLOW_42_in_rule215); 

            IDENT6=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule217); 

             builder.name(context.disambiguateName((IDENT6!=null?IDENT6.getText():null))); 

            match(input,46,FOLLOW_46_in_rule221); 

            pushFollow(FOLLOW_criteria_in_rule223);
            criteria7=criteria();

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,26,FOLLOW_26_in_rule227); 

            // Dialog.g:67:132: ( rule_statement[context, builder] ';' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= 40 && LA4_0 <= 41)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Dialog.g:67:133: rule_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule230);
            	    rule_statement(context, builder);

            	    state._fsp--;


            	    match(input,26,FOLLOW_26_in_rule233); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            match(input,47,FOLLOW_47_in_rule237); 

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
    // Dialog.g:71:1: rule_statement[DialogEngine.ParseContext context, Rule.Builder builder] : ( ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement );
    public final void rule_statement(DialogEngine.ParseContext context, Rule.Builder builder) throws RecognitionException {
        Token n=null;
        Token target=null;
        Token event=null;
        QueryRunnable remember_statement8 =null;


        try {
            // Dialog.g:71:74: ( ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) | remember_statement )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==41) ) {
                alt7=1;
            }
            else if ( (LA7_0==40) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Dialog.g:72:5: ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    {
                    // Dialog.g:72:5: ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
                    // Dialog.g:72:6: 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    {
                    match(input,41,FOLLOW_41_in_rule_statement267); 

                    n=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement271); 

                     CallResponse.Builder responseBuilder = CallResponse.builder(context.disambiguateName((n!=null?n.getText():null))); 

                    // Dialog.g:73:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==44) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // Dialog.g:73:10: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,44,FOLLOW_44_in_rule_statement285); 

                            // Dialog.g:73:17: (target= IDENT |target= NUMBER )
                            int alt5=2;
                            int LA5_0 = input.LA(1);

                            if ( (LA5_0==IDENT) ) {
                                alt5=1;
                            }
                            else if ( (LA5_0==NUMBER) ) {
                                alt5=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 5, 0, input);

                                throw nvae;

                            }
                            switch (alt5) {
                                case 1 :
                                    // Dialog.g:73:18: target= IDENT
                                    {
                                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement290); 

                                    }
                                    break;
                                case 2 :
                                    // Dialog.g:73:33: target= NUMBER
                                    {
                                    target=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule_statement296); 

                                    }
                                    break;

                            }


                            event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement301); 

                             responseBuilder.callback(new CallEventCallback(context.disambiguateName((target!=null?target.getText():null)), (event!=null?event.getText():null))); 

                            }
                            break;

                    }


                     builder.statement(responseBuilder.build()); 

                    }


                    }
                    break;
                case 2 :
                    // Dialog.g:75:7: remember_statement
                    {
                    pushFollow(FOLLOW_remember_statement_in_rule_statement325);
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
    // Dialog.g:78:1: remember_statement returns [QueryRunnable statement] : 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* ;
    public final QueryRunnable remember_statement() throws RecognitionException {
        QueryRunnable statement = null;


        try {
            // Dialog.g:78:54: ( 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )* )
            // Dialog.g:79:5: 'remember' remember_assignment[builder] ( ',' remember_assignment[builder] )*
            {
             Remember.Builder builder = Remember.builder(); 

            match(input,40,FOLLOW_40_in_remember_statement354); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement356);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:80:45: ( ',' remember_assignment[builder] )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Dialog.g:80:46: ',' remember_assignment[builder]
            	    {
            	    match(input,22,FOLLOW_22_in_remember_statement360); 

            	    pushFollow(FOLLOW_remember_assignment_in_remember_statement362);
            	    remember_assignment(builder);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // Dialog.g:84:1: remember_assignment[Remember.Builder builder] : QUERY_STRING '=' expression i1= INTEGER i2= time_unit ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token i1=null;
        Token QUERY_STRING9=null;
        TimeUnit i2 =null;

        Evaluator expression10 =null;


        try {
            // Dialog.g:84:48: ( QUERY_STRING '=' expression i1= INTEGER i2= time_unit ( '-p' )? )
            // Dialog.g:85:5: QUERY_STRING '=' expression i1= INTEGER i2= time_unit ( '-p' )?
            {
             boolean isPersistent = false; 

            QUERY_STRING9=(Token)match(input,QUERY_STRING,FOLLOW_QUERY_STRING_in_remember_assignment396); 

            match(input,29,FOLLOW_29_in_remember_assignment398); 

            pushFollow(FOLLOW_expression_in_remember_assignment400);
            expression10=expression();

            state._fsp--;


            i1=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_remember_assignment404); 

            pushFollow(FOLLOW_time_unit_in_remember_assignment408);
            i2=time_unit();

            state._fsp--;


            // Dialog.g:86:57: ( '-p' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Dialog.g:86:58: '-p'
                    {
                    match(input,24,FOLLOW_24_in_remember_assignment411); 

                     isPersistent = true; 

                    }
                    break;

            }


             builder.remember((QUERY_STRING9!=null?QUERY_STRING9.getText():null), expression10, ExpirationTime.expiringAt(Long.parseLong((i1!=null?i1.getText():null)), i2, isPersistent)); 

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
    // Dialog.g:90:1: criteria returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* ;
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
            // Dialog.g:90:49: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* )
            // Dialog.g:91:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,32,FOLLOW_32_in_criteria457); 

            // Dialog.g:92:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:92:17: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,34,FOLLOW_34_in_criteria460); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria464); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:92:68: ( ',' e2= IDENT )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // Dialog.g:92:69: ',' e2= IDENT
            	    {
            	    match(input,22,FOLLOW_22_in_criteria470); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria474); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            // Dialog.g:93:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            loop11:
            do {
                int alt11=8;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 29:
                        {
                        alt11=1;
                        }
                        break;
                    case 30:
                        {
                        alt11=2;
                        }
                        break;
                    case 27:
                        {
                        alt11=3;
                        }
                        break;
                    case 28:
                        {
                        alt11=4;
                        }
                        break;
                    case 31:
                        {
                        alt11=5;
                        }
                        break;
                    case 15:
                        {
                        alt11=6;
                        }
                        break;
                    case IDENT:
                    case 26:
                        {
                        alt11=7;
                        }
                        break;

                    }

                }


                switch (alt11) {
            	case 1 :
            	    // Dialog.g:94:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria498); 

            	    match(input,29,FOLLOW_29_in_criteria500); 

            	    pushFollow(FOLLOW_expression_in_criteria504);
            	    op1=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), op1); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:95:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria520); 

            	    match(input,30,FOLLOW_30_in_criteria522); 

            	    pushFollow(FOLLOW_expression_in_criteria526);
            	    op2=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:96:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria542); 

            	    match(input,27,FOLLOW_27_in_criteria544); 

            	    pushFollow(FOLLOW_expression_in_criteria548);
            	    op3=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), op3); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:97:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria564); 

            	    match(input,28,FOLLOW_28_in_criteria566); 

            	    pushFollow(FOLLOW_expression_in_criteria570);
            	    op4=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), op4); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:98:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria586); 

            	    match(input,31,FOLLOW_31_in_criteria588); 

            	    pushFollow(FOLLOW_expression_in_criteria592);
            	    op5=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), op5); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:99:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria608); 

            	    match(input,15,FOLLOW_15_in_criteria610); 

            	    pushFollow(FOLLOW_expression_in_criteria614);
            	    op6=expression();

            	    state._fsp--;


            	     NumberQueryPredicate.not((i6!=null?i6.getText():null), op6);

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:100:11: i7= IDENT
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria630); 

            	     NumberQueryPredicate.of((i7!=null?i7.getText():null), Predicates.<Number>alwaysTrue()); 

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // Dialog.g:103:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:103:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:104:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression661);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:105:5: ( '+' op2= mult | '-' op2= mult )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==21) ) {
                    alt12=1;
                }
                else if ( (LA12_0==23) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // Dialog.g:106:5: '+' op2= mult
            	    {
            	    match(input,21,FOLLOW_21_in_expression675); 

            	    pushFollow(FOLLOW_mult_in_expression679);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:107:8: '-' op2= mult
            	    {
            	    match(input,23,FOLLOW_23_in_expression690); 

            	    pushFollow(FOLLOW_mult_in_expression694);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // Dialog.g:110:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term11 =null;


        try {
            // Dialog.g:110:33: ( ( '+' | '-' )* term )
            // Dialog.g:111:5: ( '+' | '-' )* term
            {
            boolean positive = true;

            // Dialog.g:112:5: ( '+' | '-' )*
            loop13:
            do {
                int alt13=3;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==21) ) {
                    alt13=1;
                }
                else if ( (LA13_0==23) ) {
                    alt13=2;
                }


                switch (alt13) {
            	case 1 :
            	    // Dialog.g:112:6: '+'
            	    {
            	    match(input,21,FOLLOW_21_in_unary726); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:112:12: '-'
            	    {
            	    match(input,23,FOLLOW_23_in_unary730); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary740);
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
    // Dialog.g:119:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:119:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:120:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult760);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:121:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop14:
            do {
                int alt14=5;
                switch ( input.LA(1) ) {
                case 19:
                    {
                    alt14=1;
                    }
                    break;
                case 25:
                    {
                    alt14=2;
                    }
                    break;
                case 16:
                    {
                    alt14=3;
                    }
                    break;
                case 20:
                    {
                    alt14=4;
                    }
                    break;

                }

                switch (alt14) {
            	case 1 :
            	    // Dialog.g:121:6: '*' op2= unary
            	    {
            	    match(input,19,FOLLOW_19_in_mult769); 

            	    pushFollow(FOLLOW_unary_in_mult773);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:122:11: '/' op2= unary
            	    {
            	    match(input,25,FOLLOW_25_in_mult787); 

            	    pushFollow(FOLLOW_unary_in_mult791);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:123:11: '%' op2= unary
            	    {
            	    match(input,16,FOLLOW_16_in_mult805); 

            	    pushFollow(FOLLOW_unary_in_mult809);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:124:11: '**' op2= unary
            	    {
            	    match(input,20,FOLLOW_20_in_mult823); 

            	    pushFollow(FOLLOW_unary_in_mult827);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

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
    // $ANTLR end "mult"



    // $ANTLR start "term"
    // Dialog.g:127:1: term returns [Evaluator value] : ( '(' expression ')' | NUMBER | STRING_LITERAL | QUERY_STRING );
    public final Evaluator term() throws RecognitionException {
        Evaluator value = null;


        Token NUMBER13=null;
        Token STRING_LITERAL14=null;
        Token QUERY_STRING15=null;
        Evaluator expression12 =null;


        try {
            // Dialog.g:127:32: ( '(' expression ')' | NUMBER | STRING_LITERAL | QUERY_STRING )
            int alt15=4;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt15=1;
                }
                break;
            case NUMBER:
                {
                alt15=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt15=3;
                }
                break;
            case QUERY_STRING:
                {
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // Dialog.g:128:5: '(' expression ')'
                    {
                    match(input,17,FOLLOW_17_in_term852); 

                    pushFollow(FOLLOW_expression_in_term854);
                    expression12=expression();

                    state._fsp--;


                    match(input,18,FOLLOW_18_in_term856); 

                     value = expression12; 

                    }
                    break;
                case 2 :
                    // Dialog.g:129:7: NUMBER
                    {
                    NUMBER13=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term866); 

                     value = NumberEvaluator.create((NUMBER13!=null?NUMBER13.getText():null)); 

                    }
                    break;
                case 3 :
                    // Dialog.g:130:7: STRING_LITERAL
                    {
                    STRING_LITERAL14=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term876); 

                     value = StringEvaluator.create((STRING_LITERAL14!=null?STRING_LITERAL14.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:131:7: QUERY_STRING
                    {
                    QUERY_STRING15=(Token)match(input,QUERY_STRING,FOLLOW_QUERY_STRING_in_term886); 

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
    // Dialog.g:133:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:133:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt16=7;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt16=1;
                }
                break;
            case 45:
                {
                alt16=2;
                }
                break;
            case 38:
                {
                alt16=3;
                }
                break;
            case 43:
                {
                alt16=4;
                }
                break;
            case 37:
                {
                alt16=5;
                }
                break;
            case 35:
                {
                alt16=6;
                }
                break;
            case 33:
                {
                alt16=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // Dialog.g:134:5: 'ns'
                    {
                    match(input,39,FOLLOW_39_in_time_unit905); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:135:7: 'us'
                    {
                    match(input,45,FOLLOW_45_in_time_unit915); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:136:7: 'ms'
                    {
                    match(input,38,FOLLOW_38_in_time_unit925); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:137:7: 's'
                    {
                    match(input,43,FOLLOW_43_in_time_unit935); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:138:7: 'm'
                    {
                    match(input,37,FOLLOW_37_in_time_unit945); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:139:7: 'h'
                    {
                    match(input,35,FOLLOW_35_in_time_unit955); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:140:7: 'd'
                    {
                    match(input,33,FOLLOW_33_in_time_unit965); 

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
    public static final BitSet FOLLOW_41_in_response131 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_response133 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_response137 = new BitSet(new long[]{0x0000811000000000L});
    public static final BitSet FOLLOW_response_statement_in_response140 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_response143 = new BitSet(new long[]{0x0000811000000000L});
    public static final BitSet FOLLOW_47_in_response147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_response_statement172 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_response_statement174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule215 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule217 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46_in_rule221 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_criteria_in_rule223 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rule227 = new BitSet(new long[]{0x0000830000000000L});
    public static final BitSet FOLLOW_rule_statement_in_rule230 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rule233 = new BitSet(new long[]{0x0000830000000000L});
    public static final BitSet FOLLOW_47_in_rule237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule_statement267 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement271 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_rule_statement285 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement290 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement296 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_remember_statement354 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement356 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_remember_statement360 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement362 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_QUERY_STRING_in_remember_assignment396 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_remember_assignment398 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_remember_assignment400 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment404 = new BitSet(new long[]{0x000028EA00000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment408 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_remember_assignment411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_criteria457 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_criteria460 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria464 = new BitSet(new long[]{0x0000000000400022L});
    public static final BitSet FOLLOW_22_in_criteria470 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria474 = new BitSet(new long[]{0x0000000000400022L});
    public static final BitSet FOLLOW_IDENT_in_criteria498 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria500 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria504 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria520 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria522 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria526 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria542 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_criteria544 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria548 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria564 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria566 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria570 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria586 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria588 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria592 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria608 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_criteria610 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_criteria614 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria630 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression661 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_expression675 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_mult_in_expression679 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_23_in_expression690 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_mult_in_expression694 = new BitSet(new long[]{0x0000000000A00002L});
    public static final BitSet FOLLOW_21_in_unary726 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_23_in_unary730 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_term_in_unary740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult760 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_19_in_mult769 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult773 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_25_in_mult787 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult791 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_16_in_mult805 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult809 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_20_in_mult823 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_unary_in_mult827 = new BitSet(new long[]{0x0000000002190002L});
    public static final BitSet FOLLOW_17_in_term852 = new BitSet(new long[]{0x0000000000A23800L});
    public static final BitSet FOLLOW_expression_in_term854 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_term856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_STRING_in_term886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_time_unit905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_time_unit915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_time_unit925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_time_unit935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_time_unit945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_time_unit955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_time_unit965 = new BitSet(new long[]{0x0000000000000002L});

}