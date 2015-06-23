package com.ibm.stringoid

import scala.reflect.io.Path
import scala.tools.nsc.io.{File, Directory}

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    val apks = Directory("src/test/resources/playdrone_apks") walkFilter {
      _.extension == "apk"
    }
    apks foreach {
      file =>
        val name  = file.name
        val url   = Urls(name)
        File("target/url_comparison/" + name).writeAll(url.stats: _*)
    }
  }
}
