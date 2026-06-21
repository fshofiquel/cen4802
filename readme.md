Project: cen4802
=================

This repository contains a small Java application (Fibonacci) used for the CEN4802 Jenkins CI assignment.

Owner
-----
Fazlur Shofiquel

What I changed
---------------
- Added a `Jenkinsfile` at the project root (Declarative Pipeline for Jenkins).
- Updated `src/main/java/driver/DriverFunction.java` to append the marker string " [built via Jenkins]" to runtime output so CI-built runs are visibly marked.

Running and testing in IntelliJ
-------------------------------
- IntelliJ IDEA includes its own runtime/JDK for the IDE, and you can configure the Project SDK and Gradle JVM in
  File → Project Structure → Project and File → Settings → Build, Execution, Deployment → Build Tools → Gradle.
- To run the tests inside IntelliJ:
  1. Open the project in IntelliJ.
  2. Ensure the Project SDK and Gradle JVM are set to a valid JDK (e.g. Java 17).
  3. Use the Gradle tool window to run `clean` and `test`, or open `src/test/java/math/FibonacciTest.java` and run the tests directly.

Running Gradle from PowerShell or for Jenkins
--------------------------------------------
- Jenkins and the Gradle wrapper (`gradlew.bat`) need a Java runtime available on the PATH or `JAVA_HOME` set.
- To run the Gradle wrapper from PowerShell using the JDK IntelliJ is configured with, find the JDK path in IntelliJ:
  - File → Project Structure → SDKs shows the JDK home path (something like `C:\Program Files\Java\jdk-17.x` or a JetBrains runtime path).
  - Alternatively, Help → About in the IDE shows the runtime location.

- Example PowerShell commands (replace the JDK path with the one you found in IntelliJ):
```powershell
$env:JAVA_HOME = 'C:\Program Files\Java\jdk-17.0.x'
$env:Path = $env:JAVA_HOME + '\\bin;' + $env:Path
cd "C:\Users\fshof\OneDrive\Documents\MEGA\2026\1. Summer 2026\CEN4802 Software Integration\cen4802"
.\\gradlew.bat clean test --console=plain
```

Configuring Jenkins on this machine to use the same JDK
------------------------------------------------------
- If Jenkins runs as a Windows service, ensure the service's user account has access to the JDK and the workspace. You can:
  - Configure the Jenkins service to run under your user account (for testing), or
  - Set `JAVA_HOME` as a system environment variable pointing to the JDK installation and restart the Jenkins service.

Using GitHub remote
-------------------
- The `Jenkinsfile` in this repo is ready for use by a Pipeline job configured with
  Repository URL: `https://github.com/fshofiquel/cen4802.git`
  Branch: `master` (or change to `main` if you use that branch name)

Next steps I can do for you
---------------------------
- add a small extra unit test,
- add step-by-step annotated screenshots for your report,
- or provide ngrok instructions to allow GitHub webhooks to reach a locally running Jenkins.

-- End of README
