// $ANTLR 3.5 net\\citizensnpcs\\adventures\\dialog\\Dialog.g 2013-02-20 17:37:51

package net.citizensnpcs.adventures.dialog;
import java.util.concurrent.TimeUnit;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class DialogLexer extends Lexer {
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

	/*
	@Override
	public void reportError(RecognitionException e) {
	    e.printStackTrace();
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
	@Override public String getGrammarFileName() { return "net\\citizensnpcs\\adventures\\dialog\\Dialog.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:24:7: ( '!' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:24:9: '!'
			{
			match('!'); 
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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:25:7: ( '!=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:25:9: '!='
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
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:26:7: ( '%' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:26:9: '%'
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
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:27:7: ( '(' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:27:9: '('
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
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:28:7: ( ')' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:28:9: ')'
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:29:7: ( '*' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:29:9: '*'
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
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:30:7: ( '**' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:30:9: '**'
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
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:31:7: ( '+' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:31:9: '+'
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
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:32:7: ( ',' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:32:9: ','
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
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:33:7: ( '-' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:33:9: '-'
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
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:34:7: ( '-p' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:34:9: '-p'
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
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:35:7: ( '/' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:35:9: '/'
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
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:36:7: ( ':' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:36:9: ':'
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
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:37:7: ( ';' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:37:9: ';'
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
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:38:7: ( '<' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:38:9: '<'
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
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:39:7: ( '<=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:39:9: '<='
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
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:40:7: ( '=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:40:9: '='
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
	// $ANTLR end "T__32"

	// $ANTLR start "T__33"
	public final void mT__33() throws RecognitionException {
		try {
			int _type = T__33;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:41:7: ( '>' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:41:9: '>'
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
	// $ANTLR end "T__33"

	// $ANTLR start "T__34"
	public final void mT__34() throws RecognitionException {
		try {
			int _type = T__34;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:42:7: ( '>=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:42:9: '>='
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
	// $ANTLR end "T__34"

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:43:7: ( '[' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:43:9: '['
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
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:44:7: ( ']' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:44:9: ']'
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
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:45:7: ( 'criteria' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:45:9: 'criteria'
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
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:46:7: ( 'd' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:46:9: 'd'
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
	// $ANTLR end "T__38"

	// $ANTLR start "T__39"
	public final void mT__39() throws RecognitionException {
		try {
			int _type = T__39;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:47:7: ( 'events=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:47:9: 'events='
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
	// $ANTLR end "T__39"

	// $ANTLR start "T__40"
	public final void mT__40() throws RecognitionException {
		try {
			int _type = T__40;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:48:7: ( 'false' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:48:9: 'false'
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
	// $ANTLR end "T__40"

	// $ANTLR start "T__41"
	public final void mT__41() throws RecognitionException {
		try {
			int _type = T__41;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:49:7: ( 'h' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:49:9: 'h'
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
	// $ANTLR end "T__41"

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:50:7: ( 'm' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:50:9: 'm'
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
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:51:7: ( 'ms' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:51:9: 'ms'
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
	// $ANTLR end "T__43"

	// $ANTLR start "T__44"
	public final void mT__44() throws RecognitionException {
		try {
			int _type = T__44;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:52:7: ( 'ns' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:52:9: 'ns'
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
	// $ANTLR end "T__44"

	// $ANTLR start "T__45"
	public final void mT__45() throws RecognitionException {
		try {
			int _type = T__45;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:53:7: ( 'random {' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:53:9: 'random {'
			{
			match("random {"); 

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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:54:7: ( 'remember' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:54:9: 'remember'
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
	// $ANTLR end "T__46"

	// $ANTLR start "T__47"
	public final void mT__47() throws RecognitionException {
		try {
			int _type = T__47;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:55:7: ( 'response' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:55:9: 'response'
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
	// $ANTLR end "T__47"

	// $ANTLR start "T__48"
	public final void mT__48() throws RecognitionException {
		try {
			int _type = T__48;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:56:7: ( 'rule' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:56:9: 'rule'
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
	// $ANTLR end "T__48"

	// $ANTLR start "T__49"
	public final void mT__49() throws RecognitionException {
		try {
			int _type = T__49;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:57:7: ( 's' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:57:9: 's'
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
	// $ANTLR end "T__49"

	// $ANTLR start "T__50"
	public final void mT__50() throws RecognitionException {
		try {
			int _type = T__50;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:58:7: ( 'then' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:58:9: 'then'
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
	// $ANTLR end "T__50"

	// $ANTLR start "T__51"
	public final void mT__51() throws RecognitionException {
		try {
			int _type = T__51;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:59:7: ( 'true' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:59:9: 'true'
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
	// $ANTLR end "T__51"

	// $ANTLR start "T__52"
	public final void mT__52() throws RecognitionException {
		try {
			int _type = T__52;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:60:7: ( 'us' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:60:9: 'us'
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
	// $ANTLR end "T__52"

	// $ANTLR start "T__53"
	public final void mT__53() throws RecognitionException {
		try {
			int _type = T__53;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:61:7: ( '{' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:61:9: '{'
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
	// $ANTLR end "T__53"

	// $ANTLR start "T__54"
	public final void mT__54() throws RecognitionException {
		try {
			int _type = T__54;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:62:7: ( '}' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:62:9: '}'
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
	// $ANTLR end "T__54"

	// $ANTLR start "T__55"
	public final void mT__55() throws RecognitionException {
		try {
			int _type = T__55;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:63:7: ( '~=' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:63:9: '~='
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
	// $ANTLR end "T__55"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:229:12: ( '/*' ( options {greedy=false; } : . )* '*/' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:230:5: '/*' ( options {greedy=false; } : . )* '*/'
			{
			match("/*"); 

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:230:10: ( options {greedy=false; } : . )*
			loop1:
			while (true) {
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
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:230:38: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
				}
			}

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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:232:14: ( '//' (~ NEWLINE )* )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:233:5: '//' (~ NEWLINE )*
			{
			match("//"); 

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:233:10: (~ NEWLINE )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
			}

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

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:235:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:236:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			{
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:236:5: ( ' ' | '\\t' | '\\n' | '\\r' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\t' && LA3_0 <= '\n')||LA3_0=='\r'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

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

	// $ANTLR start "QUERY_KEY"
	public final void mQUERY_KEY() throws RecognitionException {
		try {
			int _type = QUERY_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:238:11: ( '$' IDENT ( '.' ( IDENT | QUERY_KEY_VAR ) )* )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:5: '$' IDENT ( '.' ( IDENT | QUERY_KEY_VAR ) )*
			{
			match('$'); 
			mIDENT(); 

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:15: ( '.' ( IDENT | QUERY_KEY_VAR ) )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='.') ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:16: '.' ( IDENT | QUERY_KEY_VAR )
					{
					match('.'); 
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:20: ( IDENT | QUERY_KEY_VAR )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( ((LA4_0 >= 'A' && LA4_0 <= 'Z')||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
						alt4=1;
					}
					else if ( (LA4_0=='$') ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:21: IDENT
							{
							mIDENT(); 

							}
							break;
						case 2 :
							// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:239:29: QUERY_KEY_VAR
							{
							mQUERY_KEY_VAR(); 

							}
							break;

					}

					}
					break;

				default :
					break loop5;
				}
			}

			 setText(getText().substring(1)); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUERY_KEY"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:241:7: ( LETTER ( LETTER | '_' | DIGIT )* )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:242:5: LETTER ( LETTER | '_' | DIGIT )*
			{
			mLETTER(); 

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:242:12: ( LETTER | '_' | DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
					break loop6;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "NUMBER"
	public final void mNUMBER() throws RecognitionException {
		try {
			int _type = NUMBER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:244:8: ( ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )? )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:5: ( '-' )? ( DIGIT )+ ( '.' ( DIGIT )+ )?
			{
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:5: ( '-' )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='-') ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:5: '-'
					{
					match('-'); 
					}
					break;

			}

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:10: ( DIGIT )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:17: ( '.' ( DIGIT )+ )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='.') ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:18: '.' ( DIGIT )+
					{
					match('.'); 
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:245:22: ( DIGIT )+
					int cnt9=0;
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( ((LA9_0 >= '0' && LA9_0 <= '9')) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
							if ( cnt9 >= 1 ) break loop9;
							EarlyExitException eee = new EarlyExitException(9, input);
							throw eee;
						}
						cnt9++;
					}

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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:247:16: ( '\"' ( . )* '\"' | '\\'' ( . )* '\\'' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0=='\"') ) {
				alt13=1;
			}
			else if ( (LA13_0=='\'') ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:248:5: '\"' ( . )* '\"'
					{
					match('\"'); 
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:248:9: ( . )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0=='\"') ) {
							alt11=2;
						}
						else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= '\uFFFF')) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:248:9: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop11;
						}
					}

					match('\"'); 
					 setText(stripQuotes(getText())); 
					}
					break;
				case 2 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:249:7: '\\'' ( . )* '\\''
					{
					match('\''); 
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:249:12: ( . )*
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0=='\'') ) {
							alt12=2;
						}
						else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '\uFFFF')) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:249:12: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop12;
						}
					}

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

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:252:18: ( '\\n' | '\\r' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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

	// $ANTLR start "QUERY_KEY_VAR"
	public final void mQUERY_KEY_VAR() throws RecognitionException {
		try {
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:255:24: ( '${' IDENT ( '.' IDENT )* '}' )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:256:5: '${' IDENT ( '.' IDENT )* '}'
			{
			match("${"); 

			mIDENT(); 

			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:256:16: ( '.' IDENT )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0=='.') ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:256:17: '.' IDENT
					{
					match('.'); 
					mIDENT(); 

					}
					break;

				default :
					break loop14;
				}
			}

			match('}'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUERY_KEY_VAR"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:258:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:261:16: ( ( '0' .. '9' ) )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:264:18: ( ( DIGIT )+ )
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:265:5: ( DIGIT )+
			{
			// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:265:5: ( DIGIT )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:
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
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	@Override
	public void mTokens() throws RecognitionException {
		// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | ML_COMMENT | LINE_COMMENT | WS | QUERY_KEY | IDENT | NUMBER | STRING_LITERAL )
		int alt16=47;
		alt16 = dfa16.predict(input);
		switch (alt16) {
			case 1 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:40: T__21
				{
				mT__21(); 

				}
				break;
			case 7 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:46: T__22
				{
				mT__22(); 

				}
				break;
			case 8 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:52: T__23
				{
				mT__23(); 

				}
				break;
			case 9 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:58: T__24
				{
				mT__24(); 

				}
				break;
			case 10 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:64: T__25
				{
				mT__25(); 

				}
				break;
			case 11 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:70: T__26
				{
				mT__26(); 

				}
				break;
			case 12 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:76: T__27
				{
				mT__27(); 

				}
				break;
			case 13 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:82: T__28
				{
				mT__28(); 

				}
				break;
			case 14 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:88: T__29
				{
				mT__29(); 

				}
				break;
			case 15 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:94: T__30
				{
				mT__30(); 

				}
				break;
			case 16 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:100: T__31
				{
				mT__31(); 

				}
				break;
			case 17 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:106: T__32
				{
				mT__32(); 

				}
				break;
			case 18 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:112: T__33
				{
				mT__33(); 

				}
				break;
			case 19 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:118: T__34
				{
				mT__34(); 

				}
				break;
			case 20 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:124: T__35
				{
				mT__35(); 

				}
				break;
			case 21 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:130: T__36
				{
				mT__36(); 

				}
				break;
			case 22 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:136: T__37
				{
				mT__37(); 

				}
				break;
			case 23 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:142: T__38
				{
				mT__38(); 

				}
				break;
			case 24 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:148: T__39
				{
				mT__39(); 

				}
				break;
			case 25 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:154: T__40
				{
				mT__40(); 

				}
				break;
			case 26 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:160: T__41
				{
				mT__41(); 

				}
				break;
			case 27 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:166: T__42
				{
				mT__42(); 

				}
				break;
			case 28 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:172: T__43
				{
				mT__43(); 

				}
				break;
			case 29 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:178: T__44
				{
				mT__44(); 

				}
				break;
			case 30 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:184: T__45
				{
				mT__45(); 

				}
				break;
			case 31 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:190: T__46
				{
				mT__46(); 

				}
				break;
			case 32 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:196: T__47
				{
				mT__47(); 

				}
				break;
			case 33 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:202: T__48
				{
				mT__48(); 

				}
				break;
			case 34 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:208: T__49
				{
				mT__49(); 

				}
				break;
			case 35 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:214: T__50
				{
				mT__50(); 

				}
				break;
			case 36 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:220: T__51
				{
				mT__51(); 

				}
				break;
			case 37 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:226: T__52
				{
				mT__52(); 

				}
				break;
			case 38 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:232: T__53
				{
				mT__53(); 

				}
				break;
			case 39 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:238: T__54
				{
				mT__54(); 

				}
				break;
			case 40 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:244: T__55
				{
				mT__55(); 

				}
				break;
			case 41 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:250: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 42 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:261: LINE_COMMENT
				{
				mLINE_COMMENT(); 

				}
				break;
			case 43 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:274: WS
				{
				mWS(); 

				}
				break;
			case 44 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:277: QUERY_KEY
				{
				mQUERY_KEY(); 

				}
				break;
			case 45 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:287: IDENT
				{
				mIDENT(); 

				}
				break;
			case 46 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:293: NUMBER
				{
				mNUMBER(); 

				}
				break;
			case 47 :
				// net\\citizensnpcs\\adventures\\dialog\\Dialog.g:1:300: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;

		}
	}


	protected DFA16 dfa16 = new DFA16(this);
	static final String DFA16_eotS =
		"\1\uffff\1\45\3\uffff\1\47\2\uffff\1\51\1\54\2\uffff\1\56\1\uffff\1\60"+
		"\2\uffff\1\41\1\62\2\41\1\65\1\67\2\41\1\74\2\41\25\uffff\1\41\1\uffff"+
		"\2\41\1\uffff\1\103\1\uffff\1\104\3\41\1\uffff\2\41\1\113\3\41\2\uffff"+
		"\6\41\1\uffff\6\41\1\133\1\134\1\135\2\41\1\140\3\41\3\uffff\2\41\1\uffff"+
		"\4\41\2\uffff\2\41\1\154\1\155\1\156\3\uffff";
	static final String DFA16_eofS =
		"\157\uffff";
	static final String DFA16_minS =
		"\1\11\1\75\3\uffff\1\52\2\uffff\1\60\1\52\2\uffff\1\75\1\uffff\1\75\2"+
		"\uffff\1\162\1\60\1\166\1\141\2\60\1\163\1\141\1\60\1\150\1\163\25\uffff"+
		"\1\151\1\uffff\1\145\1\154\1\uffff\1\60\1\uffff\1\60\1\156\1\155\1\154"+
		"\1\uffff\1\145\1\165\1\60\1\164\1\156\1\163\2\uffff\1\144\1\145\1\160"+
		"\1\145\1\156\1\145\1\uffff\1\145\1\164\1\145\1\157\1\155\1\157\3\60\1"+
		"\162\1\163\1\60\1\155\1\142\1\156\3\uffff\1\151\1\75\1\uffff\1\40\1\145"+
		"\1\163\1\141\2\uffff\1\162\1\145\3\60\3\uffff";
	static final String DFA16_maxS =
		"\1\176\1\75\3\uffff\1\52\2\uffff\1\160\1\57\2\uffff\1\75\1\uffff\1\75"+
		"\2\uffff\1\162\1\172\1\166\1\141\2\172\1\163\1\165\1\172\1\162\1\163\25"+
		"\uffff\1\151\1\uffff\1\145\1\154\1\uffff\1\172\1\uffff\1\172\1\156\1\163"+
		"\1\154\1\uffff\1\145\1\165\1\172\1\164\1\156\1\163\2\uffff\1\144\1\145"+
		"\1\160\1\145\1\156\1\145\1\uffff\1\145\1\164\1\145\1\157\1\155\1\157\3"+
		"\172\1\162\1\163\1\172\1\155\1\142\1\156\3\uffff\1\151\1\75\1\uffff\1"+
		"\40\1\145\1\163\1\141\2\uffff\1\162\1\145\3\172\3\uffff";
	static final String DFA16_acceptS =
		"\2\uffff\1\3\1\4\1\5\1\uffff\1\10\1\11\2\uffff\1\15\1\16\1\uffff\1\21"+
		"\1\uffff\1\24\1\25\13\uffff\1\46\1\47\1\50\1\53\1\54\1\55\1\56\1\57\1"+
		"\2\1\1\1\7\1\6\1\13\1\12\1\51\1\52\1\14\1\20\1\17\1\23\1\22\1\uffff\1"+
		"\27\2\uffff\1\32\1\uffff\1\33\4\uffff\1\42\6\uffff\1\34\1\35\6\uffff\1"+
		"\45\17\uffff\1\41\1\43\1\44\2\uffff\1\31\4\uffff\1\30\1\36\5\uffff\1\26"+
		"\1\37\1\40";
	static final String DFA16_specialS =
		"\157\uffff}>";
	static final String[] DFA16_transitionS = {
			"\2\37\2\uffff\1\37\22\uffff\1\37\1\1\1\43\1\uffff\1\40\1\2\1\uffff\1"+
			"\43\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\12\42\1\12\1\13\1\14\1\15\1"+
			"\16\2\uffff\32\41\1\17\1\uffff\1\20\3\uffff\2\41\1\21\1\22\1\23\1\24"+
			"\1\41\1\25\4\41\1\26\1\27\3\41\1\30\1\31\1\32\1\33\5\41\1\34\1\uffff"+
			"\1\35\1\36",
			"\1\44",
			"",
			"",
			"",
			"\1\46",
			"",
			"",
			"\12\42\66\uffff\1\50",
			"\1\52\4\uffff\1\53",
			"",
			"",
			"\1\55",
			"",
			"\1\57",
			"",
			"",
			"\1\61",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\63",
			"\1\64",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\22\41\1\66\7\41",
			"\1\70",
			"\1\71\3\uffff\1\72\17\uffff\1\73",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\75\11\uffff\1\76",
			"\1\77",
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
			"",
			"",
			"",
			"\1\100",
			"",
			"\1\101",
			"\1\102",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\105",
			"\1\106\5\uffff\1\107",
			"\1\110",
			"",
			"\1\111",
			"\1\112",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\114",
			"\1\115",
			"\1\116",
			"",
			"",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\136",
			"\1\137",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\1\141",
			"\1\142",
			"\1\143",
			"",
			"",
			"",
			"\1\144",
			"\1\145",
			"",
			"\1\146",
			"\1\147",
			"\1\150",
			"\1\151",
			"",
			"",
			"\1\152",
			"\1\153",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"\12\41\7\uffff\32\41\4\uffff\1\41\1\uffff\32\41",
			"",
			"",
			""
	};

	static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
	static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
	static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
	static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
	static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
	static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
	static final short[][] DFA16_transition;

	static {
		int numStates = DFA16_transitionS.length;
		DFA16_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
		}
	}

	protected class DFA16 extends DFA {

		public DFA16(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 16;
			this.eot = DFA16_eot;
			this.eof = DFA16_eof;
			this.min = DFA16_min;
			this.max = DFA16_max;
			this.accept = DFA16_accept;
			this.special = DFA16_special;
			this.transition = DFA16_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | ML_COMMENT | LINE_COMMENT | WS | QUERY_KEY | IDENT | NUMBER | STRING_LITERAL );";
		}
	}

}
