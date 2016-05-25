package com.neon.thrift.ui.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;

public class ServiceNameFinder implements Function< String, Optional< String > > {

    private static final Logger LOGGER = LoggerFactory.getLogger( ServiceNameFinder.class );

    private static final String FILTER = "service ";

    @Override
    public Optional<String> apply( String fileContractPath ) {
        try {
            return Files.lines( Paths.get( fileContractPath ) )
                    .filter(line -> line.startsWith( FILTER ))
                    .map(line -> {
                        String[] split = line.split(" ");
                        return split[ 1 ];
                    })
                    .findFirst();
        } catch (IOException e) {
            LOGGER.error( e.getLocalizedMessage(), e );
            return Optional.empty();
        }
    }

}
