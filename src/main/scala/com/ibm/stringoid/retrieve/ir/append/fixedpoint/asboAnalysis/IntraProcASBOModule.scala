package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.IrNodes
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAPhiInstruction}
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.intset.BitVector

import scala.collection.JavaConversions._

trait IntraProcASBOModule extends AbstractStringBuilderModule with IrNodes {

  override final def getSolver(node: Node, numbering: AsboMapping) =
    new IntraProcAsboFixedPointSolver(node, numbering)

  class IntraProcAsboFixedPointSolver(
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getTransferFunctions = new IntraProcStringBuilderTransferFunctions

    class IntraProcStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

      override def getNodeTransferFunction(vn: ValueNumber): UnaryOperator[BitVectorVariable] = {
        node.getDu getDef vn match {
          case instr if isSbConstructorOrFormatInDefUse(instr) =>
            val mappedIndex = abstractObjectNumbering getMappedIndex createAsbo(vn, node)
            assert(mappedIndex >= 0)
            val gen = new BitVector()
            gen set mappedIndex
            new BitVectorKillGen(new BitVector(), gen)
          case _                                               =>
            BitVectorIdentity.instance
        }
      }
    }
  }
}
