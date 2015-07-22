package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append._

trait StringAppendDatastructure {

  /**
   * A data structure for a string concatenation.
   */
  sealed trait StringConcatenation {

    def addAlternatives(string: StringConcatenation): StringConcatenation =
      string match {
        case StringAlternatives(alts) =>
          StringAlternatives(alts + this)
        case _                         =>
          StringAlternatives(Set(string, this))
      }
    
    def append(string: StringConcatenation): StringConcatenation =
    string match {
      case StringSeq(strings) =>
        StringSeq(strings +: this)
      case _                  =>
        StringSeq(Seq(this, string))
    }
  }
  
  case class StringAlternatives(strings: Set[StringConcatenation]) extends StringConcatenation {
    
    override def addAlternatives(alts: StringConcatenation): StringConcatenation =
      alts match {
        case StringAlternatives(strings2) => StringAlternatives(strings ++ strings2)
      }
  }
  
  case class StringSeq(strings: Seq[StringConcatenation]) extends StringConcatenation {

    override def append(string: StringConcatenation): StringConcatenation =
      string match {
        case StringSeq(strings2) =>
          StringSeq(strings ++ strings2)
        case _                   =>
          StringSeq(strings :+ string)
      }
  }
 
  case class AppendArgument(vn: ValueNumber) extends StringConcatenation
}
