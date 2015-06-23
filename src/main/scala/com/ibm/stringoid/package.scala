package com.ibm

package object stringoid {

  type GrepUrl = String
  type WalaUrl = String

  type WalaUrls = Map[WalaUrl, Set[String]]
}
