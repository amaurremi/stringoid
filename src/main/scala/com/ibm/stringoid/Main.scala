package com.ibm.stringoid

import java.nio.file.{Files, Path, Paths}
import scala.collection.JavaConversions._

object Main {

  private[this] val RESOURCES_PATH: Path = Paths.get("src", "test", "resources")

  def main(args: Array[String]): Unit = {
    if (args.isEmpty)
      runPlaydroneApks(CgIrAnalysis, GrepAnalysis, "playdrone_apks")
    else
      runSingleApk(???, ???, ???)
  }

  def runPlaydroneApks(a1: AnalysisType, a2: AnalysisType, apkDir: String) = {
    val apkDirPath = Paths.get(RESOURCES_PATH.toString, apkDir)
    Files.newDirectoryStream(apkDirPath, "*.apk") foreach {
      file =>
        write(Compare(a1, a2, file), file)
    }
  }

  def runSingleApk(a1: AnalysisType, a2: AnalysisType, apk: String, dir: String = ""): Unit = {

  }

  /**
   * Write the output of Urls to specified file
   */
  def write(comparison: Compare, apkPath: Path, outDir: Option[Path] = None): Unit = {
    val od = outDir.getOrElse(Paths.get("target", "url_comparison")).normalize()
    Files.createDirectories(od)
    val name1: String = comparison.a1Urls.analysisType.name
    val name2: String = comparison.a1Urls.analysisType.name
    val logName = "%s_%s_%s.txt".format(apkPath.getFileName.toString, name1, name2)
    val logPath = Paths.get(od.toString, logName)
    Files.write(logPath, comparison.toString)
  }
}
