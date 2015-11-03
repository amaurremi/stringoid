package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IntraProcIrModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.{InterProcASBOModule, IntraProcASBOModule}
import com.ibm.wala.ipa.callgraph.propagation.{LocalPointerKey, PointerKey}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAFieldAccessInstruction}
import com.ibm.wala.util.debug.UnimplementedError
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

object FixedPointAppendIrRetrieverImplementations {

  final class InterProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with InterProcASBOModule {

    override type Identifier = PointerKey

    override type Node = CallGraphNode

    override def createAsbo(vn: ValueNumber, node: CallGraphNode) = ASBO(new LocalPointerKey(node.node, vn))

    override def getNodes: Iterator[CallGraphNode] = {
      new FlexibleCallGraphBuilder()(configWithApk(config.file)).cg.getEntrypointNodes.iterator() map CallGraphNode.apply
    }

    override def getSource(node: CallGraphNode, vn: ValueNumber): VariableSource = ???

    override def hasUrls(node: CallGraphNode): Boolean = ???

    override protected def getConcatUrls(entryNode: CallGraphNode): scala.Iterable[(Url, Method)] = ???

    override def getAppendArgumentForVn(node: CallGraphNode, vn: ValueNumber): UrlPart = ???
  }

  abstract class IntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes
    with IntraProcASBOModule {

    override def getConcatUrls(node: Node): Iterable[(Url, Method)] = {
      val appendAutomaton = stringAppends(node)
      val ir              = node.getIr
      val table           = ir.getSymbolTable
      (for {
        vn           <- 1 to table.getMaxValueNumber
        if isUrlPrefixVn(vn, table)
        stringValNum  = StringValNum(vn)
        stringTail   <- (appendAutomaton tails stringValNum).iterator take 100
      } yield (Url(parseUrl(node, stringValNum +: stringTail)), ir.getMethod.toString))(breakOut)
    }

    override def hasUrls(node: Node): Boolean = {
      val table = node.getIr.getSymbolTable
      1 to table.getMaxValueNumber exists {
        isUrlPrefixVn(_, table)
      }
    }

    override def getAppendArgumentForVn(node: Node, vn: ValueNumber): UrlPart = {
      val ir = node.getIr
      val table = ir.getSymbolTable
      if (table isConstant vn)
        UrlString((table getConstantValue vn).toString)
      else {
        val typeName =
          try getTypeAbstraction(ir, vn).toString
          catch {
            case _: UnimplementedError =>
              "undefined"
          }
        VariableType(typeName, getSource(node, vn))
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
