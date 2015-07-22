package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append._

trait StringAppendDatastructure {

  sealed trait StringAppend {

    def addAlternatives(string: StringAppend): StringAppend =
      string match {
        case StringAlternatives(alts) =>
          StringAlternatives(alts + this)
        case _                         =>
          StringAlternatives(Set(string, this))
      }
    
    def append(string: StringAppend): StringAppend =
    string match {
      case StringSeq(strings) =>
        StringSeq(strings +: this)
      case _                  =>
        StringSeq(Seq(this, string))
    }
  }
  
  case class StringAlternatives(strings: Set[StringAppend]) extends StringAppend {
    
    override def addAlternatives(alts: StringAppend): StringAppend =
      alts match {
        case StringAlternatives(strings2) => StringAlternatives(strings ++ strings2)
      }
  }
  
  case class StringSeq(strings: Seq[StringAppend]) extends StringAppend {

    override def append(string: StringAppend): StringAppend =
      string match {
        case StringSeq(strings2) =>
          StringSeq(strings ++ strings2)
        case _                   =>
          StringSeq(strings :+ string)
      }
  }
  
  case class AppendArgument(vn: ValueNumber) extends StringAppend
}
