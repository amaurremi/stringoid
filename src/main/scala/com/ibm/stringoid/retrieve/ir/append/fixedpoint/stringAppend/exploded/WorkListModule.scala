package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.wala.util.collections.Heap
import com.ibm.wala.util.graph.traverse.Topological

import scala.collection.JavaConversions._

trait WorkListModule extends CFG {

  class WorkList(cfg: AcyclicCfg) extends Heap[ExplodedNode](1) {

    def nonEmpty: Boolean = !isEmpty

    private[this] lazy val nodeToOrderNumber: Map[BB, Int] = {
      val order = Topological.makeTopologicalIter(cfg.graph)
      val (nodeToNum, _) = order.foldLeft((Map.empty[BB, Int], 0)) {
        case ((oldMap, oldNum), bb) =>
          (oldMap + (bb -> oldNum), oldNum + 1)
      }
      nodeToNum
    }

    override def compareElements(elt1: ExplodedNode, elt2: ExplodedNode): Boolean = {
      val topologicalNum1 = nodeToOrderNumber(elt1._1)
      val topologicalNum2 = nodeToOrderNumber(elt2._1)
      if (topologicalNum1 == topologicalNum2) {
        assert(elt1._2.identifier.node == elt2._2.identifier.node)
        elt1._2.identifier.vn < elt2._2.identifier.vn
      }
      else topologicalNum1 < topologicalNum2
    }
  }

}
