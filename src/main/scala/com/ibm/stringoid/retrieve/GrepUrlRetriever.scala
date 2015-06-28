package com.ibm.stringoid.retrieve

import java.nio.file.Path

import com.ibm.stringoid.UrlWithSources

import scala.collection.breakOut

object GrepUrlRetriever extends UrlRetriever {

  override def getUrlsWithSources(apkPath: Path): UrlWithSources = {
    import scala.sys.process._
    val fileName = apkPath.getFileName.toString
    val dexdump  = Seq("dexdump", "-d", TEST_RESOURCES + fileName)
    val grep     = Seq("grep", "-iIohE", "\"" + URL_REGEX)
    val cut      = Seq("cut", "-c", "2-")
    val cmd      = dexdump #| grep #| cut
    (cmd.lines map {
      _ -> Set.empty[String]
    })(breakOut)
  }
}
