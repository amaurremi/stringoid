package com.ibm.stringoid

import com.ibm.stringoid.util.Time.time
import com.ibm.stringoid.util.Util
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.ipa.callgraph.CallGraph
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
    apkDir: String = "",
    useCallGraph: Boolean
  ): Urls = {

//    val x = cgReachableMethodsContaining("getDispatchedView", apkName, apkDir)

    val apkNameNoExt = if (apkName endsWith ".apk") apkName drop 4 else apkName
    val cgUsage = if (useCallGraph) "using CG" else "using CHA"
    val walaUrls: WalaUrls = time("Retrieving " + apkName + " URLs through WALA " + cgUsage) {
      retrieveWalaUrls(apkName, apkDir, useCallGraph)
    }

    val grepUrls = time("and through grep") {
      retrieveGrepUrls(apkName, apkDir)
    }

    new Urls(walaUrls, grepUrls.toSet)
  }

  /**
   * For debug purposes
   */
  private[this] def cgReachableMethodsContaining(string: String, apkName: String, apkDir: String): Iterable[IMethod] = {
    implicit val config = configWithApk(apkName, apkDir)
    new FlexibleCallGraphBuilder().cg collect {
      case n if n.getMethod.toString.contains(string) =>
        n.getMethod
    }
  }

  private[this] def getIrs(apkName: String, apkDir: String): Seq[IR] = {
    implicit val config = configWithApk(apkName, apkDir)
    val cg: CallGraph = new FlexibleCallGraphBuilder().cg
    scala.tools.nsc.io.File("target/cg.txt").writeAll(cg.mkString("\n"))
    val irs = cg map { _.getIR }
    Util.filterOutNulls(irs.toSeq)
  }

  private[this] def getIrsWithoutCallGraph(apkName: String, apkDir: String): Seq[IR] = {
    implicit val config = configWithApk(apkName, apkDir)
    val builder = new FlexibleCallGraphBuilder()
    val irs = for {
      c <- builder.cha.iterator()
      m <- c.getAllMethods
    } yield builder.cache.getIR(m)
    Util.filterOutNulls(irs.toSeq)
  }

  private[this] def retrieveWalaUrls(
    apkName: String,
    apkDir: String,
    useCallGraph: Boolean
  ): WalaUrls = {
    val urlMethodPairs: Set[(WalaUrl, String)] = (for {
      ir    <- if (useCallGraph) getIrs(apkName, apkDir) else getIrsWithoutCallGraph(apkName, apkDir)
      table <- optTable(ir).toSeq
      v     <- 1 to table.getMaxValueNumber
      if table isStringConstant v
      tryUrl = table getStringValue v
      if tryUrl matches urlRegex
      m      = ir.getMethod
    } yield tryUrl -> (m.getDeclaringClass.getName + "." + m.getName.toString))(breakOut)
    urlMethodPairs.foldLeft(Map.empty[WalaUrl, Set[String]]) {
      case (prev, (wu, m)) =>
        prev.updated(wu, prev.getOrElse(wu, Set.empty[String]) + m)
    }
  }

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

  private[this] def mkString(list: Iterable[(WalaUrl, Set[String])]): String =
    list.foldLeft("") {
      case (prev: String, (wu: WalaUrl, ms: Set[String])) =>
        prev + "\n" + wu + "\n  in methods:\n" + ms.toList.mkString("    ", "\n    ", "")
    }

  def stats: String =
    "Number of different URLs through WALA: " + walaUrls.size +
      "\nNumber of different URLs through grep: " + grepUrls.size +
      "\n\nIn WALA but not in grep:\n" + mkString(walaNotGrep.toList) +
      "\n\nIn grep but not in WALA:\n" + grepNotWala.toList.sorted.mkString("\n") +
      "\n\nURLs obtained through WALA:\n" + mkString(walaUrls) +
      "\n\nURLs obtained through grep:\n" + grepUrls.mkString("\n")

  def walaNotGrep: WalaUrls = walaUrls filterNot {
      grepUrls contains _._1
  }

  def grepNotWala = grepUrls diff walaUrls.keySet
}

