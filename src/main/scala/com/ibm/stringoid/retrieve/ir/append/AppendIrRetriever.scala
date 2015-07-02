package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.{Url, UrlsWithSources}
import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.wala.ssa.{SSAInstruction, IR}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.{Seq, breakOut}

object AppendIrRetriever extends IrUrlRetriever {

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)

  override def getUrlsWithSources(apkPath: Path): UrlsWithSources = {
    val empty = Map.empty[Url, Set[String]]
    getIrs(apkPath).foldLeft(empty) {
      case (prevMap1, ir) =>
        val urlsWithSources = getUrlsWithSourcesForIr(ir)
        (urlsWithSources.keySet ++ prevMap1.keySet).foldLeft(empty) {
          case (prevMap2, url) =>
            val emptyStrings: Set[String] = Set.empty[String]
            val methods1 = prevMap1 getOrElse (url, emptyStrings)
            val methods2 = prevMap2 getOrElse (url, emptyStrings)
            prevMap1 updated (url, methods1 ++ methods2)
        }
    }
  }

  private[this] def getUrlsWithSourcesForIr(ir: IR): UrlsWithSources = {
    val ssa = new StringConcatSsaConversion(ir)
    for {
      instr <- ir.getInstructions

    }
  }
}
