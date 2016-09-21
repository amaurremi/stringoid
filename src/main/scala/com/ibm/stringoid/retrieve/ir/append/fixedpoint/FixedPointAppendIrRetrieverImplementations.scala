package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IrNodesModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, InterProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded.{CFG, ExplodedGraphPass, ExplodedStringAppendModule}
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.{InterProcStringAppendModule, IntraProcStringAppendModule}
import com.ibm.stringoid.util.TimeResult

import scala.collection.JavaConversions._
import scala.collection.breakOut

object FixedPointAppendIrRetrieverImplementations {

  final class ExplodedInterProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends InterProcFixedPointAppendIrRetriever(config) with ExplodedGraphPass

  final class ExplodedInterProcFixedPointAppendIrRetrieverOld(config: AnalysisConfig)
    extends InterProcFixedPointAppendIrRetriever(config) with ExplodedStringAppendModule

  final class WalaInterProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends InterProcFixedPointAppendIrRetriever(config) with InterProcStringAppendModule with CFG

  sealed abstract class InterProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends FixedPointAppendIrRetriever(config)
    with InterProcIrNodes {

    def stringAppends(fieldToAutomaton: FieldToAutomaton): StringPartAutomaton

    override def getAllNodes: Iterator[CallGraphNode] =
      callGraph.iterator() map CallGraphNode.apply

    override def hasUrls(node: CallGraphNode): Boolean = hasIr(node)

    override def getUrlsWithSources: UrlsWithSources = {
      val urlsWithSources: Iterator[(Url, Method)] =
        getConcatUrls map  { (_, "interproc") }
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap, -1)
    }

    override protected def getAutomataWithSources = AutomataWithSources(Iterator(getAutomaton), -1)

    /**
      * assumes `node.getIr` is not `null`
      */
    def getAutomaton: (Json, Method) = {
      val automaton = stringAppends(fieldToAutomaton).toDFA.toJson {
        sp: StringPart =>
          stringPartToUrlPart(sp).asJson.toString()
      }
      (automaton.toString.parseOption.get, "interproc")
    }

    private[this] def getConcatUrls: Iterator[Url] = {
      stringAppends(fieldToAutomaton).iterator map {
        stringParts =>
          val urlParts = stringParts map stringPartToUrlPart
          Url(urlParts.toVector)
      }
    }

    protected def stringPartToUrlPart(string: StringPart): UrlPart =
      string match {
        case StringIdentifier(id)        =>
          idToStringPart(CallGraphNode(id.node), id.vn)
        case StaticFieldPart(str)     =>
          UrlString(str)
        case StringCycle                 =>
          UrlWithCycle
        case MissingStringFormatArgument =>
          MissingArgument
        case StringFormatPart(s)         =>
          UrlString(s)
      }
  }

  abstract class IntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes
    with IntraProcStringAppendModule {

    override def getUrlsWithSources: UrlsWithSources = {
      val TimeResult(nodes, walaTime) = TimeResult(getAllNodes)
      val urlsWithSources: Iterator[(Url, Method)] =
        for {
          node <- nodes
          if hasUrls(node)
          urlMethod <- getConcatUrls(node)
        } yield urlMethod
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap, walaTime)
    }

    override protected final def getAutomataWithSources: AutomataWithSources = {
      val TimeResult(nodes, walaTime) = TimeResult(getAllNodes)
      val automataWithSources: Iterator[(Json, Method)] =
        nodes collect {
          case node if hasUrls(node) =>
            getAutomaton(node)
        }
      AutomataWithSources(automataWithSources, walaTime)
    }

    /**
      * assumes `node.getIr` is not `null`
      */
    def getAutomaton(node: Node): (Json, Method) = {
      val automaton = stringAppends(node, fieldToAutomaton).toDFA.toJson {
        sp: StringPart =>
          getStringPartToUrlPart(node, sp).asJson.toString()
      }
      (automaton.toString.parseOption.get, node.getIr.getMethod.toString)
    }

    private[this] def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
      val appendAutomaton = stringAppends(node, fieldToAutomaton)
      val ir = node.getIr
      for {
        vn <- 1 to ir.getSymbolTable.getMaxValueNumber
        stringPart <- urlPrefixes(vn, node)
        stringTail <- (appendAutomaton tails stringPart).iterator take 100
      } yield (Url(parseUrl(node, stringPart +: stringTail)), ir.getMethod.toString)
    }

    private[this] def parseUrl(node: Node, string: Seq[StringPart]): Vector[UrlPart] =
      (string map {
        stringPartToUrlPart(node, _)
      })(breakOut)

    override def hasUrls(node: Node): Boolean = {
      val ir = node.getIr
      Option(ir).isDefined && (1 to ir.getSymbolTable.getMaxValueNumber exists {
        urlPrefixes(_, node).nonEmpty
      })
    }

    protected def stringPartToUrlPart(node: Node, string: StringPart): UrlPart =
      string match {
        case StringIdentifier(id)        =>
          idToStringPart(node, id)
        case StaticFieldPart(str)     =>
          UrlString(str)
        case StringCycle                 =>
          UrlWithCycle
        case MissingStringFormatArgument =>
          MissingArgument
        case StringFormatPart(s)         =>
          UrlString(s)
      }

    def getStringPartToUrlPart(node: Node, sp: StringPart) = stringPartToUrlPart(node, sp)
  }

  final class CgIntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends IntraProcFixedPointAppendIrRetriever(config)
    with CgIntraProcIrNodes

  final class ChaIntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends IntraProcFixedPointAppendIrRetriever(config)
    with ChaIntraProcIrNodes
}