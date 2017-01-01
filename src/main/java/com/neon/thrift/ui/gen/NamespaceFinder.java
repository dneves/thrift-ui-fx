package com.neon.thrift.ui.gen;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class NamespaceFinder implements Function< Stream< String >, Optional< String > >  {

    private static final String FILTER = "namespace java ";

    @Override
    public Optional<String> apply( Stream< String > lines ) {
        return lines
                .filter(line -> line.startsWith( FILTER ))
                .map(line -> {
                    String packagePath = line.substring( FILTER.length() );
                    if ( packagePath.endsWith( ";" ) ) {
                        packagePath = packagePath.substring( 0, packagePath.length() - 1 );
                    }
                    return packagePath;
                })
                .findFirst();
    }

}
