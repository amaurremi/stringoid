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
        ir <- getIrs(apkPath)
        formatted = getFormattedUrlStrings(ir)
        constants = getConstantUrlStrings(ir) map {
          constantUrl =>
            Url(Vector(UrlString(constantUrl)))
        }
        appends   = getConcatUrlsForIr(ir)
        url <- appends ++ constants ++ formatted // todo merge appends with formatted
      } yield url -> ir.getMethod.toString
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      UrlsWithSources(urlWithSourcesMap)
    }

    def getFormattedUrlStrings(ir: IR): Set[Url] = {
      (ir.getInstructions flatMap {
        case instr: SSAInvokeInstruction =>
          getUrlFromStringFormat(instr, ir.getSymbolTable) map {
            urlPrefix =>
              val (formattedParts, specifierNum) = parse(urlPrefix, instr)
              val missingArguments               = specifierNum >= instr.getNumberOfUses
              val urlParts = formattedParts.foldLeft(Vector.empty[UrlPart]) {
                case (parts, FormattedStringPart(string)) =>
                  parts :+ UrlString(string)
                case (parts, Specifier(argNum))           =>
                  val newVariable =
                    if (missingArguments) MissingArgument
                    else getAppendArgumentForVn(ir, instr getUse argNum)
                  parts :+ newVariable
              }
              Url(urlParts)
          }
        case _                           =>
          None
      })(breakOut)
    }

    private[this] def getUrlFromStringFormat(instr: SSAInvokeInstruction, table: SymbolTable): Option[String] =
      if (instr.getNumberOfUses > 0) {
        val stringFormatSig = "Ljava/lang/String, format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String"
        val firstArg = instr getUse 0 // todo getUse 0 or 1?
        if ((instr.getDeclaredTarget.toString contains stringFormatSig)
          && (table isStringConstant firstArg)
          && isUrlPrefix(table getStringValue firstArg))
          Some(table getStringValue firstArg)
        else None
      } else None

    private[this] def getConcatUrlsForIr(ir: IR): Set[Url] =
      asboSolver(ir) match {
        case Some(solver) =>
          val valNumToAsbo = valueNumberToAsbo(solver)
          val appends      = stringAppends(ir, valNumToAsbo)
          val urlAppends   = appends flatMap {
            altStringConcatenation =>
              getUrlSingleStringConcatenations(altStringConcatenation, ir)
          }
          urlAppends map {
            string =>
              Url(parseUrl(ir, string))
          }
        case None =>
          Set.empty[Url]
      }

    private[this] def getUrlSingleStringConcatenations(
      string: AltStringConcatenation,
      ir: IR
    ): Set[SingleStringConcatenation] = {
      string match {
        case AltStringAlternatives(strings) =>
          strings flatMap {
            getUrlSingleStringConcatenations(_, ir)
          }
        case AltStringSeq(head :: tail) =>
          val headSingleStrings = getUrlSingleStringConcatenations(head, ir)
          val withTail = for {
            concat  <- headSingleStrings
            flatEnd <- AltStringSeq(tail).flatten
          } yield concat ++ flatEnd
          if (withTail.nonEmpty)
            withTail
          else
            headSingleStrings
        case AltStringSeq(Seq()) =>
          Set.empty[SingleStringConcatenation]
        case AltAppendArgument(vn) =>
          val singleArg = SingleAppendArgument(vn)
          if (hasUrlPrefix(ir.getSymbolTable, singleArg))
            Set(singleArg)
          else
            Set.empty[SingleStringConcatenation]
        case AltCycle =>
          Set.empty[SingleStringConcatenation]
      }
    }

    // todo make lazy (avoid flattening of unnecessary data structures)
    private[this] def hasUrlPrefix(table: SymbolTable, string: SingleStringConcatenation): Boolean = {
      def matchesUrlPrefix(vn: ValueNumber) =
        (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
      string match {
        case SingleAppendArgument(vn) =>
          matchesUrlPrefix(vn)
        case SingleStringList(s :: _) =>
          // todo trim empty strings?
          hasUrlPrefix(table, s)
        case _ =>
          false
      }
    }

    private[this] val typeInferenceMap = mutable.Map.empty[IR, TypeInference]

    private[this] def parseUrl(ir: IR, string: SingleStringConcatenation): Vector[UrlPart] = {
      val table = ir.getSymbolTable
      string match {
        case SingleStringList(strings) =>
          // todo tail recursion
          strings.foldLeft(Vector.empty[UrlPart]) {
            case (prefix, s) =>
              prefix ++ parseUrl(ir, s)
          }
        case SingleAppendArgument(vn) =>
          // todo we could add more URL-part-types and be more precise about the type of value
          Vector(getAppendArgumentForVn(ir, vn))
        // todo there is also the case where the append argument is a StringBuilder! This is not handled currently!
        case SingleCycle =>
          Vector(UrlWithCycle)
      }
    }

    private[this] def getAppendArgumentForVn(ir: IR, vn: ValueNumber): UrlPart = {
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
        VariableType(typeName, getSource(ir, vn))
      }
    }

    private[this] def getSource(ir: IR, vn: ValueNumber): VariableSource =
      if (ir.getSymbolTable.isParameter(vn))
        Parameter
      else
        new DefUse(ir).getDef(vn) match {
          case fieldAccess: SSAFieldAccessInstruction =>
            FieldAccess
          case invoke: SSAInvokeInstruction           =>
            MethodReturn(invoke.getDeclaredTarget.toString)
          case _                                      =>
            UnknownSource
        }
  }

}