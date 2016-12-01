package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.graphPass

import java.util

import com.ibm.wala.cfg.ControlFlowGraph
import com.ibm.wala.ipa.cfg.EdgeFilter
import com.ibm.wala.ssa.SSAInstruction
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.util.graph.Acyclic
import com.ibm.wala.util.intset.IntPair

import scala.collection.JavaConversions._

trait BackEdges {

  type CFG = ControlFlowGraph[SSAInstruction, IExplodedBasicBlock]

  class BackEdgeFilter(cfg: CFG) extends EdgeFilter[IExplodedBasicBlock] {

    private[this] val backEdges = Acyclic.computeBackEdges(cfg, cfg.entry).toSet

    override def hasExceptionalEdge(src: IExplodedBasicBlock, dst: IExplodedBasicBlock): Boolean =
      hasEdge(src, dst, cfg.getExceptionalSuccessors)

    override def hasNormalEdge(src: IExplodedBasicBlock, dst: IExplodedBasicBlock): Boolean =
      hasEdge(src, dst, cfg.getNormalSuccessors)

    private[this] def hasEdge(
      src: IExplodedBasicBlock,
      dst: IExplodedBasicBlock,
      succFun: IExplodedBasicBlock => util.Collection[IExplodedBasicBlock]
    ): Boolean = {
      val isBackEdge = backEdges contains new IntPair(cfg getNumber src, cfg getNumber dst)
      def isSucc = succFun(src) contains dst
      !isBackEdge && isSucc
    }
  }

}
