package com.ibm.stringoid

import com.ibm.stringoid.retrieve._
import com.ibm.stringoid.retrieve.ir.append.ssa.SsaAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.{CgIrUrlRetriever, UrlFromChaRetriever}
import scopt.Read

object AnalysisType extends Enumeration {
  type AnalysisType = Value
  val CgIr      = Value("cg")
  val ChaIr     = Value("cha")
  val Grep      = Value("grep")
  val AppendCg  = Value("append_cg")
  val AppendCha = Value("append_cha")
  val SsaAppend = Value("ssa")

  def retriever(at: AnalysisType) = at match {
    case CgIr  =>
      CgIrUrlRetriever
    case ChaIr =>
      UrlFromChaRetriever
    case Append =>
      FixedPointAppendIrRetriever
    case SsaAppend =>
      SsaAppendIrRetriever
    case Grep  =>
      GrepUrlRetriever
  }

  implicit val analysisTypeRead: scopt.Read[AnalysisType] =
    Read.reads(AnalysisType.withName)
}
