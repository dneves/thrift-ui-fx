package com.neon.rpc.gen;

public class ClassNameBuilder {

    private final String serviceName;

    private String namespace;

    private ClassNameBuilder( String serviceName ) {
        if ( serviceName == null || serviceName.trim().isEmpty() ) {
            throw new IllegalArgumentException( "serviceName cannot be null or empty" );
        }
        this.serviceName = serviceName;
    }

    public static ClassNameBuilder create( String serviceName ) {
        return new ClassNameBuilder( serviceName );
    }

    public ClassNameBuilder withNamespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    public String build() {
        return namespace == null ? serviceName : namespace + "." + serviceName;
    }

}
