package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.WalaValueNumber
import com.ibm.wala.dataflow.graph.{AbstractMeetOperator, BitVectorFramework, BitVectorSolver, ITransferFunctionProvider}
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAInvokeInstruction, SSAPhiInstruction, IR}
import com.ibm.wala.util.collections.ObjectArrayMapping
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.intset.OrdinalSetMapping
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._

import scala.collection.JavaConversions._

trait AbstractStringBuilderCreatorModule {
  
  class AbstractStringBuilderCreator(ir: IR) {

    def solver: BitVectorSolver[WalaValueNumber] = {
      val framework = new BitVectorFramework[WalaValueNumber, Set[AbstractStringBuilderObject]](
        valueNumberGraph,
        transferFunctions,
        abstractObjectNumbering)
      new BitVectorSolver[WalaValueNumber](framework)
    }

    /**
     * Creates the value-number-data-flow graph. For a program
     *
     * 1 = new StringBuilder()
     * 2 = 1.append(3)
     * 4 = 2.append(4)
     * 5 = phi(4, 7)
     *
     * there will be a graph
     * 1 -> 2 -> 4 -> 5 <- 7
     */
    private[this] def valueNumberGraph: Graph[WalaValueNumber] = {
      val graph = new SlowSparseNumberedGraph[WalaValueNumber](1)
      def addNode(vn: WalaValueNumber) = if (!(graph containsNode vn)) graph addNode vn
      ir.iterateAllInstructions foreach {
        case inv: SSAInvokeInstruction if isSbConstructor(inv) =>
          getDefs(inv) foreach addNode
        case inv: SSAInvokeInstruction if isSbAppend(inv) =>
          getDefs(inv) foreach addNode
          val (firstDef, secondDef) = getFirstSecondAppendDef(inv)
          graph addEdge(secondDef, firstDef)
        case phi: SSAPhiInstruction =>
          val phiDef = phi.getDef
          graph addNode phiDef
          getPhiUses(phi) foreach {
            use =>
              addNode(use)
              graph addEdge(use, phiDef)
          }
      }
      graph
    }

    private[this] def abstractObjectNumbering: OrdinalSetMapping[Set[AbstractStringBuilderObject]] = createAbstractObjectNumbering

    private[this] def createAbstractObjectNumbering: OrdinalSetMapping[Set[AbstractStringBuilderObject]] = {
      val abstractObjects = ir.iterateNormalInstructions collect {
        case inv: SSAInvokeInstruction if isSbConstructor(inv) =>
          Set(AbstractStringBuilderObject(inv getDef 0))
      }
      new ObjectArrayMapping[Set[AbstractStringBuilderObject]](abstractObjects.toArray[Set[AbstractStringBuilderObject]])
    }

    private[this] def transferFunctions = new ITransferFunctionProvider[WalaValueNumber, BitVectorVariable] {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] = ???

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(node: WalaValueNumber): UnaryOperator[BitVectorVariable] = ???

      override def getEdgeTransferFunction(src: WalaValueNumber, dst: WalaValueNumber): UnaryOperator[BitVectorVariable] = ???

      override def hasNodeTransferFunctions: Boolean = ???
    }
  }
}
