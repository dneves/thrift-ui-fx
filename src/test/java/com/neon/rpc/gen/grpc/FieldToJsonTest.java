package com.neon.rpc.gen.grpc;

import com.neon.rpc.gen.grpc.model.Field;
import com.neon.rpc.gen.grpc.model.Message;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FieldToJsonTest {

    @Test
    public void testStringSimpleField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "string" );
        field.setOrder( "1" );
        field.setRepeated( false );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"string\",\"value\":\"\"}", json );
    }

    @Test
    public void testStringRepeatableField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "string" );
        field.setOrder( "1" );
        field.setRepeated( true );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"string\",\"value\":[\"\"]}", json );
    }

    @Test
    public void testBoolSimpleField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "bool" );
        field.setOrder( "1" );
        field.setRepeated( false );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"bool\",\"value\":false}", json );
    }

    @Test
    public void testBoolRepeatableField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "bool" );
        field.setOrder( "1" );
        field.setRepeated( true );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"bool\",\"value\":[false]}", json );
    }

    @Test
    public void testNumberSimpleField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "int32" );
        field.setOrder( "1" );
        field.setRepeated( false );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"int32\",\"value\":0}", json );
    }

    @Test
    public void testNumberRepeatableField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Field field = new Field();
        field.setName( "field-name" );
        field.setType( "float" );
        field.setOrder( "1" );
        field.setRepeated( true );

        String json = parser.apply( null, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"float\",\"value\":[0.0]}", json );
    }

    @Test
    public void testMessageField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Message message = new Message();
        message.setName( "Entity" );
        message.addField( createField( "entity-field-1", "string", "1", false ) );
        message.addField( createField( "entity-field-2", "string", "2", true ) );

        Map< String, Message> messages = new HashMap<>();
        messages.put( message.getName(), message );

        Field field = createField( "field-name", "Entity", "1", false );

        String json = parser.apply( messages, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"Entity\",\"value\":[{\"name\":\"entity-field-1\",\"type\":\"string\",\"value\":\"\"},{\"name\":\"entity-field-2\",\"type\":\"string\",\"value\":[\"\"]}]}", json );
    }

    @Test
    public void testMessageRepeatableField() throws Exception {
        FieldToJson parser = new FieldToJson();

        Message message = new Message();
        message.setName( "Entity" );
        message.addField( createField( "entity-field-1", "string", "1", false ) );

        Map< String, Message> messages = new HashMap<>();
        messages.put( message.getName(), message );

        Field field = createField( "field-name", "Entity", "1", true );

        String json = parser.apply( messages, field);
        Assert.assertEquals( "{\"name\":\"field-name\",\"type\":\"Entity\",\"value\":[{\"name\":\"entity-field-1\",\"type\":\"string\",\"value\":\"\"}]}", json );
    }


    private Field createField( String name, String type, String order, boolean repeatable ) {
        Field field = new Field();
        field.setName( name );
        field.setType( type );
        field.setOrder( order );
        field.setRepeated( repeatable);
        return field;
    }

}
