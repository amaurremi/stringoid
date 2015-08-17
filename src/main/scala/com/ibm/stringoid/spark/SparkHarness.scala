package com.ibm.stringoid.spark

import java.io.File
import java.net.URI
import java.nio.file.{Files, Path, Paths}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, Path => HadoopPath, RemoteIterator}
import org.apache.spark.{Logging, SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

import scala.collection.JavaConversions
import scala.util.Try

object SparkHarness extends Logging {
  def main(args: Array[String]) : Unit = {
    if(args.length != 4) {
      Console.err.println("Please specify:")
      Console.err.println("  1) an analysis type ('constants' | 'append'),")
      Console.err.println("  2) an input directory containing apks,")
      Console.err.println("  3) an output directory name prefix,")
      Console.err.println("  4) the number of apps to analyze (0 = all).")
    } else {
      mainSpark(args)
    }
  }

  def mainNoSpark(args: Array[String]) : Unit = {
    val analysisType = args(0)
    val apkDirPath   = args(1)
    val outDirPath   = args(2)
    val numApps      = args(3).toInt

    val ds = Files.newDirectoryStream(Paths.get(apkDirPath))
    val apkPaths: List[Path] = JavaConversions.asScalaIterator(ds.iterator()).toList


    val results: List[Try[String]] = apkPaths.map { p =>
      // println(p)

      com.ibm.stringoid.Main.analyseAPK(
        analysisType,
        p,
        useCallGraph = false,
        ignoreLibraries = true,
        stringFormat = false
      ) 
    }

    println(results.mkString("\n\n"))
  }

  def mainSpark(args : Array[String]) : Unit = {
    import java.text.SimpleDateFormat
    import java.util.Date

    val now = (new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss")).format(new Date())

    val analysisType = args(0)
    val apkDirPath   = args(1)
    val outDirPath   = s"${args(2).trim}-${now}"
    val numApps      = args(3).toInt

    val conf = new SparkConf().setAppName("Stringoid")
    val sc = new SparkContext(conf)

    val hadoopConf = sc.hadoopConfiguration

    val fs = FileSystem.get(hadoopConf)

    val apkPaths: List[HadoopPath] = iteratorFromRemoteIterator(
      fs.listFiles(new HadoopPath(apkDirPath), true)
    ).toList.map(_.getPath())

    val selectedApkPaths : List[HadoopPath] = if(numApps <= 0) {
      apkPaths
    } else {
      // Inefficient way of doing sampling, but that's not really where the time goes. PS
      val rand = new scala.util.Random(42L)
      rand.shuffle(apkPaths).take(numApps)
    }

    val apkPathsRDD: RDD[URI] = sc.parallelize(selectedApkPaths.map(_.toUri()), selectedApkPaths.length)

    val results: RDD[(String,Try[String])] = apkPathsRDD.map { apkUri =>
      val fs = FileSystem.get(apkUri, new Configuration())
      val localFile = toLocalFile(fs, apkUri)
      val localPath = localFile.toPath()

      // logInfo(s"Now looking at $apkUri...")

      val result = com.ibm.stringoid.Main.analyseAPK(
        analysisType,
        localPath,
        useCallGraph = false,
        ignoreLibraries = true,
        stringFormat = false)

      localFile.delete()

      // logInfo(s"Done with $apkUri.")

      (apkUri.toString(), result)
    }

    results.repartition(sc.defaultParallelism).saveAsTextFile(outDirPath)

    sc.stop()
  }
  

  /* Copies the file to a temporary local file.
   * Note that in principle, the way this program operates is idiotic: the mapping between files and
   * the nodes on which they reside is lost entirely, resulting in data being moved around almost
   * always. Given the respective running times of copying vs. analysing, this is probably not such a
   * big deal, but it's not something to be proud of. This situation arised as a consequence of my
   * utter inability to use binaryFiles properly (and partially because WALA can easily only read
   * from java.io.File's). PS. */
  private def toLocalFile(fs: FileSystem, uri: URI) : File = {
    val hadoopPath = new HadoopPath(uri)
    val tmp = File.createTempFile("stringoid-", ".apk")
    tmp.deleteOnExit()
    fs.copyToLocalFile(hadoopPath, new HadoopPath(tmp.getAbsolutePath()))
    tmp
  }

  /* Not the most sophisticated code. */
  private def iteratorFromRemoteIterator[T](ri: RemoteIterator[T]) = new Iterator[T] {
    def hasNext() = ri.hasNext()
    def next() : T = ri.next()
  }

  /*
  def resultForDataStream(analysis: String, ds: PortableDataStream) : Try[String] = {
    import com.ibm.stringoid.Main.analyseAPK

    val file = dataStreamToFile(ds)

    val path = file.toPath()

    val result = analyseAPK(analysis, path, false, true)

    file.delete()

    //result
    Success("OK!")
  }

  def dataStreamToFile(ds: PortableDataStream) : File = {
    import java.io._

    val tf: File = File.createTempFile("stringoid-", ".apk")
    tf.deleteOnExit()

    val dis: DataInputStream = ds.open()

    val dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tf)))

    var b: Int = 0
    while({ b = dis.read(); b } != -1) {
      dos.write(b.toByte)
    }

    dis.close()
    dos.close()
    ds.close()

    tf
  }
  */
}
