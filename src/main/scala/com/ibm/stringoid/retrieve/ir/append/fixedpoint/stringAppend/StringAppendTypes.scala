package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.Nodes
import com.ibm.wala.ssa.{SSAFieldAccessInstruction, SSAInstruction}
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton

trait StringAppendTypes extends Nodes {

  def fieldToAutomaton: Map[FieldReference, StringPartAutomaton]

  def createAutomaton(instruction: SSAInstruction, node: Node, id: Identifier): StringPartAutomaton =
    node.getDu getDef valNum(id) match {
      case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
        fieldToAutomaton(instr.getDeclaredField)
      case _                                                                                    =>
        StringPartAutomaton(instruction, StringIdentifier(id))
    }

  case class StringPartAutomaton(automaton: Automaton[StringPart], instructions: Set[Int]) {

    def |(other: StringPartAutomaton) =
      StringPartAutomaton(automaton | other.automaton, instructions ++ other.instructions)

    def +++(other: StringPartAutomaton) =
      StringPartAutomaton(automaton +++ other.automaton, instructions ++ other.instructions)

    def addInstr(instruction: SSAInstruction) = this.copy(instructions = instructions + instruction.iindex)
  }

  object StringPartAutomaton {

    def apply(instruction: SSAInstruction, sps: StringPart*): StringPartAutomaton =
      StringPartAutomaton(Automaton.empty[StringPart] + sps, (Option(instruction) map { _.iindex }).toSet)

    def apply(): StringPartAutomaton =
      StringPartAutomaton(Automaton.empty[StringPart], Set.empty[Int])

    def apply(automaton: Automaton[StringPart]): StringPartAutomaton =
      StringPartAutomaton(automaton, Set.empty[Int])

    def apply(stringPart: StringPart): StringPartAutomaton =
      StringPartAutomaton(Automaton.empty[StringPart] + Seq(stringPart))

    def merge(automata: Iterator[StringPartAutomaton]): StringPartAutomaton =
      if (automata.isEmpty) StringPartAutomaton()
      else automata.reduceLeft { _ | _ }
  }
}
