package com.ibm.stringoid

import argonaut.Argonaut._
import argonaut._

import scala.collection._

trait Urls {

  case class Url(url: List[UrlPart])

  object Url {
    implicit def UrlEncodeJson: EncodeJson[Url] =
      jencode1L(
        (u: Url) => u.url
      )("concatenation")
  }

  sealed trait UrlPart

  object UrlPart {

    implicit def UrlPartEncodeJson: EncodeJson[UrlPart] =
      jencode2L(
        (urlPart: UrlPart) =>
          urlPart match {
            case UrlString(string) =>
              ("constant", string.jencode)
            case UrlPhi(urls) =>
              ("phis", urls.toList.jencode) // todo why do we need to convert it to a list?
            case UrlPlaceHolder =>
              ("variable", "n/a".jencode)
            case UrlWithCycle =>
              ("cycle", "n/a".jencode)
          }
      )("kind", "value")
  }

  case class UrlString(string: String) extends UrlPart {
    override def toString = string
  }

  case class UrlPhi(urls: Set[Url]) extends UrlPart

  case object UrlPlaceHolder extends UrlPart

  case object UrlWithCycle extends UrlPart

  type Method = String

  object UrlToMethodsPair {

    implicit def UrlToMethodsPairEncodeJson: EncodeJson[UrlToMethodsPair] =
      jencode2L(
        (um: UrlToMethodsPair) =>
          (um.url, um.methods)
      )("url", "found in methods")
  }

  // todo List should be a Set but Argonaut doesn't understand it
  case class UrlsWithSources(uws: Map[Url, List[Method]])

  case class UrlToMethodsPair(url: Url, methods: List[Method])

  object UrlsWithSources {
    implicit def UrlsWithSourcesEncodeJson: EncodeJson[UrlsWithSources] = {
      def jsonMap(uws: Map[Url, List[Method]]): List[UrlToMethodsPair] =
        (uws map {
          case (url, methods) =>
            UrlToMethodsPair(url, methods)
        })(breakOut)
      jencode1L(
        (uws: UrlsWithSources) =>
          jsonMap(uws.uws)
      )("url-to-methods map")
    }
  }
}
