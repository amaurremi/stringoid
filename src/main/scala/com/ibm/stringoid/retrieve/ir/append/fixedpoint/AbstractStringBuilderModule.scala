package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.WalaValueNumber
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{IR, SSAInvokeInstruction, SSAPhiInstruction}
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
 * An AbstractStringBuilderObject is the representation of one such StringBuilder object that can be mapped
 * to by many value numbers.
 */
trait AbstractStringBuilderModule {
  
  type AsboMapping = OrdinalSetMapping[ASBO]

  /**
   * Representation for nodes of the value-number-data-flow graph.
   * We need to keep track of whether a node corresponds to the creation of a new StringBuilder
   * so that we know when to insert new AbstractStringBuilderObjects in the transfer function.
   */
  sealed trait GraphNode {
    val vn: WalaValueNumber
  }
  /**
   * Note: different instances of this class should correspond to different
   * values; that's why it is not a case class and does not override equals.
   */
  // todo is this bad design?
  class AppendNode(override val vn: WalaValueNumber) extends GraphNode
  case class NewSbNode(override val vn: WalaValueNumber) extends GraphNode
  case class PhiUseNode(override val vn: WalaValueNumber) extends GraphNode
  case class PhiDefNode(override val vn: WalaValueNumber) extends GraphNode

  /**
   * The resulting map we are interested in obtaining.
   */
  def valNumToAbstractStringBuilder(ir: IR): Map[WalaValueNumber, Set[ASBO]] = {
    val numbering = createAbstractObjectNumbering(ir)
    val solver = new AbstractStringBuilderFixedPointSolver(ir, numbering)
    val result = solver.result
    (solver.valueNumberGraph map {
      n: GraphNode =>
        val intSet = result.getOut(n).getValue
        n.vn -> intSetToAbstractStringBuilders(intSet, numbering)
    })(breakOut)
  }

  private[this] def intSetToAbstractStringBuilders(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
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

  private[this] class AbstractStringBuilderFixedPointSolver(
    ir: IR,
    abstractObjectNumbering: AsboMapping
  ) {

    def result: BitVectorSolver[GraphNode] = {
      val framework = new BitVectorFramework[GraphNode, ASBO](
        valueNumberGraph,
        transferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[GraphNode](framework)
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
    def valueNumberGraph: Graph[GraphNode] = {
      // 1 = new SB();
      // 2 = 1.append(3);
      // ...
      // 4 = 1.append(5);
      // For this case, we need to add three nodes that contain VN 1, and the nodes need to be connected with each other.
      // Since append is mutable (it changes 1's object) we cannot connect the nodes to the first node where 1 is defined.
      // So we need to remember the previous instruction that appended something to 1, which is the purpoe of this map.
      // todo test this case in unit tests
      val vnToLastUsedNode = mutable.Map.empty[WalaValueNumber, GraphNode]
      val graph = new SlowSparseNumberedGraph[GraphNode](1)
      def addNode(n: GraphNode) = if (!(graph containsNode n)) graph addNode n
      ir.iterateAllInstructions foreach {
        case inv: SSAInvokeInstruction if isSbConstructor(inv) =>
          getDefs(inv) foreach {
            d =>
              val node = NewSbNode(d)
              addNode(node)
              vnToLastUsedNode += d -> node
          }
        case inv: SSAInvokeInstruction if isSbAppend(inv) =>
          val (firstDef, secondDef) = getFirstSecondAppendDef(inv) // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          val firstNode = new AppendNode(firstDef)
          val secondNode = new AppendNode(secondDef)
          graph addNode firstNode
          graph addNode secondNode
          // connect the previous use of 1 with the new use of 1
          vnToLastUsedNode get secondDef match {
            case Some(sd) =>
              graph addEdge (sd, secondNode)
            case None     =>
          }
          vnToLastUsedNode += secondDef -> secondNode
          vnToLastUsedNode += firstDef  -> firstNode
          graph addEdge(secondNode, firstNode)
        case phi: SSAPhiInstruction =>
          val defNode = PhiDefNode(phi.getDef)
          graph addNode defNode
          getPhiUses(phi) foreach {
            use =>
              val useNode = vnToLastUsedNode getOrElse (use, new PhiUseNode(use))
              addNode(useNode)
              graph addEdge (useNode, defNode)
          }
      }
      graph
    }

    private[this] def transferFunctions = new ITransferFunctionProvider[GraphNode, BitVectorVariable] {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(node: GraphNode): UnaryOperator[BitVectorVariable] =
        node match {
          case NewSbNode(vn) =>
            val gen = new BitVector(abstractObjectNumbering getMappedIndex AbstractStringBuilderObject(vn))
            new BitVectorKillGen(new BitVector(), gen)
          case _ => BitVectorIdentity.instance()
        }

      override def getEdgeTransferFunction(src: GraphNode, dst: GraphNode): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
