package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.AppendUrl
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

object FixedpointAppendIrRetriever extends IrUrlRetriever with AppendUrl {

  override type Url = UrlSeq

  override def apply(apkPath: Path): UrlsWithSources = {
    val urlsWithSources: Seq[(Url, Method)] = for {
      ir  <- getIrs(apkPath)
      url <- getUrlsForIr(ir)
    } yield url -> ir.getMethod.toString
    val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, method)) =>
        val prevMethods: Set[Method] = prevMap getOrElse (url, Set.empty[Method])
        prevMap updated (url, prevMethods + method)
    }
    UrlsWithSources(urlWithSourcesMap)
  }

  override protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = ???

  private[this] def getUrlsForIr(ir: IR): Seq[Url] = ???
}
