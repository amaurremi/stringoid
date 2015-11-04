package com.ibm.stringoid.retrieve.ir.append

import com.ibm.stringoid.retrieve.ir.ValueNumber

package object fixedpoint {

  sealed trait StringPart
  case class StringValNum(vn: ValueNumber) extends StringPart
  case class StringFormatPart(string: String) extends StringPart
  case object MissingStringFormatArgument extends StringPart
  case object StringCycle extends StringPart

  type JsonAutomaton = String
}
