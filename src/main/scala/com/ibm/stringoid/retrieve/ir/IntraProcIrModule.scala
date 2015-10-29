package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ipa.callgraph.{AnalysisCache, CGNode}
import com.ibm.wala.ssa.{IR, IRFactory}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.mutable

object IntraProcIrModule {

  trait IntraProcIrNodes extends IrUrlRetriever {

    override type Identifier = ValueNumber

    override type Node = IrNode
  }

  trait CgIntraProcIrNodes extends IntraProcIrNodes {

    override def getNodes: Iterator[IrNode] = {
      val file = config.file
      val includeLib = !config.ignoreLibs
      val processed = mutable.Set.empty[CGNode]

      new FlexibleCallGraphBuilder().cg.iterator flatMap {
        case node if includeLib || isApplicationClass(node.getMethod.getDeclaringClass) =>
          if (processed contains node)
            None
          else {
            processed += node
            Some(IrNode(node.getIR))
          }
        case _ =>
          None
      }
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