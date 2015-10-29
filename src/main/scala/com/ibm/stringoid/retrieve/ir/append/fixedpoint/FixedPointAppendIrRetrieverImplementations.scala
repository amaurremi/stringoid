package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.IntraProcIrModule
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.ipa.callgraph.propagation.{LocalPointerKey, PointerKey}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

trait FixedPointAppendIrRetrieverImplementations extends FixedPointAppendIrRetrievers with IntraProcIrModule {

  final class InterProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config) {

    override type Identifier = PointerKey

    override type Node = CallGraphNode

    override def getAsbo(vn: ValueNumber, node: CallGraphNode) = ASBO(new LocalPointerKey(node.node, vn))

    override def getNodes: Iterator[CallGraphNode] = {
      new FlexibleCallGraphBuilder()(configWithApk(config.file)).cg.getEntrypointNodes.iterator() map CallGraphNode.apply
    }
  }

  abstract class IntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends FixedPointAppendIrRetriever(config)
    with IntraProcIrNodes {

    override def getAsbo(vn: ValueNumber, node: Node) = ASBO(vn)
  }

  final class CgIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with CgIntraProcIrNodes

  final class ChaIntraProcFixedPointAppendIrRetriever(
    config: AnalysisConfig
  ) extends IntraProcFixedPointAppendIrRetriever(config)
    with ChaIntraProcIrNodes
}
