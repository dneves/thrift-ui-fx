package com.neon.rpc.gen.grpc;

import com.neon.rpc.gen.grpc.FieldToJson;
import com.neon.rpc.gen.grpc.model.Field;
import org.junit.Test;

public class FieldToJsonTest {

    @Test
    public void testPrimitiveField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "string" );
        field.setOrder( "1" );
        field.setRepeated( false );

        String json = parser.apply(field);
        System.out.println( json );
    }

}
