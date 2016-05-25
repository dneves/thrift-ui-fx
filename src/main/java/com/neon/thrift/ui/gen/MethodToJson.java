package com.neon.thrift.ui.gen;

import com.google.common.base.Defaults;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * [
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

 *********
 [
    {
        "name": "beanList",
        "type": "com.neon.thrift.ui.ExampleBean",
        "value": [ { "id": null, "limit": 0 }, { "id": null, "limit": 0 }, ... ]
    }
 ]
 */
public class MethodToJson {

    private final Gson gson = new GsonBuilder().serializeNulls().create();

    private final Gson gsonPretty = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public MethodToJson() {

    }

    public String generate(Method method ) throws InstantiationException, IllegalAccessException {
        return generate( method, true );
    }

    public String generate(Method method, boolean prettyPrint ) throws InstantiationException, IllegalAccessException {
        StringBuilder json = new StringBuilder( "[ " );

        Parameter[] parameters = method.getParameters();
        for ( int i = 0; i < parameters.length; i++ ) {
            Parameter parameter = parameters[i];

            String pharzed = pharzeParameter(parameter);
            json.append( pharzed );

            if ( i < parameters.length - 1 ) {
                json.append( ", " );
            }
        }

        json.append( " ]" );

        if ( prettyPrint ) {
            Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
            List<Map<String, Object>> objects = gson.fromJson( json.toString(), type);
            return gsonPretty.toJson( objects, type );
        }

        return json.toString();
    }

    /**
     * Each parameter is an object.
     */
    private String pharzeParameter( Parameter parameter ) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = parameter.getType();
        Type parameterizedType = parameter.getParameterizedType();

        return generate( parameter, clazz, parameterizedType, true );
    }

    /**
     * This should always return an object for the given parameter.
     * { name: "", type: "", value: }
     *
     * value: null
     * value: 0
     * value: { "id": null, "limit": 0 }
     * value: [ 0 ]
     * value: [ { "id": null, "limit": 0 }, { "id": null, "limit": 0 }, ... ]
     */
    private String generate(Parameter parameter, Class< ? > clazz, Type parameterizedType, boolean decorate ) throws IllegalAccessException, InstantiationException {
        StringBuilder json = new StringBuilder();

        if ( decorate ) {
            json.append("{ ");
        }

        if ( decorate ) {
            json.append("\"name\": ")
                    .append("\"").append(parameter.getName()).append("\"");
        }

        if ( clazz.isPrimitive() || clazz == String.class ) {
//            its a primitive type - got default value

            if ( decorate ) {
                json.append(", \"type\": ")
                        .append("\"").append(clazz.getCanonicalName()).append("\"");
                json.append(", \"value\": ");
            }
            json.append( Defaults.defaultValue( clazz ) );

        } else {

            if ( clazz == List.class || clazz == Set.class ) {
                Type[] typeArguments = ((ParameterizedTypeImpl) parameterizedType).getActualTypeArguments();
                Type typeArgument = typeArguments[0];
                Class< ? > aClass = ( Class< ? > ) typeArgument;

                if ( decorate ) {
                    json.append(", \"type\": ")
                            .append("\"").append(aClass.getCanonicalName()).append("\"");
                    json.append(", \"value\": ");
                    json.append("[ ");
                }
                json.append( generate( parameter, aClass, typeArgument, false ) );
                if ( decorate ) {
                    json.append(" ]");
                }

            } else if ( clazz == Map.class ) {
                Type[] typeArguments = ((ParameterizedTypeImpl) parameterizedType).getActualTypeArguments();
                Type typeArgument = typeArguments[1];
                Class< ? > aClass = ( Class< ? > ) typeArgument;

                if ( decorate ) {
                    json.append(", \"type\": ")
                            .append("\"").append(aClass.getCanonicalName()).append("\"");
                    json.append(", \"value\": ");
                    json.append("{ ");
                    json.append( "\"map-key\": " );
                }
                json.append( generate( parameter, aClass, typeArgument, false ) );
                if ( decorate ) {
                    json.append(" }");
                }

            } else {
                Object instance = clazz.newInstance();
                String toJson = gson.toJson(instance, parameterizedType);

                if ( decorate ) {
                    json.append(", \"type\": ")
                            .append("\"").append(clazz.getCanonicalName()).append("\"");
                    json.append(", \"value\": ");
                }
                json.append( toJson );
            }
        }

        if ( decorate ) {
            json.append(" }");
        }

        return json.toString();
    }

}
