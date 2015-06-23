package com.ibm.stringoid

import com.ibm.wala.ssa.{IR, SymbolTable}
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
    System.err.println("Retrieving " + apkName + " URLs through WALA...")
    val walaUrls: WalaUrls = retrieveWalaUrls(apkName, apkDir)

    System.err.println("Running grep...")
    val grepUrls = retrieveGrepUrls(apkName, apkDir)

    new Urls(walaUrls, grepUrls.toSet)
  }

  private[this] def getIr(apkName: String, apkDir: String): Seq[IR] = {
    implicit val config = configWithApk(apkName, apkDir)
    val irs = new FlexibleCallGraphBuilder().cg map { _.getIR }
    irs.toSeq
  }

  private[this] def retrieveWalaUrls(
    apkName: String,
    apkDir: String
  ): WalaUrls = (for {
    ir    <- getIr(apkName, apkDir)
    table <- optTable(ir).toSeq
    v     <- 1 to table.getMaxValueNumber
    if table isStringConstant v
    tryUrl = table getStringValue v
    if tryUrl matches urlRegex
  } yield tryUrl -> ir.getMethod.getName.toString)(breakOut)

  private[this] def retrieveGrepUrls(apkName: String, apkDir: String): Set[String] = {
    import scala.sys.process._
    val fileName = apkDir + (if (apkName endsWith ".apk") apkName else apkName + ".apk")
    val dexdump = Seq("dexdump", "-d", "src/test/resources/" + fileName)
    val grep = Seq("grep", "-iIohE", "\"" + urlRegex)
    val cut = Seq("cut", "-c", "2-")
    val cmd = dexdump #| grep #| cut
    cmd.lineStream.toSet
  }

  private[this] def configWithApk(apkName: String, apkDir: String) =
    ConfigFactory.load().withValue(
      "wala.dependencies.apk",
      ConfigValueFactory.fromIterable(Seq("/Users/mrapopo/IBM/stringoid/src/test/resources/" + apkDir + apkName)))

  private[this] def optTable(ir: IR): Option[SymbolTable] =
    Option(ir) flatMap {
      ir =>
        Option(ir.getSymbolTable)
    }
}

/**
 * Stores the URLs retrieved through WALA and through grep
 * @param walaUrls maps URLs retrieved through WALA to names of methods in which the URLs were found
 * @param grepUrls the URLs retrieved through grep search
 */
case class Urls private(walaUrls: WalaUrls, grepUrls: Set[String]) {

  def stats: String =
    "Number of different URLs through WALA: " + walaUrls.size +
      "\nNumber of different URLs through grep: " + grepUrls.size +
      "\nIn WALA but not in grep:\n" + walaNotGrep.mkString("\n") +
      "\nIn grep but not in WALA:\n" + grepNotWala.mkString("\n") +
      "\n\nURLs obtained through WALA:\n" + walaUrls +
      "\n\nURLs obtained through grep:\n" + grepUrls

  def walaNotGrep: WalaUrls = walaUrls filterNot {
      grepUrls contains _._1
  }

  def grepNotWala = grepUrls diff walaUrls.keySet
}

