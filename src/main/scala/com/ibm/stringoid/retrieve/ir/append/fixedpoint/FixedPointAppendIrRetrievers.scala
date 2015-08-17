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
        ir       <- getIrs(apkPath)
        defUse    = new DefUse(ir)
        url      <- getAllUrls(ir, defUse)
      } yield url -> ir.getMethod.toString
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse (url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap)
    }

    private[this] def getAllUrls(ir: IR, defUse: DefUse): Set[Url] = {  // todo merge appends with formatted
      val constants = getConstantUrlStrings(ir)
      if (constants.isEmpty)
        Set.empty[Url]
      else {
        val constantUrls = constants map {
          c =>
            Url(Vector(UrlString(c)))
        }
        val formatted = getFormattedUrlStrings(ir, defUse)
        val appends   = getConcatUrlsForIr(ir, defUse)
        constantUrls ++ formatted ++ appends
      }
    }

    def getFormattedUrlStrings(ir: IR, defUse: DefUse): Set[Url] =
      if (config.stringFormat) {
        (ir.getInstructions flatMap {
          case instr: SSAInvokeInstruction =>
            getUrlFromStringFormat(instr, ir.getSymbolTable) map {
              case (urlPrefix, hasLocale) =>
                val (formattedParts, specifierNum) = parse(urlPrefix)
                val offset                         = if (hasLocale) 1 else 0
                val missingArguments               = specifierNum >= instr.getNumberOfUses - offset
                val urlParts                       =
                  formattedParts.foldLeft(Vector.empty[UrlPart]) {
                    case (parts, FormattedStringPart(string)) =>
                      parts :+ UrlString(string)
                    case (parts, Specifier(count))           =>
                      val newVariable =
                        if (missingArguments) MissingArgument
                        else getAppendArgumentForVn(ir, defUse, instr getUse (count + offset))
                      parts :+ newVariable
                  }
                Url(urlParts)
            }
          case _ =>
            None
        })(breakOut)
      } else Set.empty[Url]

    /**
     * If instr is a String.format call that builds a URL, returns the prefix of that URL and
     * a boolean flag indicating whether the first argument to String.format is a Locale.
     */
    private[this] def getUrlFromStringFormat(instr: SSAInvokeInstruction, table: SymbolTable): Option[(String, Boolean)] =
      if (instr.getNumberOfUses > 0) {
        val stringFormatPrefix = "Ljava/lang/String, format("
        val targetSig = instr.getDeclaredTarget.toString
        val locale = targetSig contains "Locale"
        if (targetSig contains stringFormatPrefix) {
          val firstArg = if (locale) instr getUse 1 else instr getUse 0
          if ((table isStringConstant firstArg)
            && isUrlPrefix(table getStringValue firstArg))
            Some((table getStringValue firstArg, locale))
          else None
        } else None
      } else None

    private[this] def isUrlPrefixVn(vn: ValueNumber, table: SymbolTable): Boolean =
      (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)

    private[this] def getConcatUrlsForIr(ir: IR, defUse: DefUse): Set[Url] =
      asboSolver(ir, defUse) match {
        case Some(solver) =>
          val valNumToAsbo    = valueNumberToAsbo(solver)
          val appendAutomaton = stringAppends(ir, valNumToAsbo)
          val table           = ir.getSymbolTable
          (for {
            vn           <- 1 to table.getMaxValueNumber
            if isUrlPrefixVn(vn, table)
            stringValNum  = StringValNum(vn)
            stringTail   <- (appendAutomaton tails stringValNum).iterator
          } yield Url(parseUrl(ir, defUse, stringValNum +: stringTail)))(breakOut)
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