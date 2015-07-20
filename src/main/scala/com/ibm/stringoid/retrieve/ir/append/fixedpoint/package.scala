package com.ibm.stringoid.retrieve.ir.append

package object fixedpoint {

  /**
   * Consider the program
   *
   * "x" + "y"
   *
   * which gets represented in the IR as something like
   *
   * 1 = new StringBuilder()
   * 2 = 1.append(3)          // 3 represents "x"
   * 4 = 2.append(4)          // 4 represents "y"
   *
   * We see that the same StringBuilder object is mapped to from the value numbers 1, 2, and 4.
   * An AbstractStringBuilderObject is the representation of one such StringBuilder object that can be mapped
   * to by many value numbers.
   */
  case class AbstractStringBuilderObject(n: Int) extends AnyVal
}
