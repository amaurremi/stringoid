package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid.retrieve.UrlPartDefs.UrlsWithSources
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

/**
 * An analysis that retrieves the URLs that occur in a program, mapped to the set
 * of enclosing methods in which the URLs occur.
 */
trait UrlRetriever {

  def getUrlsWithSources: UrlsWithSources

  def getResult: String

  protected final def configWithApk(apkPath: Path): Config =
    ConfigFactory.load() withValue (
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq(apkPath.toString)))

  protected final def configWithSrc(srcDir: Path): Config =
    ConfigFactory.load() withValue (
      "wala.dependencies.source",
      ConfigValueFactory.fromIterable(Seq(srcDir.toString)))
}