package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import argonaut.Json
import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IrNodesModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, InterProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.{InterProcStringAppendModule, IntraProcStringAppendModule}
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAFieldAccessInstruction}
import com.ibm.wala.util.debug.UnimplementedError
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object FixedPointAppendIrRetrieverImplementations {

  final class InterProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with InterProcIrNodes
    with InterProcStringAppendModule {

    /**
      * Get the string concatenation results.
      */
    def stringAppends: StringPartAutomaton = ???

    override lazy val getCallGraph: CallGraph = new FlexibleCallGraphBuilder()(configWithApk(config.file)).cg

    override def getNodes: Iterator[CallGraphNode] = {
      getCallGraph.getEntrypointNodes.iterator() map CallGraphNode.apply
    }

    override def getSource(node: CallGraphNode, vn: ValueNumber): VariableSource = ???

    override def hasUrls(node: CallGraphNode): Boolean = ???

    protected def getConcatUrls(entryNode: CallGraphNode): scala.Iterable[(Url, Method)] = ???

    override def idToStringPart(node: CallGraphNode, id: Identifier): UrlPart = ???

    override protected def getAutomaton(entryNode: CallGraphNode): (Json, Method) = ???

    override def getUrlsWithSources: UrlsWithSources = ???
  }

  abstract class IntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes
    with IntraProcStringAppendModule {

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


    def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
      val appendAutomaton = stringAppends(node)
      val ir              = node.getIr
      val table           = ir.getSymbolTable
      (for {
        vn           <- 1 to table.getMaxValueNumber
        if isUrlPrefixVn(vn, table)
        stringValNum  = StringIdentifier(vn)
        stringTail   <- (appendAutomaton tails stringValNum).iterator take 100
      } yield (Url(parseUrl(node, stringValNum +: stringTail)), ir.getMethod.toString))(breakOut)
    }

    override def getAutomaton(node: Node): (Json, Method) = {
      println(node.ir.getMethod.toString)
      val automaton = stringAppends(node).toDFA.toJson {
        sp: StringPart =>
          stringPartToUrlPart(node, sp).asJson.toString()
      }
      (automaton.toString.parseOption.get, node.getIr.getMethod.toString)
    }

    override def hasUrls(node: Node): Boolean = {
      val table = node.getIr.getSymbolTable
      1 to table.getMaxValueNumber exists {
        isUrlPrefixVn(_, table)
      }
    }

    override def idToStringPart(node: Node, id: Identifier): UrlPart = {
      val ir = node.getIr
      val table = ir.getSymbolTable
      if (table isConstant id) {
        val string = if (table isNullConstant id) "null" else (table getConstantValue id).toString
        UrlString(string)
      }
      else {
        val typeName =
          try getTypeAbstraction(ir, id).toString
          catch {
            case _: UnimplementedError =>
              "undefined"
          }
        VariableType(typeName, getSource(node, id))
      }
    }

    override def getSource(node: Node, vn: ValueNumber): VariableSource =
      if (node.getIr.getSymbolTable.isParameter(vn))
        Parameter
      else
        node.getDu.getDef(vn) match {
          case fieldAccess: SSAFieldAccessInstruction =>
            FieldAccess(fieldAccess.getDeclaredField.toString)
          case invoke: SSAAbstractInvokeInstruction   =>
            MethodReturn(invoke.getDeclaredTarget.toString)
          case _                                      =>
            UnknownSource
        }
  }

  final class CgIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with CgIntraProcIrNodes

  final class ChaIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with ChaIntraProcIrNodes
}
