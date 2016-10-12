# Stringoid

Statically extracts URL strings from Android applications.

## Installation

The installation requires you to build WALA (the [T.J. Watson Libraries for Analysis](https://github.com/wala/WALA)) and to compile Stringoid to work.


### Build WALA
Prerequisites: make sure to have the Android SDK and its build-tools installed (a proven-to-be-compatible version is `23.0.1`).

1. Clone `https://github.com/wala/WALA`
2. Copy `build-tools/*/lib/dx.jar` (typically located at `/Users/<username>/Library/Android/sdk/` on a Mac) to `com.ibm.wala.dalvik.test/lib/`. Create the `lib` directory if need be.
3. Run `mvn clean install -DskipTests=true -q` (Note: requires Maven >=3.0, or you get a completely uninformative `BUILD FAILED` error. You need `svn` to be installed. If this step succeeds, WALA will be available as a bunch of Maven packages locally.)

### Compile Stringoid

1. Clone this project using `git clone https://github.com/amaurremi/stringoid.git`
2. Rename / copy `src/main/resources/application.conf.example` to `src/main/resources/application.conf` (remove the `.example`) and provide the paths for `rt.jar` (typically found at `/Library/Java/JavaVirtualMachines/jdk*.*.*_**.jdk/Contents/Home/jre/lib/rt.jar` on a Mac) and `android.jar` (typically found at `/Applications/Android Studio.app/Contents/plugins/android/lib/android.jar` on a Mac) within the newly created file.


## Run stringoid

Once Stringoid has been installed, you can either run its tests using:

    sbt
    test // from within sbt

...or you can point it to run on a specific Android application (`.apk` file) from the root directory of the project:

    java -cp target/scala-2.10/stringoid-assembly-0.1.jar com.ibm.stringoid.Main -a append --lib false --ir-source interproc -u false <path/to/.apk-file>

Some example `.apk` files are provided in this project under `stringoid/dynamic-instrumentation/real-apks/`.


## How to run on Spark

1. Get Spark. Pick the same version as in `build.sbt`, pre-compiled for Hadoop works.
2. Run `sbt assembly`
3. Run `spark-submit --master local[1] --class com.ibm.stringoid.spark.SparkHarness target/.../stringoid-assembly....jar constants src/test/resources spark-out 0`, or similar.


## Create and run tests
1. Create Java source tests and put them into the `src/test/java/moretests` directory. You can look at the `Example.java` file to see an example. To create a test, write a Java program that creates URLs in some interesting way. Then, if you want to check whether stringoid detects a URL "http://xxx" or "https://yyy", write somewhere (for example in the main method):

  - `Assertions.shouldContainHttp("xxx");`
  - `Assertions.shouldContainHttp("yyy");`
  
  That is, don't include the "http://" or "https://" as part of the URL in the assertion.
2. To run the tests, you can use `sbt test` from your command line. If you're using an IDE, you can go to `src/test/scala/com/ibm/stringoid/ConcatenationSpec.scala` and run the tests directly from there (if you use IntelliJ, right-click the file and select "Run ConcatenationSpec"). Note the following:
  1. The tests will run an inter-procedural analysis.
  2. The analysis will not detect string concatenation with the "+" operator. To write "http://" + "url.com", you can write anything like: 
    - `StringBuilder sb = new StringBuilder();`
    - `sb.append("http://");`
    - `sb.append("url.com");`
    - `String s = url.toString;`
    - `String s = new StringBuilder("http://").append("url.com").toString;`
3. The analysis will create an acyclic control-flow graph. Here is one consequence: consider the program
  
  ```java
  StringBuilder sb = new StringBuilder("http://");
  while (...) { sb.append("url.com"); }
  sb.append("path");
  ```

  Stringoid will detect the URLs "http://", "http://url.com", and "http://path", but not "http://url.com/path".
4. Please make sure that the methods in which you construct URLs are reachable from the main method of the public class in the Java test file you're implementing.
