package com.neon.rpc.ui.fx.tree;

import com.neon.rpc.gen.grpc.model.Message;
import com.neon.rpc.gen.grpc.model.ServiceMethod;

import java.util.Map;

public class TreeGrpcMethodItemHolder extends TreeItemHolder {

    private final Map< String, Message> messages;

    private final ServiceMethod method;

    public TreeGrpcMethodItemHolder(ClassLoader classLoader, String namespace, String serviceName, ServiceMethod method,
                                    Map< String, Message> messages ) {
        super(classLoader, namespace, serviceName);
        this.method = method;
        this.messages = messages;
    }

    public ServiceMethod getMethod() {
        return method;
    }

    public Map<String, Message> getMessages() {
        return messages;
    }
}
