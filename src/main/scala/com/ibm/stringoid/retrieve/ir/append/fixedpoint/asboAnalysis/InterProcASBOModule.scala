package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.CgNodes
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAPhiInstruction}
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  def getCallGraph: CallGraph

  override def getSolver(node: Node, numbering: AsboMapping) =
    new InterProcAsboFixedPointSolver(getCallGraph, node, numbering)

  protected def identifierToAsbo: Option[Map[Identifier, Set[ASBO]]] = {
    val result: Map[Identifier, Set[ASBO]] =
      getCallGraph.foldLeft(Map.empty[Identifier, Set[ASBO]]) {
      case (prevMap, n) =>
        val newMap: Map[Identifier, Set[ASBO]] = (for {
          (id, asbos) <- idToAsboForNode(CallGraphNode(n))
          prevAsbos = prevMap getOrElse(id, Set.empty[ASBO])
        } yield id -> (prevAsbos ++ asbos))(breakOut)
        newMap
    }
    Some(result)
  }

  class InterProcAsboFixedPointSolver(
    cg: CallGraph,
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getTransferFunctions = new InterProcStringBuilderTransferFunctions

    class InterProcStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(vn: Identifier): UnaryOperator[BitVectorVariable] = ???

      override def getEdgeTransferFunction(src: Identifier, dst: Identifier): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
