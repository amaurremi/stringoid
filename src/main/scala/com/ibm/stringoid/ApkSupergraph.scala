package com.ibm.stringoid

import java.util

import com.ibm.wala.classLoader.IClass
import com.ibm.wala.ipa.callgraph.impl.ExplicitCallGraph
import com.ibm.wala.types.ClassLoaderReference
import com.typesafe.config.ConfigFactory
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder
import scala.collection.JavaConverters._
//import com.ibm.wala.dalvik.test.callgraph.DalvikCallGraphTestBase

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    implicit val config = ConfigFactory.load
    val graph: ExplicitCallGraph = new FlexibleCallGraphBuilder().getCallGraph
    new Urls(graph).findUrls foreach {
      println(_)
    }
  }

}
