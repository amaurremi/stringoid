package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.graphPass

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringFormatSpecifiers
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.mutable

// todo remove instructions from StringPartAutomaton!

trait ExplodedStringAppendModule extends InterProcASBOModule with StringFormatSpecifiers with WorkListModule with IrUrlRetriever {

  /**
    * Analysis result that maps exploded nodes to automata. This maps tracks only mutable ASBOs, i.e.
    * ASBOs corresponding to StringBuilders and StringBuffers.
    */
  private[this] val resultMutable = mutable.Map.empty[ExplodedNode, StringPartAutomaton] withDefaultValue epsilonAuto

  /**
    * Analysis result that maps immutable ASBOs to automata.
    */
  private[this] val resultImmutable = mutable.Map.empty[ASBO, StringPartAutomaton] withDefaultValue epsilonAuto

  def stringAppends(fieldToAutomaton: FieldToAutomaton): StringPartAutomaton = {
    // concatenation URLs
    val filteredAutomata: Iterator[StringPartAutomaton] = TimeResult("filter URL automata", getResult map {
      auto =>
        auto.filterHeads {
          case StringIdentifier(id)     =>
            val table = id.node.getIR.getSymbolTable
            val vn    = id.vn
            (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
          case StaticFieldPart(string)  =>
            isUrlPrefix(string)
          case StringFormatPart(string) =>
            isUrlPrefix(string)
          case _                        => false
        }
    })
    // constant URLs
    val constants = TimeResult("constant URLs", getConstantUrls)
    TimeResult("merging filtered automata", merge(filteredAutomata ++ constants))
  }

  private[this] def getConstantUrls: Iterator[StringPartAutomaton] =
    for {
      node <- callGraph.iterator()
      ir    = node.getIR
      if Option(ir).isDefined
      table = ir.getSymbolTable
      vn   <- 1 to table.getMaxValueNumber
      if table isStringConstant vn
      string = table getStringValue vn
      if isUrlPrefix(string)
      spart  = StringIdentifier(createId(vn, CallGraphNode(node)))
    } yield newAuto(spart)

  val idToAsbo: Map[CgIdentifier, Set[ASBO]] =
    identifierToAsbo withDefault {
      id => Set(createAsbo(id))
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
    val newResult = if (oldResult == epsilonAuto) newAutomaton else oldResult +++ newAutomaton
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

  private[this] def resultGet(
   bb: BB,
   asbo: ASBO
  ): Option[StringPartAutomaton] = {
    val immutAuto = resultImmutable get asbo
    if (immutAuto.isEmpty) {
      resultMutable get (bb, asbo)
    } else immutAuto
  }

  private[this] def getResult: Iterator[StringPartAutomaton] = TimeResult("II analysis phase (computing automata)", {

    implicit val worklist = TimeResult("initialize work list", initializeWorklist(idToAsbo))

    var worklistIteration = 0
    val printFrequency = 25000

    TimeResult("processing work list", while (worklist.nonEmpty) {

      if (DEBUG && ((worklistIteration % printFrequency) == 0)) {
        println(s"iteration: ${worklistIteration / 1000}k, worklist size: ${worklist.size()}")
        if (worklist.size == 32272) {
          val x = 1
        }
      }
      worklistIteration = worklistIteration + 1

      val (bb, factAsbo) = worklist.take()
      val node           = CallGraphNode(bb.getNode)

      def getId(vn: ValueNumber) = createId(vn, node)

      bb.getLastInstruction match {

        // StringBuilder.append(str)
        case instr: SSAAbstractInvokeInstruction if isSbAppend(instr)                     =>
          val asbos = idToAsbo(getId(getFirstSbAppendDef(instr)))
          append(asbos, getAppendArgument(instr), bb, factAsbo)

        // new StringBuilder(str)
        case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
          val asbos = idToAsbo(getId(getSbConstructorDef(instr)))
          append(asbos, getSbConstructorArgument(instr), bb, factAsbo)

        // String.format
        case instr: SSAAbstractInvokeInstruction if isStringFormat(instr)                 =>
          val argValnums = getStringFormatArgs(instr, node) flatMap {
            vn =>
              idToAsbo(createId(vn, node))
          }
          val factInArgs = argValnums contains factAsbo
          val sfAsbo     = createAsbo(createId(instr.getDef, node))
          if (factInArgs || sfAsbo == factAsbo) {
            val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs(instr, node)
            val automaton = sfArgSeqs.foldLeft(emptyAuto) {
              case (prevAuto, sfArgs) if sfArgs.nonEmpty =>
                val nextAuto = sfArgs.tail.foldLeft(newAuto(sfArgs.head)) {
                  case (resultAutomaton, stringFormatArg) =>
                    stringFormatArg match {
                      case StringIdentifier(id) =>
                        val automata = idToAsbo(id) map {
                          asbo =>
                            resultGet(bb, asbo) getOrElse createAutomaton(CallGraphNode(asbo.identifier.node), asbo.identifier)
                        }
                        resultAutomaton +++ merge(automata.toIterator)
                      case other =>
                        val appendAutomaton = newAuto(other)
                        resultAutomaton +++ appendAutomaton
                    }
                }
                prevAuto | nextAuto
              case (prevAuto, _)                         =>
                prevAuto
            }
            assert(automaton != emptyAuto)
            acyclicCFG getSuccNodes bb foreach {
              succ =>
                updateResultAndWorkListImmutable((succ, sfAsbo), automaton)
            }
          } else
            propagateIdentity(acyclicCFG getSuccNodes bb, bb, factAsbo)
          if (factInArgs)
            propagateIdentity(acyclicCFG getSuccNodes bb, bb, factAsbo)

        // inter-procedural call-to-start and call-to-return edges:
        // parameter substitution in call + propagate facts down to return node
        // todo test dynamic dispatch, e.g. merge
        case instr: SSAAbstractInvokeInstruction                                           =>
          // call-to-start
          for {
            succ: CGNode       <- acyclicCFG getCallTargets bb
            ir                  = succ.getIR
            if Option(ir).isDefined
            (asbo, paramIndex) <- argumentAsbos(idToAsbo, instr, node)
            if asbo == factAsbo
            paramId             = createId(paramIndex + 1, CallGraphNode(succ))
            paramAsbo          <- idToAsbo getOrElse (paramId, Set(createAsbo(paramId)))
            oldAutomaton        = resultGet(bb, paramAsbo)
            automaton           = resultGet(bb, asbo) getOrElse createAutomaton(node, asbo.identifier)
            targetBB            = acyclicCFG getEntry succ
          } {
            val paramType = ir getParameterType paramIndex
            val oldAndNew = if (oldAutomaton.isEmpty) automaton else oldAutomaton.get | automaton
            if (isMutable(paramType)) updateResultAndWorkListMutable((targetBB, paramAsbo), oldAndNew)
            else updateResultAndWorkListImmutable((targetBB, paramAsbo), oldAndNew)
          }
          // call-to-return
          propagateIdentity(acyclicCFG getReturnSites bb, bb, factAsbo)

        // inter-procedural end-to-return edge: return value assignment
        case instr: SSAReturnInstruction                                                   =>
          val retDef = instr.getResult
          if (retDef > 0) {
            val retCgNode = bb.getNode
            val retNode   = CallGraphNode(retCgNode)
            val resultId  = createId(retDef, retNode)
            for {
            // return stuff
              resultAsbo   <- idToAsbo getOrElse (resultId, Set(createAsbo(resultId)))
              if resultAsbo == factAsbo
              // call stuff
              callBlock    <- getCallBlocks(bb)
              callInstr     = callBlock.getLastInstruction.asInstanceOf[SSAAbstractInvokeInstruction]
              mutable       = isMutable(callInstr.getDeclaredResultType)
              if mutable || hasPrimitiveReturnType(callInstr) || hasStringReturnType(callInstr)
              callCgNode    = callBlock.getNode
              callNode      = CallGraphNode(callCgNode)
              callId        = createId(callInstr.getDef, callNode)
              callAsbo     <- idToAsbo getOrElse(callId, Set(createAsbo(callId)))
            } {
              val callExplNode = (callBlock, callAsbo)
              val prevResult   = resultGet(callBlock, callAsbo)
              val retResult    = resultGet(bb, resultAsbo) getOrElse createAutomaton(retNode, resultAsbo.identifier)
              val prevAndRet   = if (prevResult.isEmpty) retResult else prevResult.get | retResult
              if (mutable) updateResultAndWorkListMutable(callExplNode, prevAndRet)
              else updateResultAndWorkListImmutable(callExplNode, prevAndRet)
            }
          }
        case _                                                                           =>
          propagateIdentity(acyclicCFG getSuccNodes bb, bb, factAsbo)
      }
    })
    resultMutable.valuesIterator ++ resultImmutable.valuesIterator
  })

  private[this] def propagateIdentity(
    succNodes: Iterator[BB],
    bb: BB,
    factAsbo: ASBO
  )(
    implicit worklist: WorkList
  ): Unit = {
    val identifier = factAsbo.identifier
    val mutable = isMutable(getTypeAbstraction(identifier.node.getIR, identifier.vn).getTypeReference)
    succNodes foreach {
      succ =>
        val succNode = (succ, factAsbo)
        def createdAutomaton = createAutomaton(CallGraphNode(bb.getNode), identifier)
        val automaton =
          if (mutable) resultMutable getOrElse((bb, factAsbo), createdAutomaton)
          else resultImmutable getOrElse(factAsbo, createdAutomaton)
        val mergedAutomaton = resultMutable(succNode) | automaton
        if (mutable) updateResultAndWorkListMutable(succNode, mergedAutomaton)
        else updateResultAndWorkListImmutable(succNode, mergedAutomaton)
    }
  }

  /**
    * @param asbos  ASBOs of the stringbuilders to which we're appending
    * @param argVn  value number of the argument that's being appended
    */
  private[this] def append(
    asbos: Set[ASBO],
    argVn: ValueNumber,
    bb: BB,
    factAsbo: ASBO
  )(
    implicit worklist: WorkList
  ): Unit = {
    val node = CallGraphNode(bb.getNode)
    def getId(vn: ValueNumber) = createId(vn, node)
    val succNodes = acyclicCFG getSuccNodes bb
    for {
      succ <- succNodes.toIterable
      sb   <- asbos
      args  = idToAsbo(getId(argVn))
    } {
      if ((sb == factAsbo) || (args contains factAsbo)) {
        val argAutos = args map {
          a =>
            resultGet(bb, a) getOrElse createAutomaton(node, a.identifier)
        }
        val argAuto = merge(argAutos.toIterator)
        appendResult(bb, succ, sb, argAuto)
      }
    }
    if (!(asbos contains factAsbo))
      propagateIdentity(succNodes, bb, factAsbo)
  }

  private[this] def getConstantReturnValue(bb: BB, instr: SSAReturnInstruction): Option[ValueNumber] = {
    if (!instr.returnsVoid()) {
      val table = bb.getNode.getIR.getSymbolTable
      val result = instr.getResult
      if (table isConstant result) Some(result)
      else None
    } else None
  }

  private[this] def initializeWorklist(idToAsbo: Map[Identifier, Set[ASBO]]): WorkList = {

    val worklist = new WorkList()

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

    if (DEBUG) println("acyclic CFG size: " + acyclicCFG.size)

    acyclicCFG foreach {
      bb =>
        val node = bb.getNode
        val instr = bb.getLastInstruction
        if (Option(instr).isDefined) {
          instrToVn get(node, instr.iindex) match {
            case Some(vn) =>
              // add to work list
              idToAsbo(createId(vn, CallGraphNode(node))) foreach {
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
