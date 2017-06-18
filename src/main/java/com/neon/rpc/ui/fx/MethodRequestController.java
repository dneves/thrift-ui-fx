package com.neon.rpc.ui.fx;

import com.neon.rpc.gen.ClassNameBuilder;
import com.neon.rpc.gen.JsonToObjects;
import com.neon.rpc.gen.MethodToJson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.irenical.fetchy.Fetchy;
import org.irenical.fetchy.Node;
import org.irenical.fetchy.connector.Connector;
import org.irenical.fetchy.connector.thrift.ThriftConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class MethodRequestController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger( MethodRequestController.class );

    @FXML private TextField txtServiceAddress;
    @FXML private TextField txtServicePort;

    @FXML private TextArea txtRequest;
    @FXML private TextArea txtResponse;

    @FXML private Button buttonExecute;


    private final MethodToJson methodToJson = new MethodToJson();
    private final JsonToObjects jsonToObjects = new JsonToObjects();


    private final TreeMethodItemHolder treeMethodItemHolder;

    private final Pane view;

    public MethodRequestController( TreeMethodItemHolder treeMethodItemHolder ) throws IOException {
        this.treeMethodItemHolder = treeMethodItemHolder;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController( this );
        view = fxmlLoader.load(getClass().getResourceAsStream("/fxml/method-request.fxml"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonExecute.setGraphic( new ImageView( new Image("/images/play-12x12.png") ));
        buttonExecute.setDisable( true );
        buttonExecute.setOnAction(event -> {
            String serviceAddress = txtServiceAddress.getText();
            if ( serviceAddress == null || serviceAddress.trim().isEmpty() ) {
                LOGGER.error( "no service address" );
                return ;
            }
            String txtServicePort = this.txtServicePort.getText();
            if ( txtServicePort == null || txtServicePort.trim().isEmpty() ) {
                LOGGER.error( "no service port" );
                return ;
            }
            int servicePort;
            try {
                servicePort = Integer.parseInt(txtServicePort);
            } catch ( NumberFormatException e ) {
                LOGGER.error( "invalid service port" );
                return ;
            }

            executeThrift( treeMethodItemHolder, serviceAddress, servicePort );
        });

        txtRequest.setText( toJson( treeMethodItemHolder.getMethod() ) );

        txtServiceAddress.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonExecute.setDisable( ! validateForExecute( newValue, txtServicePort.getText() ) );
        });
        txtServicePort.textProperty().addListener((observable, oldValue, newValue) -> {
            buttonExecute.setDisable( ! validateForExecute( txtServiceAddress.getText(), newValue ) );
        });
    }


    private boolean validateForExecute( String address, String port ) {
        boolean hasPort = port != null && ! port.trim().isEmpty();
        boolean hasAddress = address != null && ! address.trim().isEmpty();
        return hasAddress && hasPort;
    }

    public Pane getView() {
        return view;
    }

    private String toJson( Method method ) {
        if ( method == null ) {
            return null;
        }

        try {
            return methodToJson.generate(method);
        } catch (InstantiationException | IllegalAccessException e) {
            LOGGER.error( e.getLocalizedMessage(), e );
        }
        return "";
    }



    private void executeThrift( TreeMethodItemHolder methodItemHolder, String serviceAddress, int servicePort ) {
        Method method = methodItemHolder.getMethod();

        String serviceClassName = ClassNameBuilder.create( methodItemHolder.getServiceName() )
                .withNamespace( methodItemHolder.getNamespace() )
                .build();
        String clientClass = serviceClassName + MainController.ThriftConstants.CLIENT;

        try {
            Class<?> clientType = methodItemHolder.getClassLoader().loadClass( clientClass );

            Object[] arguments = jsonToObjects.create( methodItemHolder.getClassLoader(), txtRequest.getText() );

            execute( serviceAddress, servicePort, clientType, new ThriftConnector<>( clientType ), method.getName(), arguments );

        } catch ( ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException e ) {
            LOGGER.error( e.getLocalizedMessage(), e );

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText( e.getLocalizedMessage() );
            alert.showAndWait();
        }
    }


    private void execute( String address, int port, Class< ? > service, Connector connector, String methodName, Object ... arguments ) {
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

            txtResponse.setText( output == null ? "" : output.toString() );

        } catch (Exception e) {
            LOGGER.error( e.getLocalizedMessage(), e );
        } finally {
            fetchy.stop();
        }
    }

}
