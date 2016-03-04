package com.ibm.stringoid.retrieve.ir.append.fixedpoint

import argonaut.Argonaut._
import argonaut._
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

  protected final def getAutomataWithSources: AutomataWithSources = {
    val TimeResult(nodes, walaTime) = TimeResult(getEntryNodes)
    val automataWithSources: Iterator[(Json, Method)] =
      nodes collect {
        case node if hasUrls(node) =>
          getAutomaton(node)
      }
    AutomataWithSources(automataWithSources, walaTime)
  }

  /**
    * assumes `node.getIr` is not `null`
    */
  def getAutomaton(node: Node): (Json, Method) = {
    val automaton = stringAppends(node, fieldToAutomaton).automaton.toDFA.toJson {
      sp: StringPart =>
        getStringPartToUrlPart(node, sp).asJson.toString()
    }
    (automaton.toString.parseOption.get, node.getIr.getMethod.toString)
  }

  def getStringPartToUrlPart(node: Node, sp: StringPart): UrlPart

  def hasUrls(node: Node): Boolean

  /**
    * collect all assignments to static fields into map from field to sum-automaton
    */
  lazy val fieldToAutomaton: Map[FieldReference, StringPartAutomaton] =
    getEntryNodes.foldLeft(Map.empty[FieldReference, StringPartAutomaton]) {
      case (oldMap, node) if hasIr(node) =>
        val ir = node.getIr
        ir.iterateNormalInstructions().foldLeft(oldMap) {
          case (oldMap2, instr: SSAPutInstruction) =>
            val field    = instr.getDeclaredField
            val writeVal = instr.getVal
            val table    = ir.getSymbolTable
            if (table isConstant writeVal) {
              val stringPart = StringPartAutomaton(StaticFieldPart(String.valueOf(table getConstantValue writeVal)))
              val automaton =
                if (oldMap2 contains field) oldMap2(field) | stringPart
                else stringPart
              oldMap2 + (field -> automaton)
            } else oldMap2
          case (oldMap2, _)                        =>
            oldMap2
        }
      case (oldMap, _)                    =>
        oldMap
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
            seq       <- automaton.automaton.iterator
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

  protected final def idToStringPart(node: Node, vn: ValueNumber): UrlPart = {
    val ir = node.getIr
    val table = ir.getSymbolTable
    if (table isConstant vn) {
      val string = if (table isNullConstant vn) "null" else (table getConstantValue vn).toString
      UrlString(string)
    }
    else {
      val typeName =
        try getTypeAbstraction(ir, vn).toString
        catch {
          case _: UnimplementedError =>
            "undefined"
        }
      VariableType(typeName, getSource(node, vn))
    }
  }

  protected final def getSource(node: Node, vn: ValueNumber): VariableSource =
    if (node.getIr.getSymbolTable.isParameter(vn))
      Parameter
    else
      node.getDu.getDef(vn) match {
        case fieldAccess: SSAFieldAccessInstruction =>
          FieldAccess(fieldAccess.getDeclaredField.toString)
        case invoke: SSAAbstractInvokeInstruction   =>
          MethodReturn(invoke.getDeclaredTarget.toString)
        case _                                      =>
          UnknownSource
      }
}
