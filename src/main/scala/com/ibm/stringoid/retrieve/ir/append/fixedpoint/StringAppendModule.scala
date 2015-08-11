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

import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.collection.{breakOut, mutable}

trait StringAppendModule extends StringAppendDatastructures {

  private[this] val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this StringBuilder."
  private[this] val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  /**
   * Get the string concatenation results.
   */
  def stringAppends(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): Set[AltStringConcatenation] = {
    val solver  = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val result  = solver.result
    val mapping = solver.atsRefMapping
    val atsRefs: Set[Int] = (solver.graph map {
      bb =>
        result.getOut(bb).index
    })(breakOut)
    atsRefs flatMap {
      ref =>
        mapping(ref).asboToString.values
    }
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, AltStringConcatenation]

    def graph = getGraph

    /**
     * For efficiency we store our AsboToString in this array. The analysis operates on its indices
     * that serve as references to the stored AsboToString objects.
     */
    val atsRefMapping = ArrayBuffer.empty[AsboToString]

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    /**
     * The map from ASBOs to string concatenations
     * @param bb we need to keep track of the basic block in order to see whether a statement
     *           appears in a strongly connected component
     */
    case class AsboToString(asboToString: AsboMap, bb: BB)

    /**
     * A reference to an AsboToString in the [[atsRefMapping]] array
     */
    sealed trait AtsReference extends NodeWithNumber with IVariable[AtsReference]  {

      val index: Int

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(ref: AtsReference): Unit = {
        val asboToString = atsRefMapping(index).asboToString
        asboToString.clear()
        asboToString ++= atsRefMapping(ref.index).asboToString
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
          atsRefMapping += AsboToString(mutable.Map.empty[ASBO, AltStringConcatenation], bb)
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

          def addRhsToLhs(l: AsboMap, r: AsboToString): Unit =
            sccForLhs match  {
              case Some(scc) if scc contains r.bb =>
                r.asboToString foreach {
                  case (asbo, _) =>
                    l += asbo -> AltCycle
                }
              case _                              =>
                r.asboToString foreach {
                  case (asbo, sb1) =>
                    l get asbo match {
                      case Some(sb2) =>
                        l += asbo -> (sb1 | sb2)
                      case None =>
                        l += asbo -> sb1
                    }
                }
            }

          val newMap = mutable.Map.empty[ASBO, AltStringConcatenation]
          rhs foreach {
            rmapRef =>
              addRhsToLhs(newMap, atsRefMapping(rmapRef.index))
          }
          if (newMap == lhsAts.asboToString)
            NOT_CHANGED
          else {
            lhsAts.asboToString ++= newMap
            CHANGED
          }
        }
      }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AtsReference] =
        node.getInstruction match {
          case instr: SSAInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new AppendOperator(asbos, AltAppendArgument(getAppendArgument(instr))) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
            }
          case inv: SSAInvokeInstruction if isSbConstructorWithStringParam(inv) =>
            vnToAsbo get getSbConstructorDef(inv) match {
              case Some(asbos) =>
                new AppendOperator(asbos, AltAppendArgument(getSbConstructorArgument(inv)))
              case None =>
                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
            }
          case _                                                                =>
            IdentityOperator()
        }

        private[this] case class AppendOperator(asbos: Set[ASBO], string: AltStringConcatenation) extends UnaryOperator[AtsReference] {

          override def evaluate(lhs: AtsReference, rhs: AtsReference): Byte = {
            val rhsMap = atsRefMapping(rhs.index).asboToString
            val newMap = mutable.Map.empty[ASBO, AltStringConcatenation] ++= rhsMap
            asbos foreach {
              asbo =>
                val newString = rhsMap get asbo match {
                  case Some(sb) =>
                    sb ++ string
                  case None =>
                    string
                }
                newMap += asbo -> newString
            }
            val lhsMap: AsboMap = atsRefMapping(lhs.index).asboToString
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
            val lhsMap = atsRefMapping(lhs.index).asboToString
            val rhsMap = atsRefMapping(rhs.index).asboToString
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
