#!/bin/bash
DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )
cd $DIR
sudo cp tstljava.sh /usr/bin/tstljava.sh
sudo mv /usr/bin/tstljava.sh /usr/bin/tstljava
mkdir -p $HOME/.tstljava/
cp tstljava.jar $HOME/.tstljava/tstljava.jar
sudo chmod -R 777 $HOME/.tstljava/
sudo chmod 777 /usr/bin/tstljava
