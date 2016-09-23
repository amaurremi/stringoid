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
import scala.collection.mutable

trait InterProcASBOModule extends AbstractStringBuilderModule with CgNodes {

  protected type BB = BasicBlockInContext[IExplodedBasicBlock]

  def callGraph: CallGraph

  def acyclicCFG: ExplodedInterproceduralCFG

  def getCallBlocks(callee: BB): Iterator[BB] = {
    val entry = acyclicCFG getEntry callee.getNode
    acyclicCFG getPredNodes entry
  }

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

  protected def createAbstractObjectNumbering(node: Node): Iterator[ASBO] = {
    val ir = node.getIr
    if (Option(ir).isDefined) {
      val abstractObjects = ir.iterateAllInstructions() flatMap {
        case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv) =>
          Iterator(createAsbo(getSbConstructorDef(inv), node))
        case inv: SSAAbstractInvokeInstruction if isStringFormat(inv) =>
          Iterator(createAsbo(inv.getDef, node))
        case inv: SSAAbstractInvokeInstruction =>
          getArgsAndParams(inv) map {
            case (arg, _) =>
              createAsbo(arg, node)
          }
        case phi: SSAPhiInstruction =>
          0 until phi.getNumberOfUses map {
            use =>
              createAsbo(phi getUse use, node)
          }
        case ret: SSAReturnInstruction =>
          Iterator(createAsbo(ret.getResult, node))
        case _ =>
          Iterator.empty
      }
      val params = 1 to ir.getSymbolTable.getNumberOfParameters collect {
        case vn if isMutable(getTypeAbstraction(ir, vn).getTypeReference) =>
          createAsbo(vn, node)
      }
      abstractObjects ++ params
    } else Iterator[ASBO]()
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

  protected def getArgsAndParams(
    inv: SSAAbstractInvokeInstruction
  ): Seq[(ValueNumber, ValueNumber)] = {
    val firstArg = if (inv.isStatic) 0 else 1 // exclusing `this`
    firstArg until inv.getNumberOfParameters map {
      argIndex =>
        (inv getUse argIndex, argIndex + 1)
    }
  }

  class InterProcAsboFixedPointSolver(numbering: AsboMapping) extends AsboFixedPointSolver(numbering) {

//    override def getDef(id: Identifier): SSAInstruction =
//      CallGraphNode(id.node).getDu getDef id.vn
//
//    override def getUses(id: Identifier): Iterator[SSAInstruction] =
//      CallGraphNode(id.node).getDu getUses id.vn

    override def getDef(id: Identifier): SSAInstruction = id.node.getDU getDef id.vn

    override def getUses(id: Identifier): Iterator[SSAInstruction] = id.node.getDU getUses id.vn

    // We need to store information about which identifiers are returned and which are passed into calls.
    val idInfo = mutable.Map.empty[Identifier, IdInfo] withDefaultValue IdInfo()

    case class IdInfo(isRet: Boolean = false, isArg: Boolean = false)

    private[this] def setIdInfoArg(id: Identifier): Unit = {
      idInfo(id) = idInfo(id).copy(isArg = true)
    }

    private[this] def setIdInfoRet(id: Identifier): Unit = {
      idInfo(id) = idInfo(id).copy(isRet = true)
    }

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

            // inter-procedural
            case inv: SSAAbstractInvokeInstruction                             =>
              val targets       = callGraph getSuccNodes node
              val argsAndParams = getArgsAndParams(inv)
              for {
                callTarget   <- targets
                if calls(bb, callTarget)
                (arg, param) <- argsAndParams
              } {
                setIdInfoArg(createIdentifier(arg, CallGraphNode(node)))
                addEdge(arg, param, sourceNode = node, targetNode = callTarget)
              }
            case ret: SSAReturnInstruction if ret.getResult > 0                 =>
              val retResult = ret.getResult
              setIdInfoRet(createIdentifier(retResult, CallGraphNode(node)))
                for {
                  callBlock    <- getCallBlocks(bb)
                  callInstr     = callBlock.getLastInstruction.asInstanceOf[SSAAbstractInvokeInstruction]
                  mutable       = isMutable(callInstr.getDeclaredResultType)
                  if mutable || hasPrimitiveReturnType(callInstr) || hasStringReturnType(callInstr)
                } {
                  addEdge(retResult, callInstr.getDef, node, callBlock.getNode)
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

    /* does the invoke instruction in `bb` call the target node? */
    private[this] def calls(bb: BB, target: CGNode): Boolean =
    acyclicCFG getSuccNodes bb exists {
      succ =>
        succ.getNode.getMethod.getReference == target.getMethod.getReference
    }


    class InterStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

        def getNodeTransferFunction(id: Identifier): UnaryOperator[BitVectorVariable] = {
          getDef(id) match {
            case instr if isSbConstructorOrFormatInDefUse(instr)    =>
              createOperator(id)
            case instr if pointsToPhi(id) && !isPhiDef(id)          =>
              createOperator(id)
            case _ if idInfo(id).isRet || idInfo(id).isArg          =>
              createOperator(id)
            case _                                                  =>
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
