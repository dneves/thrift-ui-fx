package com.neon.thrift.ui;

import com.neon.rpc.gen.thrift.ThriftCommand;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ThriftCommandTest {

    @Test
    public void testCommand() throws Exception {
        final String outputPath = "/output/folder";
        final String contractPath = "/some/folder/contract.thrift";

        final List< String > expected = Arrays.asList( "thrift", "-out", outputPath, "--gen", "java", contractPath );

        ThriftCommand thriftCommand = new ThriftCommand();
        List<String> command = thriftCommand.apply( outputPath, contractPath );

        Assert.assertEquals( expected, command );
    }

}
