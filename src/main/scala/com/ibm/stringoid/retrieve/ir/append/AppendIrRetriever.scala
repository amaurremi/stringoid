package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.wala.ssa.{IR, SSAInvokeInstruction}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object AppendIrRetriever extends IrUrlRetriever {

  override type Url = Seq[UrlPart]

  sealed trait UrlPart
  case class UrlString(string: String) extends UrlPart
  case object UrlPlaceHolder extends UrlPart

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)

  override def apply(apkPath: Path): UrlsWithSources = {
    val allUrlsWithSources: Seq[(Url, Set[Method])] =
      for {
        ir           <- getIrs(apkPath)
        constantUrls  = getUrlMethodPairsFromIr(ir) map {
          u =>
            Seq(UrlString(u))
        }
        allUrlParts   = constantUrls ++ getUrlsWithSourcesForIr(ir)
        url          <- allUrlParts
      } yield url -> Set(ir.getMethod.toString)
    UrlsWithSources(allUrlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, strings)) =>
        prevMap updated (url, (prevMap getOrElse(url, Set.empty[Method])) ++ strings)
    })
  }

  private[this] def getConcatenatedString(
    instr: SSAInvokeInstruction,
    ir: IR,
    ssa: StringConcatSsaConversion
  ): Url = {
    // todo cycles!
    (ssa.instrToDefUsesMap(instr).uses flatMap {
      use =>
        ssa.defToInstruction get use match {
          case Some(di) =>
            getConcatenatedString(di, ir, ssa)
          case None     =>
            val table = ir.getSymbolTable
            ssa.getOldVals(use) map {
              oldVal =>
                if (table isConstant oldVal)
                  UrlString((table getConstantValue oldVal).toString) // todo more refined types, not just string?
                else
                  UrlPlaceHolder
            }
        }
    })(breakOut)
  }

  private[this] def isUrl(concatString: Url): Boolean =
    concatString.nonEmpty &&
      (concatString.head match {
        case UrlString(string) => string matches URL_REGEX  // todo shouldn't accept "empty" URLs (e.g. "http:")
        case UrlPlaceHolder    => false
      })

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val ssa: StringConcatSsaConversion = new StringConcatSsaConversion(ir)
    ir.getInstructions flatMap {
      case instr: SSAInvokeInstruction if isSbAppend(instr) =>
        val concatString = getConcatenatedString(instr, ir, ssa)
        if (isUrl(concatString))
          Some(concatString)
        else None
      case _                                                =>
        None
    }
  }
}
