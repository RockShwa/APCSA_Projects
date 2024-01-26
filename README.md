# APCSA_Projects

How to Make a Bin Folder:
 - Navigate into current project
 - Make a bin directory
 - javac -d bin src/*.java
    - Compiled binaries go into bin folder (binaries are form everything with .java)
- navigate into bin
- java < class name of whichever class has main >
- Make file .gitignore
    - write in file: /bin/*

# How to Get ClassPath to work with ColorPicker into VS Code
    - Unzip file & drag it into a folder
    - compile with javac -d bin -cp libs src/*.java
    - classpath tells compiler where classes are so it can compile
    - run (on windows) with java -cp "bin;libs" ColorPicker (NOT bin folder, general folder)