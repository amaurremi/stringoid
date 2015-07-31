package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.ibm.stringoid.retrieve.grep.GrepUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.constant.ConstantUrlFromIrRetriever
import com.ibm.stringoid.util.AnalysisConfig
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

trait UrlRetrievers extends AnalysisTypes {

  import AnalysisType._

  def retriever(at: AnalysisType, config: AnalysisConfig): UrlRetriever = at match {
    case Constants =>
      new ConstantUrlFromIrRetriever(config)
    case Append =>
      new FixedPointAppendIrRetriever(config)
    case Grep =>
      GrepUrlRetriever
  }

  /**
   * An analysis that retrieves the URLs that occur in a program, mapped to the set
   * of enclosing methods in which the URLs occur.
   */
  trait UrlRetriever extends Urls {

    import AnalysisType._

    case class AnalysisResult(
      analysis: AnalysisType,
      runningTime: Double,
      urlsWithSources: UrlsWithSources
    )

    object AnalysisResult {
      implicit def AnalysisResultEncodeJson: EncodeJson[AnalysisResult] =
        jencode3L(
          (ar: AnalysisResult) =>
            (ar.analysis, ar.runningTime, ar.urlsWithSources)
        )("analysis", "running-time", "urls-with-sources")
    }

    protected val URL_PREFIX = "https?://[^\" ]*"
    protected val URL_REGEX  = "https?://[^\" ]+"

    def apply(apkPath: Path): AnalysisResult

    protected final def configWithApk(apkPath: Path): Config =
      ConfigFactory.load().withValue(
        "wala.dependencies.apk",
        ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
  }

}
