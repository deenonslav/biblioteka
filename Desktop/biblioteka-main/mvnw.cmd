@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.
@REM Apache Maven Wrapper startup batch script, version 3.3.2
@REM ----------------------------------------------------------------------------

@IF "%__MVNW_ARG0_NAME__%"=="" (SET "BASE_DIR=%~dp0") ELSE (SET "BASE_DIR=%__MVNW_ARG0_NAME__%")

@SET MAVEN_WRAPPER_JAR="%BASE_DIR%.mvn\wrapper\maven-wrapper.jar"
@SET MAVEN_WRAPPER_PROPERTIES="%BASE_DIR%.mvn\wrapper\maven-wrapper.properties"
@SET MAVEN_PROJECT_BASEDIR=%BASE_DIR%

@FOR /F "usebackq delims=" %%a IN ("%MAVEN_WRAPPER_PROPERTIES%") DO @(
  @SET LINE=%%a
  @IF NOT "!LINE:~0,1!"=="#" (
    @FOR /F "tokens=1,2 delims==" %%b IN ("%%a") DO @(
      @IF "%%b"=="distributionUrl" SET DISTRIBUTION_URL=%%c
    )
  )
)

@SET JAVA_EXE=java.exe
@IF NOT "%JAVA_HOME%"=="" SET JAVA_EXE=%JAVA_HOME%\bin\java.exe

@"%JAVA_EXE%" -classpath %MAVEN_WRAPPER_JAR% "-Dmaven.multiModuleProjectDirectory=%MAVEN_PROJECT_BASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %*
