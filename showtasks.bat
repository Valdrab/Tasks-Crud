call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openwebpage
echo.
echo Error running runcrud.bat - breaking work
goto fail

:openwebpage
start firefox.exe http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Error opening the browser - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Finished working