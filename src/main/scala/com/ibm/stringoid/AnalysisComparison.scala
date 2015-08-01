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

  def retriever(config: AnalysisConfig): UrlRetriever = config.analysis match {
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

  case class AnalysisComparisonResult(result1: AnalysisResult, result2: AnalysisResult)

  object AnalysisComparisonResult {
    implicit def AnalysisComparisonResultEncodeJson: EncodeJson[AnalysisComparisonResult] =
      jencode2L(
        (acr: AnalysisComparisonResult) =>
          (acr.result1, acr.result2)
      )("analysis1", "analysis2")

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
      AnalysisComparisonResult(AnalysisResult(config1, time1, result1) , AnalysisResult(config2, time2, result2))
    }
  }
}
