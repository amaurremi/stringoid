package com.ibm.stringoid.retrieve.grep

import java.nio.file.Path

import com.ibm.stringoid.UrlRetrievers

import scala.collection.breakOut

trait GrepUrlRetrievers extends UrlRetrievers {

  object GrepUrlRetriever extends UrlRetriever {

    override def apply(apkPath: Path): UrlsWithSources = {
      import scala.sys.process._
      val dexdump = Seq("dexdump", "-d", apkPath.toString)
      val grep = Seq("grep", "-iIohE", "\"" + UrlRetriever.URL_REGEX)
      val cut = Seq("cut", "-c", "2-")
      val cmd = dexdump #| grep #| cut
      UrlsWithSources((cmd.lines map {
        l =>
          Url(Vector(UrlString(l))) -> Set.empty[Method]
      })(breakOut), 0)
    }
  }

}