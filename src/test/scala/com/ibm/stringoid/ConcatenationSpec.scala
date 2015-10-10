package com.ibm.stringoid

import java.nio.file.Paths

import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.ssa.SSAInvokeInstruction
import org.scalatest.FunSpec

class ConcatenationSpec extends FunSpec with AnalysisComparison {

  describe("StringBuilder + String.format analysis") {

    val file = Paths.get("/Users/amaurremi/uw/stringoid/src/test/java/testPrograms")
    val analysisConfig = AnalysisConfig(irFromCg = false, ignoreLibs = true, analysis = AnalysisType.Append, file = file)

    it("merges results correctly") {
      val retriever = new FixedPointAppendIrRetriever(analysisConfig)
      val expectedUrls: Iterator[Method] = retriever.getIrs flatMap {
        case ir if ir.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE =>
          val assertionCall = ir.getInstructions find {
            case instr: SSAInvokeInstruction =>
              instr.getDeclaredTarget.toString contains "shouldContainUrl"
          }
          assertionCall map {
            instr =>
              val url = instr.getUse(0)
              ir.getSymbolTable.getStringValue(url)
          }
      }
      val actualUrls = retriever.getUrlsWithSources.uws.keysIterator collect {
        case Url(urlparts) =>
          urlparts.foldLeft("") {
            case (result, UrlString(string)) =>
              result + string
          }
      }
      expectedUrls foreach {
        expectedUrl =>
          assert(actualUrls contains expectedUrls, s"URL '$expectedUrl' should be contained in result")
      }
    }
  }
}
