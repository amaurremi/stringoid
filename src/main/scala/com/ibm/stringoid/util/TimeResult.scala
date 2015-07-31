package com.ibm.stringoid.util

case class TimeResult[R] private(result: R, time: Double)

object TimeResult {

  def apply[R](block: => R): TimeResult[R] = {
    def sec() = System.nanoTime() / 1000000000.0
    val t0 = sec()
    val result = block
    val t1 = sec()
    TimeResult(result, t1 - t0)
  }

  def printTime[R](process: String)(block: => R): R = {
    println(process + "...")
    val timeResult = TimeResult(block)
    println("    Elapsed time: " + timeResult.time + " s")
    timeResult.result
  }
}
