package com.neon.thrift.ui;

import com.neon.rpc.thrift.ThriftNamespaceFinder;
import com.neon.rpc.thrift.ThriftServiceNameFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class NameFinderTest {

    @Test
    public void testServiceNameFinder() throws Exception {
        ThriftServiceNameFinder serviceNameFinder = new ThriftServiceNameFinder();

        Optional<String> serviceName = serviceNameFinder.apply( Stream.of( "something", "", "service MyService {", "", "}", "" ) );
        Assert.assertTrue( serviceName.isPresent() );
        Assert.assertEquals( "MyService", serviceName.get() );
    }

    @Test
    public void testNamespaceFinder() throws Exception {
        Optional<String> optional = new ThriftNamespaceFinder().apply( Stream.of("something", "", "namespace java com.example", "" ) );

        Assert.assertTrue( optional.isPresent() );
        Assert.assertEquals( "com.example", optional.get() );
    }

    @Test
    public void testNamespaceFinderSemiColon() throws Exception {
        Optional<String> optional = new ThriftNamespaceFinder().apply(Stream.of("something", "", "namespace java com.example;", "", "service MyService {", "", "}"));
        Assert.assertTrue( optional.isPresent() );
        Assert.assertEquals( "com.example", optional.get() );
    }

    @Test
    public void testNamespaceFinderNoNamespace() throws Exception {
        Optional<String> optional = new ThriftNamespaceFinder().apply(Stream.of("something", "", "service MyService {", "", "}"));
        Assert.assertFalse( optional.isPresent() );
    }

    @Test
    public void testNamespaceFinderNoJavaNamespace() throws Exception {
        Optional<String> optional = new ThriftNamespaceFinder().apply(Stream.of("something", "", "namespace cpp com.example", "", "service MyService {", "", "}"));
        Assert.assertFalse( optional.isPresent() );
    }

}
