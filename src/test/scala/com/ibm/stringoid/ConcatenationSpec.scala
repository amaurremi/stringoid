package com.ibm.stringoid

import java.nio.file.Paths

import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.{IR, SSAAbstractInvokeInstruction, SSAInstruction}
import org.scalatest.FunSpec

import scala.collection.{Set, breakOut}

class ConcatenationSpec extends FunSpec with AnalysisComparison {

  describe("StringBuilder + String.format analysis") {

    it("computes URLs in CHA IR analysis") {
      val file = Paths.get("/Users/amaurremi/uw/stringoid/src/test/java/intraProcTestPrograms")
      val analysisConfig = AnalysisConfig(irFromCg = false, ignoreLibs = true, analysis = AnalysisType.Append, file = file)
      run(analysisConfig)
    }

    it("computes URLs in inter-procedural analysis") {
      val file = Paths.get("/Users/amaurremi/uw/stringoid/src/test/java/interProcTestPrograms")
      val analysisConfig = AnalysisConfig(irFromCg = true, ignoreLibs = true, analysis = AnalysisType.InterProc, file = file)
      run(analysisConfig)
    }

    def run(config: AnalysisConfig) = {
      val retriever = new FixedPointAppendIrRetriever(config)
      val expectedUrls: Iterator[(IMethod, String)] =
        for {
          ir            <- retriever.getIrs
          if isSourceIr(ir)
          assertionCall <- getAssertionInstructions(ir)
        } yield {
          val url = assertionCall.getUse(0)
          val expectedUrl = ir.getSymbolTable.getStringValue(url)
          assert(!(List("http://", "https://") exists expectedUrl.startsWith),
            "To avoid false-positive test results, always pass URL without http/https prefix into 'shouldContainHttp'")
          (ir.getMethod, "http://" + expectedUrl)
        }

      val actualUrls: Seq[(Set[Method], String)] = (retriever.getUrlsWithSources.uws collect {
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
          println(s"URL '$expectedUrl' found in $method.")
      }
    }
  }

  private[this] def isSourceIr(ir: IR) =
    ir.getMethod.getDeclaringClass.getClassLoader.getReference == JavaSourceAnalysisScope.SOURCE

  private[this] def getAssertionInstructions(ir: IR): Iterable[SSAInstruction] =
    ir.getInstructions filter {
      case instr: SSAAbstractInvokeInstruction =>
        instr.getDeclaredTarget.toString contains "Assertions, shouldContainHttp(Ljava/lang/String;)V"
      case _ => false
    }
}
