/** *****************************************************************************
  * Copyright (c) 2015 IBM Corporation.
  * All rights reserved. This program and the accompanying materials
  * are made available under the terms of the Eclipse Public License v1.0
  * which accompanies this distribution, and is available at
  * http://www.eclipse.org/legal/epl-v10.html
  *
  * @author Philippe Suter
  *         https://github.com/psuter/trie
  * ******************************************************************************/

package com.ibm.stringoid.util

import scala.annotation.tailrec

// An immutable datastructure for sets of sequences of A.
sealed trait Trie[A] {
  // Whether the trie contains any sequence.
  def isEmpty: Boolean

  // The number of distinct sequences contained in the trie.
  def size: Int

  // Computes a new trie which additionnally includes `s`.
  def +(s: Seq[A]): Trie[A]

  // Computes a trie representing the product of all concatenations.
  def +++(t: Trie[A]): Trie[A]

  // Computes the union of two tries.
  def |(t: Trie[A]): Trie[A]

  // Checks whether a sequence is contained in the Trie.
  def contains(s: Seq[A]): Boolean

  // An iterator returning all sequences encoded in thie Trie.
  def iterator: Iterator[Seq[A]]

  // The number of distinct nodes in the trie (aka. the number of distinct prefixes).
  def nodeCount: Int
}

object Trie {
  def empty[A]: Trie[A] = emptyNode[A]

  private def emptyNode[A] = Node[A](Map.empty[A, Node[A]], isTerminal = false)

  private case class Node[A](map: Map[A, Node[A]], isTerminal: Boolean) extends Trie[A] {
    def isEmpty: Boolean = !isTerminal && map.values.forall(_.isEmpty)

    def size: Int = map.values.foldLeft(0)(_ + _.size) + (if (isTerminal) 1 else 0)

    def nodeCount: Int = map.values.foldLeft(0)(_ + _.nodeCount) + 1

    @tailrec
    final def contains(s: Seq[A]): Boolean = if (s.isEmpty) {
      isTerminal
    } else {
      val sub: Option[Node[A]] = map.get(s.head)

      if (sub.isDefined) {
        sub.get.contains(s.tail)
      } else {
        false
      }
    }

    def +(s: Seq[A]): Node[A] = {
      if (s.isEmpty) {
        if (isTerminal) {
          this
        } else {
          Node(map, isTerminal = true)
        }
      } else {
        val h +: t = s
        val sub: Node[A] = map.getOrElse(h, emptyNode[A])
        val newSub = sub + t
        Node(map.updated(h, newSub), isTerminal)
      }
    }

    def +++(t: Trie[A]): Node[A] = {
      val withPostfixes = Node(map.mapValues(_ +++ t), isTerminal = false)

      if (isTerminal) {
        withPostfixes | t
      } else {
        withPostfixes
      }
    }

    def |(t: Trie[A]): Node[A] = {
      // FIXME ugly
      val that: Node[A] = t.asInstanceOf[Node[A]]

      val Node(m1, t1) = this
      val Node(m2, t2) = that

      val newKeys: Seq[A] = (m1.keySet ++ m2.keySet).toSeq
      val newMap: Map[A, Node[A]] = newKeys.map { k =>
        val v = (m1.get(k), m2.get(k)) match {
          case (Some(v1), None) => v1
          case (None, Some(v2)) => v2
          case (Some(v1), Some(v2)) => v1 | v2
          case (None, None) => assert(false); ???
        }

        k -> v
      }.toMap

      Node(newMap, t1 | t2)
    }

    def iterator: Iterator[Seq[A]] = {
      val base: Iterator[Seq[A]] = map.toIterator.flatMap { p =>
        p._2.iterator.map(t => p._1 +: t)
      }

      if (isTerminal) {
        Seq(Seq.empty[A]).toIterator ++ base
      } else {
        base
      }
    }
  }

}
