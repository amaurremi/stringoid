package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAFieldAccessInstruction, SSAInstruction, SSAReturnInstruction}
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.mutable

trait ExplodedStringAppendModule extends InterProcASBOModule {

  type BB = BasicBlockInContext[IExplodedBasicBlock]

  type ExplodedNode = (BB, ASBO)

  private[this] val result = mutable.Map.empty[ExplodedNode, StringPartAutomaton] withDefaultValue StringPartAutomaton()

  def stringAppends(fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    val filteredAutomata: Iterator[StringPartAutomaton] = TimeResult("filter URL automata", getResult map {
      auto =>
        StringPartAutomaton(auto.automaton.filterHeads {
          case StringIdentifier(id)     =>
            val table = id.node.getIR.getSymbolTable
            val vn    = id.vn
            (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
          case StaticFieldPart(string)  =>
            isUrlPrefix(string)
          case StringFormatPart(string) =>
            isUrlPrefix(string)
          case _                        => false
        })
    })
    TimeResult("merging filtered automata", StringPartAutomaton.merge(filteredAutomata))
  }

  // todo include constants, arguments, default value
  private[this] val idToAsbo: Map[CgIdentifier, Set[ASBO]] = identifierToAsbo withDefault {
    id => Set(createAsbo(id.vn, CallGraphNode(id.node)))
  }

  private[this] val worklist = new mutable.Queue[ExplodedNode] // todo heap?

  private[this] val cfg = ExplodedInterproceduralCFG.make(callGraph)

  private[this] def createAutomaton(instruction: SSAInstruction, node: Node, id: Identifier): StringPartAutomaton =
    node.getDu getDef valNum(id) match {
      case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
        fieldToAutomaton(instr.getDeclaredField)
      case _                                                                                    =>
        StringPartAutomaton(instruction, StringIdentifier(id))
    }

  private[this] def appendResult(bb: BB, succ: BB, asbo: ASBO, newAutomaton: StringPartAutomaton): Unit = {
    val succNode = (succ, asbo)
    val newResult = result((bb, asbo)) +++ newAutomaton
    updateResultAndWorklist(succNode, newResult)
  }

  private[this] def updateResultAndWorklist(node: ExplodedNode, automaton: StringPartAutomaton): Unit = {
    val oldResult = result(node)
    result += (node -> automaton)
    if (oldResult != automaton) worklist enqueue node
  }

  private[this] def getResult: Iterator[StringPartAutomaton] = {

    initializeWorklist()

    while (worklist.nonEmpty) {
      val (bb, asbo) = worklist.dequeue()
      val node       = CallGraphNode(bb.getNode)

      def getId(vn: ValueNumber) = createIdentifier(vn, node)

      bb.getLastInstruction match {
        // append from StringBuilder.append() invocation
        case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                     =>
          idToAsbo get getId(getFirstSbAppendDef(instr)) match {
            case Some(asbos) =>
              append(instr, asbos, getFirstSbAppendDef(instr), bb, asbo)
            case None        =>
              ()
          }
        // append from StringBuilder constructor invocation
        case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
          idToAsbo get getId(getSbConstructorDef(instr)) match {
            case Some(asbos) =>
              append(instr, asbos, getSbConstructorArgument(instr), bb, asbo)
            case None        =>
              ()
          }
        // String.format
        case instr: SSAAbstractInvokeInstruction if isStringFormat(instr)                 =>
          ???
        // inter-procedural call-to-start edge: parameter substitution in call
        case instr: SSAAbstractInvokeInstruction                                           =>
          val substitutionAsbos = argumentAsbos(idToAsbo, instr, node)
          for {
            succ: CGNode           <- cfg getCallTargets bb
            (asbo, paramIndex) <- substitutionAsbos
            paramId             = createIdentifier(paramIndex + 1, CallGraphNode(succ))
            paramAsbo          <- idToAsbo getOrElse (paramId, Set(ASBO(paramId))) // todo add params to ID-to-ASBO by default
            oldAutomaton        = result getOrElse ((bb, paramAsbo), StringPartAutomaton())
            automaton           = result getOrElse ((bb, asbo), StringPartAutomaton())
            targetBB            = cfg getEntry succ
          } updateResultAndWorklist((targetBB, paramAsbo), oldAutomaton | automaton)
        // inter-procedural end-to-return edge: return value assignment
        case instr: SSAReturnInstruction                                                   =>
          val retDef = instr.getResult
          if (retDef > 0) {
            val retCgNode = bb.getNode
            for {
              // call stuff
              callSite: BB <- cfg getCallSites(bb, retCgNode)
              callerInstr   = callSite.getLastInstruction.asInstanceOf[SSAAbstractInvokeInstruction]
              if instr.returnsPrimitiveType || hasStringReturnType(callerInstr) // todo add primitive types?
              callDef       = callerInstr.getDef
              callerNode    = CallGraphNode(callSite.getNode)
              callId        = createIdentifier(callDef, callerNode)
              callAsbo     <- idToAsbo getOrElse(callId, Set(createAsbo(callDef, callerNode)))
              // return stuff
              retNode       = CallGraphNode(retCgNode)
              resultId      = createIdentifier(retDef, retNode)
              resultAsbo   <- idToAsbo getOrElse (resultId, Set(createAsbo(retDef, retNode)))
            } {
              val callExplNode = (callSite, callAsbo)
              val prevResult   = result(callExplNode)
              val retResult    = result((bb, resultAsbo))
              updateResultAndWorklist(callExplNode, prevResult | retResult)
            }
          }
        case _                                                                           =>
          cfg getSuccNodes bb foreach {
            succ =>
              val succNode = (succ, asbo)
              updateResultAndWorklist(succNode, result(succNode) | result((bb, asbo))) // todo handle loops
          }
      }
    }
    result.valuesIterator
  }

  private[this] def append(
    instr: SSAAbstractInvokeInstruction,
    asbos: Set[ASBO],
    sbVn: ValueNumber,
    bb: BB,
    factAsbo: ASBO
  ): Unit = {
    val successors = cfg getSuccNodes bb
    val node = CallGraphNode(bb.getNode)
    def getId(vn: ValueNumber) = createIdentifier(vn, node)
    for {
      sb   <- asbos
      arg  <- idToAsbo(getId(sbVn))
      if (sb == factAsbo) || (arg == factAsbo)
      succ <- successors
    } appendResult(bb, succ, sb, createAutomaton(instr, node, arg.identifier))
  }

  // todo is this right?
  private[this] def initializeWorklist() = {
    cfg foreach {
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
  }
}
