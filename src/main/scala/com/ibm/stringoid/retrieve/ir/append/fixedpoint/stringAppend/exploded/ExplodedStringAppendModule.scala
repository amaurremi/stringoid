package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringFormatSpecifiers
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ipa.cfg.{BasicBlockInContext, ExplodedInterproceduralCFG}
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAFieldAccessInstruction, SSAInstruction, SSAReturnInstruction}
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable

trait ExplodedStringAppendModule extends InterProcASBOModule with StringFormatSpecifiers {

  case class BB(bb: BasicBlockInContext[IExplodedBasicBlock]) {
    override def toString = "BB " + bb.getLastInstruction.toString
    def getNode = bb.getNode
    def instruction = bb.getLastInstruction
    def getSuccNodes = cfg getSuccNodes bb map BB.apply
    def getCallTargets = cfg getCallTargets bb
    def getCallSites(callee: CGNode) = cfg getCallSites (bb, callee) map BB.apply
    def getReturnSites = cfg getReturnSites bb map BB.apply
  }

  type ExplodedNode = (BB, ASBO)

  // todo have two maps as Ondřej suggestsed
  private[this] val result = mutable.Map.empty[ExplodedNode, StringPartAutomaton] withDefaultValue StringPartAutomaton()

  def stringAppends(fieldToAutomaton: Map[FieldReference, StringPartAutomaton]): StringPartAutomaton = {
    // concatenation URLs
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
    // constant URLs
    val constants = TimeResult("constant URLs", getConstantUrls)
    TimeResult("merging filtered automata", StringPartAutomaton.merge(filteredAutomata ++ constants))
  }

  private[this] def getConstantUrls: Iterator[StringPartAutomaton] = {
    for {
      node <- callGraph.iterator()
      table = node.getIR.getSymbolTable
      vn   <- 1 to table.getMaxValueNumber
      if table isStringConstant vn
      string = table getStringValue vn
      if isUrlPrefix(string)
      spart  = StringIdentifier(createIdentifier(vn, CallGraphNode(node)))
    } yield StringPartAutomaton(spart)
  }

  // todo include constants, arguments, default value
  private[this] val idToAsbo: Map[CgIdentifier, Set[ASBO]] = {
    identifierToAsbo withDefault {
      id => Set(createAsbo(id.vn, CallGraphNode(id.node)))
    }
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
    val succNode  = (succ, asbo)
    val oldResult = result((bb, asbo))
    val newResult =
      if (oldResult.automaton == Automaton.empty[StringPartAutomaton]) newAutomaton
      else oldResult +++ newAutomaton
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
      val (bb, factAsbo) = worklist.dequeue()
      val node       = CallGraphNode(bb.getNode)

      def getId(vn: ValueNumber) = createIdentifier(vn, node)

      bb.instruction match {
        // append from StringBuilder.append() invocation
        case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                     =>
          val asbos = idToAsbo(getId(getFirstSbAppendDef(instr)))
          append(instr, asbos, getAppendArgument(instr), bb, factAsbo)
        // append from StringBuilder constructor invocation
        case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
          val asbos = idToAsbo(getId(getSbConstructorDef(instr)))
          append(instr, asbos, getSbConstructorArgument(instr), bb, factAsbo)
        // String.format
        case instr: SSAAbstractInvokeInstruction if isStringFormat(instr)                 =>
          ???
        // inter-procedural call-to-start and call-to-return edges:
        // parameter substitution in call + propagate facts down to return node
        case instr: SSAAbstractInvokeInstruction                                           =>
          // call-to-start
          val substitutionAsbos = argumentAsbos(idToAsbo, instr, node)
          for {
            succ: CGNode       <- bb.getCallTargets
            (asbo, paramIndex) <- substitutionAsbos
            if asbo == factAsbo // do I need to propagate anything else inter-procedurally?
            paramId             = createIdentifier(paramIndex + 1, CallGraphNode(succ))
            paramAsbo          <- idToAsbo getOrElse (paramId, Set(ASBO(paramId))) // todo add params to ID-to-ASBO by default
            oldAutomaton        = result getOrElse ((bb, paramAsbo), StringPartAutomaton())
            automaton           = result getOrElse ((bb, asbo), StringPartAutomaton())
            targetBB            = BB(cfg getEntry succ)
          } updateResultAndWorklist((targetBB, paramAsbo), oldAutomaton | automaton)
          // call-to-return
          propagateIdentity(bb.getReturnSites, bb, factAsbo)
        // inter-procedural end-to-return edge: return value assignment
        case instr: SSAReturnInstruction                                                   =>
          val retDef = instr.getResult
          if (retDef > 0) {
            val retCgNode = bb.getNode
            val retNode   = CallGraphNode(retCgNode)
            val resultId  = createIdentifier(retDef, retNode)
            for {
              // return stuff
              resultAsbo   <- idToAsbo getOrElse (resultId, Set(createAsbo(retDef, retNode)))
              if resultAsbo == factAsbo
              // call stuff
              callSite: BB <- bb getCallSites retCgNode
              callerInstr   = callSite.instruction.asInstanceOf[SSAAbstractInvokeInstruction]
              if instr.returnsPrimitiveType || hasStringReturnType(callerInstr) // todo add primitive types?
              callDef       = callerInstr.getDef
              callerNode    = CallGraphNode(callSite.getNode)
              callId        = createIdentifier(callDef, callerNode)
              callAsbo     <- idToAsbo getOrElse(callId, Set(createAsbo(callDef, callerNode)))
            } {
              val callExplNode = (callSite, callAsbo)
              val prevResult   = result(callExplNode)
              val retResult    = result((bb, resultAsbo))
              updateResultAndWorklist(callExplNode, prevResult | retResult)
            }
          }
        case _                                                                           =>
          propagateIdentity(bb.getSuccNodes, bb, factAsbo)
      }
    }
    result.valuesIterator
  }

  private[this] def propagateIdentity(succNodes: Iterator[BB], bb: BB, factAsbo: ASBO): Unit =
    succNodes foreach {
      succ =>
        val succNode = (succ, factAsbo)
        updateResultAndWorklist(succNode, result(succNode) | result((bb, factAsbo))) // todo handle loops
    }

  /**
    * @param asbos  ASBOs of the stringbuilders to which we're appending
    * @param argVn  value number of the argument that's being appended
    */
  private[this] def append(
    instr: SSAAbstractInvokeInstruction,
    asbos: Set[ASBO],
    argVn: ValueNumber,
    bb: BB,
    factAsbo: ASBO
  ): Unit = {
    val successors = bb.getSuccNodes
    val node = CallGraphNode(bb.getNode)
    def getId(vn: ValueNumber) = createIdentifier(vn, node)
    for {
      sb  <- asbos
      arg <- idToAsbo(getId(argVn))
    } {
      successors foreach {
        succ =>
          if ((sb == factAsbo) || (arg == factAsbo)) {
            val argAuto = result getOrElse((bb, arg), createAutomaton(instr, node, arg.identifier))
            appendResult(bb, succ, sb, argAuto)
          } else
            updateResultAndWorklist((succ, factAsbo), result(bb, factAsbo))
          // if the fact is `arg`, we also need to propagate information for it
          if (arg == factAsbo)
            updateResultAndWorklist((succ, factAsbo), result(bb, factAsbo))
      }
    }
  }

  // todo is this right?
  private[this] def initializeWorklist() = {
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
  }
}
