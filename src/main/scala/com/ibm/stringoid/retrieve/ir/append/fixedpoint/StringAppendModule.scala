package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.util.graph.impl.NodeWithNumber
import com.ibm.wala.util.graph.traverse.SCCIterator

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

trait StringAppendModule extends StringAppendDatastructures {

  private[this] val MISSING_STRING_BUILDER_MESSAGE: String =
    "Value-number-to-ASBO map should contain the value number for this StringBuilder."
  private[this] val EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE: String =
    "No edge transfer functions for StringAppend fixed-point solver."

  /**
   * Get the string concatenation result corresponding to the last instruction containing a ASBO-to-string map
   */
  def stringAppendsAtEnd(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): Set[AltStringConcatenation] = {
    val solver = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val result = solver.result
    (solver.graph flatMap {
      bb =>
        result.getOut(bb).asboToString.values
    })(breakOut)
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, AltStringConcatenation]

    def graph = getGraph

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    sealed abstract class AsboToString(val bb: BB) extends NodeWithNumber with IVariable[AsboToString]  {
      val asboToString: AsboMap

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(v: AsboToString): Unit = {
        asboToString.clear()
        asboToString ++= v.asboToString
      }
    }

    case class AsboToStringIn(asboToString: AsboMap, override val bb: BB) extends AsboToString(bb)
    case class AsboToStringOut(asboToString: AsboMap, override val bb: BB) extends AsboToString(bb)

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def result: DataflowSolver[BB, AsboToString] = {
      val framework = new IKilldallFramework[BB, AsboToString] {

        override def getFlowGraph = getGraph

        override def getTransferFunctionProvider = transferFunctions
      }

      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] lazy val getGraph = ExplodedControlFlowGraph.make(ir)

    private[this] lazy val stronglyConnectedComponents = new SCCIterator(getGraph).toSet

    private[this] def getSolver(framework: IKilldallFramework[BB, AsboToString]) =
      new DataflowSolver[BB, AsboToString](framework) {

        override def makeNodeVariable(bb: BB, in: Boolean): AsboToString =
          if (in)
            AsboToStringIn(mutable.Map.empty[ASBO, AltStringConcatenation], bb)
          else
            AsboToStringOut(mutable.Map.empty[ASBO, AltStringConcatenation], bb)

        override def makeEdgeVariable(src: BB, dst: BB): AsboToString =
          throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

        override def makeStmtRHS(size: ValueNumber): Array[AsboToString] =
          new Array[AsboToString](size)
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AsboToString] {

      override def getMeetOperator: AbstractMeetOperator[AsboToString] = StringMeetOperator()

      case class StringMeetOperator() extends AbstractMeetOperator[AsboToString] {

        override def evaluate(lhs: AsboToString, rhs: Array[AsboToString]): Byte = {
          val sccForLhs = stronglyConnectedComponents find {
            scc =>
              scc.size > 1 && (scc contains lhs.bb)
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
            rmap =>
              addRhsToLhs(newMap, rmap)
          }
          if (newMap == lhs.asboToString)
            NOT_CHANGED
          else {
            lhs.asboToString ++= newMap
            CHANGED
          }
        }
      }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AsboToString] =
        node.getInstruction match {
          case instr: SSAInvokeInstruction if isSbAppend(instr)                =>
            vnToAsbo get getFirstSbAppendDef(instr) match {
              case Some(asbos) =>
                new AppendOperator(asbos, AltAppendArgument(getAppendArgument(instr))) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                // todo note that this means that we are appending to a StringBuilder for which we haven't added an ASBO to the vnToAsbo map.
                // todo I think this means that the StringBuilder has been passed as a parameter or is a field. We should handle this case too at some point.
                IdentityOperator()
//                throw new UnsupportedOperationException(MISSING_STRING_BUILDER_MESSAGE)
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

        private[this] case class AppendOperator(asbos: Set[ASBO], string: AltStringConcatenation) extends UnaryOperator[AsboToString] {

          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte = {
            val rhsMap = rhs.asboToString
            val newMap = mutable.Map.empty[ASBO, AltStringConcatenation] ++= rhsMap
            asbos foreach {
              asbo =>
                val newString = rhs.asboToString get asbo match {
                  case Some(sb) =>
                    sb ++ string
                  case None =>
                    string
                }
                newMap += asbo -> newString
            }
            if (lhs.asboToString == newMap) // todo note: currently lhs will never be equal to newMap, so this method will always return CHANGED!
              NOT_CHANGED
            else {
              lhs.asboToString ++= newMap
              CHANGED
            }
          }
        }

        private[this] case class IdentityOperator() extends UnaryOperator[AsboToString] {

          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte =
            if (lhs.asboToString == rhs.asboToString)
              NOT_CHANGED
            else {
              lhs.asboToString ++= rhs.asboToString
              CHANGED
            }

          override def isIdentity: Boolean = true
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AsboToString] =
        throw new UnsupportedOperationException(EDGE_FUNCTIONS_NOT_SUPPORTED_MESSAGE)

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
