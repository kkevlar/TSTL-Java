for %%* in (.) do set DIRNAME=%%~nx*
IF %DIRNAME% EQU run-scripts cd ..
javac -d bin -sourcepath src src/TstlParser.java
cd bin
java TstlParser
cd ..
javac -d genbin -sourcepath gensrc gensrc/TestRunner.java
cd genbin
java TestRunner
pause