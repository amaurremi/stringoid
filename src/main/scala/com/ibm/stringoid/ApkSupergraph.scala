package com.ibm.stringoid

import scala.tools.nsc.io.{Directory, File, Path}

object ApkSupergraph {

  val SEP = File.separator
  private[this] val RESOURCES_PATH: String =  Seq("src", "test", "resources").mkString("", SEP, SEP)

  def main(args: Array[String]): Unit = {
    runPlaydroneApks(useCallGraph = true)
//    runSingleApk("cgeo.geocaching.developer-build.apk", useCallGraph = false)
  }
  
  def runPlaydroneApks(useCallGraph: Boolean = true) = {
    val playdroneDir: String = "playdrone_apks/"
    val apks = Directory(RESOURCES_PATH + playdroneDir) walkFilter {
      _.extension == "apk"
    }
    apks foreach {
      file =>
        val name = file.name
        val url  = Urls(name, playdroneDir, useCallGraph)
        write(file, url, useCallGraph)
    }
  }

  def runSingleApk(apk: String, dir: String = "", useCallGraph: Boolean = true): Unit = {
    write(File(RESOURCES_PATH + dir + apk), Urls(apk, dirWithSep(dir), useCallGraph), useCallGraph)
  }

  /**
   * Write the output of Urls to specified file
   */
  def write(file: Path, urls: Urls, useCallGraph: Boolean): Unit = {
    val outDir = Directory("target" + SEP + "url_comparison").createDirectory()
    val cgUsage = if (useCallGraph) "CG" else "CHA"
    File(dirWithSep(outDir.toString()) + file.stripExtension + "_" + cgUsage + ".txt").writeAll("Note: using " + cgUsage , urls.stats)
    println("")
  }
  
  private[this] def dirWithSep(dir: String) =
    if ((dir endsWith SEP) || dir.isEmpty) dir else dir + SEP
}
