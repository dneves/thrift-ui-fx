package com.neon.rpc.ui.fx;

import com.neon.rpc.ui.fx.request.MethodToRequest;
import com.neon.rpc.ui.fx.request.RequestExecutor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MethodRequestController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger( MethodRequestController.class );

    @FXML private TextField txtServiceAddress;
    @FXML private TextField txtServicePort;

    @FXML private TextArea txtRequest;
    @FXML private TextArea txtResponse;

    @FXML private Button buttonExecute;

    private final MethodToRequest toRequest;

    private final RequestExecutor requestExecutor;

    private final Pane view;


    public MethodRequestController( MethodToRequest toRequest, RequestExecutor requestExecutor ) throws IOException {
        this.toRequest = toRequest;
        this.requestExecutor = requestExecutor;

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
//                TODO : display error message
                return ;
            }
            String txtServicePort = this.txtServicePort.getText();
            if ( txtServicePort == null || txtServicePort.trim().isEmpty() ) {
                LOGGER.error( "no service port" );
//                TODO : display error message
                return ;
            }
            int servicePort;
            try {
                servicePort = Integer.parseInt(txtServicePort);
            } catch ( NumberFormatException e ) {
                LOGGER.error( "invalid service port" );
//                TODO : display error message
                return ;
            }

            try {
                String output = requestExecutor.execute( serviceAddress, servicePort, txtRequest.getText() );
                txtResponse.setText( output );
            } catch (Exception e) {
                LOGGER.error( e.getLocalizedMessage(), e );
//                TODO : display error message
            }
        });

        try {
            txtRequest.setText( toRequest.get() );
        } catch (Exception e) {
            LOGGER.error( e.getLocalizedMessage(), e );
//            TODO : display error message
        }

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

}
