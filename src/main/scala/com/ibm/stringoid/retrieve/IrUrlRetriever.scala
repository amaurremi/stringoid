package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

/**
 * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
 * The trait does not specify how to extract the URLs from an IR.
 */
trait IrUrlRetriever extends UrlRetriever {

  def getIrsFromBuilder(bulder: FlexibleCallGraphBuilder): Seq[IR]

  final def getIrs(apkPath: Path): Seq[IR] = {
    implicit val config = configWithApk(apkPath)
    val irs = getIrsFromBuilder(new FlexibleCallGraphBuilder())
    irs filter { Option(_).isDefined }
  }
}
