package com.neon.thrift.ui.gen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ThriftCodeGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger( ThriftCodeGenerator.class );


    private static class ProcessReader implements Runnable {

        private static final Logger LOGGER = LoggerFactory.getLogger( ProcessReader.class );

        private final InputStream inputStream;

        ProcessReader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            try {
                final BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
                String line;
                while ((line = reader.readLine()) != null) {
                    LOGGER.debug( line );
                }
                reader.close();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

    }


    public ThriftCodeGenerator() {

    }

    public Path generate( String serviceName, String contract ) throws IOException, InterruptedException {
//        create temporary directory to hold the generated classes
        Path tempDirectory = Files.createTempDirectory("thrift-" + serviceName + "-");
        File tempFileDirectory = tempDirectory.toFile();
        tempFileDirectory.deleteOnExit();

        Path path = tempDirectory.toAbsolutePath();

//        thrift command
        List< String > command = new LinkedList<>();
        command.add( "thrift" );
        command.add( "-out" );
        command.add( path.toString() );
        command.add( "--gen" );
        command.add( "java" );
        command.add( contract );
        LOGGER.debug( "command: " + command.toString() );

        ProcessBuilder processBuilder = new ProcessBuilder( command );
        Process process = processBuilder.start();

        final Thread inputReader = new Thread( new ProcessReader( process.getInputStream() ) );
        inputReader.start();

        final Thread errorReader = new Thread( new ProcessReader( process.getErrorStream() ) );
        errorReader.start();

        process.waitFor();

        return path;
    }

}
