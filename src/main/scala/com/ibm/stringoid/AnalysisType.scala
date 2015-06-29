package com.ibm.stringoid

import com.ibm.stringoid.retrieve._
import scopt.Read

object AnalysisType extends Enumeration {
  type AnalysisType = Value
  val CgIr     = Value("cg")
  val ChaIr    = Value("cha")
  val Grep     = Value("grep")
  val AppendIr = Value("append")

  def retriever(at: AnalysisType) = at match {
    case CgIr  =>
      CgIrUrlRetriever
    case ChaIr =>
      ChaIrUrlRetriever
    case AppendIr =>
      AppendIrRetriever
    case Grep  =>
      GrepUrlRetriever
  }

  implicit val analysisTypeRead: scopt.Read[AnalysisType] =
    Read.reads(AnalysisType.withName)
}