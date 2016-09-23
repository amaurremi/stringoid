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


<!-- ## How to run on Spark: (Partial?) setup steps

# Setting up WALA

    1. Clone `https://github.com/wala/WALA`
    2. Checkout the commit `ce10710125b342b5d0587975cdd8180166565e50`. (I know...)
    3. Get the Android SDK, and the build-tools. I have `build-tools/23.0.1`.
    4. Copy `build-tools/*/lib/dx.jar` to `com.ibm.wala.dalvik.test/lib/`.
    5. Run `mvn clean install -DskipTests=true -q` (requires Maven >=3.0, or you get a completely uninformative 'BUILD FAILED' error). Note that you need `svn` to be installed, for some reason. If this step succeeds, then WALA will be available as a bunch of Maven packages locally.

# The Spark part.

    1. Get Spark. Pick the same version as in `build.sbt`, pre-compiled for Hadoop works.
    2. Copy `src/main/resources/application.conf.example` to `src/main/resources/application.conf`, edit as appropriate.
    3. Run `sbt assembly`
    4. Run `spark-submit --master local[1] --class com.ibm.stringoid.spark.SparkHarness target/.../stringoid-assembly....jar constants src/test/resources spark-out 0`, or similar. -->
