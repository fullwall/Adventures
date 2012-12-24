// $ANTLR 3.4 Dialog.g 2012-12-24 23:36:13

package net.citizensnpcs.adventures.dialog;
import java.util.concurrent.Callable;
import java.util.Collection;
import com.google.common.base.Predicates;
import net.citizensnpcs.adventures.dialog.evaluators.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class DialogParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIGIT", "IDENT", "LETTER", "LINE_COMMENT", "ML_COMMENT", "NEWLINE", "NUMBER", "STRING_LITERAL", "WS", "'!='", "'%'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "';'", "'<'", "'<='", "'='", "'>'", "'>='", "'criteria'", "'events='", "'response'", "'rule'", "'then'", "'{'", "'}'"
    };

    public static final int EOF=-1;
    public static final int T__13=13;
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
    public static final int DIGIT=4;
    public static final int IDENT=5;
    public static final int LETTER=6;
    public static final int LINE_COMMENT=7;
    public static final int ML_COMMENT=8;
    public static final int NEWLINE=9;
    public static final int NUMBER=10;
    public static final int STRING_LITERAL=11;
    public static final int WS=12;

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


    private VariableSource variableSource;

    public void setVariableSource(VariableSource source) {
        this.variableSource = source;
    }


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // Dialog.g:29:1: program[DialogRegistry registry] : ( rule | response )* ;
    public final DialogParser.program_return program(DialogRegistry registry) throws RecognitionException {
        DialogParser.program_return retval = new DialogParser.program_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        DialogParser.rule_return rule1 =null;

        DialogParser.response_return response2 =null;



        try {
            // Dialog.g:29:35: ( ( rule | response )* )
            // Dialog.g:30:5: ( rule | response )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // Dialog.g:30:5: ( rule | response )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==31) ) {
                    alt1=1;
                }
                else if ( (LA1_0==30) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:31:9: rule
            	    {
            	    pushFollow(FOLLOW_rule_in_program95);
            	    rule1=rule();

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule1.getTree());

            	    registry.registerRule((rule1!=null?rule1.eventNames:null), (rule1!=null?rule1.rule:null));

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:32:11: response
            	    {
            	    pushFollow(FOLLOW_response_in_program109);
            	    response2=response();

            	    state._fsp--;

            	    adaptor.addChild(root_0, response2.getTree());

            	    registry.registerResponse((response2!=null?response2.responseName:null), (response2!=null?response2.response:null));

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "program"


    public static class response_return extends ParserRuleReturnScope {
        public String responseName;
        public Response response;
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "response"
    // Dialog.g:35:1: response returns [String responseName, Response response] : 'response' IDENT '{' ! ( response_statement ';' !)* '}' !;
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
            // Dialog.g:35:58: ( 'response' IDENT '{' ! ( response_statement ';' !)* '}' !)
            // Dialog.g:36:5: 'response' IDENT '{' ! ( response_statement ';' !)* '}' !
            {
            root_0 = (CommonTree)adaptor.nil();


            Response.Builder builder = Response.builder();

            string_literal3=(Token)match(input,30,FOLLOW_30_in_response139); 
            string_literal3_tree = 
            (CommonTree)adaptor.create(string_literal3)
            ;
            adaptor.addChild(root_0, string_literal3_tree);


            IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_response141); 
            IDENT4_tree = 
            (CommonTree)adaptor.create(IDENT4)
            ;
            adaptor.addChild(root_0, IDENT4_tree);


            retval.responseName = (IDENT4!=null?IDENT4.getText():null);

            char_literal5=(Token)match(input,33,FOLLOW_33_in_response145); 

            // Dialog.g:37:58: ( response_statement ';' !)*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==22) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Dialog.g:37:59: response_statement ';' !
            	    {
            	    pushFollow(FOLLOW_response_statement_in_response149);
            	    response_statement6=response_statement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, response_statement6.getTree());

            	    char_literal7=(Token)match(input,22,FOLLOW_22_in_response151); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            char_literal8=(Token)match(input,34,FOLLOW_34_in_response156); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:39:1: response_statement :;
    public final DialogParser.response_statement_return response_statement() throws RecognitionException {
        DialogParser.response_statement_return retval = new DialogParser.response_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        try {
            // Dialog.g:39:20: ()
            // Dialog.g:39:21: 
            {
            root_0 = (CommonTree)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
    // Dialog.g:41:1: rule returns [Collection<String> eventNames, Rule rule] : 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !;
    public final DialogParser.rule_return rule() throws RecognitionException {
        DialogParser.rule_return retval = new DialogParser.rule_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token string_literal9=null;
        Token IDENT10=null;
        Token char_literal11=null;
        Token char_literal13=null;
        Token char_literal15=null;
        Token char_literal16=null;
        DialogParser.criteria_return criteria12 =null;

        DialogParser.rule_statement_return rule_statement14 =null;


        CommonTree string_literal9_tree=null;
        CommonTree IDENT10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree char_literal16_tree=null;

        try {
            // Dialog.g:41:56: ( 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !)
            // Dialog.g:42:5: 'rule' IDENT '{' ! criteria ';' ! ( rule_statement[builder] ';' !)* '}' !
            {
            root_0 = (CommonTree)adaptor.nil();


            Rule.Builder builder = Rule.builder();

            string_literal9=(Token)match(input,31,FOLLOW_31_in_rule184); 
            string_literal9_tree = 
            (CommonTree)adaptor.create(string_literal9)
            ;
            adaptor.addChild(root_0, string_literal9_tree);


            IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule186); 
            IDENT10_tree = 
            (CommonTree)adaptor.create(IDENT10)
            ;
            adaptor.addChild(root_0, IDENT10_tree);


            char_literal11=(Token)match(input,33,FOLLOW_33_in_rule188); 

            pushFollow(FOLLOW_criteria_in_rule191);
            criteria12=criteria();

            state._fsp--;

            adaptor.addChild(root_0, criteria12.getTree());

            retval.eventNames = (criteria12!=null?criteria12.eventNames:null);

            char_literal13=(Token)match(input,22,FOLLOW_22_in_rule195); 

            // Dialog.g:43:75: ( rule_statement[builder] ';' !)*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==30) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:43:76: rule_statement[builder] ';' !
            	    {
            	    pushFollow(FOLLOW_rule_statement_in_rule199);
            	    rule_statement14=rule_statement(builder);

            	    state._fsp--;

            	    adaptor.addChild(root_0, rule_statement14.getTree());

            	    char_literal15=(Token)match(input,22,FOLLOW_22_in_rule202); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            char_literal16=(Token)match(input,34,FOLLOW_34_in_rule207); 

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:45:1: rule_statement[Rule.Builder builder] : 'response' n= IDENT ( 'then' target= IDENT event= IDENT )? ;
    public final DialogParser.rule_statement_return rule_statement(Rule.Builder builder) throws RecognitionException {
        DialogParser.rule_statement_return retval = new DialogParser.rule_statement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token n=null;
        Token target=null;
        Token event=null;
        Token string_literal17=null;
        Token string_literal18=null;

        CommonTree n_tree=null;
        CommonTree target_tree=null;
        CommonTree event_tree=null;
        CommonTree string_literal17_tree=null;
        CommonTree string_literal18_tree=null;

        try {
            // Dialog.g:45:38: ( 'response' n= IDENT ( 'then' target= IDENT event= IDENT )? )
            // Dialog.g:46:5: 'response' n= IDENT ( 'then' target= IDENT event= IDENT )?
            {
            root_0 = (CommonTree)adaptor.nil();


            string_literal17=(Token)match(input,30,FOLLOW_30_in_rule_statement225); 
            string_literal17_tree = 
            (CommonTree)adaptor.create(string_literal17)
            ;
            adaptor.addChild(root_0, string_literal17_tree);


            n=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement229); 
            n_tree = 
            (CommonTree)adaptor.create(n)
            ;
            adaptor.addChild(root_0, n_tree);


            CallResponse.Builder responseBuilder = CallResponse.builder((n!=null?n.getText():null));

            // Dialog.g:48:5: ( 'then' target= IDENT event= IDENT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==32) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // Dialog.g:48:6: 'then' target= IDENT event= IDENT
                    {
                    string_literal18=(Token)match(input,32,FOLLOW_32_in_rule_statement244); 
                    string_literal18_tree = 
                    (CommonTree)adaptor.create(string_literal18)
                    ;
                    adaptor.addChild(root_0, string_literal18_tree);


                    target=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement248); 
                    target_tree = 
                    (CommonTree)adaptor.create(target)
                    ;
                    adaptor.addChild(root_0, target_tree);


                    event=(Token)match(input,IDENT,FOLLOW_IDENT_in_rule_statement252); 
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

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:51:1: criteria returns [Collection<String> eventNames] : 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )+ ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )+ ;
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
        Token string_literal19=null;
        Token string_literal20=null;
        Token char_literal21=null;
        Token char_literal22=null;
        Token char_literal23=null;
        Token char_literal24=null;
        Token string_literal25=null;
        Token string_literal26=null;
        Token string_literal27=null;
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
        CommonTree string_literal19_tree=null;
        CommonTree string_literal20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree string_literal25_tree=null;
        CommonTree string_literal26_tree=null;
        CommonTree string_literal27_tree=null;

        try {
            // Dialog.g:51:49: ( 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )+ ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )+ )
            // Dialog.g:52:5: 'criteria' ( 'events=' e1= IDENT ( ',' e2= IDENT )+ ) (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )+
            {
            root_0 = (CommonTree)adaptor.nil();


            retval.eventNames = new ArrayList<String>();

            string_literal19=(Token)match(input,28,FOLLOW_28_in_criteria288); 
            string_literal19_tree = 
            (CommonTree)adaptor.create(string_literal19)
            ;
            adaptor.addChild(root_0, string_literal19_tree);


            // Dialog.g:53:16: ( 'events=' e1= IDENT ( ',' e2= IDENT )+ )
            // Dialog.g:53:17: 'events=' e1= IDENT ( ',' e2= IDENT )+
            {
            string_literal20=(Token)match(input,29,FOLLOW_29_in_criteria291); 
            string_literal20_tree = 
            (CommonTree)adaptor.create(string_literal20)
            ;
            adaptor.addChild(root_0, string_literal20_tree);


            e1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria295); 
            e1_tree = 
            (CommonTree)adaptor.create(e1)
            ;
            adaptor.addChild(root_0, e1_tree);


            retval.eventNames.add((e1!=null?e1.getText():null));

            // Dialog.g:53:65: ( ',' e2= IDENT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==19) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:53:66: ',' e2= IDENT
            	    {
            	    char_literal21=(Token)match(input,19,FOLLOW_19_in_criteria300); 
            	    char_literal21_tree = 
            	    (CommonTree)adaptor.create(char_literal21)
            	    ;
            	    adaptor.addChild(root_0, char_literal21_tree);


            	    e2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria304); 
            	    e2_tree = 
            	    (CommonTree)adaptor.create(e2)
            	    ;
            	    adaptor.addChild(root_0, e2_tree);


            	    retval.eventNames.add((e2!=null?e2.getText():null));

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }


            // Dialog.g:54:5: (i1= IDENT '=' op1= expression |i2= IDENT '>' op2= expression |i3= IDENT '<' op3= expression |i4= IDENT '<=' op4= expression |i5= IDENT '>=' op5= expression |i6= IDENT '!=' op6= expression |i7= IDENT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=8;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDENT) ) {
                    switch ( input.LA(2) ) {
                    case 25:
                        {
                        alt6=1;
                        }
                        break;
                    case 26:
                        {
                        alt6=2;
                        }
                        break;
                    case 23:
                        {
                        alt6=3;
                        }
                        break;
                    case 24:
                        {
                        alt6=4;
                        }
                        break;
                    case 27:
                        {
                        alt6=5;
                        }
                        break;
                    case 13:
                        {
                        alt6=6;
                        }
                        break;
                    case IDENT:
                    case 22:
                        {
                        alt6=7;
                        }
                        break;

                    }

                }


                switch (alt6) {
            	case 1 :
            	    // Dialog.g:55:9: i1= IDENT '=' op1= expression
            	    {
            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria327); 
            	    i1_tree = 
            	    (CommonTree)adaptor.create(i1)
            	    ;
            	    adaptor.addChild(root_0, i1_tree);


            	    char_literal22=(Token)match(input,25,FOLLOW_25_in_criteria329); 
            	    char_literal22_tree = 
            	    (CommonTree)adaptor.create(char_literal22)
            	    ;
            	    adaptor.addChild(root_0, char_literal22_tree);


            	    pushFollow(FOLLOW_expression_in_criteria333);
            	    op1=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op1.getTree());



            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:56:11: i2= IDENT '>' op2= expression
            	    {
            	    i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria349); 
            	    i2_tree = 
            	    (CommonTree)adaptor.create(i2)
            	    ;
            	    adaptor.addChild(root_0, i2_tree);


            	    char_literal23=(Token)match(input,26,FOLLOW_26_in_criteria351); 
            	    char_literal23_tree = 
            	    (CommonTree)adaptor.create(char_literal23)
            	    ;
            	    adaptor.addChild(root_0, char_literal23_tree);


            	    pushFollow(FOLLOW_expression_in_criteria355);
            	    op2=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());



            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:57:11: i3= IDENT '<' op3= expression
            	    {
            	    i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria371); 
            	    i3_tree = 
            	    (CommonTree)adaptor.create(i3)
            	    ;
            	    adaptor.addChild(root_0, i3_tree);


            	    char_literal24=(Token)match(input,23,FOLLOW_23_in_criteria373); 
            	    char_literal24_tree = 
            	    (CommonTree)adaptor.create(char_literal24)
            	    ;
            	    adaptor.addChild(root_0, char_literal24_tree);


            	    pushFollow(FOLLOW_expression_in_criteria377);
            	    op3=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op3.getTree());



            	    }
            	    break;
            	case 4 :
            	    // Dialog.g:58:11: i4= IDENT '<=' op4= expression
            	    {
            	    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria393); 
            	    i4_tree = 
            	    (CommonTree)adaptor.create(i4)
            	    ;
            	    adaptor.addChild(root_0, i4_tree);


            	    string_literal25=(Token)match(input,24,FOLLOW_24_in_criteria395); 
            	    string_literal25_tree = 
            	    (CommonTree)adaptor.create(string_literal25)
            	    ;
            	    adaptor.addChild(root_0, string_literal25_tree);


            	    pushFollow(FOLLOW_expression_in_criteria399);
            	    op4=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op4.getTree());



            	    }
            	    break;
            	case 5 :
            	    // Dialog.g:59:11: i5= IDENT '>=' op5= expression
            	    {
            	    i5=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria415); 
            	    i5_tree = 
            	    (CommonTree)adaptor.create(i5)
            	    ;
            	    adaptor.addChild(root_0, i5_tree);


            	    string_literal26=(Token)match(input,27,FOLLOW_27_in_criteria417); 
            	    string_literal26_tree = 
            	    (CommonTree)adaptor.create(string_literal26)
            	    ;
            	    adaptor.addChild(root_0, string_literal26_tree);


            	    pushFollow(FOLLOW_expression_in_criteria421);
            	    op5=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op5.getTree());



            	    }
            	    break;
            	case 6 :
            	    // Dialog.g:60:11: i6= IDENT '!=' op6= expression
            	    {
            	    i6=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria437); 
            	    i6_tree = 
            	    (CommonTree)adaptor.create(i6)
            	    ;
            	    adaptor.addChild(root_0, i6_tree);


            	    string_literal27=(Token)match(input,13,FOLLOW_13_in_criteria439); 
            	    string_literal27_tree = 
            	    (CommonTree)adaptor.create(string_literal27)
            	    ;
            	    adaptor.addChild(root_0, string_literal27_tree);


            	    pushFollow(FOLLOW_expression_in_criteria443);
            	    op6=expression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op6.getTree());



            	    }
            	    break;
            	case 7 :
            	    // Dialog.g:61:11: i7= IDENT
            	    {
            	    i7=(Token)match(input,IDENT,FOLLOW_IDENT_in_criteria459); 
            	    i7_tree = 
            	    (CommonTree)adaptor.create(i7)
            	    ;
            	    adaptor.addChild(root_0, i7_tree);


            	    NumberQueryPredicate.of((i7!=null?i7.getText():null), Predicates.<Number>alwaysTrue());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:64:1: expression returns [Evaluator value] : op1= mult ( '+' op2= mult | '-' op2= mult )* ;
    public final DialogParser.expression_return expression() throws RecognitionException {
        DialogParser.expression_return retval = new DialogParser.expression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal28=null;
        Token char_literal29=null;
        DialogParser.mult_return op1 =null;

        DialogParser.mult_return op2 =null;


        CommonTree char_literal28_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // Dialog.g:64:38: (op1= mult ( '+' op2= mult | '-' op2= mult )* )
            // Dialog.g:65:5: op1= mult ( '+' op2= mult | '-' op2= mult )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_mult_in_expression490);
            op1=mult();

            state._fsp--;

            adaptor.addChild(root_0, op1.getTree());

            retval.value = (op1!=null?op1.value:null);

            // Dialog.g:66:5: ( '+' op2= mult | '-' op2= mult )*
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }
                else if ( (LA7_0==20) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // Dialog.g:67:5: '+' op2= mult
            	    {
            	    char_literal28=(Token)match(input,18,FOLLOW_18_in_expression504); 
            	    char_literal28_tree = 
            	    (CommonTree)adaptor.create(char_literal28)
            	    ;
            	    adaptor.addChild(root_0, char_literal28_tree);


            	    pushFollow(FOLLOW_mult_in_expression508);
            	    op2=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	    retval.value = PlusEvaluator.create(retval.value, (op2!=null?op2.value:null));

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:68:8: '-' op2= mult
            	    {
            	    char_literal29=(Token)match(input,20,FOLLOW_20_in_expression519); 
            	    char_literal29_tree = 
            	    (CommonTree)adaptor.create(char_literal29)
            	    ;
            	    adaptor.addChild(root_0, char_literal29_tree);


            	    pushFollow(FOLLOW_mult_in_expression523);
            	    op2=mult();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	    retval.value = MinusEvaluator.create(retval.value, (op2!=null?op2.value:null));

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
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:71:1: unary returns [Evaluator value] : ( '+' | '-' )* term ;
    public final DialogParser.unary_return unary() throws RecognitionException {
        DialogParser.unary_return retval = new DialogParser.unary_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal30=null;
        Token char_literal31=null;
        DialogParser.term_return term32 =null;


        CommonTree char_literal30_tree=null;
        CommonTree char_literal31_tree=null;

        try {
            // Dialog.g:71:33: ( ( '+' | '-' )* term )
            // Dialog.g:72:5: ( '+' | '-' )* term
            {
            root_0 = (CommonTree)adaptor.nil();


            boolean positive = true;

            // Dialog.g:73:5: ( '+' | '-' )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }
                else if ( (LA8_0==20) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // Dialog.g:73:6: '+'
            	    {
            	    char_literal30=(Token)match(input,18,FOLLOW_18_in_unary555); 
            	    char_literal30_tree = 
            	    (CommonTree)adaptor.create(char_literal30)
            	    ;
            	    adaptor.addChild(root_0, char_literal30_tree);


            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:73:12: '-'
            	    {
            	    char_literal31=(Token)match(input,20,FOLLOW_20_in_unary559); 
            	    char_literal31_tree = 
            	    (CommonTree)adaptor.create(char_literal31)
            	    ;
            	    adaptor.addChild(root_0, char_literal31_tree);


            	    positive = !positive;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            pushFollow(FOLLOW_term_in_unary569);
            term32=term();

            state._fsp--;

            adaptor.addChild(root_0, term32.getTree());


                     retval.value = (term32!=null?term32.value:null);
                     if (!positive)
                     	retval.value = NegationEvaluator.create(retval.value);
                     

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:80:1: mult returns [Evaluator value] : op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )* ;
    public final DialogParser.mult_return mult() throws RecognitionException {
        DialogParser.mult_return retval = new DialogParser.mult_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal33=null;
        Token char_literal34=null;
        Token char_literal35=null;
        DialogParser.unary_return op1 =null;

        DialogParser.unary_return op2 =null;


        CommonTree char_literal33_tree=null;
        CommonTree char_literal34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // Dialog.g:80:32: (op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )* )
            // Dialog.g:81:5: op1= unary ( '*' op2= unary | '/' op2= unary | '%' op2= unary )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_unary_in_mult589);
            op1=unary();

            state._fsp--;

            adaptor.addChild(root_0, op1.getTree());

            retval.value = (op1!=null?op1.value:null);

            // Dialog.g:82:5: ( '*' op2= unary | '/' op2= unary | '%' op2= unary )*
            loop9:
            do {
                int alt9=4;
                switch ( input.LA(1) ) {
                case 17:
                    {
                    alt9=1;
                    }
                    break;
                case 21:
                    {
                    alt9=2;
                    }
                    break;
                case 14:
                    {
                    alt9=3;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // Dialog.g:82:6: '*' op2= unary
            	    {
            	    char_literal33=(Token)match(input,17,FOLLOW_17_in_mult598); 
            	    char_literal33_tree = 
            	    (CommonTree)adaptor.create(char_literal33)
            	    ;
            	    adaptor.addChild(root_0, char_literal33_tree);


            	    pushFollow(FOLLOW_unary_in_mult602);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = MultiplyEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;
            	case 2 :
            	    // Dialog.g:83:11: '/' op2= unary
            	    {
            	    char_literal34=(Token)match(input,21,FOLLOW_21_in_mult616); 
            	    char_literal34_tree = 
            	    (CommonTree)adaptor.create(char_literal34)
            	    ;
            	    adaptor.addChild(root_0, char_literal34_tree);


            	    pushFollow(FOLLOW_unary_in_mult620);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = DivideEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;
            	case 3 :
            	    // Dialog.g:84:11: '%' op2= unary
            	    {
            	    char_literal35=(Token)match(input,14,FOLLOW_14_in_mult634); 
            	    char_literal35_tree = 
            	    (CommonTree)adaptor.create(char_literal35)
            	    ;
            	    adaptor.addChild(root_0, char_literal35_tree);


            	    pushFollow(FOLLOW_unary_in_mult638);
            	    op2=unary();

            	    state._fsp--;

            	    adaptor.addChild(root_0, op2.getTree());

            	     retval.value = ModEvaluator.create(retval.value, (op2!=null?op2.value:null)); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

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
    // Dialog.g:87:1: term returns [Evaluator value] : ( '(' expression ')' | NUMBER | STRING_LITERAL | IDENT );
    public final DialogParser.term_return term() throws RecognitionException {
        DialogParser.term_return retval = new DialogParser.term_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal36=null;
        Token char_literal38=null;
        Token NUMBER39=null;
        Token STRING_LITERAL40=null;
        Token IDENT41=null;
        DialogParser.expression_return expression37 =null;


        CommonTree char_literal36_tree=null;
        CommonTree char_literal38_tree=null;
        CommonTree NUMBER39_tree=null;
        CommonTree STRING_LITERAL40_tree=null;
        CommonTree IDENT41_tree=null;

        try {
            // Dialog.g:87:32: ( '(' expression ')' | NUMBER | STRING_LITERAL | IDENT )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt10=1;
                }
                break;
            case NUMBER:
                {
                alt10=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt10=3;
                }
                break;
            case IDENT:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // Dialog.g:88:5: '(' expression ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    char_literal36=(Token)match(input,15,FOLLOW_15_in_term663); 
                    char_literal36_tree = 
                    (CommonTree)adaptor.create(char_literal36)
                    ;
                    adaptor.addChild(root_0, char_literal36_tree);


                    pushFollow(FOLLOW_expression_in_term665);
                    expression37=expression();

                    state._fsp--;

                    adaptor.addChild(root_0, expression37.getTree());

                    char_literal38=(Token)match(input,16,FOLLOW_16_in_term667); 
                    char_literal38_tree = 
                    (CommonTree)adaptor.create(char_literal38)
                    ;
                    adaptor.addChild(root_0, char_literal38_tree);


                     retval.value = (expression37!=null?expression37.value:null); 

                    }
                    break;
                case 2 :
                    // Dialog.g:89:7: NUMBER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    NUMBER39=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_term677); 
                    NUMBER39_tree = 
                    (CommonTree)adaptor.create(NUMBER39)
                    ;
                    adaptor.addChild(root_0, NUMBER39_tree);


                     retval.value = NumberEvaluator.create((NUMBER39!=null?NUMBER39.getText():null)); 

                    }
                    break;
                case 3 :
                    // Dialog.g:90:7: STRING_LITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    STRING_LITERAL40=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_term687); 
                    STRING_LITERAL40_tree = 
                    (CommonTree)adaptor.create(STRING_LITERAL40)
                    ;
                    adaptor.addChild(root_0, STRING_LITERAL40_tree);


                     retval.value = StringEvaluator.create((STRING_LITERAL40!=null?STRING_LITERAL40.getText():null)); 

                    }
                    break;
                case 4 :
                    // Dialog.g:91:7: IDENT
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENT41=(Token)match(input,IDENT,FOLLOW_IDENT_in_term697); 
                    IDENT41_tree = 
                    (CommonTree)adaptor.create(IDENT41)
                    ;
                    adaptor.addChild(root_0, IDENT41_tree);


                     retval.value = VariableEvaluator.create(variableSource, (IDENT41!=null?IDENT41.getText():null)); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "term"

    // Delegated rules


 

    public static final BitSet FOLLOW_rule_in_program95 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_response_in_program109 = new BitSet(new long[]{0x00000000C0000002L});
    public static final BitSet FOLLOW_30_in_response139 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_response141 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_response145 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_response_statement_in_response149 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_response151 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_34_in_response156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule184 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule186 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_rule188 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_criteria_in_rule191 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule195 = new BitSet(new long[]{0x0000000440000000L});
    public static final BitSet FOLLOW_rule_statement_in_rule199 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rule202 = new BitSet(new long[]{0x0000000440000000L});
    public static final BitSet FOLLOW_34_in_rule207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule_statement225 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement229 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_rule_statement244 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement248 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_rule_statement252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_criteria288 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_criteria291 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria295 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_criteria300 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_IDENT_in_criteria304 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_IDENT_in_criteria327 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_criteria329 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria333 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria349 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_criteria351 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria355 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria371 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_criteria373 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria377 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria393 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_criteria395 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria399 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria415 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_criteria417 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria421 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria437 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_criteria439 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_criteria443 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_IDENT_in_criteria459 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_mult_in_expression490 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_expression504 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_mult_in_expression508 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_20_in_expression519 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_mult_in_expression523 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_18_in_unary555 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_20_in_unary559 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_term_in_unary569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult589 = new BitSet(new long[]{0x0000000000224002L});
    public static final BitSet FOLLOW_17_in_mult598 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_unary_in_mult602 = new BitSet(new long[]{0x0000000000224002L});
    public static final BitSet FOLLOW_21_in_mult616 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_unary_in_mult620 = new BitSet(new long[]{0x0000000000224002L});
    public static final BitSet FOLLOW_14_in_mult634 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_unary_in_mult638 = new BitSet(new long[]{0x0000000000224002L});
    public static final BitSet FOLLOW_15_in_term663 = new BitSet(new long[]{0x0000000000148C20L});
    public static final BitSet FOLLOW_expression_in_term665 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_term667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_term677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_term687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term697 = new BitSet(new long[]{0x0000000000000002L});

}