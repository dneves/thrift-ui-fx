package com.neon.thrift.ui.fx;

import com.neon.thrift.ui.gen.ClassNameBuilder;
import com.neon.thrift.ui.gen.NamespaceFinder;
import com.neon.thrift.ui.gen.ServiceNameFinder;
import com.neon.thrift.ui.gen.ThriftCodeGenerator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.StringConverter;
import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler;
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl;
import org.irenical.jindy.Config;
import org.irenical.jindy.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class MainController implements Initializable {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private final Config CONFIG = ConfigFactory.getConfig();

    interface ThriftConstants {
        String IFACE = "$Iface";
        String CLIENT = "$Client";
    }

    @FXML private Button buttonAddContract;
    @FXML private TreeView< TreeItemHolder > treeMethodExplorer;

    @FXML private TabPane tabPane;

    private final Pane view;

    public MainController() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController( this );
        view = fxmlLoader.load(getClass().getResourceAsStream("/fxml/layout.fxml"));
    }

    public Pane getView() {
        return view;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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


        MenuItem treeAddContractMenuItem = new MenuItem( "Add Contract" );
        treeAddContractMenuItem.setOnAction(event -> {
            File fileContract = chooseContractFile( treeMethodExplorer.getScene().getWindow() );
            generateContractSources( fileContract.getAbsolutePath() );

        });
        ContextMenu treeContextMenu = new ContextMenu( treeAddContractMenuItem );
        treeMethodExplorer.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if ( event.getButton() == MouseButton.SECONDARY ) {
                treeContextMenu.show( treeMethodExplorer, event.getScreenX(), event.getScreenY() );
            }
        });

        buttonAddContract.setOnAction(event -> treeAddContractMenuItem.fire());
        buttonAddContract.setTooltip( new Tooltip( "Add Contract" ) );

//        TODO : start page pane
        VBox vBox = new VBox( 10 );
        vBox.alignmentProperty().setValue( Pos.CENTER );
        vBox.getChildren().add( new Label( "version: " + CONFIG.getString( "version" ) ) );
        vBox.getChildren().add( new Label( "this time is ok" ) );

        Tab tab = new Tab("Start Page", vBox);
        tab.setClosable( false );
        tabPane.getTabs().add(tab);
    }

    private File chooseContractFile( Window window ) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle( "Choose thrift contract" );
        fileChooser.setSelectedExtensionFilter( new FileChooser.ExtensionFilter( "thrift file", "thrift" ) );
        return fileChooser.showOpenDialog( window );
    }

    private void generateContractSources( String fileContractPath ) {
//        find the service name throught thrift contract
        new ServiceNameFinder().apply(fileContractPath).ifPresent(serviceName -> {
            try {
//                generate thrift sources
                Path pathContractSources = new ThriftCodeGenerator().generate(serviceName, fileContractPath);

//                get sources namespace
                String namespace = new NamespaceFinder().apply(fileContractPath).orElse(null);

//                compile generated sources
                ClassLoader classLoader = compileContractSources( pathContractSources, namespace );

//                do stuff with the generated sources
                onContractSourcesGenerated( namespace, serviceName, classLoader );
            } catch (IOException | InterruptedException e) {
                LOGGER.error( e.getLocalizedMessage(), e );
            }
        });
    }

    private ClassLoader compileContractSources( Path pathContractSources, String namespace ) throws IOException {
        JavaSourceCompilerImpl javaSourceCompiler = new JavaSourceCompilerImpl();

        JavaSourceCompiler.CompilationUnit compilationUnit = javaSourceCompiler.createCompilationUnit( pathContractSources.toFile() );

        traverse( pathContractSources, namespace, compilationUnit );

//        compile with -parameters to get their names
        return javaSourceCompiler.compile( compilationUnit, "-parameters", "-parameters" );
    }


    private void traverse( Path path, String namespace, JavaSourceCompiler.CompilationUnit compilationUnit ) throws IOException {
        Files.list( path )
                .forEach(path1 -> {
                    if ( path1.toFile().isDirectory() ) {
                        try {
                            traverse(path1, namespace, compilationUnit );
                        } catch (IOException e) {
                            LOGGER.error( e.getLocalizedMessage(), e );
                        }
                    } else {
                        try {
                            String fullClassName = ClassNameBuilder.create()
                                    .withNamespace( namespace )
                                    .withServiceName( path1.getFileName().toString().replace( ".java", "" ) )
                                    .build();

                            BufferedReader bufferedReader = Files.newBufferedReader(path1);
                            String source = bufferedReader.lines().collect( Collectors.joining( "\n" ) );

                            compilationUnit.addJavaSource( fullClassName, source );
                        } catch (IOException e) {
                            LOGGER.error( e.getLocalizedMessage(), e );
                        }
                    }
                });
    }


    private void onContractSourcesGenerated( String namespace, String serviceName, ClassLoader classLoader ) {
//        get service full classname (package.servicename)
        String serviceClassName = ClassNameBuilder.create()
                .withNamespace( namespace )
                .withServiceName( serviceName )
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
        }
    }

}
