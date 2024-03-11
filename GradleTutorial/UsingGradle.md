# Using Gradle
- Notes from: https://docs.gradle.org/current/userguide/gradle_basics.html
- Gradle automates building, testing, and deployment of software from information in build scripts

## Gradle Core Concepts
- Projects: a Gradle project is a piece of software that can be built (like an application or a library)
    - Single projects builds include a single project (called a root project)
    - Multi-project builds include one root project and any number of subprojects
- Build Scripts: detail to Gradle what steps to take to build the project (each project can have on or more build scripts)
- Dependency Management: automated technique for declaring and resolving external resources required by a project
- Tasks: a basic unit of work such as compiling code or running a test (defined inside a build script or plugin)
- Plugins: used to extend Gradle's capability and optionally contribute tasks to a project

## Gradle Project Structure
- A Gradle project will look similar to the following:
~~~
project
├── gradle // 1                  
│   ├── libs.versions.toml // 2             
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew // 3                    
├── gradlew.bat // 3                        
├── settings.gradle(.kts) // 4            
├── subproject-a
│   ├── build.gradle(.kts) // 5             
│   └── src // 6                            
└── subproject-b
    ├── build.gradle(.kts) // 5            
    └── src // 6
~~~
1) Gradle directory to store wrapper files and more
2) Gradle version catalog for dependency management
3) Grafle wrapper scripts
4) Gradle settings file to define a root project name and subprojects
5) Gradle build scripts of the two subprojects (a & b)
6) Source code and/or additional files for the projects

## Invoking Gradle
- Not recommended, but if Gradle is installed, you can type into command line: gradle build
- The recommnended way to execute a Gradle build is to use Gradle wrapper (the Wrapper script invokes a declared version of Gradle, downloading it beforehand if necessary)
    - Recommended because it provides a standardized build (can execute on different IDEs or servers)
    - The wrapper is a script that invokes a declared version of Gradle (found in project root directory as gradlew or gradle.bat)
    - Command line:
        - gradlew build // Linux or OSX
        - gradle.bat build // Windows
        - Command is run in the same directory that the Wrapper is located in, unless you provide the relative path to the Wrapper

### Command-Line Basics
- Execute Gradle on command line basic structure:
    - gradlew.bat [taskName...] [--option-name...]
    - Options are allowed before and after task names
    - If multiple tasks are specified, you should seperate them with a space
        - gradlew.bat [taskName1 taskName2...] [--option-name...]
- Options that accept values can be specified with or without = (= recommended)
    - gradlew.bat [...] --console=plain
- Options that enable behavior have long-form options with inverses specified with --no- (the following are opposites):
    - gradlew.bat [...] --build-cache
    - gradlew.bat [...] --no-build-cache 
- Executing tasks:
    - Execute task on root project: gradlew.bat :taskName
        - Runs single taskname and all of its dependencies
    - Specify options for tasks:
        - Pass an option to a task, prefix option name with -- after task name
        - gradlew.bat taskName --exampleOption=exampleValue

## Setting File Basics
- The settings file is the entry point of every Gradle project, **its purpose is to add subprojects to your build**
- For single-project builds, settings file is optional
- For multi-project builds, the settings file is mandatory and declares all subprojects
- Settings script: settings.gradle (Groovy) or settings.gradle.kts (Kotlin), typically found in root directory of project
~~~ groovy
// There is only one root project per build
rootProject.name = 'root-project' // Define project name 
include('sub-project-a') // Add subprojects
include('sub-project-b')
include('sub-project-c')
~~~ 

## Build File Basics
- Generally, a build script details build configuration, tasks, and plugins
- Every Gradle build comprises at least one build script
- In a build file, two types of dependencies can be added:
1) The libraries and/or plugins on which Gradle and the build script depend
2) The libraries on which the project sources (
i.e. source code) depend
- Build scripts are either a build.gradle (Groovy) or build.gradle.kts (Kotlin)
~~~ groovy
plugins {
    id 'application' // 1) Add plugins
}

