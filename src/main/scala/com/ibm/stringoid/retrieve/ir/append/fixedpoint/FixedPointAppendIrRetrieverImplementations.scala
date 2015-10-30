package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.AnalysisConfig
import com.ibm.stringoid.retrieve.ir.IntraProcIrModule.{CgIntraProcIrNodes, ChaIntraProcIrNodes, IntraProcIrNodes}
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.ipa.callgraph.propagation.{LocalPointerKey, PointerKey}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object FixedPointAppendIrRetrieverImplementations {

  final class InterProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config) {

    override type Identifier = PointerKey

    override type Node = CallGraphNode

    override def createAsbo(vn: ValueNumber, node: CallGraphNode) = ASBO(new LocalPointerKey(node.node, vn))

    override def getNodes: Iterator[CallGraphNode] = {
      new FlexibleCallGraphBuilder()(configWithApk(config.file)).cg.getEntrypointNodes.iterator() map CallGraphNode.apply
    }
  }

  abstract class IntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes

  final class CgIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with CgIntraProcIrNodes

  final class ChaIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with ChaIntraProcIrNodes
}
