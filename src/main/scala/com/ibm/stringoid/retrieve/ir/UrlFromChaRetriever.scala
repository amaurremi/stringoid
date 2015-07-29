package com.ibm.stringoid.retrieve.ir

import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object UrlFromChaRetriever extends IrFromChaRetriever with ConstantUrlFromIrRetriever
