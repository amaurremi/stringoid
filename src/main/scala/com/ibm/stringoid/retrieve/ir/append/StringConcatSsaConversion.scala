package com.ibm.stringoid.retrieve.ir.append

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.mutable

case class DefUses(defs: Array[ValueNumber], uses: Array[ValueNumber])

class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  private[this] val newValNum        = Iterator.from(getMaxValueNumber + 1)

  private[this] val basicBlockToPhis =
    mutable.Map.empty[SSACFG#BasicBlock, Array[SSAPhiInstruction]] withDefaultValue Array.empty[SSAPhiInstruction]
  private[this] val instrToDefUses   = initialDefUses(ir)
  private[this] val newValToOldVal   = mutable.Map.empty[ValueNumber, ValueNumber]
  private[this] val phiDefToUses        = mutable.Map.empty[ValueNumber, Set[ValueNumber]]

  def defUses: Map[SSAInstruction, DefUses] = instrToDefUses.toMap

  /**
   * Get the original value number corresponding to a value number created by this SSA conversion.
   * If the new value number is a phi instruction, returns all the original value numbers that
   * appear as the instruction's uses.
   */
  def getOldVals(newVal: ValueNumber): Set[ValueNumber] = {
    if (phiDefToUses contains newVal)
      phiDefToUses(newVal) flatMap getOldVals
    else Set(newValToOldVal(newVal))
  }

  private[this] def initialDefUses(ir: IR): mutable.Map[SSAInstruction, DefUses] = {
    val tuples: Iterator[(SSAInvokeInstruction, DefUses)] = ir.iterateAllInstructions collect {
      case instr: SSAInvokeInstruction if isSbConstructor(instr) =>
        val uses = if (isSbConstructorWithRefParam(instr)) getUses(instr)
                   else Array.empty[ValueNumber]
        instr -> DefUses(getDefs(instr), uses)
      case instr: SSAInvokeInstruction if isSbAppend(instr) =>
        instr -> DefUses(getDefs(instr), getUses(instr))
    }
    mutable.Map(tuples.toSeq: _*)
  }

  protected override def getNextNewValueNumber: ValueNumber = newValNum.next()

  protected override def repairInstructionDefs(
    instr: SSAInstruction,
    index: Int, // todo why does it have both the index and instruction?
    newDefs: Array[ValueNumber],
    newUses: Array[ValueNumber]
  ): Unit =
    instr match {
      case i: SSAInvokeInstruction =>
        def updateVals(oldVals: Array[ValueNumber], newVals: Array[ValueNumber]) =
          oldVals zip newVals foreach {
          case (o, n) =>
            newValToOldVal += n -> o
        }
        updateVals(getDefs(i), newDefs)
        updateVals(getUses(i), newUses)
        instrToDefUses += (instr -> DefUses(newDefs, newUses))
      case _                       =>
        throw new UnsupportedOperationException("String concatenation SSA conversion handles only invoke instructions")
    }

  protected override def getMaxValueNumber: ValueNumber = symbolTable.getMaxValueNumber

  protected override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = basicBlockToPhis(B)(index)

  protected override def getDef(inst: SSAInstruction, index: Int): Int = instrToDefUses(inst).defs(index)

  override def repairPhiUse(
    BB: SSACFG#BasicBlock,
    phiIndex: Int,
    rvalIndex: Int,
    newRval: ValueNumber
  ): Unit = {
    val oldInstr = basicBlockToPhis(BB)(phiIndex)
    val oldUses1 = rvalIndex + 1 to oldInstr.getNumberOfUses map oldInstr.getUse
    val oldUses2 = 0 to rvalIndex map oldInstr.getUse
    val newUses  = (oldUses1 :+ newRval) ++ oldUses2
    basicBlockToPhis(BB)(phiIndex) setValues newUses.toArray[ValueNumber]
  }

  protected override def setPhi(B: SSACFG#BasicBlock, index: Int, inst: SSAPhiInstruction): Unit =
    basicBlockToPhis(B)(index) = inst

  protected override def placeNewPhiAt(value: ValueNumber, Y: SSACFG#BasicBlock): Unit = {
    val params: Array[ValueNumber] = Array[ValueNumber](CFG getPredNodeCount Y)
    0 to params.length foreach { params(_) = value }

    val phi     = new SSAPhiInstruction(SSAInstruction.NO_INDEX, value, params)
    val oldPhis = basicBlockToPhis(Y)
    val newPhis = new Array[SSAPhiInstruction](oldPhis.length + 1)
    oldPhis copyToArray newPhis

    basicBlockToPhis += (Y -> newPhis)
  }

  protected override def repairPhiDefs(phi: SSAPhiInstruction, newDefs: Array[ValueNumber]): SSAPhiInstruction =
    phi.copyForSSA(ir.getMethod.getDeclaringClass.getClassLoader.getInstructionFactory, newDefs, null).asInstanceOf[SSAPhiInstruction]

  protected override def getNumberOfDefs(inst: SSAInstruction): Int =
    instrToDefUses get inst match {
      case Some(defUse) => defUse.defs.length
      case None         => 0
    }

  protected override def getNumberOfUses(inst: SSAInstruction): Int =
    instrToDefUses get inst match {
      case Some(defUse) => defUse.uses.length
      case None         => 0
    }

  protected override def getUse(inst: SSAInstruction, index: Int): Int = instrToDefUses(inst).uses(index)

  protected override def isConstant(vn: ValueNumber): Boolean = symbolTable isConstant vn

  protected override def repairExit(): Unit = {}

  protected override def popAssignment(inst: SSAInstruction, index: Int): Unit = {}

  protected override def isAssignInstruction(inst: SSAInstruction): Boolean = false

  protected override def skip(vn: ValueNumber): Boolean = false

  protected override def isLive(Y: SSACFG#BasicBlock, V: ValueNumber): Boolean = true

  protected override def repairInstructionUses(inst: SSAInstruction, index: Int, newUses: Array[ValueNumber]): Unit = {}

  protected override def pushAssignment(inst: SSAInstruction, index: Int, newRhs: Int): Unit = {}

  protected override def initializeVariables(): Unit = {}
}
