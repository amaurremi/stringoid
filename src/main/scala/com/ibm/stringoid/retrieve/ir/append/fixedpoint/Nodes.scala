package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.callgraph.propagation.LocalPointerKey
import com.ibm.wala.ssa.{DefUse, IR}

trait Nodes {

  type Identifier

  case class ASBO(identifier: Identifier)

  type Node <: NodeTrait

  sealed trait NodeTrait {

    def getIr: IR

    def getDu: DefUse

    final def isSource: Boolean = false
//      getIr.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE
  }

  case class IrNode(ir: IR) extends NodeTrait {

    override def getIr = ir

    override lazy val getDu = new DefUse(ir)
  }

  case class CallGraphNode(node: CGNode) extends NodeTrait {
    def getIr: IR = node.getIR
    def getDu: DefUse = node.getDU
  }

  final def createAsbo(vn: ValueNumber, node: Node) = ASBO(createIdentifier(vn, node))

  def createIdentifier(vn: ValueNumber, node: Node): Identifier

  sealed trait StringPart
  case class StringIdentifier(vn: Identifier) extends StringPart
  case class StringFormatPart(string: String) extends StringPart
  case object MissingStringFormatArgument extends StringPart
  case object StringCycle extends StringPart
}

trait IrNodes extends Nodes {

  override type Identifier = ValueNumber

  override type Node = IrNode

  final override def createIdentifier(vn: ValueNumber, node: IrNode) = vn
}

trait CgNodes extends Nodes {

  override type Identifier = LocalPointerKey

  override type Node = CallGraphNode

  final override def createIdentifier(vn: ValueNumber, node: CallGraphNode) = new LocalPointerKey(node.node, vn)
}