package com.ibm.stringoid.retrieve.ir.constant

import com.ibm.stringoid.retrieve.ir.{IntraProcIrModule, IrUrlRetrievers}
import com.ibm.stringoid.util.TimeResult

trait ConstantUrlFromIrRetrievers extends IrUrlRetrievers with IntraProcIrModule {

  /**
   * An analysis that is based on extracting the URL strings that appear as
   * constants in an IR's symbol table.
   */
  final class ConstantUrlFromIrRetriever(override val config: AnalysisConfig) extends ChaIntraProcIrNodes {

    override def getUrlsWithSources: UrlsWithSources = {
      val TimeResult(nodes, walaTime) = TimeResult(getNodes)
      val urlMethodPairs: Iterator[(Url, Method)] = nodes flatMap {
        node =>
          getConstantUrlStrings(node.getIr) map {
            url =>
              val method = node.getIr.getMethod
              Url(Vector(UrlString(url))) -> (method.getDeclaringClass.getName + "." + method.getName.toString)
          }
      }
      val urlWithSources = urlMethodPairs.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prev, (wu, m)) =>
          prev.updated(wu, prev.getOrElse(wu, Set.empty[Method]) + m)
      }
      UrlsWithSources(urlWithSources, walaTime)
    }
  }

}