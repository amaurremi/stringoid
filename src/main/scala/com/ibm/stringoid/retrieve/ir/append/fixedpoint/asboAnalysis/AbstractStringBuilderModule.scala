package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.{IrUrlRetriever, ValueNumber}
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAInstruction, SSAPhiInstruction}
import com.ibm.wala.util.collections.ObjectArrayMapping
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.intset.{BitVector, IntSet, OrdinalSetMapping}

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
trait AbstractStringBuilderModule extends IrUrlRetriever {

  type AsboMapping = OrdinalSetMapping[ASBO]

  /**
    * If the method deals with StringBuilders, returns Some result
    */
  protected[this] def getResult(solver: AsboFixedPointSolver): BitVectorSolver[Identifier] = {
    val result = solver.result
    result.solve(null)
    result
  }

  protected[this] def intSetToAsbo(intSet: IntSet, numbering: AsboMapping): Set[ASBO] = {
    val walaIterator = intSet.intIterator
    val set = new Iterator[ValueNumber] {
      override def hasNext: Boolean = walaIterator.hasNext

      override def next(): Int = walaIterator.next()
    }.toSet[ValueNumber]
    set map numbering.getMappedObject
  }

  protected def createAbstractObjectMapping(asbos: Iterator[ASBO]): AsboMapping =
    new ObjectArrayMapping[ASBO](asbos.toArray[ASBO])

  abstract class AsboFixedPointSolver(val abstractObjectNumbering: AsboMapping) {

    def valueNumberGraph: Graph[Identifier]

    def getTransferFunctions: StringBuilderTransferFunctions

    /**
      * If a method has deals with StringBuilders, returns Some solver, otherwise None
      */
    def result: BitVectorSolver[Identifier] = {
      val framework = new BitVectorFramework[Identifier, ASBO](
        valueNumberGraph,
        getTransferFunctions,
        abstractObjectNumbering)
      val solver = new BitVectorSolver[Identifier](framework)
      solver.solve(null)
      solver
    }

    def getDef(id: Identifier): SSAInstruction

    def getUses(id: Identifier): Iterator[SSAInstruction]

    abstract class StringBuilderTransferFunctions extends ITransferFunctionProvider[Identifier, BitVectorVariable] {

      def getNodeTransferFunction(id: Identifier): UnaryOperator[BitVectorVariable]

      def pointsToPhi(id: Identifier): Boolean =
        getUses(id) exists { _.isInstanceOf[SSAPhiInstruction] }

      def isPhiDef(id: Identifier): Boolean =
        getDef(id).isInstanceOf[SSAPhiInstruction]

      def createOperator(id: Identifier): UnaryOperator[BitVectorVariable] = {
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
