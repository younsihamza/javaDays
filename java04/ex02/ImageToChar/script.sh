#!/bin/bash
echo "Compiling and running the program"
javac  -cp lib/jcommander/jcommander-2.0.jar:lib/jcdp/JCDP-4.0.2.jar -d target/ft/42/printer/ $(find src/java -name "*.java") && cp -r src/resources target/
echo "Extracting the libraries"
jar xf lib/jcommander/jcommander-2.0.jar com && jar xf lib/jcdp/JCDP-4.0.2.jar com
mv com target/
echo "Creating the jar file"
jar    -cfm target/images-to-chars-printer.jar src/manifest.txt -C target/ft/42/printer/ . -C target/ resources/ -C target/ com/
echo "Running the program"
java -jar target/images-to-chars-printer.jar --white RED --black BLACK 
echo "Done"

