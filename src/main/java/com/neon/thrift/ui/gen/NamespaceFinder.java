package com.neon.thrift.ui.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;

public class NamespaceFinder implements Function< String, Optional< String > >  {

    private static final Logger LOGGER = LoggerFactory.getLogger( NamespaceFinder.class );

    private static final String FILTER = "namespace java ";

    @Override
    public Optional<String> apply( String fileContractPath ) {
        try {
            return Files.lines(Paths.get( fileContractPath ))
                    .filter(line -> line.startsWith( FILTER ))
                    .map(line -> {
                        String packagePath = line.substring( FILTER.length() );
                        if ( packagePath.endsWith( ";" ) ) {
                            packagePath = packagePath.substring( 0, -1 );
                        }
                        return packagePath;
                    })
                    .findFirst();
        } catch (IOException e) {
            LOGGER.error( e.getLocalizedMessage(), e );
            return Optional.empty();
        }
    }

}
