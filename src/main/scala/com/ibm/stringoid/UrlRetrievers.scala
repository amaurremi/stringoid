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
      jencode4L(
        (ac: AnalysisConfig) => {
          import ac._
          val lib = if (ignoreLibs) "ignoring" else "including"
          val cg  = if (irFromCg) "call graph" else "class hierarchy"
          (prettyPrint(analysis), lib, cg, stringFormat)
        }
      )("analysis", "libs", "reachability", "string-format")

    val default = AnalysisConfig(irFromCg = false, ignoreLibs = true, stringFormat = true, analysis = Unset)
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
