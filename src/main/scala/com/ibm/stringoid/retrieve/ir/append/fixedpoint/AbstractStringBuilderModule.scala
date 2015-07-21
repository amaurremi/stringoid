package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.WalaValueNumber
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{IR, SSAInvokeInstruction, SSAPhiInstruction}
import com.ibm.wala.util.collections.ObjectArrayMapping
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.intset.{IntSet, OrdinalSetMapping}

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait AbstractStringBuilderModule {
  
  type AsboMapping = OrdinalSetMapping[ASBO]

  def valNumToAbstractStringBuilder(ir: IR): Map[WalaValueNumber, Set[ASBO]] = {
    val numbering = createAbstractObjectNumbering(ir)
    val solver = new AbstractStringBuilderFixedPointSolver(ir, numbering)
    val result = solver.result
    (solver.valueNumberGraph map {
      vn: WalaValueNumber =>
        val intSet = result.getOut(vn).getValue
        vn -> intSetToAbstractStringBuilders(intSet, numbering)
    })(breakOut)
  }

  private[this] def intSetToAbstractStringBuilders(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
    val walaIterator = intSet.intIterator
    val set = new Iterator {
      override def hasNext: Boolean = walaIterator.hasNext
      override def next(): Int = walaIterator.next()
    }.toSet[WalaValueNumber]
    set map numbering.getMappedObject 
  }

  private[this] def createAbstractObjectNumbering(ir: IR): AsboMapping = {
    val abstractObjects = ir.iterateNormalInstructions collect {
      case inv: SSAInvokeInstruction if isSbConstructor(inv) =>
        AbstractStringBuilderObject(inv getDef 0)
    }
    new ObjectArrayMapping[ASBO](abstractObjects.toArray[ASBO])
  }

  private[this] class AbstractStringBuilderFixedPointSolver(
    ir: IR,
    abstractObjectNumbering: AsboMapping
  ) {

    def result: BitVectorSolver[WalaValueNumber] = {
      val framework = new BitVectorFramework[WalaValueNumber, ASBO](
        valueNumberGraph,
        transferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[WalaValueNumber](framework)
      solver.solve(null)
      solver
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
    def valueNumberGraph: Graph[WalaValueNumber] = {
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
              graph addEdge (use, phiDef)
          }
      }
      graph
    }

    private[this] def transferFunctions = new ITransferFunctionProvider[WalaValueNumber, BitVectorVariable] {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(node: WalaValueNumber): UnaryOperator[BitVectorVariable] =
        BitVectorIdentity.instance()

      override def getEdgeTransferFunction(src: WalaValueNumber, dst: WalaValueNumber): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
