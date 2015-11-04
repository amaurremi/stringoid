package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.Nodes
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.intset.{IntSet, OrdinalSetMapping}

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

  protected def asboSolver(node: Node): Option[AsboFixedPointSolver]

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

  protected def createAbstractObjectNumbering(node: Node)(implicit tag: ClassTag[ASBO]): AsboMapping

  abstract class AsboFixedPointSolver(
    node: Node,
    val abstractObjectNumbering: AsboMapping
  ) {

    /**
     * If a method has deals with StringBuilders, returns Some solver, otherwise None
     */
    def result: BitVectorSolver[ValueNumber] = {
      val framework = new BitVectorFramework[ValueNumber, ASBO](
        valueNumberGraph,
        getTransferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[ValueNumber](framework)
      solver.solve(null)
      solver
    }

    def valueNumberGraph: Graph[ValueNumber]

    def getTransferFunctions: StringBuilderTransferFunctions
  }

  abstract class StringBuilderTransferFunctions extends ITransferFunctionProvider[ValueNumber, BitVectorVariable] {

    override def getMeetOperator: AbstractMeetOperator[BitVectorVariable] =
      BitVectorUnion.instance

    override def hasEdgeTransferFunctions: Boolean = false

    override def getNodeTransferFunction(vn: ValueNumber): UnaryOperator[BitVectorVariable]

    override def getEdgeTransferFunction(src: ValueNumber, dst: ValueNumber): UnaryOperator[BitVectorVariable] =
      throw new UnsupportedOperationException("No edge transfer functions in abstract StringBuilder fixed-point iteration")

    override def hasNodeTransferFunctions: Boolean = true
  }
}