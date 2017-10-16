package com.neon.rpc.gen.grpc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

public class GrpcJsonToMessage {

    private static final Logger LOGGER = LoggerFactory.getLogger( GrpcJsonToMessage.class );

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    private final ClassLoader classLoader;

    public GrpcJsonToMessage(ClassLoader classLoader ) {
        this.classLoader = classLoader;
    }

    public Object apply( String jsonMessage ) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Type type = new TypeToken< JsonObject >() {}.getType();
        JsonObject message = gson.fromJson( jsonMessage, type);
        LOGGER.debug( message.toString() );

        JsonElement elementName = message.get("name");
        LOGGER.debug( "[message] name=" + elementName.getAsString() );


        Class<?> messageClass = classLoader.loadClass(elementName.getAsString());
        Class<?> builderClass = classLoader.loadClass(elementName.getAsString() + "$Builder");

        Method mBuilder = messageClass.getMethod("newBuilder");
        Object builder = mBuilder.invoke(null);

        JsonArray fields = message.getAsJsonArray("fields");
        fields.forEach( f -> {
            if ( f instanceof JsonObject ) {
                JsonObject field = ( JsonObject ) f;
                useField( builderClass, builder, field );
            }
        } );

        return null;
    }

    private void useField(Class<?> builderClass, Object builder, JsonObject field) {
        JsonElement elementName = field.get("name");
        String fieldName = elementName.getAsString();
        JsonElement elementType = field.get("type");
        String fieldType = elementType.getAsString();
        JsonElement elementValue = field.get("value");
        LOGGER.debug( "[field] name=" + fieldName + ", type=" + fieldType + ", value=" + elementValue.toString() );

        if ( elementValue.isJsonArray() ) {
            JsonArray values = elementValue.getAsJsonArray();

        } else if ( elementValue.isJsonObject() ) {
            JsonObject value = elementValue.getAsJsonObject();

        } else if ( elementValue.isJsonPrimitive() ) {
            JsonPrimitive value = elementValue.getAsJsonPrimitive();


        }

    }

}
