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
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
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

            executeRequest( treeMethodItemHolder, serviceAddress, servicePort );
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


    private void executeRequest( TreeMethodItemHolder methodItemHolder, String serviceAddress, int servicePort ) {
        Method method = methodItemHolder.getMethod();

        String serviceClassName = ClassNameBuilder.create( methodItemHolder.getServiceName() )
                .withNamespace( methodItemHolder.getNamespace() )
                .build();
        String clientClass = serviceClassName + MainController.ThriftConstants.CLIENT;

        TProtocol protocol = null;
        try {
            Class<?> clientType = methodItemHolder.getClassLoader().loadClass( clientClass );

            TTransport tTransport = new TFramedTransport( new TSocket( serviceAddress, servicePort ) );
            protocol = new TBinaryProtocol( tTransport );
            Constructor<?> constructor = clientType.getConstructor(TProtocol.class);

            Object instance = constructor.newInstance(protocol);
            open( protocol );

            Object[] arguments = jsonToObjects.create( methodItemHolder.getClassLoader(), txtRequest.getText() );
            Object output = method.invoke(instance, arguments);

//            get a response format ( thrift implements a simple toString() )
            txtResponse.setText( output == null ? "" : output.toString() );

        } catch (ClassNotFoundException | NoSuchMethodException | TTransportException | IllegalAccessException
                | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            LOGGER.error( e.getLocalizedMessage(), e );

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText( e.getLocalizedMessage() );
            alert.showAndWait();

        } finally {
            close( protocol );
        }
    }

    private void open( TProtocol protocol ) throws TTransportException {
        if ( protocol != null ) {
            TTransport transport = protocol.getTransport();
            if ( transport != null && ! transport.isOpen() ) {
                transport.open();
            }
        }
    }

    private void close( TProtocol protocol ) {
        if ( protocol != null ) {
            TTransport transport = protocol.getTransport();
            if ( transport != null && transport.isOpen() ) {
                transport.close();
            }
        }
    }

}
