import sbt.{Project, RootProject, file, uri}

object Build extends sbt.Build {

  lazy val subproject = RootProject(uri("git://github.com/psuter/seqset#149f7ba19a236084c525f38b126c0a24c200dfea"))

  lazy val main = Project(id = "stringoid", base = file(".")).dependsOn(subproject)
}