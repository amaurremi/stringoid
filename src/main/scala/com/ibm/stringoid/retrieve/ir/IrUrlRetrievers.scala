package com.ibm.stringoid.retrieve.ir

import java.nio.file.Path

import com.ibm.stringoid.UrlRetrievers
import com.ibm.wala.classLoader.{ClassLoaderFactoryImpl, IClass}
import com.ibm.wala.dalvik.classLoader.{DexFileModule, DexIRFactory}
import com.ibm.wala.ipa.callgraph.AnalysisCache
import com.ibm.wala.ipa.cha.ClassHierarchy
import com.ibm.wala.ssa.{DefaultIRFactory, IR}
import com.ibm.wala.types.ClassLoaderReference
import edu.illinois.wala.ipa.callgraph.{AnalysisScope, Dependency, FlexibleCallGraphBuilder}

import scala.collection.JavaConversions._
import scala.collection._

trait IrUrlRetrievers extends UrlRetrievers {

  /**
   * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
   * The trait does not specify how to extract the URLs from an IR.
   */
  trait IrUrlRetriever extends UrlRetriever {

    protected def config: AnalysisConfig

    private[this] def isApplicationClass(c: IClass): Boolean =
      c.getClassLoader.getReference == ClassLoaderReference.Application

    protected final def getIrs(apkPath: Path): Iterator[IR] = { // todo some immutable stream collection?
      implicit val analysisConfig = configWithApk(apkPath)
      val includeLib = !config.ignoreLibs
      val irs = if (config.irFromCg) {
        new FlexibleCallGraphBuilder().cg.iterator collect {
          case node if includeLib || isApplicationClass(node.getMethod.getDeclaringClass) =>
            node.getIR
        }
      }
      else {
        val scope = AnalysisScope(Seq.empty[Dependency])
        val cha = getCha(scope)
        val irFactory = getIrFactory(scope)
        val cache = new AnalysisCache(irFactory)
        for {
          c <- cha.iterator()
          if includeLib || isApplicationClass(c)
          m <- c.getAllMethods
        } yield cache getIR m
      }
      irs filter {
        Option(_).isDefined
      }
    }

    private[this] def getIrFactory(scope: AnalysisScope) =
      if (scope getModules ClassLoaderReference.Application exists {
        case _: DexFileModule => true
        case _                => false
      }) new DexIRFactory() else new DefaultIRFactory()

    private[this] def getCha(implicit scope: AnalysisScope): ClassHierarchy = {
      val includeLib = !config.ignoreLibs
      val classLoaderImpl = new ClassLoaderFactoryImpl(scope.getExclusions)
      ClassHierarchy.make(scope, classLoaderImpl)
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