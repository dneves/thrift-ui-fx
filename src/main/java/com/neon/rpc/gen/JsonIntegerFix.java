package com.neon.rpc.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

/**
 * Giveup on int values of 0.0 to 0
 */
public class JsonIntegerFix implements Function< String, String > {

    private static final Logger LOGGER = LoggerFactory.getLogger( JsonIntegerFix.class );

    private final String[] types = new String[] {
            "int", "uint", "sint", "fixed", "sfixed"
    };

    private final String[] bits = new String[] {
            "32", "64"
    };

    public JsonIntegerFix() {

    }

    @Override
    public String apply(String s) {
        String types = buildTypesGroup();

        return s.replaceAll(
                "\"type\": \"(" + types + ")\",\n(\\s*)\"value\": (\\d)(\\.\\d*)?",
                "\"type\": \"$1\",\n$2\"value\": $3" );
    }

    private String buildTypesGroup() {
        StringBuilder builder = new StringBuilder();
        for (String type : types) {
            for (String bit : bits) {
                builder.append(type).append(bit).append("|");
            }
        }
        builder.deleteCharAt( builder.length() - 1 );
        return builder.toString();
    }

}
