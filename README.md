[![Build Status](https://travis-ci.org/dneves/thrift-ui-fx.svg?branch=master)](https://travis-ci.org/dneves/thrift-ui-fx) [![codecov](https://codecov.io/gh/dneves/thrift-ui-fx/branch/master/graph/badge.svg)](https://codecov.io/gh/dneves/thrift-ui-fx)

# Thrift UI - JavaFX

Generic thrift client

## running

- install [https://thrift.apache.org/](https://thrift.apache.org/)

- clone project: 
git clone git@github.com:dneves/thrift-ui-fx.git

- run it:
```
cd rpc-ui-fx
mvn clean package
java -jar target/jfx/app/rpc-ui-fx-jfx.jar
```

#### grpc

For grpc, there needs to be an env variable set with the protoc-gen-grpc-java path

[//]: <> (http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22io.grpc%22%20a%3A%22protoc-gen-grpc-java%22)

[linux-x86_32.exe](http://search.maven.org/remotecontent?filepath=io/grpc/protoc-gen-grpc-java/1.7.0/protoc-gen-grpc-java-1.7.0-linux-x86_32.exe)
[linux-x86_64.exe](http://search.maven.org/remotecontent?filepath=io/grpc/protoc-gen-grpc-java/1.7.0/protoc-gen-grpc-java-1.7.0-linux-x86_64.exe)
[osx-x86_64.exe](http://search.maven.org/remotecontent?filepath=io/grpc/protoc-gen-grpc-java/1.7.0/protoc-gen-grpc-java-1.7.0-osx-x86_64.exe)
[windows-x86_32.exe](http://search.maven.org/remotecontent?filepath=io/grpc/protoc-gen-grpc-java/1.7.0/protoc-gen-grpc-java-1.7.0-windows-x86_32.exe)
[windows-x86_64.exe](http://search.maven.org/remotecontent?filepath=io/grpc/protoc-gen-grpc-java/1.7.0/protoc-gen-grpc-java-1.7.0-windows-x86_64.exe)

- run it:
```
java -Dprotoc-gen-grpc-java.path=<PLUGIN_PATH>/protoc-gen-grpc-java-1.7.<PLUGIN_PLATFORM>.exe -jar target/jfx/app/rpc-ui-fx-jfx.jar
```

## Author

Author:: Diogo Neves ( <a href="mailto:diogo.sousa.neves@gmail.com">diogo.sousa.neves@gmail.com</a> )

## Licence

The MIT License (MIT)

Copyright (c) 2017 Diogo Neves

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
