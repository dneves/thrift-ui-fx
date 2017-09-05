package com.neon.rpc.gen.grpc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neon.rpc.gen.grpc.model.Field;
import com.neon.rpc.gen.grpc.model.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class FieldToJson implements BiFunction< Map< String, Message>, Field, JsonElement > {

    private static final Map< String, Number > DEFAULT_NUMBERS = new HashMap<>();
    static {
        DEFAULT_NUMBERS.put( "double", 0d );
        DEFAULT_NUMBERS.put( "float", 0f );
        DEFAULT_NUMBERS.put( "int32", 0 );
        DEFAULT_NUMBERS.put( "int64", 0L );
        DEFAULT_NUMBERS.put( "uint32", 0 );
        DEFAULT_NUMBERS.put( "uint64", 0L );
        DEFAULT_NUMBERS.put( "sint32", 0 );
        DEFAULT_NUMBERS.put( "sint64", 0L );
        DEFAULT_NUMBERS.put( "fixed32", 0 );
        DEFAULT_NUMBERS.put( "fixed64", 0L );
        DEFAULT_NUMBERS.put( "sfixed32", 0 );
        DEFAULT_NUMBERS.put( "sfixed64", 0L );
    }


    @Override
    public JsonElement apply( Map< String, Message > messages, Field field ) {
        return build( messages, field );
    }


    private JsonElement build( Map< String, Message > messages, Field field ) {
        JsonObject object = new JsonObject();

        object.addProperty( "name", field.getName() );
        object.addProperty( "type", field.getType() );

        if ( field.isRepeated() ) {
            JsonArray array = new JsonArray();

            Number number = DEFAULT_NUMBERS.get(field.getType());
            if (number != null) {
                array.add( number );
                object.add( "value", array );
            } else if ("bool".equalsIgnoreCase(field.getType())) {
                array.add( Boolean.FALSE );
                object.add( "value", array );
            } else if ("string".equalsIgnoreCase(field.getType())) {
                array.add( "" );
                object.add( "value", array );
            } else {
                object.add( "value", getMessageElement( messages, field ) );
            }

        } else {

            Number number = DEFAULT_NUMBERS.get(field.getType());
            if (number != null) {
                object.addProperty("value", number);
            } else if ("bool".equalsIgnoreCase(field.getType())) {
                object.addProperty("value", Boolean.FALSE);
            } else if ("string".equalsIgnoreCase(field.getType())) {
                object.addProperty("value", "");
            } else {
                object.add("value", getMessageElement( messages, field ) );
            }

        }

        return object;
    }

    private JsonElement getMessageElement(Map< String, Message > messages, Field field ) {
        JsonArray messageObjectFields = new JsonArray();

        Message message = messages.get(field.getType());
        if ( message == null ) {
            return messageObjectFields;
        }

        List<Field> fields = message.getFields();
        if ( fields == null || fields.isEmpty() ) {
            return messageObjectFields;
        }

        for (Field mField : fields) {
            JsonElement mElement = build( messages, mField );

            messageObjectFields.add( mElement );
        }

        return messageObjectFields;
    }

//    private boolean isPrimitive( String type ) {
//        boolean result = false;
//
//        switch ( type ) {
//            case "double":
//            case "float":
//            case "int32":
//            case "int64":
//            case "uint32":
//            case "uint64":
//            case "sint32":
//            case "sint64":
//            case "fixed32":
//            case "fixed64":
//            case "sfixed32":
//            case "sfixed64":
//            case "bool":
//            case "string":
//            case "bytes":
//                result = true;
//                break;
//        }
//
//        return result;
//    }

}
