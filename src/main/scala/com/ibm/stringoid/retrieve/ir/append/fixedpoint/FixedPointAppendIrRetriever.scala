package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import argonaut.Json
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

  override def getResult: Json =
    if (config.outputUrls)
      getUrlsWithSources.asJson
    else
      getAutomataWithSources.aws.toList.asJson

  def getAutomataWithSources: AutomataWithSources = {
    val TimeResult(nodes, walaTime) = TimeResult(getNodes)
    val automataWithSources: Iterator[(Json, Method)] =
      for {
        node <- nodes
        if hasUrls(node)
      } yield getAutomaton(node)
    AutomataWithSources(automataWithSources, walaTime)
  }

  def hasUrls(node: Node): Boolean

  protected def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
    (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

  protected def getAutomaton(entryNode: Node): (Json, Method)

  protected def parseUrl(node: Node, string: Seq[StringPart]): Vector[UrlPart] =
    (string map {
      stringPartToUrlPart(node, _)
    })(breakOut)

  protected def stringPartToUrlPart(node: Node, string: StringPart): UrlPart =
    string match {
      case StringIdentifier(id)            =>
        idToStringPart(node, id)
      case StringCycle                 =>
        UrlWithCycle
      case MissingStringFormatArgument =>
        MissingArgument
      case StringFormatPart(s)         =>
        UrlString(s)
    }

  def idToStringPart(node: Node, id: Identifier): UrlPart

  def getSource(node: Node, vn: ValueNumber): VariableSource
}
