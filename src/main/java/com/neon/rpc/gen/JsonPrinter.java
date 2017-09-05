package com.neon.rpc.gen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.util.function.Function;

public class JsonPrinter implements Function<JsonElement, String > {

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    @Override
    public String apply(JsonElement jsonElement) {
        return gson.toJson( jsonElement );
    }

}
