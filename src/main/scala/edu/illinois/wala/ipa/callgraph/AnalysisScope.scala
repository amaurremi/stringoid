package edu.illinois.wala.ipa.callgraph

import java.io.{ByteArrayInputStream, File}
import java.util.Collections
import java.util.jar.JarFile

import com.ibm.wala.classLoader.{BinaryDirectoryTreeModule, JarFileModule, Language, Module}
import com.ibm.wala.dalvik.classLoader.DexFileModule
import com.ibm.wala.types.ClassLoaderReference
import com.ibm.wala.util.config.FileOfClasses
import com.ibm.wala.util.io.FileProvider
import com.ibm.wala.util.strings.Atom
import com.typesafe.config.{Config, ConfigList}
import edu.illinois.wala.ipa.callgraph.AnalysisScope._

import scala.Array.canBuildFrom
import scala.collection.JavaConversions._
import scala.collection._
//import com.ibm.wala.cast.java.ipa.callgraph.JavaSourceAnalysisScope

object AnalysisScope {

  implicit class RichConfig(c: Config) {
    def getListOption(path: String): Option[ConfigList] =
      if (c.hasPath(path))
        Some(c.getList(path))
      else
        None

    def getStringOption(path: String): Option[String] =
      if (c.hasPath(path))
        Some(c.getString(path))
      else
        None
  }

  type Scope = Atom
  val Primordial = com.ibm.wala.ipa.callgraph.AnalysisScope.PRIMORDIAL
  val Extension = com.ibm.wala.ipa.callgraph.AnalysisScope.EXTENSION
  val Application = com.ibm.wala.ipa.callgraph.AnalysisScope.APPLICATION
  val Synthetic = com.ibm.wala.ipa.callgraph.AnalysisScope.SYNTHETIC
  //  val Source = JavaSourceAnalysisScope.SOURCE.getName()
  def apply(jreLibPath: String, exclusions: String) = new AnalysisScope(jreLibPath, exclusions)

  val allScopes = List(Application,
    //      Source, 
    Synthetic, Extension, Primordial)

  def apply(extraDependencies: Iterable[Dependency] = Seq())(implicit config: Config) = {
    val binDep = if (config.hasPath("wala.dependencies.binary"))
      config.getList("wala.dependencies.binary") map { d => Dependency(d.unwrapped.asInstanceOf[String]) }
    else
      List()

    val srcDep = if (config.hasPath("wala.dependencies.source"))
      config.getList("wala.dependencies.source") map { d => Dependency(d.unwrapped.asInstanceOf[String], DependencyNature.SourceDirectory) }
    else
      List()

    val jarDep = if (config.hasPath("wala.dependencies.jar"))
      config.getList("wala.dependencies.jar") map { d => Dependency(d.unwrapped.asInstanceOf[String], DependencyNature.Jar) }
    else
      List()

    val apkDependencies = if (config.hasPath("wala.dependencies.apk"))
      config.getList("wala.dependencies.apk") map { d => Dependency(d.unwrapped.asInstanceOf[String], DependencyNature.Apk) }
    else
      List()

    val dependencies = binDep ++ srcDep ++ jarDep ++ apkDependencies ++ extraDependencies

    val jreLibPath = config.getStringOption("wala.jre-lib-path").getOrElse(System.getenv().get("JAVA_HOME") + "/jre/lib/rt.jar")

    new AnalysisScope(jreLibPath, config.getStringOption("wala.android-jar-path"), config.getString("wala.exclusions"), dependencies)
  }
}

object DependencyNature extends Enumeration {
  type DependencyNature = Value
  val Binary, BinaryDirectory, Jar, JarDirectory, SourceDirectory, Apk = Value
}

object Dependency {
  def apply(file: String): Dependency = apply(file, DependencyNature.BinaryDirectory, Application)
  def apply(file: String, nature: DependencyNature.DependencyNature): Dependency = apply(file, nature, Application)
}

case class Dependency(file: String, nature: DependencyNature.DependencyNature, scope: Scope)

class AnalysisScope(jreLibPath: String, androidJarPathOpt: Option[String], exclusions: String, dependencies: Iterable[Dependency]) extends com.ibm.wala.ipa.callgraph.AnalysisScope(Collections.singleton(Language.JAVA)) {
  val UNDER_ECLIPSE = false
  import AnalysisScope._
  import DependencyNature._

