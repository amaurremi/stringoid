package com.ibm.stringoid

import java.nio.file.Path

object Compare {

  /**
   * Retrieve the URLs for an APK file using WALA and using grep.
   */
  def apply(
    a1: AnalysisType,
    a2: AnalysisType,
    apkPath: Path
  ): Compare = {

    val urls1 = a1.retriever.getUrlsWithSources(apkPath)
    val urls2 = a2.retriever.getUrlsWithSources(apkPath)
    new Compare(RetrievedUrls(urls1, a1), RetrievedUrls(urls2, a2))
  }
}

/**
 * Stores the URLs retrieved through WALA and through grep
 */
case class Compare private(a1Urls: RetrievedUrls, a2Urls: RetrievedUrls) {

  private[this] def mkString(urls: UrlWithSources): String =
    urls.foldLeft("") {
      case (prev: String, (wu: Url, ms: Set[String])) =>
        val inMethods = if (ms.isEmpty) "\n" else "\n  in methods:\n" + ms.toList.mkString("    ", "\n    ", "")
        prev + "\n" + wu + inMethods
    }

  override def toString = {
    val name1 = a1Urls.analysisType.name
    val name2 = a2Urls.analysisType.name
    val urls1 = a1Urls.urlWithSources.keySet
    val urls2 = a2Urls.urlWithSources.keySet
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
       |${mkString(a1Urls.urlWithSources)}
       |
       |**** All URLs obtained through $name2 ****
       |${mkString(a2Urls.urlWithSources)}
     """.stripMargin
  }
}
