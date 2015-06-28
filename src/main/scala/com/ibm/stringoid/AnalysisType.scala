package com.ibm.stringoid

import com.ibm.stringoid.retrieve.{CgIrUrlRetriever, ChaIrUrlRetriever, GrepUrlRetriever, UrlRetriever}

sealed abstract class AnalysisType(val retriever: UrlRetriever, val name: String)
case object CgIrAnalysis extends AnalysisType(CgIrUrlRetriever, "CG_IR")
case object ChaIrAnalysis extends AnalysisType(ChaIrUrlRetriever, "CHA_IR")
case object GrepAnalysis extends AnalysisType(GrepUrlRetriever, "GREP")
