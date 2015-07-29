package com.ibm.stringoid.retrieve.ir.append

trait AppendUrl {

  case class UrlSeq(url: Seq[UrlPart]) {
    override def toString =
      url mkString ""
  }

  sealed trait UrlPart
  case class UrlString(string: String) extends UrlPart {
    override def toString = string
  }
  case class UrlPhi(urls: Set[UrlSeq]) extends UrlPart
  case object UrlPlaceHolder extends UrlPart {
    override def toString = "�"
  }
  case object UrlWithCycle extends UrlPart
}
