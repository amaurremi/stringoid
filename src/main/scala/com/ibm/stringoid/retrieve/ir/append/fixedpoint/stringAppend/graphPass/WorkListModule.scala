package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.graphPass

import com.ibm.wala.util.collections.Heap
import com.ibm.wala.util.graph.traverse.Topological

import scala.collection.JavaConversions._

trait WorkListModule extends CFG {

  type ExplodedNode = (BB, ASBO)

  class WorkList extends Heap[ExplodedNode](1) {

    def nonEmpty: Boolean = !isEmpty

    private[this] lazy val nodeToOrderNum: Map[BB, Int] = {
      val order = Topological.makeTopologicalIter(acyclicCFG)
      val (nodeToNum, _) = order.foldLeft((Map.empty[BB, Int], 0)) {
        case ((oldMap, oldNum), node) =>
          (oldMap + (node -> oldNum), oldNum + 1)
      }
      nodeToNum
    }

    override def compareElements(elt1: ExplodedNode, elt2: ExplodedNode): Boolean = {
      val topologicalNum1 = nodeToOrderNum(elt1._1)
      val topologicalNum2 = nodeToOrderNum(elt2._1)
      if (topologicalNum1 == topologicalNum2) {
        val idNode1 = elt1._2.identifier.node
        val idNode2 = elt2._2.identifier.node
        if (idNode1 == idNode2) elt1._2.identifier.vn < elt2._2.identifier.vn
        else (callGraph getNumber idNode1) < (callGraph getNumber idNode2)
      }
      else topologicalNum1 < topologicalNum2
    }
  }
}
