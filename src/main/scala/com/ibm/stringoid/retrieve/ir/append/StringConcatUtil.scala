package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.ssa.{SSAInvokeInstruction, SSAPhiInstruction}

object StringConcatUtil {

  private val SB_CONSTRUCTOR_PATTERN = "java/lang/StringBuilder, <init>("
  private val SB_APPEND_PATTERN      = "java/lang/StringBuilder, append("
  private val SB_TOSTRING_PATTERN    = "java/lang/StringBuilder, toString()Ljava/lang/String;"
  private val STRING_FORMAT_PATTERN  = "java/lang/String, format("

  val INVOKE_INSTR_MSG = "String concatenation SSA conversion handles only invoke and phi instructions"

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation
   * that takes a String or CharSequence as a parameter?
   */
  def isSbConstructorWithStringParam(instr: SSAInvokeInstruction): Boolean =
    hasPrefix(instr, SB_CONSTRUCTOR_PATTERN + "L")

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation?
   */
  def isSbConstructor(instr: SSAInvokeInstruction): Boolean =
    hasPrefix(instr, SB_CONSTRUCTOR_PATTERN)

  def isSbTostring(instr: SSAInvokeInstruction) =
    hasPrefix(instr, SB_TOSTRING_PATTERN)

  def isStringFormat(instr: SSAInvokeInstruction) =
    hasPrefix(instr, STRING_FORMAT_PATTERN)

  /**
   * Does this instruction correspond to a StringBuilder.append() that takes exactly one argument?
   * todo this means we currently don't support appending objects to specified parts of a string; only appending to the end
   */
  def isSbAppend(instr: SSAInvokeInstruction): Boolean =
    instr.getNumberOfParameters == 2 && // one for 'this', one for argument
      hasPrefix(instr, SB_APPEND_PATTERN)

  private[this] def hasPrefix(instr: SSAInvokeInstruction, prefix: String): Boolean =
    instr.toString() contains prefix

  def getDefs(instr: SSAInvokeInstruction): Array[ValueNumber] =
    if (isSbAppend(instr))
      Array[ValueNumber](instr getDef 0, instr getUse 0)
    else
      Array[ValueNumber](getSbConstructorDef(instr))

  def getSbConstructorDef(inv: SSAInvokeInstruction): ValueNumber =
    inv getUse 0

  def getFirstSbAppendDef(instr: SSAInvokeInstruction): ValueNumber =
    instr getDef 0

  def getSbAppendDefs(instr: SSAInvokeInstruction): (ValueNumber, ValueNumber) = {
    assert(isSbAppend(instr))
    (instr getDef 0, instr getUse 0)
  }

  def getAppendArgument(instr: SSAInvokeInstruction): ValueNumber =
    instr getUse 1

  def getSbConstructorArgument(instr: SSAInvokeInstruction): ValueNumber =
    instr getUse 1

  def getPhiUses(instr: SSAPhiInstruction): Seq[ValueNumber] =
    0 until instr.getNumberOfUses collect {
      case n: Int if (instr getUse n) >= 0 => instr getUse n
    } // todo this is to filter out -1 instructions. is this good? should it be > 0?

  def getSbToStringDef(inv: SSAInvokeInstruction) = inv.getDef

  def getSbToStringUse(inv: SSAInvokeInstruction) = inv.getUse(0)

  def hasStringFormatLocale(instr: SSAInvokeInstruction) =
    instr.getDeclaredTarget.toString contains "Locale"

  def getFirstStringFormatArg(instr: SSAInvokeInstruction) = {
    if (hasStringFormatLocale(instr)) instr getUse 1 else instr getUse 0
  }
}
