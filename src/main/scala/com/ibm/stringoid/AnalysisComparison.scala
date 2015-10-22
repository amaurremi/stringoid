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

  def retriever(config: AnalysisConfig): UrlsWithSources = {
    val retriever: UrlRetriever = config.analysis match {
      case Append    =>
        new FixedPointAppendIrRetriever(config)
      case Constants =>
        new ConstantUrlFromIrRetriever(config)
      case Grep      =>
        new GrepUrlRetriever(config.file)
    }
    retriever.getUrlsWithSources
  }

  case class AnalysisResult private[AnalysisComparison](
    config: AnalysisConfig,
    runningTime: Double,
    urlsWithSources: UrlsWithSources,
    urlsNum: Int
  )

  object AnalysisResult {
    implicit def AnalysisResultEncodeJson: EncodeJson[AnalysisResult] =
      jencode4L(
        (ar: AnalysisResult) => {
          import ar._
          (config, runningTime, urlsWithSources, urlsNum)
        }
      )("config", "runtime", "result", "url-num")

    def fromConfig(
      config: AnalysisConfig
    ): AnalysisResult = {
      val TimeResult(result, time) = TimeResult(retriever(config))
      AnalysisResult(config, time, result, result.uws.size)
    }
  }

  case class AnalysisComparisonResult private[AnalysisComparison](
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
      )("analysis1",
        "analysis2",
        "diff_1_2", // difference between the number of results in the first and second analysis
        "diff_2_1", // difference between the number of results in the second and first analysis
        "in1not2",  // URLs present in the first but not second analysis
        "in2not1")  // URLs present in the second but not first analysis

    /**
     * Retrieve the URLs for an APK file using WALA and using grep.
     */
    def fromConfigs(
      config1: AnalysisConfig,
      config2: AnalysisConfig,
      apkPath: Path
    ): AnalysisComparisonResult = {
      val ar1 = AnalysisResult.fromConfig(config1)
      val ar2 = AnalysisResult.fromConfig(config2)
      val urls1 = ar1.urlsWithSources.uws.keySet
      val urls2 = ar2.urlsWithSources.uws.keySet
      val in1not2 = (urls1 diff urls2).toSet
      val in2not1 = (urls2 diff urls1).toSet
      AnalysisComparisonResult(ar1 , ar2, in1not2.size, in2not1.size, in1not2, in2not1)
    }
  }
}
