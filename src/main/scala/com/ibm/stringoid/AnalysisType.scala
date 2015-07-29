package com.ibm.stringoid

import com.ibm.stringoid.retrieve._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.append.ssa.SsaAppendIrRetriever
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.util.AnalysisConfig
import scopt.Read

object AnalysisType extends Enumeration {
  type AnalysisType = Value
  val Constants = Value("constants")
  val Grep        = Value("grep")
  val Append      = Value("append")
  val SsaAppend   = Value("ssa")

  def retriever(at: AnalysisType, config: AnalysisConfig) = at match {
    case Constants  =>
      new ConstantUrlFromIrRetriever(config)
    case Append =>
      new FixedPointAppendIrRetriever(config)
    case SsaAppend =>
      new SsaAppendIrRetriever(config)
    case Grep  =>
      GrepUrlRetriever
  }

  implicit val analysisTypeRead: scopt.Read[AnalysisType] =
    Read.reads(AnalysisType.withName)
}
