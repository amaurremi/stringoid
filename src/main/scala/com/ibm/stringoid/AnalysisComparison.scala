package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid.retrieve.grep.GrepUrlRetrievers
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetrievers
import com.ibm.stringoid.retrieve.ir.constant.ConstantUrlFromIrRetrievers
import com.ibm.stringoid.util.TimeResult

trait AnalysisComparison extends FixedPointAppendIrRetrievers with ConstantUrlFromIrRetrievers with GrepUrlRetrievers {

  import AnalysisType._

  def retriever(config: AnalysisConfig): UrlRetriever =
    config.analysis match {
      case Constants =>
        new ConstantUrlFromIrRetriever(config)
      case Append =>
        new FixedPointAppendIrRetriever(config)
      case Grep =>
        GrepUrlRetriever
    }

  case class AnalysisComparisonResult(
    result1: AnalysisResult,
    result2: AnalysisResult,
    in1not2size: Int,
    in2not1size: Int,
    in1not2: Set[Url],
    in2not1: Set[Url]
  )

  object AnalysisComparisonResult {
    implicit def AnalysisComparisonResultEncodeJson: EncodeJson[AnalysisComparisonResult] =
      jencode6L(
        (acr: AnalysisComparisonResult) => {
          import acr._
          (result1, result2, in1not2size, in2not1size, in1not2, in2not1)
        }
      )("1st analysis",
        "2nd analysis",
        "1st has > URLs than 2nd by",
        "2nd has > URLs than 1st by",
        "in 1st analysis but not in 2nd",
        "in 2nd analysis but not in 1st")

    /**
     * Retrieve the URLs for an APK file using WALA and using grep.
     */
    def apply(
      config1: AnalysisConfig,
      config2: AnalysisConfig,
      apkPath: Path
    ): AnalysisComparisonResult = {
      val TimeResult(result1, time1) = TimeResult(retriever(config1)(apkPath))
      val TimeResult(result2, time2) = TimeResult(retriever(config2)(apkPath))
      val ar1 = AnalysisResult(config1, time1, result1, result1.uws.size)
      val ar2 = AnalysisResult(config2, time2, result2, result2.uws.size)
      val urls1 = ar1.urlsWithSources.uws.keySet
      val urls2 = ar2.urlsWithSources.uws.keySet
      val in1not2 = (urls1 diff urls2).toSet
      val in2not1 = (urls2 diff urls1).toSet
      AnalysisComparisonResult(ar1 , ar2, in1not2.size, in2not1.size, in1not2, in2not1)
    }
  }
}
