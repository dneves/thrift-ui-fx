package com.neon.rpc.gen.grpc;

import org.junit.Test;

public class GrpcJsonToMessageTest {

    @Test
    public void testApply() throws Exception {
        GrpcJsonToMessage grpcJsonToField = new GrpcJsonToMessage( this.getClass().getClassLoader() );

        String message = "{ " +
                "\"name\": \"DummyMessage\", " +
                "\"fields\": [ " +
                "{ " +
                "   \"name\": \"id\", " +
                "   \"type\": \"string\", " +
                "   \"value\": [ \"1\" ] " +
                "}, " +
                "{ " +
                "   \"name\": \"limit\", " +
                "   \"type\": \"uint32\", " +
                "   \"value\": 10 " +
                "} " +
                "] " +
                "}";

        Object output = grpcJsonToField.apply( message );
        System.out.println( output );
    }

}
