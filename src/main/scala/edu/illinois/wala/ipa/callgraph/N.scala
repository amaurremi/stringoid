package edu.illinois.wala.ipa.callgraph

import com.ibm.wala.ipa.callgraph.{CGNode, Context, ContextKey}
import com.ibm.wala.ssa.IR
import edu.illinois.wala.Facade._
import edu.illinois.wala.S
import edu.illinois.wala.ssa.V

import scala.collection.JavaConverters._

object N {
  def unapply(n: N): Option[(Context, M)] = {
    Some(n.getContext(), n.getMethod())
  }
}

class RichN(n: CGNode) {
  def prettyPrint: String =
    n.getMethod().prettyPrint

  def instructions =
    normalInstructions

  def normalInstructions =
    (ir.map { _.iterateNormalInstructions.asScala }).getOrElse(Iterator())

  def getV(name: String): V =
    valuesForVariableName(name).head

  def valuesForVariableName(name: String): Iterable[V] =
    instructions.map(i => S(n, i).valuesForVariableName(name).toSet).reduce(_ ++ _)

  def variableNames(value: V): Set[String] =
    instructions.map(i => S(n, i).variableNames(value).toSet).reduce(_ ++ _)

  def ir: Option[IR] =
    Option(n.getIR())

  def m: M =
    n.getMethod()

  def c(k: ContextKey) =
    n.getContext().get(k)
}

  
