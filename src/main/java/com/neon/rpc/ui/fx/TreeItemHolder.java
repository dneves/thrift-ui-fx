package com.neon.rpc.ui.fx;

public abstract class TreeItemHolder {

    private final ClassLoader classLoader;

    private final String namespace;

    private final String serviceName;

    public TreeItemHolder(ClassLoader classLoader, String namespace, String serviceName) {
        this.classLoader = classLoader;
        this.namespace = namespace;
        this.serviceName = serviceName;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getServiceName() {
        return serviceName;
    }
}
