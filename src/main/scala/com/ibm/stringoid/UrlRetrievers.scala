package com.ibm.stringoid

import java.nio.file.Path

import com.ibm.stringoid.retrieve.grep.GrepUrlRetriever
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.FixedPointAppendIrRetriever
import com.ibm.stringoid.retrieve.ir.constant.ConstantUrlFromIrRetriever
import com.ibm.stringoid.util.AnalysisConfig
import com.typesafe.config.{Config, ConfigFactory, ConfigValueFactory}

trait UrlRetrievers extends AnalysisTypes {

  import AnalysisType._

  def retriever(at: AnalysisType, config: AnalysisConfig): UrlRetriever = at match {
    case Constants =>
      new ConstantUrlFromIrRetriever(config)
    case Append =>
      new FixedPointAppendIrRetriever(config)
    case Grep =>
      GrepUrlRetriever
  }

  /**
   * An analysis that retrieves the URLs that occur in a program, mapped to the set
   * of enclosing methods in which the URLs occur.
   */
  trait UrlRetriever extends Urls {

    protected val URL_PREFIX = "https?://[^\" ]*"
    protected val URL_REGEX  = "https?://[^\" ]+"

    def apply(apkPath: Path): AnalysisResult

    protected final def configWithApk(apkPath: Path): Config =
      ConfigFactory.load().withValue(
        "wala.dependencies.apk",
        ConfigValueFactory.fromIterable(Seq(apkPath.toString)))
  }

}
