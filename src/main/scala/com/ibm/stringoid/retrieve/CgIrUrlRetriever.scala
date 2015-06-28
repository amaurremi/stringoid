package com.ibm.stringoid.retrieve

import java.nio.file.{Paths, Files, Path}

import com.ibm.stringoid.util.Util
import com.ibm.wala.ipa.callgraph.CallGraph
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object CgIrUrlRetriever extends IrUrlRetriever {

  override def getIrs(apkPath: Path): Seq[IR] = {
    implicit val config = configWithApk(apkPath)
    val cg: CallGraph = new FlexibleCallGraphBuilder().cg
    Files.write(Paths.get("target", "cg.txt"), List(cg mkString "\n"))
    val irs = cg map {
      _.getIR
    }
    Util.filterOutNulls(irs.toSeq)
  }
}
