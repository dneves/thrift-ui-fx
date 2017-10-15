package com.neon.rpc.gen.grpc;

import org.irenical.jindy.ConfigFactory;
import org.irenical.jindy.ConfigNotFoundException;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

public class GrpcCommand implements BiFunction< String, File, List< List< String > > > {

    private static final String PATH_TO_PROTOC_GEN_GRPC_JAVA = "protoc-gen-grpc-java.path";

    private final String protocGenGrpcJavaPath;

    public GrpcCommand() throws ConfigNotFoundException {
        protocGenGrpcJavaPath = ConfigFactory.getConfig().getMandatoryString( PATH_TO_PROTOC_GEN_GRPC_JAVA );
    }

    @Override
    public List< List<String> > apply(String outputPath, File input) {
//        protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/file.proto

//        protoc
        // --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN_EXE
        // --grpc-java_out=$DST_DIR
        // --proto_path=$SRC_DIR
        // $SRC_DIR/file.proto

//        TODO : plugin path dependent on OS

        List< String > command = new LinkedList<>();
        command.add( "protoc" );
        command.add( "--plugin=protoc-gen-grpc-java=" + protocGenGrpcJavaPath );
        command.add( "--grpc-java_out=" + outputPath );
        command.add( "--proto_path=" + input.getParent() );
        command.add( input.getAbsolutePath() );

        List< String > command2 = new LinkedList<>();
        command2.add( "protoc" );
        command2.add( "--java_out=" + outputPath );
        command2.add( "-I=" + input.getParent() );
        command2.add( input.getAbsolutePath() );

        return Arrays.asList( command, command2 );
    }

}
