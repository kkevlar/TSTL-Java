#!/usr/bin/env bash
cd ..
OLD=$PWD
rm -rf src/res
rm -rf bin
rm names.file
rm -rf genbin
rm -rf gensrc
rm tester-output.log
rm test-reduced.log
mkdir src/res
for file in src/*.java
do
  var=${file##*/}
  cp "$file" "src/res/${var}"
done

for file in src/res/*.java
do
  var=${file##*/}
echo $var
echo  $var >> "names.file"
  mv "$file" "${file}.nocompile"
done
mkdir -p bin/res
cp -rf src/res bin
cp names.file bin/res/names.names

javac -d bin -sourcepath src src/TstlParser.java
cd bin
java TstlParser
cd $OLD
javac -d genbin -sourcepath gensrc gensrc/TestRunner.java
cd genbin
rm names.file
java TestRunner
