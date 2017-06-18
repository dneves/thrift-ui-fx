package com.neon.rpc.gen.grpc.model;

import java.util.HashMap;
import java.util.Map;

public class Service {

    private String name;

    private Map< String, ServiceMethod > methods;

    public Service() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ServiceMethod> getMethods() {
        return methods;
    }

    public void setMethods(Map<String, ServiceMethod> methods) {
        this.methods = methods;
    }

    public void addMethod( ServiceMethod method ) {
        if ( methods == null ) {
            methods = new HashMap<>();
        }
        methods.put( method.getName().toLowerCase(), method );
    }
}
