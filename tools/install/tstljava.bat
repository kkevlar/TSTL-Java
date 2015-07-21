@echo off
set WDIR=%cd%
set TJHOME=%USERPROFILE%\AppData\Roaming\tstljava
java -jar %TJHOME%\tstljava.jar -p %WDIR% %*
set /p WASHELP=<%TJHOME%\washelp.yes
if %WASHELP%==true goto HELP
set /p CCP=<%TJHOME%\cp.cfg
javac -cp lib/commons-cli.jar%CCP% -d genbin -sourcepath gensrc gensrc/TestRunner.java
set /p WANTSCC=<%TJHOME%\wantscc.yes
if %WANTSCC%==true goto GIVECC
java -cp lib/commons-cli.jar:genbin:.%CCP% TestRunner
goto EXIT

:GIVECC
set /p CCCFG =<%TJHOME%\cc.cfg.yes
java -noverify -jar lib/emma.jar -cp lib/commons-cli.jar:genbin:.%CCP% -ix %CCCFG% TestRunner
exit
:HELP
pause
exit
:EXIT
exit
