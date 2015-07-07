java -jar tstl-java.jar
javac -d genbin -sourcepath gensrc gensrc/TestRunner.java
cd genbin
java TestRunner
pause