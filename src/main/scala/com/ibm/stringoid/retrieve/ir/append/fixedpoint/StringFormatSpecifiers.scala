package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import java.util.regex.Pattern

import com.ibm.wala.ssa.SSAInvokeInstruction

import scala.collection.JavaConversions._
import scala.collection.mutable

object StringFormatSpecifiers {

  val formatSpecifier = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])"
  val fsPattern       = Pattern.compile(formatSpecifier)
}

trait StringFormatSpecifiers {

  import StringFormatSpecifiers._

  sealed trait FormattedString
  case class FormattedStringPart(substring: String) extends FormattedString
  case class Specifier(useNumber: Int) extends FormattedString

  /**
   * Returns the sequence of string parts and specifiers, along with the number of specifiers.
   */
  def parse(s: String): (Iterable[FormattedString], Int) = {
    var specifierCount = 0
    val matcher = fsPattern matcher s
    val buffer  = mutable.UnrolledBuffer.empty[FormattedString]
    var index   = 0
    val length  = s.length
    while (index < length) {
      if (matcher find index) {
        if (matcher.start != index)
          buffer add FormattedStringPart(s substring (index, matcher.start))
        specifierCount = specifierCount + 1
        buffer add Specifier(specifierCount)
        index = matcher.end
      } else {
        specifierCount = specifierCount + 1
        buffer add Specifier(specifierCount)
        return (buffer.toIterable, specifierCount)
      }
    }
    (buffer.toIterable, specifierCount)
  }
}
