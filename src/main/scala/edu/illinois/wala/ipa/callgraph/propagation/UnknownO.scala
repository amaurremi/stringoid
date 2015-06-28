package edu.illinois.wala.ipa.callgraph.propagation

import com.ibm.wala.util.collections.EmptyIterator
import edu.illinois.wala.Facade._

object unknownO extends O {
  override def getConcreteType() = null
  override def getCreationSites(cg: G) = EmptyIterator.instance()

  override def toString = "UNKOWN object"
}