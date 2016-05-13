package com.ibm.stringoid.util

case class TimeResult[R] private(result: R, time: Double)

object TimeResult {

  private val ANSI_RESET  = "\u001B[0m"
  private val ANSI_PURPLE = "\u001B[35m"
  private val ANSI_GREEN  = "\u001B[32m"
  private val ANSI_YELLOW = "\u001B[33m"
  private val ANSI_RED    = "\u001B[31m"
  private val ANSI_BLUE   = "\u001B[34m"
  private val ANSI_CYAN   = "\u001B[36m"
  private val ANSI_WHITE  = "\u001B[37m"
  private val colours = List(ANSI_PURPLE, ANSI_GREEN, ANSI_YELLOW, ANSI_RED, ANSI_BLUE, ANSI_CYAN, ANSI_WHITE)

  private val PRINT_ON = false

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
    printColoured(num, process + "...")
    num = num + 1
    val timeResult = TimeResult(block)
    num = num - 1
    printColoured(num, "elapsed time: " + timeResult.time.toLong + " s (" + process + ")\n")
    timeResult.result
  }

  private def printColoured(num: Int, msg: String) = {
    val colour = colours(num % colours.length)
    println(colour + "    " * num + msg + ANSI_RESET)
  }

  def print(msg: String) =
    if (PRINT_ON) println(msg) else ()
}
