cd ..
RD /S /Q src\res
RD /S /Q bin
DEL names.file
RD /S /Q genbin
RD /S /Q gensrc
java -jar copyToRes/copyToRes.jar
javac -d bin -sourcepath src src/TstlParser.java
cd bin
java TstlParser
cd ..
javac -d genbin -sourcepath gensrc gensrc/TestRunner.java
cd genbin
rm names.file
java TestRunner
pause
