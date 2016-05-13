package com.ibm.stringoid.util

case class TimeResult[R] private(result: R, time: Double)

object TimeResult {

  private[TimeResult] var num = 0

  def apply[R](block: => R): TimeResult[R] = {
    def sec() = System.nanoTime() / 1000000000.0
    val t0 = sec()
    val result = block
    val t1 = sec()
    val diff = t1 - t0
    TimeResult(result, diff)
  }

  def apply[R](process: String, block: => R): R = {
    println("    " * num + process + "...")
    num = num + 1
    val timeResult = TimeResult(block)
    num = num - 1
    println("    " * num + "elapsed time: " + timeResult.time.toInt + " s (" + process + ")")
    timeResult.result
  }
}
