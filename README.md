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

# For BouncingBalls:
    - javac -d bin -cp lib src/*.java
    - java -cp "bin;lib" BouncingBalls

# How to Push at School Computer
- git remote set-url origin https://RockShwa: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@github.com/RockShwa/APCSA_Projects
- git push origin main

# Pulling
- Anytime I make a change on multiple computers to the same repo I need to use git pull to pull the changes onto my local repo
- git pull