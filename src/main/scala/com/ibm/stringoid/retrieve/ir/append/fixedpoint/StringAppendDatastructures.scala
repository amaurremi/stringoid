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

    def myHashCode: Int

    override def hashCode(): Int = myHashCode

    def size: Long

    def headSize: Long

    def nodeNum: Long

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

    override lazy val flatten: Set[SingleStringConcatenation] =
      strings flatMap { _.flatten }

    override def size: Long =
      strings.foldLeft(0L) {
        (prevSize, string) =>
          prevSize + string.size
      }

    override lazy val myHashCode = strings.hashCode()

    override def headSize: Long =
      strings.foldLeft(0L) {
        (prevSize, string) =>
          prevSize + string.headSize
      }

    override def nodeNum: Long =
      strings.foldLeft(1L) {
        (prevSize, string) =>
          prevSize + string.nodeNum
      }
  }
  
  case class AltStringSeq(strings: Seq[AltStringConcatenation]) extends AltStringConcatenation {

    override def ++(string: AltStringConcatenation): AltStringConcatenation =
      string match {
        case AltStringSeq(strings2) =>
          AltStringSeq(strings ++ strings2)
        case _                      =>
          AltStringSeq(strings :+ string)
      }

    // simplify this method
    override lazy val flatten: Set[SingleStringConcatenation] =
      strings match {
        case Seq() =>
          Set.empty[SingleStringConcatenation]
        case head :: tail =>
          val flatHeadSets = head.flatten
          val flatTailSets = AltStringSeq(tail).flatten
          if (flatTailSets.isEmpty)
            flatHeadSets
          else
            flatHeadSets.foldLeft(Set.empty[SingleStringConcatenation]) {
              case (prevSet, string) =>
                val newStrings = flatTailSets map { string ++ _ }
                prevSet ++ newStrings
            }
      }

    override def size: Long =
      strings.foldLeft(1L) {
        (prevSize, string) =>
          prevSize * string.size
      }

    override lazy val myHashCode: Int = strings.hashCode()

    override def headSize: Long =
      if (strings.isEmpty)
        0
      else strings.head.headSize

    override def nodeNum: Long =
      strings.foldLeft(1L) {
        (prevSize, string) =>
          prevSize + string.nodeNum
      }
  }

  case class AltAppendArgument(vn: ValueNumber) extends AltStringConcatenation {

    override lazy val flatten: Set[SingleStringConcatenation] = Set(SingleAppendArgument(vn))

    override def size: Long = 1

    override lazy val myHashCode: Int = vn.hashCode()

    override def headSize: Long = 1

    override def nodeNum: Long = 1
  }

  case object AltCycle extends AltStringConcatenation {

    override def |(string: AltStringConcatenation): AltStringConcatenation = AltCycle

    override def ++(string: AltStringConcatenation): AltStringConcatenation = AltCycle

    override lazy val flatten: Set[SingleStringConcatenation] = Set(SingleCycle)

    override def size: Long = 1

    override lazy val myHashCode = "AltCycle".hashCode

    override def headSize: Long = 1

    override def nodeNum: Long = 1
  }

  /**
   * A data structure for the representation of a single string (without alternatives).
   */
  sealed trait SingleStringConcatenation extends StringConcatenation[SingleStringConcatenation]

  case class SingleStringList(strings: List[SingleStringConcatenation]) extends SingleStringConcatenation {

    override def ++(string: SingleStringConcatenation): SingleStringConcatenation =
      string match {
        case SingleStringList(strings2) =>
          SingleStringList(strings ++ strings2)
        case _                         =>
          SingleStringList(strings :+ string)
      }
  }

  case class SingleAppendArgument(vn: ValueNumber) extends SingleStringConcatenation {

    override def ++(string: SingleStringConcatenation): SingleStringConcatenation =
      string match {
        case SingleStringList(strings) =>
          SingleStringList(this +: strings)
        case _                        =>
          SingleStringList(List(this, string))
      }
  }

  case object SingleCycle extends SingleStringConcatenation {

    override def ++(string: SingleStringConcatenation): SingleStringConcatenation = SingleCycle
  }
}
