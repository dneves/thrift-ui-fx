package com.neon.rpc.ui.fx.request;

import com.neon.rpc.ui.fx.tree.TreeGrpcMethodItemHolder;

public class GrpcExecutor implements RequestExecutor {

    private final TreeGrpcMethodItemHolder methodItemHolder;

    public GrpcExecutor(TreeGrpcMethodItemHolder methodItemHolder) {
        this.methodItemHolder = methodItemHolder;
    }

    @Override
    public String execute(String host, int port, String request) {
//        TODO :
        throw new UnsupportedOperationException( "TODO" );
    }

}