  def this(jreLibPath: String, exclusions: String) = this(jreLibPath, None, exclusions, Seq())

  initForJava()

  addToScope(getLoader(Primordial), new JarFile(jreLibPath))

  androidJarPathOpt match {
    case Some(androidJarPath) =>
      addToScope(getLoader(Primordial), new JarFile(androidJarPathOpt.get))
      setLoaderImpl(ClassLoaderReference.Application, "com.ibm.wala.dalvik.classLoader.WDexClassLoaderImpl")
    case None                 =>
      if (dependencies.exists { case Dependency(_, Apk, _) => true })
        throw new Exception("The wala.android-jar path is missing in the config file.")
  }

  setExclusions(new FileOfClasses(new ByteArrayInputStream(exclusions.getBytes("UTF-8"))))

  addDependencies(dependencies)

  def addDependencies(dependencies: Iterable[Dependency]) {
    for (d <- dependencies) d match {
      case Dependency(file, BinaryDirectory, scope: Scope) => addBinaryDependency(file, scope)
      case Dependency(file, JarDirectory, scope: Scope) => addJarDirectoryDependency(file, scope)
      case Dependency(file, Jar, scope: Scope) => addJarDependency(file, scope)
      case Dependency(file, Binary, scope: Scope) => throw new Exception("Unimplemented yet")
      case Dependency(file, Apk, scope: Scope) => addApkDependency(file, scope)
      //      case Dependency(file, SourceDirectory, scope: Scope) => addSourceDependency(file, scope)
    }
  }

  def getFile(path: String) =
    if (UNDER_ECLIPSE)
      new FileProvider().getFile(path, getLoader)
    else
      new File(path)

  def addBinaryDependency(directory: String, analysisScope: Atom = Application) {
    //    debug("Binary: " + directory);
    val sd = getFile(directory)
    assert(sd.exists(), "dependency \"" + directory + "\" not found")
    assert(sd.isDirectory, "dependency \"" + directory + "\" not a directory")
    addToScope(getLoader(analysisScope), new BinaryDirectoryTreeModule(sd))
  }

  // stuff for source frontend below

  //  def addSourceDependency(directory: String, analysisScope: Atom = Application) {
  //    loadersByName.put(JavaSourceAnalysisScope.SOURCE.getName(), JavaSourceAnalysisScope.SOURCE);
  //    setLoaderImpl(JavaSourceAnalysisScope.SOURCE, "com.ibm.wala.cast.java.translator.polyglot.PolyglotSourceLoaderImpl");
  //    initSynthetic(JavaSourceAnalysisScope.SOURCE)
  //    //    debug("Binary: " + directory);
  //    val sd = getFile(directory);
  //    assert(sd.exists(), "dependency \"" + directory + "\" not found")
  //    assert(sd.isDirectory(), "dependency \"" + directory + "\" not a directory")
  //    addToScope(getLoader(analysisScope), new SourceDirectoryTreeModule(sd));
  //  }

  override def addToScope(loader: ClassLoaderReference, m: Module) {
    //    if (m.isInstanceOf[SourceDirectoryTreeModule] && loader.equals(ClassLoaderReference.Application)) {
    //      super.addToScope(JavaSourceAnalysisScope.SOURCE, m);
    //    } else {
    super.addToScope(loader, m)
    //    }
  }

  // stuff for source front end above

  def getLoader = AnalysisScope.this.getClass.getClassLoader

  def addJarDirectoryDependency(path: String, scope: Scope = Extension) {
    //    debug("Jar folder: " + path);
    val dir = getFile(path)
    val delim = if (path.endsWith("/")) "" else "/"

    val files = dir.list()
    if (files == null) return

    for (fileName <- files) yield {
      if (fileName.endsWith(".jar"))
        addJarDependency(path + delim + fileName, scope)
      else {
        val file = new File(fileName)
        if (file.isDirectory)
          addJarDirectoryDependency(file.getAbsolutePath, scope)
      }
    }
  }

  def addJarDependency(file: String, scope: Scope = Extension) {
    //    debug("Jar: " + file);
    val M = if (UNDER_ECLIPSE)
      new FileProvider().getJarFileModule(file, getLoader)
    else
      new JarFileModule(new JarFile(file, true))

    addToScope(getLoader(scope), M)
  }

  def addApkDependency(file: String, scope: Scope = Application): Unit = {
    val make = DexFileModule.make(new File(file))
    addToScope(getLoader(scope), make)
  }
}
