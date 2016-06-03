package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.SSAAbstractInvokeInstruction
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.util.graph.Acyclic
import com.ibm.wala.util.intset.IntPair

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

trait CFG extends InterProcASBOModule {

  type ExplodedNode = (BB, ASBO)

  type Worklist = mutable.Queue[ExplodedNode]

  private[this] type BasicBlock = BasicBlockInContext[IExplodedBasicBlock]

  private[this] val cfg: ExplodedInterproceduralCFG = ExplodedInterproceduralCFG.make(callGraph)

  private[this] lazy val backEdges: Set[IntPair] =
    (callGraph.getEntrypointNodes flatMap {
      entryNode =>
        val entry = cfg getEntry entryNode
        Acyclic.computeBackEdges(cfg, entry)
    })(breakOut)

  // todo in `BB`, I'm not checking back edges in all of the methods. that can probably lead to problems
  // todo the better way to do this would be to create a new acyclic CFG out of intraprocedural pruned CFGs
  private[this] def isBackEdge(src: BasicBlock, target: BasicBlock): Boolean =
    backEdges contains new IntPair(src.getNumber, target.getNumber)

  case class BB(bb: BasicBlock) {

    override def toString = "BB " + bb.getLastInstruction.toString

    def getNode = bb.getNode

    def instruction = bb.getLastInstruction

    def getSuccNodes: Iterator[BB] =
      cfg getSuccNodes bb collect {
        case succ if !isBackEdge(bb, succ) =>
          BB(succ)
      }

    def getCallTargets = cfg getCallTargets bb

    def getCallSites(callee: CGNode) = cfg getCallSites (bb, callee) map BB.apply

    def getReturnSites = cfg getReturnSites bb map BB.apply
  }

  def getEntry(node: CGNode) = BB(cfg getEntry node)

  // todo is this right?
  def initializeWorklist(idToAsbo: Map[Identifier, Set[ASBO]]): Worklist = {

    val worklist = mutable.Queue.empty[ExplodedNode]

    def getEntry(node: CGNode) = cfg getEntry node

    cfg foreach {
      bb =>

        def addToWl(sbDef: ValueNumber): Unit = {
          val asbos = idToAsbo(createIdentifier(sbDef, CallGraphNode(bb.getNode)))
          asbos foreach {
            asbo =>
              worklist enqueue ((BB(bb), asbo))
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
