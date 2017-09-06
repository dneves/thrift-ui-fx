package com.neon.rpc.ui.fx.request;

import com.neon.rpc.gen.ClassNameBuilder;
import com.neon.rpc.gen.JsonToObjects;
import com.neon.rpc.ui.fx.MainController;
import com.neon.rpc.ui.fx.tree.TreeThriftMethodItemHolder;
import javafx.scene.control.Alert;
import org.irenical.fetchy.Fetchy;
import org.irenical.fetchy.Node;
import org.irenical.fetchy.connector.Connector;
import org.irenical.fetchy.connector.thrift.ThriftConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Collections;

public class ThriftExecutor implements RequestExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger( ThriftExecutor.class );

    private final JsonToObjects jsonToObjects = new JsonToObjects();

    private final TreeThriftMethodItemHolder methodItemHolder;

    public ThriftExecutor(TreeThriftMethodItemHolder methodItemHolder) {
        this.methodItemHolder = methodItemHolder;
    }

    @Override
    public String execute( String serviceAddress, int servicePort, String request ) throws Exception {
        Method method = methodItemHolder.getMethod();

        String serviceClassName = ClassNameBuilder.create( methodItemHolder.getServiceName() )
                .withNamespace( methodItemHolder.getNamespace() )
                .build();
        String clientClass = serviceClassName + MainController.ThriftConstants.CLIENT;

        try {
            Class<?> clientType = methodItemHolder.getClassLoader().loadClass( clientClass );

            Object[] arguments = jsonToObjects.create( methodItemHolder.getClassLoader(), request );

            return execute( serviceAddress, servicePort, clientType, new ThriftConnector<>( clientType ), method.getName(), arguments );

        } catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException e ) {
            LOGGER.error( e.getLocalizedMessage(), e );

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText( e.getLocalizedMessage() );
            alert.showAndWait();
        }

        return null;
    }


    private String execute(String address, int port, Class< ? > service, Connector connector, String methodName, Object ... arguments ) {
        Fetchy fetchy = new Fetchy();
        try {
            fetchy.start();
            fetchy.register("myService",
                    serviceId -> {
                        Node node = new Node( serviceId, address, port );
                        return Collections.singletonList(node);
                    },
                    list -> list.get( 0 ), connector );

            Object output = fetchy.call("myService", service, client -> {
                Class<?> parameterTypes[] = new Class<?>[ arguments.length ];
                int i = 0;
                for (Object argument : arguments) {
                    parameterTypes[ i++ ] = argument.getClass(); // TODO : if nulls, nullpointer
                }
                Method method = service.getMethod( methodName, parameterTypes );
                return method.invoke(client, arguments);
            });

            return output == null ? "" : output.toString();

        } catch (Exception e) {
            LOGGER.error( e.getLocalizedMessage(), e );
//            TODO : display error message
        } finally {
            fetchy.stop();
        }
        return null;
    }

}
