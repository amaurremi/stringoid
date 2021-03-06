package com.ibm.stringoid.retrieve.grep

import java.nio.file.Path

import argonaut.Argonaut._
import argonaut.Json
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.{UrlCheck, UrlRetriever}

import scala.collection.breakOut

final class GrepUrlRetriever(apkPath: Path) extends UrlRetriever {

  override def getUrlsWithSources: UrlsWithSources = {
    import scala.sys.process._
    val dexdump = Seq("dexdump", "-d", apkPath.toString)
    val grep = Seq("grep", "-iIohE", "\"" + UrlCheck.URL_REGEX)
    val cut = Seq("cut", "-c", "2-")
    val cmd = dexdump #| grep #| cut
    UrlsWithSources((cmd.lines map {
      l =>
        Url(Vector(UrlString(l))) -> Set.empty[Method]
    })(breakOut), 0)
  }

  override def getResult: Json = getUrlsWithSources.asJson
}