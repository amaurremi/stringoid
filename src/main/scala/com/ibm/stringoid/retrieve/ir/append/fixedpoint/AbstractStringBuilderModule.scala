package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.WalaValueNumber
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{DefUse, IR, SSAInvokeInstruction, SSAPhiInstruction}
import com.ibm.wala.util.collections.ObjectArrayMapping
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.intset.{BitVector, IntSet, OrdinalSetMapping}

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

/**
 * Consider the program
 *
 * "x" + "y"
 *
 * which gets represented in the IR as something like
 *
 * 1 = new StringBuilder()
 * 2 = 1.append(3)          // 3 represents "x"
 * 4 = 2.append(4)          // 4 represents "y"
 *
 * We see that the same StringBuilder object is mapped to from the value numbers 1, 2, and 4.
 * An [[AbstractStringBuilderObject]] (ASBO) is the representation of one such StringBuilder object that can be mapped
 * to by many value numbers.
 */
trait AbstractStringBuilderModule {
  
  type AsboMapping = OrdinalSetMapping[ASBO]

  def asboSolver(ir: IR): AsboFixedPointSolver =
    new AsboFixedPointSolver(ir, createAbstractObjectNumbering(ir))
  
  def getResult(solver: AsboFixedPointSolver): BitVectorSolver[WalaValueNumber] = {
    val result = solver.result
    result.solve(null)
    result
  }
  
  /**
   * The resulting map we are interested in obtaining.
   */
  def valueNumberToAsbo(solver: AsboFixedPointSolver): Map[WalaValueNumber, Set[ASBO]] = {
    val result = getResult(solver)
    (solver.valueNumberGraph map {
      vn: WalaValueNumber =>
        val intSet = result.getOut(vn).getValue
        vn -> intSetToAsbo(intSet, solver.abstractObjectNumbering)
    })(breakOut)
  }

  private[this] def intSetToAsbo(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
    val walaIterator = intSet.intIterator
    val set = new Iterator[WalaValueNumber] {
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

  class AsboFixedPointSolver(
    ir: IR,
    val abstractObjectNumbering: AsboMapping
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
      // 1 = new SB();
      // 2 = 1.append(3);
      // ...
      // 4 = 1.append(5);
      // For this case, we need to add three nodes that contain VN 1, and the nodes need to be connected with each other.
      // Since append is mutable (it changes 1's object) we cannot connect the nodes to the first node where 1 is defined.
      // So we need to remember the previous instruction that appended something to 1, which is the purpoe of this map.
      // todo test this case in unit tests
      val vnToLastUsedNode = mutable.Map.empty[WalaValueNumber, WalaValueNumber]
      val graph = new SlowSparseNumberedGraph[WalaValueNumber](1)
      def addNode(n: WalaValueNumber) = if (!(graph containsNode n)) graph addNode n
      ir.iterateAllInstructions foreach {
        case inv: SSAInvokeInstruction if isSbConstructor(inv) =>
          getDefs(inv) foreach addNode
        case inv: SSAInvokeInstruction if isSbAppend(inv) =>
          val (firstDef, secondDef) = getFirstSecondAppendDef(inv) // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          graph addNode firstDef
          graph addNode secondDef
          graph addEdge(secondDef, firstDef)
        case phi: SSAPhiInstruction =>
          val defNode = phi.getDef
          graph addNode defNode
          getPhiUses(phi) foreach {
            use =>
              addNode(use)
              graph addEdge (use, defNode)
          }
      }
      graph
    }

    private[this] def transferFunctions = new ITransferFunctionProvider[WalaValueNumber, BitVectorVariable] {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(vn: WalaValueNumber): UnaryOperator[BitVectorVariable] = {
        val defUse = new DefUse(ir)
        defUse getDef vn match {
          case instr: SSAInvokeInstruction if isSbConstructor(instr) =>
            val gen = new BitVector(abstractObjectNumbering getMappedIndex AbstractStringBuilderObject(vn))
            new BitVectorKillGen(new BitVector(), gen)
          case _                                                     =>
            BitVectorIdentity.instance()
        }
      }

      override def getEdgeTransferFunction(src: WalaValueNumber, dst: WalaValueNumber): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}