package com.ibm.stringoid

import scopt.Read

trait AnalysisTypes {

  object AnalysisType extends Enumeration {
    type AnalysisType = Value
    val Constants = Value("constants")
    val Grep = Value("grep")
    val Append = Value("append")

    implicit val analysisTypeRead: scopt.Read[AnalysisType] =
      Read.reads(AnalysisType.withName)

    def prettyPrint(at: AnalysisType) =
      at match {
        case Constants =>
          "constants (extracting constant URLs from symbol tables)"
        case Grep      =>
          "grep"
        case Append    =>
          "append (extracting string concatentations through StringBuilders and '+'"
      }
  }
}