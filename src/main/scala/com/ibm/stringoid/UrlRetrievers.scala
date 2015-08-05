package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

trait UrlRetrievers extends AnalysisTypes with Urls {

  import AnalysisType._

  case class AnalysisConfig(irFromCg: Boolean, ignoreLibs: Boolean, stringFormat: Boolean, analysis: AnalysisType)

  object AnalysisConfig {
    implicit def AnalysisConfigEncodeJson: EncodeJson[AnalysisConfig] =
      jencode3L(
        (ac: AnalysisConfig) => {
          val lib = if (ac.ignoreLibs) "ignoring" else "including"
          val cg  = if (ac.irFromCg) "call graph" else "class hierarchy"
          (prettyPrint(ac.analysis), lib, cg)
        }
      )("analysis", "libs", "reachability")

    val default = AnalysisConfig(irFromCg = false, ignoreLibs = true, stringFormat = false, analysis = Unset)
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
