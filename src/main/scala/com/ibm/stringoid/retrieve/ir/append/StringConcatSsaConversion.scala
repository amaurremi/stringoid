package com.ibm.stringoid.retrieve.ir.append

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

/**
 * For a given instruction, what are its def and use value numbers?
 */
case class DefUses(defs: Array[ValueNumber], uses: Array[ValueNumber])

/**
 * Creates an SSA IR value numbering that is based on string concatenation
 */
class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  /**
   * Generate a new value number, used by the the SSA builder
   */
  private[this] val newValNum  = Iterator.from(getMaxValueNumber + 1)

  /**
   * Associates basic blocks with the new phi nodes created by the SSA builder
   */
  private[this] val basicBlockToPhis =
    mutable.Map.empty[SSACFG#BasicBlock, Array[SSAPhiInstruction]] withDefaultValue Array.empty[SSAPhiInstruction]

  /**
   * Maps instructions to its new defs and uses
   */
  private[this] val instrToDefUses = initialDefUses(ir)

  /**
   * Maps newly created value numbers back to the original value numbers
   */
  private[this] val newValToOldVal = mutable.Map.empty[ValueNumber, ValueNumber] withDefault { _ } // todo correct?

  /**
   * Maps the def of a newly created phi to the original value numbers corresponding to that phi's uses
   */
  private[this] val phiDefToOldVals = mutable.Map.empty[ValueNumber, Set[ValueNumber]]

  /**
   * The instruction in which a value number was defined
   */
  def defToInstruction: Map[ValueNumber, SSAInvokeInstruction] =
    (instrToDefUses flatMap {
      case (instr: SSAInvokeInstruction, DefUses(defs, _)) =>
        defs map { _ -> instr }
    })(breakOut)

  /**
   * The instructions in which a value number was used. Currently this method is not used anywhere.
   */
  def useToInstructions: Map[ValueNumber, Set[SSAInvokeInstruction]] =
    instrToDefUses.foldLeft(Map.empty[ValueNumber, Set[SSAInvokeInstruction]]) {
      case (prevMap, (instr: SSAInvokeInstruction, DefUses(_, uses))) =>
        uses.foldLeft(prevMap) {
          case (prevMap2, use) =>
            prevMap2 updated (use, (prevMap2 getOrElse (use, Set.empty[SSAInvokeInstruction])) + instr)
        }
    }

  /**
   * The immutable publicly visible result of instructions with its new defs and uses
   */
  def instrToDefUsesMap: Map[SSAInvokeInstruction, DefUses] = instrToDefUses.toMap

  /**
   * Get the original value number corresponding to a value number created by this SSA conversion.
   * If the new value number is a phi instruction, returns all the original value numbers that
   * appear as the instruction's uses.
   */
  def getOldVals(newVal: ValueNumber): Set[ValueNumber] =
    phiDefToOldVals getOrElse (newVal, Set(newValToOldVal(newVal))) // todo correct?

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
    val phiInstruction = basicBlockToPhis(BB)(phiIndex)
    val oldInstr = phiInstruction
    val oldUses1 = rvalIndex + 1 to oldInstr.getNumberOfUses map oldInstr.getUse
    val oldUses2 = 0 to rvalIndex map oldInstr.getUse
    val newUses  = (oldUses1 :+ newRval) ++ oldUses2
    phiInstruction setValues newUses.toArray[ValueNumber]
    phiDefToOldVals += (phiInstruction.getDef -> getOldVals(newRval)) // todo correct?
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
    phiDefToOldVals  += (value -> getOldVals(value)) // todo correct?
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
