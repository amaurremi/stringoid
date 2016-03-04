package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.{CgNodes, IrNodes}
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ipa.callgraph.impl.PartialCallGraph
import com.ibm.wala.ipa.callgraph.{AnalysisCache, CallGraph}
import com.ibm.wala.ssa.{IR, IRFactory}
import com.ibm.wala.types.ClassLoaderReference
import com.typesafe.config.Config
import com.typesafe.config.impl.ConfigImpl
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.mutable

object IrNodesModule {

  trait InterProcIrNodes extends IrUrlRetriever with CgNodeRetriever with CgNodes

  private[IrNodesModule] trait CgNodeRetriever extends IrUrlRetriever {

    lazy val callGraph: CallGraph = {
      val conf  = if (isApk) configWithApk(config.file) else withMainEntryPoint(configWithSrc(config.file))
      val graph = FlexibleCallGraphBuilder()(conf).cg
      if (config.ignoreLibs)
        PartialCallGraph.make(graph, graph.getEntrypointNodes, graph filterNot {
          node =>
            ClassLoaderReference.Primordial == node.getMethod.getDeclaringClass.getReference.getClassLoader
        })
      else
        graph
    }

    private[this] def withMainEntryPoint(conf: Config): Config =
      conf withValue ("wala.entry.signature-pattern", ConfigImpl.fromAnyRef(".*main\\(\\[Ljava/lang/String;\\)V", ""))
  }

  trait IntraProcIrNodes extends IrUrlRetriever with IrNodes

  trait CgIntraProcIrNodes extends IntraProcIrNodes with CgNodeRetriever {

    override def getEntryNodes: Iterator[IrNode] =
      callGraph.getEntrypointNodes.iterator() map {
        node =>
          IrNode(node.getIR)
      }

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

    override def getEntryNodes = getAllNodes
  }
}