package edu.illinois.wala.ipa.callgraph

import java.util

import com.ibm.wala.classLoader.ClassLoaderFactoryImpl
import com.ibm.wala.dalvik.util.AndroidEntryPointLocator
import com.ibm.wala.dalvik.util.AndroidEntryPointLocator.LocatorFlags
import com.ibm.wala.ipa.callgraph.AnalysisOptions.ReflectionOptions
import com.ibm.wala.ipa.callgraph.Entrypoint
import com.ibm.wala.ipa.callgraph.impl.DefaultEntrypoint
import com.ibm.wala.ipa.cha.ClassHierarchy
import com.ibm.wala.types.{MethodReference, TypeName, TypeReference}
import com.ibm.wala.util.collections.HashSetFactory
import com.typesafe.config.{Config, ConfigFactory}

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

class AnalysisOptions(scope: AnalysisScope, entrypoints: java.lang.Iterable[Entrypoint], val cha: ClassHierarchy, val isSourceAnalysis: Boolean)
  extends com.ibm.wala.ipa.callgraph.AnalysisOptions(scope, entrypoints) {
}

object AnalysisOptions {

  // TODO: replace below to use the above class

  def apply(
    extraEntrypoints: Iterable[(String, String)],
    extraDependencies: Iterable[Dependency])(
      implicit config: Config): AnalysisOptions = {

    implicit val scope = AnalysisScope(extraDependencies)

    val classLoaderImpl = new ClassLoaderFactoryImpl(scope.getExclusions())
    //      if (!srcDep.isEmpty) 
    //      new PolyglotClassLoaderFactory(scope.getExclusions(), new JavaIRTranslatorExtension())
    //    else

    implicit val cha = ClassHierarchy.make(scope, classLoaderImpl)

    val options = new AnalysisOptions(scope, entrypoints(extraEntrypoints), cha, false)
    options.setReflectionOptions(ReflectionOptions.NONE)
    options // !srcDep.isEmpty
  }

  def entrypoints(extraEntrypoints: Iterable[(String, String)] = Seq())(
    implicit config: Config, cha: ClassHierarchy, scope: AnalysisScope) = {
    val oneEntryPoint =
      if (config.hasPath("wala.entry.class"))
        Some((config.getString("wala.entry.class"), config.getString("wala.entry.method")))
      else
        None

    val entryPointsFromPattern =
      if (config.hasPath("wala.entry.signature-pattern")) {
        val signaturePattern = config.getString("wala.entry.signature-pattern")
        val matchingMethods = cha.iterator() flatMap { c =>
          c.getAllMethods() filter { m =>
            m.getSignature() matches signaturePattern
          }
        }
        matchingMethods map { new DefaultEntrypoint(_, cha) } toSeq
      } else
        Seq()

    val androidEntrypoints =
      if (config.hasPath("wala.dependencies.apk")) {
        val flags: util.HashSet[LocatorFlags] = HashSetFactory.make[LocatorFlags]
        flags.addAll(Seq(LocatorFlags.INCLUDE_CALLBACKS, LocatorFlags.EP_HEURISTIC, LocatorFlags.CB_HEURISTIC))
        new AndroidEntryPointLocator(flags).getEntryPoints(cha).asScala
      } else Seq.empty[DefaultEntrypoint]

    val entrypoints = entryPointsFromPattern ++
      ((extraEntrypoints ++ oneEntryPoint) map { case (klass, method) => makeEntrypoint(klass, method) }) ++
      androidEntrypoints

    if (entrypoints.isEmpty)
      System.err.println("WARNING: no entrypoints")

    entrypoints
  }

  // helper apply methods 

  def apply()(implicit config: Config = ConfigFactory.load): AnalysisOptions = {
    apply(Seq(), Seq())
  }

  def apply(klass: String, method: String)(implicit config: Config): AnalysisOptions = apply((klass, method), Seq())

  def apply(entrypoint: (String, String),
    dependencies: Iterable[Dependency])(implicit config: Config): AnalysisOptions = apply(Seq(entrypoint), dependencies)

  val mainMethod = "main([Ljava/lang/String;)V"

  private def makeEntrypoint(entryClass: String, entryMethod: String)(implicit scope: AnalysisScope, cha: ClassHierarchy): Entrypoint = {
    val methodReference = AnalysisScope.allScopes.toStream
      .map { scope.getLoader(_) }
      .map { TypeReference.findOrCreate(_, TypeName.string2TypeName(entryClass)) }
      .map { MethodReference.findOrCreate(_, entryMethod.substring(0, entryMethod.indexOf('(')), entryMethod.substring(entryMethod.indexOf('('))) }
      .find { cha.resolveMethod(_) != null } getOrElse { throw new Error("Could not find entrypoint: " + entryClass + "#" + entryMethod + " anywhere in loaded classes.") }

    new DefaultEntrypoint(methodReference, cha)
  }

}