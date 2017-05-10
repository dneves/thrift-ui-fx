package com.neon.rpc.thrift;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class ThriftCommand implements BiFunction< String, String, List< String > > {

    public ThriftCommand() {

    }

    public List< String > apply( String outputPath, String contractPath ) {
        List< String > command = new LinkedList<>();
        command.add( "thrift" );
        command.add( "-out" );
        command.add( outputPath );
        command.add( "--gen" );
        command.add( "java" );
        command.add( contractPath );
        return command;
    }
}
