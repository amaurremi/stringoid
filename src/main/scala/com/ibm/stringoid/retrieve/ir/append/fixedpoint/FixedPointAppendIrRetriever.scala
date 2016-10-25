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
import scala.collection.mutable

abstract class FixedPointAppendIrRetriever(
  override val config: AnalysisConfig
)
  extends IrUrlRetriever with StringAppendModule {

  override def getResult: Json =
    if (config.outputUrls)
      getUrlsWithSources.asJson
    else
      getAutomataWithSources.aws.toList.asJson

  protected def getAutomataWithSources: AutomataWithSources

  def hasUrls(node: Node): Boolean

  /**
    * collect all assignments to static fields into map from field to sum-automaton
    */
  override lazy val fieldToAutomaton: FieldToAutomaton = TimeResult("field-to-automaton", {
    val resultMap = mutable.Map.empty[FieldReference, StringPartAutomaton]
    for {
      node  <- getAllNodes
      if hasIr(node)
      ir     = node.getIr
      instr <- ir.iterateNormalInstructions()
    } {
      instr match {
        case pi: SSAPutInstruction =>
          val field = pi.getDeclaredField
          val writeVal = pi.getVal
          val table = ir.getSymbolTable
          if (table isConstant writeVal) {
            val stringPart = newAuto(StaticFieldPart(String.valueOf(table getConstantValue writeVal)))
            val automaton =
              if (resultMap contains field) resultMap(field) | stringPart
              else stringPart
            resultMap += (field -> automaton)
          }
        case _                    => ()
      }
    }
    resultMap
  })

  protected def urlPrefixes(vn: ValueNumber, node: Node): Seq[StringPart] = {
    val table = node.getIr.getSymbolTable
    val inTable = (table isStringConstant vn) && isUrlPrefix(table getStringValue vn)
    if (inTable)
      Seq(StringIdentifier(createId(vn, node)))
    else {
      node.getDu getDef vn match {
        case instr: SSAFieldAccessInstruction =>
          val strings = for {
            automaton <- (fieldToAutomaton get instr.getDeclaredField).toSeq
            seq       <- automaton.iterator
            if seq.nonEmpty
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
