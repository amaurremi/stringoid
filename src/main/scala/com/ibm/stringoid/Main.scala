package com.ibm.stringoid

import java.nio.file.{Files, InvalidPathException, Path, Paths}

import argonaut.Argonaut._
import com.ibm.stringoid.util.TimeResult
import scopt.{OptionParser, Read}

object Main extends AnalysisComparison {

  import AnalysisType._

  // Program arguments example
  // --a1 append --a2 constants --lib1 false --lib2 false --cg1 false --cg2 false src/test/resources/cgeo.geocaching.developer-build.apk src/test/resources/playdrone_apks/com.facebook.katana-4947895.apk src/test/resources/playdrone_apks/com.google.android.apps.maps-804010103.apk src/test/resources/playdrone_apks/com.google.android.apps.plus-413339268.apk src/test/resources/playdrone_apks/com.google.android.gm-4900120.apk src/test/resources/playdrone_apks/com.google.android.gms-6183036.apk src/test/resources/playdrone_apks/com.google.android.googlequicksearchbox-300306150.apk src/test/resources/playdrone_apks/com.google.android.street-18102.apk src/test/resources/playdrone_apks/com.google.android.tts-210302120.apk src/test/resources/playdrone_apks/com.google.android.videos-33331.apk src/test/resources/playdrone_apks/com.google.android.youtube-51405300.apk

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      import options._
      files foreach {
        file =>
          TimeResult.printTime("processing " + file.toString) {
            write(AnalysisComparisonResult(config1, config2, file), file, outDir)
          }
      }
    }

  /**
   * Write the output of Urls to specified file
   */
  def write(comparison: AnalysisComparisonResult, apkPath: Path, outDir: Path): Unit = {
    import comparison._
    Files.createDirectories(outDir)
    val logName = "%s_%s_%s.json".format(apkPath.getFileName.toString, result1.config.analysis, result2.config.analysis)
    val logPath = Paths.get(outDir.toString, logName)
    Files.write(logPath, comparison.asJson.spaces2.getBytes) // todo is this bad?
  }

  case class CmdOptions (
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

    private[this] val analysisTypes = AnalysisType.values mkString ", "

    head("stringoid")
    opt[AnalysisType]("a1") required() valueName "<analysis1>" action {
      (analysis, opts) =>
        opts.copy(config1 = opts.config1.copy(analysis = analysis)) // todo lenses
    } text s"first analysis type (one of $analysisTypes)"
    opt[AnalysisType]("a2") required() valueName "<analysis2>" action {
      (analysis, opts) =>
        opts.copy(config2 = opts.config2.copy(analysis = analysis)) // todo lenses
    } text s"second analysis type (one of $analysisTypes)"
    opt[Path]('o', "outdir") optional() valueName "<out dir>" action {
      (o, opts) =>
        opts.copy(outDir = o)
    } text "output directory"
    opt[Boolean]("lib1") optional() valueName "<include libraries>" action {
      (includeLibs, opts) =>
        opts.copy(config1 = opts.config1.copy(ignoreLibs = !includeLibs)) // todo lenses + invert flag ignoreLibs to includeLibs
    } text "ignore libraries in first analysis?"
    opt[Boolean]("lib2") optional() valueName "<libraries?>" action {
      (includeLibs, opts) =>
        opts.copy(config2 = opts.config2.copy(ignoreLibs = !includeLibs)) // todo lenses + invert flag ignoreLibs to includeLibs
    } text "ignore libraries in second analysis?"
    opt[Boolean]("cg1") optional() valueName "<call graph?>" action {
      (irFromCg, opts) =>
        opts.copy(config1 = opts.config1.copy(irFromCg = irFromCg)) // todo lenses
    } text "construct call graph to only retrieve URLs in reachable methods in first analysis?"
    opt[Boolean]("cg2") optional() valueName "<call graph?>" action {
      (irFromCg, opts) =>
        opts.copy(config2 = opts.config2.copy(irFromCg = irFromCg)) // todo lenses
    } text "construct call graph to only retrieve URLs in reachable methods in second analysis?"
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
    checkConfig {
      opts =>
        if (opts.config1 == opts.config2)
          Left("Comparing equal analyses")
        else
          Right(opts)
    }
  }
}
