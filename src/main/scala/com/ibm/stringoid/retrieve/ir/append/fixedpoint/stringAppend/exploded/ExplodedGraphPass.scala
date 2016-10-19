package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

import java.util

import com.ibm.stringoid.retrieve.UrlCheck._
import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.asboAnalysis.InterProcASBOModule
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringFormatSpecifiers
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ipa.callgraph.CGNode
import com.ibm.wala.ssa._
import com.ibm.wala.util.graph.traverse.Topological

import scala.collection.JavaConversions._
import scala.collection.mutable

trait ExplodedGraphPass extends InterProcASBOModule with StringFormatSpecifiers with WorkListModule with IrUrlRetriever {

  def addToResult(bb: BB, asbo: ASBO, auto: StringPartAutomaton): Unit = {
    asbo match {
      case imm: ImmutAsbo =>
        resultMapImmut += (imm -> auto)
      case mut: MutAsbo   =>
        resultMapMut(bb) = resultMapMut(bb) + (mut -> auto)
    }
  }

  def getResult(bb: BB, at: ASBO): Option[StringPartAutomaton] =
    at match {
      case asbo: ImmutAsbo =>
        resultMapImmut get asbo
      case asbo: MutAsbo   =>
        resultMapMut(bb) get asbo
    }

  def getResultOrDefault(bb: BB, at: ASBO): StringPartAutomaton =
    getResult(bb, at) getOrElse defaultAsbo(at)

  val resultMapMut = mutable.Map[BB, Map[MutAsbo, StringPartAutomaton]]() withDefaultValue Map.empty[MutAsbo, StringPartAutomaton]
  val resultMapImmut = mutable.Map[ImmutAsbo, StringPartAutomaton]()

  def defaultAsbo(asbo: ASBO): StringPartAutomaton = {
    val id = asbo.identifier
    if (hasSbType(id.node, id.vn, getTypeAbstraction(id.node.getIR, id.vn)))
      epsilonAuto
    else
      createAutomaton(CallGraphNode(asbo.identifier.node), asbo.identifier)
  }

