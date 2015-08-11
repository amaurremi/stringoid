package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetrievers
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.wala.analysis.typeInference.TypeInference
import com.ibm.wala.ssa._
import com.ibm.wala.util.debug.UnimplementedError

import scala.collection.{breakOut, mutable}

trait FixedPointAppendIrRetrievers extends IrUrlRetrievers with StringFormatSpecifiers {

  final class FixedPointAppendIrRetriever(override val config: AnalysisConfig)
    extends IrUrlRetriever
    with AbstractStringBuilderModule
    with StringAppendModule {

    override def apply(apkPath: Path): UrlsWithSources = {
      val urlsWithSources: Iterator[(Url, Method)] = for {
        ir        <- getIrs(apkPath)
        defUse     = new DefUse(ir)
        formatted  = getFormattedUrlStrings(ir, defUse)
        constants  = getConstantUrlStrings(ir) map {
          constantUrl =>
            Url(Vector(UrlString(constantUrl)))
        }
        appends    = getConcatUrlsForIr(ir, defUse)
        url       <- appends ++ constants ++ formatted // todo merge appends with formatted
      } yield url -> ir.getMethod.toString
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap)
    }

    def getFormattedUrlStrings(ir: IR, defUse: DefUse): Set[Url] =
      if (config.stringFormat) {
        (ir.getInstructions flatMap {
          case instr: SSAInvokeInstruction =>
            getUrlFromStringFormat(instr, ir.getSymbolTable) map {
              urlPrefix =>
                val (formattedParts, specifierNum) = parse(urlPrefix, instr)
                val missingArguments = specifierNum >= instr.getNumberOfUses
                val urlParts = formattedParts.foldLeft(Vector.empty[UrlPart]) {
                  case (parts, FormattedStringPart(string)) =>
                    parts :+ UrlString(string)
                  case (parts, Specifier(argNum)) =>
                    val newVariable =
                      if (missingArguments) MissingArgument
                      else getAppendArgumentForVn(ir, defUse, instr getUse argNum)
                    parts :+ newVariable
                }
                Url(urlParts)
            }
          case _ =>
            None
        })(breakOut)
      } else Set.empty[Url]

    private[this] def getUrlFromStringFormat(instr: SSAInvokeInstruction, table: SymbolTable): Option[String] =
      if (instr.getNumberOfUses > 0) {
        val stringFormatSig = "Ljava/lang/String, format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String"
        val firstArg = instr getUse 0
        if ((instr.getDeclaredTarget.toString contains stringFormatSig)
          && (table isStringConstant firstArg)
          && isUrlPrefix(table getStringValue firstArg))
          Some(table getStringValue firstArg)
        else None
      } else None

    private[this] def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
      (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

    private[this] def getConcatUrlsForIr(ir: IR, defUse: DefUse): Set[Url] =
      asboSolver(ir, defUse) match {
        case Some(solver) =>
          val valNumToAsbo = valueNumberToAsbo(solver)
          val appendTrie   = stringAppends(ir, valNumToAsbo)
          val table = ir.getSymbolTable
          val urlValNums = 1 to table.getMaxValueNumber filter {
            isUrlPrefixVn(_, table)
          }
          val urlStringSeqs = urlValNums flatMap {
            vn =>
              (appendTrie postfixes StringValNum(vn)).iterator
          }
          (urlStringSeqs map {
            stringSeq =>
              Url(parseUrl(ir, defUse, stringSeq))
          })(breakOut)
        case None =>
          Set.empty[Url]
      }

    private[this] val typeInferenceMap = mutable.Map.empty[IR, TypeInference]

    private[this] def parseUrl(ir: IR, defUse: DefUse, string: Seq[StringPart]): Vector[UrlPart] = {
      val table = ir.getSymbolTable
      (string map {
        case StringValNum(vn) =>
          getAppendArgumentForVn(ir, defUse, vn)
        case StringCycle =>
          UrlWithCycle
      })(breakOut)
    }

    private[this] def getAppendArgumentForVn(ir: IR, defUse: DefUse, vn: ValueNumber): UrlPart = {
      val table = ir.getSymbolTable
      if (table isConstant vn)
        UrlString((table getConstantValue vn).toString)
      else {
        val typeName = try {
          val typeInference = typeInferenceMap getOrElseUpdate(ir, TypeInference.make(ir, true))
          val abstraction = typeInference.getType(vn)
          abstraction.toString
        } catch {
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
          case invoke: SSAInvokeInstruction           =>
            MethodReturn(invoke.getDeclaredTarget.toString)
          case _                                      =>
            UnknownSource
        }
  }

}