application {
    mainClass = 'com.example.Main' // 2) Use convention properties
}
~~~
1) Add plugins: called applying a plugin and makes additional functionality available
    - The application plugin facilitates creatin an executable JVM application
    - Applying the application plugin also implicity applies the Java plugin (adds Java compilation along with testing and bundling capabilities)
2) Use convention properties: a plugin adds tasks to a project, it also adds properties and methods to a project
    - The application plugin defines tasks that package and distribute an application, like the run task
    - The application plugin also provides a way to declare the main class of a Java appliation, which is required to execute the code

## Dependency Management Basics
- Dependency management is an automated technique for declaring and resolving external resources required by a project
- Dependencies refer to JARs, plugins, libraries, or source code that support building your project

### Version Catalog
- Version Catalogs provide a way to centralize your dependency declarations in a libs.versions.toml file
- Makes sharing dependencies and version configs between subprojects simple (also allows teams to enforce versions of libraries and plugins)
- Usually in 4 sections:
1) [versions] to declare the version numbers that plugins and libraries will reference
2) [libraries] to define the libraries used in the build files
3) [bundles] to define a set of dependencies
4) [plugins] to define plugins
~~~ groovy
[versions]
androidGradlePlugin = "7.4.1"
mockito = "2.16.0"

[libraries]
google-material = { group = "com.google.android.material", name = "material", version = "1.1.0-alpha05" }
mockito-core = { module = "org.mockito:mockito-core", version.ref = "mockito" }

[plugins]
android-application = { id = "com.android.application", version.ref = "androidGradlePlugin" }
~~~
- The file is located in the gradle directory so that it can be used by Gradle and IDEs automatically, should be checked into source control:
    - gradle/libs.versions.toml

### Declaring Dependencies
- To add a dependency, specify it in the dependencies block of your build.gradle file
- Example, adds a plugin and two dependencies to project using version catalog above:
~~~ groovy
plugins {
   alias(libs.plugins.android.application) // 1
}

dependencies {
    // Dependency on a remote binary to compile and run the code
    implementation(libs.google.material) // 2   

    // Dependency on a remote binary to compile and run the test code
    testImplementation(libs.mockito.core) // 3
}
~~~
1) Applies Android Gradle plugin to this project
2) Adds Material dependency to the project, used to compile and run the source code
3) Adds Mockito dependency to the prokect, mocking framework for testing Java code, used to compile and run test code
- Dependencies in Gradle are grouped by configurations:
    - The material library is added to the **implementation configuration, which is used for compiling and running production code**
    - The mockito-core library is added to the **testImplementation configuration, which is used for compiling and running test code**
    - Many more configurations available

### Viewing Project Dependencies
- View dependency tree in terminal using the ./gradlew :app:dependencies command

## Task Basics
- A task represents some independent unit of work that a build performs, such as compiling classes, creating a JAR, generating a Javadoc, or publishing archives to a repo
- Run a Gradle build task using gradle.bat build in your project directory

### Available Tasks
- All available tasks in your project come from Gradle plugins and build scripts
- List all available tasks in project by running this is the terminal:
    - gradle.bat tasks
- The run task is executed with gradle.bat run (runs this project as a JVM application)

### Task Dependency
- Many times, a task requires another task to run first
    - EX: for Gradle to execute the build task, the Java code must first be compiled, thus, the build task depends on the compileJava task (compileJava runs before build)
- Build scripts can optionally define task dependencies, Gradle then automatically determines task execution order

## Plugin Basics
- Plugins add features, organize build logic, provide useful tasks with capabilities (running code, creating documentation, etc.)
- Applying a plugin to a project allows the plugin to extend the project's and Gradle's capabilites
- EX:
    - Spring Boot Gradle Plugin, provides Spring Boot support
    - Google Services Gradle Plugin, enables Google APIs and Firebase services in Android application
    - Gradle Shadow Plugin, generates fat/uber JARs with support for package relocation

