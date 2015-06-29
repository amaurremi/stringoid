package com.ibm.stringoid

import java.nio.file.{Files, InvalidPathException, Path, Paths}

import com.ibm.stringoid.AnalysisType._
import scopt.{OptionParser, Read}

import scala.collection.JavaConversions._

object Main {

  private[this] val RESOURCES_PATH: Path = Paths.get("src", "test", "resources")

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      runPlaydroneApks(options.analysis1, options.analysis2, options.files, options.outDir)
    }

  def runPlaydroneApks(a1: AnalysisType, a2: AnalysisType, apkFiles: Seq[Path], outDir: Path) =
    apkFiles foreach {
      file =>
        write(Compare(a1, a2, file), file, outDir)
    }

  /**
   * Write the output of Urls to specified file
   */
  def write(comparison: Compare, apkPath: Path, outDir: Path): Unit = {
    import comparison._
    Files.createDirectories(outDir)
    def name(rs: RetrievedUrls) = rs.analysisType.toString
    val logName = "%s_%s_%s.txt".format(apkPath.getFileName.toString, name(a1Urls), name(a2Urls))
    val logPath = Paths.get(outDir.toString, logName)
    Files.write(logPath, Seq(comparison.toString))
  }

  case class CmdOptions (
    analysis1: AnalysisType = Grep,
    analysis2: AnalysisType = CgIr,
    outDir: Path            = Paths.get("target", "url_comparison"),
    files: Seq[Path]        = Seq.empty[Path]
  )

  val parser = new OptionParser[CmdOptions]("scopt") {
    implicit val pathRead: scopt.Read[Path] =
      Read.reads(
        s => {
          val path = Paths.get(s, Seq.empty[String]: _*)
          if (!Files.exists(path)) throw new InvalidPathException(s, "does not exist")
          else path
        })

    private[this] val analysisTypes: String = AnalysisType.values mkString ", "

    head("stringoid")
    opt[AnalysisType]("a1") required() valueName "<analysis1>" action {
      (a1, opts) =>
        opts.copy(analysis1 = a1)
    } text s"first analysis type (${ analysisTypes })"
    opt[AnalysisType]("a2") required() valueName "<analysis2>" action {
      (a1, opts) =>
        opts.copy(analysis1 = a1)
    } text s"second analysis type (${ analysisTypes })"
    opt[Path]('o', "outdir") optional() valueName "<out dir>" action {
      (o, opts) =>
        opts.copy(outDir = o)
    } text "output directory"
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
    checkConfig {
      opts =>
        if (opts.analysis1 == opts.analysis2)
          Left("Comparing equal analyses")
        else Right(opts)
    }
  }
}
