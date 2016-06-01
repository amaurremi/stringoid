package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.CgNodes
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringAppendTypes
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.cast.java.ssa.AstJavaInvokeInstruction
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait InterProcASBOModule extends AbstractStringBuilderModule with StringAppendTypes with CgNodes {

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

  /**
    * Do the arguments passed into a call have ASBOS? If yes, get them, together with the argument index
    */
  protected def argumentAsbos(
    idToAsbo: Map[Identifier, Set[ASBO]],
    instr: SSAAbstractInvokeInstruction,
    node: Node
  ): Seq[(ASBO, Int)] =
    instr match {
      case inv: SSAInvokeInstruction     =>
        argumentAsbosForInstr(idToAsbo, instr.getNumberOfParameters, instr.getUse, node)
      case inv: AstJavaInvokeInstruction =>
        argumentAsbosForInstr(idToAsbo, instr.getNumberOfParameters, instr.getUse, node)
    }

  protected def argumentAsbosForInstr(
    idToAsbo: Map[Identifier, Set[ASBO]],
    paramNum: Int,
    getArg: Int => ValueNumber,
    node: Node
  ): Seq[(ASBO, Int)] =
    for {
      argIndex <- 0 until paramNum
      arg       = getArg(argIndex)
      asbo     <- (idToAsbo getOrElse (createIdentifier(arg, node), Set(createAsbo(arg, node)))).toSeq
    } yield (asbo, argIndex)

  protected def getCallInstructions(
    ret: SSAReturnInstruction,
    callerNode: Node,
    calleeNode: Node
  ): Iterator[SSAAbstractInvokeInstruction] = {
    val node = callerNode.node
    for {
      callSiteRef <- node.iterateCallSites()
      if callSiteRef.getDeclaredTarget == calleeNode.node.getMethod.getReference
      callSite <- node.getIR getCalls callSiteRef
    } yield callSite
  }

  class InterProcAsboFixedPointSolver(
    cg: CallGraph,
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getDef(id: CgIdentifier): SSAInstruction =
      CallGraphNode(id.node).getDu getDef id.vn

    override def getUses(id: Identifier): Iterator[SSAInstruction] =
      CallGraphNode(id.node).getDu getUses id.vn
  }
}
