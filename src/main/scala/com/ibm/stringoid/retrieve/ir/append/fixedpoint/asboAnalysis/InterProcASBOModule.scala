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

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  def getCallGraph: CallGraph

  override def getSolver(node: Node, numbering: AsboMapping) =
    new InterProcAsboFixedPointSolver(getCallGraph, node, numbering)

  class InterProcAsboFixedPointSolver(
    cg: CallGraph,
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    // todo factor our common code with [[IntraProcASBOModule]]
    lazy val valueNumberGraph: Graph[Identifier] = {
      val graph = new SlowSparseNumberedGraph[Identifier](1)
      def idFor(vn: ValueNumber) = createIdentifier(vn, node)
      def addNode(n: Identifier) = if (!(graph containsNode n)) graph addNode n
      def addDefaultNode(vn: ValueNumber) = addNode(idFor(vn))
      node.getIr.iterateAllInstructions foreach {
        case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)  =>
          getDefs(inv) foreach addDefaultNode // todo unnecessary?
        case inv: SSAAbstractInvokeInstruction if isSbAppend(inv)       =>
          val (firstDef, secondDef) = getSbAppendDefs(inv)                  // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          addDefaultNode(firstDef)
          addDefaultNode(secondDef)
          graph addEdge (idFor(secondDef), idFor(firstDef))
        case inv: SSAAbstractInvokeInstruction if isSbTostring(inv)     =>  // in 1 = 2.toString, 1 is sbDef and 2 is sbUse
          val sbDef = getSbToStringDef(inv)
          val sbUse = getSbToStringUse(inv)
          addDefaultNode(sbDef)
          addDefaultNode(sbUse)
          graph addEdge (idFor(sbUse), idFor(sbDef))
        case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)   =>
          addDefaultNode(inv.getDef)
        case phi: SSAPhiInstruction                                     =>
          val defNode = phi.getDef
          addDefaultNode(defNode)
          getPhiUses(phi) foreach {
            use =>
              addDefaultNode(use)
              graph addEdge (idFor(use), idFor(defNode))
          }
        case call: SSAAbstractInvokeInstruction                         =>
          1 to call.getNumberOfParameters foreach {
            param => // todo add tests where non-string related stuff is passed to methods
              val parameter = idFor(param)
              addNode(parameter)
              cg.getPossibleTargets(node.node, call.getCallSite) foreach { // todo check if possibleTargets is correct
                n =>
                  val argument = createIdentifier(param, CallGraphNode(n)) // todo check param + 1
                  addNode(argument)
                  graph addEdge (parameter, argument)
              }
          }
        case _                                                          =>
        // do  nothing
      }
      graph
    }

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
