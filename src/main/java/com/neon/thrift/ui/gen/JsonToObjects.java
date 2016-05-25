package com.neon.thrift.ui.gen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class JsonToObjects {

    private static final Logger LOGGER = LoggerFactory.getLogger( JsonToObjects.class );

    public JsonToObjects() {

    }

    public Object[] create(ClassLoader classLoader, String json ) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        if ( json == null || json.trim().isEmpty() ) {
            return null;
        }

        Gson gson = new GsonBuilder().create();

        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> objects = gson.fromJson(json, type);

        List< Object > result = new ArrayList<>( objects.size() );

        for (Map<String, Object> object : objects) {

            String name = (String) object.get("name");
            String parameterType = (String) object.get("type");
            Object objectValue = object.get("value");

            LOGGER.debug( "name=" + name + ", type=" + parameterType + ", value=" + objectValue );

            Object o = create(classLoader, parameterType, objectValue);
            result.add( o );
        }

        return result.toArray();
    }


    private Object create(ClassLoader classLoader, String type, Object value ) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        if ( value instanceof List ) {
            List< Object > list = ( List< Object > ) value;
            List< Object > result = new ArrayList<>( list.size() );
            for (Object listElement : list) {
                result.add( create( classLoader, type, listElement ) );
            }
            return result;
        } else if ( value instanceof Map ) {
            Map< String, Object > map = ( Map< String, Object > ) value;

            Class<?> aClass = classLoader.loadClass( type );
            Object instance = aClass.newInstance();

            for (String fieldName : map.keySet()) {
                Object fieldValue = map.get(fieldName);

                Field field = aClass.getDeclaredField( fieldName );
                field.setAccessible( true );
                field.set( instance, fieldValue );
            }

            return instance;
        } else {
            if ( "int".equals( type ) ) {
                Number number = ( Number ) value;
                return number.intValue();
            } else if ( "float".equals( type ) ) {
                Number number = ( Number ) value;
                return number.floatValue();
            } else if ( "long".equals( type ) ) {
                Number number = ( Number ) value;
                return number.longValue();
            } else if ( "double".equals( type ) ) {
                Number number = ( Number ) value;
                return number.doubleValue();
            }
            return value;
        }
    }

}
