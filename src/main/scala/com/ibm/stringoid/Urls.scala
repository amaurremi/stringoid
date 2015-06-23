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
      url = Try(new URL(table.getStringValue(v)))
      if url.isSuccess
    } yield url.get.toString)(breakOut)

    // retrieving URL's using grep
    import scala.sys.process._
    // todo avoid absolute paths
    val absolutePath = "/Users/mrapopo/IBM/stringoid/src/test/resources/"
    val dexdump = Seq("dexdump", "-d", absolutePath + apkName + ".apk")
    val grep    = Seq("grep", "-iIohE", "\"https?://[^\" ]+")
    val cut     = Seq("cut", "-c", "2-")
    val cmd = dexdump #| grep #| "sort" #| "uniq" #| cut
    val grepUrls = cmd.lineStream.toList

    def adjustUrls(urls: Seq[String]) = applyParams(urls, nonEmptyCg, distinct)
    new Urls(adjustUrls(cgUrls), adjustUrls(grepUrls))
  }

  private[this] def applyParams(
    urlStrings: Seq[String],
    nonEmpty: Boolean,
    distinct: Boolean
  ): Seq[String] = {
    val maybeDistinct = if (distinct) urlStrings.distinct else urlStrings
    if (nonEmpty) maybeDistinct filter { _.nonEmpty } else maybeDistinct
  }

  private[this] def optTable(node: CGNode): Option[SymbolTable] =
    Option(node.getIR) flatMap {
      ir =>
        Option(ir.getSymbolTable)
    }
}

case class Urls private(cgUrls: Seq[String], grepUrls: Seq[String]) {

  def print(): Unit = {
    println("Number of URLs through WALA: " + cgUrls.size)
    println("Number of URLs through grep: " + grepUrls.size)
    println("URLs obtained through WALA:\n")
    cgUrls foreach println
    println("\nURLs obtained through grep:\n")
    grepUrls foreach println
  }
}

