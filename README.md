## How to run on Spark: (Partial?) setup steps

# Setting up WALA

    1. Clone `https://github.com/wala/WALA`
    2. Get the Android SDK, and the build-tools. I have `build-tools/23.0.1`.
    3. Copy `build-tools/*/lib/dx.jar` to `com.ibm.wala.dalvik.test/lib/`.
    4. Run `mvn clean install -DskipTests=true -q` (requires Maven >=3.0, or you get a completely uninformative 'BUILD FAILED' error). Note that you need `svn` to be installed, for some reason. If this step succeeds, then WALA will be available as a bunch of Maven packages locally.
    5. You should just have built WALA version `1.3.10-SNAPSHOT`.

# Configuring Java paths

    1. Copy `src/main/resources/application.conf.example` to `src/main/resources/application.conf`, edit as appropriate.

# The Spark part.
    1. Get Spark. Pick the same version as in `build.sbt`, pre-compiled for Hadoop works.
    2. Run `sbt assembly`
    3. Run `spark-submit --master local[1] --class com.ibm.stringoid.spark.SparkHarness target/.../stringoid-assembly....jar constants src/test/resources spark-out 0`, or similar.
