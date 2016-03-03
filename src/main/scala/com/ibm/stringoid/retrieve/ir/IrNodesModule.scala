package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.{CgNodes, IrNodes}
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ipa.callgraph.{AnalysisCache, CGNode}
import com.ibm.wala.ssa.{IR, IRFactory}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.mutable

object IrNodesModule {

  trait InterProcIrNodes extends IrUrlRetriever with CgNodeRetriever with CgNodes {
    override def getNodes: Iterator[CallGraphNode] =
    getCgNodes map {
      n =>
        CallGraphNode(n)
    }
  }

  private[IrNodesModule] trait CgNodeRetriever extends IrUrlRetriever {

    def getCgNodes: Iterator[CGNode] = {
      val includeLib = !config.ignoreLibs
      val processed = mutable.Set.empty[CGNode]

      FlexibleCallGraphBuilder().cg.iterator flatMap {
        case node if includeLib || isApplicationClass(node.getMethod.getDeclaringClass) =>
          if (processed contains node)
            None
          else {
            processed += node
            Some(node)
          }
        case _ =>
          None
      }
    }
  }

  trait IntraProcIrNodes extends IrUrlRetriever with IrNodes

  trait CgIntraProcIrNodes extends IntraProcIrNodes with CgNodeRetriever {

    override def getNodes: Iterator[IrNode] =
      getCgNodes map {
        n =>
          IrNode(n.getIR)
      }
  }

  trait ChaIntraProcIrNodes extends IntraProcIrNodes {

    override def getNodes: Iterator[Node] = {
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