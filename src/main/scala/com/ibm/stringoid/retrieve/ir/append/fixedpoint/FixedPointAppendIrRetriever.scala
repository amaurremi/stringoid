package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import argonaut.Json
import com.ibm.stringoid._
import com.ibm.stringoid.retrieve.UrlCheck.isUrlPrefix
import com.ibm.stringoid.retrieve.UrlPartDefs._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend.StringAppendModule
import com.ibm.stringoid.retrieve.ir.{IrUrlRetriever, ValueNumber}
import com.ibm.stringoid.util.TimeResult
import com.ibm.wala.ssa._
import com.ibm.wala.types.FieldReference

import scala.collection.JavaConversions._
import scala.collection.breakOut

abstract class FixedPointAppendIrRetriever(
  override val config: AnalysisConfig
)
  extends IrUrlRetriever
  with StringAppendModule {

  override def getResult: Json =
    if (config.outputUrls)
      getUrlsWithSources.asJson
    else
      getAutomataWithSources.aws.toList.asJson

  def getAutomataWithSources: AutomataWithSources = {
    val TimeResult(nodes, walaTime) = TimeResult(getNodes)
    val automataWithSources: Iterator[(Json, Method)] =
      for {
        node <- nodes
        if hasUrlWithoutStaticField(node)
      } yield getAutomaton(node)
    AutomataWithSources(automataWithSources, walaTime)
  }

  def hasUrls(node: Node) = hasUrlWithoutStaticField(node) || hasStaticFieldUrl(node)

  def hasUrlWithoutStaticField(node: Node): Boolean

  /**
    * collect all assignments to static fields into map from field to sum-automaton
    */
  lazy val fieldToAutomaton: Map[FieldReference, StringPartAutomaton] =
    getNodes.foldLeft(Map.empty[FieldReference, StringPartAutomaton]) {
      case (oldMap, node) =>
        node.getIr.iterateNormalInstructions().foldLeft(oldMap) {
          case (oldMap2, instr: SSAPutInstruction) =>
            val field    = instr.getDeclaredField
            val writeVal = instr.getVal
            val table    = node.getIr.getSymbolTable
            if (table isConstant writeVal) {
              val stringPart = singleAutomaton(StaticFieldPart(String.valueOf(table getConstantValue writeVal)))
              val automaton =
                if (oldMap2 contains field) oldMap2(field) | stringPart
                else stringPart
              oldMap2 + (field -> automaton)
            } else oldMap2
          case (oldMap2, _)                        =>
            oldMap2
        }
    }

  def hasStaticFieldUrl(node: Node): Boolean = staticUrlFields(node).nonEmpty

  def staticUrlFields(node: Node): Seq[StringPart] =
    1 to node.getIr.getSymbolTable.getMaxValueNumber flatMap {
      vn =>
        node.getDu getDef vn match {
          case instr: SSAFieldAccessInstruction if fieldToAutomaton contains instr.getDeclaredField =>
            fieldToAutomaton(instr.getDeclaredField).iterator map { _.head }
          case _                                                                                    =>
            Seq.empty[StringPart]
        }
    }

  protected def urlPrefixes(vn: ValueNumber, node: Node): Seq[StringPart] = {
    val table = node.getIr.getSymbolTable
    val inTable = (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
    if (inTable)
      Seq(StringIdentifier(createIdentifier(vn, node)))
    else {
      node.getDu getDef vn match {
        case instr: SSAFieldAccessInstruction =>
          val strings = for {
            automaton <- (fieldToAutomaton get instr.getDeclaredField).toSeq
            seq       <- automaton.iterator
          } yield seq.head
          strings filter {
            case StaticFieldPart(str) => isUrlPrefix(str)
            case _                    => false
          }
        case _                                =>
          Seq.empty[StringPart]
      }
    }
  }

  protected def getAutomaton(entryNode: Node): (Json, Method)

  protected def parseUrl(node: Node, string: Seq[StringPart]): Vector[UrlPart] =
    (string map {
      stringPartToUrlPart(node, _)
    })(breakOut)

  protected def stringPartToUrlPart(node: Node, string: StringPart): UrlPart =
    string match {
      case StringIdentifier(id)        =>
        idToStringPart(node, id)
      case StaticFieldPart(str)     =>
        UrlString(str)
      case StringCycle                 =>
        UrlWithCycle
      case MissingStringFormatArgument =>
        MissingArgument
      case StringFormatPart(s)         =>
        UrlString(s)
    }

  def idToStringPart(node: Node, id: Identifier): UrlPart

  def getSource(node: Node, vn: ValueNumber): VariableSource
}
