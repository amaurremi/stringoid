package com.ibm.stringoid

import argonaut.Argonaut._
import argonaut._
import scopt.Read

trait AnalysisTypes {

  object AnalysisType extends Enumeration {
    type AnalysisType = Value
    val Constants = Value("constants")
    val Grep = Value("grep")
    val Append = Value("append")

    implicit val analysisTypeRead: scopt.Read[AnalysisType] =
      Read.reads(AnalysisType.withName)

    def unapply(at: AnalysisType): Option[String] =
      Some(at.toString)

    implicit def AnalysisTypeEncodeJson: EncodeJson[AnalysisType] =
      jencode1L((at: AnalysisType) => at.toString)("analysis-type")
  }
}