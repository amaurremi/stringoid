import sbt.{Project, RootProject, file, uri}

object Build extends sbt.Build {

  lazy val subproject = RootProject(uri("git://github.com/psuter/seqset#e0f36ea933da394544ed6f2aed76b4ead23353a0"))

  lazy val main = Project(id = "stringoid", base = file(".")).dependsOn(subproject)
}