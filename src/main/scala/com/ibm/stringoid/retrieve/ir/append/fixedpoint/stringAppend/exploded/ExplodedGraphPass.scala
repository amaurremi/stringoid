package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.exploded

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

  private[this] val GRAPH_PASSES = 2

  val resultMap: mutable.Map[BB, Map[ASBO, StringPartAutomaton]] = initialResultMap

  lazy val initialResultMap = mutable.Map.empty[BB, Map[ASBO, StringPartAutomaton]] withDefaultValue
    (Map.empty[ASBO, StringPartAutomaton] withDefault defaultAsbo)

  def defaultAsbo(asbo: ASBO) = {
    val id = asbo.identifier
    if (hasSbType(id.node, id.vn, getTypeAbstraction(id.node.getIR, id.vn)))
      epsilonAuto
    else
      createAutomaton(CallGraphNode(asbo.identifier.node), asbo.identifier)
  }

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
      spart  = StringIdentifier(createIdentifier(vn, CallGraphNode(node)))
    } yield newAuto(spart)

  private[this] val idToAsbo: Map[CgIdentifier, Set[ASBO]] =
    identifierToAsbo withDefault {
      id => Set(createAsbo(id.vn, CallGraphNode(id.node)))
    }

  private[this] def getResult: Iterator[StringPartAutomaton] = TimeResult("II analysis phase (computing automata)", {

    (0 until GRAPH_PASSES) foreach { _ =>

      val topOrder = Topological.makeTopologicalIter(acyclicCFG) // todo avoid recalculating this?
      topOrder foreach {
        bb: BB =>

          val predNodes = acyclicCFG getPredNodes bb
          val asbos     = getAsbosForNode(bb)
          val node      = CallGraphNode(bb.getNode)
          def getId(vn: ValueNumber) = {
            createIdentifier(vn, node)
          }

          bb.getLastInstruction match {

            // StringBuilder.append(str)
            case instr: SSAAbstractInvokeInstruction if isSbAppend(instr) =>
              val asbos = idToAsbo(getId(getFirstSbAppendDef(instr)))
              propagateIdentity(bb, asbos)
              append(asbos, getAppendArgument(instr), bb)

            // new StringBuilder(str)
            case instr: SSAAbstractInvokeInstruction if isSbConstructorWithStringParam(instr) =>
              val asbos = Set(createAsbo(getSbConstructorDef(instr), node))
              propagateIdentity(bb, asbos)
              append(asbos, getSbConstructorArgument(instr), bb)

            // String.format
            case instr: SSAAbstractInvokeInstruction if isStringFormat(instr) =>
              propagateIdentity(bb, Set(createAsbo(instr.getDef, node)))
              stringFormat(instr, bb)

            // field writes
            case instr: SSAPutInstruction =>
              propagateIdentity(bb, Set.empty[ASBO])
              val argVn     = instr getUse (if (instr.isStatic) 2 else 1)
              val rhs       = idToAsbo(getId(argVn))
              val field     = instr.getDeclaredField
              val fieldAuto = fieldToAutomaton getOrElse(field, epsilonAuto)
              val rhsAutos  = rhs map {
                rh =>
                  resultMap(bb) getOrElse (rh, defaultAsbo(rh))
              }
              fieldToAutomaton += (field -> (fieldAuto | merge(rhsAutos.iterator)))

            // field reads
            case instr: SSAGetInstruction =>
              propagateIdentity(bb, Set.empty[ASBO])
              val vn      = instr getUse (if (instr.isStatic) 1 else 2)
              val varAsbo = createAsbo(vn, node)
              if (vn > 0) {
                val fieldAuto = fieldToAutomaton getOrElse(instr.getDeclaredField, epsilonAuto)
                val prevMap   = resultMap(bb)
                resultMap(bb) = prevMap + (varAsbo -> ((prevMap getOrElse (varAsbo, defaultAsbo(varAsbo))) | fieldAuto))
              }
            case _ =>
              propagateIdentity(bb, Set.empty[ASBO])
          }
      }
    }
    resultMap.valuesIterator flatMap {
      _.valuesIterator
    }
  })

  private[this] def propagateIdentity(
    bb: BB,
    exclude: Set[ASBO]
  ): Unit = {
    val predNodes   = (acyclicCFG getPredNodes bb).toList
    val predNodeNum = predNodes.size
    lazy val allPredAsbos = (predNodes flatMap {
      resultMap(_).keySet
    }).toSet
    // if we have to merge results from several pred nodes, or
    // if the to-be-propagated ASBOs contain ones that should be excluded,
    // then we create a new ASBO-to-automaton map from scratch
    if (predNodeNum > 1 || (allPredAsbos diff exclude).nonEmpty) {
      // todo if this is a bottle neck it can be made more efficient by looking only at relevant ASBOs
      val asboToAuto: Map[ASBO, StringPartAutomaton] = (for {
        asbo <- allPredAsbos
        if !(exclude contains asbo)
      } yield {
        val automaton = predNodes.foldLeft(epsilonAuto) {
          case (auto, pred) =>
            (resultMap(pred) getOrElse (asbo, defaultAsbo(asbo))) | auto
        }
        asbo -> automaton
      })(scala.collection.breakOut)
      resultMap(bb) = asboToAuto
    } else if (predNodeNum == 1) {
      resultMap(bb) = resultMap(predNodes.head)
    }
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
    val argAsbos  = idToAsbo getOrElse (createIdentifier(argVn, node), Set(createAsbo(argVn, node)))
    val argAutos  = for {
      predNode <- predNodes
      argAsbo  <- argAsbos
    } yield resultMap(predNode) getOrElse (argAsbo, defaultAsbo(argAsbo))
    val argAutomaton = merge(argAutos)

    asbos foreach {
      sb =>
        val predAuto = predNodes.foldLeft(epsilonAuto) {
          case (auto, predNode) =>
            (resultMap(predNode) getOrElse (sb, defaultAsbo(sb))) | auto
        }

        val newAuto = predAuto +++ argAutomaton
        resultMap(bb) = resultMap(bb) + (sb -> newAuto)
    }
  }

  private[this] def stringFormat(instr: SSAAbstractInvokeInstruction, bb: BB): Unit = {
    val cgNode = CallGraphNode(bb.getNode)
    val argValnums = getStringFormatArgs(instr, cgNode) flatMap {
      vn =>
        idToAsbo(createIdentifier(vn, cgNode))
    }
    val sfAsbo = createAsbo(instr.getDef, cgNode)
    val sfArgSeqs: Seq[Seq[StringPart]] = reorderStringFormatArgs(instr, cgNode)
    val automaton = sfArgSeqs.foldLeft(epsilonAuto) {
      case (prevAuto, sfArgs) if sfArgs.nonEmpty =>
        val nextAuto = sfArgs.tail.foldLeft(newAuto(sfArgs.head)) {
          case (resultAutomaton, stringFormatArg) =>
            stringFormatArg match {
              case StringIdentifier(id) =>
                val automata = idToAsbo(id) map {
                  asbo =>
                    resultMap(bb) getOrElse (asbo, createAutomaton(CallGraphNode(id.node), id))
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
    acyclicCFG getSuccNodes bb foreach {
      succ =>
        resultMap(bb) = resultMap(bb) + (sfAsbo -> automaton)
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
          idToAsbo(createIdentifier(vn, CallGraphNode(node)))
        case None =>
          Set.empty[ASBO]
      }
    } else Set.empty[ASBO]
  }
}
