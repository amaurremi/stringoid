package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.util.graph.impl.NodeWithNumber
import com.ibm.wala.util.graph.traverse.SCCIterator
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait StringAppendModule {

  private[this] val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this StringBuilder."
  private[this] val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  type ValNumAutomaton = Automaton[StringPart]

  /**
   * Get the string concatenation results.
   */
  def stringAppends(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): ValNumAutomaton = {
    val solver  = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val result  = solver.result
    val mapping = solver.ataRefMapping
    val ataRefs: Set[Int] = (solver.graph map {
      bb =>
        result.getOut(bb).index
    })(breakOut)
    ataRefs.foldLeft(Automaton.empty[StringPart]) {
      (automaton, ref) =>
        val automata = mapping(ref).asboToAutomaton.values
        automaton | automata.foldLeft(Automaton.empty[StringPart]) { _ | _ }
    }
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB      = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, ValNumAutomaton]

    def graph = getGraph

    /**
     * For efficiency we store our AsboToAutomaton in this array. The analysis operates on its indices
     * that serve as references to the stored AsboToAutomaton objects.
     */
    val ataRefMapping = ArrayBuffer.empty[AsboToAutomaton]

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
     * @param bb we need to keep track of the basic block in order to see whether a statement
     *           appears in a strongly connected component
     */
    case class AsboToAutomaton(asboToAutomaton: AsboMap, bb: BB)

    /**
     * A reference to an AsboToAutomaton in the [[ataRefMapping]] array
     */
    sealed trait AtaReference extends NodeWithNumber with IVariable[AtaReference]  {

      val index: Int

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(ref: AtaReference): Unit = {
        val asboToString = ataRefMapping(index).asboToAutomaton
        asboToString.clear()
        asboToString ++= ataRefMapping(ref.index).asboToAutomaton
      }
    }

    case class AtaRefIn(override val index: Int) extends AtaReference
    case class AtaRefOut(override val index: Int) extends AtaReference

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def result: DataflowSolver[BB, AtaReference] = {
      val framework = new IKilldallFramework[BB, AtaReference] {

        override def getFlowGraph = getGraph

        override def getTransferFunctionProvider = transferFunctions
      }

      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] lazy val getGraph = ExplodedControlFlowGraph.make(ir)

    private[this] lazy val stronglyConnectedComponents =
      (new SCCIterator(getGraph) filter { _.size() > 1 }).toSet

    private[this] def getSolver(framework: IKilldallFramework[BB, AtaReference]) =
      new DataflowSolver[BB, AtaReference](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AtaReference = {
          val nextIndex = ataRefMapping.size
          ataRefMapping += AsboToAutomaton(mutable.Map.empty[ASBO, ValNumAutomaton], bb)
          if (in)
            AtaRefIn(nextIndex)
          else
            AtaRefOut(nextIndex)
        }

        override def makeEdgeVariable(src: BB, dst: BB): AtaReference =
          throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

        override def makeStmtRHS(size: ValueNumber): Array[AtaReference] =
          new Array[AtaReference](size)
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AtaReference] {

      override def getMeetOperator: AbstractMeetOperator[AtaReference] = StringMeetOperator()

      case class StringMeetOperator() extends AbstractMeetOperator[AtaReference] {

        override def evaluate(lhs: AtaReference, rhs: Array[AtaReference]): Byte = {
          val lhsAta = ataRefMapping(lhs.index)

          val sccForLhs = stronglyConnectedComponents find { _ contains lhsAta.bb }

          def addRhsToLhs(l: AsboMap, r: AsboToAutomaton): Unit =
            sccForLhs match  {
              case Some(scc) if scc contains r.bb =>
                r.asboToAutomaton foreach {
                  case (asbo, _) =>
                    l += asbo -> (Automaton.empty[StringPart] + Seq(StringCycle))
                }
              case _                              =>
                r.asboToAutomaton foreach {
                  case (asbo, auto1) =>
                    l get asbo match {
                      case Some(auto2) =>
                        l += asbo -> (auto1 | auto2)
                      case None =>
                        l += asbo -> auto1
                    }
                }
            }

          val newMap = mutable.Map.empty[ASBO, ValNumAutomaton]
          rhs foreach {
            rmapRef =>
              addRhsToLhs(newMap, ataRefMapping(rmapRef.index))
          }
          if (newMap == lhsAta.asboToAutomaton)
            NOT_CHANGED
          else {
            lhsAta.asboToAutomaton ++= newMap
            CHANGED
          }
        }
      }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AtaReference] =
        node.getInstruction match {
          case instr: SSAInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new AppendOperator(asbos, getAppendArgument(instr)) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = getSbConstructorArgument(inv)
                new AppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case _                                                                =>
            IdentityOperator()
        }

        private[this] case class AppendOperator(asbos: Set[ASBO], appendVn: ValueNumber) extends UnaryOperator[AtaReference] {

          override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
            val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
            val newMap = mutable.Map.empty[ASBO, ValNumAutomaton] ++= rhsMap
            val appendAutomata: Iterable[ValNumAutomaton] = for {
              asbos     <- (vnToAsbo get appendVn).toIterable
              asbo      <- asbos
              automaton <- rhsMap get asbo
            } yield automaton
            val appendAutomaton =
              if (appendAutomata.isEmpty)
                Automaton.empty[StringPart] + Seq(StringValNum(appendVn))
              else
                appendAutomata.foldLeft(Automaton.empty[StringPart]) { _ | _ }
            asbos foreach {
              asbo =>
                val newString = rhsMap get asbo match {
                  case Some(sb) =>
                    sb +++ appendAutomaton
                  case None =>
                    appendAutomaton
                }
                newMap += asbo -> newString
            }

            val lhsMap: AsboMap = ataRefMapping(lhs.index).asboToAutomaton

            if (lhsMap == newMap)
              NOT_CHANGED
            else {
              lhsMap ++= newMap
              CHANGED
            }
          }
        }

        private[this] case class IdentityOperator() extends UnaryOperator[AtaReference] {

          override def evaluate(lhs: AtaReference, rhs: AtaReference): Byte = {
            val lhsMap = ataRefMapping(lhs.index).asboToAutomaton
            val rhsMap = ataRefMapping(rhs.index).asboToAutomaton
            if (lhsMap == rhsMap)
              NOT_CHANGED
            else {
              lhsMap ++= rhsMap
              CHANGED
            }
          }

          override def isIdentity: Boolean = true
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AtaReference] =
        throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
