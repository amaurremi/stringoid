package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir._
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.SSAFieldAccessInstruction
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton

trait StringAutomata extends Nodes {

  type FieldToAutomaton = scala.collection.mutable.Map[FieldReference, SPA]

  def fieldToAutomaton: FieldToAutomaton

  sealed trait StringPart
  case class StringIdentifier(id: Identifier) extends StringPart
  case class StaticFieldPart(string: String) extends StringPart
  case class StringFormatPart(string: String) extends StringPart
  case object MissingStringFormatArgument extends StringPart
  case object StringCycle extends StringPart

  type StringPartAutomaton = Automaton[StringPart]

  case class SPA private[StringAutomata] (auto: StringPartAutomaton) {

    import SPA._

    def |(other: SPA) = SPA(auto | other.auto)

    def +++(other: SPA) = {
      if (isEmpty) other else SPA(auto +++ other.auto)
    }

    def isEmpty = auto == emptyAuto

    def filterHeads(f: StringPart => Boolean) = SPA(auto.filterHeads(f))

    def iterator: Iterator[Seq[StringPart]] = auto.iterator
  }

  object SPA {

    private[StringAutomata] val emptyAuto     = Automaton.empty[StringPart]
    private[this] def newAuto(sp: StringPart) = emptyAuto + Seq(sp)

    def apply(node: Node, id: Identifier): SPA =
      node.getDu getDef valNum(id) match {
        case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
          fieldToAutomaton(instr.getDeclaredField)
        case _                                                                                    =>
          SPA(newAuto(StringIdentifier(id)))
      }

    def apply(sp: StringPart): SPA = SPA(newAuto(sp))

    val empty = SPA(emptyAuto)

    def merge(sps: Iterator[SPA]): SPA= {
      if (sps.isEmpty)
        empty
      else
        sps.reduce {
          _ | _
        }
    }

  }
}

trait IrNodes extends StringAutomata {

  override type Identifier = ValueNumber

  override def valNum(id: Identifier): ValueNumber = id

  override type Node = IrNode

  final override def createId(vn: ValueNumber, node: IrNode) = vn
}

trait CgNodes extends StringAutomata {

  override type Identifier = CgIdentifier

  case class CgIdentifier(node: CGNode, vn: ValueNumber) {

    override val hashCode = node.getGraphNodeId * 23 + vn
  }

  override def valNum(id: Identifier): ValueNumber = id.vn

  override type Node = CallGraphNode

  final override def createId(vn: ValueNumber, node: CallGraphNode) = {
    assert(vn > 0)
    CgIdentifier(node.node, vn)
  }
}