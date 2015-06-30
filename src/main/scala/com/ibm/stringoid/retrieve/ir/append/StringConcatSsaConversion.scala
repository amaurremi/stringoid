package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  override def repairInstructionUses(
    inst: SSAInstruction,
    index: Int,
    newUses: Array[Int]
  ): Unit = ???

  override def initializeVariables(): Unit = ???

  override def getNextNewValueNumber: Int = ???

  override def repairInstructionDefs(
    inst: SSAInstruction,
    index: Int,
    newDefs: Array[Int],
    newUses: Array[Int]
  ): Unit = ???

  override def getMaxValueNumber: Int = ???

  override def pushAssignment(inst: SSAInstruction, index: Int, newRhs: Int): Unit = ???

  override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = ???

  override def isAssignInstruction(inst: SSAInstruction): Boolean = ???

  override def skip(vn: Int): Boolean = ???

  override def isLive(Y: SSACFG#BasicBlock, V: Int): Boolean = ???

  override def getDef(inst: SSAInstruction, index: Int): Int = ???

  override def repairPhiUse(
    BB: SSACFG#BasicBlock,
    phiIndex: Int,
    rvalIndex: Int,
    newRval: Int
  ): Unit = ???

  override def setPhi(B: SSACFG#BasicBlock, index: Int, inst: SSAPhiInstruction): Unit = ???

  override def placeNewPhiAt(value: Int, Y: SSACFG#BasicBlock): Unit = ???

  override def repairPhiDefs(phi: SSAPhiInstruction, newDefs: Array[Int]): SSAPhiInstruction = ???

  override def getNumberOfDefs(inst: SSAInstruction): Int = ???

  override def getNumberOfUses(inst: SSAInstruction): Int = ???

  override def repairExit(): Unit = ???

  override def popAssignment(inst: SSAInstruction, index: Int): Unit = ???

  override def getUse(inst: SSAInstruction, index: Int): Int = ???

  override def isConstant(valueNumber: Int): Boolean = ???
}
