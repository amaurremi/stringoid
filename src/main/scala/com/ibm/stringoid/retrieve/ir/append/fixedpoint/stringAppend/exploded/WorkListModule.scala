package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.util.collections.Heap
import com.ibm.wala.util.graph.traverse.Topological

import scala.collection.JavaConversions._

trait WorkListModule extends CFG {

  class WorkList(cfg: AcyclicCfg) extends Heap[ExplodedNode](1) {

    def nonEmpty: Boolean = !isEmpty

    private[this] lazy val cgNodeToOrderNum: Map[CGNode, Int] = {
      val order = Topological.makeTopologicalIter(callGraph)
      nodeToNum(order)
    }

    private[this] lazy val bbToOrderNum: Map[BB, Int] = {
      val order = Topological.makeTopologicalIter(cfg.acyclicIntraCfgs)
      nodeToNum(order)
    }

    private[this] def nodeToNum[T](order: Iterator[T]) = {
      val (nodeToNum, _) = order.foldLeft((Map.empty[T, Int], 0)) {
        case ((oldMap, oldNum), node) =>
          (oldMap + (node -> oldNum), oldNum + 1)
      }
      nodeToNum
    }

    override def compareElements(elt1: ExplodedNode, elt2: ExplodedNode): Boolean = {
      val cgNum1 = cgNodeToOrderNum(elt1._1.getNode)
      val cgNum2 = cgNodeToOrderNum(elt2._1.getNode)
      if (cgNum1 == cgNum2) {
        val topologicalNum1 = bbToOrderNum(elt1._1)
        val topologicalNum2 = bbToOrderNum(elt2._1)
        if (topologicalNum1 == topologicalNum2) {
          val idNode1 = elt1._2.identifier.node
          val idNode2 = elt2._2.identifier.node
          if (idNode1 == idNode2) elt1._2.identifier.vn < elt2._2.identifier.vn
          else (callGraph getNumber idNode1) < (callGraph getNumber idNode2)
        }
        else topologicalNum1 < topologicalNum2
      } else cgNum1 < cgNum2
    }
  }
}
