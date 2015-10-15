package com.ibm.stringoid

import java.nio.file.Paths

import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.{IR, SSAAbstractInvokeInstruction, SSAInstruction}
import org.scalatest.FunSpec

import scala.collection.{Set, breakOut}

class ConcatenationSpec extends FunSpec with AnalysisComparison {

  describe("StringBuilder + String.format analysis") {

    val file = Paths.get("/Users/amaurremi/uw/stringoid/src/test/java/testPrograms")
    val analysisConfig = AnalysisConfig(irFromCg = false, ignoreLibs = true, analysis = AnalysisType.Append, file = file)

    it("merges results correctly") {
      val retriever = new FixedPointAppendIrRetriever(analysisConfig)
      val expectedUrls: Iterator[(IMethod, String)] =
        for {
          ir            <- retriever.getIrs
          if isSourceIr(ir)
          assertionCall <- getAssertionInstruction(ir)
        } yield {
          val url = assertionCall.getUse(0)
          (ir.getMethod, "http://" + ir.getSymbolTable.getStringValue(url))
        }

      val actualUrls: Seq[(Set[Method], Method)] = (retriever.getUrlsWithSources.uws collect {
        case (Url(urlParts), methods) =>
          val actualUrl = urlParts.foldLeft("") {
            case (result, UrlString(string)) =>
              result + string
            case (result, _) =>
              result
          }
          (methods, actualUrl)
      })(breakOut)
      expectedUrls foreach {
        case (method, expectedUrl) =>
          val hasUrl = actualUrls exists {
            case (methods, url) =>
              url == expectedUrl && (methods contains method.toString)
          }
          assert(hasUrl, s"(URL '$expectedUrl' should be contained in result)")
      }
    }
  }

  private[this] def isSourceIr(ir: IR) =
    ir.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE

  private[this] def getAssertionInstruction(ir: IR): Option[SSAInstruction] =
    ir.getInstructions find {
      case instr: SSAAbstractInvokeInstruction =>
        instr.getDeclaredTarget.toString contains "LtestPrograms/Assertions, shouldContainHttp(Ljava/lang/String;)V"
      case _ => false
    }
}
