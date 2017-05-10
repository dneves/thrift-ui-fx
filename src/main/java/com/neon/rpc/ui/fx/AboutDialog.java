package com.neon.rpc.ui.fx;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.irenical.jindy.ConfigFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AboutDialog extends Dialog< Void > implements Initializable {

    @FXML private Label labelVersionNumber;

    @FXML private Label labelBuildDate;

    @FXML private Hyperlink linkUrl;

    private final HostServices hostServices;


    public AboutDialog(HostServices hostServices) throws IOException {
        this.hostServices = hostServices;

        setTitle( "About" );
        setHeaderText( null );
        setResizable( false );

        getDialogPane().getButtonTypes().addAll( ButtonType.OK );

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController( this );
        Pane aboutContentPane = fxmlLoader.load(getClass().getResourceAsStream("/fxml/about.fxml"));

        getDialogPane().setContent( aboutContentPane );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelVersionNumber.setText( ConfigFactory.getConfig().getString( "version", "" ) );

        labelBuildDate.setText( ConfigFactory.getConfig().getString( "build.date", "" ) );

        linkUrl.setOnAction(event -> hostServices.showDocument( linkUrl.getText() ));
    }

}
