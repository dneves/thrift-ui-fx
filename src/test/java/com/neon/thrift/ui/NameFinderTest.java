package com.neon.thrift.ui;

import com.neon.thrift.ui.gen.NamespaceFinder;
import com.neon.thrift.ui.gen.ServiceNameFinder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class NameFinderTest {

    @Test
    public void testServiceNameFinder() throws Exception {
        ServiceNameFinder serviceNameFinder = new ServiceNameFinder();

        Optional<String> serviceName = serviceNameFinder.apply( Stream.of( "something", "", "service MyService {", "", "}", "" ) );
        Assert.assertTrue( serviceName.isPresent() );
        Assert.assertEquals( "MyService", serviceName.get() );
    }

    @Test
    public void testNamespaceFinder() throws Exception {
        NamespaceFinder namespaceFinder = new NamespaceFinder();

        Optional<String> optional = namespaceFinder.apply( Stream.of("something", "", "namespace java com.example", "" ) );

        Assert.assertTrue( optional.isPresent() );
        Assert.assertEquals( "com.example", optional.get() );
    }

    @Test
    public void testNamespaceFinderNoNamespace() throws Exception {
        Optional<String> optional = new NamespaceFinder().apply(Stream.of("something", "", "service MyService {", "", "}"));
        Assert.assertFalse( optional.isPresent() );
    }

    @Test
    public void testNamespaceFinderNoJavaNamespace() throws Exception {
        Optional<String> optional = new NamespaceFinder().apply(Stream.of("something", "", "namespace cpp com.example", "", "service MyService {", "", "}"));
        Assert.assertFalse( optional.isPresent() );
    }

}
