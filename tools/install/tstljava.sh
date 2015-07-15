#!/bin/bash
java -jar $HOME/.tstljava/tstljava.jar -p $PWD "$@"
if [ $(cat $HOME/.tstljava/washelp.cfg) = true ] ; then
exit
fi
CCP=$(cat $HOME/.tstljava/cp.cfg)
echo $CCP
echo lib/commons-cli.jar:genbin:.$CCP
javac -cp lib/commons-cli.jar$CCP -d genbin -sourcepath gensrc gensrc/TestRunner.java
java -cp lib/commons-cli.jar:genbin:.$CCP TestRunner
