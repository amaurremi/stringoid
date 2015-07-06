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
    ssa: StringConcatSsaConversion
  ): (Url, Set[Method]) = {
    ???
  }

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val ssa = new StringConcatSsaConversion(ir)
    val appendUrls = ir.getInstructions collect {
      case instr: SSAInvokeInstruction if isSbConstructorWithRefParam(instr) =>
          val table = ir.getSymbolTable
          val argVn = instr getUse 1
          if (table isStringConstant argVn) {
            val string = table getStringValue argVn
            if (string matches URL_REGEX) Seq(UrlString(string))
            else Seq.empty[UrlPart]
          } else Seq.empty[UrlPart]
      case instr: SSAInvokeInstruction if isSbAppend(instr)                  =>
        ???
    }
    ???
  }
}
