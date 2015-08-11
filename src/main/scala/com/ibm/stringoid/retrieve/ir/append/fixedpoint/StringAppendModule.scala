package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ipa.cfg.ExceptionPrunedCFG
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.util.graph.impl.NodeWithNumber
import com.ibm.wala.util.graph.traverse.SCCIterator
import trie.Trie

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait StringAppendModule {

  private[this] val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this StringBuilder."
  private[this] val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  type ValNumTrie = Trie[StringPart]

  /**
   * Get the string concatenation results.
   */
  def stringAppends(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): ValNumTrie = {
    val solver  = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val result  = solver.result
    val mapping = solver.atsRefMapping
    val atsRefs: Set[Int] = (solver.graph map {
      bb =>
        result.getOut(bb).index
    })(breakOut)
    atsRefs.foldLeft(Trie.empty[StringPart]) {
      (trie, ref) =>
        val tries = mapping(ref).asboToTrie.values
        trie | tries.foldLeft(Trie.empty[StringPart]) { _ | _ }
    }
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB      = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, ValNumTrie]

    def graph = getGraph

    /**
     * For efficiency we store our AsboToTrie in this array. The analysis operates on its indices
     * that serve as references to the stored AsboToTrie objects.
     */
    val atsRefMapping = ArrayBuffer.empty[AsboToTrie]

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
     * @param bb we need to keep track of the basic block in order to see whether a statement
     *           appears in a strongly connected component
     */
    case class AsboToTrie(asboToTrie: AsboMap, bb: BB)

    /**
     * A reference to an AsboToTrie in the [[atsRefMapping]] array
     */
    sealed trait AtsReference extends NodeWithNumber with IVariable[AtsReference]  {

      val index: Int

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(ref: AtsReference): Unit = {
        val asboToString = atsRefMapping(index).asboToTrie
        asboToString.clear()
        asboToString ++= atsRefMapping(ref.index).asboToTrie
      }
    }

    case class AtsRefIn(override val index: Int) extends AtsReference
    case class AtsRefOut(override val index: Int) extends AtsReference

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def result: DataflowSolver[BB, AtsReference] = {
      val framework = new IKilldallFramework[BB, AtsReference] {

        override def getFlowGraph = getGraph

        override def getTransferFunctionProvider = transferFunctions
      }

      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] lazy val getGraph = ExceptionPrunedCFG.make(ExplodedControlFlowGraph.make(ir))

    private[this] lazy val stronglyConnectedComponents = new SCCIterator(getGraph).toSet

    private[this] def getSolver(framework: IKilldallFramework[BB, AtsReference]) =
      new DataflowSolver[BB, AtsReference](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AtsReference = {
          val nextIndex = atsRefMapping.size
          atsRefMapping += AsboToTrie(mutable.Map.empty[ASBO, ValNumTrie], bb)
          if (in)
            AtsRefIn(nextIndex)
          else
            AtsRefOut(nextIndex)
        }

        override def makeEdgeVariable(src: BB, dst: BB): AtsReference =
          throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

        override def makeStmtRHS(size: ValueNumber): Array[AtsReference] =
          new Array[AtsReference](size)
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AtsReference] {

      override def getMeetOperator: AbstractMeetOperator[AtsReference] = StringMeetOperator()

      case class StringMeetOperator() extends AbstractMeetOperator[AtsReference] {

        override def evaluate(lhs: AtsReference, rhs: Array[AtsReference]): Byte = {
          val lhsAts = atsRefMapping(lhs.index)

          val sccForLhs = stronglyConnectedComponents find {
            scc =>
              scc.size > 1 && (scc contains lhsAts.bb)
          }

          def addRhsToLhs(l: AsboMap, r: AsboToTrie): Unit =
            sccForLhs match  {
              case Some(scc) if scc contains r.bb =>
                r.asboToTrie foreach {
                  case (asbo, _) =>
                    l += asbo -> (Trie.empty[StringPart] + Seq(StringCycle))
                }
              case _                              =>
                r.asboToTrie foreach {
                  case (asbo, trie1) =>
                    l get asbo match {
                      case Some(trie2) =>
                        l += asbo -> (trie1 | trie2)
                      case None =>
                        l += asbo -> trie1
                    }
                }
            }

          val newMap = mutable.Map.empty[ASBO, ValNumTrie]
          rhs foreach {
            rmapRef =>
              addRhsToLhs(newMap, atsRefMapping(rmapRef.index))
          }
          if (newMap == lhsAts.asboToTrie)
            NOT_CHANGED
          else {
            lhsAts.asboToTrie ++= newMap
            CHANGED
          }
        }
      }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AtsReference] =
        node.getInstruction match {
          case instr: SSAInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                val appendArgument = Trie.empty[StringPart] + Seq(StringValNum(getAppendArgument(instr)))
                new AppendOperator(asbos, appendArgument) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                val appendArgument = Trie.empty[StringPart] + Seq(StringValNum(getSbConstructorArgument(inv)))
                new AppendOperator(asbos, appendArgument)
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case _                                                                =>
            IdentityOperator()
        }

        private[this] case class AppendOperator(asbos: Set[ASBO], string: ValNumTrie) extends UnaryOperator[AtsReference] {

          override def evaluate(lhs: AtsReference, rhs: AtsReference): Byte = {
            val rhsMap = atsRefMapping(rhs.index).asboToTrie
            val newMap = mutable.Map.empty[ASBO, ValNumTrie] ++= rhsMap
            asbos foreach {
              asbo =>
                val newString = rhsMap get asbo match {
                  case Some(sb) =>
                    sb +++ string
                  case None =>
                    string
                }
                newMap += asbo -> newString
            }
            val lhsMap: AsboMap = atsRefMapping(lhs.index).asboToTrie
            if (lhsMap == newMap) // todo note: currently lhs will never be equal to newMap, so this method will always return CHANGED!
              NOT_CHANGED
            else {
              lhsMap ++= newMap
              CHANGED
            }
          }
        }

        private[this] case class IdentityOperator() extends UnaryOperator[AtsReference] {

          override def evaluate(lhs: AtsReference, rhs: AtsReference): Byte = {
            val lhsMap = atsRefMapping(lhs.index).asboToTrie
            val rhsMap = atsRefMapping(rhs.index).asboToTrie
            if (lhsMap == rhsMap)
              NOT_CHANGED
            else {
              lhsMap ++= rhsMap
              CHANGED
            }
          }

          override def isIdentity: Boolean = true
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AtsReference] =
        throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
