package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.util.Time
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

/**
 * Retrieves the URLs in an application by extracting constant URL strings
 * found in the symbol table of the IRs of methods reachable in a call graph.
 */
object CgIrUrlRetriever extends ConstantUrlsFromIrRetriever {
  
  override final def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    (Time.time("building call graph") { builder.cg } map { _.getIR })(breakOut)
  }
}