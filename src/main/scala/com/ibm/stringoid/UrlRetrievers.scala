package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

trait UrlRetrievers extends AnalysisTypes with FilterTypes with Urls {

  import AnalysisType._, FilterType._

  case class AnalysisConfig(irFromCg: Boolean, ignoreLibs: Boolean, analysis: AnalysisType, filter: FilterType)

  object AnalysisConfig {
    implicit def AnalysisConfigEncodeJson: EncodeJson[AnalysisConfig] =
      jencode3L(
        (ac: AnalysisConfig) => {
          val lib = if (ac.ignoreLibs) "ignoring" else "including"
          val cg  = if (ac.irFromCg) "call graph" else "class hierarchy"
          (prettyPrint(ac.analysis), lib, cg)
        }
      )("analysis type", "libraries", "reachability")

    val default = AnalysisConfig(irFromCg = false, ignoreLibs = true, analysis = Grep, filter = Identity)
  }

  case class AnalysisResult(
    config: AnalysisConfig,
    runningTime: Double,
    urlsWithSources: UrlsWithSources,
    urlsNum: Int
  )

  object AnalysisResult {
    implicit def AnalysisResultEncodeJson: EncodeJson[AnalysisResult] =
      jencode4L(
        (ar: AnalysisResult) => {
          import ar._
          (config, runningTime, urlsWithSources, urlsNum)
        }
      )("configuration", "running time", "urls with sources", "number of URLs")
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
