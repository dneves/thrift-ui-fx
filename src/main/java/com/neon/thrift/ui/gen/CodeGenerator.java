package com.neon.thrift.ui.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.BiFunction;

public class CodeGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger( CodeGenerator.class );


//    private static class ProcessReader implements Runnable {
//
//        private static final Logger LOGGER = LoggerFactory.getLogger( ProcessReader.class );
//
//        private final InputStream inputStream;
//
//        ProcessReader(InputStream inputStream) {
//            this.inputStream = inputStream;
//        }
//
//        @Override
//        public void run() {
//            try {
//                final BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    LOGGER.debug( line );
//                }
//                reader.close();
//            } catch (final Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


    private final BiFunction< String, String, List< String > > command;

    public CodeGenerator( BiFunction< String, String, List< String > > command ) {
        if ( command == null ) {
            throw new IllegalArgumentException( "command cannot be null" );
        }
        this.command = command;
    }

    public Path generate( String serviceName, String contract ) throws IOException, InterruptedException {
//        create temporary directory to hold the generated classes
        Path tempDirectory = Files.createTempDirectory("thrift-" + serviceName + "-");
        File tempFileDirectory = tempDirectory.toFile();
        tempFileDirectory.deleteOnExit();

        Path path = tempDirectory.toAbsolutePath();

        List< String > commandParameters = command.apply( path.toString(), contract );
        LOGGER.debug( "command: " + commandParameters.toString() );

        ProcessBuilder processBuilder = new ProcessBuilder( commandParameters );
        Process process = processBuilder.start();

//        final Thread inputReader = new Thread( new ProcessReader( process.getInputStream() ) );
//        inputReader.start();

//        final Thread errorReader = new Thread( new ProcessReader( process.getErrorStream() ) );
//        errorReader.start();

        process.waitFor();

        return path;
    }

}
