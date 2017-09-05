package com.neon.rpc.ui.fx;

import com.neon.rpc.ui.fx.request.MethodToRequest;
import com.neon.rpc.ui.fx.request.RequestExecutor;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TestMethodLayout extends Application {

    public static void main( String ... args ) {
        launch( args );
    }

    public TestMethodLayout() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        MethodRequestController methodRequestController = new MethodRequestController(
                new MethodToRequest() {
                    @Override
                    public String get() throws Exception {
                        return null;
                    }
                }, new RequestExecutor() {
            @Override
            public String execute(String host, int port, String request) {
                return null;
            }
        }
        );

        Pane view = methodRequestController.getView();

        Scene scene = new Scene( view );
        scene.getStylesheets().add( "/styles/styles.css" );

        stage.setTitle( "Method Request Layout" );
        stage.setScene(scene);
        stage.setMaximized( true );
        stage.setResizable( true );
        stage.show();

    }

}
