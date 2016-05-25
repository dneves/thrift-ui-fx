package com.neon.thrift.ui.fx;

public class FullClassNameFunction {

    public String get( String namespace, String serviceName ) {
        return namespace == null ? serviceName : namespace + "." + serviceName;
    }

}
