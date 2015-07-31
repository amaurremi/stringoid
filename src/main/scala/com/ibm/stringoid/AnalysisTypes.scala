package com.ibm.stringoid

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid.retrieve._
import com.ibm.stringoid.retrieve.grep.GrepUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.constant.ConstantUrlFromIrRetriever
import com.ibm.stringoid.util.AnalysisConfig
import scopt.Read

trait AnalysisTypes {

  object AnalysisType extends Enumeration {
    type AnalysisType = Value
    val Constants = Value("constants")
    val Grep = Value("grep")
    val Append = Value("append")

    def analysisType(retriever: UrlRetriever): AnalysisType = retriever match {
      case _: ConstantUrlFromIrRetriever =>
        Constants
      case _: FixedPointAppendIrRetriever =>
        Append
      case GrepUrlRetriever =>
        Grep
    }

    implicit val analysisTypeRead: scopt.Read[AnalysisType] =
      Read.reads(AnalysisType.withName)

    def unapply(at: AnalysisType): Option[String] =
      Some(at.toString)

    implicit def AnalysisTypeEncodeJson: EncodeJson[AnalysisType] =
      jencode1L((at: AnalysisType) => at.toString)("analysis-type")
  }
}