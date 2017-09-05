package com.neon.rpc.ui.fx.request;

@FunctionalInterface
public interface RequestExecutor {

    String execute( String host, int port, String request );

}
