package com.ibm.stringoid.retrieve.ir

import java.util

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.{CgNodes, IrNodes}
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ipa.callgraph.impl.PartialCallGraph
import com.ibm.wala.ipa.callgraph.pruned.PrunedCallGraph
import com.ibm.wala.ipa.callgraph.{AnalysisCache, CGNode, CallGraph}
import com.ibm.wala.ssa.{IR, IRFactory}
import com.ibm.wala.types.ClassLoaderReference
import com.ibm.wala.util.graph.Acyclic
import com.typesafe.config.Config
import com.typesafe.config.impl.ConfigImpl
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.mutable

object IrNodesModule {

  trait InterProcIrNodes extends IrUrlRetriever with CgNodeRetriever with CgNodes

  private[IrNodesModule] trait CgNodeRetriever extends IrUrlRetriever {

    lazy val callGraph: CallGraph = {
      val conf  = if (isApk) configWithApk(config.file) else withMainEntryPoint(configWithSrc(config.file))
      val graph = TimeResult("call graph", FlexibleCallGraphBuilder()(conf).cg)
      val noLibGraph =
        if (config.ignoreLibs)
          PartialCallGraph.make(graph, graph.getEntrypointNodes, graph filterNot {
            node =>
              ClassLoaderReference.Primordial == node.getMethod.getDeclaringClass.getReference.getClassLoader
          })
        else
          graph
      TimeResult("acyclic call graph", {
        val backEdges: Map[CGNode, Set[CGNode]] = TimeResult("back edges",
          Acyclic.computeBackEdges(noLibGraph, graph.getFakeRootNode).foldLeft(Map.empty[CGNode, Set[CGNode]]) {
            case (oldMap2, backEdge) =>
              val src = noLibGraph getNode backEdge.getX
              val dst = noLibGraph getNode backEdge.getY
              val dsts = oldMap2 getOrElse (src, Set.empty[CGNode])
              oldMap2 + (src -> (dsts + dst))
          }
        )
        val backEdgesJava: util.Map[CGNode, util.Set[CGNode]] = (backEdges map {
          case (src, dsts) =>
            src -> dsts.asJava
        }).asJava
        val pruned = new PrunedCallGraph(noLibGraph, noLibGraph.iterator.toSet.asJava, backEdgesJava)
        if (DEBUG) println("call graph size: " + pruned.size)
        pruned
      })
    }

    private[this] def withMainEntryPoint(conf: Config): Config =
      conf withValue ("wala.entry.signature-pattern", ConfigImpl.fromAnyRef(".*main\\(\\[Ljava/lang/String;\\)V", ""))
  }

  trait IntraProcIrNodes extends IrUrlRetriever with IrNodes

  trait CgIntraProcIrNodes extends IntraProcIrNodes with CgNodeRetriever {

    override def getAllNodes: Iterator[IrNode] =
      callGraph.iterator() map {
        node =>
          IrNode(node.getIR)
      }
  }

  trait ChaIntraProcIrNodes extends IntraProcIrNodes {

    override def getAllNodes: Iterator[Node] = {
      val includeLib = !config.ignoreLibs
      val processed = mutable.Set.empty[IR]

      val irFactory: IRFactory[IMethod] = if (isApk) getDexIrFactory(scope) else getJavaIrFactory(scope)
      val cache = new AnalysisCache(irFactory)
      for {
        c  <- cha.iterator()
        if includeLib || isApplicationClass(c)
        m  <- c.getAllMethods
        ir <- getIr(cache, m, processed)
      } yield IrNode(ir)
    }
  }
}