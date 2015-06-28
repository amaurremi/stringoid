package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid.util.Util
import com.ibm.wala.ssa.IR
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._

object ChaIrUrlRetriever extends IrUrlRetriever {

   override def getIrs(apkPath: Path): Seq[IR] = {
     implicit val config = configWithApk(apkPath)
     val builder = new FlexibleCallGraphBuilder()
     val irs = for {
       c <- builder.cha.iterator()
       m <- c.getAllMethods
     } yield builder.cache.getIR(m)
     Util.filterOutNulls(irs.toSeq)
   }
 }
