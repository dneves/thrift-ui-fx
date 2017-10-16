package com.neon.rpc.ui.fx.request;

import com.neon.rpc.gen.grpc.GrpcJsonToMessage;
import com.neon.rpc.gen.grpc.model.Message;
import com.neon.rpc.gen.grpc.model.ServiceMethod;
import com.neon.rpc.ui.fx.tree.TreeGrpcMethodItemHolder;
import io.grpc.Channel;
import io.grpc.stub.AbstractStub;
import org.irenical.fetchy.Fetchy;
import org.irenical.fetchy.Node;
import org.irenical.fetchy.connector.grpc.GrpcConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

public class GrpcExecutor implements RequestExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger( GrpcExecutor.class );

    private final TreeGrpcMethodItemHolder methodItemHolder;

    public GrpcExecutor(TreeGrpcMethodItemHolder methodItemHolder) {
        this.methodItemHolder = methodItemHolder;
    }

    @Override
    public String execute(String host, int port, String request) throws Exception {
        ClassLoader classLoader = methodItemHolder.getClassLoader();
        String namespace = methodItemHolder.getNamespace();
        String serviceName = methodItemHolder.getServiceName();
        ServiceMethod method = methodItemHolder.getMethod();
        Map<String, Message> messages = methodItemHolder.getMessages();

        String serviceClass = serviceName + "Grpc";
        Class<?> C = classLoader.loadClass( namespace + "." + serviceClass );
        Method newBlockingStub = C.getMethod("newBlockingStub", Channel.class);

        String ifaceClass = serviceClass + "$" + serviceName + "BlockingStub";
        Class< ? extends AbstractStub< ? > > I = (Class<? extends AbstractStub<?>>)
                classLoader.loadClass( namespace + "." + ifaceClass );

        Class<?> M = classLoader.loadClass( namespace + "." + method.getMessage().getName());

        final GrpcJsonToMessage grpcJsonToMessage = new GrpcJsonToMessage(classLoader);

        Fetchy fetchy = new Fetchy();
        try {
            fetchy.start();
            fetchy.register("myService",
                    serviceId -> {
                        Node node = new Node(serviceId, host, port);
                        return Collections.singletonList(node);
                    },
                    list -> list.get(0), new GrpcConnector<>((Function<Channel, AbstractStub<?>>) channel -> {
                        try {
                            return (AbstractStub<?>) newBlockingStub.invoke( null, channel );
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            LOGGER.error( e.getLocalizedMessage(), e );
                        }
                        return null;
                    }, true) );

            Object output = fetchy.call("myService", I, client -> {
                Object message = grpcJsonToMessage.apply( request );

                Method sMethod = I.getMethod(method.getName(), M);
                return sMethod.invoke( client, message );
            } );

            return output == null ? "" : output.toString();
        } finally {
            fetchy.stop();
        }
    }

}
