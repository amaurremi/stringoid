package com.ibm.stringoid.retrieve.ir.append

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.{Url, UrlsWithSources}
import com.ibm.wala.ssa.{SymbolTable, IR, SSAInvokeInstruction}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object AppendIrRetriever extends IrUrlRetriever {

  protected def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] =
    (builder.cg map { _.getIR })(breakOut)

  override def getUrlsWithSources(apkPath: Path): UrlsWithSources = {
    val allUrlsWithSources: Seq[(Url, Set[String])] =
      for {
        ir  <- getIrs(apkPath)
        url <- getUrlsWithSourcesForIr(ir)
      } yield (url, Set(ir.getMethod.toString))
    allUrlsWithSources.foldLeft(Map.empty[Url, Set[String]]) {
      case (prevMap, (url, strings)) =>
        prevMap updated (url, (prevMap getOrElse(url, Set.empty[String])) ++ strings)
    }
  }

  private[this] def getUrlWithSourcesForInstr(
    instr: SSAInvokeInstruction, 
    ssa: StringConcatSsaConversion
  ): (Url, Set[String]) = {
    ???
  }

  private[this] def getUrlsWithSourcesForIr(ir: IR): Seq[Url] = {
    val ssa = new StringConcatSsaConversion(ir)
    val urls = ir.getInstructions collect {
      case instr: SSAInvokeInstruction =>
        for {
          param <- isSbConstructorWithRefParam(instr)
          table = ir.getSymbolTable
          argVn = instr getUse 1
          if table isStringConstant argVn
          string = table getStringValue argVn
          if string matches URL_REGEX
        } yield string
    }
  }
}
