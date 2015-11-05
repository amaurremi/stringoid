package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IrNodesModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, InterProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.{InterProcStringAppendModule, IntraProcStringAppendModule}
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAFieldAccessInstruction}
import com.ibm.wala.util.debug.UnimplementedError
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

object FixedPointAppendIrRetrieverImplementations {

  final class InterProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with InterProcIrNodes
    with InterProcStringAppendModule {

    override lazy val getCallGraph: CallGraph = new FlexibleCallGraphBuilder()(configWithApk(config.file)).cg

    override def getNodes: Iterator[CallGraphNode] = {
      getCallGraph.getEntrypointNodes.iterator() map CallGraphNode.apply
    }

    override def getSource(node: CallGraphNode, vn: ValueNumber): VariableSource = ???

    override def hasUrls(node: CallGraphNode): Boolean = ???

    override protected def getConcatUrls(entryNode: CallGraphNode): scala.Iterable[(Url, Method)] = ???

    override def idToStringPart(node: CallGraphNode, id: Identifier): UrlPart = ???

    override protected def getAutomaton(entryNode: CallGraphNode): (JsonAutomaton, Method) = ???
  }

  abstract class IntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes
    with IntraProcStringAppendModule {

    override def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
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

    override def getAutomaton(node: Node): (JsonAutomaton, Method) = {
      val automaton = stringAppends(node).toDFA.toJson {
        sp: StringPart =>
          stringPartToUrlPart(node, sp).asJson.toString()
      }
      (automaton.toString, node.getIr.getMethod.toString)
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
      if (table isConstant id)
        UrlString((table getConstantValue id).toString)
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
