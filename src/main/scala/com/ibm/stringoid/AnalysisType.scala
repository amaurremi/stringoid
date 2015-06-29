package com.ibm.stringoid

import com.ibm.stringoid.retrieve.{CgIrUrlRetriever, ChaIrUrlRetriever, GrepUrlRetriever}
import scopt.Read

object AnalysisType extends Enumeration {
  type AnalysisType = Value
  val CgIr  = Value("cg")
  val ChaIr = Value("cha")
  val Grep  = Value("grep")

  def retriever(at: AnalysisType) = at match {
    case CgIr  =>
      CgIrUrlRetriever
    case ChaIr =>
      ChaIrUrlRetriever
    case Grep  =>
      GrepUrlRetriever
  }

  implicit val analysisTypeRead: scopt.Read[AnalysisType] =
    Read.reads(AnalysisType.withName)
}
