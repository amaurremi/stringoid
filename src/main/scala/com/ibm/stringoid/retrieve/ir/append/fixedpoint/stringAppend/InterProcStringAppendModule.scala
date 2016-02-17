package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.dataflow.graph.AbstractMeetOperator
import com.ibm.wala.fixpoint.FixedPointConstants._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInvokeInstruction, SSAReturnInstruction}
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  def stringAppends(node: Node, fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    val solver = new InterProcStringAppendSolver(identifierToAsbo, fieldToAutomaton)
    stringAppendsForSolver(solver)
  }

  class InterProcStringAppendSolver(
    idToAsbo: Map[Identifier, Set[ASBO]],
    fieldToAutomaton: Map[FieldReference, StringPartAutomaton]
  ) extends StringAppendFixedPointSolver(idToAsbo, fieldToAutomaton) {

    type BB = BasicBlockInContext[IExplodedBasicBlock]

    override lazy val cfg = ExplodedInterproceduralCFG.make(callGraph)

    /**
      * Creates an initial mapping from ASBOs to automata, which contains constants.
      * At the beginning [[ataRefMapping]] gets assigned this function, but we need to remember its
      * value to later manually add constants to the result.
      */
    override lazy val initialMapping: ArrayBuffer[AsboToAutomaton] =
      callGraph.foldLeft(ArrayBuffer.empty[AsboToAutomaton]) {
        case (buffer, node) =>
          initialAtaRefMapping(buffer, CallGraphNode(node))
      }

    /**
      * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
      * that serve as references to the stored AsboToAutomaton objects.
      */
    override def ataRefMapping: ArrayBuffer[AsboToAutomaton] = initialMapping

    override protected def transferFunctions: StringAppendTransferFunctions = new InterProcStringAppendTransferFunctions

    class InterProcStringAppendTransferFunctions extends StringAppendTransferFunctions(idToAsbo) {

      override def valNum(id: Identifier): ValueNumber = id.getValueNumber

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
          case inv: SSAAbstractInvokeInstruction                                        =>
            new SubstitutionOperator(
              callGraph.getPossibleTargets(node.node, inv.getCallSite).toSet,
              argumentAsbos(inv, node))
//            val assignTo = ASBO(getId(inv.getDef))
//            new StringBuilderAppendOperator(Set(assignTo), getId(inv.getReturnValue(0)))
          case ret: SSAReturnInstruction                                                =>
            val result = getId(ret.getResult)
            val assignTo = callGraph.getSuccNodes(node.node)
            ???
          case _ =>
            IdentityOperator()
        }
      }

      case class SubstitutionOperator(
        targetNodes: Set[CGNode],
        substitutionAsbos: Seq[(ASBO, Int)] // pairs (asbo, argNum) of argument indices (starting at 0) and their corresponding ASBOs
      ) extends UnaryOperator[AtaReference] {

        def createSubstitutionMap(rhsMap: AsboMap): AsboMap = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton] ++= rhsMap
          targetNodes foreach {
             node =>
               val cgNode = CallGraphNode(node)
               substitutionAsbos foreach {
                 case (asbo, paramIndex) =>
                   val paramId = createIdentifier(paramIndex + 1, cgNode)
                   for {
                     paramAsbo <- idToAsbo getOrElse (paramId, Set(ASBO(paramId)))
                     automaton <- rhsMap get asbo
                   } {
                       newMap += (paramAsbo -> automaton)
                   }
               }
          }
          newMap
        }

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = createSubstitutionMap(rhsMap)
          val lhsMap: AsboMap = ataRefMapping(lhs.index).asboToAutomaton

          if (lhsMap == newMap)
            NOT_CHANGED
          else {
            lhsMap ++= newMap
            CHANGED
          }
        }
      }

      /**
        * Do the arguments passed into a call have ASBOS? If yes, get them, together with the argument index
        */
      private[this] def argumentAsbos(instr: SSAAbstractInvokeInstruction, node: Node): Seq[(ASBO, Int)] =
        instr match {
          case inv: SSAInvokeInstruction =>
            for {
              argIndex <- 0 to instr.getNumberOfParameters
              arg       = instr getUse argIndex
              asbos    <- idToAsbo get createIdentifier(arg, node)
              asbo     <- asbos
            } yield (asbo, argIndex)
          case _ => throw new UnsupportedOperationException("TODO handle other invoke instruction!")
        }

      private[this] def hasStringReturnType(inv: SSAAbstractInvokeInstruction): Boolean =
        inv.getDeclaredResultType.toString contains "java/lang/String"

      case class StringFormatAppendOperator(inv: SSAAbstractInvokeInstruction, node: Node) extends AbstractAppendOperator {
        override def createLhsMap(rhsMap: AsboMap): AsboMap = ???
      }

      case class StringBuilderAppendOperator(asbos: Set[ASBO], id: Identifier) extends AbstractAppendOperator {
        override def createLhsMap(rhsMap: AsboMap): AsboMap = ???
      }

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = ???

      case class StringBuilderMeetOperator() extends AbstractMeetOperator[AtaReference] {
        override def evaluate(lhs: AtaReference, rhs: Array[AtaReference]): Byte = ???
      }
    }
  }
}
