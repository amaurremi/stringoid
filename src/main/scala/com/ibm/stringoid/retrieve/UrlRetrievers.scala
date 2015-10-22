package com.ibm.stringoid.retrieve

import java.nio.file.{Path, Paths}
import java.util.regex.Pattern

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.ibm.stringoid.{AnalysisTypes, Urls}
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

trait UrlRetrievers extends AnalysisTypes with Urls {

  import AnalysisType._
  import IrSource._
  
  case class AnalysisConfig(irSource: IrSource, ignoreLibs: Boolean, analysis: AnalysisType, file: Path)

  object AnalysisConfig {
    implicit def AnalysisConfigEncodeJson: EncodeJson[AnalysisConfig] =
      jencode3L(
        (ac: AnalysisConfig) => {
          import ac._
          val lib = if (ignoreLibs) "ignoring" else "including"
          (prettyPrintAT(analysis), lib, prettyPrintIS(irSource))
        }
      )("analysis", "libs", "reachability")

    val default = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = ATUnset, Paths.get("src/test/java/testPrograms"))
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

    def getUrlsWithSources: UrlsWithSources

    protected final def configWithApk(apkPath: Path): Config =
      ConfigFactory.load() withValue (
        "wala.dependencies.apk",
        ConfigValueFactory.fromIterable(Seq(apkPath.toString)))

    protected final def configWithSrc(srcDir: Path): Config =
      ConfigFactory.load() withValue (
        "wala.dependencies.source",
        ConfigValueFactory.fromIterable(Seq(srcDir.toString)))
  }

  object UrlRetriever {

    private val URL_PREFIX = "https?://[^\" ]*"
    val URL_REGEX          = "https?://[^\" ]+"

    val urlPrefixPattern = Pattern.compile(URL_PREFIX)
    val urlRegexPattern = Pattern.compile(URL_REGEX)
  }
}
