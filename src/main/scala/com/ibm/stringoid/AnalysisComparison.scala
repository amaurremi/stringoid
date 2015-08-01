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

  def retriever(at: AnalysisType, config: AnalysisConfig): UrlRetriever = at match {
    case Constants =>
      new ConstantUrlFromIrRetriever(config)
    case Append =>
      new FixedPointAppendIrRetriever(config)
    case Grep =>
      GrepUrlRetriever
  }

  def analysisType(retriever: UrlRetriever): AnalysisType = retriever match {
    case _: ConstantUrlFromIrRetriever =>
      Constants
    case _: FixedPointAppendIrRetriever =>
      Append
    case GrepUrlRetriever =>
      Grep
  }

  case class AnalysisComparisonResult(a1: AnalysisResult, a2: AnalysisResult)

  object AnalysisComparisonResult {
    implicit def AnalysisComparisonResultEncodeJson: EncodeJson[AnalysisComparisonResult] =
      jencode2L(
        (acr: AnalysisComparisonResult) =>
          (acr.a1, acr.a2)
      )("analysis1", "analysis2")

    /**
     * Retrieve the URLs for an APK file using WALA and using grep.
     */
    def apply(
      a1: AnalysisType,
      a2: AnalysisType,
      apkPath: Path,
      config: AnalysisConfig
    ): AnalysisComparisonResult = {
      val TimeResult(result1, time1) = TimeResult(retriever(a1, config)(apkPath))
      val TimeResult(result2, time2) = TimeResult(retriever(a2, config)(apkPath))
      AnalysisComparisonResult(AnalysisResult(a1, time1, result1) , AnalysisResult(a2, time2, result2))
    }
  }
}
