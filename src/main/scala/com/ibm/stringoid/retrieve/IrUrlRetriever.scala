package com.ibm.stringoid.retrieve

import java.nio.file.{Paths, Files, Path}

import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

trait IrUrlRetriever extends UrlRetriever {

  def getIrsFromBuilder(bulder: FlexibleCallGraphBuilder): Seq[IR]

  final def getIrs(apkPath: Path): Seq[IR] = {
    implicit val config = configWithApk(apkPath)
    val irs = getIrsFromBuilder(new FlexibleCallGraphBuilder())
    irs filter { Option(_).isDefined }
  }

  /**
   * For debug purposes
   */
  final def cgReachableMethodsContaining(string: String, apkPath: Path): Iterable[IMethod] = {
    implicit val config = configWithApk(apkPath)
    new FlexibleCallGraphBuilder().cg collect {
      case n if n.getMethod.toString.contains(string) =>
        n.getMethod
    }
  }
}

trait AllIrFromCgRetriever extends IrUrlRetriever {

  override final def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
    (builder.cg map { _.getIR })(breakOut)
  }
}