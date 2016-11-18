package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir._
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.SSAFieldAccessInstruction
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton
import seqset.regular.{ ADFA, ADFADag }

trait StringAutomata extends Nodes {

  type FieldToAutomaton = scala.collection.mutable.Map[FieldReference, StringPartAutomaton]

  def fieldToAutomaton: FieldToAutomaton

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

  // Never make another one !
  implicit val automataDag: ADFADag[StringPart] = ADFA.makeDag[StringPart]()

  val epsilonAuto: StringPartAutomaton = ADFA(Seq.empty[StringPart])

  val emptyAuto: StringPartAutomaton = ADFA.empty[StringPart]

  def newAuto(sp: StringPart): StringPartAutomaton = ADFA(Seq(sp))

  def merge(sps: Iterator[StringPartAutomaton]): StringPartAutomaton =
    sps reduce {
      _ | _
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
