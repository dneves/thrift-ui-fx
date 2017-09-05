package com.neon.rpc.ui.fx.request;

import com.google.gson.JsonElement;
import com.neon.rpc.gen.JsonIntegerFix;
import com.neon.rpc.gen.JsonPrettyPrinter;
import com.neon.rpc.gen.JsonPrinter;
import com.neon.rpc.gen.grpc.FieldToJson;
import com.neon.rpc.gen.grpc.MessageToJson;
import com.neon.rpc.gen.grpc.ServiceMethodToJson;
import com.neon.rpc.ui.fx.tree.TreeGrpcMethodItemHolder;

public class GrpcMethodToRequest implements MethodToRequest {

    private final TreeGrpcMethodItemHolder itemHolder;

    public GrpcMethodToRequest(TreeGrpcMethodItemHolder itemHolder) {
        this.itemHolder = itemHolder;
    }

    @Override
    public String get() throws Exception {
        JsonElement element = new ServiceMethodToJson(new MessageToJson(new FieldToJson()))
                .apply(itemHolder.getMessages(), itemHolder.getMethod());

        return new JsonIntegerFix().apply( new JsonPrettyPrinter().apply( new JsonPrinter().apply( element ) ) );
    }

}
