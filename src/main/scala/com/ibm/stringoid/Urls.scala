package com.ibm.stringoid

import com.ibm.wala.ipa.callgraph.{CGNode, CallGraph}
import com.ibm.wala.ssa.SymbolTable
import java.net.URL
import scala.util.Try

import scala.collection.JavaConversions._
import scala.collection.breakOut

class Urls(cg: CallGraph) {

  def findStrings: Seq[String] = {
    (for {
      node  <- cg
      table <- optTable(node).toSeq
      v     <- 1 to table.getMaxValueNumber
      if table.isStringConstant(v)
    } yield {
      table.getStringValue(v)
    })(breakOut)
  }

  def findUrls: Seq[String] = findStrings filter {
    str =>
      Try(new URL(str)).isSuccess
  }

  private[this] def optTable(node: CGNode): Option[SymbolTable] =
    Option(node.getIR) flatMap {
      ir =>
        Option(ir.getSymbolTable)
    }
}
