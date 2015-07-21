set IDIR=%~dp0
set TJHOME=%USERPROFILE%\AppData\Roaming\tstljava
mkdir %TJHOME%
copy /y %IDIR%\tstljava.jar %TJHOME%\tstljava.jar
copy /y %IDIR%\tstljava.bat %SYSTEMROOT%\tstljava.bat