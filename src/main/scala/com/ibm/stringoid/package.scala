package com.ibm

import com.ibm.stringoid.AnalysisType.AnalysisType

package object stringoid {

  type Url = String

  type UrlsWithSources = Map[Url, Set[String]]

  case class RetrievedUrls(urlWithSources: UrlsWithSources, analysisType: AnalysisType)
}
