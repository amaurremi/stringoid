package com.ibm.stringoid

import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa.SymbolTable
import com.typesafe.config.{ConfigFactory, ConfigValueFactory}
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection.breakOut

object Urls {

  val urlRegex = "https?://[^\" ]+"

  /**
   * Retrieve the URLs for an APK file using WALA and using grep.
   */
  def apply(
    apkName: String,
    apkDir: String = ""
  ): Urls = {
    System.err.println("Constructing " + apkName + " callgraph...")
    val cgUrls: Seq[String] = retrieveCgUrls(apkName, apkDir)

    System.err.println("Running grep...")
    val grepUrls = retrieveGrepUrls(apkName, apkDir)

    def adjustUrls(urls: Seq[String]) = urls.distinct.sorted
    new Urls(adjustUrls(cgUrls), adjustUrls(grepUrls))
  }

  private[this] def getCallGraph(apkName: String, apkDir: String) = {
    implicit val config = configWithApk(apkName, apkDir)
    val cg = new FlexibleCallGraphBuilder().getCallGraph
    System.err.println("Retrieving URLs from callgraph...")
    cg
  }

  private[this] def retrieveCgUrls(
    apkName: String,
    apkDir: String
  ): Seq[String] = (for {
    node  <- getCallGraph(apkName, apkDir)
    table <- optTable(node).toSeq
    v     <- 1 to table.getMaxValueNumber
    if table.isStringConstant(v)
    tryUrl = table getStringValue v
    if tryUrl matches urlRegex
  } yield tryUrl)(breakOut)

  private[this] def retrieveGrepUrls(apkName: String, apkDir: String) = {
    import scala.sys.process._
    val fileName = apkDir + (if (apkName endsWith ".apk") apkName else apkName + ".apk")
    val dexdump  = Seq("dexdump", "-d", "src/test/resources/" + fileName)
    val grep     = Seq("grep", "-iIohE", "\"" + urlRegex)
    val cut      = Seq("cut", "-c", "2-")
    val cmd      = dexdump #| grep #| cut
    cmd.lineStream.toList
  }

  private[this] def configWithApk(apkName: String, apkDir: String) =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq("/Users/mrapopo/IBM/stringoid/src/test/resources/" + apkDir + apkName)))

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

