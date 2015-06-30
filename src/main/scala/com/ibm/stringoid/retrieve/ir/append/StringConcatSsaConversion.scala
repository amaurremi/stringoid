package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.mutable

class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  private[this] case class DefUse(df: Array[ValueNumber], uses: Array[ValueNumber])

  private[this] val phiInstructions = mutable.Map.empty[SSACFG#BasicBlock, Set[SSAPhiInstruction]]
  private[this] val defUses         = mutable.Map.empty[SSAInstruction, DefUse]
  
  private[this] var valNumIterator  = Iterator.from(getMaxValueNumber + 1)

  /**
   * Does this instruction correspond to the creation of a new string, StringBuilder, or StringBuffer?
   */
  def isStringCreation(inst: SSAInstruction): Boolean =
    inst match {
      case i: SSAInvokeInstruction =>
        val target = i.getDeclaredTarget
        // todo: isInit, right params, string/stringbuilder/stringbuffer
        ???
    }

  /**
   * Does this instruction do string concatenation?
   */
  def isConcat(inst: SSAInstruction): Boolean = ???

  override def repairInstructionUses(
    inst: SSAInstruction,
    index: Int,
    newUses: Array[ValueNumber]
  ): Unit = {}

  override def initializeVariables(): Unit = {}

  override def getNextNewValueNumber: ValueNumber = valNumIterator.next()

  override def repairInstructionDefs(
    instr: SSAInstruction,
    index: Int, // todo why does it have both the index and instruction?
    newDefs: Array[ValueNumber],
    newUses: Array[ValueNumber]
  ): Unit = defUses += (instr -> DefUse(newDefs, newUses))

  override def getMaxValueNumber = ir.getSymbolTable.getMaxValueNumber

  override def pushAssignment(inst: SSAInstruction, index: Int, newRhs: Int): Unit = {}

  override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = ???

  override def isAssignInstruction(inst: SSAInstruction): Boolean = false
  
  override def skip(vn: ValueNumber): Boolean = false

  override def isLive(Y: SSACFG#BasicBlock, V: ValueNumber): Boolean = true

  override def getDef(inst: SSAInstruction, index: Int): Int = ???

  override def repairPhiUse(
    BB: SSACFG#BasicBlock,
    phiIndex: Int,
    rvalIndex: Int,
    newRval: ValueNumber
  ): Unit = ???

  override def setPhi(B: SSACFG#BasicBlock, index: Int, inst: SSAPhiInstruction): Unit = ???

  override def placeNewPhiAt(value: ValueNumber, Y: SSACFG#BasicBlock): Unit = ???

  override def repairPhiDefs(phi: SSAPhiInstruction, newDefs: Array[ValueNumber]): SSAPhiInstruction = ???

  override def getNumberOfDefs(inst: SSAInstruction): Int = ???

  override def getNumberOfUses(inst: SSAInstruction): Int = ???

  override def repairExit(): Unit = ???

  override def popAssignment(inst: SSAInstruction, index: Int): Unit = {}

  override def getUse(inst: SSAInstruction, index: Int): Int = ???

  override def isConstant(vn: ValueNumber): Boolean = ir.getSymbolTable isConstant vn
}
