name := "stringoid"

version := "0.1"

organization := "IBM T.J. Watson Research"

scalaVersion := "2.10.5"

resolvers ++= Seq(
  "Local Maven Repository" at "file:///" + Path.userHome.absolutePath + "/.m2/repository",
  Resolver.sonatypeRepo("public")
)

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "0.5.+",

  "com.ibm.wala" % "com.ibm.wala.core" % "1.3.7",
  "com.ibm.wala" % "com.ibm.wala.shrike" % "1.3.7",
  "com.ibm.wala" % "com.ibm.wala.util" % "1.3.7",
  "com.ibm.wala" % "com.ibm.wala.cast" % "1.3.8-SNAPSHOT",

//  "edu.illinois.wala" %% "walafacade" % "0.1.2",

  "junit" % "junit" % "4.+",

  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
  "org.mockito" % "mockito-core" % "1.9.5",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "com.github.scopt" %% "scopt" % "3.3.0")

org.scalastyle.sbt.ScalastylePlugin.Settings
