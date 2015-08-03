package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrUrlRetrievers
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.wala.analysis.typeInference.TypeInference
import com.ibm.wala.ssa.{IR, SymbolTable}
import com.ibm.wala.util.debug.UnimplementedError

import scala.collection.mutable

trait FixedPointAppendIrRetrievers extends IrUrlRetrievers {

  final class FixedPointAppendIrRetriever(override val config: AnalysisConfig)
    extends IrUrlRetriever
    with AbstractStringBuilderModule
    with StringAppendModule {

    override def apply(apkPath: Path): UrlsWithSources = {
      val urlsWithSources: Seq[(Url, Method)] = for {
        ir <- getIrs(apkPath)
        constants = getConstantUrlStrings(ir) map {
          u =>
            Url(List(UrlString(u)))
        }
        url <- getUrlsForIr(ir) ++ constants
      } yield url -> ir.getMethod.toString
      val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
        case (prevMap, (url, method)) =>
          val prevMethods = prevMap getOrElse(url, Set.empty[Method])
          prevMap updated(url, prevMethods + method)
      }
      val urlWithListSourcesMap = urlWithSourcesMap map {
        case (url, methods: Set[Method]) =>
          url -> methods.toList
      }
      UrlsWithSources(urlWithListSourcesMap)
    }

    private[this] def getUrlsForIr(ir: IR): Set[Url] =
      asboSolver(ir) match {
        case Some(solver) =>
          val valNumToAsbo = valueNumberToAsbo(solver)
          val stringAppends = stringAppendsAtEnd(ir, valNumToAsbo)
          val strings = stringAppends flatMap {
            _.flatten
          }
          strings collect {
            case string if hasUrlPrefix(ir.getSymbolTable, string) =>
              Url(parseUrl(ir, string))
          }
        case None =>
          Set.empty[Url]
      }

    // todo make lazy (avoid flattening of unnecessary data structures)
    private[this] def hasUrlPrefix(table: SymbolTable, string: SingleStringConcatenation): Boolean = {
      def matchesUrlPrefix(vn: ValueNumber) =
        (table isStringConstant vn) && (table getStringValue vn matches URL_PREFIX)
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

    private[this] def parseUrl(ir: IR, string: SingleStringConcatenation): List[UrlPart] = {
      val table = ir.getSymbolTable
      string match {
        case SingleStringList(strings) =>
          // todo tail recursion
          strings.foldLeft(List.empty[UrlPart]) {
            case (prefix, s) =>
              prefix ++ parseUrl(ir, s)
          }
        case SingleAppendArgument(vn) =>
          // todo we could add more URL-part-types and be more precise about the type of value
          if (table isConstant vn)
            List(UrlString((table getConstantValue vn).toString))
          else {
            try {
              val typeInference = typeInferenceMap getOrElseUpdate (ir, TypeInference.make(ir, true))
              val abstraction = typeInference.getType(vn)
              List(VariableType(abstraction.toString))
            } catch {
              case _: UnimplementedError =>
                List(UrlPlaceHolder)
            }
          }
        // todo there is also the case where the append argument is a StringBuilder! This is not handled currently!
        case SingleCycle =>
          List(UrlWithCycle)
      }
    }
  }

}