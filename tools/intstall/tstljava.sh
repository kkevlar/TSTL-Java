#!/bin/bash
mkdir lib
java -jar $HOME/.tstljava/tstljava.jar -p $PWD "$@"
javac -cp lib/commons-cli.jar -d genbin -sourcepath gensrc gensrc/TestRunner.java
WORKDIR=$PWD
SENDARG=${WORKDIR}/args.args
echo $SENDARG
java -cp lib/commons-cli.jar:genbin:. TestRunner $SENDARG
rm args.args
