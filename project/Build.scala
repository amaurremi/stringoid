import sbt.{Project, RootProject, file, uri}

object Build extends sbt.Build {

  lazy val subproject = RootProject(uri("git://github.com/psuter/trie#e06fef8f4e84eb8ddcdb5e225a6d279f1e936d33"))

  lazy val main = Project(id = "stringoid", base = file(".")).dependsOn(subproject)
}