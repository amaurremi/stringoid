package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import java.util

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.cfg.ControlFlowGraph
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, EdgeFilter, ExplodedInterproceduralCFG, PrunedCFG}
import com.ibm.wala.ssa.SSAInstruction
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.util.collections.IndiscriminateFilter
import com.ibm.wala.util.graph.Acyclic
import com.ibm.wala.util.intset.IntPair

import scala.collection.JavaConversions._
import scala.collection.mutable

trait CFG extends InterProcASBOModule {

  protected type BB = BasicBlockInContext[IExplodedBasicBlock]

  class AcyclicInterproceduralCFG extends ExplodedInterproceduralCFG(callGraph, IndiscriminateFilter.singleton[CGNode]) {

    private[this] type CFG = ControlFlowGraph[SSAInstruction, IExplodedBasicBlock]

    private[this] val nodeToCfg = mutable.Map[Int, CFG]()

    override def getCFG(n: CGNode): CFG =
      nodeToCfg get (callGraph getNumber n) match {
        case Some(graph) =>
          graph
        case None =>
          val cfg = super[ExplodedInterproceduralCFG].getCFG(n)
          if (Option(cfg).isDefined) {
            val filter = new BackEdgeFilter(cfg)
            PrunedCFG.make(cfg, filter)
          } else cfg
      }

    def getCallBlocks(callee: BB): Iterator[BB] = {
      val entry = acyclicCFG getEntry callee.getNode
      acyclicCFG getPredNodes entry
    }

    private[this] class BackEdgeFilter(cfg: CFG) extends EdgeFilter[IExplodedBasicBlock] {

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

    lazy val acyclicCFG = TimeResult("acyclic CFG", new AcyclicInterproceduralCFG)
  }

}