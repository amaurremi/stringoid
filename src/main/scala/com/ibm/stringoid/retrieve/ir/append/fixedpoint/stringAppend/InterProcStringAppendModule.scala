package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.cast.java.ssa.AstJavaInvokeInstruction
import com.ibm.wala.fixpoint.FixedPointConstants._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInstruction, SSAInvokeInstruction, SSAReturnInstruction}
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.mutable

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  /**
    * assumes `node.getIr` is not `null`
    */
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
    override lazy val initialMapping: ImmutableAsboMap =
      callGraph.foldLeft(Map.empty[ASBO, StringPartAutomaton]) {
        case (oldMap, node) if Option(node.getIR).isDefined =>
          oldMap ++ initialAtaForNode(CallGraphNode(node))
        case (oldMap, _)                                    =>
          oldMap
      }

    override protected def transferFunctions: StringAppendTransferFunctions = new InterProcStringAppendTransferFunctions

    class InterProcStringAppendTransferFunctions extends StringAppendTransferFunctions(idToAsbo) {

      override def getNodeTransferFunction(bb: BB): UnaryOperator[AtaReference] = {
        val node = CallGraphNode(bb.getNode)
        def getId(vn: ValueNumber) = createIdentifier(vn, node)
        bb.getLastInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                 =>
            idToAsbo get getId(getFirstSbAppendDef(instr)) match {
              case Some(asbos) =>
                val id = getId(getAppendArgument(instr))
                new StringBuilderAppendOperator(asbos, id, CallGraphNode(id.getNode), node, instr)
              case None        =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getId(getSbConstructorDef(inv)) match {
              case Some(asbos) =>
                val appendArgument = getId(getSbConstructorArgument(inv))
                new StringBuilderAppendOperator(asbos, appendArgument, CallGraphNode(appendArgument.getNode), node, inv)
              case None        =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case inv: SSAAbstractInvokeInstruction                                        =>
            val returnAsbos =
              if (hasStringReturnType(inv))
                idToAsbo getOrElse (getId(inv.getDef), Set(createAsbo(inv.getDef, node)))
              else Set.empty[ASBO]
            new ParamSubstitutionAndReturnOperator(
              callGraph.getPossibleTargets(node.node, inv.getCallSite).toSet,
              argumentAsbos(inv, node),
              returnAsbos,
              inv)
          case _ =>
            IdentityOperator()
        }
      }

      /**
        * @param targetNodes        nodes of the possible callee methods
        * @param substitutionAsbos  pairs (asbo, argNum) of String-argument indices (starting at 0) and their corresponding ASBOs
        * @param returnAsbos        the ASBOs of the left-hand side of the call (the variable to which the result should be assigned);
        *                           if the function does not return a String, this set should be empty
        */
      case class ParamSubstitutionAndReturnOperator(
        targetNodes: Set[CGNode],
        substitutionAsbos: Seq[(ASBO, Int)],
        returnAsbos: Set[ASBO],
        instruction: SSAInstruction
      ) extends UnaryOperator[AtaReference] {

        private[this] def createSubstitutionMap(rhsMap: AsboMap): AsboMap = {
          val newMap = mutable.Map.empty[ASBO, StringPartAutomaton] ++= rhsMap
          targetNodes foreach {
             node =>
               val cgNode = CallGraphNode(node)
               substitutionAsbos foreach {
                 case (asbo, paramIndex) =>
                   val paramId = createIdentifier(paramIndex + 1, cgNode)
                   for {
                     paramAsbo    <- idToAsbo getOrElse (paramId, Set(ASBO(paramId)))
                     oldAutomaton  = rhsMap getOrElse (paramAsbo, StringPartAutomaton())
                     automaton     = rhsMap getOrElse (asbo, StringPartAutomaton())
                   } newMap += (paramAsbo -> (oldAutomaton | automaton))
               }
          }
          newMap
        }

        private[this] def addReturnResult(to: AsboMap, rhsMap: AsboMap) =
          for {
            target <- targetNodes
            if Option(target.getIR).isDefined
            instr  <- target.getIR.iterateNormalInstructions() filter { _.isInstanceOf[SSAReturnInstruction] }
            ret     = instr.asInstanceOf[SSAReturnInstruction]
            result  = ret.getResult
            if result > -1
            id      = createIdentifier(result, CallGraphNode(target))
            asbo   <- returnAsbos
            oldA    = rhsMap getOrElse (asbo, StringPartAutomaton())
          } to += (asbo -> (oldA | createAutomaton(instruction, CallGraphNode(target), id)))

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = createSubstitutionMap(rhsMap)
          addReturnResult(newMap, rhsMap)
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
          case inv: SSAInvokeInstruction     =>
            argumentAsbosForInstr(instr.getNumberOfParameters, instr.getUse, node)
          case inv: AstJavaInvokeInstruction =>
            argumentAsbosForInstr(instr.getNumberOfParameters, instr.getUse, node)
        }

      private[this] def argumentAsbosForInstr(paramNum: Int, getArg: Int => ValueNumber, node: Node): Seq[(ASBO, Int)] =
        for {
          argIndex <- 0 until paramNum
          arg       = getArg(argIndex)
          asbo     <- (idToAsbo getOrElse (createIdentifier(arg, node), Set(createAsbo(arg, node)))).toSeq
        } yield (asbo, argIndex)
    }
  }
}
