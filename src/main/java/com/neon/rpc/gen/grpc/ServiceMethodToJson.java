package com.neon.rpc.gen.grpc;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.neon.rpc.gen.grpc.model.Message;
import com.neon.rpc.gen.grpc.model.ServiceMethod;

import java.util.Map;
import java.util.function.BiFunction;

public class ServiceMethodToJson implements BiFunction<Map< String, Message>, ServiceMethod, JsonElement> {

    private final BiFunction<Map< String, Message>, Message, JsonElement> messageToJson;

    public ServiceMethodToJson(BiFunction<Map<String, Message>, Message, JsonElement> messageToJson) {
        this.messageToJson = messageToJson;
    }

    @Override
    public JsonElement apply(Map<String, Message> messages, ServiceMethod method) {
        JsonObject object = new JsonObject();

        object.addProperty( "name", method.getName() );

        JsonElement message = messageToJson.apply(messages, method.getMessage());
        object.add( "message", message );

        return object;
    }

}
