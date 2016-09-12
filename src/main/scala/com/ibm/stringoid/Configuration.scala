package com.ibm.stringoid

import java.nio.file.{Path, Paths}

import argonaut.Argonaut._
import argonaut.EncodeJson
import scopt.Read

object AnalysisTypeObject {

  object AnalysisType extends Enumeration {
    type AnalysisType = Value
    val Append = Value("append")
    val Constants = Value("constants")
    val Grep = Value("grep")
    val ATUnset = Value

    def validValues = values - ATUnset

    implicit val analysisTypeRead: scopt.Read[AnalysisType] =
      Read.reads(AnalysisType.withName)

    def prettyPrintAT(at: AnalysisType) =
      at match {
        case Append =>
          "append (extracting string concatentations through StringBuilders/StringBuffers and '+')"
        case Constants =>
          "constants (extracting constant URLs from symbol tables)"
        case Grep =>
          "grep"
        case ATUnset =>
          throw new UnsupportedOperationException("no analysis set")
      }
  }

}

object IrSourceObject {

  object IrSource extends Enumeration {
    type IrSource = Value
    val Cha = Value("cha")
    val Cg = Value("cg")
    val InterProc = Value("interproc")
    val InterProcOld = Value("interprocold")
    val IrSourceUnset = Value

    def validValues = values - IrSourceUnset

    implicit val irSourceRead: scopt.Read[IrSource] =
      Read.reads(IrSource.withName)

    def prettyPrintIS(is: IrSource) =
      is match {
        case Cha =>
          "class hierarchy analysis"
        case Cg =>
          "call graph"
        case InterProc =>
          "inter-procedural analysis (one-pass)"
        case InterProcOld =>
          "old inter-procedural analysis (worklist)"
        case IrSourceUnset =>
          throw new UnsupportedOperationException("no analysis set")
      }
  }

}

import com.ibm.stringoid.AnalysisTypeObject.AnalysisType._
import com.ibm.stringoid.IrSourceObject.IrSource._

case class AnalysisConfig(irSource: IrSource, ignoreLibs: Boolean, analysis: AnalysisType, outputUrls: Boolean, file: Path)

object AnalysisConfig {

  implicit def AnalysisConfigEncodeJson: EncodeJson[AnalysisConfig] =
    jencode3L(
      (ac: AnalysisConfig) => {
        import ac._
        val lib = if (ignoreLibs) "ignoring" else "including"
        (prettyPrintAT(analysis), lib, prettyPrintIS(irSource))
      }
    )("analysis", "libs", "reachability")

  val default = AnalysisConfig(
    irSource = IrSourceObject.IrSource.Cha,
    ignoreLibs = true,
    analysis = ATUnset,
    outputUrls = false,
    Paths.get("src/test/java/testPrograms")
  )
}