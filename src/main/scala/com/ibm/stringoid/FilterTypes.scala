package com.ibm.stringoid

import scopt.Read

trait FilterTypes {

  object FilterType extends Enumeration {
    type FilterType = Value
    val Identity = Value("id")

    implicit val filterTypeRead: scopt.Read[FilterType] =
      Read.reads(FilterType.withName)
  }
}