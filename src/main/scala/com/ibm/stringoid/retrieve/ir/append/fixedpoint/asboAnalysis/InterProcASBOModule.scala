package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.util.graph.Graph

import scala.reflect.ClassTag

trait InterProcASBOModule extends AbstractStringBuilderModule {

  override def createAbstractObjectNumbering(node: Node)(implicit tag: ClassTag[ASBO]): AsboMapping = ???

  def asboSolver(node: Node): Option[AsboFixedPointSolver] = ???

  class InterProcAsboFixedPointSolver(node: Node, numbering: AsboMapping) extends AsboFixedPointSolver(node, numbering) {

    /**
      * Creates the value-number-data-flow graph. For a program
      *
      * 1 = new StringBuilder()
      * 2 = 1.append(3)
      * 4 = 2.append(6)
      * 5 = phi(4, 7)
      *
      * there will be a graph
      * 5 -> 4 -> 2 -> 1
      *   -> 7
      */
    override lazy val valueNumberGraph: Graph[ValueNumber] = ???

    override def getTransferFunctions = new InterProcStringBuilderTransferFunctions

    class InterProcStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(vn: ValueNumber): UnaryOperator[BitVectorVariable] = ???

      override def getEdgeTransferFunction(src: ValueNumber, dst: ValueNumber): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
