name := "stringoid"

version := "0.1"

organization := "IBM T.J. Watson Research"

scalaVersion := "2.10.5"

resolvers ++= Seq(
  "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository",
  Resolver.sonatypeRepo("public")
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "0.5.2",
  "com.ibm.wala" % "com.ibm.wala.core" % "1.3.9-SNAPSHOT",
  "com.ibm.wala" % "com.ibm.wala.shrike" % "1.3.9-SNAPSHOT",
  "com.ibm.wala" % "com.ibm.wala.util" % "1.3.9-SNAPSHOT",
  "com.ibm.wala" % "com.ibm.wala.cast" % "1.3.9-SNAPSHOT",
  "com.ibm.wala" % "com.ibm.wala.cast.java" % "1.3.9-SNAPSHOT",
  "com.ibm.wala" % "com.ibm.wala.ide.jdt" % "1.3.9-SNAPSHOT",
  "io.argonaut" %% "argonaut" % "6.0.4",
  "junit" % "junit" % "4.+",
  "org.eclipse.equinox" % "common" % "3.6.200-v20130402-1505",
  "org.eclipse.core" % "runtime" % "3.10.0-v20140318-2214",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
  "org.mockito" % "mockito-core" % "1.9.5",
  "org.scalaz" %% "scalaz-core" % "7.0.6",
  "com.github.scopt" %% "scopt" % "3.3.0",
  "org.apache.spark" %% "spark-core" % "1.5.1" % "provided"
)

org.scalastyle.sbt.ScalastylePlugin.Settings

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case _ => MergeStrategy.first
}
