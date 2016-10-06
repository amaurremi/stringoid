package com.ibm.stringoid.retrieve.ir.append.fixedpoint.stringAppend

import java.util.regex.Pattern

import com.ibm.stringoid.retrieve.ir._
import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append.fixedpoint.StringAutomata
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAArrayStoreInstruction}

import scala.collection.JavaConversions._
import scala.collection.mutable

object StringFormatSpecifiers {

  val formatSpecifier = "%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])"
  val fsPattern       = Pattern.compile(formatSpecifier)
}

trait StringFormatSpecifiers extends StringAutomata {

  import StringFormatSpecifiers._

  sealed trait FormattedString
  case class FormattedStringPart(substring: String) extends FormattedString
  case class Specifier(useNumber: Int) extends FormattedString

  /**
   * Returns the sequence of string parts and specifiers, along with the number of specifiers.
   */
  def parse(s: String): (Iterable[FormattedString], Int) = {
    var specifierCount = 0
    val matcher = fsPattern matcher s
    val buffer  = mutable.UnrolledBuffer.empty[FormattedString]
    var index   = 0
    val length  = s.length
    while ((index < length) && (matcher find index)) {
      if (matcher.start != index)
        buffer add FormattedStringPart(s substring (index, matcher.start))
      specifierCount = specifierCount + 1
      buffer add Specifier(specifierCount)
      index = matcher.end
    }
    if (index < length)
      buffer add FormattedStringPart(s substring index)
    (buffer, specifierCount)
  }

  private[this] def getArrayValNums(node: Node, arrayDef: ValueNumber): Iterator[ValueNumber] =
    node.getDu getUses arrayDef collect {
      case store: SSAArrayStoreInstruction =>
        store getUse 2
    }

  def getStringFormatArgs(instr: SSAAbstractInvokeInstruction, node: Node): Iterator[ValueNumber] = {
    val formatArrayValNum = getStringFormatArray(instr)
    getArrayValNums(node, formatArrayValNum)
  }

  /**
    * Produce sequence of [[StringPart]]s for String.format arguments in the right concatenation order,
    * in the form of an automaton.
    * This method does not substitute the value numbers with the corresponding automata or [[ASBO]]s.
    */
  def reorderStringFormatArgs(instr: SSAAbstractInvokeInstruction, node: Node): Vector[Vector[StringPart]] = {
    val firstArg = getFirstStringFormatArg(instr)
    val formatArrayValNum = getStringFormatArray(instr)
    val table = node.getIr.getSymbolTable
    if (table isStringConstant firstArg) {
      val argValNums = getArrayValNums(node, formatArrayValNum)
      val (formattedParts, specifierNum) = parse(table getStringValue firstArg)
      formattedParts.foldLeft(Vector.empty[Vector[StringPart]]) {
        case (parts, FormattedStringPart(string)) =>
          val stringPart = StaticFieldPart(string)
          if (parts.isEmpty) Vector(Vector(stringPart))
          else parts map {
            _ :+ stringPart
          }
        case (parts, Specifier(count)) =>
          val newVariables =
            if (argValNums.hasNext)
              createAutomaton(node, createId(argValNums.next(), node)).iterator.toVector
            else Vector(Seq(MissingStringFormatArgument))
          if (parts.isEmpty) newVariables map { _.toVector }
          else for {
            v <- newVariables
            p <- parts
          } yield p ++ v
      }
    } else Vector.empty[Vector[StringPart]]
  }
}
