package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.CgNodes
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa.SSAInstruction

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  def callGraph: CallGraph

  override def getSolver(node: Node, numbering: AsboMapping) =
    new InterProcAsboFixedPointSolver(callGraph, node, numbering)

  protected lazy val identifierToAsbo: Map[Identifier, Set[ASBO]] =
    TimeResult("ID-to-ASBO map", callGraph.foldLeft(Map.empty[Identifier, Set[ASBO]]) {
    case (prevMap, n) =>
      val newMap: Map[Identifier, Set[ASBO]] = (for {
        (id, asbos) <- idToAsboForNode(CallGraphNode(n))
        prevAsbos = prevMap getOrElse (id, Set.empty[ASBO])
      } yield id -> (prevAsbos ++ asbos))(breakOut)
      prevMap ++ newMap
    })

  class InterProcAsboFixedPointSolver(
    cg: CallGraph,
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getDef(id: CgIdentifier): SSAInstruction =
      CallGraphNode(id.node).getDu getDef id.vn
  }
}
