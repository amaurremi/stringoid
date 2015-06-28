package com.ibm.stringoid

import java.nio.file.{Files, Path, Paths}

import com.ibm.stringoid.AnalysisType._
import scopt.{Read, OptionParser}

import scala.collection.JavaConversions._

object Main {

  private[this] val RESOURCES_PATH: Path = Paths.get("src", "test", "resources")

  def main(args: Array[String]): Unit = {
    // parser.parse returns Option[C]
    parser.parse(args, CmdOptions()) map { options =>
      ???
    } getOrElse {
      ???
      // arguments are bad, usage message will have been displayed
    }

    if (args.isEmpty)
      runPlaydroneApks(CgIr, Grep, "playdrone_apks")
    else
      runSingleApk(???, ???, ???)
  }

  def runPlaydroneApks(a1: AnalysisType, a2: AnalysisType, apkDir: String, outDir: String) = {
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
  def write(comparison: Compare, apkPath: Path, outDir: Path): Unit = {
    Files.createDirectories(outDir)
    val name1: String = comparison.a1Urls.analysisType.toString
    val name2: String = comparison.a1Urls.analysisType.toString
    val logName = "%s_%s_%s.txt".format(apkPath.getFileName.toString, name1, name2)
    val logPath = Paths.get(outDir.toString, logName)
    Files.write(logPath, Seq(comparison.toString))
  }

  case class CmdOptions(
    analysis1: AnalysisType = Grep,
    analysis2: AnalysisType = CgIr,
    outDir: Path            = Paths.get("target", "url_comparison"),
    files: Seq[Path]        = Seq.empty[Path]
  )

  val parser = new OptionParser[CmdOptions]("scopt") {
    implicit val pathRead: scopt.Read[Path] =
      Read.reads(
        s =>
          Paths.get(s, Seq.empty[String]: _*))

    head("stringoid")
    opt[AnalysisType]("a1") required() valueName "<analysis1>" action {
      (a1, opts) =>
        opts.copy(analysis1 = a1)
    } text s"first analysis type (${AnalysisType.values})"
    opt[AnalysisType]("a2") required() valueName "<analysis2>" action {
      (a1, opts) =>
        opts.copy(analysis1 = a1)
    } text s"second analysis type (${AnalysisType.values})"
    opt[Path]('o', "outdir") optional() valueName "<out dir>" action {
      (o, opts) =>
        opts.copy(outDir = o)
    } text "output directory"
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
  }
}
