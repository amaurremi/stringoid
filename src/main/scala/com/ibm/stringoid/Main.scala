package com.ibm.stringoid

import java.nio.file.{Files, InvalidPathException, Path, Paths}

import argonaut.Argonaut._
import argonaut.Json
import com.ibm.stringoid.util.TimeResult
import scopt.{OptionParser, Read}

import scala.util.Try

object Main extends AnalysisComparison {

  import AnalysisType._

  // Program arguments example for comparison
  // compare --a append --a2 constants --lib false --lib2 false --cg false --cg2 false src/test/resources/cgeo.geocaching.developer-build.apk src/test/resources/playdrone_apks/com.facebook.katana-4947895.apk src/test/resources/playdrone_apks/com.google.android.apps.maps-804010103.apk src/test/resources/playdrone_apks/com.google.android.apps.plus-413339268.apk src/test/resources/playdrone_apks/com.google.android.gm-4900120.apk src/test/resources/playdrone_apks/com.google.android.gms-6183036.apk src/test/resources/playdrone_apks/com.google.android.googlequicksearchbox-300306150.apk src/test/resources/playdrone_apks/com.google.android.street-18102.apk src/test/resources/playdrone_apks/com.google.android.tts-210302120.apk src/test/resources/playdrone_apks/com.google.android.videos-33331.apk src/test/resources/playdrone_apks/com.google.android.youtube-51405300.apk
  // Program arguments example for single analysis
  // single -a append --lib false --cg false src/test/resources/cgeo.geocaching.developer-build.apk src/test/resources/playdrone_apks/com.facebook.katana-4947895.apk src/test/resources/playdrone_apks/com.google.android.apps.maps-804010103.apk src/test/resources/playdrone_apks/com.google.android.apps.plus-413339268.apk src/test/resources/playdrone_apks/com.google.android.gm-4900120.apk src/test/resources/playdrone_apks/com.google.android.gms-6183036.apk src/test/resources/playdrone_apks/com.google.android.googlequicksearchbox-300306150.apk src/test/resources/playdrone_apks/com.google.android.street-18102.apk src/test/resources/playdrone_apks/com.google.android.tts-210302120.apk src/test/resources/playdrone_apks/com.google.android.videos-33331.apk src/test/resources/playdrone_apks/com.google.android.youtube-51405300.apk

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      import options._
      files foreach {
        file =>
          TimeResult.printTime("processing " + file.toString) {
            mode match {
              case Compare        =>
                writeComparison(AnalysisComparisonResult.fromConfigs(config1, config2, file), file, outDir)
              case SingleAnalysis =>
                writeSingleAnalysis(AnalysisResult.fromConfig(config1, file), file, outDir)
            }
          }
      }
    }

  def analyseAPK(
    analysis: String,
    apkPath: Path,
    useCallGraph: Boolean,
    ignoreLibraries: Boolean,
    stringFormat: Boolean
  ) : Try[String] = {
    val config = AnalysisConfig(useCallGraph, ignoreLibraries, stringFormat, AnalysisType.withName(analysis))
    Try(AnalysisResult.fromConfig(config, apkPath).asJson.nospaces)
  }

  /**
   * Write the output of the URL retrieval to specified file
   */
  def writeSingleAnalysis(result: AnalysisResult, apkPath: Path, outDir: Path): Unit = {
    val logName = "%s_%s.json".format(apkPath.getFileName.toString, result.config.analysis)
    write(result.asJson, logName, outDir)
  }

  /**
   * Write the output of the URL comparison to specified file
   */
  def writeComparison(comparison: AnalysisComparisonResult, apkPath: Path, outDir: Path): Unit = {
    import comparison._
    val logName = "%s_%s_%s.json".format(apkPath.getFileName.toString, result1.config.analysis, result2.config.analysis)
    write(comparison.asJson, logName, outDir)
  }

  private[this] def write(json: Json, logName: String, outDir: Path) = {
    Files.createDirectories(outDir)
    val logPath = Paths.get(outDir.toString, logName)
    Files.write(logPath, json.spaces2.getBytes)
  }

  sealed trait AnalysisMode
  case object Compare extends AnalysisMode
  case object SingleAnalysis extends AnalysisMode

  case class CmdOptions (
    mode: AnalysisMode      = Compare,
    config1: AnalysisConfig = AnalysisConfig.default,
    config2: AnalysisConfig = AnalysisConfig.default,
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

    private[this] val analysisTypes = AnalysisType.validValues mkString ", "

    head("stringoid")
    cmd("compare") valueName "compare" action {
      (_, opts) =>
        opts.copy(mode = Compare)
    } text "compare two analyses"
    cmd("single") valueName "single-analysis" action {
      (_, opts) =>
        opts.copy(mode = SingleAnalysis)
    } text "compute URLs for one analysis"
    opt[AnalysisType]('a', "a1") required() valueName "<analysis1>" action {
      (analysis, opts) =>
        opts.copy(config1 = opts.config1.copy(analysis = analysis)) // todo lenses
    } text s"first analysis type (one of $analysisTypes)"
    opt[AnalysisType]("a2") optional() valueName "<analysis2>" action {
      (analysis, opts) =>
        opts.copy(config2 = opts.config2.copy(analysis = analysis)) // todo lenses
    } text s"second analysis type (one of $analysisTypes)"
    opt[Path]('o', "outdir") optional() valueName "<out dir>" action {
      (o, opts) =>
        opts.copy(outDir = o)
    } text "output directory"
    opt[Boolean]("lib") optional() valueName "<include libraries>" action {
      (includeLibs, opts) =>
        opts.copy(config1 = opts.config1.copy(ignoreLibs = !includeLibs)) // todo lenses + invert flag ignoreLibs to includeLibs
    } text "ignore libraries in first analysis?"
    opt[Boolean]("lib2") optional() valueName "<libraries?>" action {
      (includeLibs, opts) =>
        opts.copy(config2 = opts.config2.copy(ignoreLibs = !includeLibs)) // todo lenses + invert flag ignoreLibs to includeLibs
    } text "ignore libraries in second analysis?"
    opt[Boolean]("cg") optional() valueName "<call graph?>" action {
      (irFromCg, opts) =>
        opts.copy(config1 = opts.config1.copy(irFromCg = irFromCg)) // todo lenses
    } text "construct call graph to only retrieve URLs in reachable methods in first analysis?"
    opt[Boolean]("cg2") optional() valueName "<call graph?>" action {
      (irFromCg, opts) =>
        opts.copy(config2 = opts.config2.copy(irFromCg = irFromCg)) // todo lenses
    } text "construct call graph to only retrieve URLs in reachable methods in second analysis?"
    opt[Boolean]('f', "string-format") optional() valueName "<string format?>" action {
      (stringFormat, opts) =>
        opts.copy(config1 = opts.config1.copy(stringFormat = stringFormat)) // todo lenses
    } text "do string format in first analysis?"
    opt[Boolean]("f2") optional() valueName "<string format?>" action { // todo lenses
      (stringFormat, opts) =>
        opts.copy(config2 = opts.config2.copy(stringFormat = stringFormat))
    } text "do string format in second analysis?"
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
    checkConfig {
      opts =>
        validateAnalysisDiffer(opts)
        validateAnalysisPresence(opts)
    }

    private[this] def validate(p: Boolean, message: String): Either[String, Unit] =
      if (p) Left(message) else Right()

    private[this] def validateAnalysisDiffer(opts: CmdOptions): Either[String, Unit] =
      validate(opts.config1 == opts.config2, "Comparing equal analyses")

    private[this] def validateAnalysisPresence(opts: CmdOptions): Either[String, Unit] =
      validate(
        opts.mode == Compare && (opts.config1.analysis == Unset || opts.config2.analysis == Unset),
        "In compare mode, two analyses have to be set"
      )
  }
}
