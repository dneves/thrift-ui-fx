package com.neon.rpc.ui.fx.request;

import com.neon.rpc.gen.MethodToJson;
import com.neon.rpc.ui.fx.tree.TreeThriftMethodItemHolder;

import java.lang.reflect.Method;

public class ThriftMethodToRequest implements MethodToRequest {

    private final MethodToJson methodToJson = new MethodToJson();

    private final TreeThriftMethodItemHolder itemHolder;

    public ThriftMethodToRequest(TreeThriftMethodItemHolder itemHolder) {
        this.itemHolder = itemHolder;
    }

    @Override
    public String get() throws Exception {
        Method method = itemHolder.getMethod();
        if ( method == null ) {
            return null;
        }

        return methodToJson.generate(method);
    }

}
