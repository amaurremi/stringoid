package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.IrSourceObject.IrSource
import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlCheck.isUrlPrefix
import com.ibm.stringoid.retrieve.ir.IrUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ssa._
import com.ibm.wala.util.debug.UnimplementedError

import scala.collection.breakOut

abstract class FixedPointAppendIrRetriever(
  override val config: AnalysisConfig
)
  extends IrUrlRetriever
  with StringAppendModule {

  override def getUrlsWithSources: UrlsWithSources = {
    val TimeResult(nodes, walaTime) = TimeResult(getNodes)
    val urlsWithSources: Iterator[(Url, Method)] =
      if (config.irSource == IrSource.InterProc)
        nodes flatMap getInterProcConcatUrls
      else for {
        node <- nodes
        if hasUrls(node)
        url <- getConcatUrlsForNode(node)
      } yield url -> node.getIr.getMethod.toString
    val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, method)) =>
        val prevMethods = prevMap getOrElse (url, Set.empty[Method])
        prevMap updated(url, prevMethods + method)
    }
    UrlsWithSources(urlWithSourcesMap, walaTime)
  }

  def hasUrls(node: Node): Boolean = {
    val table = node.getIr.getSymbolTable
    1 to table.getMaxValueNumber exists {
      isUrlPrefixVn(_, table)
    }
  }

  private[this] def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
    (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

  private[this] def getInterProcConcatUrls(entryNode: Node): Iterable[(Url, Method)] = {
    ???
  }

  private[this] def getConcatUrlsForNode(node: Node): Set[Url] = {
    val appendAutomaton = stringAppends(node)
    val table           = node.getIr.getSymbolTable // todo won't work for inter-proc stuff
    (for {
      vn           <- 1 to table.getMaxValueNumber
      if isUrlPrefixVn(vn, table)
      stringValNum  = StringValNum(vn)
      stringTail   <- (appendAutomaton tails stringValNum).iterator take 100
    } yield Url(parseUrl(node, stringValNum +: stringTail)))(breakOut)
  }

  private[this] def parseUrl(node: Node, string: Seq[StringPart]): Vector[UrlPart] =
    (string map {
      case StringValNum(vn)            =>
        getAppendArgumentForVn(node, vn)
      case StringCycle                 =>
        UrlWithCycle
      case MissingStringFormatArgument =>
        MissingArgument
      case StringFormatPart(s)         =>
        UrlString(s)
    })(breakOut)

  private[this] def getAppendArgumentForVn(node: Node, vn: ValueNumber): UrlPart = {
    val ir = node.getIr
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
      VariableType(typeName, getSource(node, vn))
    }
  }

  private[this] def getSource(node: Node, vn: ValueNumber): VariableSource =
    if (node.getIr.getSymbolTable.isParameter(vn))
      Parameter
    else
      node.getDu.getDef(vn) match {
        case fieldAccess: SSAFieldAccessInstruction =>
          FieldAccess(fieldAccess.getDeclaredField.toString)
        case invoke: SSAAbstractInvokeInstruction   =>
          MethodReturn(invoke.getDeclaredTarget.toString)
        case _                                      =>
          UnknownSource
      }
}
