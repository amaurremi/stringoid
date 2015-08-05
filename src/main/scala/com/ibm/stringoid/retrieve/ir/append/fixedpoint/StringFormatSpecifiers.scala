package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.util
import java.util.regex.{Matcher, Pattern}
import com.ibm.stringoid.retrieve.ir.append.ValueNumber
import com.ibm.wala.ssa.SSAInvokeInstruction

import scala.collection.JavaConversions._

trait StringFormatSpecifiers {

  private val formatSpecifier
    = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])"

  private val fsPattern = Pattern.compile(formatSpecifier)

  sealed trait FormattedString
  case class FormattedStringPart(start: Int, startNext: Int) extends FormattedString
  case class Specifier(start: Int, startNext: Int, use: ValueNumber) extends FormattedString

  def parse(s: String, instr: SSAInvokeInstruction): Array[FormattedString] = { // todo rewrite this horrible method
    val uses = (1 until instr.getNumberOfUses).iterator
    val al = new util.ArrayList[FormattedString]
    val m: Matcher = fsPattern.matcher(s)
      var i: Int = 0
      val len: Int = s.length
      while (i < len) {
        if (m.find(i)) {
          if (m.start != i)
            al.add(FormattedStringPart(i, m.start))
          al.add(Specifier(m.start, m.end, instr getUse uses.next()))
          i = m.end
        }
        else {
          al.add(Specifier(i, s.length, instr getUse uses.next()))
          return Array(al: _*)
        }
      }
    Array(al: _*)
  }
}
