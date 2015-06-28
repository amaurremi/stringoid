package edu.illinois.wala.ipa.callgraph.propagation

import com.ibm.wala.ipa.callgraph.propagation.{AllocationSiteInNode, InstanceKey}
import edu.illinois.wala.Facade._
import edu.illinois.wala.S
import edu.illinois.wala.classLoader.{CodeLocation, ProgramCounter}

object O {
  import edu.illinois.wala.Facade._

  def unapply(o: O): Option[(N, I)] = {
    o match {
      case o: AllocationSiteInNode => Some(o.getNode(), o.getNode().getIR().getNew(o.getSite()))
      case _ => None
    }
  }
}

trait WrapO {
  implicit def wrapAllocationSiteInNode(o: AllocationSiteInNode): RichAllocationSiteInNode = new RichAllocationSiteInNode(o)
  implicit def wrapStaticClassObject(o: StaticClassObject): RichStaticClassObject = new RichStaticClassObject(o)
  implicit def wrapO(o: InstanceKey): RichO = new RichO(o)
}

class RichAllocationSiteInNode(val o: AllocationSiteInNode) extends AnyVal {
  def prettyPrint: String = o.getConcreteType().prettyPrint + ": " +
    (ProgramCounter(o.getSite().getProgramCounter()) map { CodeLocation(n.m, _) } getOrElse "")
  //    (if (debug.detailContexts) " --- " + o.getNode().getContext() else "")

  def n = o.getNode

  def lineNo = n.m.lineNo(o.getSite())
}

class RichStaticClassObject(val o: StaticClassObject) extends AnyVal {
  def prettyPrint: String = "Static: " + o.klass.prettyPrint
}

class RichO(val o: InstanceKey) extends AnyVal {
  def prettyPrint: String = {
    (o match {
      case o: AllocationSiteInNode => o.prettyPrint
      case o: StaticClassObject => o.prettyPrint
      case _ => o.toString
    })
  }
  def s: Option[S[I]] = o match {
    case o: AllocationSiteInNode => Some(S(o.getNode, o.getNode.getIR.getNew(o.getSite)))
    case _ => None
  }
}