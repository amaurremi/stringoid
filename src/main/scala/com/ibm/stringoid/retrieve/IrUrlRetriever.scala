package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid._
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait IrUrlRetriever extends UrlRetriever {

  def getIrs(apkPath: Path): Seq[IR]

  def getUrlsWithSources(
    apkPath: Path
  ): UrlWithSources = {
    val urlMethodPairs: Set[(Url, String)] = (for {
      ir    <- getIrs(apkPath)
      table <- Option(ir.getSymbolTable).toSeq
      v     <- 1 to table.getMaxValueNumber
      if table isStringConstant v
      tryUrl = table getStringValue v
      if tryUrl matches URL_REGEX
      m      = ir.getMethod
    } yield tryUrl -> (m.getDeclaringClass.getName + "." + m.getName.toString))(breakOut)
    urlMethodPairs.foldLeft(Map.empty[Url, Set[String]]) {
      case (prev, (wu, m)) =>
        prev.updated(wu, prev.getOrElse(wu, Set.empty[String]) + m)
    }
  }

  /**
   * For debug purposes
   */
  def cgReachableMethodsContaining(string: String, apkPath: Path): Iterable[IMethod] = {
    implicit val config = configWithApk(apkPath)
    new FlexibleCallGraphBuilder().cg collect {
      case n if n.getMethod.toString.contains(string) =>
        n.getMethod
    }
  }
}
