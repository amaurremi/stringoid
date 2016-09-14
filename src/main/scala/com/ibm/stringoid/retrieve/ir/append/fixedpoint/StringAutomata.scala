package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir._
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.SSAFieldAccessInstruction
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton

trait StringAutomata extends Nodes {

  def fieldToAutomaton: Map[FieldReference, StringPartAutomaton]

  def createAutomaton(node: Node, id: Identifier): StringPartAutomaton =
    node.getDu getDef valNum(id) match {
      case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
        fieldToAutomaton(instr.getDeclaredField)
      case _                                                                                    =>
        newAuto(StringIdentifier(id))
    }

  sealed trait StringPart
  case class StringIdentifier(id: Identifier) extends StringPart
  case class StaticFieldPart(string: String) extends StringPart
  case class StringFormatPart(string: String) extends StringPart
  case object MissingStringFormatArgument extends StringPart
  case object StringCycle extends StringPart

  type StringPartAutomaton = Automaton[StringPart]

  def emptyAuto = Automaton.empty[StringPart]

  def newAuto(sp: StringPart): StringPartAutomaton = emptyAuto + Seq(sp)

  def merge(sps: Iterator[StringPartAutomaton]): StringPartAutomaton = {
    sps.foldLeft(emptyAuto) {
      _ | _
    }
  }
}

trait IrNodes extends StringAutomata {

  override type Identifier = ValueNumber

  override def valNum(id: Identifier): ValueNumber = id

  override type Node = IrNode

  final override def createIdentifier(vn: ValueNumber, node: IrNode, isReturn: Boolean = false) = vn
}

trait CgNodes extends StringAutomata {

  override type Identifier = CgIdentifier

  case class CgIdentifier(node: CGNode, vn: ValueNumber, isReturn: Boolean = false) {

    override val hashCode = node.getGraphNodeId * 23 + vn

    override def equals(obj: Any): Boolean = {
      obj match {
          // ignoring `isReturn`
        case CgIdentifier(n, v, _) =>
          n == node && v == vn
        case _                     =>
          false
      }
    }
  }

  override def valNum(id: Identifier): ValueNumber = id.vn

  override type Node = CallGraphNode

  final override def createIdentifier(vn: ValueNumber, node: CallGraphNode, isReturn: Boolean = false) =
    CgIdentifier(node.node, vn, isReturn)
}