package com.ibm.stringoid.retrieve.ir

import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object IrFromChaRetriever extends ConstantUrlsFromIrRetriever {

  override protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    val irs = for {
      c <- builder.cha.iterator()
      m <- c.getAllMethods
    } yield builder.cache.getIR(m)
    irs.toSeq
  }
 }
