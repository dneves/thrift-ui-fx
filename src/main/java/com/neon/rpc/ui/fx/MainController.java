package com.neon.rpc.ui.fx;

import com.neon.rpc.gen.ClassNameBuilder;
import com.neon.rpc.gen.JavaCompiler;
import com.neon.rpc.gen.thrift.ThriftNamespaceFinder;
import com.neon.rpc.gen.thrift.ThriftServiceNameFinder;
import com.neon.rpc.gen.CodeGenerator;
import com.neon.rpc.gen.thrift.ThriftCommand;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.StringConverter;
import org.irenical.jindy.Config;
import org.irenical.jindy.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tbee.javafx.scene.layout.MigPane;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class MainController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final Config CONFIG = ConfigFactory.getConfig();

    interface ThriftConstants {
        String IFACE = "$Iface";
        String CLIENT = "$Client";
    }

    @FXML private VBox root;

    @FXML private MenuBar menuBar;

    @FXML private MigPane container;

    @FXML private Button buttonAddContract;
    @FXML private TreeView< TreeItemHolder > treeMethodExplorer;

    @FXML private TabPane tabPane;


    private final Pane view;

    private Dialog< Void > dialogAbout = null;

    private final Application application;

    public MainController( Application application ) throws IOException {
        this.application = application;

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController( this );
        view = fxmlLoader.load(getClass().getResourceAsStream("/fxml/layout.fxml"));
    }

    public Pane getView() {
        return view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox.setVgrow( container, Priority.ALWAYS );

        treeMethodExplorer.setCellFactory(root -> new TextFieldTreeCell<>(new StringConverter< TreeItemHolder>() {
            @Override
            public String toString( TreeItemHolder itemHolder) {
                if ( itemHolder instanceof TreeServiceItemHolder ) {
                    return itemHolder.getServiceName();
                } else if ( itemHolder instanceof TreeMethodItemHolder ) {
                    return ((TreeMethodItemHolder) itemHolder).getMethod().getName();
                }
                return null;
            }

            @Override
            public TreeItemHolder fromString(String string) {
                LOGGER.debug( "fromString: " + string );
                return new TreeServiceItemHolder(null, null, string);
            }
        }));

        treeMethodExplorer.setOnMouseClicked(event -> {
            if ( event.getClickCount() == 2 && event.getButton() == MouseButton.PRIMARY ) {
                TreeItem< TreeItemHolder > item = treeMethodExplorer.getSelectionModel().getSelectedItem();
                if ( item != null ) {
                    Object value = item.getValue();
                    if (value instanceof TreeMethodItemHolder) {
                        onMethodChoosed((TreeMethodItemHolder) value);
                    }
                }
            }
        });

        treeMethodExplorer.setRoot( new TreeItem<>() );
        treeMethodExplorer.setShowRoot( false );


        MenuItem addContractMenuItem = new MenuItem( "Add Contract", new ImageView( new Image("/images/add-8x8.png") ) );
        addContractMenuItem.setOnAction(event -> {
            File fileContract = chooseContractFile( treeMethodExplorer.getScene().getWindow() );
            if ( fileContract == null ) {
                return ;
            }

            processFileContract( fileContract );
        });
        ContextMenu treeContextMenu = new ContextMenu( addContractMenuItem );
        treeMethodExplorer.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if ( event.getButton() == MouseButton.SECONDARY ) {
                treeContextMenu.show( treeMethodExplorer, event.getScreenX(), event.getScreenY() );
            }
        });

        buttonAddContract.setOnAction(event -> addContractMenuItem.fire());
        buttonAddContract.setTooltip( new Tooltip( "Add Contract" ) );


//        menu bar items
        Menu file = new Menu( "File" );

        MenuItem itemAddContract = new MenuItem( "Add Contract", new ImageView( new Image("/images/add-8x8.png") ) );
        itemAddContract.setOnAction(event -> addContractMenuItem.fire());

        file.getItems().add( itemAddContract );
        file.getItems().add( new SeparatorMenuItem() );

        MenuItem close = new MenuItem( "Close", new ImageView( new Image("/images/dialog_cancel-12x12.png") ) );
        close.setOnAction(event -> Platform.exit());
        file.getItems().add( close );

        MenuItem aboutItem = new MenuItem( "About", new ImageView( new Image("/images/info-12x12.png") ) );
        aboutItem.setOnAction(event -> onAboutAction());

        Menu help = new Menu( "Help" );
        help.getItems().add( aboutItem );

        menuBar.getMenus().addAll( file, help );


