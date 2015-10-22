package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.IrUrlRetrievers
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ssa._
import com.ibm.wala.util.debug.UnimplementedError

import scala.collection.breakOut

trait FixedPointAppendIrRetrievers extends IrUrlRetrievers with StringFormatSpecifiers {

  final class FixedPointAppendIrRetriever(override val config: AnalysisConfig)
    extends IrUrlRetriever
    with AbstractStringBuilderModule
    with StringAppendModule {

    override def getUrlsWithSources: UrlsWithSources = {
      val TimeResult(irs, walaTime) = TimeResult(getIrs)
      val urlsWithSources: Iterator[(Url, Method)] =
        if (config.irSource == IrSource.InterProc)
          irs flatMap getInterProcConcatUrls
        else for {
          ir     <- irs
          if hasUrls(ir)
          url    <- getConcatUrlsForIr(ir, new DefUse(ir))
        } yield url -> ir.getMethod.toString
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse (url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap, walaTime)
    }

    private[this] def hasUrls(ir: IR): Boolean = {
      val table = ir.getSymbolTable
      1 to table.getMaxValueNumber exists {
        isUrlPrefixVn(_, table)
      }
    }

    private[this] def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
      (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

    private[this] def getInterProcConcatUrls(entryIr: IR): Iterable[(Url, Method)] = {
      ???
    }

    private[this] def getConcatUrlsForIr(ir: IR, defUse: DefUse): Set[Url] =
      asboSolver(ir, defUse) match {
        case Some(solver) =>
          val appendAutomaton = stringAppends(ir, defUse, valueNumberToAsbo(solver))
          val table           = ir.getSymbolTable
          (for {
            vn           <- 1 to table.getMaxValueNumber
            if isUrlPrefixVn(vn, table)
            stringValNum  = StringValNum(vn)
            stringTail   <- (appendAutomaton tails stringValNum).iterator take 100
          } yield Url(parseUrl(ir, defUse, stringValNum +: stringTail)))(breakOut)
        case None =>
          Set.empty[Url]
      }

    private[this] def parseUrl(ir: IR, defUse: DefUse, string: Seq[StringPart]): Vector[UrlPart] =
      (string map {
        case StringValNum(vn)            =>
          getAppendArgumentForVn(ir, defUse, vn)
        case StringCycle                 =>
          UrlWithCycle
        case MissingStringFormatArgument =>
          MissingArgument
        case StringFormatPart(s)         =>
          UrlString(s)
      })(breakOut)

    private[this] def getAppendArgumentForVn(ir: IR, defUse: DefUse, vn: ValueNumber): UrlPart = {
      val table = ir.getSymbolTable
      if (table isConstant vn)
        UrlString((table getConstantValue vn).toString)
      else {
        val typeName =
          try getTypeAbstraction(ir, vn).toString
          catch {
            case _: UnimplementedError =>
              "undefined"
          }
        VariableType(typeName, getSource(ir, defUse, vn))
      }
    }

    private[this] def getSource(ir: IR, defUse: DefUse, vn: ValueNumber): VariableSource =
      if (ir.getSymbolTable.isParameter(vn))
        Parameter
      else
        defUse.getDef(vn) match {
          case fieldAccess: SSAFieldAccessInstruction =>
            FieldAccess(fieldAccess.getDeclaredField.toString)
          case invoke: SSAAbstractInvokeInstruction   =>
            MethodReturn(invoke.getDeclaredTarget.toString)
          case _                                      =>
            UnknownSource
        }
  }

}