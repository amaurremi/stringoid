package com.ibm.stringoid

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    val urls = Urls("cgeo.geocaching")
    urls.stats foreach println
  }
}
