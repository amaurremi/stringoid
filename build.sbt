name := "stringoid"

version := "0.1"

organization := "IBM T.J. Watson Research"

scalaVersion := "2.11.1"

resolvers += "Local Maven Repository" at "file:///"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "0.5.+",

  "com.ibm.wala" % "com.ibm.wala.core" % "1.3.7",
  "com.ibm.wala" % "com.ibm.wala.shrike" % "1.3.7",
  "com.ibm.wala" % "com.ibm.wala.util" % "1.3.7",

  "edu.illinois.wala" %% "walafacade" % "0.1.2",

  "junit" % "junit" % "4.+",

  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test",
  "org.mockito" % "mockito-core" % "1.9.5",
  "org.scalaz" %% "scalaz-core" % "7.1.0")

org.scalastyle.sbt.ScalastylePlugin.Settings