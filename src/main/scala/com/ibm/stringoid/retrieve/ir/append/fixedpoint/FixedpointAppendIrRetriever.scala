package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrFromBuilderRetriever
import com.ibm.stringoid.retrieve.ir.append.AppendUrl
import com.ibm.wala.ssa.IR

object FixedpointAppendIrRetriever extends IrFromBuilderRetriever with AppendUrl with AbstractStringBuilderModule {

  override type Url = UrlSeq

  override def apply(apkPath: Path): UrlsWithSources = {
    val urlsWithSources: Seq[(Url, Method)] = for {
      ir  <- getIrs(apkPath)
      url <- getUrlsForIr(ir)
    } yield url -> ir.getMethod.toString
    val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, method)) =>
        val prevMethods = prevMap getOrElse (url, Set.empty[Method])
        prevMap updated (url, prevMethods + method)
    }
    UrlsWithSources(urlWithSourcesMap)
  }

  private[this] def getUrlsForIr(ir: IR): Seq[Url] = {
    val valNumToAsbo = valNumToAbstractStringBuilder(ir)
    ???
  }
}
