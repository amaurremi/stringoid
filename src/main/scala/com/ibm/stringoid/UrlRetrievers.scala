package com.ibm.stringoid

import java.nio.file.Path
import java.util.regex.Pattern

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

  import UrlRetriever._

  private[this] def matches(string: String, pattern: Pattern): Boolean = {
    val matcher = pattern matcher string
    matcher.matches
  }

  def isUrlPrefix(string: String): Boolean =
    matches(string, urlPrefixPattern)

  def isUrlRegex(string: String): Boolean =
    matches(string, urlRegexPattern)

  /**
   * An analysis that retrieves the URLs that occur in a program, mapped to the set
   * of enclosing methods in which the URLs occur.
   */
  trait UrlRetriever {

    def apply(apkPath: Path): UrlsWithSources

    protected final def configWithApk(apkPath: Path): Config =
      ConfigFactory.load() withValue (
        "wala.dependencies.apk",
        ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
  }

  object UrlRetriever {

    private val URL_PREFIX = "https?://[^\" ]*"
    val URL_REGEX          = "https?://[^\" ]+"

    val urlPrefixPattern = Pattern.compile(URL_PREFIX)
    val urlRegexPattern = Pattern.compile(URL_REGEX)
  }
}
