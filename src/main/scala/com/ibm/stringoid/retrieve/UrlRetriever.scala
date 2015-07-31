package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid.AnalysisComparison.AnalysisResult
import com.ibm.stringoid.Urls
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

/**
 * An analysis that retrieves the URLs that occur in a program, mapped to the set
 * of enclosing methods in which the URLs occur.
 */
trait UrlRetriever extends Urls {

  protected val URL_PREFIX = "https?://[^\" ]*"
  protected val URL_REGEX  = "https?://[^\" ]+"

  def apply(apkPath: Path): AnalysisResult

  protected final def configWithApk(apkPath: Path): Config =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
}
