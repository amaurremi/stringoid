package com.ibm.stringoid

import java.net.URL

import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.SymbolTable
import com.typesafe.config.ConfigFactory
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut
import scala.util.Try

object Urls {

  /**
   * Retrieve the URLs for an APK file using WALA and using grep.
   * @param apkName     Name of the APK file
   * @param nonEmptyCg  Should URL prefixes (e.g. "http://") be included in the call-graph retrieval?
   * @param distinct    Should only distinct URLs be returned?
   */
  def apply(
    apkName: String,
    nonEmptyCg: Boolean = true,
    distinct: Boolean = true
  ): Urls = {
    // retrieving URLs through WALA
    implicit val config = ConfigFactory.load(apkName)
    val cgUrls: Seq[String] = (for {
      node  <- new FlexibleCallGraphBuilder().getCallGraph
      table <- optTable(node).toSeq
      v     <- 1 to table.getMaxValueNumber
      if table.isStringConstant(v)
      tryUrl = Try(new URL(table.getStringValue(v)))
      if tryUrl.isSuccess
      url    = tryUrl.get
      if !nonEmptyCg || url.getPath.nonEmpty
    } yield url.toString)(breakOut)

    // retrieving URL's using grep
    import scala.sys.process._
    val dexdump      = Seq("dexdump", "-d", "src/test/resources/" + apkName + ".apk")
    val grep         = Seq("grep", "-iIohE", "\"https?://[^\" ]+")
    val cut          = Seq("cut", "-c", "2-")
    val cmd          = dexdump #| grep #| "sort" #| "uniq" #| cut
    val grepUrls     = cmd.lineStream.toList

    def adjustUrls(urls: Seq[String]) = applyParams(urls, distinct = distinct)
    new Urls(adjustUrls(cgUrls), adjustUrls(grepUrls))
  }

  private[this] def applyParams(
    urlStrings: Seq[String],
    distinct: Boolean
  ): Seq[String] =
    if (distinct) urlStrings.distinct else urlStrings

  private[this] def optTable(node: CGNode): Option[SymbolTable] =
    Option(node.getIR) flatMap {
      ir =>
        Option(ir.getSymbolTable)
    }
}

case class Urls private(cgUrls: Seq[String], grepUrls: Seq[String]) {

  def stats: Seq[String] =
    Seq(
      "Number of URLs through WALA: " + cgUrls.size,
      "Number of URLs through grep: " + grepUrls.size,
      "\nIn WALA but not in grep:\n") ++
    walaNotGrep ++
    Seq("\nIn grep but not in WALA:\n") ++
    grepNotWala ++
    Seq("\nURLs obtained through WALA:\n") ++
    cgUrls ++
    Seq("\nURLs obtained through grep:\n") ++
    grepUrls

  def walaNotGrep = cgUrls diff grepUrls

  def grepNotWala = grepUrls diff cgUrls
}

