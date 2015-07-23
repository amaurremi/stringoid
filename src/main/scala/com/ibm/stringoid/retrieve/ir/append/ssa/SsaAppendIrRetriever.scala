package com.ibm.stringoid.retrieve.ir.append.ssa

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrFromBuilderRetriever
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.ssa.{IR, SSAInvokeInstruction, SSAPhiInstruction}

import scala.collection.breakOut

object SsaAppendIrRetriever extends IrFromBuilderRetriever with AppendUrl {

  override type Url = UrlSeq

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
    ssa: StringConcatSsaResult,
    seenVns: Set[StringSsaValueNumber]
  ): Seq[UrlPart] =
    (ssa.normalInstrToDefUsesMap(instr).uses flatMap {
      use =>
        getConcatenatedStringForUse(use, instr, ir, ssa, seenVns)
    })(breakOut)

  private[this] def getConcatenatedStringForUse(
    use: StringSsaValueNumber,
    instr: SSAInvokeInstruction,
    ir: IR,
    ssa: StringConcatSsaResult,
    seenVns: Set[StringSsaValueNumber]
  ): Seq[UrlPart] = { // todo also for phi instructions?
    if (!(seenVns contains use))
      ssa.defToInstruction get use match {
        case Some(di: SSAInvokeInstruction) =>
          getConcatenatedString(di, ir, ssa, seenVns + use)
        case Some(pi: SSAPhiInstruction)    =>
          val distinctUses: Set[StringSsaValueNumber] = (0 until pi.getNumberOfUses map {
            useNr =>
              SSVN(pi.getUse(useNr))
          })(breakOut)
          val urls: Set[Url] = distinctUses map {
            phiUse =>
              UrlSeq(getConcatenatedStringForUse(phiUse, instr, ir, ssa, seenVns + use))
          }
          Seq(UrlPhi(urls))
        case None                           =>
          val table = ir.getSymbolTable
          val results: Set[UrlPart] = ssa.getOldVals(use) map {
            oldVal =>
              if (table isConstant oldVal)
                UrlString((table getConstantValue oldVal).toString) // todo more refined types, not just string?
              else
                UrlPlaceHolder
          }
          if (results.size == 1)
            Seq(results.head)
          else
            Seq(UrlPhi(results map {
              result =>
                UrlSeq(Seq(result))
            }))
        case _                              =>
          throw new UnsupportedOperationException(INVOKE_INSTR_MSG)
      }
    else Seq.empty[UrlPart]
  }

  private[this] def isUrl(concatString: Url): Boolean =
    concatString.url.nonEmpty &&
      (concatString.url.head match {
        case UrlString(string)             => string matches URL_REGEX  // todo shouldn't accept "empty" URLs (e.g. "http:")
        case UrlPhi(phis)                  => phis exists isUrl
        case UrlPlaceHolder | UrlWithCycle => false
      })

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val ssa = StringConcatSsaResult(ir)
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
