package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path

import com.ibm.stringoid._
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.{SymbolTable, IR}

import scala.collection.breakOut

/**
 * An analysis that is based on extracting the URL strings that appear as
 * constants in an IR's symbol table.
 */
trait ConstantUrlsFromIrRetriever extends IrUrlRetriever {

  override type Url = String

  final override def apply(
    apkPath: Path
  ): UrlsWithSources = {
    val urlMethodPairs = getIrs(apkPath) flatMap getUrlMethodPairsFromIr
    UrlsWithSources(urlMethodPairs.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prev, (wu, m)) =>
        prev.updated(wu, prev.getOrElse(wu, Set.empty[Method]) + m)
    })
  }

  def getUrlMethodPairsFromIr(ir: IR): Set[(Url, Method)] = {
    val table = ir.getSymbolTable
    (1 to table.getMaxValueNumber collect {
      case v if (table isStringConstant v) && (table getStringValue v matches URL_REGEX) =>
        val method = ir.getMethod
        (table getStringValue v) -> (method.getDeclaringClass.getName + "." + method.getName.toString)
    })(breakOut)
  }
}
