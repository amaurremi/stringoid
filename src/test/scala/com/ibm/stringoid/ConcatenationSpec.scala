package com.ibm.stringoid

import java.nio.file.Paths

import com.ibm.stringoid.AnalysisTypeObject.AnalysisType
import com.ibm.stringoid.IrSourceObject.IrSource
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.{IR, SSAAbstractInvokeInstruction, SSAInstruction}
import org.scalatest.FunSpec

import scala.collection.{Set, breakOut}

class ConcatenationSpec extends FunSpec with StringoidAnalysis {

  describe("StringBuilder + String.format analysis") {

    import AnalysisType._
    import IrSource._

    it("reproduces debugging test") {
      val file = Paths.get("src/test/java/debug")
      val analysisConfig = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
      run(analysisConfig)
    }

    it("reproduces failing tests") {
      val file = Paths.get("src/test/java/failing")
      val analysisConfig = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = Append, file = file, outputUrls = false)
      run(analysisConfig)
    }

    it("computes URLs in CHA IR analysis") {
      val file = Paths.get("src/test/java/intraproc")
      val analysisConfig = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
      run(analysisConfig)
    }

    it("computes URLs in inter-procedural analysis") {
      val file = Paths.get("src/test/java/interproc")
      val analysisConfig = AnalysisConfig(irSource = InterProc, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
      run(analysisConfig)
    }

    def run(config: AnalysisConfig) = {
      val interProc = config.irSource == IrSource.InterProc
      retriever(config) match {
        case ret: FixedPointAppendIrRetriever =>
          val expectedUrls: Iterator[(IMethod, String)] =
            for {
              node <- ret.getAllNodes
              if node.isSource
              ir = node.getIr
              assertionCall <- getAssertionInstructions(ir)
            } yield {
              val url = assertionCall.getUse(0)
              val expectedUrl = ir.getSymbolTable.getStringValue(url)
              assert(!(List("http://", "https://") exists expectedUrl.startsWith),
                "To avoid false-positive test results, always pass URL without http/https prefix into 'shouldContainHttp'")
              (ir.getMethod, "http://" + expectedUrl)
            }

          val actualUrls: Seq[(Set[Method], String)] = (ret.getUrlsWithSources.uws collect {
            case (Url(urlParts), methods) =>
              val actualUrl = urlParts.foldLeft("") {
                case (result, UrlString(string)) =>
                  result + string
                case (result, _) =>
                  result
              }
              (methods, actualUrl)
          }) (breakOut)
          expectedUrls foreach {
            case (method, expectedUrl) =>
              val hasUrl = actualUrls exists {
                case (methods, url) =>
                  url == expectedUrl && (interProc || (methods contains method.toString))
              }
              assert(hasUrl, s"(URL '$expectedUrl' should be contained in result)")
              println(s"URL '$expectedUrl' found in $method.")
          }
      }
      println(retriever(config.copy(outputUrls = false)).getResult)
    }
  }

  private[this] def getAssertionInstructions(ir: IR): Iterable[SSAInstruction] =
    ir.getInstructions filter {
      case instr: SSAAbstractInvokeInstruction =>
        instr.getDeclaredTarget.toString contains "Assertions, shouldContainHttp(Ljava/lang/String;)V"
      case _ => false
    }
}
