package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.CgNodes
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.cast.java.ssa.AstJavaInvokeInstruction
import com.ibm.wala.dataflow.graph.BitVectorIdentity
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ipa.callgraph.{CGNode, CallGraph}
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa._
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph

import scala.collection.JavaConversions._

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  protected type BB = BasicBlockInContext[IExplodedBasicBlock]

  def callGraph: CallGraph

  def acyclicCFG: ExplodedInterproceduralCFG

  def getCallBlocks(callee: BB): Iterator[BB]

  protected lazy val identifierToAsbo: Map[Identifier, Set[ASBO]] =
    TimeResult("ID-to-ASBO map", {
      val solver = new InterProcAsboFixedPointSolver(abstractObjectNumbering)
      val result = getResult(solver)
      (for {
        id <- solver.valueNumberGraph
        intSet <- Option((result getOut id).getValue)
        i2a = intSetToAsbo(intSet, solver.abstractObjectNumbering)
      } yield id -> i2a).toMap[Identifier, Set[ASBO]]
    })

  private[this] def abstractObjectNumbering: AsboMapping = {
    val numberingIterator: Iterator[ASBO] = callGraph.iterator flatMap {
      node =>
        createAbstractObjectNumbering(CallGraphNode(node))
    }
    createAbstractObjectMapping(numberingIterator)
  }

  /**
    * Do the arguments passed into a call have ASBOS? If yes, get them, together with the argument index
    */
  protected def argumentAsbos(
    idToAsbo: Map[Identifier, Set[ASBO]],
    instr: SSAAbstractInvokeInstruction,
    node: Node
  ): Seq[(ASBO, Int)] =
    instr match {
      case inv: SSAInvokeInstruction     =>
        argumentAsbosForInstr(idToAsbo, instr.getNumberOfParameters, instr.getUse, node)
      case inv: AstJavaInvokeInstruction =>
        argumentAsbosForInstr(idToAsbo, instr.getNumberOfParameters, instr.getUse, node)
    }

  protected def argumentAsbosForInstr(
    idToAsbo: Map[Identifier, Set[ASBO]],
    paramNum: Int,
    getArg: Int => ValueNumber,
    node: Node
  ): Seq[(ASBO, Int)] =
    for {
      argIndex <- 0 until paramNum
      arg       = getArg(argIndex)
      asbo     <- (idToAsbo getOrElse (createIdentifier(arg, node), Set(createAsbo(arg, node)))).toSeq
    } yield (asbo, argIndex)

  protected def getCallInstructions(
    callerNode: Node,
    calleeNode: Node
  ): Iterator[SSAAbstractInvokeInstruction] = {
    val node = callerNode.node
    for {
      callSiteRef <- node.iterateCallSites()
      if callSiteRef.getDeclaredTarget == calleeNode.node.getMethod.getReference
      callSite <- node.getIR getCalls callSiteRef
    } yield callSite
  }

  class InterProcAsboFixedPointSolver(numbering: AsboMapping) extends AsboFixedPointSolver(numbering) {

//    override def getDef(id: Identifier): SSAInstruction =
//      CallGraphNode(id.node).getDu getDef id.vn
//
//    override def getUses(id: Identifier): Iterator[SSAInstruction] =
//      CallGraphNode(id.node).getDu getUses id.vn

      override def getDef(id: Identifier): SSAInstruction = id.node.getDU getDef id.vn

      override def getUses(id: Identifier): Iterator[SSAInstruction] = id.node.getDU getUses id.vn

      lazy val valueNumberGraph: Graph[Identifier] = {
        // 1 = new SB();
        // 2 = 1.append(3);
        // ...
        // 4 = 1.append(5);
        // For this case, we need to add three nodes that contain VN 1, and the nodes need to be connected with each other.
        // Since append is mutable (it changes 1's object) we cannot connect the nodes to the first node where 1 is defined.
        // So we need to remember the previous instruction that appended something to 1, which is the purpose of this map.
        // todo test this case in unit tests
        val graph = new SlowSparseNumberedGraph[Identifier](1)
        acyclicCFG.iterator foreach {
          bb =>
            val node = bb.getNode
            def addNode(vn: ValueNumber, n: CGNode = node) {
              val id = createIdentifier(vn, CallGraphNode(n))
              if (!(graph containsNode id)) graph addNode id
            }
            def addEdge(sourceVn: ValueNumber, targetVn: ValueNumber, sourceNode: CGNode = node, targetNode: CGNode = node) {
              addNode(sourceVn, sourceNode)
              addNode(targetVn, targetNode)
              graph addEdge(
                createIdentifier(sourceVn, CallGraphNode(sourceNode)),
                createIdentifier(targetVn, CallGraphNode(targetNode)))
            }

            bb.getLastInstruction match {
              // intra-procedural
              case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)     =>
                getDefs(inv) foreach {
                  vn =>
                    addNode(vn)
                }
              case inv: SSAAbstractInvokeInstruction if isSbAppend(inv)          =>
                val (firstDef, secondDef) = getSbAppendDefs(inv) // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
                addEdge(secondDef, firstDef)
              case inv: SSAAbstractInvokeInstruction if isSbTostring(inv) => // in 1 = 2.toString, 1 is sbDef and 2 is sbUse
                val sbDef = getSbToStringDef(inv)
                val sbUse = getSbToStringUse(inv)
                addEdge(sbUse, sbDef)
              case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)      =>
                addNode(inv.getDef)
              case inv: SSAAbstractInvokeInstruction if hasStringReturnType(inv) =>
                addNode(inv.getDef)

              // inter-procedural
              case inv: SSAAbstractInvokeInstruction                             =>
                val targets       = callGraph getSuccNodes node
                val argsAndParams = getArgsAndParams(inv)
                for {
                  callTarget   <- targets
                  if inv.getDeclaredTarget == callTarget.getMethod.getReference
                  (arg, param) <- argsAndParams
                } {
                  addEdge(param, arg, sourceNode = callTarget, targetNode = node)
                }
              case ret: SSAReturnInstruction                                     =>
                val retDef = ret.getDef
                if (retDef > 0) {
                  for {
                    callBlock    <- getCallBlocks(bb)
                    callInstr     = callBlock.getLastInstruction.asInstanceOf[SSAAbstractInvokeInstruction]
                    mutable       = isMutable(callInstr.getDeclaredResultType)
                    if mutable || hasPrimitiveReturnType(callInstr) || hasStringReturnType(callInstr)
                  } {
                    addEdge(callInstr.getDef, retDef, callBlock.getNode, node)
                  }
                }
              case _ =>
              // do  nothing
            }
        }

        // add phi edges, since CFG does not contain phi instructions
        // todo or does it?
        for {
          node   <- callGraph
          instr  <- node.getIR.iteratePhis
          phi    = instr.asInstanceOf[SSAPhiInstruction]
          defId  = createIdentifier(phi.getDef, CallGraphNode(node))
          use    <- getPhiUses(phi)
          useId  = createIdentifier(use, CallGraphNode(node))
        } {
          if (!(graph containsNode defId)) graph addNode defId
          if (!(graph containsNode useId)) graph addNode useId
          graph addEdge (useId, defId)
        }

        graph
      }

      private[this] def getArgsAndParams(
        inv: SSAAbstractInvokeInstruction
      ): Seq[(ValueNumber, ValueNumber)] =
        0 until inv.getNumberOfParameters map {
          argIndex =>
            (inv getUse argIndex, argIndex + 1)
        }

      class InterStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

        def getNodeTransferFunction(id: Identifier): UnaryOperator[BitVectorVariable] = {
          getDef(id) match {
            case instr if isSbConstructorOrFormatInDefUse(instr) =>
              createOperator(id)
            case instr if pointsToPhi(id) && !isPhiDef(id)       =>
              createOperator(id)
            case _ if isParameter(id)                            =>
              val tpe = getTypeAbstraction(id.node.getIR, valNum(id))
              if (isMutable(tpe.getTypeReference))
                createOperator(id)
              else
                BitVectorIdentity.instance
            case instr: SSAAbstractInvokeInstruction
              if isMutable(instr.getDeclaredResultType) &&
                !isSbAppend(instr) &&
                !isSbConstructorWithStringParam(instr)           =>
              createOperator(id)
            case _                                               =>
              BitVectorIdentity.instance
          }
        }

        private[this] def isParameter(id: Identifier) = {
          valNum(id) <= id.node.getIR.getNumberOfParameters
        }
      }

      override def getTransferFunctions: StringBuilderTransferFunctions = new InterStringBuilderTransferFunctions
    }
}
