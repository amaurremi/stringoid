package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.callgraph.propagation.{LocalPointerKey, PointerKey}
import com.ibm.wala.ssa.{DefUse, IR}

trait Nodes {

  type Identifier

  case class ASBO(identifier: Identifier)

  type Node <: NodeTrait

  sealed trait NodeTrait {

    def getIr: IR

    def getDu: DefUse

    final def isSource: Boolean =
      getIr.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE
  }

  case class IrNode(ir: IR) extends NodeTrait {

    def getIr = ir

    lazy val getDu = new DefUse(ir)
  }

  case class CallGraphNode(node: CGNode) extends NodeTrait {
    def getIr: IR = node.getIR
    def getDu: DefUse = node.getDU
  }

  def createAsbo(vn: ValueNumber, node: Node): ASBO
}

trait IrNodes extends Nodes {

  override type Identifier = ValueNumber

  override type Node = IrNode

  final override def createAsbo(vn: ValueNumber, node: IrNode): ASBO = ASBO(vn)
}

trait CgNodes extends Nodes {

  override type Identifier = PointerKey

  override type Node = CallGraphNode

  final override def createAsbo(vn: ValueNumber, node: CallGraphNode): ASBO = ASBO(new LocalPointerKey(node.node, vn))
}