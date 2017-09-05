package com.neon.rpc.gen.thrift;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ThriftCommandTest {

    @Test
    public void testCommand() throws Exception {
        final String outputPath = "/output/folder";
        final String contractPath = "/some/folder/contract.thrift";

        final List< String > expected = Arrays.asList( "thrift", "-out", outputPath, "--gen", "java", contractPath );

        ThriftCommand thriftCommand = new ThriftCommand();
        List<String> command = thriftCommand.apply( outputPath, new File( contractPath ) );

        Assert.assertEquals( expected, command );
    }

}
