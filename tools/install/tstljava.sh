#!/bin/bash
java -jar $HOME/.tstljava/tstljava.jar -p $PWD "$@"
if [ $(cat $HOME/.tstljava/washelp.yes) = true ] ; then
exit
fi
CCP=$(cat $HOME/.tstljava/cp.cfg)
if [ $(cat $HOME/.tstljava/skipcompile.yes) = false ] ; then
javac -cp lib/commons-cli.jar:lib/commons-lang.jar$CCP -d genbin -sourcepath gensrc gensrc/TestRunner.java
fi
if [ $(cat $HOME/.tstljava/wantscc.yes) = true ] ; then
java -noverify -jar lib/emma.jar -cp lib/commons-cli.jar:lib/commons-lang.jar:genbin:.$CCP -ix $(cat $HOME/.tstljava/cc.cfg) TestRunner
exit
fi
java -cp lib/commons-cli.jar:genbin:.$CCP TestRunner
