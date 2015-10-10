package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.UrlRetrievers
import com.ibm.wala.cast.ir.ssa.AstIRFactory.AstDefaultIRFactory
import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.classLoader.{ClassLoaderFactoryImpl, IClass, IMethod, SourceDirectoryTreeModule}
import com.ibm.wala.dalvik.classLoader.{DexFileModule, DexIRFactory}
import com.ibm.wala.ipa.callgraph.AnalysisCache
import com.ibm.wala.ipa.cha.ClassHierarchy
import com.ibm.wala.ssa.{DefaultIRFactory, IR, IRFactory}
import com.ibm.wala.types.ClassLoaderReference
import edu.illinois.wala.ipa.callgraph.{AnalysisScope, Dependency, FlexibleCallGraphBuilder}

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

trait IrUrlRetrievers extends UrlRetrievers {

  /**
   * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
   * The trait does not specify how to extract the URLs from an IR.
   */
  trait IrUrlRetriever extends UrlRetriever {

    protected def config: AnalysisConfig

    private[this] def isApplicationClass(c: IClass): Boolean =
      Set(ClassLoaderReference.Application, JavaSourceAnalysisScope.SOURCE) contains c.getClassLoader.getReference

    final def getIrs: Iterator[IR] = {
      val file = config.file
      val isApk = file.toString.toLowerCase endsWith ".apk"
      implicit val analysisConfig =
        if (isApk) configWithApk(file)
        else configWithSrc(file)
      val includeLib = !config.ignoreLibs
      val processed = mutable.Set.empty[IR]
      if (config.irFromCg) {
        new FlexibleCallGraphBuilder().cg.iterator flatMap {
          case node if includeLib || isApplicationClass(node.getMethod.getDeclaringClass) =>
            val ir = node.getIR
            if (processed contains ir)
              None
            else {
              processed += ir
              Some(ir)
            }
          case _ =>
            None
        }
      } else {
        val scope = AnalysisScope(Seq.empty[Dependency])
        val cha = getCha(scope)
        val irFactory: IRFactory[IMethod] = if (isApk) getDexIrFactory(scope) else getJavaIrFactory(scope)
        val cache = new AnalysisCache(irFactory)
        for {
          c <- cha.iterator()
          if includeLib || isApplicationClass(c)
          m <- c.getAllMethods
          ir <- getIr(cache, m, processed)
        } yield ir
      }
    }

    private[this] def getIr(cache: AnalysisCache, m: IMethod, processed: mutable.Set[IR]): Option[IR] = {
//      println(m.toString)
      val ir = cache getIR m
      if (Option(ir).isDefined) {
        if (!(processed contains ir)) {
          processed += ir
          Some(ir)
        } else None
      } else None
    }

    private[this] def getDexIrFactory(scope: AnalysisScope) =
      if (scope getModules ClassLoaderReference.Application exists {
        case _: DexFileModule => true
        case _                => false
      }) new DexIRFactory() else new DefaultIRFactory()

    private[this] def getJavaIrFactory(scope: AnalysisScope): IRFactory[IMethod] =
      if (scope getModules JavaSourceAnalysisScope.SOURCE exists {
        case _: SourceDirectoryTreeModule => true
        case _                            => false
      }) new AstDefaultIRFactory() else new DefaultIRFactory()

    private[this] def getCha(implicit scope: AnalysisScope): ClassHierarchy = {
      val includeLib = !config.ignoreLibs
      val classLoaderImpl = new ClassLoaderFactoryImpl(scope.getExclusions)
      ClassHierarchy.make(scope, classLoaderImpl)
    }

    def getConstantUrlStrings(ir: IR): Set[String] = {
      val table = ir.getSymbolTable
      (1 to table.getMaxValueNumber collect {
        case v if (table isStringConstant v) && isUrlPrefix(table getStringValue v) =>
          table getStringValue v
      })(breakOut)
    }
  }
}