package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.dataflow.graph.AbstractMeetOperator
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAReturnInstruction}
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  def getAppendSolver(fieldToAutomaton: Map[FieldReference, StringPartAutomaton]) =
    new InterProcStringAppendSolver(identifierToAsbo, fieldToAutomaton)

  class InterProcStringAppendSolver(
    idToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) extends StringAppendFixedPointSolver(idToAsbo, fieldToAutomaton) {

    type BB = BasicBlockInContext[IExplodedBasicBlock]

    override lazy val cfg = ExplodedInterproceduralCFG.make(callGraph)

    /**
      * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
      * that serve as references to the stored AsboToAutomaton objects.
      */
    override def ataRefMapping: ArrayBuffer[AsboToAutomaton] =
      callGraph.foldLeft(ArrayBuffer.empty[AsboToAutomaton]) {
        (buffer, node) =>
          buffer ++ initialAtaRefMapping(CallGraphNode(node))
      }

    override protected def transferFunctions: StringAppendTransferFunctions = new InterProcStringAppendTransferFunctions

    class InterProcStringAppendTransferFunctions extends StringAppendTransferFunctions {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] = {
        val node = CallGraphNode(bb.getNode)
        def getId(vn: ValueNumber) = createIdentifier(vn, node)
        bb.getLastInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                =>
            idToAsbo get getId(getFirstSbAppendDef(instr)) match {
              case Some(asbos) =>
                new StringBuilderAppendOperator(asbos, getId(getAppendArgument(instr)))
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getId(getSbConstructorDef(inv)) match {
              case Some(asbos) =>
                val appendArgument = getId(getSbConstructorArgument(inv))
                new StringBuilderAppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case inv: SSAAbstractInvokeInstruction if hasStringReturnType(inv)            =>
            val assignTo = ASBO(getId(inv.getDef))
            // todo problem: multiple return values
            // todo problem: how do I ensure that by the time we get here, the callee already produced an automaton that it returns?
            new StringBuilderAppendOperator(Set(assignTo), getId(inv.getReturnValue(0)))
          case ret: SSAReturnInstruction                                                =>
            val result = getId(ret.getResult)
            val assignTo = callGraph.getSuccNodes(node.node)
            ???
          case _ =>
            IdentityOperator()
        }
      }

      private[this] def hasStringReturnType(inv: SSAAbstractInvokeInstruction): Boolean =
        inv.getDeclaredResultType.toString contains "java/lang/String"

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
