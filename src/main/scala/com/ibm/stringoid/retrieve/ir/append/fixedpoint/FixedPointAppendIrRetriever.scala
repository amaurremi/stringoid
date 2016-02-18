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
import com.ibm.wala.util.debug.UnimplementedError

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
        if hasUrls(node)
      } yield getAutomaton(node)
    AutomataWithSources(automataWithSources, walaTime)
  }

  def hasUrls(node: Node): Boolean

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

  protected final def getAutomaton(node: Node): (Json, Method) = {
    val automaton = stringAppends(node, fieldToAutomaton).toDFA.toJson {
      sp: StringPart =>
        stringPartToUrlPart(node, sp).asJson.toString()
    }
    (automaton.toString.parseOption.get, node.getIr.getMethod.toString)
  }

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

  protected final def idToStringPart(node: Node, id: Identifier): UrlPart = {
    val ir = node.getIr
    val table = ir.getSymbolTable
    val valNum = valNum(id)
    if (table isConstant valNum) {
      val string = if (table isNullConstant valNum) "null" else (table getConstantValue valNum).toString
      UrlString(string)
    }
    else {
      val typeName =
        try getTypeAbstraction(ir, valNum).toString
        catch {
          case _: UnimplementedError =>
            "undefined"
        }
      VariableType(typeName, getSource(node, valNum))
    }
  }

  def getSource(node: Node, vn: ValueNumber): VariableSource
}
