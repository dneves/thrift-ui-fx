package com.neon.rpc.gen.grpc;

import com.neon.rpc.gen.grpc.ProtobufParser;
import com.neon.rpc.gen.grpc.model.Proto;
import org.junit.Test;

import java.io.InputStream;

public class ProtobufParserTest {

    @Test
    public void testSimpleParser() throws Exception {
        ProtobufParser parser = new ProtobufParser();

        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("simple.proto");

        Proto proto = parser.parse( resource );
//        System.out.println( proto );

//        TODO : validations
    }

}
