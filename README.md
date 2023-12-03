# GluonWithSpring

Demonstration of Gluon native image generation with springboot + JavaFX application.


Sample project inspired by https://github.com/guirak/GluonWithSpring/tree/master but demonstrate how to create a native image through graalvm for a JavaFX and Springboot application. 
The build is composed via maven of spring AOT + GluonFX.

See gluonFX at : https://docs.gluonhq.com/ 

This project has been tested on Windows to create a native image exe file.

For this, you have to install all the gluonFX specific versions as described in the link.
Here are my configuration :  

- Java 21 (from eclipse adoptium) on windows
- maven 3.8.8
- graalvm-svm-java17-windows-gluon-22.1.0.1-Final
- Microsoft VS Code 2022 with the C compiler build tools


# How to build this project : 

In a VS Code CLI (e.g. launched via : cmd /k "C:\VisualStudio\2022\Community\VC\Auxiliary\Build\vcvars64.bat"), build with maven : 
`mvn clean install`
test with : 
`launch.bat`

Build the native executable : 
run spring AOT : 
`mvn -Pnative spring-boot:process-aot`

build native with gluonFX : 
`mvn gluonfx:build`

Run it : 
`mvn gluonfx:nativerun` 

Or double clic on the executable in target\gluonfx\x86_64-windows\GluonWithSpring.exe


# Performance : 

On my PC which is quite limited in resources : 

- the standard java and jar launch uses 185 Mb of RAM and has a startup time of 2.4s

- the native executable uses 86 Mb of RAM and has a startup time of 0.06s :)

