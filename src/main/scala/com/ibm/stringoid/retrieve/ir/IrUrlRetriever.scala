package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path

import com.ibm.stringoid.retrieve.UrlRetriever
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection._

/**
 * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
 * The trait does not specify how to extract the URLs from an IR.
 */
trait IrUrlRetriever extends UrlRetriever {

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR]

  protected final def getIrs(apkPath: Path): Seq[IR] = {
    implicit val config = configWithApk(apkPath)
    val irs = getIrsFromBuilder(new FlexibleCallGraphBuilder())
    irs filter { Option(_).isDefined }
  }
}
