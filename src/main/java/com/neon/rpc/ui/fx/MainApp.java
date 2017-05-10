package com.neon.rpc.ui.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start( Stage stage ) throws Exception {
        MainController mainController = new MainController( this );

        Scene scene = new Scene( mainController.getView() );
        scene.getStylesheets().add( "/styles/styles.css" );

        stage.setTitle( "Thrift UI" );
        stage.setScene(scene);
        stage.setMaximized( true );
        stage.setResizable( true );
        stage.show();
    }

}
