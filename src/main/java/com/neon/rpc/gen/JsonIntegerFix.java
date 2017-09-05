package com.neon.rpc.gen;

import java.util.function.Function;

public class JsonIntegerFix implements Function< String, String > {

    @Override
    public String apply(String s) {
        //        giveup to convert int values of 0.0 to 0

//        TODO : int, uint, sint, fixed, sfixed 32/64

        return s.replaceAll(
                "\"type\": \"uint32\",\n(\\s*)\"value\": (\\d)(\\.\\d*)?",
                "\"type\": \"uint32\",\n$1\"value\": $2" );
    }

}
