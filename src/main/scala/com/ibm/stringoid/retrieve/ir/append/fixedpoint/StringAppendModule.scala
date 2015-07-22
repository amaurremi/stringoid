package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.UnaryOperator
import com.ibm.wala.ssa._
import com.ibm.wala.util.graph.Graph

trait StringAppendModule {

  type BB = ISSABasicBlock
  
  sealed trait StringAppend
  
  type AsboToString = Map[ASBO, StringAppend]
  
  class StringAppendFixedPointSolver(ir: IR) {

    def result: DataflowSolver[BB, AsboToString] = {
      val framework = new IKilldallFramework[BB, AsboToString] {
        override def getFlowGraph: Graph[BB] = ir.getControlFlowGraph
        override def getTransferFunctionProvider = transferFunctions
      }
      val solver = getSolver(framework)
      solver.solve(null)
      solver
    }

    private[this] def getSolver(framework: IKilldallFramework[BB, AsboToString]) =
      new DataflowSolver[BB, AsboToString](framework) {

        override def makeNodeVariable(n: BB, IN: Boolean): AsboToString = ???

        override def makeEdgeVariable(src: BB, dst: BB): AsboToString = ???

        override def makeStmtRHS(size: WalaValueNumber): Array[AsboToString] = ???
      }
    
    private[this] def transferFunctions = new ITransferFunctionProvider[BB, AsboToString] {
      override def getMeetOperator: AbstractMeetOperator[AsboToString] = ???

      override def hasEdgeTransferFunctions: Boolean = ???

      override def getNodeTransferFunction(node: BB): UnaryOperator[AsboToString] = ???

      override def getEdgeTransferFunction(src: BB, dst: BB): UnaryOperator[AsboToString] = ???

      override def hasNodeTransferFunctions: Boolean = ???
    }
  }
}
