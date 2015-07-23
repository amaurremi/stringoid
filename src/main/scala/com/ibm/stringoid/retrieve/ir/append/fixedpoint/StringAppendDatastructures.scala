package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import com.ibm.stringoid.retrieve.ir.append._

trait StringAppendDatastructures {

  sealed trait StringConcatenation[S <: StringConcatenation[S]] {
    
    /**
     * append a string
     */
    def ++(string: S): S
  }

  /**
   * A data structure for a string concatenation that encompasses alternatives caused by phi instructions.
   */
  sealed trait AltStringConcatenation extends StringConcatenation[AltStringConcatenation] {

    /**
     * add an alternative string
     */
    def |(string: AltStringConcatenation): AltStringConcatenation =
      string match {
        case AltStringAlternatives(alts) =>
          AltStringAlternatives(alts + this)
        case _                         =>
          AltStringAlternatives(Set(string, this))
      }

    override def ++(string: AltStringConcatenation): AltStringConcatenation =
      string match {
        case AltStringSeq(strings) =>
          AltStringSeq(this +: strings)
        case _                     =>
          AltStringSeq(Seq(this, string))
      }

    def flatten: Set[SingleStringConcatenation]
  }
  
  case class AltStringAlternatives(strings: Set[AltStringConcatenation]) extends AltStringConcatenation {
    
    override def |(alts: AltStringConcatenation): AltStringConcatenation =
      alts match {
        case AltStringAlternatives(strings2) =>
          AltStringAlternatives(strings ++ strings2)
        case _                               =>
          AltStringAlternatives(strings + alts)
      }

    override def flatten: Set[SingleStringConcatenation] =
      strings flatMap { _.flatten }
  }
  
  case class AltStringSeq(strings: Seq[AltStringConcatenation]) extends AltStringConcatenation {

    override def ++(string: AltStringConcatenation): AltStringConcatenation =
      string match {
        case AltStringSeq(strings2) =>
          AltStringSeq(strings ++ strings2)
        case _                      =>
          AltStringSeq(strings :+ string)
      }

    override def flatten: Set[SingleStringConcatenation] =
      strings match {
        case head :: tail =>
          for {
            flatHead <- head.flatten
            flatTail <- AltStringSeq(tail).flatten
          } yield flatHead ++ flatTail
        case Seq() =>
          Set.empty[SingleStringConcatenation]
      }
  }
 
  case class AltAppendArgument(vn: ValueNumber) extends AltStringConcatenation {

    override def flatten: Set[SingleStringConcatenation] = Set(SingleAppendArgument(vn))
  }

  /**
   * A data structure for the representation of a single string (without alternatives).
   */
  sealed trait SingleStringConcatenation extends StringConcatenation[SingleStringConcatenation]

  case class SingleStringSeq(strings: Seq[SingleStringConcatenation]) extends SingleStringConcatenation {

    override def ++(string: SingleStringConcatenation): SingleStringConcatenation =
      string match {
        case SingleStringSeq(strings2) =>
          SingleStringSeq(strings ++ strings2)
        case _                   =>
          SingleStringSeq(strings :+ string)
      }
  }

  case class SingleAppendArgument(vn: ValueNumber) extends SingleStringConcatenation {

    override def ++(string: SingleStringConcatenation): SingleStringConcatenation =
      string match {
        case SingleStringSeq(strings) =>
          SingleStringSeq(this +: strings)
        case _                        =>
          SingleStringSeq(Seq(this, string))
      }
  }
}
