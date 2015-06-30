package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.UrlWithSources
import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.{Seq, breakOut}

object AppendIrRetriever extends IrUrlRetriever {

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)

  override def getUrlsWithSources(apkPath: Path): UrlWithSources = {
    for {
      ir <- getIrs(apkPath)
      ssaConversion = new StringConcatSsaConversion(ir)
    } yield ???
    ???
  }
}
