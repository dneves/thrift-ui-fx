package com.neon.rpc.gen;

import org.abstractmeta.toolbox.compilation.compiler.JavaSourceCompiler;
import org.abstractmeta.toolbox.compilation.compiler.impl.JavaSourceCompilerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class JavaCompiler {

    private static final Logger LOGGER = LoggerFactory.getLogger( JavaCompiler.class );

    public JavaCompiler() {

    }

    public ClassLoader compile( Path pathSources, String namespace ) throws IOException {
        JavaSourceCompilerImpl javaSourceCompiler = new JavaSourceCompilerImpl();

        JavaSourceCompiler.CompilationUnit compilationUnit = javaSourceCompiler.createCompilationUnit( pathSources.toFile() );

        traverse( pathSources, namespace, compilationUnit );

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
                            String fullClassName = ClassNameBuilder.create( path1.getFileName().toString().replace( ".java", "" ) )
                                    .withNamespace( namespace )
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
}
