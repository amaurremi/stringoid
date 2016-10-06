package com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.IrNodes
import com.ibm.wala.dataflow.graph._
import com.ibm.wala.fixpoint.{BitVectorVariable, UnaryOperator}
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInstruction, SSAPhiInstruction}
import com.ibm.wala.util.graph.Graph
import com.ibm.wala.util.graph.impl.SlowSparseNumberedGraph

import scala.collection.JavaConversions._
import scala.collection.breakOut

trait IntraProcASBOModule extends AbstractStringBuilderModule with IrNodes {

  protected final def asboSolver(node: Node): AsboFixedPointSolver =
    new IntraProcAsboFixedPointSolver(node, createAbstractObjectMapping(createAbstractObjectNumbering(node)))

  protected def createAbstractObjectNumbering(node: Node): Iterator[ASBO] = {
    val ir = node.getIr
    val abstractObjects = ir.iterateAllInstructions() flatMap {
      case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)                            =>
        Iterator(createAsbo(createId(getSbConstructorDef(inv), node)))
      case inv: SSAAbstractInvokeInstruction if isStringFormat(inv) || hasStringReturnType(inv) =>
        Iterator(createAsbo(createId(inv.getDef, node)))
      case phi: SSAPhiInstruction                                                               =>
        0 until phi.getNumberOfUses map {
          use =>
            createAsbo(createId(phi getUse use, node))
        }
      case _                                                                                    =>
        Iterator.empty
    }
    val params = 1 to ir.getSymbolTable.getNumberOfParameters collect {
      case vn if isMutable(getTypeAbstraction(ir, vn).getTypeReference) =>
        createAsbo(createId(vn, node))
    }

    abstractObjects ++ params
  }

  /**
    * The resulting map from value numbers to abstract StringBuilder objects
    */
  protected final def idToAsboForNode(node: Node): Map[Identifier, Set[ASBO]] =
  if (hasIr(node)) {
    val solver = asboSolver(node)
    val result = getResult(solver)
    (for {
      id <- solver.valueNumberGraph
      intSet <- Option((result getOut id).getValue)
      i2a = intSetToAsbo(intSet, solver.abstractObjectNumbering)
    } yield id -> i2a)(breakOut)
  } else Map.empty[Identifier, Set[ASBO]]

  class IntraProcAsboFixedPointSolver(
    node: Node,
    numbering: AsboMapping
  ) extends AsboFixedPointSolver(numbering) {

    override def getDef(id: ValueNumber): SSAInstruction = node.getDu getDef id

    override def getUses(id: Identifier): Iterator[SSAInstruction] = node.getDu getUses id

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
      def addNode(vn: ValueNumber) {
        val n = createId(vn, node)
        if (!(graph containsNode n)) graph addNode n
      }
      def addEdge(source: ValueNumber, target: ValueNumber) {
        val sourceN = createId(source, node)
        val targetN = createId(target, node)
        addNode(source)
        addNode(target)
        graph addEdge(sourceN, targetN)
      }
      node.getIr.iterateAllInstructions() foreach {
        // todo remove just adding nodes?
        case inv: SSAAbstractInvokeInstruction if isSbConstructor(inv)     =>
          getDefs(inv) foreach addNode
        case inv: SSAAbstractInvokeInstruction if isSbAppend(inv)          =>
          val (firstDef, secondDef) = getSbAppendDefs(inv)                    // in 1 = 2.append(3), 1 is firstDef and 2 is secondDef
          addEdge(secondDef, firstDef)
        case inv: SSAAbstractInvokeInstruction if isSbTostring(inv)        => // in 1 = 2.toString, 1 is sbDef and 2 is sbUse
          val sbDef = getSbToStringDef(inv)
          val sbUse = getSbToStringUse(inv)
          addEdge(sbUse, sbDef)
        case inv: SSAAbstractInvokeInstruction if isStringFormat(inv)      =>
          addNode(inv.getDef)
        case inv: SSAAbstractInvokeInstruction if hasStringReturnType(inv) =>
          addNode(inv.getDef)
        case phi: SSAPhiInstruction                                        =>
          val defNode = phi.getDef
          addNode(defNode)
          getPhiUses(phi) foreach {
            use =>
              addEdge(use, defNode)
          }
        case _                                                             =>
        // do  nothing
      }

      graph
    }

    class IntraStringBuilderTransferFunctions extends StringBuilderTransferFunctions {

      def getNodeTransferFunction(id: Identifier): UnaryOperator[BitVectorVariable] = {
        getDef(id) match {
          case instr if isSbConstructorOrFormatInDefUse(instr) =>
            createOperator(id)
          case instr if pointsToPhi(id) && !isPhiDef(id)       =>
            createOperator(id)
          case _ if isParameter(id)                            =>
            val tpe = getTypeAbstraction(node.getIr, valNum(id))
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
        valNum(id) <= node.getIr.getNumberOfParameters
      }
    }

    override def getTransferFunctions: StringBuilderTransferFunctions = new IntraStringBuilderTransferFunctions
  }
}
