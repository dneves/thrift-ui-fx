package com.neon.rpc.gen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Function;

public class JsonPrettyPrinter implements Function< String, String > {

    private final Gson gsonPretty = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    @Override
    public String apply(String json) {
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> objects = gsonPretty.fromJson( json, type);
        return gsonPretty.toJson(objects, type);
    }

}
