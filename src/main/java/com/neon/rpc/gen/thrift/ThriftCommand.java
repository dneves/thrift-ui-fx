package com.neon.rpc.gen.thrift;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class ThriftCommand implements BiFunction< String, File, List< List< String > > > {

    public ThriftCommand() {

    }

    public List< List< String > > apply( String outputPath, File input ) {
        List< String > command = new LinkedList<>();
        command.add( "thrift" );
        command.add( "-out" );
        command.add( outputPath );
        command.add( "--gen" );
        command.add( "java" );
        command.add( input.getAbsolutePath() );
        return Arrays.asList( command );
    }
}
