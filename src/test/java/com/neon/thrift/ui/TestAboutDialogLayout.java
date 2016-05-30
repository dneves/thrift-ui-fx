package com.neon.thrift.ui;

import com.neon.thrift.ui.fx.AboutDialog;
import javafx.application.Application;
import javafx.stage.Stage;
import org.irenical.jindy.ConfigFactory;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestAboutDialogLayout extends Application {

    public static void main( String ... args ) {
        ConfigFactory.getConfig().setProperty( "version", "dummy-version" );
        ConfigFactory.getConfig().setProperty( "build.date",
                ZonedDateTime.now().format( DateTimeFormatter.ofPattern( "yyyy-MM-dd HH:mm:ss" ) ) );
        launch( args );
    }

    public TestAboutDialogLayout() {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AboutDialog dialog = new AboutDialog(getHostServices());
        dialog.showAndWait();
    }

}
