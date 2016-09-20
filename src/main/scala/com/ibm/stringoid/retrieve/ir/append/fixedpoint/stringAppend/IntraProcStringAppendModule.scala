package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.IntraProcASBOModule
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded.BackEdges
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.{ExceptionPrunedCFG, PrunedCFG}
import com.ibm.wala.ssa.SSAAbstractInvokeInstruction
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.types.FieldReference
import scala.collection.JavaConversions._

trait IntraProcStringAppendModule extends StringAppendModule with IntraProcASBOModule with BackEdges {

  /**
    * Get the string concatenation results.
    */
  def stringAppends(node: Node, fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    val idToAsbo: Map[ValueNumber, Set[ASBO]] = idToAsboForNode(node)
    val solver: IntraProcStringAppendSolver = getAppendSolver(node, idToAsbo, fieldToAutomaton)
    val automata = stringAppendsForSolver(solver)
    val filteredAutomata: Iterator[StringPartAutomaton] = TimeResult("filter URL automata", automata map {
      auto =>
        auto.filterHeads {
          case StringIdentifier(vn)     =>
            val table = node.getIr.getSymbolTable
            (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
          case StaticFieldPart(string)  =>
            isUrlPrefix(string)
          case StringFormatPart(string) =>
            isUrlPrefix(string)
          case _                        => false
        }
    })
    TimeResult("merging filtered automata", merge(filteredAutomata))

  }

  def getAppendSolver(
    node: Node,
    vnToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) = new IntraProcStringAppendSolver(node, vnToAsbo, fieldToAutomaton)

  class IntraProcStringAppendSolver(
    node: Node,
    idToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) extends StringAppendFixedPointSolver(idToAsbo, fieldToAutomaton) {

    override type BB = IExplodedBasicBlock

    override lazy val initialMapping: AsboMap = initialAtaForNode(node)

    override lazy val cfg = {
      val withCycles = ExplodedControlFlowGraph.make(node.getIr)
      PrunedCFG.make(withCycles, new BackEdgeFilter(withCycles))
    }

    override protected def transferFunctions: StringAppendTransferFunctions = new IntraProcStringAppendTransferFunctions

    class IntraProcStringAppendTransferFunctions extends StringAppendTransferFunctions(idToAsbo) {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            idToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getAppendArgument(instr), node, node, instr)
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator(instr)
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new StringBuilderAppendOperator(asbos, appendArgument, node, node, inv)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case instr                                                                    =>
            IdentityOperator(instr)
        }
    }
  }
}
