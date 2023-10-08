@echo off

rem set choice_from_cli = %1
echo Antysymetria Kateryna Dryzhakova
:menu
echo  ---------------------------
echo             Menu             
echo  ----------------------------
echo.                             
echo   1. Start the program       
echo   2. Program information     
echo   3. Backup                  
echo   4. Exit                    
echo  ----------------------------
echo.
set /p choice=Your choice(1-4) 

if %choice%==1 goto task1
if %choice%==2 goto task2
if %choice%==3 goto task3
if %choice%==4 goto exit
echo Your choice is not included in the range 1-4
goto menu
:task1
echo.
IF EXIST raport.html DEL raport.html
IF NOT EXIST output mkdir output
echo "<HTML>" >> raport.html
DEL /Q output
for /f "delims=" %%a in ('dir /b input') do (
    call python antysymetria.py %%a
)
call python raport.py
echo.
goto menu
:task2
echo.
chcp 1251
type information.txt
pause
echo.
goto menu
:task3
echo.
IF NOT EXIST backups mkdir backups
set name=%date%--%TIME:~1,7%
set name=%name::=-%
IF EXIST raport.html mkdir backups\%name%
robocopy input backups\%name%\input
robocopy output backups\%name%\output
copy raport.html backups\%name%\raport.html
echo.
goto menu
:exit