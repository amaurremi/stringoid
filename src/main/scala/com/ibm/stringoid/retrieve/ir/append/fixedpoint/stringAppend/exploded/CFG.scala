package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.cfg.ControlFlowGraph
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInstruction}
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.graph.{Acyclic, NumberedGraph}
import com.ibm.wala.util.intset.IntPair

import scala.collection.JavaConversions._
import scala.collection.mutable

trait CFG extends InterProcASBOModule {

  protected type BB = BasicBlockInContext[IExplodedBasicBlock]

  type ExplodedNode = (BB, ASBO)

  object AcyclicCfg {

    // map from call graph nodes to intraprocedural (possibly cyclic) CFGs
    private val intraCfgCache = mutable.Map[Int, ControlFlowGraph[SSAInstruction, IExplodedBasicBlock]]()

    /**
      * Creates an acyclic inter-procedural CFG:
      * - creates an inter-procedural CFG based on the acyclic call graph;
      *   this graph has acyclic inter-procedural and possibly cyclic intra-procedural edges
      * - for each intra-procedural sub-CFG, computes back-edges, and puts the non-back-edges into the result graph,
      *   thus creating a graph of disconnected acyclic sub-CFGs
      * - adds all inter-procedural edges into the result graph, yielding an inter-procedural acyclic CFG
      */
    def apply(): AcyclicCfg = TimeResult("acyclic CFG", {
      val graph = new SlowSparseNumberedGraph[BB](1)

      def addEdge(src: BB, dst: BB): Unit = {
        if (!(graph containsNode src)) graph addNode src
        if (!(graph containsNode dst)) graph addNode dst
        graph addEdge (src, dst)
      }

      // CFG with acyclic inter-procedural and possibly cyclic intra-procedural edges
      val acyclicInterprocCFG: ExplodedInterproceduralCFG =
        TimeResult("inter-procedurally acyclic CFG (can have intra-procedural cycles)",
          ExplodedInterproceduralCFG.make(callGraph))

      for {
        cgNode   <- callGraph
        num       = callGraph getNumber cgNode
        intraCfg  = intraCfgCache getOrElseUpdate (num, acyclicInterprocCFG getCFG cgNode) // intra-procedural CFG with cycles
        if Option(intraCfg).isDefined
        backEdges = Acyclic.computeBackEdges(intraCfg, intraCfg.entry).toSet
        bb       <- intraCfg
        src       = new BasicBlockInContext[IExplodedBasicBlock](cgNode, bb)
      } {

        // todo is that the right way of adding intra- and especially inter-procedural edges?

        // adding intra-procedural edges
        for {
          succ <- intraCfg getSuccNodes bb
          if !(backEdges contains new IntPair(bb.getNumber, succ.getNumber))
          dst   = new BasicBlockInContext[IExplodedBasicBlock](cgNode, succ)
        } addEdge(src, dst)

        // adding inter-procedural edges
        bb.getLastInstruction match {
          // call-to-start
          case instr: SSAAbstractInvokeInstruction                =>
            val targets = acyclicInterprocCFG getCallTargets src
            targets foreach {
              case target if Option(target.getIR).isDefined =>
                addEdge(src, acyclicInterprocCFG getEntry target)
              case _                                        =>
                ()
            }
          // end-to-return
          // todo I'm especially unsure about this part
          case instr if instr == intraCfg.exit.getLastInstruction =>
            val targets = acyclicInterprocCFG getSuccNodes src
            targets foreach {
              addEdge(src, _)
            }
          case _ =>
            ()
        }
      }

      new AcyclicCfg(graph, acyclicInterprocCFG)
      })
  }

  /**
    * @param graph               The fully acyclic CFG that we constructed
    * @param acyclicInterProcCFG This CFG is acyclic inter-procedurally, but can have cycles inside procedures.
    *                            We use this CFG because it has convenient methods for traversing the CFG which we
    *                            don't have in [[graph]], because it's just a [[NumberedGraph]].
    */
  class AcyclicCfg private[CFG](graph: NumberedGraph[BB], acyclicInterProcCFG: ExplodedInterproceduralCFG) {

    import AcyclicCfg.intraCfgCache

    def getSuccNodes(bb: BB): Iterator[BB] = graph getSuccNodes bb

    def getPredNodes(bb: BB): Iterator[BB] = graph getPredNodes bb

    // todo this method takes a lot of time
    def getCallTargets(bb: BB) = acyclicInterProcCFG getCallTargets bb

    // todo this method takes a lot of time and seems overly complicated for what it does, but I don't know how else to do it. Is this right?
    /**
      * @return the basic blocks of the call sites that invoke `callee`
      */
    def getCallBlocks(callee: BB): Iterator[BB] =
      for {
        caller   <- callGraph getPredNodes callee.getNode
        intraCfg  = intraCfgCache(callGraph getNumber caller)
        bb       <- intraCfg
        instr     = bb.getLastInstruction
        if instr.isInstanceOf[SSAAbstractInvokeInstruction]
        callBlock = new BasicBlockInContext(caller, bb)
        if acyclicInterProcCFG getCallTargets callBlock contains callee.getNode
      } yield callBlock

    def getEntry(node: CGNode): BB = acyclicInterProcCFG getEntry node

    def getReturnSites(bb: BB): Iterator[BB] = acyclicInterProcCFG getReturnSites bb

    def nodesIterator: Iterator[BB] = graph.iterator()
  }
}
