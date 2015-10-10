package com.ibm.stringoid

import java.nio.file.Paths

import org.scalatest.FunSpec

import scala.collection.breakOut

class ConcatenationSpec extends FunSpec with AnalysisComparison {

  describe("StringBuilder + String.format analysis") {

    val file = Paths.get("/Users/amaurremi/uw/stringoid/src/test/java/testPrograms")
    val analysisConfig = AnalysisConfig(irFromCg = false, ignoreLibs = true, analysis = AnalysisType.Append, file = file)

    it("merges results correctly") {
      val retriever = new FixedPointAppendIrRetriever(analysisConfig)
      val expectedUrlParts: Option[Vector[UrlPart]] = retriever.getIrs collectFirst {
        case ir if ir.getMethod.toString contains "Assertions" =>
          val table = ir.getSymbolTable
          (for {
            paramNum <- 1 until ir.getNumberOfParameters
            string = table getStringValue paramNum
          } yield UrlString(string))(breakOut)
      }
      val actual = retriever.getUrlsWithSources.uws.keysIterator find {
        case Url(urlparts) =>
          urlparts == expectedUrlParts.get
      }
      assert(actual.isDefined)
    }
  }
}