### Plugin Distribution
- Distributed in 3 ways:
1) Core Plugins - Gradle develops and maintains a set of Core Plugins
2) Community Plugins - Gradle's community shares plugins via the Gradle Plugin Portal
3) Local Plugins - Gradle enables users to create custom plugins using APIs
- You apply plugins in the build script using their plugin id, a globally unique identifier/name
~~~ groovy
plugins {
    id <<plugin id>> version <<plugin version>> [apply <<false>>]
}
~~~
- Core Plugins: unique in that they provide short names, such as java for the core JavaPlugin
    - JavaPlugin adds Java compilation along with testing and bundling capabilites to a project
    - Lots more: https://docs.gradle.org/current/userguide/plugin_reference.html#plugin_reference
- Community Plugins: Gradle has a large community of plugin developers who contribute plugins for various capabilites
    - Spring Boots Gradle plugin, provides Spring Boot support in Gradle, it packages executable JAR or WAR archives and runs Spring Boot Java applications
    - Lots more: https://plugins.gradle.org/?_gl=1*37xe3b*_ga*NjAyOTUzMjkuMTcxMDE4MDQzMg..*_ga_7W7NC6YNPT*MTcxMDE4MDQzMi4xLjEuMTcxMDE4NjY3Ny42MC4wLjA.

### Plugin Tasks
- Jib is a Gradle plugin for building Docker and OCI images of Java applications, adds tasks to project when applied (view with gradle.bat tasks)

## Gradle Incremental Builds and Build Caching
- Two main features to reduce build time: incremental builds and build caching

### Incremental Builds
- Incremental builds are builds that avoid running tasks whose inputs have not changed since the previous build
- For them to work, tasks must define their inputs and outputs; Gradle will determine whether inputs or outputs have changed at build time. If they have changed, Gradle will execute the task. If not, it will skip execution
- Always enabled, best way to see them in action is to turn on verbose mode - each task state is labeled during a build
    - gradle.bat compileJava --console=verbose
    - When you run a task that has been previously executed and hasn't changed, then UP-TO-DATE is printed next to task
    - To permanently enable verbose mode, add org.gradle.console=verbose to your gradle.properties file

### Build Caching
- Build cache stores previoud build results and resures them when needed, preventing redundant work and cost of executing time-consuming processes
- When the build cache has been used to repopulate local directory, tasks are marked as FROM-CACHE
- Once local directory has been repopulated, next execution will mark tasks as UP-TO-DATE and not FROM-CACHE
- Allows you to share and reuse unchanged build and test outputs actoss teams (speeds up local and CI builds)

## Build Scans
- A build scan is a representation of metadata captured as you run your build
- Gradle captures your build metadata and sends it to the Build Scan Service, which then transforms the metadata into info you can analyze and share with others
- Rnable build scans on a gradle command with --add scan to command line option
    - gradle.bat build --scans

## Gradle Tutorial

### Step 1 - Initiallizing the Project 
- Run gradle init with parameters to generate a Java application
    - gradle init --use-defaults --type java-application
- In this tutorial, Kotlin DSL is used 
- Gradle Wrapper is the preferred way of stating a Gradle build, it downloads (if needed) and then invokes a specific version of Gradle declared in the build
- Use wrapper by entering .\grandlew.bat build
- All of the files generated by the build process go into the build directory unless otherwise specified
- A build contains:
    - A top level settings.gradle.kts file
    - A root project
    - One or more subprojects, each with its own build.gradle.kts file
    - Some builds may have a build.gradle.kts file in root project, but this is not recommended
- In this tutorial, the root project is called tutorial and is defined with rootProject.name = "tutorial" in settings.gradle
- The subproject is called app and is defined with include("app") in settings.gradle
- A build: represents a bundle of related software that you can build, test, and/or release together (can optionally include other builds like libraries, plugins, etc.)
- A project: represents a single piece of your architecture, a library, an app, a Gradle plugin, etc. (sometimes can contain other projects)

### Step 2 - Running Gradle Tasks
- A task is a basic unit of work that can be done by Gradle as part of the build
- ./gradlew.bat tasks
- You can obtain more info in the task listing by using ./gradlewbat tasks --all
- Creating our own tasks:
~~~ kotlin
tasks.register<Copy>("copyTask") {
    from("source")
    into("target")
    include("*.war")
}
~~~
- This task, if added to build.gradle.kts in the app subproject directory, would be execured using the command ./gradlew :app:copyTask
- Popular built-in-tasks:
    - Copy - useful to copy files around
    - Delete - useful to delete files and directories
    - Exec - useful to execute arbitrary O/S commands
    - Zip - useful to bundle files
