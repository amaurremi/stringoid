package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid.util.AnalysisConfig

trait AnalysisComparison extends UrlRetrievers {

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
      AnalysisComparisonResult(retriever(a1, config)(apkPath), retriever(a2, config)(apkPath))
    }
  }
}
