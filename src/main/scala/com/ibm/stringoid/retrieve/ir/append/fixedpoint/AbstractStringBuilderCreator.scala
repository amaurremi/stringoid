package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.WalaValueNumber
import com.ibm.wala.dataflow.graph.{AbstractMeetOperator, BitVectorFramework, BitVectorSolver, ITransferFunctionProvider}
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.IR
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.intset.OrdinalSetMapping

trait AbstractStringBuilderCreator {

  def apply(ir: IR): BitVectorSolver[WalaValueNumber] = {
    val framework = new BitVectorFramework[WalaValueNumber, Set[AbstractStringBuilderObject]](
      valueNumberGraph,
      transferFunctions,
      abstractObjectNumbering)
    new BitVectorSolver[WalaValueNumber](framework)
  }

  def valueNumberGraph: Graph[WalaValueNumber] = ???

  private def abstractObjectNumbering: OrdinalSetMapping[Set[AbstractStringBuilderObject]] = createAbstractObjectNumbering

  private def createAbstractObjectNumbering: OrdinalSetMapping[Set[AbstractStringBuilderObject]] = ???

  private def transferFunctions = new ITransferFunctionProvider[WalaValueNumber, BitVectorVariable] {

    override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] = ???

    override def hasEdgeTransferFunctions: Boolean = ???

    override def getNodeTransferFunction(node: WalaValueNumber): UnaryOperator[BitVectorVariable] = ???

    override def getEdgeTransferFunction(src: WalaValueNumber, dst: WalaValueNumber): UnaryOperator[BitVectorVariable] = ???

    override def hasNodeTransferFunctions: Boolean = ???
  }
}
