package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{IVariable, UnaryOperator}
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.{ExplodedControlFlowGraph, IExplodedBasicBlock}
import com.ibm.wala.util.graph.impl.NodeWithNumber

import scala.collection.mutable

trait StringAppendModule extends StringAppendDatastructures {

  def stringAppendsAtEndOfMethod(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]): Set[AltStringConcatenation] = {
    val solver = new StringAppendFixedPointSolver(ir, vnToAsbo)
    val stringAppendResult = solver.result
    stringAppendResult.getOut(solver.endOfMethod).asboToString.values.toSet[AltStringConcatenation]
  }

  private class StringAppendFixedPointSolver(ir: IR, vnToAsbo: Map[ValueNumber, Set[ASBO]]) {

    type BB = IExplodedBasicBlock
    type AsboMap = mutable.Map[ASBO, AltStringConcatenation]

    // ITransferFunctionProvider's methods force the lattice elements to be mutable
    sealed trait AsboToString extends NodeWithNumber with IVariable[AsboToString]  {
      val asboToString: AsboMap

      private[this] var orderNumber = -1

      override def getOrderNumber: Int = orderNumber

      override def setOrderNumber(i: Int): Unit = orderNumber = i

      override def copyState(v: AsboToString): Unit = {
        asboToString.clear()
        asboToString ++= v.asboToString
      }
    }

    case class AsboToStringIn(asboToString: AsboMap) extends AsboToString
    case class AsboToStringOut(asboToString: AsboMap) extends AsboToString

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

        override def makeNodeVariable(n: BB, in: Boolean): AsboToString =
          if (in)
            AsboToStringIn(mutable.Map.empty[ASBO, AltStringConcatenation])
          else
            AsboToStringOut(mutable.Map.empty[ASBO, AltStringConcatenation])

        override def makeEdgeVariable(src: BB, dst: BB): AsboToString =
          throw new UnsupportedOperationException("No edge transfer functions for StringAppend fixed-point solver.")

        override def makeStmtRHS(size: ValueNumber): Array[AsboToString] =
          new Array[AsboToString](size)
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AsboToString] {

      override def getMeetOperator: AbstractMeetOperator[AsboToString] = StringMeetOperator()

      case class StringMeetOperator() extends AbstractMeetOperator[AsboToString] {

        override def evaluate(lhs: AsboToString, rhs: Array[AsboToString]): Byte = {
          def addRhsToLhs(l: AsboMap, r: AsboMap): Unit =
            r foreach {
              case (asbo, sb1) =>
                l get asbo match {
                  case Some(sb2) =>
                    l += asbo -> (sb1 | sb2)
                  case None =>
                    l += asbo -> sb1
                }
            }

          val newMap = mutable.Map.empty[ASBO, AltStringConcatenation]
          rhs foreach {
            rmap =>
              addRhsToLhs(newMap, rmap.asboToString)
          }
          if (newMap == lhs.asboToString)
            NOT_CHANGED
          else {
            lhs.asboToString ++= newMap
            CHANGED
          }
        }
      }

      override def getNodeTransferFunction(node: BB): UnaryOperator[AsboToString] = {
        node.getInstruction match {
          case inv: SSAInvokeInstruction if isSbAppend(inv) || isSbConstructorWithStringParam(inv) =>
            vnToAsbo get inv.getDef match {
              case Some(asbos) =>
                new AppendOperator(asbos, AltAppendArgument(inv getUse 0)) // todo what if the argument is in itself a StringBuilder? will we handle that case outside?
              case None =>
                throw new UnsupportedOperationException("Value-number-to-ASBO map should contain the value number for this StringBuilder")
            }
          case _                                                                                   =>
            IdentityOperator()
        }
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
        }

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AsboToString] =
        throw new UnsupportedOperationException("No edge transfer functions for StringAppend fixed-point solver.")

      override def hasNodeTransferFunctions: Boolean = true

      override def hasEdgeTransferFunctions: Boolean = false
    }
  }
}
