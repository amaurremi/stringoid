import sbt.{Project, RootProject, file, uri}

object Build extends sbt.Build {

  lazy val automatonLib = RootProject(uri("https://git@github.com/psuter/seqset.git"))

  lazy val main = Project(id = "stringoid", base = file(".")).dependsOn(automatonLib)
}