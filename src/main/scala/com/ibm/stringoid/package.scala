package com.ibm

import com.ibm.stringoid.AnalysisType.AnalysisType

package object stringoid {

  type GrepUrl = String
  type Url = String

  type UrlWithSources = Map[Url, Set[String]]

  case class RetrievedUrls(urlWithSources: UrlWithSources, analysisType: AnalysisType)
}
