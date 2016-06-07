package com.ibm.stringoid.retrieve.ir.append

import com.ibm.stringoid.retrieve.ir.ValueNumber
import com.ibm.wala.ssa.{SSAAbstractInvokeInstruction, SSAInstruction, SSAPhiInstruction}
import com.ibm.wala.types.TypeReference

object StringConcatUtil {

  private val SB_CONSTRUCTOR_PATTERNS = Set("java/lang/StringBuilder, <init>(", "java/lang/StringBuffer, <init>(")
  private val SB_APPEND_PATTERNS = Set("java/lang/StringBuilder, append(", "java/lang/StringBuffer, append(")
  private val SB_TOSTRING_PATTERNS = Set("java/lang/StringBuilder, toString()Ljava/lang/String;", "java/lang/StringBuffer, toString()Ljava/lang/String;")
  private val STRING_FORMAT_PATTERN = "java/lang/String, format("

  val INVOKE_INSTR_MSG = "String concatenation SSA conversion handles only invoke and phi instructions"

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation
   * that takes a String or CharSequence as a parameter?
   */
  def isSbConstructorWithStringParam(instr: SSAAbstractInvokeInstruction): Boolean =
    hasPattern(instr, SB_CONSTRUCTOR_PATTERNS map { _ + "L" })

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation?
   */
  def isSbConstructor(instr: SSAAbstractInvokeInstruction): Boolean =
    hasPattern(instr, SB_CONSTRUCTOR_PATTERNS)

  def isSbTostring(instr: SSAAbstractInvokeInstruction) =
    hasPattern(instr, SB_TOSTRING_PATTERNS)

  def isStringFormat(instr: SSAAbstractInvokeInstruction) =
    hasPattern(instr, Set(STRING_FORMAT_PATTERN))

  /**
   * Does this instruction correspond to a StringBuilder.append() that takes exactly one argument?
   * todo this means we currently don't support appending objects to specified parts of a string; only appending to the end
   */
  def isSbAppend(instr: SSAAbstractInvokeInstruction): Boolean =
    instr.getNumberOfParameters == 2 && // one for 'this', one for argument
      hasPattern(instr, SB_APPEND_PATTERNS)

  private[this] def hasPattern(instr: SSAAbstractInvokeInstruction, substrings: Set[String]): Boolean =
    substrings exists {
      instr.toString() contains _
    }

  def getDefs(instr: SSAAbstractInvokeInstruction): Array[ValueNumber] =
    if (isSbAppend(instr))
      Array[ValueNumber](instr getDef 0, instr getUse 0)
    else
      Array[ValueNumber](getSbConstructorDef(instr))

  def getSbConstructorDef(inv: SSAAbstractInvokeInstruction): ValueNumber =
    inv getUse 0

  def getFirstSbAppendDef(instr: SSAAbstractInvokeInstruction): ValueNumber =
    instr getDef 0

  def getSecondSbAppendDef(instr: SSAAbstractInvokeInstruction): ValueNumber =
    instr getDef 1

  def getSbAppendDefs(instr: SSAAbstractInvokeInstruction): (ValueNumber, ValueNumber) = {
    assert(isSbAppend(instr))
    (instr getDef 0, instr getUse 0)
  }

  def getAppendArgument(instr: SSAAbstractInvokeInstruction): ValueNumber =
    instr getUse 1

  def getSbConstructorArgument(instr: SSAAbstractInvokeInstruction): ValueNumber =
    instr getUse 1

  def getPhiUses(instr: SSAPhiInstruction): Seq[ValueNumber] =
    0 until instr.getNumberOfUses collect {
      case n: Int if (instr getUse n) >= 0 => instr getUse n
    } // todo this is to filter out -1 instructions. is this good? should it be > 0?

  def getSbToStringDef(inv: SSAAbstractInvokeInstruction) = inv.getDef

  def getSbToStringUse(inv: SSAAbstractInvokeInstruction) = inv.getUse(0)

  def hasStringFormatLocale(instr: SSAAbstractInvokeInstruction) =
    instr.getDeclaredTarget.toString contains "Locale"

  def getFirstStringFormatArg(instr: SSAAbstractInvokeInstruction) =
    if (hasStringFormatLocale(instr)) instr getUse 1 else instr getUse 0

  def getStringFormatArray(instr: SSAAbstractInvokeInstruction) =
    if (hasStringFormatLocale(instr)) instr getUse 2 else instr getUse 1

  /**
   * We need to redefine isSbConstructor because in DefUse the instruction is stored in a different form
   * and it is not an invoke instruction
   */
  def isSbConstructorOrFormatInDefUse(instr: SSAInstruction): Boolean =
    Option(instr).isDefined && (
      Set("Ljava/lang/String, format(",
        "new <Application,Ljava/lang/StringBuilder>",
        "new <Application,Ljava/lang/StringBuffer>",
        "new <Primordial,Ljava/lang/StringBuilder>",
        "new <Primordial,Ljava/lang/StringBuffer>",
        "new <Source,Ljava/lang/StringBuilder>",
        "new <Source,Ljava/lang/StringBuffer>") exists {
        instr.toString contains _
      })

  def hasStringReturnType(inv: SSAAbstractInvokeInstruction): Boolean =
    inv.getDeclaredResultType.toString contains "java/lang/String"

  def hasPrimitiveReturnType(inv: SSAAbstractInvokeInstruction): Boolean =
    Seq("B", "C", "D", "F", "I", "J", "S", "Z") contains inv.getDeclaredResultType.getName.toString

  def isMutable(tpe: TypeReference) =
    Seq("Ljava/lang/StringBuilder", "Ljava/lang/StringBuffer") exists tpe.toString.contains
}