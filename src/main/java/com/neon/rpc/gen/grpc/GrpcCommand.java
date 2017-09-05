package com.neon.rpc.gen.grpc;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class GrpcCommand implements BiFunction< String, File, List< String > > {

    public GrpcCommand() {

    }

    @Override
    public List<String> apply(String outputPath, File input) {
//        protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto

        List< String > command = new LinkedList<>();
        command.add( "protoc" );

        command.add( "-I=" + input.getParent() );

        command.add( "--java_out=" + outputPath );

        command.add( input.getAbsolutePath() );

        return command;
    }

}
