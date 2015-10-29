package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa._
import com.ibm.wala.util.collections.ObjectArrayMapping
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.intset.{BitVector, IntSet, OrdinalSetMapping}

import scala.collection.JavaConversions._
import scala.collection.breakOut
import scala.reflect.ClassTag

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
 * An abstract string builder object (ASBO) is the representation of one such string builder object that can be mapped
 * to by many value numbers.
 */
trait AbstractStringBuilderModule extends Nodes {

  def createAsbo(vn: ValueNumber, node: Node): ASBO

  type AsboMapping = OrdinalSetMapping[ASBO]

  private[this] def asboSolver(node: Node): Option[AsboFixedPointSolver] = {
    val numbering = createAbstractObjectNumbering(node)
    if (numbering.isEmpty)
      None
    else
      Some(new AsboFixedPointSolver(node, numbering))
  }

  /**
   * If the method deals with StringBuilders, returns Some result
   */
  def getResult(solver: AsboFixedPointSolver): BitVectorSolver[ValueNumber] = {
    val result = solver.result
    result.solve(null)
    result
  }

  /**
   * The resulting map from value numbers to abstract StringBuilder objects
   */
  def valueNumberToAsbo(node: Node): Option[Map[ValueNumber, Set[ASBO]]] = {
    asboSolver(node) map {
      solver =>
        val result = getResult(solver)
        (for {
          vn     <- solver.valueNumberGraph
          intSet <- Option((result getOut vn).getValue)
          i2a     = intSetToAsbo(intSet, solver.abstractObjectNumbering)
        } yield vn -> i2a)(breakOut)
    }
  }

  private[this] def intSetToAsbo(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
    val walaIterator = intSet.intIterator
    val set = new Iterator[ValueNumber] {
      override def hasNext: Boolean = walaIterator.hasNext
      override def next(): Int = walaIterator.next()
    }.toSet[ValueNumber]
    set map numbering.getMappedObject
  }

  private[this] def createAbstractObjectNumbering(node: Node)(implicit tag: ClassTag[ASBO]): AsboMapping = {
    val abstractObjects = node.getIr.iterateNormalInstructions collect {
      case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv) =>
        createAsbo(getSbConstructorDef(inv), node)
      case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)  =>
        createAsbo(inv.getDef, node)
    }

    val objects = abstractObjects.toSeq
    val asboArray = objects.toArray[ASBO]
    new ObjectArrayMapping[ASBO](asboArray)
  }

  class AsboFixedPointSolver(
    node: Node,
    val abstractObjectNumbering: AsboMapping
  ) {

    /**
     * If a method has deals with StringBuilders, returns Some solver, otherwise None
     */
    def result: BitVectorSolver[ValueNumber] = {
      val framework = new BitVectorFramework[ValueNumber, ASBO](
        valueNumberGraph,
        new StringBuilderTransferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[ValueNumber](framework)
      solver.solve(null)
      solver
    }

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
    lazy val valueNumberGraph: Graph[ValueNumber] = {
      // 1 = new SB();
      // 2 = 1.append(3);
      // ...
      // 4 = 1.append(5);
      // For this case, we need to add three nodes that contain VN 1, and the nodes need to be connected with each other.
      // Since append is mutable (it changes 1's object) we cannot connect the nodes to the first node where 1 is defined.
      // So we need to remember the previous instruction that appended something to 1, which is the purpose of this map.
      // todo test this case in unit tests
      val graph = new SlowSparseNumberedGraph[ValueNumber](1)
      def addNode(n: ValueNumber) = if (!(graph containsNode n)) graph addNode n
      node.getIr.iterateAllInstructions foreach {
        case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)  =>
          getDefs(inv) foreach addNode // todo unnecessary?
        case inv: SSAAbstractInvokeInstruction if isSbAppend(inv)       =>
          val (firstDef, secondDef) = getSbAppendDefs(inv) // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          graph addNode firstDef
          graph addNode secondDef
          graph addEdge(secondDef, firstDef)
        case inv: SSAAbstractInvokeInstruction if isSbTostring(inv)     =>  // in 1 = 2.toString, 1 is sbDef and 2 is sbUse
          val sbDef = getSbToStringDef(inv)
          val sbUse = getSbToStringUse(inv)
          graph addNode sbDef
          graph addNode sbUse
          graph addEdge(sbUse, sbDef)
        case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)   =>
          graph addNode inv.getDef
        case phi: SSAPhiInstruction                                     =>
          val defNode = phi.getDef
          graph addNode defNode
          getPhiUses(phi) foreach {
            use =>
              addNode(use)
              graph addEdge (use, defNode)
          }
        case _                                                          =>
          // do  nothing
      }
      graph
    }

    private[this] class StringBuilderTransferFunctions extends ITransferFunctionProvider[ValueNumber, BitVectorVariable] {

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getNodeTransferFunction(vn: ValueNumber): UnaryOperator[BitVectorVariable] = {
        node.getDu getDef vn match {
          case instr if isSbConstructorOrFormatInDefUse(instr) =>
            val mappedIndex = abstractObjectNumbering getMappedIndex createAsbo(vn, node)
            assert(mappedIndex >= 0)
            val gen = new BitVector()
            gen.set(mappedIndex)
            new BitVectorKillGen(new BitVector(), gen)
          case _                                               =>
            BitVectorIdentity.instance()
        }
      }

      override def getEdgeTransferFunction(src: ValueNumber, dst: ValueNumber): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }
}
