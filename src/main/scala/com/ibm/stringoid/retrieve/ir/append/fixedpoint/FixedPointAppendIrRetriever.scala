package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlCheck.isUrlPrefix
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringAppendModule
import com.ibm.stringoid.retrieve.ir.{IrUrlRetriever, ValueNumber}
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ssa._

import scala.collection.breakOut

abstract class FixedPointAppendIrRetriever(
  override val config: AnalysisConfig
)
  extends IrUrlRetriever
  with StringAppendModule {

  override def getUrlsWithSources: UrlsWithSources = {
    val TimeResult(nodes, walaTime) = TimeResult(getNodes)
    val urlsWithSources: Iterator[(Url, Method)] =
      for {
        node      <- nodes
        if hasUrls(node)
        urlMethod <- getConcatUrls(node)
      } yield urlMethod
    val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, method)) =>
        val prevMethods = prevMap getOrElse (url, Set.empty[Method])
        prevMap updated(url, prevMethods + method)
    }
    UrlsWithSources(urlWithSourcesMap, walaTime)
  }

  def hasUrls(node: Node): Boolean

  protected def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
    (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

  protected def getConcatUrls(entryNode: Node): Iterable[(Url, Method)]

  protected def parseUrl(node: Node, string: Seq[StringPart]): Vector[UrlPart] =
    (string map {
      case StringValNum(vn)            =>
        getAppendArgumentForVn(node, vn)
      case StringCycle                 =>
        UrlWithCycle
      case MissingStringFormatArgument =>
        MissingArgument
      case StringFormatPart(s)         =>
        UrlString(s)
    })(breakOut)

  def getAppendArgumentForVn(node: Node, vn: ValueNumber): UrlPart

  def getSource(node: Node, vn: ValueNumber): VariableSource
}
