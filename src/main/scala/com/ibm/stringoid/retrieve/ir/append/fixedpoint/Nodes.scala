package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.{DefUse, IR}

trait Nodes {

  val DEBUG = false

  type Identifier

  def valNum(id: Identifier): ValueNumber

  trait ASBO {
    val identifier: Identifier
    override val hashCode = identifier.hashCode
  }

  type Node <: NodeTrait

  def hasIr(node: Node) = Option(node.getIr).isDefined

  sealed trait NodeTrait {

    def getIr: IR

    def getDu: DefUse

    final def isSource: Boolean =
      getIr.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE
  }

  case class IrNode(ir: IR) extends NodeTrait {

    override def getIr = ir

    override lazy val getDu = new DefUse(ir)
  }

  case class CallGraphNode(node: CGNode) extends NodeTrait {
    def getIr: IR = node.getIR
    def getDu: DefUse = node.getDU
  }

  def createAsbo(id: Identifier): ASBO

  def createId(vn: ValueNumber, node: Node): Identifier
}