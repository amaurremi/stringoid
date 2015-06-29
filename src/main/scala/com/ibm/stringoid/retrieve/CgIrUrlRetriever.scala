package com.ibm.stringoid.retrieve

import com.ibm.stringoid.util.Time
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

/**
 * Retrieves the URLs in an application by extracting constant URL strings
 * found in the symbol table of the IRs of methods reachable in a call graph.
 */
object CgIrUrlRetriever extends ConstantUrlsFromIrRetriever with AllIrFromCgRetriever

/**
 * An analysis that is based on independently processing the IRs
 * of all methods reachable in a call graph.
 */
trait AllIrFromCgRetriever extends IrUrlRetriever {

  override final def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    (Time.time("building call graph") {
      val cg = builder.cg
      println(cg)
      cg
    } map { _.getIR })(breakOut)
  }
}