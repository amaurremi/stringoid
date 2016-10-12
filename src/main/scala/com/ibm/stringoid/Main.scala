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
  // -a append --lib false --ir-source interproc -u true -p 1 <apk file>
  // run concatenation analysis
  //           without analyzing libraries
  //                       run the interprocedural analysis
  //                                             output URLs (not automata)
  //                                                     do one pass over the CFG

  def main(args: Array[String]): Unit =
    parser.parse(args, CmdOptions()) foreach { options =>
      import options._
      files foreach {
        file =>
          TimeResult("running stringoid on "+ file.getFileName,
              write(AnalysisResult.fromConfig(config.copy(file = file)), file, outDir, spaces = false))
          }
      }

  def analyseFile(
    analysis: String,
    file: Path,
    irSource: String,
    ignoreLibraries: Boolean,
    outputUrls: Boolean,
    graphPasses: Int
  ) : Try[String] = {
    val config = AnalysisConfig(IrSource.withName(irSource), ignoreLibraries, AnalysisType.withName(analysis), outputUrls = outputUrls, graphPasses = graphPasses, file)
    Try(AnalysisResult.fromConfig(config).asJson.nospaces)
  }

  /**
   * Write the output of the URL retrieval to specified file
   */
  def write(result: AnalysisResult, apkPath: Path, outDir: Path, spaces: Boolean = true): Unit = {
    val logName = "%s_%s_%s.json".format(apkPath.getFileName.toString, result.config.analysis, result.config.irSource)
    Files.createDirectories(outDir)
    val logPath = Paths.get(outDir.toString, logName)
    val json = if (spaces) result.asJson.spaces2 else result.asJson.nospaces
    Files.write(logPath, json.getBytes)
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
        opts.copy(config = opts.config.copy(analysis = analysis))
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
        opts.copy(config = opts.config.copy(ignoreLibs = !includeLibs))
    } text "ignore libraries?"
    opt[IrSource]("ir-source") optional() valueName "<IR source>" action {
      (irSource, opts) =>
        opts.copy(config = opts.config.copy(irSource = irSource))
    } text s"construct call graph to only retrieve URLs in reachable methods? options: $irSources"
    opt[Int]('p', "passes") optional() valueName "<# of graph passes>" action {
      (graphPasses, opts) =>
        opts.copy(config = opts.config.copy(graphPasses = graphPasses))
    }
    arg[Path]("<file>...") unbounded() action {
      (f, opts) =>
        opts.copy(files = opts.files :+ f)
    } text "APK files"
  }
}
