package com.neon.rpc.gen.grpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class GrpcNamespaceFinder implements Function< Stream< String >, Optional< String > > {

    private static final String FILTER_JAVA_PACKAGE = "option java_package =";

    private static final String FILTER_PACKAGE = "package ";

    @Override
    public Optional<String> apply(Stream<String> lines) {

        Map< String, String > packages = new HashMap<>();

        lines.filter( line -> line.startsWith(FILTER_JAVA_PACKAGE) || line.startsWith(FILTER_PACKAGE) )
                .forEach( line -> {
                    if ( line.startsWith( FILTER_JAVA_PACKAGE ) ) {
                        packages.put( FILTER_JAVA_PACKAGE, line.substring(line.indexOf("\"")+1, line.lastIndexOf("\"")) );
                    } else if ( line.startsWith( FILTER_PACKAGE ) ) {
                        String p = line.substring( FILTER_PACKAGE.length() );
                        if ( p.endsWith( ";" ) ) {
                            p = p.substring( 0, p.length() - 1 );
                        }
                        packages.put( FILTER_PACKAGE, p );
                    }
                } );

        String result = null;

        String p1 = packages.get( FILTER_JAVA_PACKAGE );
        if ( p1 != null ) {
            result = p1;
        }
        String p2 = packages.get( FILTER_PACKAGE );
        if ( p2 != null ) {
            result = result == null ? p2 : result + "." + p2;
        }

        return Optional.ofNullable( result );
    }

}
