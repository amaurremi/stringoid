package com.ibm.stringoid.retrieve.grep

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut._
import com.ibm.stringoid.retrieve.UrlRetriever

import scala.collection.breakOut

object GrepUrlRetriever extends UrlRetriever {

  override def apply(apkPath: Path): Json = {
    import scala.sys.process._
    val dexdump  = Seq("dexdump", "-d", apkPath.toString)
    val grep     = Seq("grep", "-iIohE", "\"" + URL_REGEX)
    val cut      = Seq("cut", "-c", "2-")
    val cmd      = dexdump #| grep #| cut
    UrlsWithSources((cmd.lines map {
      l =>
        Url(List(UrlString(l))) -> List.empty[Method]
    })(breakOut)).asJson
  }
}
