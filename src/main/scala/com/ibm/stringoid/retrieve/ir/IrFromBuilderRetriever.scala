package com.ibm.stringoid.retrieve.ir

import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait IrFromBuilderRetriever { this: IrUrlRetriever =>

  override protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)
}
