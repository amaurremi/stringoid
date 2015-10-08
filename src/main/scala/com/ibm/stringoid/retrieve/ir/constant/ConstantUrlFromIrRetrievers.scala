package com.ibm.stringoid.retrieve.ir.constant

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetrievers
import com.ibm.stringoid.util.TimeResult

trait ConstantUrlFromIrRetrievers extends IrUrlRetrievers {

  /**
   * An analysis that is based on extracting the URL strings that appear as
   * constants in an IR's symbol table.
   */
  final class ConstantUrlFromIrRetriever(override val config: AnalysisConfig) extends IrUrlRetriever {

    override def apply(file: Path): UrlsWithSources = {
      val TimeResult(irs, walaTime) = TimeResult(getIrs(file))
      val urlMethodPairs: Iterator[(Url, Method)] = irs flatMap {
        ir =>
          getConstantUrlStrings(ir) map {
            url =>
              val method = ir.getMethod
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