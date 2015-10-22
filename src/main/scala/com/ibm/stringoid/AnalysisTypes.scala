package com.ibm.stringoid

import scopt.Read

trait AnalysisTypes {

  object AnalysisType extends Enumeration {
    type AnalysisType = Value
    val Append    = Value("append")
    val Constants = Value("constants")
    val Grep      = Value("grep")
    val ATUnset     = Value

    def validValues: ValueSet = values - ATUnset

    implicit val analysisTypeRead: scopt.Read[AnalysisType] =
      Read.reads(AnalysisType.withName)

    def prettyPrintAT(at: AnalysisType) =
      at match {
        case Append    =>
          "append (extracting string concatentations through StringBuilders/StringBuffers and '+')"
        case Constants =>
          "constants (extracting constant URLs from symbol tables)"
        case Grep      =>
          "grep"
        case ATUnset   =>
          throw new UnsupportedOperationException("no analysis set")
      }
  }

  object IrSource extends Enumeration {
    type IrSource = Value
    val Cha           = Value("cha")
    val Cg            = Value("cg")
    val InterProc     = Value("interproc")
    val IrSourceUnset = Value

    def validValues: ValueSet = values - IrSourceUnset

    implicit val irSourceRead: scopt.Read[IrSource] =
      Read.reads(IrSource.withName)

    def prettyPrintIS(is: IrSource) =
      is match {
        case Cha       => 
          "class hierarchy analysis"
        case Cg        =>
          "call graph"
        case InterProc =>
          "inter-procedural analysis"
        case IrSourceUnset     =>
          throw new UnsupportedOperationException("no analysis set")
      }
  }
}