package com.neon.rpc.gen.grpc;

import com.neon.rpc.gen.grpc.model.Field;
import com.neon.rpc.gen.grpc.model.Message;
import com.neon.rpc.gen.grpc.model.Service;
import com.neon.rpc.gen.grpc.model.ServiceMethod;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3BaseListener;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3Lexer;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3Parser;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ProtobufParser {

    class Rpc {
        String name;
        String message;
        String resultMessage;
    }

    public ProtobufParser() {

    }

    public Service parse(File file) throws IOException {
        ANTLRFileStream antlrFileStream = new ANTLRFileStream( file.getAbsolutePath() );

        Protobuf3Lexer lexer = new Protobuf3Lexer( antlrFileStream );

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        Protobuf3Parser parser = new Protobuf3Parser(commonTokenStream);

        Protobuf3Parser.ProtoContext proto = parser.proto();


        final Service service = new Service();

        final List< Rpc > rpcs = new LinkedList<>();

        final Map< String, Message> messages = new HashMap<>();


        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new Protobuf3BaseListener() {

            @Override
            public void enterService(Protobuf3Parser.ServiceContext ctx) {
                Protobuf3Parser.ServiceNameContext serviceNameContext = ctx.serviceName();
                service.setName( serviceNameContext.getText() );
            }

            @Override
            public void enterRpc(Protobuf3Parser.RpcContext ctx) {
                Rpc rpc = new Rpc();

                Protobuf3Parser.RpcNameContext rpcNameContext = ctx.rpcName();
                rpc.name = rpcNameContext.getText();

//                List<Protobuf3Parser.MessageTypeContext> messageTypeContexts = ctx.messageType();
//                for (Protobuf3Parser.MessageTypeContext messageTypeContext : messageTypeContexts) {
//                    Protobuf3Parser.MessageNameContext messageNameContext = messageTypeContext.messageName();
//                    System.out.println( " [ messageType ] -> messageName=" + messageNameContext.getText() );
//                }

                Protobuf3Parser.MessageTypeContext messageTypeContext0 = ctx.messageType(0);
                Protobuf3Parser.MessageNameContext messageNameContext0 = messageTypeContext0.messageName();
                rpc.message = messageNameContext0.getText();

                Protobuf3Parser.MessageTypeContext messageTypeContext1 = ctx.messageType(1);
                Protobuf3Parser.MessageNameContext messageNameContext1 = messageTypeContext1.messageName();
                rpc.resultMessage = messageNameContext1.getText();

//                List<Protobuf3Parser.OptionContext> option = ctx.option();
//                for (Protobuf3Parser.OptionContext optionContext : option) {
//                    Protobuf3Parser.OptionNameContext optionNameContext = optionContext.optionName();
//                    System.out.println( " [ option ] -> " + optionNameContext.getText() );
//                }

                rpcs.add( rpc );
            }

            @Override
            public void enterMessage(Protobuf3Parser.MessageContext ctx) {
                Message message = messageParser.apply(ctx);
                messages.put( message.getName(), message );
            }

        }, proto );

        rpcs.stream()
                .map(rpc -> {
                    ServiceMethod method = new ServiceMethod();
                    method.setName(rpc.name);
                    method.setMessage(messages.get(rpc.message));
                    method.setResult(messages.get(rpc.resultMessage));
                    return method;
                })
                .forEach(service::addMethod);

        return service;
    }

    private Function<Protobuf3Parser.FieldContext, Field> fieldParser = ctx -> {
        Protobuf3Parser.FieldNameContext fieldNameContext = ctx.fieldName();
        Protobuf3Parser.FieldNumberContext fieldNumberContext = ctx.fieldNumber();
        Protobuf3Parser.FieldOptionsContext fieldOptionsContext = ctx.fieldOptions();
        Protobuf3Parser.TypeContext type = ctx.type();
        boolean isRepeated = ctx.getText().startsWith( "repeated" );

        Field field = new Field();
        field.setName( fieldNameContext.getText() );
        field.setOrder( fieldNumberContext.getText() );
        field.setType( type.getText() );
        field.setRepeated( isRepeated );
        return field;
    };

    private Function<Protobuf3Parser.MessageContext, Message > messageParser = ctx -> {
        Message message = new Message();

        Protobuf3Parser.MessageNameContext messageNameContext = ctx.messageName();

        message.setName( messageNameContext.getText() );

        Protobuf3Parser.MessageBodyContext messageBodyContext = ctx.messageBody();
        List<Protobuf3Parser.FieldContext> fields = messageBodyContext.field();
        for (Protobuf3Parser.FieldContext field : fields) {
            message.addField( fieldParser.apply( field ) );
        }

        return message;
    };
}
