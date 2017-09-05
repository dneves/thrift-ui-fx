package com.neon.rpc.ui.fx.request;

@FunctionalInterface
public interface MethodToRequest {

    String get() throws Exception;

}
