package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}

import scala.collection.mutable

trait StringAppendModule extends StringAppendDatastructure {

  def stringAppendsAtEndOfMethod(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): Set[StringConcatenation] = {
    val solver = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val stringAppendResult = solver.result
    stringAppendResult.getOut(solver.endOfMethod).values.toSet[StringConcatenation]
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB = IExplodedBasicBlock

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    type AsboToString = mutable.Map[ASBO, StringConcatenation]

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def endOfMethod = getGraph.exit

    def result: DataflowSolver[BB, AsboToString] = {
      val framework = new IKilldallFramework[BB, AsboToString] {
        override def getFlowGraph = getGraph
        override def getTransferFunctionProvider = transferFunctions
      }
      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] def getGraph = ExplodedControlFlowGraph.make(ir)

    private[this] def getSolver(framework: IKilldallFramework[BB, AsboToString]) =
      new DataflowSolver[BB, AsboToString](framework) {

        override def makeNodeVariable(n: BB, IN: Boolean): AsboToString =
          mutable.Map.empty[ASBO, StringConcatenation]

        override def makeEdgeVariable(src: BB, dst: BB): AsboToString =
          throw new UnsupportedOperationException("No edge transfer functions for StringAppend fixed-point solver.")

        override def makeStmtRHS(size: ValueNumber): Array[AsboToString] =
          new Array[AsboToString](size)
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AsboToString] {

      override def getMeetOperator: AbstractMeetOperator[AsboToString] =
        new AbstractMeetOperator[AsboToString] {
          override def evaluate(lhs: AsboToString, rhs: Array[AsboToString]): Byte = {
            def addRhsToLhs(l: AsboToString, r: AsboToString): Unit =
              r foreach {
                case (asbo, sb1) =>
                  l get asbo match {
                    case Some(sb2) =>
                      l += asbo -> (sb1 addAlternatives sb2)
                    case None      =>
                      l += asbo -> sb1
                  }
              }

            val newMap = mutable.Map.empty[ASBO, StringConcatenation]
            rhs foreach {
              addRhsToLhs(newMap, _)
            }
            if (newMap == lhs)
              NOT_CHANGED
            else {
              lhs ++= newMap
              CHANGED
            }
          }
        }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AsboToString] = {
        node.getInstruction match {
          case inv: SSAInvokeInstruction if isSbAppend(inv) || isSbConstructorWithStringParam(inv) =>
            vnToAsbo get inv.getDef match {
              case Some(asbos) =>
                new AppendOperator(asbos, AppendArgument(inv getUse 0)) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                throw new UnsupportedOperationException("Value-number-to-ASBO map should contain the value number for this StringBuilder")
            }
          case _                                                                                   =>
            IdentityOperator
        }
      }

        private[this] class AppendOperator(asbos: Set[ASBO], string: StringConcatenation) extends UnaryOperator[AsboToString] {
          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte = {
            val newMap = mutable.Map.empty[ASBO, StringConcatenation] ++= rhs
            asbos foreach {
              asbo =>
                val newString = rhs get asbo match {
                  case Some(sb) =>
                    sb append string
                  case None =>
                    string
                }
                newMap += asbo -> newString
            }
            if (lhs == newMap) // todo note: currently lhs will never be equal to newMap, so this method will always return CHANGED!
              NOT_CHANGED
            else
              CHANGED
          }
        }

        private[this] object IdentityOperator extends UnaryOperator[AsboToString] {

          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte =
            if (lhs == rhs)
              NOT_CHANGED
            else {
              lhs ++= rhs
              CHANGED
            }
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AsboToString] =
        throw new UnsupportedOperationException("No edge transfer functions for StringAppend fixed-point solver.")

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
