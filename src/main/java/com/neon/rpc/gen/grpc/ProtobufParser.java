package com.neon.rpc.gen.grpc;

import com.neon.rpc.gen.grpc.model.Field;
import com.neon.rpc.gen.grpc.model.Message;
import com.neon.rpc.gen.grpc.model.Proto;
import com.neon.rpc.gen.grpc.model.Service;
import com.neon.rpc.gen.grpc.model.ServiceMethod;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3BaseListener;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3Lexer;
import com.neon.rpc.gen.grpc.protobuf.Protobuf3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * TODO : support enum
 * TODO : support nested messages
 */
public class ProtobufParser {

    class Rpc {
        String name;
        String message;
        String resultMessage;
    }

    public ProtobufParser() {

    }

    public Proto parse( InputStream inputStream ) throws IOException {
//        ANTLRFileStream stream = new ANTLRFileStream( file.getAbsolutePath() );
        ANTLRInputStream stream = new ANTLRInputStream(inputStream);

        Protobuf3Lexer lexer = new Protobuf3Lexer( stream );

        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        Protobuf3Parser parser = new Protobuf3Parser(commonTokenStream);

        Protobuf3Parser.ProtoContext proto = parser.proto();


        final Map< String, Message> messages = new HashMap<>();

        final Map< String, List< Rpc > > rpcPerService = new HashMap<>();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new Protobuf3BaseListener() {

            String currentServiceName = null;

            @Override
            public void enterService(Protobuf3Parser.ServiceContext ctx) {
                Protobuf3Parser.ServiceNameContext serviceNameContext = ctx.serviceName();

                currentServiceName = serviceNameContext.getText();
            }

            @Override
            public void exitService(Protobuf3Parser.ServiceContext ctx) {
                currentServiceName = null;
            }

            @Override
            public void enterMessage(Protobuf3Parser.MessageContext ctx) {
                Message message = messageParser.apply(ctx);
                messages.put( message.getName(), message );
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

                List<Rpc> serviceRpcs = rpcPerService.computeIfAbsent(currentServiceName, k -> new LinkedList<>());
                serviceRpcs.add( rpc );
            }

        }, proto );


        Proto result = new Proto();
        result.messages = messages;
        result.services = new HashMap<>();

        for (String serviceName : rpcPerService.keySet()) {
            Service service = new Service();
            service.setName( serviceName );

            List<Rpc> rpcs = rpcPerService.get(serviceName);
            rpcs.stream()
                    .map( rpc -> methodParser.apply( messages, rpc ) )
                    .forEach(service::addMethod);

            result.services.putIfAbsent( serviceName, service );
        }

        return result;
    }

    private BiFunction< Map< String, Message >, Rpc, ServiceMethod > methodParser = (messages, rpc) -> {
        ServiceMethod method = new ServiceMethod();
        method.setName(rpc.name);
        method.setMessage(messages.get(rpc.message));
        method.setResult(messages.get(rpc.resultMessage));
        return method;
    };

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
