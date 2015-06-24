package com.ibm.stringoid

import scala.tools.nsc.io.{Path, Directory, File}

object ApkSupergraph {

  private[this] val RESOURCES_PATH: String = "src/test/resources/"
  val SEP = File.separator

  def main(args: Array[String]): Unit = {
    runSingleApk("cgeo.geocaching.apk", useCallGraph = false)
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
    val apkDir = dirWithSep(dir)
    write(File(RESOURCES_PATH + dir + apk), Urls(apk, dir, useCallGraph), useCallGraph)
  }

  /**
   * Write the output of Urls to specified file
   */
  def write(file: Path, urls: Urls, useCallGraph: Boolean): Unit = {
    val outDir = Directory("target" + SEP + "url_comparison").createDirectory()
    val cgUsage = if (useCallGraph) "_CG" else "_CHA"
    File(dirWithSep(outDir.toString()) + file.stripExtension + cgUsage + ".txt").writeAll(urls.stats)
    System.err.println("")
  }
  
  private[this] def dirWithSep(dir: String) =
    if ((dir endsWith SEP) || dir.isEmpty) dir else dir + SEP
}
