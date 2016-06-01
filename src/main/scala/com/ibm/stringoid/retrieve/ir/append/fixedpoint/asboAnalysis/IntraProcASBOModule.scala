package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.IrNodes
import com.ibm.wala.ssa.SSAInstruction

import scala.collection.JavaConversions._

trait IntraProcASBOModule extends AbstractStringBuilderModule with IrNodes {

  override final def getSolver(node: Node, numbering: AsboMapping) =
    new IntraProcAsboFixedPointSolver(node, numbering)

  class IntraProcAsboFixedPointSolver(
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(node, numbering) {

    override def getDef(id: ValueNumber): SSAInstruction = node.getDu getDef id

    override def getUses(id: Identifier): Iterator[SSAInstruction] = node.getDu getUses id
  }
}
