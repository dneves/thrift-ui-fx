package com.neon.rpc.gen.grpc;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neon.rpc.gen.grpc.model.Field;
import com.neon.rpc.gen.grpc.model.Message;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class MessageToJson implements BiFunction<Map< String, Message >, Message, JsonElement > {

    private final FieldToJson fieldToJson;

    public MessageToJson( FieldToJson fieldToJson ) {
        this.fieldToJson = fieldToJson;
    }

    @Override
    public JsonElement apply( Map< String, Message > messages, Message message ) {
        JsonObject object = new JsonObject();

        object.addProperty( "name", message.getName() );

        JsonArray jsonFields = new JsonArray();

        List<Field> fields = message.getFields();
        for (Field field : fields) {
            jsonFields.add( fieldToJson.apply( messages, field ) );
        }

        object.add( "fields", jsonFields );

        return object;
    }

}
