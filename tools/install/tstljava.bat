@echo on
set WDIR=%cd%
set TJHOME=%USERPROFILE%\AppData\Roaming\tstljava
java -jar %TJHOME%\tstljava.jar -p %WDIR% %*
set /p WASHELP=<%TJHOME%\washelp.yes
if %WASHELP%==true goto HELP
set CCP=
if exist %TJHOME%\cp.cfg set /p CCP=<%TJHOME%\cp.cfg
set /p SKIPCOMPILE=<%TJHOME%\skipcompile.yes
if %SKIPCOMPILE%==true goto DORUN
goto COMPILE

:COMPILE
javac -cp lib/commons-cli.jar%CCP% -d genbin -sourcepath gensrc gensrc/TestRunner.java
goto DORUN

:DORUN
set /p WANTSCC=<%TJHOME%\wantscc.yes
if %WANTSCC%==true goto GIVECC
java -cp lib\commons-cli.jar;genbin;.%CCP% TestRunner
goto EXIT

:GIVECC
set /p CFG=<%TJHOME%\cc.cfg
java -noverify -jar lib\emma.jar -cp lib\commons-cli.jar;genbin;.%CCP% -ix %CFG% TestRunner
goto EXIT

:EXIT
pause
echo done
exit

:HELP
pause
echo done
exit