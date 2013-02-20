// $ANTLR 3.4 Dialog.g 2013-02-20 21:44:53

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "QUERY_KEY", "QUERY_KEY_VAR", "STRING_LITERAL", "WS", "'!'", "'!='", "'%'", "'('", "')'", "'*'", "'**'", "'+'", "','", "'-'", "'-p'", "'/'", "':'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'['", "']'", "'criteria'", "'d'", "'events='", "'false'", "'h'", "'m'", "'ms'", "'ns'", "'random {'", "'remember'", "'response'", "'rule'", "'s'", "'then'", "'true'", "'us'", "'{'", "'}'", "'~='"
    };

    public static final int EOF=-1;
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
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int INTEGER=6;
    public static final int LETTER=7;
    public static final int LINE_COMMENT=8;
    public static final int ML_COMMENT=9;
    public static final int NEWLINE=10;
    public static final int NUMBER=11;
    public static final int QUERY_KEY=12;
    public static final int QUERY_KEY_VAR=13;
    public static final int STRING_LITERAL=14;
    public static final int WS=15;

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

                if ( (LA1_0==48) ) {
                    alt1=1;
                }
                else if ( (LA1_0==47) ) {
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

                if ( (LA2_1==27) ) {
                    alt2=2;
                }
                else if ( (LA2_1==29||LA2_1==50||LA2_1==53) ) {
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

                    match(input,27,FOLLOW_27_in_name154); 

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

            match(input,47,FOLLOW_47_in_response196); 

            pushFollow(FOLLOW_name_in_response198);
            name3=name(context);

            state._fsp--;


             builder.name(name3); 

            match(input,53,FOLLOW_53_in_response203); 

            // Dialog.g:74:64: ( response_statement[context, builder] ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT||(LA3_0 >= 45 && LA3_0 <= 46)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:74:65: response_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response206);
            	    response_statement(context, builder);

            	    state._fsp--;


            	    match(input,29,FOLLOW_29_in_response209); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            match(input,54,FOLLOW_54_in_response213); 

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

            if ( (LA4_0==46) ) {
                alt4=1;
            }
            else if ( (LA4_0==IDENT||LA4_0==45) ) {
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

            match(input,48,FOLLOW_48_in_rule279); 

            pushFollow(FOLLOW_name_in_rule281);
            name6=name(context);

            state._fsp--;


             builder.name(name6); 

            match(input,53,FOLLOW_53_in_rule295); 

            pushFollow(FOLLOW_criteria_in_rule297);
            criteria7=criteria(builder);

            state._fsp--;


             retval.eventNames = criteria7; 

            match(input,29,FOLLOW_29_in_rule302); 

            // Dialog.g:87:13: ( rule_statement[context, builder] ';' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IDENT||(LA5_0 >= 45 && LA5_0 <= 47)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:87:14: rule_statement[context, builder] ';'
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule318);
            	    rule_statement(context, builder);

            	    state._fsp--;


            	    match(input,29,FOLLOW_29_in_rule321); 

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            match(input,54,FOLLOW_54_in_rule334); 

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
            case 47:
                {
                alt8=1;
                }
                break;
            case 46:
                {
                alt8=2;
                }
                break;
            case IDENT:
            case 45:
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
                    match(input,47,FOLLOW_47_in_rule_statement364); 

                    pushFollow(FOLLOW_name_in_rule_statement368);
                    n=name(context);

                    state._fsp--;


                     CallResponse.Builder responseBuilder = CallResponse.builder(n); 

                    // Dialog.g:94:9: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==50) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // Dialog.g:96:13: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                            {
                            match(input,50,FOLLOW_50_in_rule_statement409); 

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
            match(input,45,FOLLOW_45_in_block500); 

             SequentialRandomSelector.Builder builder = SequentialRandomSelector.builder(); 

            // Dialog.g:107:9: ( generic_statement[context] ':' NUMBER )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT||LA9_0==45) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Dialog.g:108:13: generic_statement[context] ':' NUMBER
            	    {
            	    pushFollow(FOLLOW_generic_statement_in_block534);
            	    generic_statement10=generic_statement(context);

            	    state._fsp--;


            	    match(input,28,FOLLOW_28_in_block537); 

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


            match(input,54,FOLLOW_54_in_block571); 

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

            if ( (LA12_0==45) ) {
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

                    if ( (LA11_0==IDENT||(LA11_0 >= NUMBER && LA11_0 <= QUERY_KEY)||LA11_0==STRING_LITERAL||LA11_0==19||LA11_0==23||LA11_0==25||LA11_0==35||LA11_0==40||LA11_0==51||LA11_0==53) ) {
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

                                if ( (LA10_0==24) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // Dialog.g:120:13: ',' a2= argument_decl
                            	    {
                            	    match(input,24,FOLLOW_24_in_generic_statement655); 

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
            else if ( ((LA13_0 >= NUMBER && LA13_0 <= QUERY_KEY)||LA13_0==STRING_LITERAL||LA13_0==19||LA13_0==23||LA13_0==25||LA13_0==35||LA13_0==40||LA13_0==51||LA13_0==53) ) {
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

                    match(input,28,FOLLOW_28_in_argument_decl712); 

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

            match(input,46,FOLLOW_46_in_remember_statement756); 

            pushFollow(FOLLOW_remember_assignment_in_remember_statement758);
            remember_assignment(builder);

            state._fsp--;


            // Dialog.g:131:45: ( ',' remember_assignment[builder] )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==24) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // Dialog.g:131:46: ',' remember_assignment[builder]
            	    {
            	    match(input,24,FOLLOW_24_in_remember_statement762); 

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
    // Dialog.g:135:1: remember_assignment[Remember.Builder builder] :q= query ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )? ;
    public final void remember_assignment(Remember.Builder builder) throws RecognitionException {
        Token i1=null;
        Evaluator q =null;

        TimeUnit i2 =null;

        Evaluator expression13 =null;


        try {
            // Dialog.g:135:48: (q= query ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )? )
            // Dialog.g:136:5: q= query ':' expression (i1= INTEGER i2= time_unit )? ( '-p' )?
            {
             boolean isPersistent = false; long expiration = Long.MAX_VALUE; TimeUnit unit = TimeUnit.DAYS; 

            pushFollow(FOLLOW_query_in_remember_assignment800);
            q=query();

            state._fsp--;


            match(input,28,FOLLOW_28_in_remember_assignment802); 

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

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // Dialog.g:142:13: '-p'
                    {
                    match(input,26,FOLLOW_26_in_remember_assignment873); 

                     isPersistent = true; 

                    }
                    break;

            }


             builder.remember(q, expression13, ExpirationTime.expiringAt(expiration, unit, isPersistent)); 

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
    // Dialog.g:147:1: criteria[Rule.Builder builder] returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= query '=' op1= expression r1= require |i2= query '>' op2= expression r2= require |i3= query '<' op3= expression r3= require |i4= query '<=' op4= expression r4= require |i5= query '>=' op5= expression r5= require |i6= query '!=' op6= expression r6= require |i7= query '~=' op7= '/' (regex=~ ( '/' ) )+ '/' r7= require |i8= query r8= require )* ;
    public final Collection<String> criteria(Rule.Builder builder) throws RecognitionException {
        Collection<String> eventNames = null;


        Token e1=null;
        Token e2=null;
        Token op7=null;
        Token regex=null;
        Evaluator i1 =null;

        Evaluator op1 =null;

        boolean r1 =false;

        Evaluator i2 =null;

        Evaluator op2 =null;

        boolean r2 =false;

        Evaluator i3 =null;

        Evaluator op3 =null;

        boolean r3 =false;

        Evaluator i4 =null;

        Evaluator op4 =null;

        boolean r4 =false;

        Evaluator i5 =null;

        Evaluator op5 =null;

        boolean r5 =false;

        Evaluator i6 =null;

        Evaluator op6 =null;

        boolean r6 =false;

        Evaluator i7 =null;

        boolean r7 =false;

        Evaluator i8 =null;

        boolean r8 =false;


        try {
            // Dialog.g:147:72: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= query '=' op1= expression r1= require |i2= query '>' op2= expression r2= require |i3= query '<' op3= expression r3= require |i4= query '<=' op4= expression r4= require |i5= query '>=' op5= expression r5= require |i6= query '!=' op6= expression r6= require |i7= query '~=' op7= '/' (regex=~ ( '/' ) )+ '/' r7= require |i8= query r8= require )* )
            // Dialog.g:148:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= query '=' op1= expression r1= require |i2= query '>' op2= expression r2= require |i3= query '<' op3= expression r3= require |i4= query '<=' op4= expression r4= require |i5= query '>=' op5= expression r5= require |i6= query '!=' op6= expression r6= require |i7= query '~=' op7= '/' (regex=~ ( '/' ) )+ '/' r7= require |i8= query r8= require )*
            {
             eventNames = new ArrayList<String>(); 

            match(input,37,FOLLOW_37_in_criteria930); 

            // Dialog.g:149:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:150:21: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            match(input,39,FOLLOW_39_in_criteria954); 

            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria958); 

             eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:150:72: ( ',' e2= IDENT )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==24) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // Dialog.g:150:73: ',' e2= IDENT
            	    {
            	    match(input,24,FOLLOW_24_in_criteria964); 

            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria968); 

            	     eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            // Dialog.g:152:5: (i1= query '=' op1= expression r1= require |i2= query '>' op2= expression r2= require |i3= query '<' op3= expression r3= require |i4= query '<=' op4= expression r4= require |i5= query '>=' op5= expression r5= require |i6= query '!=' op6= expression r6= require |i7= query '~=' op7= '/' (regex=~ ( '/' ) )+ '/' r7= require |i8= query r8= require )*
            loop19:
            do {
                int alt19=9;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==QUERY_KEY) ) {
                    switch ( input.LA(2) ) {
                    case 32:
                        {
                        alt19=1;
                        }
                        break;
                    case 33:
                        {
                        alt19=2;
                        }
                        break;
                    case 30:
                        {
                        alt19=3;
                        }
                        break;
                    case 31:
                        {
                        alt19=4;
                        }
                        break;
                    case 34:
                        {
                        alt19=5;
                        }
                        break;
                    case 17:
                        {
                        alt19=6;
                        }
                        break;
                    case 55:
                        {
                        alt19=7;
                        }
                        break;
                    case QUERY_KEY:
                    case 16:
                    case 29:
                        {
                        alt19=8;
                        }
                        break;

                    }

                }


                switch (alt19) {
            	case 1 :
            	    // Dialog.g:153:9: i1= query '=' op1= expression r1= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1008);
            	    i1=query();

            	    state._fsp--;


            	    match(input,32,FOLLOW_32_in_criteria1010); 

            	    pushFollow(FOLLOW_expression_in_criteria1014);
            	    op1=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1018);
            	    r1=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.equalTo(i1, op1, r8)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:154:11: i2= query '>' op2= expression r2= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1034);
            	    i2=query();

            	    state._fsp--;


            	    match(input,33,FOLLOW_33_in_criteria1036); 

            	    pushFollow(FOLLOW_expression_in_criteria1040);
            	    op2=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1044);
            	    r2=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThan(i2, op2, r8)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:155:11: i3= query '<' op3= expression r3= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1060);
            	    i3=query();

            	    state._fsp--;


            	    match(input,30,FOLLOW_30_in_criteria1062); 

            	    pushFollow(FOLLOW_expression_in_criteria1066);
            	    op3=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1070);
            	    r3=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThan(i3, op3, r8)); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:156:11: i4= query '<=' op4= expression r4= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1086);
            	    i4=query();

            	    state._fsp--;


            	    match(input,31,FOLLOW_31_in_criteria1088); 

            	    pushFollow(FOLLOW_expression_in_criteria1092);
            	    op4=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1096);
            	    r4=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.lessThanOrEqual(i4, op4, r8)); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:157:11: i5= query '>=' op5= expression r5= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1112);
            	    i5=query();

            	    state._fsp--;


            	    match(input,34,FOLLOW_34_in_criteria1114); 

            	    pushFollow(FOLLOW_expression_in_criteria1118);
            	    op5=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1122);
            	    r5=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.greaterThanOrEqual(i5, op5, r8)); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:158:11: i6= query '!=' op6= expression r6= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1138);
            	    i6=query();

            	    state._fsp--;


            	    match(input,17,FOLLOW_17_in_criteria1140); 

            	    pushFollow(FOLLOW_expression_in_criteria1144);
            	    op6=expression();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1148);
            	    r6=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.not(i6, op6, r8)); 

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:159:11: i7= query '~=' op7= '/' (regex=~ ( '/' ) )+ '/' r7= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1164);
            	    i7=query();

            	    state._fsp--;


            	    match(input,55,FOLLOW_55_in_criteria1166); 

            	    op7=(Token)match(input,27,FOLLOW_27_in_criteria1170); 

            	    // Dialog.g:159:38: (regex=~ ( '/' ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( ((LA18_0 >= DIGIT && LA18_0 <= 26)||(LA18_0 >= 28 && LA18_0 <= 55)) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // Dialog.g:159:38: regex=~ ( '/' )
            	    	    {
            	    	    regex=(Token)input.LT(1);

            	    	    if ( (input.LA(1) >= DIGIT && input.LA(1) <= 26)||(input.LA(1) >= 28 && input.LA(1) <= 55) ) {
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


            	    match(input,27,FOLLOW_27_in_criteria1180); 

            	    pushFollow(FOLLOW_require_in_criteria1184);
            	    r7=require();

            	    state._fsp--;


            	     builder.criterion(RegexQueryPredicate.of(i7, (regex!=null?regex.getText():null), r8)); 

            	    }
            	    break;
            	case 8 :
            	    // Dialog.g:160:11: i8= query r8= require
            	    {
            	    pushFollow(FOLLOW_query_in_criteria1200);
            	    i8=query();

            	    state._fsp--;


            	    pushFollow(FOLLOW_require_in_criteria1204);
            	    r8=require();

            	    state._fsp--;


            	     builder.criterion(NumberQueryPredicate.of(i8, Predicates.<Number>alwaysTrue(), r8)); 

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



    // $ANTLR start "require"
    // Dialog.g:163:1: require returns [boolean required] : ( '!' )? ;
    public final boolean require() throws RecognitionException {
        boolean required = false;


        try {
            // Dialog.g:163:36: ( ( '!' )? )
            // Dialog.g:164:5: ( '!' )?
            {
            // Dialog.g:164:5: ( '!' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // Dialog.g:164:7: '!'
                    {
                    match(input,16,FOLLOW_16_in_require1231); 

                     required = true; 

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
        return required;
    }
    // $ANTLR end "require"



    // $ANTLR start "query"
    // Dialog.g:165:1: query returns [Evaluator value] : q= QUERY_KEY ;
    public final Evaluator query() throws RecognitionException {
        Evaluator value = null;


        Token q=null;

        try {
            // Dialog.g:165:33: (q= QUERY_KEY )
            // Dialog.g:166:5: q= QUERY_KEY
            {
            q=(Token)match(input,QUERY_KEY,FOLLOW_QUERY_KEY_in_query1253); 

             value = StringEvaluator.create((q!=null?q.getText():null), variableSource); 

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
    // $ANTLR end "query"



    // $ANTLR start "expression"
    // Dialog.g:169:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final Evaluator expression() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:169:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:170:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            pushFollow(FOLLOW_mult_in_expression1282);
            op1=mult();

            state._fsp--;


             value = op1; 

            // Dialog.g:171:5: ( '+' op2= mult | '-' op2= mult )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==23) ) {
                    alt21=1;
                }
                else if ( (LA21_0==25) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // Dialog.g:172:5: '+' op2= mult
            	    {
            	    match(input,23,FOLLOW_23_in_expression1296); 

            	    pushFollow(FOLLOW_mult_in_expression1300);
            	    op2=mult();

            	    state._fsp--;


            	     value = PlusEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:173:8: '-' op2= mult
            	    {
            	    match(input,25,FOLLOW_25_in_expression1311); 

            	    pushFollow(FOLLOW_mult_in_expression1315);
            	    op2=mult();

            	    state._fsp--;


            	     value = MinusEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // Dialog.g:176:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final Evaluator unary() throws RecognitionException {
        Evaluator value = null;


        Evaluator term14 =null;


        try {
            // Dialog.g:176:33: ( ( '+' | '-' )* term )
            // Dialog.g:177:5: ( '+' | '-' )* term
            {
             boolean positive = true; 

            // Dialog.g:178:5: ( '+' | '-' )*
            loop22:
            do {
                int alt22=3;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==23) ) {
                    alt22=1;
                }
                else if ( (LA22_0==25) ) {
                    alt22=2;
                }


                switch (alt22) {
            	case 1 :
            	    // Dialog.g:178:6: '+'
            	    {
            	    match(input,23,FOLLOW_23_in_unary1347); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:178:12: '-'
            	    {
            	    match(input,25,FOLLOW_25_in_unary1351); 

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary1361);
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
    // Dialog.g:185:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* ;
    public final Evaluator mult() throws RecognitionException {
        Evaluator value = null;


        Evaluator op1 =null;

        Evaluator op2 =null;


        try {
            // Dialog.g:185:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )* )
            // Dialog.g:186:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            {
            pushFollow(FOLLOW_unary_in_mult1381);
            op1=unary();

            state._fsp--;


             value = op1; 

            // Dialog.g:187:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary | '**' op2= unary )*
            loop23:
            do {
                int alt23=5;
                switch ( input.LA(1) ) {
                case 21:
                    {
                    alt23=1;
                    }
                    break;
                case 27:
                    {
                    alt23=2;
                    }
                    break;
                case 18:
                    {
                    alt23=3;
                    }
                    break;
                case 22:
                    {
                    alt23=4;
                    }
                    break;

                }

                switch (alt23) {
            	case 1 :
            	    // Dialog.g:188:9: '*' op2= unary
            	    {
            	    match(input,21,FOLLOW_21_in_mult1399); 

            	    pushFollow(FOLLOW_unary_in_mult1403);
            	    op2=unary();

            	    state._fsp--;


            	     value = MultiplyEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:189:11: '/' op2= unary
            	    {
            	    match(input,27,FOLLOW_27_in_mult1417); 

            	    pushFollow(FOLLOW_unary_in_mult1421);
            	    op2=unary();

            	    state._fsp--;


            	     value = DivideEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:190:11: '%' op2= unary
            	    {
            	    match(input,18,FOLLOW_18_in_mult1435); 

            	    pushFollow(FOLLOW_unary_in_mult1439);
            	    op2=unary();

            	    state._fsp--;


            	     value = ModEvaluator.create(value, op2); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:191:11: '**' op2= unary
            	    {
            	    match(input,22,FOLLOW_22_in_mult1453); 

            	    pushFollow(FOLLOW_unary_in_mult1457);
            	    op2=unary();

            	    state._fsp--;


            	     value = PowerEvaluator.create(value, op2); 

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // Dialog.g:194:1: term returns [Evaluator value] : ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' );
    public final Evaluator term() throws RecognitionException {
        Evaluator value = null;


        Token NUMBER16=null;
        Token STRING_LITERAL17=null;
        boolean b =false;

        Evaluator q =null;

        Evaluator exp1 =null;

        Evaluator exp2 =null;

        Evaluator expression15 =null;


        try {
            // Dialog.g:194:32: ( '(' expression ')' |b= bool | NUMBER | STRING_LITERAL |q= query | '[' (exp1= expression ( ',' exp2= expression )* )? ']' | '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}' )
            int alt28=7;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt28=1;
                }
                break;
            case 40:
            case 51:
                {
                alt28=2;
                }
                break;
            case NUMBER:
                {
                alt28=3;
                }
                break;
            case STRING_LITERAL:
                {
                alt28=4;
                }
                break;
            case QUERY_KEY:
                {
                alt28=5;
                }
                break;
            case 35:
                {
                alt28=6;
                }
                break;
            case 53:
                {
                alt28=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // Dialog.g:195:5: '(' expression ')'
                    {
                    match(input,19,FOLLOW_19_in_term1482); 

                    pushFollow(FOLLOW_expression_in_term1484);
                    expression15=expression();

                    state._fsp--;


                    match(input,20,FOLLOW_20_in_term1486); 

                     value = expression15; 

                    }
                    break;
                case 2 :
                    // Dialog.g:196:7: b= bool
                    {
                    pushFollow(FOLLOW_bool_in_term1498);
                    b=bool();

                    state._fsp--;


                     value = BooleanEvaluator.create(b); 

                    }
                    break;
                case 3 :
                    // Dialog.g:197:7: NUMBER
                    {
                    NUMBER16=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term1508); 

                     value = NumberEvaluator.create((NUMBER16!=null?NUMBER16.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:198:7: STRING_LITERAL
                    {
                    STRING_LITERAL17=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term1518); 

                     value = StringEvaluator.create((STRING_LITERAL17!=null?STRING_LITERAL17.getText():null), this.variableSource); 

                    }
                    break;
                case 5 :
                    // Dialog.g:199:7: q= query
                    {
                    pushFollow(FOLLOW_query_in_term1530);
                    q=query();

                    state._fsp--;


                     value = VariableEvaluator.create(variableSource, q); 

                    }
                    break;
                case 6 :
                    // Dialog.g:200:7: '[' (exp1= expression ( ',' exp2= expression )* )? ']'
                    {
                    match(input,35,FOLLOW_35_in_term1541); 

                     List<Evaluator> array = Lists.newArrayList(); 

                    // Dialog.g:202:13: (exp1= expression ( ',' exp2= expression )* )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( ((LA25_0 >= NUMBER && LA25_0 <= QUERY_KEY)||LA25_0==STRING_LITERAL||LA25_0==19||LA25_0==23||LA25_0==25||LA25_0==35||LA25_0==40||LA25_0==51||LA25_0==53) ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // Dialog.g:203:14: exp1= expression ( ',' exp2= expression )*
                            {
                            pushFollow(FOLLOW_expression_in_term1587);
                            exp1=expression();

                            state._fsp--;


                             array.add(exp1); 

                            // Dialog.g:204:14: ( ',' exp2= expression )*
                            loop24:
                            do {
                                int alt24=2;
                                int LA24_0 = input.LA(1);

                                if ( (LA24_0==24) ) {
                                    alt24=1;
                                }


                                switch (alt24) {
                            	case 1 :
                            	    // Dialog.g:204:15: ',' exp2= expression
                            	    {
                            	    match(input,24,FOLLOW_24_in_term1605); 

                            	    pushFollow(FOLLOW_expression_in_term1609);
                            	    exp2=expression();

                            	    state._fsp--;


                            	     array.add(exp2); 

                            	    }
                            	    break;

                            	default :
                            	    break loop24;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,36,FOLLOW_36_in_term1636); 

                     value = ArrayEvaluator.create(array); 

                    }
                    break;
                case 7 :
                    // Dialog.g:207:7: '{' ( map_pair[vars] ( ',' map_pair[vars] )* )? '}'
                    {
                    match(input,53,FOLLOW_53_in_term1646); 

                     Map<String, Evaluator> vars = Maps.newHashMap(); 

                    // Dialog.g:209:11: ( map_pair[vars] ( ',' map_pair[vars] )* )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==STRING_LITERAL) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // Dialog.g:209:12: map_pair[vars] ( ',' map_pair[vars] )*
                            {
                            pushFollow(FOLLOW_map_pair_in_term1672);
                            map_pair(vars);

                            state._fsp--;


                            // Dialog.g:209:27: ( ',' map_pair[vars] )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==24) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // Dialog.g:209:28: ',' map_pair[vars]
                            	    {
                            	    match(input,24,FOLLOW_24_in_term1676); 

                            	    pushFollow(FOLLOW_map_pair_in_term1678);
                            	    map_pair(vars);

                            	    state._fsp--;


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);


                            }
                            break;

                    }


                    match(input,54,FOLLOW_54_in_term1691); 

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
    // Dialog.g:213:1: bool returns [boolean value] : ( 'true' | 'false' ) ;
    public final boolean bool() throws RecognitionException {
        boolean value = false;


        try {
            // Dialog.g:213:30: ( ( 'true' | 'false' ) )
            // Dialog.g:214:5: ( 'true' | 'false' )
            {
            // Dialog.g:214:5: ( 'true' | 'false' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==51) ) {
                alt29=1;
            }
            else if ( (LA29_0==40) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // Dialog.g:214:6: 'true'
                    {
                    match(input,51,FOLLOW_51_in_bool1715); 

                     value = true; 

                    }
                    break;
                case 2 :
                    // Dialog.g:214:34: 'false'
                    {
                    match(input,40,FOLLOW_40_in_bool1721); 

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
    // Dialog.g:216:1: map_pair[Map<String, Evaluator> vars] : k= STRING_LITERAL ':' expression ;
    public final void map_pair(Map<String, Evaluator> vars) throws RecognitionException {
        Token k=null;
        Evaluator expression18 =null;


        try {
            // Dialog.g:216:40: (k= STRING_LITERAL ':' expression )
            // Dialog.g:217:5: k= STRING_LITERAL ':' expression
            {
            k=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_map_pair1744); 

            match(input,28,FOLLOW_28_in_map_pair1746); 

            pushFollow(FOLLOW_expression_in_map_pair1748);
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
    // Dialog.g:219:1: time_unit returns [TimeUnit unit] : ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' );
    public final TimeUnit time_unit() throws RecognitionException {
        TimeUnit unit = null;


        try {
            // Dialog.g:219:35: ( 'ns' | 'us' | 'ms' | 's' | 'm' | 'h' | 'd' )
            int alt30=7;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt30=1;
                }
                break;
            case 52:
                {
                alt30=2;
                }
                break;
            case 43:
                {
                alt30=3;
                }
                break;
            case 49:
                {
                alt30=4;
                }
                break;
            case 42:
                {
                alt30=5;
                }
                break;
            case 41:
                {
                alt30=6;
                }
                break;
            case 38:
                {
                alt30=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // Dialog.g:220:5: 'ns'
                    {
                    match(input,44,FOLLOW_44_in_time_unit1766); 

                     unit = TimeUnit.NANOSECONDS; 

                    }
                    break;
                case 2 :
                    // Dialog.g:221:7: 'us'
                    {
                    match(input,52,FOLLOW_52_in_time_unit1776); 

                     unit = TimeUnit.MICROSECONDS; 

                    }
                    break;
                case 3 :
                    // Dialog.g:222:7: 'ms'
                    {
                    match(input,43,FOLLOW_43_in_time_unit1786); 

                     unit = TimeUnit.MILLISECONDS; 

                    }
                    break;
                case 4 :
                    // Dialog.g:223:7: 's'
                    {
                    match(input,49,FOLLOW_49_in_time_unit1796); 

                     unit = TimeUnit.SECONDS; 

                    }
                    break;
                case 5 :
                    // Dialog.g:224:7: 'm'
                    {
                    match(input,42,FOLLOW_42_in_time_unit1806); 

                     unit = TimeUnit.MINUTES; 

                    }
                    break;
                case 6 :
                    // Dialog.g:225:7: 'h'
                    {
                    match(input,41,FOLLOW_41_in_time_unit1816); 

                     unit = TimeUnit.HOURS; 

                    }
                    break;
                case 7 :
                    // Dialog.g:226:7: 'd'
                    {
                    match(input,38,FOLLOW_38_in_time_unit1826); 

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


 

    public static final BitSet FOLLOW_rule_in_program81 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_response_in_program96 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_IDENT_in_name136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_name152 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_name154 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_name158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_response196 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_response198 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_response203 = new BitSet(new long[]{0x0040600000000020L});
    public static final BitSet FOLLOW_response_statement_in_response206 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_response209 = new BitSet(new long[]{0x0040600000000020L});
    public static final BitSet FOLLOW_54_in_response213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_response_statement238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_response_statement248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule279 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule281 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_rule295 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_criteria_in_rule297 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rule302 = new BitSet(new long[]{0x0040E00000000020L});
    public static final BitSet FOLLOW_rule_statement_in_rule318 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rule321 = new BitSet(new long[]{0x0040E00000000020L});
    public static final BitSet FOLLOW_54_in_rule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule_statement364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_name_in_rule_statement368 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_rule_statement409 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement414 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_remember_statement_in_rule_statement463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_generic_statement_in_rule_statement473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_block500 = new BitSet(new long[]{0x0000200000000020L});
    public static final BitSet FOLLOW_generic_statement_in_block534 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_block537 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_NUMBER_in_block539 = new BitSet(new long[]{0x0040200000000020L});
    public static final BitSet FOLLOW_54_in_block571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_generic_statement589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_generic_statement608 = new BitSet(new long[]{0x0028010802885822L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement629 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_generic_statement655 = new BitSet(new long[]{0x0028010802885820L});
    public static final BitSet FOLLOW_argument_decl_in_generic_statement659 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_IDENT_in_argument_decl710 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_argument_decl712 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_argument_decl716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_argument_decl728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_remember_statement756 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement758 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_remember_statement762 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_remember_assignment_in_remember_statement764 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_query_in_remember_assignment800 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_remember_assignment802 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_remember_assignment804 = new BitSet(new long[]{0x0000000004000042L});
    public static final BitSet FOLLOW_INTEGER_in_remember_assignment831 = new BitSet(new long[]{0x00121E4000000000L});
    public static final BitSet FOLLOW_time_unit_in_remember_assignment835 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_remember_assignment873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_criteria930 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_criteria954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria958 = new BitSet(new long[]{0x0000000001001002L});
    public static final BitSet FOLLOW_24_in_criteria964 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria968 = new BitSet(new long[]{0x0000000001001002L});
    public static final BitSet FOLLOW_query_in_criteria1008 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_criteria1010 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1014 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1018 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1034 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_criteria1036 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1040 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1044 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1060 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria1062 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1066 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1070 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1086 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_criteria1088 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1092 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1096 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1112 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_criteria1114 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1118 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1122 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1138 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_criteria1140 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_criteria1144 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1148 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1164 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_criteria1166 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_criteria1170 = new BitSet(new long[]{0x00FFFFFFF7FFFFF0L});
    public static final BitSet FOLLOW_set_in_criteria1174 = new BitSet(new long[]{0x00FFFFFFFFFFFFF0L});
    public static final BitSet FOLLOW_27_in_criteria1180 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1184 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_query_in_criteria1200 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_require_in_criteria1204 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_16_in_require1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUERY_KEY_in_query1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_expression1282 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_23_in_expression1296 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_mult_in_expression1300 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_25_in_expression1311 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_mult_in_expression1315 = new BitSet(new long[]{0x0000000002800002L});
    public static final BitSet FOLLOW_23_in_unary1347 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_25_in_unary1351 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_term_in_unary1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult1381 = new BitSet(new long[]{0x0000000008640002L});
    public static final BitSet FOLLOW_21_in_mult1399 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_unary_in_mult1403 = new BitSet(new long[]{0x0000000008640002L});
    public static final BitSet FOLLOW_27_in_mult1417 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_unary_in_mult1421 = new BitSet(new long[]{0x0000000008640002L});
    public static final BitSet FOLLOW_18_in_mult1435 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_unary_in_mult1439 = new BitSet(new long[]{0x0000000008640002L});
    public static final BitSet FOLLOW_22_in_mult1453 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_unary_in_mult1457 = new BitSet(new long[]{0x0000000008640002L});
    public static final BitSet FOLLOW_19_in_term1482 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_term1484 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_term1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bool_in_term1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term1518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_query_in_term1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_term1541 = new BitSet(new long[]{0x0028011802885800L});
    public static final BitSet FOLLOW_expression_in_term1587 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_24_in_term1605 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_term1609 = new BitSet(new long[]{0x0000001001000000L});
    public static final BitSet FOLLOW_36_in_term1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_term1646 = new BitSet(new long[]{0x0040000000004000L});
    public static final BitSet FOLLOW_map_pair_in_term1672 = new BitSet(new long[]{0x0040000001000000L});
    public static final BitSet FOLLOW_24_in_term1676 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_map_pair_in_term1678 = new BitSet(new long[]{0x0040000001000000L});
    public static final BitSet FOLLOW_54_in_term1691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_bool1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_bool1721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_map_pair1744 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_map_pair1746 = new BitSet(new long[]{0x0028010802885800L});
    public static final BitSet FOLLOW_expression_in_map_pair1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_time_unit1766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_time_unit1776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_time_unit1786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_time_unit1796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_time_unit1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_time_unit1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_time_unit1826 = new BitSet(new long[]{0x0000000000000002L});

}