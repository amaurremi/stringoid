package com.ibm.stringoid.retrieve

import argonaut.Argonaut._
import argonaut.{EncodeJson, Json}

import scala.collection.breakOut

object UrlPartDefs {

  type Method = String

  case class Url(url: Vector[UrlPart])

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
            case UrlPhi(urls)      =>
              ("phis", urls.toList.jencode) // todo why do we need to convert it to a list?
            case v: VariableType   =>
              ("variable", VariableType.VariableTypeEncodeJson.apply(v)) // for some reason v.jencode results in a stack overflow
            case UrlWithCycle      =>
              ("cycle", "undefined".jencode)
            case MissingArgument   =>
              ("missing", "undefined".jencode)
          }
      )("kind", "value")
  }

  sealed trait VariableSource

  case object Parameter extends VariableSource

  case class MethodReturn(methodName: String) extends VariableSource

  case class FieldAccess(fieldName: String) extends VariableSource

  case object UnknownSource extends VariableSource

  case class UrlString(string: String) extends UrlPart {
    override def toString = string
  }

  case object MissingArgument extends UrlPart

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
              case FieldAccess(name) =>
                "field access: " + name
              case UnknownSource =>
                "other"
            }
          (v.typeName, source)
        }
      )("type", "source")
  }

  case object UrlWithCycle extends UrlPart

  object UrlToMethodsPair {

    implicit def UrlToMethodsPairEncodeJson: EncodeJson[UrlToMethodsPair] =
      jencode2L(
        (um: UrlToMethodsPair) =>
          (um.url, um.methods.toList)
      )("url", "methods")
  }

  case class AutomataWithSources(aws: Iterator[(Json, Method)], walaTime: Double)

  case class UrlsWithSources(uws: Map[Url, Set[Method]], walaTime: Double) {

    def filter(p: ((Url, Set[Method])) => Boolean): UrlsWithSources =
      UrlsWithSources(uws filter p, walaTime)
  }

  case class UrlToMethodsPair(url: Url, methods: Set[Method])

  object UrlsWithSources {
    implicit def UrlsWithSourcesEncodeJson: EncodeJson[UrlsWithSources] = {
      def jsonMap(uws: Map[Url, Set[Method]]): Vector[UrlToMethodsPair] =
        (uws map {
          case (url, methods) =>
            UrlToMethodsPair(url, methods)
        })(breakOut)
      jencode2L(
        (uws: UrlsWithSources) =>
          (jsonMap(uws.uws), uws.walaTime)
      )("url2methods", "wala-time")
    }
  }
}
