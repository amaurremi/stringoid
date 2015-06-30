package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid._
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

/**
 * An analysis that retrieves the URLs that occur in a program, mapped to the set
 * of enclosing methods in which the URLs occur.
 */
trait UrlRetriever {

  protected val URL_REGEX      = "https?://[^\" ]+"

  def getUrlsWithSources(apkPath: Path): UrlWithSources

  protected final def configWithApk(apkPath: Path): Config =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
}
