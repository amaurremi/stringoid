package com.ibm.stringoid.retrieve.ir.constant

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetrievers

trait ConstantUrlFromIrRetrievers extends IrUrlRetrievers {

  /**
   * An analysis that is based on extracting the URL strings that appear as
   * constants in an IR's symbol table.
   */
  final class ConstantUrlFromIrRetriever(override val config: AnalysisConfig) extends IrUrlRetriever {

    override def apply(apkPath: Path): UrlsWithSources = {
      val urlMethodPairs: Seq[(Url, Method)] = getIrs(apkPath) flatMap {
        ir =>
          getConstantUrlStrings(ir) map {
            url =>
              val method = ir.getMethod
              Url(List(UrlString(url))) -> (method.getDeclaringClass.getName + "." + method.getName.toString)
          }
      }
      val urlWithSetSources = urlMethodPairs.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prev, (wu, m)) =>
          prev.updated(wu, prev.getOrElse(wu, Set.empty[Method]) + m)
      }
      val urlWithListSources = urlWithSetSources map {
        case (url, methods: Set[Method]) =>
          url -> methods.toList
      }
      UrlsWithSources(urlWithListSources)
    }
  }

}