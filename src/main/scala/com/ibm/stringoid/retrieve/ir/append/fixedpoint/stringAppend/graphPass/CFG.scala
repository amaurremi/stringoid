package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.graphPass

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{ExplodedInterproceduralCFG, PrunedCFG}
import com.ibm.wala.util.collections.IndiscriminateFilter

import scala.collection.JavaConversions._
import scala.collection.mutable

trait CFG extends InterProcASBOModule {

  class AcyclicInterproceduralCFG extends ExplodedInterproceduralCFG(callGraph, IndiscriminateFilter.singleton[CGNode]) with BackEdges {

    private[this] val nodeToCfg = mutable.Map[Int, CFG]()

    override def getCFG(n: CGNode): CFG = {
      val num = callGraph getNumber n
      nodeToCfg get num match {
        case Some(graph) =>
          graph
        case None        =>
          val cfg = super[ExplodedInterproceduralCFG].getCFG(n)
          val acyclic = if (Option(cfg).isDefined) {
            PrunedCFG.make(cfg, new BackEdgeFilter(cfg))
          } else cfg
          nodeToCfg += (num -> acyclic)
          acyclic
      }
    }

    def getEntryPoints: Iterable[BB] = callGraph.getEntrypointNodes map getEntry
  }

  lazy val acyclicCFG: AcyclicInterproceduralCFG = new AcyclicInterproceduralCFG
}