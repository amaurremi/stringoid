package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.ssa.SSAInvokeInstruction

object StringConcatUtil {

  private val SB_CONSTRUCTOR_PREFIX = "invokespecial < Application, Ljava/lang/StringBuilder, <init>("
  private val SB_APPEND_PREFIX      = "invokevirtual < Application, Ljava/lang/StringBuilder, append("

  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation
   * that takes a String or CharSequence as a parameter?
   * todo StringBuffer
   */
  def isSbConstructorWithRefParam(instr: SSAInvokeInstruction): Boolean =
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

  def getDefs(instr: SSAInvokeInstruction): Array[ValueNumber] =
    Array[ValueNumber](instr getDef 0, instr getUse 0)

  def getUses(instr: SSAInvokeInstruction): Array[ValueNumber] =
    Array[ValueNumber](instr getUse 0, instr getUse 1)
}
