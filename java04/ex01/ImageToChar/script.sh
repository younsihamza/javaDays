#!/bin/bash
echo "Compiling and running the program"
javac -d  target/ft/42/printer $(find src/java/ -name "*.java") && cp -r src/resources target/
echo "Creating the jar file"
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
echo "Running the program"
java -jar target/images-to-chars-printer.jar $1 $2
echo "Done"