package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.fixpoint.FixedPointConstants._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait InterProcStringAppendModule extends StringAppendModule with InterProcASBOModule {

  def stringAppends(fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    val solver = new InterProcStringAppendSolver(identifierToAsbo, fieldToAutomaton)
    val automata = stringAppendsForSolver(solver)
    val filteredAutomata: Iterator[StringPartAutomaton] = TimeResult("filter URL automata", automata map {
      auto =>
        StringPartAutomaton(auto.automaton.filterHeads {
          case StringIdentifier(id)     =>
            val table = id.node.getIR.getSymbolTable
            val vn    = id.vn
            (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
          case StaticFieldPart(string)  =>
            isUrlPrefix(string)
          case StringFormatPart(string) =>
            isUrlPrefix(string)
          case _                        => false
        })
    })
    TimeResult("merging filtered automata", StringPartAutomaton.merge(filteredAutomata))
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
    override lazy val initialMapping: AsboMap =
      TimeResult("initial mapping", callGraph.foldLeft(Map.empty[ASBO, StringPartAutomaton]) {
        case (oldMap, node) if Option(node.getIR).isDefined =>
          oldMap ++ initialAtaForNode(CallGraphNode(node))
        case (oldMap, _)                                    =>
          oldMap
      })

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
                new StringBuilderAppendOperator(asbos, id, CallGraphNode(id.node), node, instr)
              case None        =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the idToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator(instr)
            }
          case inv: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            idToAsbo get getId(getSbConstructorDef(inv)) match {
              case Some(asbos) =>
                val appendArgument = getId(getSbConstructorArgument(inv))
                new StringBuilderAppendOperator(asbos, appendArgument, CallGraphNode(appendArgument.node), node, inv)
              case None        =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)                 =>
            new StringFormatAppendOperator(inv, node)
          case inv: SSAAbstractInvokeInstruction                                        =>
            new ParamSubstitutionOperator(
              inv,
              callGraph.getPossibleTargets(node.node, inv.getCallSite).toSet,
              argumentAsbos(idToAsbo, inv, node))
          case ret: SSAReturnInstruction                                                =>
            val lhsAsbos = for {
              callerNode  <- getCallNodes(node)
              callerInstr <- getCallInstructions(ret, callerNode, node)
              if ret.returnsPrimitiveType || hasStringReturnType(callerInstr)  // todo test primitive & void
              callDef      = callerInstr.getDef
              callId       = createIdentifier(callDef, callerNode)
              asbo        <- idToAsbo getOrElse (callId, Set(createAsbo(callDef, callerNode)))
            } yield asbo
            new ReturnOperator(lhsAsbos, ret, node)
          case instr =>
            IdentityOperator(instr)
        }
      }

      private[this] def getCallNodes(node: Node): Iterator[Node] =
        callGraph getPredNodes node.node map CallGraphNode.apply

      /*
       * @param assignAsbos    the ASBOs of the left-hand side of the call (the variable to which the result should be assigned);
       *                       if the function does not return a String, this set should be empty
       */
      case class ReturnOperator(
        lhsAsbos: Iterator[ASBO],
        retInstr: SSAReturnInstruction,
        retNode: Node
      ) extends UnaryOperator[AtaReference] {

        /* l = c()   ... c() { ... return result; } */
        private[this] def addReturnResult(rhsMap: AsboMap): AsboMap = {
          val result = retInstr.getResult
          if (result > 0) {
            val resultId = createIdentifier(result, retNode)
            val newMap = (for {
              resultAsbo <- idToAsbo getOrElse(resultId, Set(createAsbo(result, retNode)))
              lAsbo <- lhsAsbos
              lAuto = rhsMap getOrElse(lAsbo, StringPartAutomaton())
              resultAsboId = createIdentifier(resultAsbo.identifier.vn, CallGraphNode(resultAsbo.identifier.node))
              oldLhs = rhsMap getOrElse(lAsbo, StringPartAutomaton()) // todo replace with createAutomaton
              resultAuto = rhsMap getOrElse(resultAsbo, createAutomaton(retInstr, retNode, resultAsboId))
            } yield lAsbo -> (oldLhs | lAuto | resultAuto))(breakOut)
            rhsMap ++ newMap
          } else rhsMap
        }

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          updateProcessedInstructions(processedRetInstructions, retInstr)

          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = addReturnResult(rhsMap)

          if (ataRefMapping(lhs.index).asboToAutomaton == newMap)
            NOT_CHANGED
          else {
            updateLhs(lhs, newMap)
            CHANGED
          }
        }
      }

      /**
        * @param targetNodes        nodes of the possible callee methods
        * @param substitutionAsbos  pairs (asbo, argNum) of String-argument indices (starting at 0) and their corresponding ASBOs
        */
      case class ParamSubstitutionOperator(
        callInstr: SSAInstruction,
        targetNodes: Set[CGNode],
        substitutionAsbos: Seq[(ASBO, Int)]
      ) extends UnaryOperator[AtaReference] {

        private[this] def createSubstitutionMap(rhsMap: AsboMap): AsboMap = {
          val newPairs: AsboMap = (for {
            node <- targetNodes
            cgNode = CallGraphNode(node)
            (asbo, paramIndex) <- substitutionAsbos
            paramId = createIdentifier(paramIndex + 1, cgNode)
            paramAsbo    <- idToAsbo getOrElse (paramId, Set(ASBO(paramId)))
            oldAutomaton  = rhsMap getOrElse (paramAsbo, StringPartAutomaton())
            automaton     = rhsMap getOrElse (asbo, StringPartAutomaton())
          } yield paramAsbo -> (oldAutomaton | automaton))(breakOut)
          rhsMap ++ newPairs
        }

        override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
          updateProcessedInstructions(processedCallInstructions, callInstr)

          val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
          val newMap = createSubstitutionMap(rhsMap)

          if (ataRefMapping(lhs.index).asboToAutomaton == newMap)
            NOT_CHANGED
          else {
            updateLhs(lhs, newMap)
            CHANGED
          }
        }
      }
    }
  }
}
