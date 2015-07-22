package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}

import scala.collection.mutable

trait StringAppendModule extends StringAppendDatastructure {

  type BB = IExplodedBasicBlock
  
  // ITransferFunctionProvider's methods force the lattice elements to be mutable
  type AsboToString = mutable.Map[ASBO, StringAppend]
  
  class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    import com.ibm.wala.fixpoint.FixedPointConstants._

    def result: DataflowSolver[BB, AsboToString] = {
      val framework = new IKilldallFramework[BB, AsboToString] {
        override def getFlowGraph = ExplodedControlFlowGraph.make(ir)
        override def getTransferFunctionProvider = transferFunctions
      }
      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] def getSolver(framework: IKilldallFramework[BB, AsboToString]) =
      new DataflowSolver[BB, AsboToString](framework) {

        override def makeNodeVariable(n: BB, IN: Boolean): AsboToString =
          mutable.Map.empty[ASBO, StringAppend]

        override def makeEdgeVariable(src: BB, dst: BB): AsboToString = ???

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

            val newMap = mutable.Map.empty[ASBO, StringAppend]
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

      override def hasEdgeTransferFunctions: Boolean = ???

      override def getNodeTransferFunction(node: BB): UnaryOperator[AsboToString] = {
        node.getInstruction match {
          case inv: SSAInvokeInstruction if isSbConstructorWithStringParam(inv) => ???
          case inv: SSAInvokeInstruction if isSbConstructor(inv) => ???
          case inv: SSAInvokeInstruction if isSbAppend(inv) =>
            vnToAsbo get inv.getDef match {
              case Some(asbos) =>
                new AppendOperator(asbos, AppendArgument(inv getUse 0)) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>

              case phi: SSAPhiInstruction => ???
            }
        }

        private[this] class AppendOperator(asbos: Set[ASBO], string: StringAppend) extends UnaryOperator[AsboToString] {
          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte = {
            val newMap = mutable.Map.empty[ASBO, StringAppend] ++= rhs
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

        private[this] class IdentityOperator extends UnaryOperator[AsboToString] {
          override def evaluate(lhs: AsboToString, rhs: AsboToString): Byte =
            
        }
      }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AsboToString] = ???

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
