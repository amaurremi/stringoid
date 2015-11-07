package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.IntraProcASBOModule
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.ExceptionPrunedCFG
import com.ibm.wala.ssa.analysis.ExplodedControlFlowGraph
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAPhiInstruction}
import seqset.regular.Automaton

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait IntraProcStringAppendModule extends StringAppendModule with IntraProcASBOModule {

  override def getAppendSolver(node: Node, vnToAsbo: Map[Identifier, Set[ASBO]]) =
    new IntraProcStringAppendSolver(node, vnToAsbo)

  class IntraProcStringAppendSolver(
    node: Node,
    vnToAsbo: Map[Identifier, Set[ASBO]]
  ) extends StringAppendFixedPointSolver(node, vnToAsbo) {

    override def getGraph = ExceptionPrunedCFG.make(ExplodedControlFlowGraph.make(node.getIr))

    lazy val initialAtaRefMapping: ArrayBuffer[AsboToAutomaton] = {
      val refMapping = ArrayBuffer.empty[AsboToAutomaton]
      val table = node.getIr.getSymbolTable
      1 to table.getMaxValueNumber foreach {
        vn =>
          if (table isConstant vn) {
            val automaton = Automaton.empty[StringPart] + Seq(StringIdentifier(vn))
            val asboMap = mutable.Map(createAsbo(vn, node) -> automaton)
            refMapping += AsboToAutomaton(asboMap, None)
          }
      }
      refMapping
    }

    override protected def transferFunctions: StringAppendTransferFunctions = new IntraProcStringAppendTransferFunctions

    class IntraProcStringAppendTransferFunctions extends StringAppendTransferFunctions {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] =
        bb.getInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getAppendArgument(instr))
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new StringBuilderAppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node.getDu)
          case _                                                                =>
            IdentityOperator()
        }

      private[this] def getAppendAutomaton(
        vn: Identifier,
        rhsMap: AsboMap,
        processedAcc: Set[Identifier]
      ): (StringPartAutomaton, AsboMap) =
        if (processedAcc contains vn)
          (singleAutomaton(StringCycle), mutable.Map.empty[ASBO, StringPartAutomaton])
        else
          vnToAsbo get vn match {
            case Some(asbos) =>
              val automata = for {
                asbo      <- asbos
                automaton <- rhsMap get asbo
              } yield automaton
              val newValNumAutomaton = if (automata.isEmpty)
                singleAutomaton(StringIdentifier(vn))
              else
                mergeAutomata(automata)
              (newValNumAutomaton, mutable.Map.empty[ASBO, StringPartAutomaton])
            case None         =>
              node.getDu.getDef(vn) match {
                case phi: SSAPhiInstruction =>
                  val uses = 0 until phi.getNumberOfUses map phi.getUse
                  val (automata, asboMaps) = (uses map {
                    u =>
                      getAppendAutomaton(u, rhsMap, processedAcc + vn)
                  }).unzip
                  val mergedAutomaton = mergeAutomata(automata)
                  val mergedMap = (asboMaps reduceLeft {
                    _ ++ _
                  }) + (createAsbo(phi.getDef, node) -> mergedAutomaton)
                  (mergedAutomaton, mergedMap)
                case _                      =>
                  (singleAutomaton(StringIdentifier(vn)), mutable.Map.empty[ASBO, StringPartAutomaton])
              }
          }

      override def getAppendAutomaton(vn: Identifier, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) =
        getAppendAutomaton(vn, rhsMap, Set.empty[Identifier])
    }
  }
}
