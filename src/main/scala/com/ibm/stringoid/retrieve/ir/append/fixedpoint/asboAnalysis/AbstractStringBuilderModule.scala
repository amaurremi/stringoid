package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.Nodes
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInstruction, SSAPhiInstruction}
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

  type AsboMapping = OrdinalSetMapping[ASBO]

  protected def getSolver(node: Node, numbering: AsboMapping): AsboFixedPointSolver

  protected final def asboSolver(node: Node): AsboFixedPointSolver =
    getSolver(node, createAbstractObjectNumbering(node))

  /**
    * If the method deals with StringBuilders, returns Some result
    */
  private[this] def getResult(solver: AsboFixedPointSolver): BitVectorSolver[Identifier] = {
    val result = solver.result
    result.solve(null)
    result
  }

  /**
    * The resulting map from value numbers to abstract StringBuilder objects
    */
  protected final def idToAsboForNode(node: Node): Map[Identifier, Set[ASBO]] =
    if (hasIr(node)) {
      val solver = asboSolver(node)
      val result = getResult(solver)
      (for {
        id <- solver.valueNumberGraph
        intSet <- Option((result getOut id).getValue)
        i2a = intSetToAsbo(intSet, solver.abstractObjectNumbering)
      } yield id -> i2a)(breakOut)
    } else Map.empty[Identifier, Set[ASBO]]

  private[this] def intSetToAsbo(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
    val walaIterator = intSet.intIterator
    val set = new Iterator[ValueNumber] {
      override def hasNext: Boolean = walaIterator.hasNext

      override def next(): Int = walaIterator.next()
    }.toSet[ValueNumber]
    set map numbering.getMappedObject
  }

  protected def createAbstractObjectNumbering(node: Node)(implicit tag: ClassTag[ASBO]): AsboMapping = {
    val abstractObjects = node.getIr.iterateNormalInstructions() collect {
      case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)                            =>
        createAsbo(getSbConstructorDef(inv), node)
      case inv: SSAAbstractInvokeInstruction if isStringFormat(inv) || hasStringReturnType(inv) =>
        createAsbo(inv.getDef, node)
    }

    new ObjectArrayMapping[ASBO](abstractObjects.toArray[ASBO])
  }

  abstract class AsboFixedPointSolver(
   node: Node,
   val abstractObjectNumbering: AsboMapping
  ) {

    lazy val valueNumberGraph: Graph[Identifier] = {
      // 1 = new SB();
      // 2 = 1.append(3);
      // ...
      // 4 = 1.append(5);
      // For this case, we need to add three nodes that contain VN 1, and the nodes need to be connected with each other.
      // Since append is mutable (it changes 1's object) we cannot connect the nodes to the first node where 1 is defined.
      // So we need to remember the previous instruction that appended something to 1, which is the purpose of this map.
      // todo test this case in unit tests
      val graph = new SlowSparseNumberedGraph[Identifier](1)
      def addNode(vn: ValueNumber) {
        val n = createIdentifier(vn, node)
        if (!(graph containsNode n)) graph addNode n
      }
      def addEdge(source: ValueNumber, target: ValueNumber) {
        val sourceN = createIdentifier(source, node)
        val targetN = createIdentifier(target, node)
        addNode(source)
        addNode(target)
        graph addEdge(sourceN, targetN)
      }
      node.getIr.iterateAllInstructions() foreach {
        case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)     =>
          getDefs(inv) foreach addNode
        case inv: SSAAbstractInvokeInstruction if isSbAppend(inv)          =>
          val (firstDef, secondDef) = getSbAppendDefs(inv) // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          addEdge(secondDef, firstDef)
        case inv: SSAAbstractInvokeInstruction if isSbTostring(inv)        => // in 1 = 2.toString, 1 is sbDef and 2 is sbUse
          val sbDef = getSbToStringDef(inv)
          val sbUse = getSbToStringUse(inv)
          addEdge(sbUse, sbDef)
        case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)      =>
          addNode(inv.getDef)
        case inv: SSAAbstractInvokeInstruction if hasStringReturnType(inv) =>
          addNode(inv.getDef)
        case phi: SSAPhiInstruction                                        =>
          val defNode = phi.getDef
          addNode(defNode)
          getPhiUses(phi) foreach {
            use =>
              addEdge(use, defNode)
          }
        case _                                                             =>
        // do  nothing
      }
      graph
    }

    /**
      * If a method has deals with StringBuilders, returns Some solver, otherwise None
      */
    def result: BitVectorSolver[Identifier] = {
      val framework = new BitVectorFramework[Identifier, ASBO](
        valueNumberGraph,
        new StringBuilderTransferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[Identifier](framework)
      solver.solve(null)
      solver
    }

    def getDef(id: Identifier): SSAInstruction

    class StringBuilderTransferFunctions extends ITransferFunctionProvider[Identifier, BitVectorVariable] {

      def getNodeTransferFunction(id: Identifier): UnaryOperator[BitVectorVariable] = {
        getDef(id) match {
          case instr if isSbConstructorOrFormatInDefUse(instr)                   =>
            createOperator(id, instr)
          case instr: SSAAbstractInvokeInstruction if hasStringReturnType(instr) =>
            createOperator(id, instr)
//          case _ => // todo is this wrong? what if this phi depends on another phi?
//            BitVectorIdentity.instance
        }
      }

      private[this] def createOperator(id: Identifier, instr: SSAInstruction): UnaryOperator[BitVectorVariable] = {
        val mappedIndex = abstractObjectNumbering getMappedIndex ASBO(id)
        assert(mappedIndex >= 0)
        val gen = new BitVector()
        gen set mappedIndex
        new BitVectorKillGen(new BitVector(), gen)
      }

      override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
        BitVectorUnion.instance

      override def hasEdgeTransferFunctions: Boolean = false

      override def getEdgeTransferFunction(src: Identifier, dst: Identifier): UnaryOperator[BitVectorVariable] =
        throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

      override def hasNodeTransferFunctions: Boolean = true
    }
  }

}
