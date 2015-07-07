for %%* in (.) do set DIRNAME=%%~nx*
IF %DIRNAME% EQU run-scripts cd ..
cd copyToRes
java -jar copyToRes.jar
cd ..
if not exist "bin" mkdir bin
javac -d bin -sourcepath src src/TstlParser.java
cd bin
java TstlParser
cd ..
javac -d genbin -sourcepath gensrc gensrc/TestRunner.java
cd genbin
java TestRunner
pause