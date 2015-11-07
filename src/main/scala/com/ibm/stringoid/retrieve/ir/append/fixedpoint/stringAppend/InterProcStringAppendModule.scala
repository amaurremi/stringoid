package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.ExceptionPrunedCFG
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAPhiInstruction}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  override def getAppendSolver(node: Node, vnToAsbo: Map[Identifier, Set[ASBO]]) =
    new InterProcStringAppendSolver(node, vnToAsbo)

  class InterProcStringAppendSolver(
    node: Node, // should be replaced with CG
    vnToAsbo: Map[Identifier, Set[ASBO]]
   ) extends StringAppendFixedPointSolver(vnToAsbo) {

    override def getGraph = ExceptionPrunedCFG.make(???)

    def initialAtaRefMapping: ArrayBuffer[AsboToAutomaton] = ???

    override protected def transferFunctions: StringAppendTransferFunctions = new InterProcStringAppendTransferFunctions

    class InterProcStringAppendTransferFunctions extends StringAppendTransferFunctions {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get createIdentifier(getFirstSbAppendDef(instr), ???) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, createIdentifier(getAppendArgument(instr), node))
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get createIdentifier(getSbConstructorDef(inv), ???) match {
              case Some(asbos) =>
                val appendArgument = createIdentifier(getSbConstructorArgument(inv), ???)
                new StringBuilderAppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case inv: SSAAbstractInvokeInstruction                                        =>
            ???
          case _                                                                        =>
            IdentityOperator()
        }

      override def getAppendAutomaton(id: Identifier, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) =
        vnToAsbo get id match {
          case Some(asbos) =>
            val automata = for {
              asbo      <- asbos
              automaton <- rhsMap get asbo
            } yield automaton
            val newValNumAutomaton = if (automata.isEmpty)
              singleAutomaton(StringIdentifier(id))
            else
              mergeAutomata(automata)
            (newValNumAutomaton, mutable.Map.empty[ASBO, StringPartAutomaton])
          case None         =>
            node.getDu.getDef(id.getValueNumber) match {
              case phi: SSAPhiInstruction =>
                val uses = 0 until phi.getNumberOfUses map {
                  use =>
                    createIdentifier(phi.getUse(use), node)
                }
                val (automata, asboMaps) = (uses map { getAppendAutomaton(_, rhsMap) }).unzip
                val mergedAutomaton = mergeAutomata(automata)
                val mergedMap = (asboMaps reduceLeft {
                  _ ++ _
                }) + (createAsbo(phi.getDef, node) -> mergedAutomaton)
                (mergedAutomaton, mergedMap)
              case _                      =>
                (singleAutomaton(StringIdentifier(id)), mutable.Map.empty[ASBO, StringPartAutomaton])
            }
        }
    }
  }
}
