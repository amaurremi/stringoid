package com.ibm.stringoid.util

class ProgressBar(size: Int) {
  private[this] var iteration = 0
  private[this] var printedOut = 0

  private[this] def printProgressBarDot: Boolean =
    Math.ceil((iteration.toFloat / size) * 100).toInt > printedOut

  def advance(): Unit = {
    iteration = iteration + 1
    if (printProgressBarDot) {
      print(".")
      printedOut = printedOut + 1
    }
  }
}
