package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path

import com.ibm.stringoid._

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
    val urlMethodPairs: Set[(Url, Method)] = (for {
      ir    <- getIrs(apkPath)
      table <- Option(ir.getSymbolTable).toSeq
      v     <- 1 to table.getMaxValueNumber
      if table isStringConstant v
      tryUrl = table getStringValue v
      if tryUrl matches URL_REGEX
      m      = ir.getMethod
    } yield tryUrl -> (m.getDeclaringClass.getName + "." + m.getName.toString))(breakOut)
    UrlsWithSources(urlMethodPairs.foldLeft(Map.empty[Url, Set[Method]]) {
      case (prev, (wu, m)) =>
        prev.updated(wu, prev.getOrElse(wu, Set.empty[Method]) + m)
    })
  }
}
