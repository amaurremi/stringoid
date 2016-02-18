package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IrNodesModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, InterProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.{InterProcStringAppendModule, IntraProcStringAppendModule}
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CallGraph
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object FixedPointAppendIrRetrieverImplementations {

  final class InterProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends FixedPointAppendIrRetriever(config)
    with InterProcIrNodes
    with InterProcStringAppendModule {

    override lazy val callGraph: CallGraph = {
      val conf = if (isApk) configWithApk(config.file) else configWithSrc(config.file)
      new FlexibleCallGraphBuilder()(conf).cg
    }

    override def getNodes: Iterator[CallGraphNode] =
      callGraph.getEntrypointNodes.iterator() map CallGraphNode.apply

    override def hasUrls(node: CallGraphNode): Boolean = true

    override def getUrlsWithSources: UrlsWithSources = {
      val TimeResult(nodes, walaTime) = TimeResult(getNodes)
      val urlsWithSources: Iterator[(Url, Method)] =
        for {
          node <- nodes
          urlMethod <- getConcatUrls(node)
        } yield urlMethod
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap, walaTime)
    }

    private[this] def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
      val appendAutomaton = stringAppends(node, fieldToAutomaton)
      // todo wait for automaton-predicate function
      ???
    }
  }

  abstract class IntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes
    with IntraProcStringAppendModule {

    override def getUrlsWithSources: UrlsWithSources = {
      val TimeResult(nodes, walaTime) = TimeResult(getNodes)
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

    private[this] def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
      val appendAutomaton = stringAppends(node, fieldToAutomaton)
      val ir = node.getIr
      (for {
        vn <- 1 to ir.getSymbolTable.getMaxValueNumber
        stringPart <- urlPrefixes(vn, node)
        stringTail <- (appendAutomaton tails stringPart).iterator take 100
      } yield (Url(parseUrl(node, stringPart +: stringTail)), ir.getMethod.toString)) (breakOut)
    }

    override def hasUrls(node: Node): Boolean =
      1 to node.getIr.getSymbolTable.getMaxValueNumber exists {
        urlPrefixes(_, node).nonEmpty
      }
  }

  final class CgIntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends IntraProcFixedPointAppendIrRetriever(config)
    with CgIntraProcIrNodes

  final class ChaIntraProcFixedPointAppendIrRetriever(config: AnalysisConfig)
    extends IntraProcFixedPointAppendIrRetriever(config)
    with ChaIntraProcIrNodes
}