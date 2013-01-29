// $ANTLR 3.4 Dialog.g 2013-01-29 20:32:31

package net.citizensnpcs.adventures.dialog;
import java.util.concurrent.TimeUnit;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class DialogLexer extends Lexer {
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

    /*  @Override
        public void reportError(RecognitionException e) {
            throw e;
        }
    */
    private String stripQuotes(String quoted) {
        return quoted.substring(1, quoted.length() - 1);
    }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public DialogLexer() {} 
    public DialogLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DialogLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Dialog.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:22:7: ( '!=' )
            // Dialog.g:22:9: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:23:7: ( '%' )
            // Dialog.g:23:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:24:7: ( '(' )
            // Dialog.g:24:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:25:7: ( ')' )
            // Dialog.g:25:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:26:7: ( '*' )
            // Dialog.g:26:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:27:7: ( '**' )
            // Dialog.g:27:9: '**'
            {
            match("**"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:28:7: ( '+' )
            // Dialog.g:28:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:29:7: ( ',' )
            // Dialog.g:29:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:30:7: ( '-' )
            // Dialog.g:30:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:31:7: ( '-p' )
            // Dialog.g:31:9: '-p'
            {
            match("-p"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:32:7: ( '.' )
            // Dialog.g:32:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:33:7: ( '/' )
            // Dialog.g:33:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:34:7: ( ':' )
            // Dialog.g:34:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:35:7: ( ';' )
            // Dialog.g:35:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:36:7: ( '<' )
            // Dialog.g:36:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:37:7: ( '<=' )
            // Dialog.g:37:9: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:38:7: ( '=' )
            // Dialog.g:38:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:39:7: ( '>' )
            // Dialog.g:39:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:40:7: ( '>=' )
            // Dialog.g:40:9: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:41:7: ( '[' )
            // Dialog.g:41:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:42:7: ( ']' )
            // Dialog.g:42:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:43:7: ( 'criteria' )
            // Dialog.g:43:9: 'criteria'
            {
            match("criteria"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:44:7: ( 'd' )
            // Dialog.g:44:9: 'd'
            {
            match('d'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:45:7: ( 'events=' )
            // Dialog.g:45:9: 'events='
            {
            match("events="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:46:7: ( 'false' )
            // Dialog.g:46:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:47:7: ( 'h' )
            // Dialog.g:47:9: 'h'
            {
            match('h'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:48:7: ( 'm' )
            // Dialog.g:48:9: 'm'
            {
            match('m'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:49:7: ( 'ms' )
            // Dialog.g:49:9: 'ms'
            {
            match("ms"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:50:7: ( 'ns' )
            // Dialog.g:50:9: 'ns'
            {
            match("ns"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:51:7: ( 'remember' )
            // Dialog.g:51:9: 'remember'
            {
            match("remember"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:52:7: ( 'response' )
            // Dialog.g:52:9: 'response'
            {
            match("response"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:53:7: ( 'rule' )
            // Dialog.g:53:9: 'rule'
            {
            match("rule"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:54:7: ( 's' )
            // Dialog.g:54:9: 's'
            {
            match('s'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:55:7: ( 'then' )
            // Dialog.g:55:9: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:56:7: ( 'true' )
            // Dialog.g:56:9: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:57:7: ( 'us' )
            // Dialog.g:57:9: 'us'
            {
            match("us"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:58:7: ( '{' )
            // Dialog.g:58:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:59:7: ( '}' )
            // Dialog.g:59:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:60:7: ( '~=' )
            // Dialog.g:60:9: '~='
            {
            match("~="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "ML_COMMENT"
    public final void mML_COMMENT() throws RecognitionException {
        try {
            int _type = ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:212:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // Dialog.g:213:5: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 



            // Dialog.g:213:10: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Dialog.g:213:38: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("*/"); 



             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ML_COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:215:14: ( '//' (~ NEWLINE )* )
            // Dialog.g:216:5: '//' (~ NEWLINE )*
            {
            match("//"); 



            // Dialog.g:216:10: (~ NEWLINE )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // Dialog.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            // Dialog.g:218:18: ( '\\n' | '\\r' )
            // Dialog.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:222:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // Dialog.g:223:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // Dialog.g:223:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // Dialog.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:225:7: ( LETTER ( LETTER | '_' | DIGIT )* )
            // Dialog.g:226:5: LETTER ( LETTER | '_' | DIGIT )*
            {
            mLETTER(); 


            // Dialog.g:226:12: ( LETTER | '_' | DIGIT )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // Dialog.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // Dialog.g:228:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // Dialog.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // Dialog.g:231:16: ( ( '0' .. '9' ) )
            // Dialog.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            // Dialog.g:234:18: ( ( DIGIT )+ )
            // Dialog.g:235:5: ( DIGIT )+
            {
            // Dialog.g:235:5: ( DIGIT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // Dialog.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:237:8: ( ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )? )
            // Dialog.g:238:5: ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )?
            {
            // Dialog.g:238:5: ( '-' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='-') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // Dialog.g:238:5: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Dialog.g:238:10: ( DIGIT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // Dialog.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // Dialog.g:238:17: ( '.' ( DIGIT )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='.') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // Dialog.g:238:18: '.' ( DIGIT )+
                    {
                    match('.'); 

                    // Dialog.g:238:22: ( DIGIT )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // Dialog.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Dialog.g:240:16: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\"') ) {
                alt12=1;
            }
            else if ( (LA12_0=='\'') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // Dialog.g:241:5: '\"' ( . )* '\"'
                    {
                    match('\"'); 

                    // Dialog.g:241:9: ( . )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0=='\"') ) {
                            alt10=2;
                        }
                        else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // Dialog.g:241:9: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    match('\"'); 

                     setText(stripQuotes(getText())); 

                    }
                    break;
                case 2 :
                    // Dialog.g:242:7: '\\'' ( . )* '\\''
                    {
                    match('\''); 

                    // Dialog.g:242:12: ( . )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\'') ) {
                            alt11=2;
                        }
                        else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '&')||(LA11_0 >= '(' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // Dialog.g:242:12: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    match('\''); 

                     setText(stripQuotes(getText())); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    public void mTokens() throws RecognitionException {
        // Dialog.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | ML_COMMENT | LINE_COMMENT | WS | IDENT | NUMBER | STRING_LITERAL )
        int alt13=45;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // Dialog.g:1:10: T__14
                {
                mT__14(); 


                }
                break;
            case 2 :
                // Dialog.g:1:16: T__15
                {
                mT__15(); 


                }
                break;
            case 3 :
                // Dialog.g:1:22: T__16
                {
                mT__16(); 


                }
                break;
            case 4 :
                // Dialog.g:1:28: T__17
                {
                mT__17(); 


                }
                break;
            case 5 :
                // Dialog.g:1:34: T__18
                {
                mT__18(); 


                }
                break;
            case 6 :
                // Dialog.g:1:40: T__19
                {
                mT__19(); 


                }
                break;
            case 7 :
                // Dialog.g:1:46: T__20
                {
                mT__20(); 


                }
                break;
            case 8 :
                // Dialog.g:1:52: T__21
                {
                mT__21(); 


                }
                break;
            case 9 :
                // Dialog.g:1:58: T__22
                {
                mT__22(); 


                }
                break;
            case 10 :
                // Dialog.g:1:64: T__23
                {
                mT__23(); 


                }
                break;
            case 11 :
                // Dialog.g:1:70: T__24
                {
                mT__24(); 


                }
                break;
            case 12 :
                // Dialog.g:1:76: T__25
                {
                mT__25(); 


                }
                break;
            case 13 :
                // Dialog.g:1:82: T__26
                {
                mT__26(); 


                }
                break;
            case 14 :
                // Dialog.g:1:88: T__27
                {
                mT__27(); 


                }
                break;
            case 15 :
                // Dialog.g:1:94: T__28
                {
                mT__28(); 


                }
                break;
            case 16 :
                // Dialog.g:1:100: T__29
                {
                mT__29(); 


                }
                break;
            case 17 :
                // Dialog.g:1:106: T__30
                {
                mT__30(); 


                }
                break;
            case 18 :
                // Dialog.g:1:112: T__31
                {
                mT__31(); 


                }
                break;
            case 19 :
                // Dialog.g:1:118: T__32
                {
                mT__32(); 


                }
                break;
            case 20 :
                // Dialog.g:1:124: T__33
                {
                mT__33(); 


                }
                break;
            case 21 :
                // Dialog.g:1:130: T__34
                {
                mT__34(); 


                }
                break;
            case 22 :
                // Dialog.g:1:136: T__35
                {
                mT__35(); 


                }
                break;
            case 23 :
                // Dialog.g:1:142: T__36
                {
                mT__36(); 


                }
                break;
            case 24 :
                // Dialog.g:1:148: T__37
                {
                mT__37(); 


                }
                break;
            case 25 :
                // Dialog.g:1:154: T__38
                {
                mT__38(); 


                }
                break;
            case 26 :
                // Dialog.g:1:160: T__39
                {
                mT__39(); 


                }
                break;
            case 27 :
                // Dialog.g:1:166: T__40
                {
                mT__40(); 


                }
                break;
            case 28 :
                // Dialog.g:1:172: T__41
                {
                mT__41(); 


                }
                break;
            case 29 :
                // Dialog.g:1:178: T__42
                {
                mT__42(); 


                }
                break;
            case 30 :
                // Dialog.g:1:184: T__43
                {
                mT__43(); 


                }
                break;
            case 31 :
                // Dialog.g:1:190: T__44
                {
                mT__44(); 


                }
                break;
            case 32 :
                // Dialog.g:1:196: T__45
                {
                mT__45(); 


                }
                break;
            case 33 :
                // Dialog.g:1:202: T__46
                {
                mT__46(); 


                }
                break;
            case 34 :
                // Dialog.g:1:208: T__47
                {
                mT__47(); 


                }
                break;
            case 35 :
                // Dialog.g:1:214: T__48
                {
                mT__48(); 


                }
                break;
            case 36 :
                // Dialog.g:1:220: T__49
                {
                mT__49(); 


                }
                break;
            case 37 :
                // Dialog.g:1:226: T__50
                {
                mT__50(); 


                }
                break;
            case 38 :
                // Dialog.g:1:232: T__51
                {
                mT__51(); 


                }
                break;
            case 39 :
                // Dialog.g:1:238: T__52
                {
                mT__52(); 


                }
                break;
            case 40 :
                // Dialog.g:1:244: ML_COMMENT
                {
                mML_COMMENT(); 


                }
                break;
            case 41 :
                // Dialog.g:1:255: LINE_COMMENT
                {
                mLINE_COMMENT(); 


                }
                break;
            case 42 :
                // Dialog.g:1:268: WS
                {
                mWS(); 


                }
                break;
            case 43 :
                // Dialog.g:1:271: IDENT
                {
                mIDENT(); 


                }
                break;
            case 44 :
                // Dialog.g:1:277: NUMBER
                {
                mNUMBER(); 


                }
                break;
            case 45 :
                // Dialog.g:1:284: STRING_LITERAL
                {
                mSTRING_LITERAL(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\5\uffff\1\45\2\uffff\1\47\1\uffff\1\52\2\uffff\1\54\1\uffff\1\56"+
        "\2\uffff\1\41\1\60\2\41\1\63\1\65\2\41\1\71\2\41\22\uffff\1\41\1"+
        "\uffff\2\41\1\uffff\1\100\1\uffff\1\101\2\41\1\uffff\2\41\1\107"+
        "\3\41\2\uffff\5\41\1\uffff\5\41\1\125\1\126\1\127\2\41\1\132\2\41"+
        "\3\uffff\2\41\1\uffff\3\41\1\uffff\2\41\1\144\1\145\1\146\3\uffff";
    static final String DFA13_eofS =
        "\147\uffff";
    static final String DFA13_minS =
        "\1\11\4\uffff\1\52\2\uffff\1\60\1\uffff\1\52\2\uffff\1\75\1\uffff"+
        "\1\75\2\uffff\1\162\1\60\1\166\1\141\2\60\1\163\1\145\1\60\1\150"+
        "\1\163\22\uffff\1\151\1\uffff\1\145\1\154\1\uffff\1\60\1\uffff\1"+
        "\60\1\155\1\154\1\uffff\1\145\1\165\1\60\1\164\1\156\1\163\2\uffff"+
        "\1\145\1\160\1\145\1\156\1\145\1\uffff\1\145\1\164\1\145\1\155\1"+
        "\157\3\60\1\162\1\163\1\60\1\142\1\156\3\uffff\1\151\1\75\1\uffff"+
        "\1\145\1\163\1\141\1\uffff\1\162\1\145\3\60\3\uffff";
    static final String DFA13_maxS =
        "\1\176\4\uffff\1\52\2\uffff\1\160\1\uffff\1\57\2\uffff\1\75\1\uffff"+
        "\1\75\2\uffff\1\162\1\172\1\166\1\141\2\172\1\163\1\165\1\172\1"+
        "\162\1\163\22\uffff\1\151\1\uffff\1\145\1\154\1\uffff\1\172\1\uffff"+
        "\1\172\1\163\1\154\1\uffff\1\145\1\165\1\172\1\164\1\156\1\163\2"+
        "\uffff\1\145\1\160\1\145\1\156\1\145\1\uffff\1\145\1\164\1\145\1"+
        "\155\1\157\3\172\1\162\1\163\1\172\1\142\1\156\3\uffff\1\151\1\75"+
        "\1\uffff\1\145\1\163\1\141\1\uffff\1\162\1\145\3\172\3\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\7\1\10\1\uffff\1\13\1\uffff\1"+
        "\15\1\16\1\uffff\1\21\1\uffff\1\24\1\25\13\uffff\1\45\1\46\1\47"+
        "\1\52\1\53\1\54\1\55\1\6\1\5\1\12\1\11\1\50\1\51\1\14\1\20\1\17"+
        "\1\23\1\22\1\uffff\1\27\2\uffff\1\32\1\uffff\1\33\3\uffff\1\41\6"+
        "\uffff\1\34\1\35\5\uffff\1\44\15\uffff\1\40\1\42\1\43\2\uffff\1"+
        "\31\3\uffff\1\30\5\uffff\1\26\1\36\1\37";
    static final String DFA13_specialS =
        "\147\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\40\2\uffff\1\40\22\uffff\1\40\1\1\1\43\2\uffff\1\2\1\uffff"+
            "\1\43\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\12\42\1\13\1\14\1\15"+
            "\1\16\1\17\2\uffff\32\41\1\20\1\uffff\1\21\3\uffff\2\41\1\22"+
            "\1\23\1\24\1\25\1\41\1\26\4\41\1\27\1\30\3\41\1\31\1\32\1\33"+
            "\1\34\5\41\1\35\1\uffff\1\36\1\37",
            "",
            "",
            "",
            "",
            "\1\44",
            "",
            "",
            "\12\42\66\uffff\1\46",
            "",
            "\1\50\4\uffff\1\51",
            "",
            "",
            "\1\53",
            "",
            "\1\55",
            "",
            "",
            "\1\57",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\61",
            "\1\62",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\64\7\41",
            "\1\66",
            "\1\67\17\uffff\1\70",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\72\11\uffff\1\73",
            "\1\74",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\75",
            "",
            "\1\76",
            "\1\77",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\102\5\uffff\1\103",
            "\1\104",
            "",
            "\1\105",
            "\1\106",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\110",
            "\1\111",
            "\1\112",
            "",
            "",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\130",
            "\1\131",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\1\133",
            "\1\134",
            "",
            "",
            "",
            "\1\135",
            "\1\136",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "\1\142",
            "\1\143",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | ML_COMMENT | LINE_COMMENT | WS | IDENT | NUMBER | STRING_LITERAL );";
        }
    }
 

}