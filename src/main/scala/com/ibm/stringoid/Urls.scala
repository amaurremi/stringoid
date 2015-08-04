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
      )("concat")
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
            case v: VariableType =>
              ("variable", VariableType.VariableTypeEncodeJson.apply(v)) // for some reason v.jencode results in a stack overflow
            case UrlWithCycle =>
              ("cycle", "undefined".jencode)
          }
      )("kind", "value")
  }
  
  sealed trait VariableSource
  
  case object Parameter extends VariableSource
  
  case class MethodReturn(methodName: String) extends VariableSource
  
  case object FieldAccess extends VariableSource

  case object UnknownSource extends VariableSource
  
  case class UrlString(string: String) extends UrlPart {
    override def toString = string
  }

  case class UrlPhi(urls: Set[Url]) extends UrlPart

  case class VariableType(typeName: String, source: VariableSource) extends UrlPart

  object VariableType {

    implicit def VariableTypeEncodeJson: EncodeJson[VariableType] =
      jencode2L(
        (v: VariableType) => {
          val source =
            v.source match {
              case Parameter =>
                "parameter"
              case MethodReturn(methodName) =>
                "method return: " + methodName
              case FieldAccess =>
                "field access"
              case UnknownSource =>
                "other"
            }
          (v.typeName, source)
        }
      )("type", "source")
  }
  
  case object UrlWithCycle extends UrlPart

  type Method = String

  object UrlToMethodsPair {

    implicit def UrlToMethodsPairEncodeJson: EncodeJson[UrlToMethodsPair] =
      jencode2L(
        (um: UrlToMethodsPair) =>
          (um.url, um.methods)
      )("url", "methods")
  }

  // todo List should be a Set but Argonaut doesn't understand it
  case class UrlsWithSources(uws: Map[Url, List[Method]]) {

    def filter(p: ((Url, List[Method])) => Boolean): UrlsWithSources =
      UrlsWithSources(uws filter p)
  }

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
      )("url2methods")
    }
  }
}
