package com.neon.rpc.ui.fx;

import com.neon.rpc.ui.fx.MethodRequestController;
import com.neon.rpc.ui.fx.TreeMethodItemHolder;
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

        TreeMethodItemHolder treeMethodItemHolder = new TreeMethodItemHolder( this.getClass().getClassLoader(), "com.neon.thrift", "UTest", null );

        MethodRequestController methodRequestController = new MethodRequestController(treeMethodItemHolder);

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
