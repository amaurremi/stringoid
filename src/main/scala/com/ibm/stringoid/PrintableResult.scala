package com.ibm.stringoid

import java.nio.file.Path

import com.ibm.stringoid.AnalysisType._
import com.ibm.stringoid.retrieve.{StringMap, UrlRetriever}

object PrintableResult {

  /**
   * Retrieve the URLs for an APK file using WALA and using grep.
   */
  def apply(
    a1: AnalysisType,
    a2: AnalysisType,
    apkPath: Path
  ): PrintableResult = {

    val urls1 = retriever(a1)(apkPath).printable
    val urls2 = retriever(a2)(apkPath).printable
    new PrintableResult(urls1, a1, urls2, a2)
  }
}

case class PrintableResult(a1Urls: StringMap, a1: AnalysisType, a2Urls: StringMap, a2: AnalysisType) {

  private[this] def mkString(urls: StringMap): String =
    urls.foldLeft("") {
      case (prev: String, (us: String, ms: Set[String])) =>
        val inMethods = if (ms.isEmpty) "\n" else "\n  in methods:\n" + ms.toList.mkString("    ", "\n    ", "")
        prev + "\n" + us + inMethods
    }

  override def toString = {
    val name1 = a1.toString
    val name2 = a2.toString
    val urls1 = a1Urls.keySet
    val urls2 = a2Urls.keySet
    s"""Number of different URLs through $name1: ${urls1.size}
        |Number of different URLs through $name2: ${urls2.size}
        |
        |**** In $name1 but not in $name2 ****
                                           |${(urls1 diff urls2) mkString "\n"}
        |
        |**** In $name2 but not in $name1 ****
                                           |${(urls2 diff urls1) mkString "\n"}
        |
        |**** All URLs obtained through $name1 ****
                                                |${mkString(a1Urls)}
        |
        |**** All URLs obtained through $name2 ****
                                                |${mkString(a2Urls)}
       """.stripMargin
  }
}