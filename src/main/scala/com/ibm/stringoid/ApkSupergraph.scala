package com.ibm.stringoid

object ApkSupergraph {

  def main(args: Array[String]): Unit = {
    val urls = Urls("cgeo.geocaching", distinct = true)
    urls.print()
  }

}
