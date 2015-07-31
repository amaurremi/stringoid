package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path
import com.ibm.stringoid.UrlRetrievers
import com.ibm.stringoid.util.AnalysisConfig
import com.ibm.wala.classLoader.IClass
import com.ibm.wala.ssa.IR
import com.ibm.wala.types.ClassLoaderReference
import edu.illinois.wala.ipa.callgraph.FlexibleCallGraphBuilder

import scala.collection.JavaConversions._
import scala.collection._

trait IrUrlRetrievers extends UrlRetrievers {

  /**
   * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
   * The trait does not specify how to extract the URLs from an IR.
   */
  trait IrUrlRetriever extends UrlRetriever {

    protected def config: AnalysisConfig

    protected final def getIrsFromBuilder(builder: FlexibleCallGraphBuilder): Seq[IR] = {
      val includeLib = !config.ignoreLibs
      if (config.irFromCg) {
        (builder.cg collect {
          case node if includeLib || isApplicationClass(node.getMethod.getDeclaringClass) =>
            node.getIR
        })(breakOut)
      }
      else {
        val irs = for {
          c <- builder.cha.iterator()
          if includeLib || isApplicationClass(c)
          m <- c.getAllMethods
        } yield builder.cache.getIR(m)
        irs.toSeq
      }
    }

    private[this] def isApplicationClass(c: IClass): Boolean =
      c.getClassLoader.getReference == ClassLoaderReference.Application

    protected final def getIrs(apkPath: Path): Seq[IR] = {
      implicit val config = configWithApk(apkPath)
      val irs = getIrsFromBuilder(new FlexibleCallGraphBuilder)
      irs filter {
        Option(_).isDefined
      }
    }

    def getConstantUrlStrings(ir: IR): Seq[String] = {
      val table = ir.getSymbolTable
      (1 to table.getMaxValueNumber collect {
        case v if (table isStringConstant v) && (table getStringValue v matches URL_REGEX) =>
          table getStringValue v
      })(breakOut)
    }
  }
}