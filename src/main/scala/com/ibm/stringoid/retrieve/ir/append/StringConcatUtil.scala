package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.ssa.SSAInvokeInstruction

object StringConcatUtil {

  private val SB_CONSTRUCTOR_PREFIX = "invokespecial < Application, Ljava/lang/StringBuilder, <init>("
  private val SB_APPEND_PREFIX      = "invokevirtual < Application, Ljava/lang/StringBuilder, append("

  val INVOKE_INSTR_MSG = "String concatenation SSA conversion handles only invoke and phi instructions"

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation
   * that takes a String or CharSequence as a parameter?
   * todo StringBuffer
   */
  def isSbConstructorWithStringParam(instr: SSAInvokeInstruction): Boolean =
    instr.toString() startsWith SB_CONSTRUCTOR_PREFIX + "L"

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation?
   * todo StringBuffer
   */
  def isSbConstructor(instr: SSAInvokeInstruction): Boolean =
    instr.toString() startsWith SB_CONSTRUCTOR_PREFIX

  /**
   * Does this instruction correspond to a StringBuilder.append() that takes exactly one argument?
   * todo this means we currently don't support appending objects to specified parts of a string; only appending to the end
   */
  def isSbAppend(instr: SSAInvokeInstruction): Boolean =
    instr.getNumberOfParameters == 2 && // one for 'this', one for argument
      (instr.toString() contains SB_APPEND_PREFIX)

  def getDefs(instr: SSAInvokeInstruction): Array[WalaValueNumber] =
    if (isSbAppend(instr))
      Array[WalaValueNumber](instr getDef 0, instr getUse 0)
    else
      Array[WalaValueNumber](instr getUse 0)

  def getUses(instr: SSAInvokeInstruction): Array[WalaValueNumber] =
    if (isSbConstructorWithStringParam(instr) || isSbAppend(instr))
      Array[WalaValueNumber](instr getUse 0, instr getUse 1)
    else
      Array.empty[WalaValueNumber]
}
