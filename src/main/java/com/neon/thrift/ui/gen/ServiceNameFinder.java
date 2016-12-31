package com.neon.thrift.ui.gen;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ServiceNameFinder implements Function<Stream< String >, Optional< String > > {

    private static final String FILTER = "service ";

    @Override
    public Optional<String> apply( Stream< String > lines ) {
        return lines
                .filter(line -> line.startsWith( FILTER ))
                .map(line -> {
                    String[] split = line.split(" ");
                    return split[ 1 ];
                })
                .findFirst();
    }

}
