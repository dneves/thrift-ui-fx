package com.neon.thrift.ui;

import com.neon.thrift.ui.gen.ClassNameBuilder;
import org.junit.Assert;
import org.junit.Test;

public class ClassNameBuilderTest {

    @Test( expected = IllegalArgumentException.class )
    public void testNoServiceName() throws Exception {
        ClassNameBuilder.create( null ).build();
    }

    @Test
    public void testNoNamespace() throws Exception {
        String myService = ClassNameBuilder.create("MyService").build();
        Assert.assertEquals( "MyService", myService );
    }

    @Test
    public void testWithNamespace() throws Exception {
        String myService = ClassNameBuilder.create("MyService")
                .withNamespace( "com.example.package" )
                .build();
        Assert.assertEquals( "com.example.package.MyService", myService );
    }

}
