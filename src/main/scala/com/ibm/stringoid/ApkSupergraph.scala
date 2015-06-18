package com.ibm.stringoid

import com.typesafe.config.ConfigFactory
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    implicit val config = ConfigFactory.load
    new Urls(new FlexibleCallGraphBuilder().getCallGraph).findUrls foreach {
      println(_)
    }
  }
}