  def stringAppends(fieldToAutomaton: FieldToAutomaton): StringPartAutomaton = {
    val automatonCache = new util.IdentityHashMap[StringPartAutomaton, Unit]
    // concatenation URLs
    val filteredAutomata: Iterator[StringPartAutomaton] = TimeResult("filter URL automata", getResult flatMap {
      auto =>
        val filtered = auto.filterHeads {
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
        if (automatonCache contains filtered)
          None
        else {
          automatonCache += (filtered -> ())
          Some(filtered)
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

  private[this] val idToAsbo: Map[CgIdentifier, Set[ASBO]] =
    identifierToAsbo withDefault {
      id => Set(createAsbo(id))
    }

  private[this] def getResult: Iterator[StringPartAutomaton] = TimeResult("II analysis phase (computing automata)", {

    val passes   = config.graphPasses
    val topOrder = TimeResult("CFG in topological order", Topological.makeTopologicalIter(acyclicCFG).toList)
    val size     = acyclicCFG.size
    if (DEBUG) println(s"CFG size: $size")
    println("_" * 100 + "(100%)")

    (0 until passes) foreach { graphPass =>

      println(s"running graph pass ${graphPass + 1} out of $passes")

      // for the "progress bar"
      var iteration  = 0
      var printedOut = 0

      topOrder foreach {
        bb: BB =>

          // printing progress bar
          iteration = iteration + 1
          if (Math.ceil((iteration.toFloat / size) * 100).toInt > printedOut) {
            print(".")
            printedOut = printedOut + 1
          }

          propagateIdentity(bb)

          val node = CallGraphNode(bb.getNode)
          def getId(vn: ValueNumber) = createId(vn, node)

          bb.getLastInstruction match {

            // StringBuilder.append(str)
            case instr: SSAAbstractInvokeInstruction if isSbAppend(instr) =>
              val asbos = idToAsbo(getId(getFirstSbAppendDef(instr)))
              append(asbos, getAppendArgument(instr), bb)

            // new StringBuilder(str)
            case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
              val asbos = Set(createAsbo(createId(getSbConstructorDef(instr), node)))
              append(asbos, getSbConstructorArgument(instr), bb)

            // String.format
            case instr: SSAAbstractInvokeInstruction if isStringFormat(instr) =>
              stringFormat(instr, bb)

            // field writes
            case instr: SSAPutInstruction =>
              val argVn     = instr getUse (if (instr.isStatic) 2 else 1)
              val rhs       = idToAsbo(getId(argVn))
              val field     = instr.getDeclaredField
              val fieldAuto = fieldToAutomaton getOrElse (field, epsilonAuto)
              val rhsAutos  = rhs map {
                rh =>
                  getResultOrDefault(bb, rh)
              }
              fieldToAutomaton += (field -> (fieldAuto | merge(rhsAutos.iterator)))

            // field reads
            case instr: SSAGetInstruction =>
              val vn = instr getUse (if (instr.isStatic) 1 else 2)
              if (vn > 0) {
                val varAsbo = createAsbo(createId(vn, node))
                val fieldAuto    = fieldToAutomaton getOrElse(instr.getDeclaredField, epsilonAuto)
                val prevMap      = resultMapMut(bb)
                addToResult(bb, varAsbo, fieldAuto)
              }
            case _ =>
              ()
          }
      }
      println()
    }
    val resultsMut = resultMapMut.valuesIterator flatMap {
      _.valuesIterator
    }
    val resultsImmut = resultMapImmut.valuesIterator
    resultsMut ++ resultsImmut
  })

  private[this] def propagateIdentity(bb: BB): Unit = {
    val predNodes = acyclicCFG getPredNodes bb
    val newMap    = predNodes map resultMapMut reduceLeftOption {
      (map1, map2) =>
        map2.foldLeft(map1) {
          case (prevMap, (asbo, auto)) =>
            prevMap get asbo match {
              case Some(prevAuto) if prevAuto eq auto =>
                prevMap
              case Some(prevAuto)                     =>
                prevMap updated (asbo, prevAuto | auto)
              case None                               =>
                prevMap + (asbo -> auto)
            }
        }
    }
    resultMapMut(bb) = newMap getOrElse Map.empty[MutAsbo, StringPartAutomaton] withDefault defaultAsbo
  }

  /**
    * @param asbos  ASBOs of the stringbuilders to which we're appending
    * @param argVn  value number of the argument that's being appended
    */
  private[this] def append(
    asbos: Set[ASBO],
    argVn: ValueNumber,
    bb: BB
  ): Unit = {

    def predNodes = acyclicCFG getPredNodes bb
    val node      = CallGraphNode(bb.getNode)
    val argAsbos  = idToAsbo getOrElse (createId(argVn, node), Set(createAsbo(createId(argVn, node))))
    val argAutos  = argAsbos map {
      argAsbo =>
        getResultOrDefault(bb, argAsbo)
    }
    val argAutomaton = merge(argAutos.iterator)

    asbos foreach {
      sb =>
        val predAuto = getResultOrDefault(bb, sb)
        val newAuto = predAuto +++ argAutomaton
        addToResult(bb, sb, newAuto)
    }
  }

  private[this] def stringFormat(instr: SSAAbstractInvokeInstruction, bb: BB): Unit = {
    val cgNode = CallGraphNode(bb.getNode)
    val argValnums = getStringFormatArgs(instr, cgNode) flatMap {
      vn =>
        idToAsbo(createId(vn, cgNode))
    }
    val sfAsbo = createAsbo(createId(instr.getDef, cgNode))
    val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs(instr, cgNode)
    val automaton = sfArgSeqs.foldLeft(epsilonAuto) {
      case (prevAuto, sfArgs) if sfArgs.nonEmpty =>
        val nextAuto = sfArgs.tail.foldLeft(newAuto(sfArgs.head)) {
          case (resultAutomaton, stringFormatArg) =>
            stringFormatArg match {
              case StringIdentifier(id) =>
                val automata = idToAsbo(id) map {
                  asbo =>
                    getResultOrDefault(bb, asbo)
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
    addToResult(bb, sfAsbo, automaton)
  }

  private[this] def getConstantReturnValue(bb: BB, instr: SSAReturnInstruction): Option[ValueNumber] = {
    if (!instr.returnsVoid()) {
      val table = bb.getNode.getIR.getSymbolTable
      val result = instr.getResult
      if (table isConstant result) Some(result)
      else None
    } else None
  }

  // remember which instructions define which String value numbers: map pairs (node, iindex) to value numbers
  lazy val instrToVn = callGraph.foldLeft(Map.empty[(CGNode, Int), ValueNumber]) {
    case (oldMap, node) =>
      val ir = node.getIR
      if (Option(ir).isDefined) {
        val table = ir.getSymbolTable
        (1 to table.getMaxValueNumber).foldLeft(oldMap) {
          case (oldMap2, vn) if hasStringType(node, vn, getTypeAbstraction(node.getIR, vn)) =>
            (node.getDU getUses vn).foldLeft(oldMap2) {
              case (oldMap3, useInstr) =>
                oldMap3 + ((node, useInstr.iindex) -> vn)
            }
          case (oldMap2, _) =>
            oldMap2
        }
      } else oldMap
  }

  def getAsbosForNode(bb: BB): Set[ASBO] = {
    val instr = bb.getLastInstruction
    val node  = bb.getNode
    if (Option(instr).isDefined) {
      instrToVn get(node, instr.iindex) match {
        case Some(vn) =>
          idToAsbo(createId(vn, CallGraphNode(node)))
        case None =>
          Set.empty[ASBO]
      }
    } else Set.empty[ASBO]
  }
}
