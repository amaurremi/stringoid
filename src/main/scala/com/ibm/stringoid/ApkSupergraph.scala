package com.ibm.stringoid

import com.ibm.wala.ipa.callgraph.AnalysisScope
import com.typesafe.config.ConfigFactory
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder
import com.ibm.wala.

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    implicit val config = ConfigFactory.load

    val scope: AnalysisScope = makeDalvikScope(androidLibs, androidAPIJar, dexFileName)

    val pa = new FlexibleCallGraphBuilder()
  }
}
