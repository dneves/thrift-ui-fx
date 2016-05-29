package com.neon.thrift.ui.gen;

public class ClassNameBuilder {

    private String namespace;

    private String serviceName;

    private ClassNameBuilder() {

    }

    public static ClassNameBuilder create() {
        return new ClassNameBuilder();
    }

    public ClassNameBuilder withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public ClassNameBuilder withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String build() {
        return namespace == null ? serviceName : namespace + "." + serviceName;
    }

}
