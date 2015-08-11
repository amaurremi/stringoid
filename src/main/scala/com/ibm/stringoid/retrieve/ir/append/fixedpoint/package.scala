package com.ibm.stringoid.retrieve.ir.append

package object fixedpoint {

  /**
   * See [[AbstractStringBuilderModule]]
   */
  case class AbstractStringBuilderObject(vn: Int)

  type ASBO = AbstractStringBuilderObject

  sealed trait StringPart
  case class StringValNum(vn: ValueNumber) extends StringPart
  case object StringCycle extends StringPart
}
