package com.ibm.stringoid

import java.nio.file.{Files, InvalidPathException, Path, Paths}

import argonaut.Argonaut._
import com.ibm.stringoid.AnalysisTypeObject.AnalysisType._
import com.ibm.stringoid.AnalysisTypeObject._
import com.ibm.stringoid.IrSourceObject.IrSource._
import com.ibm.stringoid.IrSourceObject._
import com.ibm.stringoid.util.TimeResult
import scopt.{OptionParser, Read}

import scala.util.Try

object Main extends StringoidAnalysis {

  // Program arguments example
  // -a append --lib false --ir-source cha -u true <apk file>
  // failing
  // /Users/amaurremi/uw/stringoid/src/test/resources/failing/at.software.vn.facechanger-62.apk
  // /Users/amaurremi/uw/stringoid/src/test/resources/failing/com.minifactory.topsnipershooting-2.apk
  // /Users/amaurremi/uw/stringoid/src/test/resources/failing/com.myjoapps.textdecorator-10.apk
  // /Users/amaurremi/uw/stringoid/src/test/resources/failing/com.teslacoilsw.notifier-700.apk
  // /Users/amaurremi/uw/stringoid/src/test/resources/failing/jp.cbrains-15.apk

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      import options._
      files foreach {
        file =>
          TimeResult.printTime("processing " + file.toString) {
              write(AnalysisResult.fromConfig(config.copy(file = file)), file, outDir)
            }
          }
      }

  def analyseFile(
    analysis: String,
    file: Path,
    irSource: String,
    ignoreLibraries: Boolean,
    outputUrls: Boolean
  ) : Try[String] = {
    val config = AnalysisConfig(IrSource.withName(irSource), ignoreLibraries, AnalysisType.withName(analysis), outputUrls = outputUrls, file)
    Try(AnalysisResult.fromConfig(config).asJson.nospaces)
  }

  /**
   * Write the output of the URL retrieval to specified file
   */
  def write(result: AnalysisResult, apkPath: Path, outDir: Path): Unit = {
    val logName = "%s_%s.json".format(apkPath.getFileName.toString, result.config.analysis)
    Files.createDirectories(outDir)
    val logPath = Paths.get(outDir.toString, logName)
    Files.write(logPath, result.asJson.spaces2.getBytes)
  }

  case class CmdOptions (
    config: AnalysisConfig = AnalysisConfig.default,
    outDir: Path            = Paths.get("target", "retrieved-urls"),
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
    private[this] val irSources = IrSource.validValues mkString ", "

    head("stringoid")
    opt[AnalysisType]('a', "analysis") required() valueName "<analysis type>" action {
      (analysis, opts) =>
        opts.copy(config = opts.config.copy(analysis = analysis)) // todo lenses
    } text s"analysis type (one of $analysisTypes)"
    opt[Boolean]('u', "urls") optional() valueName "<output URLs?>" action {
      (outputUrls, opts) =>
        opts.copy(config = opts.config.copy(outputUrls = outputUrls))
    } text "JSON-output URLs instead of automata?"
    opt[Path]('o', "outdir") optional() valueName "<out dir>" action {
      (o, opts) =>
        opts.copy(outDir = o)
    } text "output directory"
    opt[Boolean]("lib") optional() valueName "<include libraries>" action {
      (includeLibs, opts) =>
        opts.copy(config = opts.config.copy(ignoreLibs = !includeLibs)) // todo lenses + invert flag ignoreLibs to includeLibs
    } text "ignore libraries?"
    opt[IrSource]("ir-source") optional() valueName "<IR source>" action {
      (irSource, opts) =>
        opts.copy(config = opts.config.copy(irSource = irSource)) // todo lenses
    } text s"construct call graph to only retrieve URLs in reachable methods? options: $irSources"
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
  }
}
