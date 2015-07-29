package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path

import com.ibm.stringoid.util.AnalysisConfig

/**
 * An analysis that is based on extracting the URL strings that appear as
 * constants in an IR's symbol table.
 */
final class ConstantUrlFromIrRetriever(override val config: AnalysisConfig) extends IrUrlRetriever {

  override type Url = String

  override def apply(
    apkPath: Path
  ): UrlsWithSources = {
    val urlMethodPairs: Seq[(Url, Method)] = getIrs(apkPath) flatMap {
      ir =>
        getConstantUrlStrings(ir) map {
          url =>
            val method = ir.getMethod
            url -> (method.getDeclaringClass.getName + "." + method.getName.toString)
        }
    }
    UrlsWithSources(urlMethodPairs.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prev, (wu, m)) =>
        prev.updated(wu, prev.getOrElse(wu, Set.empty[Method]) + m)
    })
  }
}
