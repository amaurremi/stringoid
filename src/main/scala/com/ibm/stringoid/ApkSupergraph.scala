package com.ibm.stringoid

import scala.tools.nsc.io.{Path, Directory, File}

object ApkSupergraph {

  private[this] val RESOURCES_PATH: String = "src/test/resources/"
  val SEP = File.pathSeparator

  def main(args: Array[String]): Unit = {
    runSingleApk("cgeo.geocaching.apk")
  }
  
  def runPlaydroneApks() = {
    val playdroneDir: String = "playdrone_apks/"
    val apks = Directory(RESOURCES_PATH + playdroneDir) walkFilter {
      _.extension == "apk"
    }
    apks foreach {
      file =>
        val name = file.name
        val url  = Urls(name, playdroneDir)
        write(file, url)
    }
  }

  def runSingleApk(apk: String, dir: String = ""): Unit = {
    val apkDir = dirWithSep(dir)
    write(File(RESOURCES_PATH + dir + apk), Urls(apk, dir))
  }

  /**
   * Write the output of Urls to specified file
   */
  def write(file: Path, urls: Urls): Unit = {
    val outDir = Directory("target" + SEP + "url_comparison").createDirectory()
    File(dirWithSep(outDir.toString()) + file.stripExtension + ".txt").writeAll(urls.stats)
    System.err.println("")
  }
  
  private[this] def dirWithSep(dir: String) =
    if (dir endsWith SEP) dir else dir + SEP
}
