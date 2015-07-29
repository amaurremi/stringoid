package com.ibm.stringoid

import java.nio.file.{Files, InvalidPathException, Path, Paths}

import com.ibm.stringoid.AnalysisType._
import com.ibm.stringoid.util.Time
import scopt.{OptionParser, Read}

import scala.collection.JavaConversions._

object Main {

  // Program arguments
  // all apks:
  // --a1 append --a2 grep src/test/resources/playdrone_apks/com.facebook.katana-4947895.apk src/test/resources/playdrone_apks/com.google.android.apps.maps-804010103.apk src/test/resources/playdrone_apks/com.google.android.apps.plus-413339268.apk src/test/resources/playdrone_apks/com.google.android.gm-4900120.apk src/test/resources/playdrone_apks/com.google.android.gms-6183036.apk src/test/resources/playdrone_apks/com.google.android.googlequicksearchbox-300306150.apk src/test/resources/playdrone_apks/com.google.android.street-18102.apk src/test/resources/playdrone_apks/com.google.android.tts-210302120.apk src/test/resources/playdrone_apks/com.google.android.videos-33331.apk src/test/resources/playdrone_apks/com.google.android.youtube-51405300.apk
  // those where grep > cg
  // --a1 cha --a2 grep src/test/resources/playdrone_apks/com.google.android.apps.maps-804010103.apk rc/test/resources/playdrone_apks/com.google.android.gms-6183036.apk src/test/resources/playdrone_apks/com.google.android.googlequicksearchbox-300306150.apk src/test/resources/playdrone_apks/com.google.android.tts-210302120.apk src/test/resources/playdrone_apks/com.google.android.youtube-51405300.apk

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      runPlaydroneApks(options.analysis1, options.analysis2, options.files, options.outDir)
    }

  def runPlaydroneApks(a1: AnalysisType, a2: AnalysisType, apkFiles: Seq[Path], outDir: Path) = {
    apkFiles foreach {
      file =>
        Time.time("processing " + file.toString) {
          write(PrintableResult(a1, a2, file), file, outDir)
        }
    }
  }

  /**
   * Write the output of Urls to specified file
   */
  def write(comparison: PrintableResult, apkPath: Path, outDir: Path): Unit = {
    import comparison._
    Files.createDirectories(outDir)
    val logName = "%s_%s_%s.txt".format(apkPath.getFileName.toString, a1, a2)
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

    private[this] val analysisTypes = AnalysisType.values mkString ", "

    head("stringoid")
    opt[AnalysisType]("a1") required() valueName "<analysis1>" action {
      (a1, opts) =>
        opts.copy(analysis1 = a1)
    } text s"first analysis type (one of $analysisTypes)"
    opt[AnalysisType]("a2") required() valueName "<analysis2>" action {
      (a2, opts) =>
        opts.copy(analysis2 = a2)
    } text s"second analysis type (one of $analysisTypes)"
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
        else
          Right(opts)
    }
  }
}
