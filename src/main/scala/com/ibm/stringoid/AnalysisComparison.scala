package com.ibm.stringoid

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid.util.AnalysisConfig

trait AnalysisComparison extends AnalysisTypes with UrlRetrievers {

  import AnalysisType._

  case class AnalysisResult(
    analysis: AnalysisType,
    runningTime: Double,
    urlsWithSources: UrlsWithSources
  )

  object AnalysisResult {
    implicit def AnalysisResultEncodeJson: EncodeJson[AnalysisResult] =
      jencode3L(
        (ar: AnalysisResult) =>
          (ar.analysis, ar.runningTime, ar.urlsWithSources)
      )("analysis", "running-time", "urls-with-sources")
  }

  case class AnalysisComparisonResult(
    a1: AnalysisResult,
    a2: AnalysisResult
  )

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
