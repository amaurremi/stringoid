package com.ibm.stringoid.retrieve

import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._
import com.ibm.stringoid.util.Time

object CgIrUrlRetriever extends AllUrlsFromIrRetriever with AllIrFromCgRetriever

trait AllIrFromCgRetriever extends IrUrlRetriever {

  override final def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    (Time.time("building call graph") {
      val cg = builder.cg
      println(cg)
      cg
    } map { _.getIR })(breakOut)
  }
}