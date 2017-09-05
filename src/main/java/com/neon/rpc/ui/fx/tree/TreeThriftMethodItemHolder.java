package com.neon.rpc.ui.fx.tree;

import java.lang.reflect.Method;

public class TreeThriftMethodItemHolder extends TreeItemHolder {

    private Method method;

    public TreeThriftMethodItemHolder(ClassLoader classLoader, String namespace, String serviceName, Method method) {
        super( classLoader, namespace, serviceName);
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }
}
