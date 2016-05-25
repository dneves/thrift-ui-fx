package com.neon.thrift.ui.fx;

import java.lang.reflect.Method;

public class TreeMethodItemHolder extends TreeItemHolder {

    private Method method;

    public TreeMethodItemHolder(ClassLoader classLoader, String namespace, String serviceName, Method method) {
        super( classLoader, namespace, serviceName);
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }
}
