package com.ibm.stringoid

import argonaut.Argonaut._
import argonaut.EncodeJson
import com.ibm.stringoid.AnalysisTypeObject.AnalysisType._
import com.ibm.stringoid.IrSourceObject.IrSource._
import com.ibm.stringoid.retrieve.UrlPartDefs.UrlsWithSources
import com.ibm.stringoid.retrieve.UrlRetriever
import com.ibm.stringoid.retrieve.grep.GrepUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetrieverImplementations.{CgIntraProcFixedPointAppendIrRetriever, ChaIntraProcFixedPointAppendIrRetriever, InterProcFixedPointAppendIrRetriever}
import com.ibm.stringoid.retrieve.ir.constant.ConstantUrlFromIrRetriever
import com.ibm.stringoid.util.TimeResult

trait StringoidAnalysis {

  case class AnalysisResult private[StringoidAnalysis] (
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
      val TimeResult(result, time) = TimeResult(retriever(config).getUrlsWithSources)
      AnalysisResult(config, time, result, result.uws.size)
    }
  }

  def retriever(config: AnalysisConfig): UrlRetriever = {

    config.analysis match {
      case Append    =>
        config.irSource match {
          case Cha       => new ChaIntraProcFixedPointAppendIrRetriever(config)
          case Cg        => new CgIntraProcFixedPointAppendIrRetriever(config)
          case InterProc => new InterProcFixedPointAppendIrRetriever(config)
        }
      case Constants =>
        new ConstantUrlFromIrRetriever(config)
      case Grep      =>
        new GrepUrlRetriever(config.file)
    }
  }
}
