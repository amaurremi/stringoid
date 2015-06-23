package com.ibm.stringoid

import scala.tools.nsc.io.{Path, Directory, File}

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    val playdroneDir: String = "playdrone_apks/"
    val apks = Directory("src/test/resources/" + playdroneDir) walkFilter {
      _.extension == "apk"
    }
    apks foreach {
      file =>
        val name   = file.name
        val url    = Urls(name, playdroneDir)
        write(file, url)
    }
  }

  def write(file: Path, url: Urls): Unit = {
    val outDir = Directory("target/url_comparison")
    outDir.createDirectory()
    File(outDir.toString + "/" + file.stripExtension + ".txt").writeAll(url.stats)
    System.err.println("")
  }
}
