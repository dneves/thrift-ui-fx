package com.neon.thrift.ui;

import java.util.List;
import java.util.Map;

public interface ExampleService {

    void emptyMethod();

    void singleSimpleMethod( int limit );

    void singleMethod( ExampleBean exampleBean );

    void multiMethod( List< ExampleBean > beanList );

    void complexSingleMethod( ExampleBean exampleBean, int limit, String randomArgument );

    void complexMultiMethod( List< ExampleBean > beanList, String randomArgument, int limit );

    void mapMethod( Map< String, ExampleBean > map );

}
