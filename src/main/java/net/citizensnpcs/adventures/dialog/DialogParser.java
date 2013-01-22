// $ANTLR 3.4 Dialog.g 2013-01-22 08:23:16

package net.citizensnpcs.adventures.dialog;
import java.util.concurrent.Callable;
import java.util.Collection;
import com.google.common.base.Predicates;
import com.google.common.collect.Ranges;
import net.citizensnpcs.adventures.dialog.*;
import net.citizensnpcs.adventures.dialog.statements.*;
import net.citizensnpcs.adventures.dialog.evaluators.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DialogParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "INTEGER", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'criteria'", "'events='", "'log'", "'response'", "'rule'", "'then'", "'{'", "'}'"
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

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
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


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // Dialog.g:50:1: program[DialogEngine.ParseContext context] : ( rule | response )* ;
    public final DialogParser.program_return program(DialogEngine.ParseContext context) throws RecognitionException {
        DialogParser.program_return retval = new DialogParser.program_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DialogParser.rule_return rule1 =null;

        DialogParser.response_return response2 =null;



        try {
            // Dialog.g:50:45: ( ( rule | response )* )
            // Dialog.g:51:5: ( rule | response )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // Dialog.g:51:5: ( rule | response )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==33) ) {
                    alt1=1;
                }
                else if ( (LA1_0==32) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:52:9: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_program109);
            	    rule1=rule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule1.getTree());

            	     context.ruleLoaded((rule1!=null?rule1.eventNames:null), (rule1!=null?rule1.rule:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:53:11: response
            	    {
            	    pushFollow(FOLLOW_response_in_program123);
            	    response2=response();

            	    state._fsp--;

            	    adaptor.addChild(root_0, response2.getTree());

            	     context.responseLoaded((response2!=null?response2.response:null)); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "program"


    public static class response_return extends ParserRuleReturnScope {
        public Response response;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "response"
    // Dialog.g:56:1: response returns [Response response] : 'response' IDENT '{' ! ( response_statement[builder] ';' !)* '}' !;
    public final DialogParser.response_return response() throws RecognitionException {
        DialogParser.response_return retval = new DialogParser.response_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal3=null;
        Token IDENT4=null;
        Token char_literal5=null;
        Token char_literal7=null;
        Token char_literal8=null;
        DialogParser.response_statement_return response_statement6 =null;


        CommonTree string_literal3_tree=null;
        CommonTree IDENT4_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree char_literal7_tree=null;
        CommonTree char_literal8_tree=null;

        try {
            // Dialog.g:56:38: ( 'response' IDENT '{' ! ( response_statement[builder] ';' !)* '}' !)
            // Dialog.g:57:5: 'response' IDENT '{' ! ( response_statement[builder] ';' !)* '}' !
            {
            root_0 = (CommonTree)adaptor.nil();


             Response.Builder builder = Response.builder(); 

            string_literal3=(Token)match(input,32,FOLLOW_32_in_response155); 
            string_literal3_tree = 
            (CommonTree)adaptor.create(string_literal3)
            ;
            adaptor.addChild(root_0, string_literal3_tree);


            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_response157); 
            IDENT4_tree = 
            (CommonTree)adaptor.create(IDENT4)
            ;
            adaptor.addChild(root_0, IDENT4_tree);


             builder.name((IDENT4!=null?IDENT4.getText():null)); 

            char_literal5=(Token)match(input,35,FOLLOW_35_in_response161); 

            // Dialog.g:58:58: ( response_statement[builder] ';' !)*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==31) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Dialog.g:58:59: response_statement[builder] ';' !
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response165);
            	    response_statement6=response_statement(builder);

            	    state._fsp--;

            	    adaptor.addChild(root_0, response_statement6.getTree());

            	    char_literal7=(Token)match(input,23,FOLLOW_23_in_response168); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            char_literal8=(Token)match(input,36,FOLLOW_36_in_response173); 

             retval.response = builder.build(); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "response"


    public static class response_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "response_statement"
    // Dialog.g:62:1: response_statement[Response.Builder builder] : 'log' expression ;
    public final DialogParser.response_statement_return response_statement(Response.Builder builder) throws RecognitionException {
        DialogParser.response_statement_return retval = new DialogParser.response_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal9=null;
        DialogParser.expression_return expression10 =null;


        CommonTree string_literal9_tree=null;

        try {
            // Dialog.g:62:47: ( 'log' expression )
            // Dialog.g:63:5: 'log' expression
            {
            root_0 = (CommonTree)adaptor.nil();


            string_literal9=(Token)match(input,31,FOLLOW_31_in_response_statement199); 
            string_literal9_tree = 
            (CommonTree)adaptor.create(string_literal9)
            ;
            adaptor.addChild(root_0, string_literal9_tree);


            pushFollow(FOLLOW_expression_in_response_statement201);
            expression10=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression10.getTree());

             builder.statement(Log.logging((expression10!=null?expression10.value:null)));

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "response_statement"


    public static class rule_return extends ParserRuleReturnScope {
        public Collection<String> eventNames;
        public Rule rule;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // Dialog.g:66:1: rule returns [Collection<String> eventNames, Rule rule] : 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !;
    public final DialogParser.rule_return rule() throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal11=null;
        Token IDENT12=null;
        Token char_literal13=null;
        Token char_literal15=null;
        Token char_literal17=null;
        Token char_literal18=null;
        DialogParser.criteria_return criteria14 =null;

        DialogParser.rule_statement_return rule_statement16 =null;


        CommonTree string_literal11_tree=null;
        CommonTree IDENT12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree char_literal17_tree=null;
        CommonTree char_literal18_tree=null;

        try {
            // Dialog.g:66:56: ( 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !)
            // Dialog.g:67:5: 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !
            {
            root_0 = (CommonTree)adaptor.nil();


             Rule.Builder builder = Rule.builder(); 

            string_literal11=(Token)match(input,33,FOLLOW_33_in_rule230); 
            string_literal11_tree = 
            (CommonTree)adaptor.create(string_literal11)
            ;
            adaptor.addChild(root_0, string_literal11_tree);


            IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule232); 
            IDENT12_tree = 
            (CommonTree)adaptor.create(IDENT12)
            ;
            adaptor.addChild(root_0, IDENT12_tree);


             builder.name((IDENT12!=null?IDENT12.getText():null)); 

            char_literal13=(Token)match(input,35,FOLLOW_35_in_rule236); 

            pushFollow(FOLLOW_criteria_in_rule239);
            criteria14=criteria();

            state._fsp--;

            adaptor.addChild(root_0, criteria14.getTree());

             retval.eventNames = (criteria14!=null?criteria14.eventNames:null); 

            char_literal15=(Token)match(input,23,FOLLOW_23_in_rule243); 

            // Dialog.g:68:108: ( rule_statement[builder] ';' !)*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==32) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:68:109: rule_statement[builder] ';' !
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule247);
            	    rule_statement16=rule_statement(builder);

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule_statement16.getTree());

            	    char_literal17=(Token)match(input,23,FOLLOW_23_in_rule250); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            char_literal18=(Token)match(input,36,FOLLOW_36_in_rule255); 

             retval.rule = builder.build(); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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


    public static class rule_statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule_statement"
    // Dialog.g:72:1: rule_statement[Rule.Builder builder] : ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) ;
    public final DialogParser.rule_statement_return rule_statement(Rule.Builder builder) throws RecognitionException {
        DialogParser.rule_statement_return retval = new DialogParser.rule_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token n=null;
        Token target=null;
        Token event=null;
        Token string_literal19=null;
        Token string_literal20=null;

        CommonTree n_tree=null;
        CommonTree target_tree=null;
        CommonTree event_tree=null;
        CommonTree string_literal19_tree=null;
        CommonTree string_literal20_tree=null;

        try {
            // Dialog.g:72:39: ( ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? ) )
            // Dialog.g:73:5: ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
            {
            root_0 = (CommonTree)adaptor.nil();


            // Dialog.g:73:5: ( 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )? )
            // Dialog.g:73:6: 'response' n= IDENT ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
            {
            string_literal19=(Token)match(input,32,FOLLOW_32_in_rule_statement286); 
            string_literal19_tree = 
            (CommonTree)adaptor.create(string_literal19)
            ;
            adaptor.addChild(root_0, string_literal19_tree);


            n=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement290); 
            n_tree = 
            (CommonTree)adaptor.create(n)
            ;
            adaptor.addChild(root_0, n_tree);


             CallResponse.Builder responseBuilder = CallResponse.builder((n!=null?n.getText():null)); 

            // Dialog.g:75:5: ( 'then' (target= IDENT |target= NUMBER ) event= IDENT )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==34) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Dialog.g:75:6: 'then' (target= IDENT |target= NUMBER ) event= IDENT
                    {
                    string_literal20=(Token)match(input,34,FOLLOW_34_in_rule_statement305); 
                    string_literal20_tree = 
                    (CommonTree)adaptor.create(string_literal20)
                    ;
                    adaptor.addChild(root_0, string_literal20_tree);


                    // Dialog.g:75:13: (target= IDENT |target= NUMBER )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==IDENT) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==NUMBER) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }
                    switch (alt4) {
                        case 1 :
                            // Dialog.g:75:14: target= IDENT
                            {
                            target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement310); 
                            target_tree = 
                            (CommonTree)adaptor.create(target)
                            ;
                            adaptor.addChild(root_0, target_tree);


                            }
                            break;
                        case 2 :
                            // Dialog.g:75:27: target= NUMBER
                            {
                            target=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_rule_statement314); 
                            target_tree = 
                            (CommonTree)adaptor.create(target)
                            ;
                            adaptor.addChild(root_0, target_tree);


                            }
                            break;

                    }


                    event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement319); 
                    event_tree = 
                    (CommonTree)adaptor.create(event)
                    ;
                    adaptor.addChild(root_0, event_tree);


                     responseBuilder.callback(new CallEventCallback((target!=null?target.getText():null), (event!=null?event.getText():null))); 

                    }
                    break;

            }


             builder.statement(responseBuilder.build()); 

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule_statement"


    public static class criteria_return extends ParserRuleReturnScope {
        public Collection<String> eventNames;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "criteria"
    // Dialog.g:78:1: criteria returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* ;
    public final DialogParser.criteria_return criteria() throws RecognitionException {
        DialogParser.criteria_return retval = new DialogParser.criteria_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token e1=null;
        Token e2=null;
        Token i1=null;
        Token i2=null;
        Token i3=null;
        Token i4=null;
        Token i5=null;
        Token i6=null;
        Token i7=null;
        Token string_literal21=null;
        Token string_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token string_literal27=null;
        Token string_literal28=null;
        Token string_literal29=null;
        DialogParser.expression_return op1 =null;

        DialogParser.expression_return op2 =null;

        DialogParser.expression_return op3 =null;

        DialogParser.expression_return op4 =null;

        DialogParser.expression_return op5 =null;

        DialogParser.expression_return op6 =null;


        CommonTree e1_tree=null;
        CommonTree e2_tree=null;
        CommonTree i1_tree=null;
        CommonTree i2_tree=null;
        CommonTree i3_tree=null;
        CommonTree i4_tree=null;
        CommonTree i5_tree=null;
        CommonTree i6_tree=null;
        CommonTree i7_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree string_literal27_tree=null;
        CommonTree string_literal28_tree=null;
        CommonTree string_literal29_tree=null;

        try {
            // Dialog.g:78:49: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )* )
            // Dialog.g:79:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )* ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            {
            root_0 = (CommonTree)adaptor.nil();


            retval.eventNames = new ArrayList<String>();

            string_literal21=(Token)match(input,29,FOLLOW_29_in_criteria356); 
            string_literal21_tree = 
            (CommonTree)adaptor.create(string_literal21)
            ;
            adaptor.addChild(root_0, string_literal21_tree);


            // Dialog.g:80:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )* )
            // Dialog.g:80:17: 'events=' e1= IDENT ( ',' e2= IDENT )*
            {
            string_literal22=(Token)match(input,30,FOLLOW_30_in_criteria359); 
            string_literal22_tree = 
            (CommonTree)adaptor.create(string_literal22)
            ;
            adaptor.addChild(root_0, string_literal22_tree);


            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria363); 
            e1_tree = 
            (CommonTree)adaptor.create(e1)
            ;
            adaptor.addChild(root_0, e1_tree);


             retval.eventNames.add((e1!=null?e1.getText():null)); 

            // Dialog.g:80:68: ( ',' e2= IDENT )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // Dialog.g:80:69: ',' e2= IDENT
            	    {
            	    char_literal23=(Token)match(input,20,FOLLOW_20_in_criteria369); 
            	    char_literal23_tree = 
            	    (CommonTree)adaptor.create(char_literal23)
            	    ;
            	    adaptor.addChild(root_0, char_literal23_tree);


            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria373); 
            	    e2_tree = 
            	    (CommonTree)adaptor.create(e2)
            	    ;
            	    adaptor.addChild(root_0, e2_tree);


            	     retval.eventNames.add((e2!=null?e2.getText():null)); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            // Dialog.g:81:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )*
            loop7:
            do {
                int alt7=8;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 26:
                        {
                        alt7=1;
                        }
                        break;
                    case 27:
                        {
                        alt7=2;
                        }
                        break;
                    case 24:
                        {
                        alt7=3;
                        }
                        break;
                    case 25:
                        {
                        alt7=4;
                        }
                        break;
                    case 28:
                        {
                        alt7=5;
                        }
                        break;
                    case 14:
                        {
                        alt7=6;
                        }
                        break;
                    case IDENT:
                    case 23:
                        {
                        alt7=7;
                        }
                        break;

                    }

                }


                switch (alt7) {
            	case 1 :
            	    // Dialog.g:82:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria397); 
            	    i1_tree = 
            	    (CommonTree)adaptor.create(i1)
            	    ;
            	    adaptor.addChild(root_0, i1_tree);


            	    char_literal24=(Token)match(input,26,FOLLOW_26_in_criteria399); 
            	    char_literal24_tree = 
            	    (CommonTree)adaptor.create(char_literal24)
            	    ;
            	    adaptor.addChild(root_0, char_literal24_tree);


            	    pushFollow(FOLLOW_expression_in_criteria403);
            	    op1=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op1.getTree());

            	     NumberQueryPredicate.equalTo((i1!=null?i1.getText():null), (op1!=null?op1.value:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:83:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria419); 
            	    i2_tree = 
            	    (CommonTree)adaptor.create(i2)
            	    ;
            	    adaptor.addChild(root_0, i2_tree);


            	    char_literal25=(Token)match(input,27,FOLLOW_27_in_criteria421); 
            	    char_literal25_tree = 
            	    (CommonTree)adaptor.create(char_literal25)
            	    ;
            	    adaptor.addChild(root_0, char_literal25_tree);


            	    pushFollow(FOLLOW_expression_in_criteria425);
            	    op2=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     NumberQueryPredicate.greaterThan((i2!=null?i2.getText():null), (op2!=null?op2.value:null)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:84:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria441); 
            	    i3_tree = 
            	    (CommonTree)adaptor.create(i3)
            	    ;
            	    adaptor.addChild(root_0, i3_tree);


            	    char_literal26=(Token)match(input,24,FOLLOW_24_in_criteria443); 
            	    char_literal26_tree = 
            	    (CommonTree)adaptor.create(char_literal26)
            	    ;
            	    adaptor.addChild(root_0, char_literal26_tree);


            	    pushFollow(FOLLOW_expression_in_criteria447);
            	    op3=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op3.getTree());

            	     NumberQueryPredicate.lessThan((i3!=null?i3.getText():null), (op3!=null?op3.value:null)); 

            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:85:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria463); 
            	    i4_tree = 
            	    (CommonTree)adaptor.create(i4)
            	    ;
            	    adaptor.addChild(root_0, i4_tree);


            	    string_literal27=(Token)match(input,25,FOLLOW_25_in_criteria465); 
            	    string_literal27_tree = 
            	    (CommonTree)adaptor.create(string_literal27)
            	    ;
            	    adaptor.addChild(root_0, string_literal27_tree);


            	    pushFollow(FOLLOW_expression_in_criteria469);
            	    op4=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op4.getTree());

            	     NumberQueryPredicate.lessThanOrEqual((i4!=null?i4.getText():null), (op4!=null?op4.value:null)); 

            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:86:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria485); 
            	    i5_tree = 
            	    (CommonTree)adaptor.create(i5)
            	    ;
            	    adaptor.addChild(root_0, i5_tree);


            	    string_literal28=(Token)match(input,28,FOLLOW_28_in_criteria487); 
            	    string_literal28_tree = 
            	    (CommonTree)adaptor.create(string_literal28)
            	    ;
            	    adaptor.addChild(root_0, string_literal28_tree);


            	    pushFollow(FOLLOW_expression_in_criteria491);
            	    op5=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op5.getTree());

            	     NumberQueryPredicate.greaterThanOrEqual((i5!=null?i5.getText():null), (op5!=null?op5.value:null)); 

            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:87:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria507); 
            	    i6_tree = 
            	    (CommonTree)adaptor.create(i6)
            	    ;
            	    adaptor.addChild(root_0, i6_tree);


            	    string_literal29=(Token)match(input,14,FOLLOW_14_in_criteria509); 
            	    string_literal29_tree = 
            	    (CommonTree)adaptor.create(string_literal29)
            	    ;
            	    adaptor.addChild(root_0, string_literal29_tree);


            	    pushFollow(FOLLOW_expression_in_criteria513);
            	    op6=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op6.getTree());

            	     NumberQueryPredicate.not((i6!=null?i6.getText():null), (op6!=null?op6.value:null));

            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:88:11: i7= IDENT
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria529); 
            	    i7_tree = 
            	    (CommonTree)adaptor.create(i7)
            	    ;
            	    adaptor.addChild(root_0, i7_tree);


            	     NumberQueryPredicate.of((i7!=null?i7.getText():null), Predicates.<Number>alwaysTrue()); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "criteria"


    public static class expression_return extends ParserRuleReturnScope {
        public Evaluator value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "expression"
    // Dialog.g:91:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final DialogParser.expression_return expression() throws RecognitionException {
        DialogParser.expression_return retval = new DialogParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal30=null;
        Token char_literal31=null;
        DialogParser.mult_return op1 =null;

        DialogParser.mult_return op2 =null;


        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;

        try {
            // Dialog.g:91:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:92:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_in_expression560);
            op1=mult();

            state._fsp--;

            adaptor.addChild(root_0, op1.getTree());

            retval.value = (op1!=null?op1.value:null);

            // Dialog.g:93:5: ( '+' op2= mult | '-' op2= mult )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==19) ) {
                    alt8=1;
                }
                else if ( (LA8_0==21) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // Dialog.g:94:5: '+' op2= mult
            	    {
            	    char_literal30=(Token)match(input,19,FOLLOW_19_in_expression574); 
            	    char_literal30_tree = 
            	    (CommonTree)adaptor.create(char_literal30)
            	    ;
            	    adaptor.addChild(root_0, char_literal30_tree);


            	    pushFollow(FOLLOW_mult_in_expression578);
            	    op2=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	    retval.value = PlusEvaluator.create(retval.value, (op2!=null?op2.value:null));

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:95:8: '-' op2= mult
            	    {
            	    char_literal31=(Token)match(input,21,FOLLOW_21_in_expression589); 
            	    char_literal31_tree = 
            	    (CommonTree)adaptor.create(char_literal31)
            	    ;
            	    adaptor.addChild(root_0, char_literal31_tree);


            	    pushFollow(FOLLOW_mult_in_expression593);
            	    op2=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	    retval.value = MinusEvaluator.create(retval.value, (op2!=null?op2.value:null));

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "expression"


    public static class unary_return extends ParserRuleReturnScope {
        public Evaluator value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "unary"
    // Dialog.g:98:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final DialogParser.unary_return unary() throws RecognitionException {
        DialogParser.unary_return retval = new DialogParser.unary_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal32=null;
        Token char_literal33=null;
        DialogParser.term_return term34 =null;


        CommonTree char_literal32_tree=null;
        CommonTree char_literal33_tree=null;

        try {
            // Dialog.g:98:33: ( ( '+' | '-' )* term )
            // Dialog.g:99:5: ( '+' | '-' )* term
            {
            root_0 = (CommonTree)adaptor.nil();


            boolean positive = true;

            // Dialog.g:100:5: ( '+' | '-' )*
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }
                else if ( (LA9_0==21) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // Dialog.g:100:6: '+'
            	    {
            	    char_literal32=(Token)match(input,19,FOLLOW_19_in_unary625); 
            	    char_literal32_tree = 
            	    (CommonTree)adaptor.create(char_literal32)
            	    ;
            	    adaptor.addChild(root_0, char_literal32_tree);


            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:100:12: '-'
            	    {
            	    char_literal33=(Token)match(input,21,FOLLOW_21_in_unary629); 
            	    char_literal33_tree = 
            	    (CommonTree)adaptor.create(char_literal33)
            	    ;
            	    adaptor.addChild(root_0, char_literal33_tree);


            	    positive = !positive;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary639);
            term34=term();

            state._fsp--;

            adaptor.addChild(root_0, term34.getTree());


                     retval.value = (term34!=null?term34.value:null);
                     if (!positive)
                     	retval.value = NegationEvaluator.create(retval.value);
                     

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "unary"


    public static class mult_return extends ParserRuleReturnScope {
        public Evaluator value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "mult"
    // Dialog.g:107:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )* ;
    public final DialogParser.mult_return mult() throws RecognitionException {
        DialogParser.mult_return retval = new DialogParser.mult_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal35=null;
        Token char_literal36=null;
        Token char_literal37=null;
        DialogParser.unary_return op1 =null;

        DialogParser.unary_return op2 =null;


        CommonTree char_literal35_tree=null;
        CommonTree char_literal36_tree=null;
        CommonTree char_literal37_tree=null;

        try {
            // Dialog.g:107:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )* )
            // Dialog.g:108:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_in_mult659);
            op1=unary();

            state._fsp--;

            adaptor.addChild(root_0, op1.getTree());

             retval.value = (op1!=null?op1.value:null); 

            // Dialog.g:109:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary )*
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case 18:
                    {
                    alt10=1;
                    }
                    break;
                case 22:
                    {
                    alt10=2;
                    }
                    break;
                case 15:
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // Dialog.g:109:6: '*' op2= unary
            	    {
            	    char_literal35=(Token)match(input,18,FOLLOW_18_in_mult668); 
            	    char_literal35_tree = 
            	    (CommonTree)adaptor.create(char_literal35)
            	    ;
            	    adaptor.addChild(root_0, char_literal35_tree);


            	    pushFollow(FOLLOW_unary_in_mult672);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = MultiplyEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:110:11: '/' op2= unary
            	    {
            	    char_literal36=(Token)match(input,22,FOLLOW_22_in_mult686); 
            	    char_literal36_tree = 
            	    (CommonTree)adaptor.create(char_literal36)
            	    ;
            	    adaptor.addChild(root_0, char_literal36_tree);


            	    pushFollow(FOLLOW_unary_in_mult690);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = DivideEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:111:11: '%' op2= unary
            	    {
            	    char_literal37=(Token)match(input,15,FOLLOW_15_in_mult704); 
            	    char_literal37_tree = 
            	    (CommonTree)adaptor.create(char_literal37)
            	    ;
            	    adaptor.addChild(root_0, char_literal37_tree);


            	    pushFollow(FOLLOW_unary_in_mult708);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = ModEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "mult"


    public static class term_return extends ParserRuleReturnScope {
        public Evaluator value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "term"
    // Dialog.g:114:1: term returns [Evaluator value] : ( '(' expression ')' | NUMBER | STRING_LITERAL | IDENT );
    public final DialogParser.term_return term() throws RecognitionException {
        DialogParser.term_return retval = new DialogParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal38=null;
        Token char_literal40=null;
        Token NUMBER41=null;
        Token STRING_LITERAL42=null;
        Token IDENT43=null;
        DialogParser.expression_return expression39 =null;


        CommonTree char_literal38_tree=null;
        CommonTree char_literal40_tree=null;
        CommonTree NUMBER41_tree=null;
        CommonTree STRING_LITERAL42_tree=null;
        CommonTree IDENT43_tree=null;

        try {
            // Dialog.g:114:32: ( '(' expression ')' | NUMBER | STRING_LITERAL | IDENT )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt11=1;
                }
                break;
            case NUMBER:
                {
                alt11=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt11=3;
                }
                break;
            case IDENT:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // Dialog.g:115:5: '(' expression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal38=(Token)match(input,16,FOLLOW_16_in_term733); 
                    char_literal38_tree = 
                    (CommonTree)adaptor.create(char_literal38)
                    ;
                    adaptor.addChild(root_0, char_literal38_tree);


                    pushFollow(FOLLOW_expression_in_term735);
                    expression39=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression39.getTree());

                    char_literal40=(Token)match(input,17,FOLLOW_17_in_term737); 
                    char_literal40_tree = 
                    (CommonTree)adaptor.create(char_literal40)
                    ;
                    adaptor.addChild(root_0, char_literal40_tree);


                     retval.value = (expression39!=null?expression39.value:null); 

                    }
                    break;
                case 2 :
                    // Dialog.g:116:7: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    NUMBER41=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term747); 
                    NUMBER41_tree = 
                    (CommonTree)adaptor.create(NUMBER41)
                    ;
                    adaptor.addChild(root_0, NUMBER41_tree);


                     retval.value = NumberEvaluator.create((NUMBER41!=null?NUMBER41.getText():null)); 

                    }
                    break;
                case 3 :
                    // Dialog.g:117:7: STRING_LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    STRING_LITERAL42=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term757); 
                    STRING_LITERAL42_tree = 
                    (CommonTree)adaptor.create(STRING_LITERAL42)
                    ;
                    adaptor.addChild(root_0, STRING_LITERAL42_tree);


                     retval.value = StringEvaluator.create((STRING_LITERAL42!=null?STRING_LITERAL42.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:118:7: IDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_term767); 
                    IDENT43_tree = 
                    (CommonTree)adaptor.create(IDENT43)
                    ;
                    adaptor.addChild(root_0, IDENT43_tree);


                     retval.value = VariableEvaluator.create(variableSource, (IDENT43!=null?IDENT43.getText():null)); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }

        catch (RecognitionException e) {
            throw e;
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_program109 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_response_in_program123 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_32_in_response155 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_response157 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_response161 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_response_statement_in_response165 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_response168 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_36_in_response173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_response_statement199 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_response_statement201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule230 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule232 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_rule236 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_criteria_in_rule239 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule243 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_rule_statement_in_rule247 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rule250 = new BitSet(new long[]{0x0000001100000000L});
    public static final BitSet FOLLOW_36_in_rule255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule_statement286 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement290 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_34_in_rule_statement305 = new BitSet(new long[]{0x0000000000000820L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_NUMBER_in_rule_statement314 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_criteria356 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_criteria359 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria363 = new BitSet(new long[]{0x0000000000100022L});
    public static final BitSet FOLLOW_20_in_criteria369 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria373 = new BitSet(new long[]{0x0000000000100022L});
    public static final BitSet FOLLOW_IDENT_in_criteria397 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_criteria399 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria403 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria419 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_criteria421 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria425 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria441 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_criteria443 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria447 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria463 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_criteria465 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria469 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria485 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_criteria487 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria491 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria507 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_criteria509 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_criteria513 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria529 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression560 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_19_in_expression574 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_mult_in_expression578 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_21_in_expression589 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_mult_in_expression593 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_19_in_unary625 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_21_in_unary629 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_term_in_unary639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult659 = new BitSet(new long[]{0x0000000000448002L});
    public static final BitSet FOLLOW_18_in_mult668 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_unary_in_mult672 = new BitSet(new long[]{0x0000000000448002L});
    public static final BitSet FOLLOW_22_in_mult686 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_unary_in_mult690 = new BitSet(new long[]{0x0000000000448002L});
    public static final BitSet FOLLOW_15_in_mult704 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_unary_in_mult708 = new BitSet(new long[]{0x0000000000448002L});
    public static final BitSet FOLLOW_16_in_term733 = new BitSet(new long[]{0x0000000000291820L});
    public static final BitSet FOLLOW_expression_in_term735 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_term737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term767 = new BitSet(new long[]{0x0000000000000002L});

}