package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringFormatSpecifiers
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa._
import com.ibm.wala.types.FieldReference
import seqset.regular.Automaton

import scala.collection.JavaConversions._
import scala.collection.mutable

// todo remove instructions from StringPartAutomaton!

trait ExplodedStringAppendModule extends InterProcASBOModule with StringFormatSpecifiers with WorkListModule with IrUrlRetriever {

  /**
    * Analysis result that maps exploded nodes to automata. This maps tracks only mutable ASBOs, i.e.
    * ASBOs corresponding to StringBuilders and StringBuffers.
    */
  private[this] val resultMutable = mutable.Map.empty[ExplodedNode, StringPartAutomaton] withDefaultValue StringPartAutomaton()

  /**
    * Analysis result that maps immutable ASBOs to automata.
    */
  private[this] val resultImmutable = mutable.Map.empty[ASBO, StringPartAutomaton] withDefaultValue StringPartAutomaton()

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
      ir    = node.getIR
      if Option(ir).isDefined
      table = ir.getSymbolTable
      vn   <- 1 to table.getMaxValueNumber
      if table isStringConstant vn
      string = table getStringValue vn
      if isUrlPrefix(string)
      spart  = StringIdentifier(createIdentifier(vn, CallGraphNode(node)))
    } yield StringPartAutomaton(spart)
  }

  private[this] val idToAsbo: Map[CgIdentifier, Set[ASBO]] = {
    identifierToAsbo withDefault {
      id => Set(createAsbo(id.vn, CallGraphNode(id.node)))
    }
  }

  private[this] def createAutomaton(instruction: SSAInstruction, node: Node, id: Identifier): StringPartAutomaton =
    node.getDu getDef valNum(id) match {
      case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
        fieldToAutomaton(instr.getDeclaredField)
      case _                                                                                    =>
        StringPartAutomaton(instruction, StringIdentifier(id))
    }

  private[this] def appendResult(
    bb: BB,
    succ: BB,
    asbo: ASBO,
    newAutomaton: StringPartAutomaton
  )(
    implicit worklist: WorkList
  ): Unit = {
    val succNode  = (succ, asbo)
    val oldResult = resultMutable((bb, asbo))
    val newResult =
      if (oldResult.automaton == Automaton.empty[StringPartAutomaton]) newAutomaton
      else oldResult +++ newAutomaton
    val oldSuccResult = resultMutable(succNode)
    updateResultAndWorkListMutable(succNode, oldSuccResult | newResult)
  }

  private[this] def updateResultAndWorkListMutable(
    node: ExplodedNode,
    automaton: StringPartAutomaton
  )(
    implicit worklist: WorkList
  ): Unit = {
    val oldResult = resultMutable(node)
    resultMutable += (node -> automaton)
    if (oldResult != automaton) worklist insert node
  }

  private[this] def updateResultAndWorkListImmutable(
    node: ExplodedNode,
    automaton: StringPartAutomaton
  )(
    implicit worklist: WorkList
  ): Unit = {
    val oldResult = resultImmutable(node._2)
    resultImmutable += (node._2 -> automaton)
    if (oldResult != automaton) worklist insert node
  }

  private[this] def resultGetOrElse(
    bb: BB,
    asbo: ASBO,
    default: StringPartAutomaton = StringPartAutomaton()
  ): StringPartAutomaton = {
    val immutAuto = resultImmutable get asbo
    if (immutAuto.isEmpty) {
      resultMutable getOrElse ((bb, asbo), default)
    } else immutAuto.get
  }

  private[this] lazy val cfg = AcyclicCfg()

  private[this] def getResult: Iterator[StringPartAutomaton] = TimeResult("II analysis phase (computing automata)", {

    implicit val worklist = initializeWorklist(cfg, idToAsbo)

    var worklistIteration = 0
    val printFrequency = 100
    val debug = true

    while (worklist.nonEmpty) {

      if (debug && (worklistIteration % printFrequency) == 0) {
        println(s"iteration: $printFrequency, worklist size: ${worklist.size()}")
        worklistIteration = worklistIteration + 1
      }

      val (bb, factAsbo) = worklist.take()
      val node           = CallGraphNode(bb.getNode)

      def getId(vn: ValueNumber) = createIdentifier(vn, node)

      bb.getLastInstruction match {

        // StringBuilder.append(str)
        case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                     =>
          val asbos = idToAsbo(getId(getFirstSbAppendDef(instr)))
          append(instr, asbos, getAppendArgument(instr), bb, factAsbo)

        // new StringBuilder(str)
        case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
          val asbos = idToAsbo(getId(getSbConstructorDef(instr)))
          append(instr, asbos, getSbConstructorArgument(instr), bb, factAsbo)

        // String.format
        case instr: SSAAbstractInvokeInstruction if isStringFormat(instr)                 =>
          val argValnums = getStringFormatArgs(instr, node) flatMap {
            vn =>
              idToAsbo(createIdentifier(vn, node))
          }
          val factInArgs = argValnums contains factAsbo
          val sfAsbo     = createAsbo(instr.getDef, node)
          if (factInArgs || sfAsbo == factAsbo) {
            val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs(instr, node)
            val automaton = sfArgSeqs.foldLeft(StringPartAutomaton()) {
              case (prevAuto, sfArgs) =>
                val newAuto = sfArgs.tail.foldLeft(StringPartAutomaton(instr, sfArgs.head)) {
                  case (resultAutomaton, stringFormatArg) =>
                    stringFormatArg match {
                      case StringIdentifier(id) =>
                        val automata = idToAsbo(id) map {
                          asbo =>
                            resultGetOrElse(bb, asbo, StringPartAutomaton(StringIdentifier(id)))
                        }
                        resultAutomaton +++ StringPartAutomaton.merge(automata.toIterator)
                      case other =>
                        val appendAutomaton = StringPartAutomaton(instr, other)
                        resultAutomaton +++ appendAutomaton
                    }
                }
                prevAuto | newAuto
            }
            cfg getIntraSuccnodes bb foreach {
              succ =>
                updateResultAndWorkListImmutable((succ, sfAsbo), automaton)
            }
          } else
            propagateIdentity(cfg getIntraSuccnodes bb, bb, factAsbo)
          if (factInArgs)
            propagateIdentity(cfg getIntraSuccnodes bb, bb, factAsbo)

        // inter-procedural call-to-start and call-to-return edges:
        // parameter substitution in call + propagate facts down to return node
        // todo test multiple dispatch, e.g. merge
        case instr: SSAAbstractInvokeInstruction                                           =>
          // call-to-start
          val substitutionAsbos = argumentAsbos(idToAsbo, instr, node)
          for {
            succ: CGNode       <- cfg getCallTargets bb
            ir                  = succ.getIR
            if Option(ir).isDefined
            (asbo, paramIndex) <- substitutionAsbos
            if asbo == factAsbo
            paramId             = createIdentifier(paramIndex + 1, CallGraphNode(succ))
            paramAsbo          <- idToAsbo getOrElse (paramId, Set(ASBO(paramId))) // todo add params to ID-to-ASBO by default
            oldAutomaton        = resultGetOrElse(bb, paramAsbo)
            automaton           = resultGetOrElse(bb, asbo, createAutomaton(instr, node, asbo.identifier))
            targetBB            = cfg getEntry succ
          } {
            val paramType = ir getParameterType paramIndex
            if (isMutable(paramType)) updateResultAndWorkListMutable((targetBB, paramAsbo), oldAutomaton | automaton)
            else updateResultAndWorkListImmutable((targetBB, paramAsbo), oldAutomaton | automaton)
          }
          // call-to-return
          propagateIdentity(cfg getReturnSites bb, bb, factAsbo)

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
              callBlock    <- cfg getCallBlocks bb
              callInstr     = callBlock.getLastInstruction.asInstanceOf[SSAAbstractInvokeInstruction]
              mutable       = isMutable(callInstr.getDeclaredResultType)
              if mutable || hasPrimitiveReturnType(callInstr) || hasStringReturnType(callInstr)
              callCgNode    = callBlock.getNode
              callNode      = CallGraphNode(callCgNode)
              callDef       = callInstr.getDef
              callId        = createIdentifier(callDef, callNode)
              callAsbo     <- idToAsbo getOrElse(callId, Set(createAsbo(callDef, callNode)))
            } {
              val callExplNode = (callBlock, callAsbo)
              val prevResult   = resultGetOrElse(callBlock, callAsbo)
              val retResult    = resultGetOrElse(bb, resultAsbo, createAutomaton(instr, retNode, resultAsbo.identifier))
              if (mutable) updateResultAndWorkListMutable(callExplNode, prevResult | retResult)
              else updateResultAndWorkListImmutable(callExplNode, prevResult | retResult)
            }
          }
        case _                                                                           =>
          propagateIdentity(cfg getIntraSuccnodes bb, bb, factAsbo)
      }
    }
    resultMutable.valuesIterator ++ resultImmutable.valuesIterator
  })

  private[this] def propagateIdentity(
    succNodes: Iterator[BB],
    bb: BB, factAsbo: ASBO
  )(
    implicit worklist: WorkList
  ): Unit =
    succNodes foreach {
      succ =>
        val succNode  = (succ, factAsbo)
        val automaton = resultMutable getOrElse ((bb, factAsbo), createAutomaton(bb.getLastInstruction, CallGraphNode(bb.getNode), factAsbo.identifier))
        updateResultAndWorkListMutable(succNode, resultMutable(succNode) | automaton)
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
  )(
    implicit worklist: WorkList
  ): Unit = {
    val node = CallGraphNode(bb.getNode)
    def getId(vn: ValueNumber) = createIdentifier(vn, node)
    for {
      succ <- (cfg getIntraSuccnodes bb).toIterable
      sb   <- asbos
      args  = idToAsbo(getId(argVn))
    } {
      if ((sb == factAsbo) || (args contains factAsbo)) {
        val argAutos = args map {
          a =>
            resultGetOrElse(bb, a, createAutomaton(instr, node, a.identifier))
        }
        val argAuto = StringPartAutomaton.merge(argAutos.toIterator)
        appendResult(bb, succ, sb, argAuto)
      }
      if (sb != factAsbo)
        updateResultAndWorkListMutable((succ, factAsbo), resultGetOrElse(bb, factAsbo))
    }
  }

  private[this] def getConstantReturnValue(bb: BB, instr: SSAReturnInstruction): Option[ValueNumber] = {
    if (!instr.returnsVoid()) {
      val table = bb.getNode.getIR.getSymbolTable
      val result = instr.getResult
      if (table isConstant result) Some(result)
      else None
    } else None
  }

  private[this] def initializeWorklist(cfg: AcyclicCfg, idToAsbo: Map[Identifier, Set[ASBO]]): WorkList = {

    val worklist = new WorkList(cfg)

    // remember which instructions define which String value numbers: map pairs (node, iindex) to value numbers
    val instrToVn = callGraph.foldLeft(Map.empty[(CGNode, Int), ValueNumber]) {
      case (oldMap, node) =>
        val ir = node.getIR
        if (Option(ir).isDefined) {
          val table = ir.getSymbolTable
          (1 to table.getMaxValueNumber).foldLeft(oldMap) {
            case (oldMap2, vn) if hasStringType(node, vn) =>
              (node.getDU getUses vn).foldLeft(oldMap2) {
                case (oldMap3, useInstr) =>
                  oldMap3 + ((node, useInstr.iindex) -> vn)
              }
            case (oldMap2, _) =>
              oldMap2
          }
        } else oldMap
    }

    cfg.nodesIterator foreach {
      bb =>
        val node = bb.getNode
        val instr = bb.getLastInstruction
        if (Option(instr).isDefined) {
          instrToVn get(node, instr.iindex) match {
            case Some(vn) =>
              // add to work list
              idToAsbo(createIdentifier(vn, CallGraphNode(node))) foreach {
                asbo =>
                  worklist insert ((bb, asbo))
              }
            case None     =>
              ()
          }
        }
    }

    worklist
  }

  private[this] def hasStringType(node: CGNode, vn: ValueNumber): Boolean = {
    val tpe = getTypeAbstraction(node.getIR, vn)
    tpe.toString contains "Ljava/lang/String"
  }
}
