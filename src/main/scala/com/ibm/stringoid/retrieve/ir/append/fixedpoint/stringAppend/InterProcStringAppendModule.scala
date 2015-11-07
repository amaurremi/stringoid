package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.dataflow.graph.AbstractMeetOperator
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.SSAAbstractInvokeInstruction
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  def getAppendSolver = new InterProcStringAppendSolver(identifierToAsbo)

  class InterProcStringAppendSolver(
    idToAsbo: Map[Identifier, Set[ASBO]]
  ) extends StringAppendFixedPointSolver(idToAsbo) {

    type BB = BasicBlockInContext[IExplodedBasicBlock]

    override lazy val cfg = ExplodedInterproceduralCFG.make(getCallGraph)

    /**
      * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
      * that serve as references to the stored AsboToAutomaton objects.
      */
    override def ataRefMapping: ArrayBuffer[AsboToAutomaton] =
      getCallGraph.foldLeft(ArrayBuffer.empty[AsboToAutomaton]) {
        (buffer, node) =>
          buffer ++ initialAtaRefMapping(CallGraphNode(node))
      }

    override protected def transferFunctions: StringAppendTransferFunctions = new InterProcStringAppendTransferFunctions

    class InterProcStringAppendTransferFunctions extends StringAppendTransferFunctions {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] = ???

      /**
        * Resolve the union of all automata to which this value number could map.
        * 1. For each ASBO, checks if value number is in `rhsMap`, and
        *    - if yes, returns automaton;
        *    - if no, checks if val num is a phi instruction,
        *      and if yes, resolves its arguments recursively and adds them to a new AsboMap
        *      with which we will need to update the lhsMap.
        */
      def getAppendAutomaton(node: Node, id: Identifier, rhsMap: AsboMap): (StringPartAutomaton, AsboMap) = ???

      case class StringFormatAppendOperator(inv: SSAAbstractInvokeInstruction, node: Node) extends AbstractAppendOperator {
        override def createNewMap(rhsMap: AsboMap): AsboMap = ???
      }

      case class StringBuilderAppendOperator(asbos: Set[ASBO], id: Identifier) extends AbstractAppendOperator {
        override def createNewMap(rhsMap: AsboMap): AsboMap = ???
      }

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = ???

      case class StringBuilderMeetOperator() extends AbstractMeetOperator[AtaReference] {
        override def evaluate(lhs: AtaReference, rhs: Array[AtaReference]): Byte = ???
      }
    }
  }
}
