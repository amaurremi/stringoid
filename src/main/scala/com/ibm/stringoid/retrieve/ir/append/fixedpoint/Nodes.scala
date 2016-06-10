package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.{DefUse, IR}

trait Nodes {

  val DEBUG = true

  type Identifier

  def valNum(id: Identifier): ValueNumber

  case class ASBO(identifier: Identifier) {
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

  final def createAsbo(vn: ValueNumber, node: Node) = ASBO(createIdentifier(vn, node))

  def createIdentifier(vn: ValueNumber, node: Node): Identifier

  sealed trait StringPart
  case class StringIdentifier(id: Identifier) extends StringPart
  case class StaticFieldPart(string: String) extends StringPart
  case class StringFormatPart(string: String) extends StringPart
  case object MissingStringFormatArgument extends StringPart
  case object StringCycle extends StringPart
}

trait IrNodes extends Nodes {

  override type Identifier = ValueNumber

  override def valNum(id: Identifier): ValueNumber = id

  override type Node = IrNode

  final override def createIdentifier(vn: ValueNumber, node: IrNode) = vn
}

trait CgNodes extends Nodes {

  override type Identifier = CgIdentifier

  case class CgIdentifier(node: CGNode, vn: ValueNumber) {

    override val hashCode = node.getGraphNodeId * 23 + vn
  }

  override def valNum(id: Identifier): ValueNumber = id.vn

  override type Node = CallGraphNode

  final override def createIdentifier(vn: ValueNumber, node: CallGraphNode) = CgIdentifier(node.node, vn)
}