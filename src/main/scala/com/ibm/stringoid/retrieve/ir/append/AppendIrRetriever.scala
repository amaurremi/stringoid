package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.wala.ssa.{IR, SSAInvokeInstruction}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object AppendIrRetriever extends IrUrlRetriever {

  override type Url = UrlSeq

  case class UrlSeq(url: Seq[UrlPart]) {
    override def toString =
      url mkString " + "
  }

  sealed trait UrlPart
  case class UrlString(string: String) extends UrlPart {
    override def toString = string
  }
  case object UrlPlaceHolder extends UrlPart
  case object UrlWithCycle extends UrlPart

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)

  override def apply(apkPath: Path): UrlsWithSources = {
    val allUrlsWithSources: Seq[(Url, Set[Method])] =
      for {
        ir           <- getIrs(apkPath)
        constantUrls  = getUrlMethodPairsFromIr(ir) map {
          u =>
            UrlSeq(Seq(UrlString(u)))
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
    ssa: StringConcatSsaConversion,
    seenVns: Set[StringSsaValueNumber]
  ): Seq[UrlPart] =
    (ssa.instrToDefUsesMap(instr).uses flatMap {
      case use if !(seenVns contains use) =>
        ssa.defToInstruction get use match {
          case Some(di) =>
            getConcatenatedString(di, ir, ssa, seenVns + use)
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
      case _                              =>
        Seq.empty[UrlPart]
    })(breakOut)

  private[this] def isUrl(concatString: Url): Boolean =
    concatString.url.nonEmpty &&
      (concatString.url.head match {
        case UrlString(string)             => string matches URL_REGEX  // todo shouldn't accept "empty" URLs (e.g. "http:")
        case UrlPlaceHolder | UrlWithCycle => false
      })

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val ssa: StringConcatSsaConversion = new StringConcatSsaConversion(ir)()
    ir.getInstructions flatMap {
      case instr: SSAInvokeInstruction if isSbAppend(instr) =>
        val concatString = UrlSeq(getConcatenatedString(instr, ir, ssa, Set.empty[StringSsaValueNumber]))
        if (isUrl(concatString))
          Some(concatString)
        else None
      case _                                                =>
        None
    }
  }
}
