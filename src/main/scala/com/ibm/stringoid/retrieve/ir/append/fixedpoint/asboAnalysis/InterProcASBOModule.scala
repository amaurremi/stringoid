package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.CgNodes
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ipa.callgraph.propagation.LocalPointerKey
import com.ibm.wala.ssa.SSAInstruction

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  def callGraph: CallGraph

  override def getSolver(node: Node, numbering: AsboMapping) =
    new InterProcAsboFixedPointSolver(callGraph, node, numbering)

  protected def identifierToAsbo: Map[Identifier, Set[ASBO]] =
    callGraph.foldLeft(Map.empty[Identifier, Set[ASBO]]) {
    case (prevMap, n) =>
      val newMap: Map[Identifier, Set[ASBO]] = (for {
        (id, asbos) <- idToAsboForNode(CallGraphNode(n))
        prevAsbos = prevMap getOrElse (id, Set.empty[ASBO])
      } yield id -> (prevAsbos ++ asbos))(breakOut)
      newMap
    }

  class InterProcAsboFixedPointSolver(
    cg: CallGraph,
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getDef(id: LocalPointerKey): SSAInstruction =
      node.getDu getDef id.getValueNumber
  }
}
