package com.ibm.stringoid.retrieve.ir

import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object ChaIrUrlRetriever extends ConstantUrlsFromIrRetriever {

  override def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    val irs = for {
      c <- builder.cha.iterator()
      m <- c.getAllMethods
    } yield builder.cache.getIR(m)
    irs.toSeq
  }
 }
