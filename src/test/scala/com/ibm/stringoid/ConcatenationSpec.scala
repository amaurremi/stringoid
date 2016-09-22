package com.ibm.stringoid

import java.nio.file.Paths

import com.ibm.stringoid.AnalysisTypeObject.AnalysisType
import com.ibm.stringoid.IrSourceObject.IrSource
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.{IR, SSAAbstractInvokeInstruction, SSAInstruction}
import org.scalatest.FunSpec

import scala.collection.{Set, breakOut}

class ConcatenationSpec extends FunSpec with StringoidAnalysis {

  private[this] val doRunTests = true

  import AnalysisType._
  import IrSource._

  describe("Concatenations") {

    if (doRunTests) {

      /* Run this test for your example programs */
      it("computes URLs in inter-procedural analysis (moretests)") {
        val file = Paths.get("src/test/java/moretests")
        val analysisConfig = AnalysisConfig(irSource = InterProc, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
        run(analysisConfig)
      }

//      it("runs a benchmark") {
//        val ret = retriever(AnalysisConfig(irSource = InterProc, ignoreLibs = true, analysis = Append, file = Paths.get("dynamic-data/apps/mobi.ifunny-2447.apk"), outputUrls = true))
//        println(ret.getResult)
//      }

//      /* debugging */
//      it("reproduces debugging test") {
//        val file = Paths.get("src/test/java/debug")
//        val analysisConfig = AnalysisConfig(irSource = InterProc, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
//        run(analysisConfig)
//      }

      /* failing */
//      it("reproduces failing tests") {
//        val file = Paths.get("src/test/java/failing")
//        val analysisConfig = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = Append, file = file, outputUrls = false)
//        run(analysisConfig)
//      }

//      /* INTRA procedural*/
//      it("computes URLs in CHA IR analysis") {
//        val file = Paths.get("src/test/java/intraproc")
//        val analysisConfig = AnalysisConfig(irSource = Cha, ignoreLibs = true, analysis = Append, file = file, outputUrls = true)
//        run(analysisConfig)
//      }

//      /* INTER procedural */
//      it("computes URLs in inter-procedural analysis") {
//        val fileInter = Paths.get("src/test/java/interproc")
//        val config    = AnalysisConfig(irSource = InterProc, ignoreLibs = true, analysis = Append, file = fileInter, outputUrls = true)
//        run(config)
//        val fileIntra = Paths.get("src/test/java/intraproc")
//        val analysisConfigIntra = config.copy(file = fileIntra)
//        run(analysisConfigIntra)
//      }
//    } else {
//      println("No tests run: test running option disabled")
//    }

    def run(config: AnalysisConfig) = {
      val interProc = config.irSource == IrSource.InterProc
      retriever(config) match {
        case ret: IrUrlRetriever =>
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
              assert(hasUrl, s"(URL '$expectedUrl' should be contained in result.\nFound URLs: ${actualUrls.unzip._2.mkString("\n")})")
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
