package com.ibm.stringoid.retrieve

import java.nio.file.Path

import scala.collection.breakOut

object GrepUrlRetriever extends UrlRetriever {

  override type Url = String

  override def apply(apkPath: Path): UrlsWithSources = {
    import scala.sys.process._
    val dexdump  = Seq("dexdump", "-d", apkPath.toString)
    val grep     = Seq("grep", "-iIohE", "\"" + URL_REGEX)
    val cut      = Seq("cut", "-c", "2-")
    val cmd      = dexdump #| grep #| cut
    UrlsWithSources((cmd.lines map {
      _ -> Set.empty[String]
    })(breakOut))
  }
}
