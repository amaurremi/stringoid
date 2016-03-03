package edu.illinois.wala.ipa.callgraph

import com.ibm.wala.cast.ir.ssa.AstIRFactory
import com.ibm.wala.cast.java.ipa.callgraph.AstJavaSSAPropagationCallGraphBuilder
import com.ibm.wala.classLoader.IMethod
import com.ibm.wala.dalvik.classLoader.{DexFileModule, DexIRFactory}
import com.ibm.wala.ipa.callgraph._
import com.ibm.wala.ipa.callgraph.propagation._
import com.ibm.wala.ipa.callgraph.propagation.cfa.DefaultPointerKeyFactory
import com.ibm.wala.ipa.cha.ClassHierarchy
import com.ibm.wala.ssa.{DefaultIRFactory, IRFactory}
import com.ibm.wala.types.ClassLoaderReference
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConversions._

object FlexibleCallGraphBuilder {
  def apply(entrypoint: (String, String), dependencies: Iterable[Dependency])(implicit config: Config): AbstractCallGraphBuilder =
    apply(AnalysisOptions(Seq(entrypoint), dependencies))

  def apply(entrypoint: (String, String), dependency: String)(implicit config: Config = ConfigFactory.load): AbstractCallGraphBuilder =
    apply(entrypoint, Seq(Dependency(dependency)))

  def apply()(implicit config: Config): AbstractCallGraphBuilder =
    apply(AnalysisOptions())

  def apply(options: AnalysisOptions): AbstractCallGraphBuilder =
    if(options.isSourceAnalysis)
      new AstFlexibleCallGraphBuilder(options)
    else
      new BytecodeFlexibleCallGraphBuilder(options)
}

trait AbstractFlexibleCallGraphBuilder extends PropagationCallGraphBuilder with AbstractCallGraphBuilder with ExtraFeatures {

  final lazy val heap = getPointerAnalysis.getHeapGraph

  val _options: AnalysisOptions

  setContextInterpreter(theContextInterpreter)
  setContextSelector(cs)
  setInstanceKeys(instanceKeys)

  lazy val cg = makeCallGraph(_options)
  val cache = _cache

  // expose implicits
  implicit val implicitCha = cha
}

class BytecodeFlexibleCallGraphBuilder(
  val _cha: ClassHierarchy,
  val _options: AnalysisOptions,
  val _cache: AnalysisCache, pointerKeys: PointerKeyFactory
) extends SSAPropagationCallGraphBuilder(_cha, _options, _cache, pointerKeys)
  with AbstractFlexibleCallGraphBuilder {

  def this(cha: ClassHierarchy, options: AnalysisOptions, irFactory: IRFactory[IMethod]) =
    this(cha, options, new AnalysisCache(irFactory), new DefaultPointerKeyFactory())

  def this(options: AnalysisOptions) = {
    this(options.cha, options,
      if ((options.getAnalysisScope getModules ClassLoaderReference.Application) exists {
        case _: DexFileModule => true
        case _                => false
      }) new DexIRFactory()
      else new DefaultIRFactory())
  }

  def this()(implicit config: Config) = this(AnalysisOptions())
}

class AstFlexibleCallGraphBuilder(
  val _cha: ClassHierarchy,
  val _options: AnalysisOptions,
  val _cache: AnalysisCache, pointerKeys: PointerKeyFactory
) extends AstJavaSSAPropagationCallGraphBuilder(_cha, _options, _cache, pointerKeys)
  with AbstractFlexibleCallGraphBuilder {

  def this(cha: ClassHierarchy, options: AnalysisOptions, irFactory: IRFactory[IMethod]) =
    this(cha, options, new AnalysisCache(irFactory), new DefaultPointerKeyFactory())

  def this(options: AnalysisOptions) =
    this(options.cha, options,
      if (options.isSourceAnalysis)
        AstIRFactory.makeDefaultFactory()
      else
        new DefaultIRFactory())
}