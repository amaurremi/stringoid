import sbt.{Project, RootProject, file, uri}

object Build extends sbt.Build {

  lazy val automatonLib = RootProject(uri("https://git@github.com/psuter/seqset.git#0a0e5f6a647feb73e947d2e8cc4b9287b3b6f573"))

  lazy val main = Project(id = "stringoid", base = file(".")).dependsOn(automatonLib)
}
