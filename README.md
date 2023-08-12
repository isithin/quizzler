# quizzler
A simple rmi Quiz-Game to play with friends over lan.

## Getting started
clone this repo

switch to the quizzler directory

do: mvn install

find the .jar executable file under client/target/client-1.0-SNAPSHOT-jar-with-dependencies.jar

for some more information at runtime switch to the target directory and execute (windows): java -jar client-1.0-SNAPSHOT-jar-with-dependencies.jar 

generate javadocs with: mvn site:stage

find aggregated javadocs in quizzler/target/staging/index.html

or simply visit https://isithin.github.io/quizzler/

## Requirements
Port 1099 must be opened if you want to host a game

Apache Maven

JDK 8+ (8 won´t work)

(Tested with Apache Maven 3.9.3 and Java 17.0.1)
