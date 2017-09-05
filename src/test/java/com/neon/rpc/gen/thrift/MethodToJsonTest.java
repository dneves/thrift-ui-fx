package com.neon.rpc.gen.thrift;

import com.neon.rpc.gen.thrift.dummy.ExampleBean;
import com.neon.rpc.gen.thrift.dummy.ExampleEnum;
import com.neon.rpc.gen.thrift.dummy.ExampleService;
import com.neon.rpc.gen.MethodToJson;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class MethodToJsonTest {

    @Test
    public void emptyMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("emptyMethod");

        final String expected = "[]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals( expected, pharze );
    }

    @Test
    public void singleSimpleMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("singleSimpleMethod", int.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"int\",\n" +
                "    \"value\": 0\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals( expected, pharze );
    }

    @Test
    public void singleMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("singleMethod", ExampleBean.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleBean.class.getName() + "\",\n" +
                "    \"value\": {\n" +
                "      \"id\": null,\n" +
                "      \"randomProperty\": null,\n" +
                "      \"enumValue\": null\n" +
                "    }\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals( expected, pharze );
    }

    @Test
    public void multiMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("multiMethod", List.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleBean.class.getName() + "\",\n" +
                "    \"value\": [\n" +
                "      {\n" +
                "        \"id\": null,\n" +
                "        \"randomProperty\": null,\n" +
                "        \"enumValue\": null\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals(expected, pharze );
    }

    @Test
    public void complexSingleMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("complexSingleMethod", ExampleBean.class, int.class, String.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleBean.class.getName() + "\",\n" +
                "    \"value\": {\n" +
                "      \"id\": null,\n" +
                "      \"randomProperty\": null,\n" +
                "      \"enumValue\": null\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"arg1\",\n" +
                "    \"type\": \"int\",\n" +
                "    \"value\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"arg2\",\n" +
                "    \"type\": \"java.lang.String\",\n" +
                "    \"value\": null\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals(expected, pharze );
    }

    @Test
    public void complexMultiMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("complexMultiMethod", List.class, String.class, int.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleBean.class.getName() + "\",\n" +
                "    \"value\": [\n" +
                "      {\n" +
                "        \"id\": null,\n" +
                "        \"randomProperty\": null,\n" +
                "        \"enumValue\": null\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"arg1\",\n" +
                "    \"type\": \"java.lang.String\",\n" +
                "    \"value\": null\n" +
                "  },\n" +
                "  {\n" +
                "    \"name\": \"arg2\",\n" +
                "    \"type\": \"int\",\n" +
                "    \"value\": 0\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals(expected, pharze );
    }

    @Test
    public void mapMethod() throws Exception {
        Class<ExampleService> aClass = ExampleService.class;
        Method method = aClass.getMethod("mapMethod", Map.class );

        final String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleBean.class.getName() + "\",\n" +
                "    \"value\": {\n" +
                "      \"map-key\": {\n" +
                "        \"id\": null,\n" +
                "        \"randomProperty\": null,\n" +
                "        \"enumValue\": null\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "]";

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        Assert.assertEquals(expected, pharze );
    }

    @Test
    public void testEnums() throws Exception {
        Class< ExampleService > aClass = ExampleService.class;
        Method method = aClass.getMethod( "enumMethod", ExampleEnum.class );

        MethodToJson methodToJson = new MethodToJson();
        String pharze = methodToJson.generate(method);

        String expected = "[\n" +
                "  {\n" +
                "    \"name\": \"arg0\",\n" +
                "    \"type\": \"" + ExampleEnum.class.getName() + "\",\n" +
                "    \"value\": \"ENUM_VALUE_1 | ENUM_VALUE_2\"\n" +
                "  }\n" +
                "]";

        Assert.assertEquals( expected, pharze );
    }
}
