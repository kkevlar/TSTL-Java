#!/bin/bash
mkdir -p lib
java -jar $HOME/.tstljava/tstljava.jar -p $PWD "$@"
javac -cp lib/commons-cli.jar -d genbin -sourcepath gensrc gensrc/TestRunner.java
java -cp lib/commons-cli.jar:genbin:. TestRunner
