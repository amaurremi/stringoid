package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid._
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._

trait UrlRetriever {

  val TEST_RESOURCES = "src/test/resources/"
  val URL_REGEX      = "https?://[^\" ]+"

  def getUrlsWithSources(apkPath: Path): UrlWithSources

  final def configWithApk(apkPath: Path): Config =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
}
