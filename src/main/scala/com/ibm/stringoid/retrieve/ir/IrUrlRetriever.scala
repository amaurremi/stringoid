package com.ibm.stringoid.retrieve.ir

import com.ibm.stringoid.AnalysisConfig
import com.ibm.stringoid.retrieve.UrlCheck.isUrlPrefix
import com.ibm.stringoid.retrieve.UrlRetriever
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.StringAutomata
import com.ibm.wala.analysis.typeInference.{TypeAbstraction, TypeInference}
import com.ibm.wala.cast.ir.ssa.AstIRFactory.AstDefaultIRFactory
import com.ibm.wala.cast.java.analysis.typeInference.AstJavaTypeInference
import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope
import com.ibm.wala.classLoader.{ClassLoaderFactoryImpl, IClass, IMethod, SourceDirectoryTreeModule}
import com.ibm.wala.dalvik.classLoader.{DexFileModule, DexIRFactory}
import com.ibm.wala.ipa.callgraph.AnalysisCacheImpl
import com.ibm.wala.ipa.cha.{ClassHierarchy, ClassHierarchyFactory}
import com.ibm.wala.ssa.{DefaultIRFactory, IR, IRFactory}
import com.ibm.wala.types.ClassLoaderReference
import com.ibm.wala.util.debug.UnimplementedError
import edu.illinois.wala.ipa.callgraph.AnalysisScope

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

/**
 * A URL-retrieval analysis that is based on analyzing IRs independently from each other.
 * The trait does not specify how to extract the URLs from an IR.
 */
trait IrUrlRetriever extends UrlRetriever with StringAutomata {

  protected implicit def config: AnalysisConfig

  def getAllNodes: Iterator[Node]

  protected lazy val isApk = config.file.toString.toLowerCase endsWith ".apk"

  protected def isApplicationClass(c: IClass): Boolean =
    Set(ClassLoaderReference.Application, JavaSourceAnalysisScope.SOURCE) contains c.getClassLoader.getReference

  implicit lazy val analysisConfig =
    if (isApk) configWithApk(config.file)
    else configWithSrc(config.file)

  protected lazy val scope = AnalysisScope()

  private[this] val typeInferenceMap = mutable.Map.empty[IR, TypeInference]
  private[this] val javaAstTypeInferenceMap = mutable.Map.empty[IR, AstJavaTypeInference]

  protected def getTypeAbstraction(ir: IR, vn: ValueNumber): TypeAbstraction =
    if (isApk) {
      try {
        val typeInference = typeInferenceMap getOrElseUpdate(ir, TypeInference.make(ir, true))
        typeInference getType vn
      } catch {
        case e: UnimplementedError => // todo something is wrong here
          TypeAbstraction.TOP
      }
    } else {
      val typeInference = javaAstTypeInferenceMap getOrElseUpdate (ir, new AstJavaTypeInference(ir, cha, true))
      typeInference getType vn
    }

  protected def getIr(cache: AnalysisCacheImpl, m: IMethod, processed: mutable.Set[IR]): Option[IR] = {
    val ir = cache getIR m
    if (Option(ir).isDefined) {
      if (!(processed contains ir)) {
        processed += ir
        Some(ir)
      } else None
    } else None
  }

  protected def getDexIrFactory(scope: AnalysisScope) =
    if (scope getModules ClassLoaderReference.Application exists {
      case _: DexFileModule => true
      case _                => false
    }) new DexIRFactory() else new DefaultIRFactory()

  protected def getJavaIrFactory(scope: AnalysisScope): IRFactory[IMethod] =
    if (scope getModules JavaSourceAnalysisScope.SOURCE exists {
      case _: SourceDirectoryTreeModule => true
      case _                            => false
    }) new AstDefaultIRFactory() else new DefaultIRFactory()

  protected lazy val cha: ClassHierarchy = {
    val includeLib = !config.ignoreLibs
    val classLoaderImpl = new ClassLoaderFactoryImpl(scope.getExclusions)
    ClassHierarchyFactory.make(scope, classLoaderImpl)
  }

  def getConstantUrlStrings(ir: IR): Set[String] = {
    val table = ir.getSymbolTable
    (1 to table.getMaxValueNumber collect {
      case v if (table isStringConstant v) && isUrlPrefix(table getStringValue v) =>
        table getStringValue v
    })(breakOut)
  }
}