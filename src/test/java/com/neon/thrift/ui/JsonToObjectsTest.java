package com.neon.thrift.ui;

import com.neon.thrift.ui.gen.JsonToObjects;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class JsonToObjectsTest {

    /**
     [
         {
             "name": "exampleBean",
             "type": "com.neon.thrift.ui.ExampleBean",
             "value": { "id": null, "limit": 0 }
         },
         {
             "name": "limit",
             "type": "int",
             "value": 0
         },
         {
             "name": "randomArgument",
             "type": "java.lang.String",
             "value": null
         }
     ]

     *

     [
         {
             "name": "beanList",
             "type": "com.neon.thrift.ui.ExampleBean",
             "value": [ { "id": null, "limit": 0 }, { "id": null, "limit": 0 }, ... ]
         }
    ]

     */



    @Test
    public void singleValue() throws Exception {
        JsonToObjects jsonToObjects = new JsonToObjects();

        ClassLoader classLoader = this.getClass().getClassLoader();

        Object[] objects = jsonToObjects.create(classLoader, "[\n" +
                "         {\n" +
                "             \"name\": \"bean\",\n" +
                "             \"type\": \"com.neon.thrift.ui.ExampleBean\",\n" +
                "             \"value\": { \"id\": null, \"randomProperty\": null }\n" +
                "         }\n" +
                "    ]");

        ExampleBean expected = new ExampleBean();
        expected.setId( null );
        expected.setRandomProperty( null );

//        List< Object > e = Arrays.asList( expected, expected );

        Assert.assertTrue( objects != null && objects.length == 1 );
        Assert.assertEquals( expected, objects[ 0 ] );
    }

    @Test
    public void listValue() throws Exception {
        JsonToObjects jsonToObjects = new JsonToObjects();

        ClassLoader classLoader = this.getClass().getClassLoader();

        Object[] objects = jsonToObjects.create(classLoader, "[\n" +
                "         {\n" +
                "             \"name\": \"beanList\",\n" +
                "             \"type\": \"com.neon.thrift.ui.ExampleBean\",\n" +
                "             \"value\": [ { \"id\": null, \"randomProperty\": null }, { \"id\": null, \"randomProperty\": null } ]\n" +
                "         }\n" +
                "    ]");

        ExampleBean expected = new ExampleBean();
        expected.setId( null );
        expected.setRandomProperty( null );

        List< Object > e = Arrays.asList( expected, expected );

        Assert.assertTrue( objects != null && objects.length == 1 );
        Assert.assertEquals( e, objects[ 0 ] );
    }

}
