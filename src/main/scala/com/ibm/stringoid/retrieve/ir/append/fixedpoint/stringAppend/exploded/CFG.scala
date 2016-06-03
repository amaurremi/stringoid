package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.pruned.PrunedCallGraph
import com.ibm.wala.ipa.callgraph.{CGNode, CallGraph}
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.SSAAbstractInvokeInstruction
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph
import com.ibm.wala.util.graph.{Acyclic, NumberedGraph}
import com.ibm.wala.util.intset.IntPair

import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import scala.collection.mutable

trait CFG extends InterProcASBOModule {

  protected type BB = BasicBlockInContext[IExplodedBasicBlock]

  type ExplodedNode = (BB, ASBO)

  type Worklist = mutable.Queue[ExplodedNode]

  object AcyclicCfg {

    private[this] lazy val acyclicCallGraph: CallGraph = {
      val pruned = new PrunedCallGraph(callGraph, callGraph.iterator.toSet.asJava)
      val backEdges = pruned.getEntrypointNodes flatMap {
        entry =>
          Acyclic.computeBackEdges(callGraph, entry)
      }
      backEdges foreach {
        edge =>
          pruned.removeEdge(pruned getNode edge.getX, pruned getNode edge.getY)
      }
      pruned
    }

    /**
      * Creates an acyclic inter-procedural CFG:
      * - creates an acyclic call graph
      * - creates an inter-procedural CFG based on that call graph;
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
      val acyclicInterprocCFG: ExplodedInterproceduralCFG = ExplodedInterproceduralCFG.make(acyclicCallGraph)

      for {
        cgNode   <- acyclicCallGraph
        intraCfg  = acyclicInterprocCFG getCFG cgNode // intra-procedural CFG with cycles
        backEdges = Acyclic.computeBackEdges(intraCfg, intraCfg.entry).toSet
        bb       <- intraCfg
        src       = new BasicBlockInContext[IExplodedBasicBlock](cgNode, bb)
      } {
        // adding intra-procedural edges
        for {
          succ <- (intraCfg getNormalSuccessors bb) ++ (intraCfg getExceptionalSuccessors bb) // todo should this just be replaced with getSuccNodes?
          if !(backEdges contains new IntPair(bb.getNumber, succ.getNumber))
          dst   = new BasicBlockInContext[IExplodedBasicBlock](cgNode, succ)
        } addEdge(src, dst)

        // adding inter-procedural edges
        bb match {
          case instr: SSAAbstractInvokeInstruction =>
            val targets = acyclicInterprocCFG getCallTargets src
            targets foreach {
              target =>
                addEdge(src, acyclicInterprocCFG getEntry target)
            }
          case _ =>
            ()
        }
      }
      new AcyclicCfg(graph, acyclicInterprocCFG)
      })
  }

  /**
    * @param acyclicInterProcCFG Note that this CFG is acyclic inter-procedurally, but can have cycles inside procedures
    */
  class AcyclicCfg private[CFG](graph: NumberedGraph[BB], acyclicInterProcCFG: ExplodedInterproceduralCFG) {

    def getSuccNodes(bb: BB): Iterator[BB] = graph getSuccNodes bb

    def getCallTargets(bb: BB) = acyclicInterProcCFG getCallTargets bb

    def getCallSites(bb: BB, callee: CGNode) = acyclicInterProcCFG getCallSites (bb, callee)

    def getEntry(node: CGNode): BB = acyclicInterProcCFG getEntry node

    def getReturnSites(bb: BB): Iterator[BB] = acyclicInterProcCFG getReturnSites bb

    def nodesIterator: Iterator[BB] = graph.iterator()
  }

  // todo is this right?
  def initializeWorklist(cfg: AcyclicCfg, idToAsbo: Map[Identifier, Set[ASBO]]): Worklist = {

    val worklist = mutable.Queue.empty[ExplodedNode]

    cfg.nodesIterator foreach {
      bb =>

        def addToWl(sbDef: ValueNumber): Unit = {
          val asbos = idToAsbo(createIdentifier(sbDef, CallGraphNode(bb.getNode)))
          asbos foreach {
            asbo =>
              worklist enqueue ((bb, asbo))
          }
        }

        bb.getLastInstruction match {
          case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                     =>
            addToWl(getFirstSbAppendDef(instr))
          case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
            addToWl(getSbConstructorDef(instr))
          case instr: SSAAbstractInvokeInstruction if isStringFormat(instr)                 =>
            addToWl(instr.getDef)
          case _                                                                            =>
            ()
        }
    }
    worklist
  }
}
