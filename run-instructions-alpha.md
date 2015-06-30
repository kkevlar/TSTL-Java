Releases of Tstl-Java are best run through the included .jar archive or in an IDE such as eclipse.

###Generate code with the runnable jar:
* Download the runnable jar below.
* Download the ArrayListTest.valid.tstl file included, or write your own .tstl file.
  * The .jar and the .tstl file must be in the same directory.
* Open command prompt and set working directory to the root of the project folder.
* Run the jar with `java -jar TSTL-Java-v3.0.1-alpha.jar`

###Generate code with eclipse:
* Extract the source into a new project
* Run the copyToRes/CopyToRes.jar archive.  It will allow the program to find dependencies for generated code.
* Refresh the project files (Right-click project folder in Package Explorer).
* Ensure a tstl source file can be found in the root of your project folder.
* Run TstlParser in eclipse.
* Navigate to the project folder in file explorer

###Running the generated code:
* Locate the gensrc and genbin folders.  If everything worked properly they should be found in the root of the project directory. 
  * If you can't see them, attempt to find them in your $HOME directory.  If it is there, report the bug and move the directories next to the jar file
* Compile and run the generated java:
```shell
cd <path-to-project-folder>
javac -d genbin -sourcepath gensrc gensrc/RandomTester.java
cd genbin
java RandomTester
```
Care! The commands above will break horribly if your working directory is not set the the root of the project folder in command line

Happy testing! Please report any bugs under "issues" in GitHub

