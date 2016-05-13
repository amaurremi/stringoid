package com.ibm.stringoid.util

case class TimeResult[R] private(result: R, time: Double)

object TimeResult {

  val ANSI_PURPLE = "\u001B[35m"
  val ANSI_GREEN = "\u001B[32m"
  val ANSI_RESET = "\u001B[0m"

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
    printColoured(num, process + "...", start = true)
    num = num + 1
    val timeResult = TimeResult(block)
    num = num - 1
    printColoured(num, "elapsed time: " + timeResult.time.toLong + " s (" + process + ")", start = false)
    timeResult.result
  }

  def printColoured(num: Int, msg: String, start: Boolean) =
    println(if (start) ANSI_PURPLE else ANSI_GREEN + "    " * num + msg + ANSI_RESET)
}
