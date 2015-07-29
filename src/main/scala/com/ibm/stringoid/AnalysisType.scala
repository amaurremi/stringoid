package com.ibm.stringoid

import com.ibm.stringoid.retrieve._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.append.ssa.SsaAppendIrRetriever
import com.ibm.stringoid.retrieve.ir._
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
      new ConstantUrlFromIrRetriever with IrFromCgRetriever
    case ChaIr =>
      new ConstantUrlFromIrRetriever with IrFromChaRetriever
    case AppendCg =>
      new FixedPointAppendIrRetriever with IrFromCgRetriever
    case AppendCha =>
      new FixedPointAppendIrRetriever with IrFromChaRetriever
    case SsaAppend =>
      SsaAppendIrRetriever
    case Grep  =>
      GrepUrlRetriever
  }

  implicit val analysisTypeRead: scopt.Read[AnalysisType] =
    Read.reads(AnalysisType.withName)
}
