package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

import scala.collection.JavaConversions._
import scala.collection.breakOut

/**
 * An analysis that retrieves the URLs that occur in a program, mapped to the set
 * of enclosing methods in which the URLs occur.
 */
trait UrlRetriever extends  {

  type Method = String

  type Url
  
  case class UrlsWithSources(uws: Map[Url, Set[Method]]) {
    def printable: Map[String, Set[String]] =
      (uws map {
        case (k, vs) => k.toString -> (vs map {
          _.toString
        })
      })(breakOut)
  }

  protected val URL_REGEX = "https?://[^\" ]+"

  def apply(apkPath: Path): UrlsWithSources

  protected final def configWithApk(apkPath: Path): Config =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
}
