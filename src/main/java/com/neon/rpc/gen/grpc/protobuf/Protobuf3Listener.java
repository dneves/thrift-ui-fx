package com.neon.rpc.gen.grpc.protobuf;// Generated from Protobuf3.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Protobuf3Parser}.
 */
public interface Protobuf3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#proto}.
	 * @param ctx the parse tree
	 */
	void enterProto(Protobuf3Parser.ProtoContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#proto}.
	 * @param ctx the parse tree
	 */
	void exitProto(Protobuf3Parser.ProtoContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#syntax}.
	 * @param ctx the parse tree
	 */
	void enterSyntax(Protobuf3Parser.SyntaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#syntax}.
	 * @param ctx the parse tree
	 */
	void exitSyntax(Protobuf3Parser.SyntaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(Protobuf3Parser.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(Protobuf3Parser.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void enterPackageStatement(Protobuf3Parser.PackageStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#packageStatement}.
	 * @param ctx the parse tree
	 */
	void exitPackageStatement(Protobuf3Parser.PackageStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#option}.
	 * @param ctx the parse tree
	 */
	void enterOption(Protobuf3Parser.OptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#option}.
	 * @param ctx the parse tree
	 */
	void exitOption(Protobuf3Parser.OptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#optionName}.
	 * @param ctx the parse tree
	 */
	void enterOptionName(Protobuf3Parser.OptionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#optionName}.
	 * @param ctx the parse tree
	 */
	void exitOptionName(Protobuf3Parser.OptionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDef(Protobuf3Parser.TopLevelDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#topLevelDef}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDef(Protobuf3Parser.TopLevelDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#message}.
	 * @param ctx the parse tree
	 */
	void enterMessage(Protobuf3Parser.MessageContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#message}.
	 * @param ctx the parse tree
	 */
	void exitMessage(Protobuf3Parser.MessageContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#messageBody}.
	 * @param ctx the parse tree
	 */
	void enterMessageBody(Protobuf3Parser.MessageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#messageBody}.
	 * @param ctx the parse tree
	 */
	void exitMessageBody(Protobuf3Parser.MessageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#enumDefinition}.
	 * @param ctx the parse tree
	 */
	void enterEnumDefinition(Protobuf3Parser.EnumDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#enumDefinition}.
	 * @param ctx the parse tree
	 */
	void exitEnumDefinition(Protobuf3Parser.EnumDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(Protobuf3Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(Protobuf3Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#enumField}.
	 * @param ctx the parse tree
	 */
	void enterEnumField(Protobuf3Parser.EnumFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#enumField}.
	 * @param ctx the parse tree
	 */
	void exitEnumField(Protobuf3Parser.EnumFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#enumValueOption}.
	 * @param ctx the parse tree
	 */
	void enterEnumValueOption(Protobuf3Parser.EnumValueOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#enumValueOption}.
	 * @param ctx the parse tree
	 */
	void exitEnumValueOption(Protobuf3Parser.EnumValueOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#service}.
	 * @param ctx the parse tree
	 */
	void enterService(Protobuf3Parser.ServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#service}.
	 * @param ctx the parse tree
	 */
	void exitService(Protobuf3Parser.ServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#rpc}.
	 * @param ctx the parse tree
	 */
	void enterRpc(Protobuf3Parser.RpcContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#rpc}.
	 * @param ctx the parse tree
	 */
	void exitRpc(Protobuf3Parser.RpcContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#reserved}.
	 * @param ctx the parse tree
	 */
	void enterReserved(Protobuf3Parser.ReservedContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#reserved}.
	 * @param ctx the parse tree
	 */
	void exitReserved(Protobuf3Parser.ReservedContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#ranges}.
	 * @param ctx the parse tree
	 */
	void enterRanges(Protobuf3Parser.RangesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#ranges}.
	 * @param ctx the parse tree
	 */
	void exitRanges(Protobuf3Parser.RangesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#range}.
	 * @param ctx the parse tree
	 */
	void enterRange(Protobuf3Parser.RangeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#range}.
	 * @param ctx the parse tree
	 */
	void exitRange(Protobuf3Parser.RangeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void enterFieldNames(Protobuf3Parser.FieldNamesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fieldNames}.
	 * @param ctx the parse tree
	 */
	void exitFieldNames(Protobuf3Parser.FieldNamesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Protobuf3Parser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Protobuf3Parser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void enterFieldNumber(Protobuf3Parser.FieldNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fieldNumber}.
	 * @param ctx the parse tree
	 */
	void exitFieldNumber(Protobuf3Parser.FieldNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(Protobuf3Parser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(Protobuf3Parser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void enterFieldOptions(Protobuf3Parser.FieldOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fieldOptions}.
	 * @param ctx the parse tree
	 */
	void exitFieldOptions(Protobuf3Parser.FieldOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void enterFieldOption(Protobuf3Parser.FieldOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fieldOption}.
	 * @param ctx the parse tree
	 */
	void exitFieldOption(Protobuf3Parser.FieldOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#oneof}.
	 * @param ctx the parse tree
	 */
	void enterOneof(Protobuf3Parser.OneofContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#oneof}.
	 * @param ctx the parse tree
	 */
	void exitOneof(Protobuf3Parser.OneofContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#oneofField}.
	 * @param ctx the parse tree
	 */
	void enterOneofField(Protobuf3Parser.OneofFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#oneofField}.
	 * @param ctx the parse tree
	 */
	void exitOneofField(Protobuf3Parser.OneofFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#mapField}.
	 * @param ctx the parse tree
	 */
	void enterMapField(Protobuf3Parser.MapFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#mapField}.
	 * @param ctx the parse tree
	 */
	void exitMapField(Protobuf3Parser.MapFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#keyType}.
	 * @param ctx the parse tree
	 */
	void enterKeyType(Protobuf3Parser.KeyTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#keyType}.
	 * @param ctx the parse tree
	 */
	void exitKeyType(Protobuf3Parser.KeyTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void enterFullIdent(Protobuf3Parser.FullIdentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fullIdent}.
	 * @param ctx the parse tree
	 */
	void exitFullIdent(Protobuf3Parser.FullIdentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#messageName}.
	 * @param ctx the parse tree
	 */
	void enterMessageName(Protobuf3Parser.MessageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#messageName}.
	 * @param ctx the parse tree
	 */
	void exitMessageName(Protobuf3Parser.MessageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#enumName}.
	 * @param ctx the parse tree
	 */
	void enterEnumName(Protobuf3Parser.EnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#enumName}.
	 * @param ctx the parse tree
	 */
	void exitEnumName(Protobuf3Parser.EnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#messageOrEnumName}.
	 * @param ctx the parse tree
	 */
	void enterMessageOrEnumName(Protobuf3Parser.MessageOrEnumNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#messageOrEnumName}.
	 * @param ctx the parse tree
	 */
	void exitMessageOrEnumName(Protobuf3Parser.MessageOrEnumNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void enterFieldName(Protobuf3Parser.FieldNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#fieldName}.
	 * @param ctx the parse tree
	 */
	void exitFieldName(Protobuf3Parser.FieldNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#oneofName}.
	 * @param ctx the parse tree
	 */
	void enterOneofName(Protobuf3Parser.OneofNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#oneofName}.
	 * @param ctx the parse tree
	 */
	void exitOneofName(Protobuf3Parser.OneofNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#mapName}.
	 * @param ctx the parse tree
	 */
	void enterMapName(Protobuf3Parser.MapNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#mapName}.
	 * @param ctx the parse tree
	 */
	void exitMapName(Protobuf3Parser.MapNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#serviceName}.
	 * @param ctx the parse tree
	 */
	void enterServiceName(Protobuf3Parser.ServiceNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#serviceName}.
	 * @param ctx the parse tree
	 */
	void exitServiceName(Protobuf3Parser.ServiceNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#rpcName}.
	 * @param ctx the parse tree
	 */
	void enterRpcName(Protobuf3Parser.RpcNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#rpcName}.
	 * @param ctx the parse tree
	 */
	void exitRpcName(Protobuf3Parser.RpcNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#messageType}.
	 * @param ctx the parse tree
	 */
	void enterMessageType(Protobuf3Parser.MessageTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#messageType}.
	 * @param ctx the parse tree
	 */
	void exitMessageType(Protobuf3Parser.MessageTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#messageOrEnumType}.
	 * @param ctx the parse tree
	 */
	void enterMessageOrEnumType(Protobuf3Parser.MessageOrEnumTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#messageOrEnumType}.
	 * @param ctx the parse tree
	 */
	void exitMessageOrEnumType(Protobuf3Parser.MessageOrEnumTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(Protobuf3Parser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(Protobuf3Parser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Protobuf3Parser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(Protobuf3Parser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Protobuf3Parser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(Protobuf3Parser.ConstantContext ctx);
}