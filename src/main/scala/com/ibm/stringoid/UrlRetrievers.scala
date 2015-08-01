package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

trait UrlRetrievers extends AnalysisTypes with Urls {

  import AnalysisType._

  case class AnalysisConfig(irFromCg: Boolean, ignoreLibs: Boolean)

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

  /**
   * An analysis that retrieves the URLs that occur in a program, mapped to the set
   * of enclosing methods in which the URLs occur.
   */
  trait UrlRetriever {

    protected val URL_PREFIX = "https?://[^\" ]*"
    protected val URL_REGEX  = "https?://[^\" ]+"

    def apply(apkPath: Path): UrlsWithSources

    protected final def configWithApk(apkPath: Path): Config =
      ConfigFactory.load().withValue(
        "wala.dependencies.apk",
        ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
  }

}