//        start page tab
//        TODO : start page pane
        VBox vBox = new VBox( 10 );
        vBox.alignmentProperty().setValue( Pos.CENTER );
        vBox.getChildren().add( new Label( "version: " + CONFIG.getString( "version" ) ) );

        Tab tab = new Tab("Start", vBox);
        tab.setClosable( false );
        tabPane.getTabs().add(tab);
    }

    private void onAboutAction() {
        if ( dialogAbout == null ) {
            try {
                dialogAbout = new AboutDialog( application.getHostServices() );
            } catch (IOException e) {
                LOGGER.error( e.getLocalizedMessage(), e );
//                TODO : display error message
            }
        }

        if ( dialogAbout != null ) {
            dialogAbout.showAndWait();
        }
    }

    private File chooseContractFile( Window window ) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle( "Choose thrift contract" );
        fileChooser.setSelectedExtensionFilter( new FileChooser.ExtensionFilter( "thrift file", "thrift" ) );
        return fileChooser.showOpenDialog( window );
    }

    private void processFileContract( File file ) {
        boolean isThrift = file.getName().endsWith(".thrift");
        boolean isProto = ! isThrift && file.getName().endsWith(".proto");

        if ( isThrift ) {
            try {
                generateContractSources(file.getAbsolutePath());
            } catch (IOException e) {
                LOGGER.error(e.getLocalizedMessage(), e);
//                TODO : display error message
            }
        } else if ( isProto ) {
//            TODO : handle proto files

        } else {
            LOGGER.warn( "unable to process file: " + file.getAbsolutePath() + " - unknown type" );
//            TODO : display warning message
        }
    }

    private void generateContractSources( String fileContractPath ) throws IOException {
//        TODO : add loading info

        //        find the service name throught thrift contract
        new ThriftServiceNameFinder().apply( readContractFile( fileContractPath ) ).ifPresent(serviceName -> {
            try {
//                generate thrift sources
                Path pathContractSources = new CodeGenerator( new ThriftCommand() ).generate(serviceName, fileContractPath);

//                get sources namespace
                String namespace = new ThriftNamespaceFinder().apply( readContractFile( fileContractPath ) ).orElse(null);

//                compile generated sources
                ClassLoader classLoader = new JavaCompiler().compile( pathContractSources, namespace );

//                do stuff with the generated sources
                onSourcesCompiled( namespace, serviceName, classLoader );
            } catch (IOException | InterruptedException e) {
                LOGGER.error( e.getLocalizedMessage(), e );
//                TODO : display error message
            }
        });
    }

    private Stream< String > readContractFile(String fileContractPath ) throws IOException {
        return Files.lines( Paths.get( fileContractPath ) );
    }

    private void onSourcesCompiled(String namespace, String serviceName, ClassLoader classLoader ) {
//        get service full classname (package.servicename)
        String serviceClassName = ClassNameBuilder.create( serviceName )
                .withNamespace( namespace )
                .build();

        try {
//            load service class
            String iFace = serviceClassName + ThriftConstants.IFACE;
            Class<?> anIface = classLoader.loadClass( iFace );

            TreeItem< TreeItemHolder > itemService = new TreeItem<>(
                    new TreeServiceItemHolder( classLoader, namespace, serviceName ) );
            itemService.setExpanded( true );

            Method[] methods = anIface.getMethods();
            Arrays.sort(methods, (o1, o2) -> o1.getName().compareTo( o2.getName() ));
            for (Method method : methods) {
                TreeItem< TreeItemHolder > itemServiceInterfaceMethod = new TreeItem<>(
                        new TreeMethodItemHolder( classLoader, namespace, serviceName, method ) );
                itemService.getChildren().add( itemServiceInterfaceMethod );
            }

            treeMethodExplorer.getRoot().getChildren().add( itemService );
        } catch (ClassNotFoundException e) {
            LOGGER.error( e.getLocalizedMessage(), e );
//                TODO : display error message
        }
    }

    private void onMethodChoosed( TreeMethodItemHolder treeMethodItemHolder ) {
        try {
            MethodRequestController methodRequestController = new MethodRequestController(treeMethodItemHolder);

            String tabName = treeMethodItemHolder.getServiceName() + "." + treeMethodItemHolder.getMethod().getName();
            Tab tab = new Tab(tabName, methodRequestController.getView());
            tabPane.getTabs().add(tab);
            tabPane.getSelectionModel().select( tab );
        } catch (IOException e) {
            LOGGER.error( e.getLocalizedMessage(), e );
//                TODO : display error message
        }
    }

}
