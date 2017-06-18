package com.neon.rpc.gen.grpc.protobuf;// Generated from Protobuf3.g4 by ANTLR 4.7

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Protobuf3Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL=1, BYTES=2, DOUBLE=3, ENUM=4, FIXED32=5, FIXED64=6, FLOAT=7, IMPORT=8, 
		INT32=9, INT64=10, MAP=11, MESSAGE=12, ONEOF=13, OPTION=14, PACKAGE=15, 
		PROTO3_DOUBLE=16, PROTO3_SINGLE=17, PUBLIC=18, REPEATED=19, RESERVED=20, 
		RETURNS=21, RPC=22, SERVICE=23, SFIXED32=24, SFIXED64=25, SINT32=26, SINT64=27, 
		STREAM=28, STRING=29, SYNTAX=30, TO=31, UINT32=32, UINT64=33, WEAK=34, 
		Ident=35, IntLit=36, FloatLit=37, BoolLit=38, StrLit=39, Quote=40, LPAREN=41, 
		RPAREN=42, LBRACE=43, RBRACE=44, LBRACK=45, RBRACK=46, LCHEVR=47, RCHEVR=48, 
		SEMI=49, COMMA=50, DOT=51, MINUS=52, PLUS=53, ASSIGN=54, WS=55, COMMENT=56, 
		LINE_COMMENT=57;
	public static final int
		RULE_proto = 0, RULE_syntax = 1, RULE_importStatement = 2, RULE_packageStatement = 3, 
		RULE_option = 4, RULE_optionName = 5, RULE_topLevelDef = 6, RULE_message = 7, 
		RULE_messageBody = 8, RULE_enumDefinition = 9, RULE_enumBody = 10, RULE_enumField = 11, 
		RULE_enumValueOption = 12, RULE_service = 13, RULE_rpc = 14, RULE_reserved = 15, 
		RULE_ranges = 16, RULE_range = 17, RULE_fieldNames = 18, RULE_type = 19, 
		RULE_fieldNumber = 20, RULE_field = 21, RULE_fieldOptions = 22, RULE_fieldOption = 23, 
		RULE_oneof = 24, RULE_oneofField = 25, RULE_mapField = 26, RULE_keyType = 27, 
		RULE_fullIdent = 28, RULE_messageName = 29, RULE_enumName = 30, RULE_messageOrEnumName = 31, 
		RULE_fieldName = 32, RULE_oneofName = 33, RULE_mapName = 34, RULE_serviceName = 35, 
		RULE_rpcName = 36, RULE_messageType = 37, RULE_messageOrEnumType = 38, 
		RULE_emptyStatement = 39, RULE_constant = 40;
	public static final String[] ruleNames = {
		"proto", "syntax", "importStatement", "packageStatement", "option", "optionName", 
		"topLevelDef", "message", "messageBody", "enumDefinition", "enumBody", 
		"enumField", "enumValueOption", "service", "rpc", "reserved", "ranges", 
		"range", "fieldNames", "type", "fieldNumber", "field", "fieldOptions", 
		"fieldOption", "oneof", "oneofField", "mapField", "keyType", "fullIdent", 
		"messageName", "enumName", "messageOrEnumName", "fieldName", "oneofName", 
		"mapName", "serviceName", "rpcName", "messageType", "messageOrEnumType", 
		"emptyStatement", "constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'bool'", "'bytes'", "'double'", "'enum'", "'fixed32'", "'fixed64'", 
		"'float'", "'import'", "'int32'", "'int64'", "'map'", "'message'", "'oneof'", 
		"'option'", "'package'", "'\"proto3\"'", "''proto3''", "'public'", "'repeated'", 
		"'reserved'", "'returns'", "'rpc'", "'service'", "'sfixed32'", "'sfixed64'", 
		"'sint32'", "'sint64'", "'stream'", "'string'", "'syntax'", "'to'", "'uint32'", 
		"'uint64'", "'weak'", null, null, null, null, null, null, "'('", "')'", 
		"'{'", "'}'", "'['", "']'", "'<'", "'>'", "';'", "','", "'.'", "'-'", 
		"'+'", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOL", "BYTES", "DOUBLE", "ENUM", "FIXED32", "FIXED64", "FLOAT", 
		"IMPORT", "INT32", "INT64", "MAP", "MESSAGE", "ONEOF", "OPTION", "PACKAGE", 
		"PROTO3_DOUBLE", "PROTO3_SINGLE", "PUBLIC", "REPEATED", "RESERVED", "RETURNS", 
		"RPC", "SERVICE", "SFIXED32", "SFIXED64", "SINT32", "SINT64", "STREAM", 
		"STRING", "SYNTAX", "TO", "UINT32", "UINT64", "WEAK", "Ident", "IntLit", 
		"FloatLit", "BoolLit", "StrLit", "Quote", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "LBRACK", "RBRACK", "LCHEVR", "RCHEVR", "SEMI", "COMMA", "DOT", 
		"MINUS", "PLUS", "ASSIGN", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Protobuf3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Protobuf3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProtoContext extends ParserRuleContext {
		public SyntaxContext syntax() {
			return getRuleContext(SyntaxContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Protobuf3Parser.EOF, 0); }
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<PackageStatementContext> packageStatement() {
			return getRuleContexts(PackageStatementContext.class);
		}
		public PackageStatementContext packageStatement(int i) {
			return getRuleContext(PackageStatementContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<TopLevelDefContext> topLevelDef() {
			return getRuleContexts(TopLevelDefContext.class);
		}
		public TopLevelDefContext topLevelDef(int i) {
			return getRuleContext(TopLevelDefContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public ProtoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_proto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterProto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitProto(this);
		}
	}

	public final ProtoContext proto() throws RecognitionException {
		ProtoContext _localctx = new ProtoContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_proto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			syntax();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENUM) | (1L << IMPORT) | (1L << MESSAGE) | (1L << OPTION) | (1L << PACKAGE) | (1L << SERVICE) | (1L << SEMI))) != 0)) {
				{
				setState(88);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IMPORT:
					{
					setState(83);
					importStatement();
					}
					break;
				case PACKAGE:
					{
					setState(84);
					packageStatement();
					}
					break;
				case OPTION:
					{
					setState(85);
					option();
					}
					break;
				case ENUM:
				case MESSAGE:
				case SERVICE:
					{
					setState(86);
					topLevelDef();
					}
					break;
				case SEMI:
					{
					setState(87);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SyntaxContext extends ParserRuleContext {
		public SyntaxContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_syntax; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterSyntax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitSyntax(this);
		}
	}

	public final SyntaxContext syntax() throws RecognitionException {
		SyntaxContext _localctx = new SyntaxContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_syntax);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(SYNTAX);
			setState(96);
			match(ASSIGN);
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==PROTO3_DOUBLE || _la==PROTO3_SINGLE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(98);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode StrLit() { return getToken(Protobuf3Parser.StrLit, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IMPORT);
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLIC || _la==WEAK) {
				{
				setState(101);
				_la = _input.LA(1);
				if ( !(_la==PUBLIC || _la==WEAK) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(104);
			match(StrLit);
			setState(105);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PackageStatementContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public PackageStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterPackageStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitPackageStatement(this);
		}
	}

	public final PackageStatementContext packageStatement() throws RecognitionException {
		PackageStatementContext _localctx = new PackageStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_packageStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(PACKAGE);
			setState(108);
			fullIdent();
			setState(109);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public OptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOption(this);
		}
	}

	public final OptionContext option() throws RecognitionException {
		OptionContext _localctx = new OptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_option);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(OPTION);
			setState(112);
			optionName();
			setState(113);
			match(ASSIGN);
			setState(114);
			constant();
			setState(115);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OptionNameContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(Protobuf3Parser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(Protobuf3Parser.Ident, i);
		}
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public OptionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOptionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOptionName(this);
		}
	}

	public final OptionNameContext optionName() throws RecognitionException {
		OptionNameContext _localctx = new OptionNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_optionName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Ident:
				{
				setState(117);
				match(Ident);
				}
				break;
			case LPAREN:
				{
				setState(118);
				match(LPAREN);
				setState(119);
				fullIdent();
				setState(120);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(124);
				match(DOT);
				setState(125);
				match(Ident);
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TopLevelDefContext extends ParserRuleContext {
		public MessageContext message() {
			return getRuleContext(MessageContext.class,0);
		}
		public EnumDefinitionContext enumDefinition() {
			return getRuleContext(EnumDefinitionContext.class,0);
		}
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public TopLevelDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterTopLevelDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitTopLevelDef(this);
		}
	}

	public final TopLevelDefContext topLevelDef() throws RecognitionException {
		TopLevelDefContext _localctx = new TopLevelDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_topLevelDef);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MESSAGE:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				message();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				enumDefinition();
				}
				break;
			case SERVICE:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				service();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageContext extends ParserRuleContext {
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public MessageBodyContext messageBody() {
			return getRuleContext(MessageBodyContext.class,0);
		}
		public MessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_message; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessage(this);
		}
	}

	public final MessageContext message() throws RecognitionException {
		MessageContext _localctx = new MessageContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_message);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(MESSAGE);
			setState(137);
			messageName();
			setState(138);
			messageBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageBodyContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public List<EnumDefinitionContext> enumDefinition() {
			return getRuleContexts(EnumDefinitionContext.class);
		}
		public EnumDefinitionContext enumDefinition(int i) {
			return getRuleContext(EnumDefinitionContext.class,i);
		}
		public List<MessageContext> message() {
			return getRuleContexts(MessageContext.class);
		}
		public MessageContext message(int i) {
			return getRuleContext(MessageContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<OneofContext> oneof() {
			return getRuleContexts(OneofContext.class);
		}
		public OneofContext oneof(int i) {
			return getRuleContext(OneofContext.class,i);
		}
		public List<MapFieldContext> mapField() {
			return getRuleContexts(MapFieldContext.class);
		}
		public MapFieldContext mapField(int i) {
			return getRuleContext(MapFieldContext.class,i);
		}
		public List<ReservedContext> reserved() {
			return getRuleContexts(ReservedContext.class);
		}
		public ReservedContext reserved(int i) {
			return getRuleContext(ReservedContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public MessageBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageBody(this);
		}
	}

	public final MessageBodyContext messageBody() throws RecognitionException {
		MessageBodyContext _localctx = new MessageBodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_messageBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(LBRACE);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << BYTES) | (1L << DOUBLE) | (1L << ENUM) | (1L << FIXED32) | (1L << FIXED64) | (1L << FLOAT) | (1L << INT32) | (1L << INT64) | (1L << MAP) | (1L << MESSAGE) | (1L << ONEOF) | (1L << OPTION) | (1L << REPEATED) | (1L << RESERVED) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << SINT32) | (1L << SINT64) | (1L << STRING) | (1L << UINT32) | (1L << UINT64) | (1L << Ident) | (1L << SEMI) | (1L << DOT))) != 0)) {
				{
				setState(149);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case BYTES:
				case DOUBLE:
				case FIXED32:
				case FIXED64:
				case FLOAT:
				case INT32:
				case INT64:
				case REPEATED:
				case SFIXED32:
				case SFIXED64:
				case SINT32:
				case SINT64:
				case STRING:
				case UINT32:
				case UINT64:
				case Ident:
				case DOT:
					{
					setState(141);
					field();
					}
					break;
				case ENUM:
					{
					setState(142);
					enumDefinition();
					}
					break;
				case MESSAGE:
					{
					setState(143);
					message();
					}
					break;
				case OPTION:
					{
					setState(144);
					option();
					}
					break;
				case ONEOF:
					{
					setState(145);
					oneof();
					}
					break;
				case MAP:
					{
					setState(146);
					mapField();
					}
					break;
				case RESERVED:
					{
					setState(147);
					reserved();
					}
					break;
				case SEMI:
					{
					setState(148);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDefinitionContext extends ParserRuleContext {
		public EnumNameContext enumName() {
			return getRuleContext(EnumNameContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public EnumDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumDefinition(this);
		}
	}

	public final EnumDefinitionContext enumDefinition() throws RecognitionException {
		EnumDefinitionContext _localctx = new EnumDefinitionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ENUM);
			setState(157);
			enumName();
			setState(158);
			enumBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumBodyContext extends ParserRuleContext {
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<EnumFieldContext> enumField() {
			return getRuleContexts(EnumFieldContext.class);
		}
		public EnumFieldContext enumField(int i) {
			return getRuleContext(EnumFieldContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(LBRACE);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTION) | (1L << Ident) | (1L << SEMI))) != 0)) {
				{
				setState(164);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPTION:
					{
					setState(161);
					option();
					}
					break;
				case Ident:
					{
					setState(162);
					enumField();
					}
					break;
				case SEMI:
					{
					setState(163);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumFieldContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public TerminalNode IntLit() { return getToken(Protobuf3Parser.IntLit, 0); }
		public List<EnumValueOptionContext> enumValueOption() {
			return getRuleContexts(EnumValueOptionContext.class);
		}
		public EnumValueOptionContext enumValueOption(int i) {
			return getRuleContext(EnumValueOptionContext.class,i);
		}
		public EnumFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumField(this);
		}
	}

	public final EnumFieldContext enumField() throws RecognitionException {
		EnumFieldContext _localctx = new EnumFieldContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enumField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(Ident);
			setState(172);
			match(ASSIGN);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(173);
				match(MINUS);
				}
			}

			setState(176);
			match(IntLit);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(177);
				match(LBRACK);
				setState(178);
				enumValueOption();
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(179);
					match(COMMA);
					setState(180);
					enumValueOption();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(RBRACK);
				}
			}

			setState(190);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumValueOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public EnumValueOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValueOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumValueOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumValueOption(this);
		}
	}

	public final EnumValueOptionContext enumValueOption() throws RecognitionException {
		EnumValueOptionContext _localctx = new EnumValueOptionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_enumValueOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			optionName();
			setState(193);
			match(ASSIGN);
			setState(194);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceContext extends ParserRuleContext {
		public ServiceNameContext serviceName() {
			return getRuleContext(ServiceNameContext.class,0);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<RpcContext> rpc() {
			return getRuleContexts(RpcContext.class);
		}
		public RpcContext rpc(int i) {
			return getRuleContext(RpcContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitService(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(SERVICE);
			setState(197);
			serviceName();
			setState(198);
			match(LBRACE);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPTION) | (1L << RPC) | (1L << SEMI))) != 0)) {
				{
				setState(202);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPTION:
					{
					setState(199);
					option();
					}
					break;
				case RPC:
					{
					setState(200);
					rpc();
					}
					break;
				case SEMI:
					{
					setState(201);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(207);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpcContext extends ParserRuleContext {
		public RpcNameContext rpcName() {
			return getRuleContext(RpcNameContext.class,0);
		}
		public List<MessageTypeContext> messageType() {
			return getRuleContexts(MessageTypeContext.class);
		}
		public MessageTypeContext messageType(int i) {
			return getRuleContext(MessageTypeContext.class,i);
		}
		public List<OptionContext> option() {
			return getRuleContexts(OptionContext.class);
		}
		public OptionContext option(int i) {
			return getRuleContext(OptionContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public RpcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRpc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRpc(this);
		}
	}

	public final RpcContext rpc() throws RecognitionException {
		RpcContext _localctx = new RpcContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rpc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(RPC);
			setState(210);
			rpcName();
			setState(211);
			match(LPAREN);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STREAM) {
				{
				setState(212);
				match(STREAM);
				}
			}

			setState(215);
			messageType();
			setState(216);
			match(RPAREN);
			setState(217);
			match(RETURNS);
			setState(218);
			match(LPAREN);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STREAM) {
				{
				setState(219);
				match(STREAM);
				}
			}

			setState(222);
			messageType();
			setState(223);
			match(RPAREN);
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				{
				setState(224);
				match(LBRACE);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPTION || _la==SEMI) {
					{
					setState(227);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case OPTION:
						{
						setState(225);
						option();
						}
						break;
					case SEMI:
						{
						setState(226);
						emptyStatement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(RBRACE);
				}
				}
				break;
			case SEMI:
				{
				setState(233);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReservedContext extends ParserRuleContext {
		public RangesContext ranges() {
			return getRuleContext(RangesContext.class,0);
		}
		public FieldNamesContext fieldNames() {
			return getRuleContext(FieldNamesContext.class,0);
		}
		public ReservedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reserved; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterReserved(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitReserved(this);
		}
	}

	public final ReservedContext reserved() throws RecognitionException {
		ReservedContext _localctx = new ReservedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_reserved);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(RESERVED);
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntLit:
				{
				setState(237);
				ranges();
				}
				break;
			case StrLit:
				{
				setState(238);
				fieldNames();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(241);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangesContext extends ParserRuleContext {
		public List<RangeContext> range() {
			return getRuleContexts(RangeContext.class);
		}
		public RangeContext range(int i) {
			return getRuleContext(RangeContext.class,i);
		}
		public RangesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ranges; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRanges(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRanges(this);
		}
	}

	public final RangesContext ranges() throws RecognitionException {
		RangesContext _localctx = new RangesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ranges);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			range();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(244);
				match(COMMA);
				setState(245);
				range();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public List<TerminalNode> IntLit() { return getTokens(Protobuf3Parser.IntLit); }
		public TerminalNode IntLit(int i) {
			return getToken(Protobuf3Parser.IntLit, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_range);
		try {
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(IntLit);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(IntLit);
				setState(253);
				match(TO);
				setState(254);
				match(IntLit);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNamesContext extends ParserRuleContext {
		public List<TerminalNode> StrLit() { return getTokens(Protobuf3Parser.StrLit); }
		public TerminalNode StrLit(int i) {
			return getToken(Protobuf3Parser.StrLit, i);
		}
		public FieldNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldNames(this);
		}
	}

	public final FieldNamesContext fieldNames() throws RecognitionException {
		FieldNamesContext _localctx = new FieldNamesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(StrLit);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(258);
				match(COMMA);
				setState(259);
				match(StrLit);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public MessageOrEnumTypeContext messageOrEnumType() {
			return getRuleContext(MessageOrEnumTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case BYTES:
			case DOUBLE:
			case FIXED32:
			case FIXED64:
			case FLOAT:
			case INT32:
			case INT64:
			case SFIXED32:
			case SFIXED64:
			case SINT32:
			case SINT64:
			case STRING:
			case UINT32:
			case UINT64:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << BYTES) | (1L << DOUBLE) | (1L << FIXED32) | (1L << FIXED64) | (1L << FLOAT) | (1L << INT32) | (1L << INT64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << SINT32) | (1L << SINT64) | (1L << STRING) | (1L << UINT32) | (1L << UINT64))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case Ident:
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				messageOrEnumType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNumberContext extends ParserRuleContext {
		public TerminalNode IntLit() { return getToken(Protobuf3Parser.IntLit, 0); }
		public FieldNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldNumber(this);
		}
	}

	public final FieldNumberContext fieldNumber() throws RecognitionException {
		FieldNumberContext _localctx = new FieldNumberContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_fieldNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(IntLit);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEATED) {
				{
				setState(271);
				match(REPEATED);
				}
			}

			setState(274);
			type();
			setState(275);
			fieldName();
			setState(276);
			match(ASSIGN);
			setState(277);
			fieldNumber();
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(278);
				match(LBRACK);
				setState(279);
				fieldOptions();
				setState(280);
				match(RBRACK);
				}
			}

			setState(284);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldOptionsContext extends ParserRuleContext {
		public List<FieldOptionContext> fieldOption() {
			return getRuleContexts(FieldOptionContext.class);
		}
		public FieldOptionContext fieldOption(int i) {
			return getRuleContext(FieldOptionContext.class,i);
		}
		public FieldOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldOptions(this);
		}
	}

	public final FieldOptionsContext fieldOptions() throws RecognitionException {
		FieldOptionsContext _localctx = new FieldOptionsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_fieldOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			fieldOption();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(287);
				match(COMMA);
				setState(288);
				fieldOption();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldOptionContext extends ParserRuleContext {
		public OptionNameContext optionName() {
			return getRuleContext(OptionNameContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public FieldOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldOption(this);
		}
	}

	public final FieldOptionContext fieldOption() throws RecognitionException {
		FieldOptionContext _localctx = new FieldOptionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_fieldOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			optionName();
			setState(295);
			match(ASSIGN);
			setState(296);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneofContext extends ParserRuleContext {
		public OneofNameContext oneofName() {
			return getRuleContext(OneofNameContext.class,0);
		}
		public List<OneofFieldContext> oneofField() {
			return getRuleContexts(OneofFieldContext.class);
		}
		public OneofFieldContext oneofField(int i) {
			return getRuleContext(OneofFieldContext.class,i);
		}
		public List<EmptyStatementContext> emptyStatement() {
			return getRuleContexts(EmptyStatementContext.class);
		}
		public EmptyStatementContext emptyStatement(int i) {
			return getRuleContext(EmptyStatementContext.class,i);
		}
		public OneofContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneof; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneof(this);
		}
	}

	public final OneofContext oneof() throws RecognitionException {
		OneofContext _localctx = new OneofContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_oneof);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(ONEOF);
			setState(299);
			oneofName();
			setState(300);
			match(LBRACE);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << BYTES) | (1L << DOUBLE) | (1L << FIXED32) | (1L << FIXED64) | (1L << FLOAT) | (1L << INT32) | (1L << INT64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << SINT32) | (1L << SINT64) | (1L << STRING) | (1L << UINT32) | (1L << UINT64) | (1L << Ident) | (1L << SEMI) | (1L << DOT))) != 0)) {
				{
				setState(303);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BOOL:
				case BYTES:
				case DOUBLE:
				case FIXED32:
				case FIXED64:
				case FLOAT:
				case INT32:
				case INT64:
				case SFIXED32:
				case SFIXED64:
				case SINT32:
				case SINT64:
				case STRING:
				case UINT32:
				case UINT64:
				case Ident:
				case DOT:
					{
					setState(301);
					oneofField();
					}
					break;
				case SEMI:
					{
					setState(302);
					emptyStatement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneofFieldContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public OneofFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneofField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneofField(this);
		}
	}

	public final OneofFieldContext oneofField() throws RecognitionException {
		OneofFieldContext _localctx = new OneofFieldContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_oneofField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			type();
			setState(311);
			fieldName();
			setState(312);
			match(ASSIGN);
			setState(313);
			fieldNumber();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(314);
				match(LBRACK);
				setState(315);
				fieldOptions();
				setState(316);
				match(RBRACK);
				}
			}

			setState(320);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapFieldContext extends ParserRuleContext {
		public KeyTypeContext keyType() {
			return getRuleContext(KeyTypeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MapNameContext mapName() {
			return getRuleContext(MapNameContext.class,0);
		}
		public FieldNumberContext fieldNumber() {
			return getRuleContext(FieldNumberContext.class,0);
		}
		public FieldOptionsContext fieldOptions() {
			return getRuleContext(FieldOptionsContext.class,0);
		}
		public MapFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMapField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMapField(this);
		}
	}

	public final MapFieldContext mapField() throws RecognitionException {
		MapFieldContext _localctx = new MapFieldContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mapField);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(MAP);
			setState(323);
			match(LCHEVR);
			setState(324);
			keyType();
			setState(325);
			match(COMMA);
			setState(326);
			type();
			setState(327);
			match(RCHEVR);
			setState(328);
			mapName();
			setState(329);
			match(ASSIGN);
			setState(330);
			fieldNumber();
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(331);
				match(LBRACK);
				setState(332);
				fieldOptions();
				setState(333);
				match(RBRACK);
				}
			}

			setState(337);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyTypeContext extends ParserRuleContext {
		public KeyTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterKeyType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitKeyType(this);
		}
	}

	public final KeyTypeContext keyType() throws RecognitionException {
		KeyTypeContext _localctx = new KeyTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_keyType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << FIXED32) | (1L << FIXED64) | (1L << INT32) | (1L << INT64) | (1L << SFIXED32) | (1L << SFIXED64) | (1L << SINT32) | (1L << SINT64) | (1L << STRING) | (1L << UINT32) | (1L << UINT64))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FullIdentContext extends ParserRuleContext {
		public List<TerminalNode> Ident() { return getTokens(Protobuf3Parser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(Protobuf3Parser.Ident, i);
		}
		public FullIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fullIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFullIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFullIdent(this);
		}
	}

	public final FullIdentContext fullIdent() throws RecognitionException {
		FullIdentContext _localctx = new FullIdentContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_fullIdent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(Ident);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(342);
				match(DOT);
				setState(343);
				match(Ident);
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public MessageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageName(this);
		}
	}

	public final MessageNameContext messageName() throws RecognitionException {
		MessageNameContext _localctx = new MessageNameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_messageName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public EnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEnumName(this);
		}
	}

	public final EnumNameContext enumName() throws RecognitionException {
		EnumNameContext _localctx = new EnumNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_enumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageOrEnumNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public MessageOrEnumNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageOrEnumName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageOrEnumName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageOrEnumName(this);
		}
	}

	public final MessageOrEnumNameContext messageOrEnumName() throws RecognitionException {
		MessageOrEnumNameContext _localctx = new MessageOrEnumNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_messageOrEnumName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OneofNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public OneofNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oneofName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterOneofName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitOneofName(this);
		}
	}

	public final OneofNameContext oneofName() throws RecognitionException {
		OneofNameContext _localctx = new OneofNameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_oneofName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public MapNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMapName(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mapName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public ServiceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterServiceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitServiceName(this);
		}
	}

	public final ServiceNameContext serviceName() throws RecognitionException {
		ServiceNameContext _localctx = new ServiceNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_serviceName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpcNameContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(Protobuf3Parser.Ident, 0); }
		public RpcNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterRpcName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitRpcName(this);
		}
	}

	public final RpcNameContext rpcName() throws RecognitionException {
		RpcNameContext _localctx = new RpcNameContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_rpcName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(Ident);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageTypeContext extends ParserRuleContext {
		public MessageNameContext messageName() {
			return getRuleContext(MessageNameContext.class,0);
		}
		public List<TerminalNode> Ident() { return getTokens(Protobuf3Parser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(Protobuf3Parser.Ident, i);
		}
		public MessageTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageType(this);
		}
	}

	public final MessageTypeContext messageType() throws RecognitionException {
		MessageTypeContext _localctx = new MessageTypeContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_messageType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(365);
				match(DOT);
				}
			}

			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(368);
					match(Ident);
					setState(369);
					match(DOT);
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(375);
			messageName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MessageOrEnumTypeContext extends ParserRuleContext {
		public MessageOrEnumNameContext messageOrEnumName() {
			return getRuleContext(MessageOrEnumNameContext.class,0);
		}
		public List<TerminalNode> Ident() { return getTokens(Protobuf3Parser.Ident); }
		public TerminalNode Ident(int i) {
			return getToken(Protobuf3Parser.Ident, i);
		}
		public MessageOrEnumTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageOrEnumType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterMessageOrEnumType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitMessageOrEnumType(this);
		}
	}

	public final MessageOrEnumTypeContext messageOrEnumType() throws RecognitionException {
		MessageOrEnumTypeContext _localctx = new MessageOrEnumTypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_messageOrEnumType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(377);
				match(DOT);
				}
			}

			setState(384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(380);
					match(Ident);
					setState(381);
					match(DOT);
					}
					} 
				}
				setState(386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(387);
			messageOrEnumName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitEmptyStatement(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public FullIdentContext fullIdent() {
			return getRuleContext(FullIdentContext.class,0);
		}
		public TerminalNode IntLit() { return getToken(Protobuf3Parser.IntLit, 0); }
		public TerminalNode FloatLit() { return getToken(Protobuf3Parser.FloatLit, 0); }
		public TerminalNode StrLit() { return getToken(Protobuf3Parser.StrLit, 0); }
		public TerminalNode BoolLit() { return getToken(Protobuf3Parser.BoolLit, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Protobuf3Listener ) ((Protobuf3Listener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_constant);
		int _la;
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				fullIdent();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(392);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(395);
				match(IntLit);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS || _la==PLUS) {
					{
					setState(396);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(399);
				match(FloatLit);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(400);
				_la = _input.LA(1);
				if ( !(_la==BoolLit || _la==StrLit) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u0196\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\7\2[\n\2\f\2\16\2^\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\4\3\4\5\4i\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\5\7}\n\7\3\7\3\7\7\7\u0081\n\7\f\7\16\7\u0084\13\7"+
		"\3\b\3\b\3\b\5\b\u0089\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b\13\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\7\f\u00a7\n\f\f\f\16\f\u00aa\13\f\3\f\3\f\3\r\3\r\3\r"+
		"\5\r\u00b1\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00b8\n\r\f\r\16\r\u00bb\13\r\3"+
		"\r\3\r\5\r\u00bf\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\7\17\u00cd\n\17\f\17\16\17\u00d0\13\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\5\20\u00d8\n\20\3\20\3\20\3\20\3\20\3\20\5\20\u00df\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\7\20\u00e6\n\20\f\20\16\20\u00e9\13\20\3\20\3\20"+
		"\5\20\u00ed\n\20\3\21\3\21\3\21\5\21\u00f2\n\21\3\21\3\21\3\22\3\22\3"+
		"\22\7\22\u00f9\n\22\f\22\16\22\u00fc\13\22\3\23\3\23\3\23\3\23\5\23\u0102"+
		"\n\23\3\24\3\24\3\24\7\24\u0107\n\24\f\24\16\24\u010a\13\24\3\25\3\25"+
		"\5\25\u010e\n\25\3\26\3\26\3\27\5\27\u0113\n\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\5\27\u011d\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u0124"+
		"\n\30\f\30\16\30\u0127\13\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\32\7\32\u0132\n\32\f\32\16\32\u0135\13\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\5\33\u0141\n\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0152\n\34\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\36\7\36\u015b\n\36\f\36\16\36\u015e\13\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\5\'\u0171\n\'\3"+
		"\'\3\'\7\'\u0175\n\'\f\'\16\'\u0178\13\'\3\'\3\'\3(\5(\u017d\n(\3(\3("+
		"\7(\u0181\n(\f(\16(\u0184\13(\3(\3(\3)\3)\3*\3*\5*\u018c\n*\3*\3*\5*\u0190"+
		"\n*\3*\3*\5*\u0194\n*\3*\2\2+\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 "+
		"\"$&(*,.\60\62\64\668:<>@BDFHJLNPR\2\b\3\2\22\23\4\2\24\24$$\b\2\3\5\7"+
		"\t\13\f\32\35\37\37\"#\b\2\3\3\7\b\13\f\32\35\37\37\"#\3\2\66\67\3\2("+
		")\2\u01a2\2T\3\2\2\2\4a\3\2\2\2\6f\3\2\2\2\bm\3\2\2\2\nq\3\2\2\2\f|\3"+
		"\2\2\2\16\u0088\3\2\2\2\20\u008a\3\2\2\2\22\u008e\3\2\2\2\24\u009e\3\2"+
		"\2\2\26\u00a2\3\2\2\2\30\u00ad\3\2\2\2\32\u00c2\3\2\2\2\34\u00c6\3\2\2"+
		"\2\36\u00d3\3\2\2\2 \u00ee\3\2\2\2\"\u00f5\3\2\2\2$\u0101\3\2\2\2&\u0103"+
		"\3\2\2\2(\u010d\3\2\2\2*\u010f\3\2\2\2,\u0112\3\2\2\2.\u0120\3\2\2\2\60"+
		"\u0128\3\2\2\2\62\u012c\3\2\2\2\64\u0138\3\2\2\2\66\u0144\3\2\2\28\u0155"+
		"\3\2\2\2:\u0157\3\2\2\2<\u015f\3\2\2\2>\u0161\3\2\2\2@\u0163\3\2\2\2B"+
		"\u0165\3\2\2\2D\u0167\3\2\2\2F\u0169\3\2\2\2H\u016b\3\2\2\2J\u016d\3\2"+
		"\2\2L\u0170\3\2\2\2N\u017c\3\2\2\2P\u0187\3\2\2\2R\u0193\3\2\2\2T\\\5"+
		"\4\3\2U[\5\6\4\2V[\5\b\5\2W[\5\n\6\2X[\5\16\b\2Y[\5P)\2ZU\3\2\2\2ZV\3"+
		"\2\2\2ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]"+
		"_\3\2\2\2^\\\3\2\2\2_`\7\2\2\3`\3\3\2\2\2ab\7 \2\2bc\78\2\2cd\t\2\2\2"+
		"de\7\63\2\2e\5\3\2\2\2fh\7\n\2\2gi\t\3\2\2hg\3\2\2\2hi\3\2\2\2ij\3\2\2"+
		"\2jk\7)\2\2kl\7\63\2\2l\7\3\2\2\2mn\7\21\2\2no\5:\36\2op\7\63\2\2p\t\3"+
		"\2\2\2qr\7\20\2\2rs\5\f\7\2st\78\2\2tu\5R*\2uv\7\63\2\2v\13\3\2\2\2w}"+
		"\7%\2\2xy\7+\2\2yz\5:\36\2z{\7,\2\2{}\3\2\2\2|w\3\2\2\2|x\3\2\2\2}\u0082"+
		"\3\2\2\2~\177\7\65\2\2\177\u0081\7%\2\2\u0080~\3\2\2\2\u0081\u0084\3\2"+
		"\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\r\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0085\u0089\5\20\t\2\u0086\u0089\5\24\13\2\u0087\u0089\5\34\17"+
		"\2\u0088\u0085\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\17"+
		"\3\2\2\2\u008a\u008b\7\16\2\2\u008b\u008c\5<\37\2\u008c\u008d\5\22\n\2"+
		"\u008d\21\3\2\2\2\u008e\u0099\7-\2\2\u008f\u0098\5,\27\2\u0090\u0098\5"+
		"\24\13\2\u0091\u0098\5\20\t\2\u0092\u0098\5\n\6\2\u0093\u0098\5\62\32"+
		"\2\u0094\u0098\5\66\34\2\u0095\u0098\5 \21\2\u0096\u0098\5P)\2\u0097\u008f"+
		"\3\2\2\2\u0097\u0090\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0092\3\2\2\2\u0097"+
		"\u0093\3\2\2\2\u0097\u0094\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0096\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7.\2\2\u009d\23\3\2\2\2"+
		"\u009e\u009f\7\6\2\2\u009f\u00a0\5> \2\u00a0\u00a1\5\26\f\2\u00a1\25\3"+
		"\2\2\2\u00a2\u00a8\7-\2\2\u00a3\u00a7\5\n\6\2\u00a4\u00a7\5\30\r\2\u00a5"+
		"\u00a7\5P)\2\u00a6\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2"+
		"\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab"+
		"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac\27\3\2\2\2\u00ad"+
		"\u00ae\7%\2\2\u00ae\u00b0\78\2\2\u00af\u00b1\7\66\2\2\u00b0\u00af\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00be\7&\2\2\u00b3"+
		"\u00b4\7/\2\2\u00b4\u00b9\5\32\16\2\u00b5\u00b6\7\64\2\2\u00b6\u00b8\5"+
		"\32\16\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\60"+
		"\2\2\u00bd\u00bf\3\2\2\2\u00be\u00b3\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00c1\7\63\2\2\u00c1\31\3\2\2\2\u00c2\u00c3\5\f\7"+
		"\2\u00c3\u00c4\78\2\2\u00c4\u00c5\5R*\2\u00c5\33\3\2\2\2\u00c6\u00c7\7"+
		"\31\2\2\u00c7\u00c8\5H%\2\u00c8\u00ce\7-\2\2\u00c9\u00cd\5\n\6\2\u00ca"+
		"\u00cd\5\36\20\2\u00cb\u00cd\5P)\2\u00cc\u00c9\3\2\2\2\u00cc\u00ca\3\2"+
		"\2\2\u00cc\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7."+
		"\2\2\u00d2\35\3\2\2\2\u00d3\u00d4\7\30\2\2\u00d4\u00d5\5J&\2\u00d5\u00d7"+
		"\7+\2\2\u00d6\u00d8\7\36\2\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00da\5L\'\2\u00da\u00db\7,\2\2\u00db\u00dc\7\27"+
		"\2\2\u00dc\u00de\7+\2\2\u00dd\u00df\7\36\2\2\u00de\u00dd\3\2\2\2\u00de"+
		"\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\5L\'\2\u00e1\u00ec\7,\2"+
		"\2\u00e2\u00e7\7-\2\2\u00e3\u00e6\5\n\6\2\u00e4\u00e6\5P)\2\u00e5\u00e3"+
		"\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\u00ed\7."+
		"\2\2\u00eb\u00ed\7\63\2\2\u00ec\u00e2\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\37\3\2\2\2\u00ee\u00f1\7\26\2\2\u00ef\u00f2\5\"\22\2\u00f0\u00f2\5&\24"+
		"\2\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\7\63\2\2\u00f4!\3\2\2\2\u00f5\u00fa\5$\23\2\u00f6\u00f7\7\64\2\2\u00f7"+
		"\u00f9\5$\23\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb#\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0102"+
		"\7&\2\2\u00fe\u00ff\7&\2\2\u00ff\u0100\7!\2\2\u0100\u0102\7&\2\2\u0101"+
		"\u00fd\3\2\2\2\u0101\u00fe\3\2\2\2\u0102%\3\2\2\2\u0103\u0108\7)\2\2\u0104"+
		"\u0105\7\64\2\2\u0105\u0107\7)\2\2\u0106\u0104\3\2\2\2\u0107\u010a\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\'\3\2\2\2\u010a\u0108"+
		"\3\2\2\2\u010b\u010e\t\4\2\2\u010c\u010e\5N(\2\u010d\u010b\3\2\2\2\u010d"+
		"\u010c\3\2\2\2\u010e)\3\2\2\2\u010f\u0110\7&\2\2\u0110+\3\2\2\2\u0111"+
		"\u0113\7\25\2\2\u0112\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\3"+
		"\2\2\2\u0114\u0115\5(\25\2\u0115\u0116\5B\"\2\u0116\u0117\78\2\2\u0117"+
		"\u011c\5*\26\2\u0118\u0119\7/\2\2\u0119\u011a\5.\30\2\u011a\u011b\7\60"+
		"\2\2\u011b\u011d\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u011d\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\7\63\2\2\u011f-\3\2\2\2\u0120\u0125\5\60\31"+
		"\2\u0121\u0122\7\64\2\2\u0122\u0124\5\60\31\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126/\3\2\2\2"+
		"\u0127\u0125\3\2\2\2\u0128\u0129\5\f\7\2\u0129\u012a\78\2\2\u012a\u012b"+
		"\5R*\2\u012b\61\3\2\2\2\u012c\u012d\7\17\2\2\u012d\u012e\5D#\2\u012e\u0133"+
		"\7-\2\2\u012f\u0132\5\64\33\2\u0130\u0132\5P)\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2"+
		"\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7.\2\2\u0137"+
		"\63\3\2\2\2\u0138\u0139\5(\25\2\u0139\u013a\5B\"\2\u013a\u013b\78\2\2"+
		"\u013b\u0140\5*\26\2\u013c\u013d\7/\2\2\u013d\u013e\5.\30\2\u013e\u013f"+
		"\7\60\2\2\u013f\u0141\3\2\2\2\u0140\u013c\3\2\2\2\u0140\u0141\3\2\2\2"+
		"\u0141\u0142\3\2\2\2\u0142\u0143\7\63\2\2\u0143\65\3\2\2\2\u0144\u0145"+
		"\7\r\2\2\u0145\u0146\7\61\2\2\u0146\u0147\58\35\2\u0147\u0148\7\64\2\2"+
		"\u0148\u0149\5(\25\2\u0149\u014a\7\62\2\2\u014a\u014b\5F$\2\u014b\u014c"+
		"\78\2\2\u014c\u0151\5*\26\2\u014d\u014e\7/\2\2\u014e\u014f\5.\30\2\u014f"+
		"\u0150\7\60\2\2\u0150\u0152\3\2\2\2\u0151\u014d\3\2\2\2\u0151\u0152\3"+
		"\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\7\63\2\2\u0154\67\3\2\2\2\u0155"+
		"\u0156\t\5\2\2\u01569\3\2\2\2\u0157\u015c\7%\2\2\u0158\u0159\7\65\2\2"+
		"\u0159\u015b\7%\2\2\u015a\u0158\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a"+
		"\3\2\2\2\u015c\u015d\3\2\2\2\u015d;\3\2\2\2\u015e\u015c\3\2\2\2\u015f"+
		"\u0160\7%\2\2\u0160=\3\2\2\2\u0161\u0162\7%\2\2\u0162?\3\2\2\2\u0163\u0164"+
		"\7%\2\2\u0164A\3\2\2\2\u0165\u0166\7%\2\2\u0166C\3\2\2\2\u0167\u0168\7"+
		"%\2\2\u0168E\3\2\2\2\u0169\u016a\7%\2\2\u016aG\3\2\2\2\u016b\u016c\7%"+
		"\2\2\u016cI\3\2\2\2\u016d\u016e\7%\2\2\u016eK\3\2\2\2\u016f\u0171\7\65"+
		"\2\2\u0170\u016f\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0176\3\2\2\2\u0172"+
		"\u0173\7%\2\2\u0173\u0175\7\65\2\2\u0174\u0172\3\2\2\2\u0175\u0178\3\2"+
		"\2\2\u0176\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0179\3\2\2\2\u0178"+
		"\u0176\3\2\2\2\u0179\u017a\5<\37\2\u017aM\3\2\2\2\u017b\u017d\7\65\2\2"+
		"\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u0182\3\2\2\2\u017e\u017f"+
		"\7%\2\2\u017f\u0181\7\65\2\2\u0180\u017e\3\2\2\2\u0181\u0184\3\2\2\2\u0182"+
		"\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184\u0182\3\2"+
		"\2\2\u0185\u0186\5@!\2\u0186O\3\2\2\2\u0187\u0188\7\63\2\2\u0188Q\3\2"+
		"\2\2\u0189\u0194\5:\36\2\u018a\u018c\t\6\2\2\u018b\u018a\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0194\7&\2\2\u018e\u0190\t\6"+
		"\2\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u0194\7\'\2\2\u0192\u0194\t\7\2\2\u0193\u0189\3\2\2\2\u0193\u018b\3\2"+
		"\2\2\u0193\u018f\3\2\2\2\u0193\u0192\3\2\2\2\u0194S\3\2\2\2*Z\\h|\u0082"+
		"\u0088\u0097\u0099\u00a6\u00a8\u00b0\u00b9\u00be\u00cc\u00ce\u00d7\u00de"+
		"\u00e5\u00e7\u00ec\u00f1\u00fa\u0101\u0108\u010d\u0112\u011c\u0125\u0131"+
		"\u0133\u0140\u0151\u015c\u0170\u0176\u017c\u0182\u018b\u018f\u0193";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}