- Many times, tasks are dependent on another task running first. A task may explicitly or implicitly declare its dependencies
- Ex:
~~~ kotlin
tasks.register("hello") {
    doLast {
        println('Hello!')
    }
}

tasks.register("greet") {
    doLast {
        println('How are you?')
    }
    dependsOn("hello")
}
~~~
- The jar task creates an executable JAR file of the app (./grandlew.bat jar)

### Step 3 - Dependency Management
- Repositories - The source of dependencies -> mavenCentral()
    - Maven Central is a collection of jar files, plugins, and libraries provided by the Maven community (de-facto public artifact store for Java)
- Dependencies - declared via config types -> junit and guava; Gradle needs specific info to find a dependency:
    - Group (identifier of an organization), Name (dependency identifer), Version (version # to import)
    - A transitive dependency is a dependency of a dependency
    - view dependencies with ./gradlew.bat :app:dependencies
        - the output (in our example) depicts that com.google.guava:32.1.2-jre has a dependency on com.google.guava:failureaccess:1.0.1
- To view dependencies using a Build Scan, run the build task with the optional --scan flag
- Adding a Version Catalog:
    - used to declare all direct dependencies of a project in a central location 
    - created in gradle/lobs.versions.toml and referenced in subproject build files
    - when you add this to libs.versions.toml:
    ~~~ kotlin
    [versions]
    junitVer = "5.9.1"
    guavaVer = "32.1.2-jre"

    [libraries]
    junit = { module = "org.junit.jupiter:junit-jupiter", version.ref = "junitVer" }
    guava = { module = "com.google.guava:guava", version.ref = "guavaVer" }
    ~~~
    - and update the app/build.gradle.kts dependencies:
    ~~~ kotlin
    dependencies {
        testImplementation(libs.junit)
        implementation(libs.guava)
    }
    ~~~
    - This creates a simpler and centralized dependency that a subproject can easily refer to

### Step 4 - Applying Gradle Plugins
- The tutorial project cuttently applies the Application Plugin, which is bundled with Gradle
- To run the plugin, run the publishToMavenLocal task by running ./gradlew.bat :app:publishToMavenLocal
- This builds the POM file and the artifacts to be published, it then installs them into the local Maven repository
- Convention plugins - used to share build logic between subprojects (modules). users can wrap common logic in a convention plugin  

### Step 5 - Exploring Incremental Builds
- Run the clean task and then the build task using the ./gradlew.bat :app:clean :app:build to build the app
- After this, run just the build to view an incremental build in action
- Outcome Lables (verbose mode on):
    - UP-TO-DATE: Task has already been executed and hasn't changed (incremental build feature)
    - SKIPPED: Task was explicitly prevented from running
    - FROM-CACHE: Task output has been copied to local directory from previous builds in the build cache (caching feature)
    - NO-SOURCE: Task was no executed because 
    its required inputs were not available
    - If there is no label, the task was newly executed by Gradle (locally)

### Step 6 - Enabling the Gradle Build
1) First, we used the build task to populate our local cache with task inputs and outputs - we can imagine this was done a week ago
2) Then, we used the clean task to mimic switching branches - overriding previous outputs
3) Finally, we used the build task - unlike incremental builds, the previous outputs were stored in the local cache and could be reused
- The local Gradle Build Cache is located at %USERPROFILE%\.gradle\caches
- Remote Caching: share commonly built task outputs across remote builds to improve build times
- When both remote and local caches are enabled, the build output is first checked in the local cache. If the output isn't present in the lcoal cache, it'll be downloaded from the remote cache and also stored in the local cache

### Step 7 - Using Gradle's Reference
- To work with Gradle, the following references are useful:
- https://docs.gradle.org/current/userguide/part7_gradle_refs.html#part7_begin
