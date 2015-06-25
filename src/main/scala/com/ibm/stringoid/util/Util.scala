package com.ibm.stringoid.util

object Util {

  def filterOutNulls[A](seq: Seq[A]): Seq[A] =
    seq filter { Option(_).isDefined }
}
