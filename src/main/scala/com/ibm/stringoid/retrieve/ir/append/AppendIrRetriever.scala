package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.wala.ssa.{IR, SSAInstruction, SSAInvokeInstruction}
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
    vn: ValueNumber,
    defUses: Map[SSAInstruction, DefUses],
    ir: IR
  ): Url = {
    // todo cycles!
//    if ir.getSymbolTable isConstant
    ???
  }

  private[this] def isUrl(concatString: Seq[UrlPart]): Boolean = ???

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val defUses = new StringConcatSsaConversion(ir).defUses
    ir.getInstructions flatMap {
      case instr: SSAInvokeInstruction if isSbAppend(instr) =>
        // todo it should be enough to get URLs for only one of the defs, right?
        val concatString = getConcatenatedString(instr, defUses(instr).defs(0), defUses, ir)
        if (isUrl(concatString))
          Some(concatString)
        else None
    }
  }
}
