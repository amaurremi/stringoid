package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.nio.file.Path

import com.ibm.stringoid.retrieve.ir.IrFromBuilderRetriever
import com.ibm.stringoid.retrieve.ir.append.{AppendUrl, ValueNumber}
import com.ibm.wala.ssa.{IR, SymbolTable}

object FixedPointAppendIrRetriever
  extends IrFromBuilderRetriever
  with AppendUrl
  with AbstractStringBuilderModule
  with StringAppendModule {

  override type Url = UrlSeq

  override def apply(apkPath: Path): UrlsWithSources = {
    val urlsWithSources: Seq[(Url, Method)] = for {
      ir  <- getIrs(apkPath)
      url <- getUrlsForIr(ir)
    } yield url -> ir.getMethod.toString
    val urlWithSourcesMap = urlsWithSources.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prevMap, (url, method)) =>
        val prevMethods = prevMap getOrElse (url, Set.empty[Method])
        prevMap updated (url, prevMethods + method)
    }
    UrlsWithSources(urlWithSourcesMap)
  }

  private[this] def getUrlsForIr(ir: IR): Set[Url] = {
    val valNumToAsbo = valueNumberToAsbo(asboSolver(ir))
    val stringAppends: Set[AltStringConcatenation] = stringAppendsAtEndOfMethod(ir, valNumToAsbo)
    val strings: Set[SingleStringConcatenation] = stringAppends flatMap { _.flatten }
    // identifying URLs
    val table = ir.getSymbolTable
    strings collect {
      case string if hasUrlPrefix(table, string) =>
        UrlSeq(parseUrl(table, string))
    }
  }

  // todo make lazy (avoid flattening of unnecessary data structures)
  private[this] def hasUrlPrefix(table: SymbolTable, string: SingleStringConcatenation): Boolean = {
    def matchesUrlPrefix(vn: ValueNumber) =
      (table isConstant vn) && (table getStringValue vn matches URL_PREFIX)
    string match {
      case SingleAppendArgument(vn) =>
        matchesUrlPrefix(vn)
      case SingleStringSeq(s :: _)  =>
        // todo trim empty strings?
        hasUrlPrefix(table, s)
      case _                        =>
        false
    }
  }

  private[this] def parseUrl(table: SymbolTable, string: SingleStringConcatenation): Seq[UrlPart] = {
    string match {
      case SingleStringSeq(strings) =>
        // todo add accumulator to method and do tail recursion
        strings.foldLeft(Seq.empty[UrlPart]) {
          case (prefix, s) =>
            prefix ++ parseUrl(table, s)
        }
      case SingleAppendArgument(vn) =>
        // todo we could add more URL-part-types and be more precise about the type of value
        if (table isConstant vn)
          Seq(UrlString((table getConstantValue vn).toString))
        else
          Seq(UrlPlaceHolder)
      // todo there is also the case where the append argument is a StringBuilder! This is not handled currently!
    }
  }
}
