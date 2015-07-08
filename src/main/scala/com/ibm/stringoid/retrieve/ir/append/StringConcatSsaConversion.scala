package com.ibm.stringoid.retrieve.ir.append

import com.ibm.stringoid.retrieve.ir.append.StringConcatUtil._
import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

/**
 * For a given instruction, what are its def and use value numbers?
 */
case class DefUses(defs: Array[StringSsaValueNumber], uses: Array[StringSsaValueNumber])

/**
 * Creates an SSA IR value numbering that is based on string concatenation
 */
class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  def apply(): StringConcatSsaConversion = {
    perform()
    this
  }

  /**
   * Generate a new value number, used by the the SSA builder
   */
  private[this] val newValNum = Iterator.from(getMaxValueNumber + 1)

  /**
   * Associates basic blocks with the new phi nodes created by the SSA builder
   */
  private[this] val basicBlockToPhis =
    mutable.Map.empty[SSACFG#BasicBlock, Array[SSAPhiInstruction]] withDefaultValue Array.empty[SSAPhiInstruction]

  /**
   * Maps instructions to its new defs and uses
   */
  private[this] val normalInstrToDefUses: mutable.Map[SSAInvokeInstruction, DefUses] = initialDefUses(ir)

  /**
   * Maps newly created value numbers back to the original value numbers
   */
  private[this] val newValToOldVal = mutable.Map.empty[StringSsaValueNumber, WalaValueNumber] withDefault { _.vn } // todo correct?

  /**
   * Maps the def of a newly created phi to the original value numbers corresponding to that phi's uses
   */
  private[this] val phiDefToOldVals = mutable.Map.empty[StringSsaValueNumber, Set[WalaValueNumber]]

  private[this] val INVOKE_INSTR_MSG = "String concatenation SSA conversion handles only invoke and phi instructions"

  /**
   * The instruction in which a value number was defined
   */
  def defToInstruction: Map[StringSsaValueNumber, SSAInstruction] = {
    val normal: Map[StringSsaValueNumber, SSAInvokeInstruction] = (normalInstrToDefUses flatMap {
      case (instr: SSAInvokeInstruction, DefUses(defs, _)) =>
        defs map {
          _ -> instr
        }
    })(breakOut)
    val phi: Map[StringSsaValueNumber, SSAPhiInstruction] =
      (for {
        phis <- basicBlockToPhis.values
        phi  <- phis
      } yield SSVN(phi.getDef) -> phi)(breakOut)
    // assuming SSA works correctly and def value numbers are always different
    normal ++ phi
  }

  /**
   * The instructions in which a value number was used. Currently this method is not used anywhere.
   */
  def useToInstructions: Map[StringSsaValueNumber, Set[SSAInstruction]] = {
    val instructions = normalInstrToDefUses.keys ++ basicBlockToPhis.keys

    def createUseMap(
      prevMap: Map[StringSsaValueNumber, Set[SSAInstruction]],
      uses: Array[StringSsaValueNumber],
      instr: SSAInstruction
    ) = uses.foldLeft(prevMap) {
      case (prevMap2, use) =>
        val oldInstructions = prevMap2 getOrElse(use, Set.empty[SSAInstruction])
        prevMap2 updated(use, oldInstructions + instr)
    }

    instructions.foldLeft(Map.empty[StringSsaValueNumber, Set[SSAInstruction]]) {
      case (prevMap, instr: SSAInvokeInstruction) =>
        createUseMap(prevMap, normalInstrToDefUses(instr).uses, instr)
      case (prevMap, instr: SSAPhiInstruction)    =>
        val uses = 0 until instr.getNumberOfUses map instr.getUse
        createUseMap(prevMap, (uses map SSVN.apply)(breakOut), instr)
      case _                                      =>
        throw new UnsupportedOperationException(INVOKE_INSTR_MSG)
    }
  }

  /**
   * The immutable publicly visible result of instructions with its new defs and uses
   */
  def normalInstrToDefUsesMap = normalInstrToDefUses.toMap[SSAInvokeInstruction, DefUses]

  /**
   * Get the original value number corresponding to a value number created by this SSA conversion.
   * If the new value number is a phi instruction, returns all the original value numbers that
   * appear as the instruction's uses.
   */
  def getOldVals(newVal: StringSsaValueNumber): Set[WalaValueNumber] =
    phiDefToOldVals getOrElse (newVal, Set(newValToOldVal(newVal))) // todo correct?

  private[this] def initialDefUses(ir: IR): mutable.Map[SSAInvokeInstruction, DefUses] = {
    val tuples: Iterator[(SSAInvokeInstruction, DefUses)] = ir.iterateAllInstructions collect {
      case instr: SSAInvokeInstruction if isSbConstructor(instr) =>
        val uses = if (isSbConstructorWithRefParam(instr)) getUses(instr) map SSVN.apply
                   else Array.empty[StringSsaValueNumber]
        instr -> DefUses(getDefs(instr) map SSVN.apply, uses)
      case instr: SSAInvokeInstruction if isSbAppend(instr) =>
        instr -> DefUses(getDefs(instr) map SSVN.apply, getUses(instr) map SSVN.apply)
    }
    mutable.Map(tuples.toSeq: _*)
  }

  protected override def getNextNewValueNumber: WalaValueNumber = newValNum.next()

  protected override def repairInstructionDefs(
    instr: SSAInstruction,
    index: Int, // todo why does it have both the index and instruction?
    newDefs: Array[Int],
    newUses: Array[Int]
  ): Unit =
    instr match {
      case i: SSAInvokeInstruction =>
        val newDefVns = newDefs map SSVN.apply
        val newUseVns = newUses map SSVN.apply
        def updateVals(oldVals: Array[WalaValueNumber], newVals: Array[StringSsaValueNumber]) =
          oldVals zip newVals foreach {
          case (o, n) =>
            newValToOldVal += n -> o
        }
        updateVals(getDefs(i), newDefVns)
        updateVals(getUses(i), newUseVns)
        normalInstrToDefUses += (i -> DefUses(newDefVns, newUseVns))
      case _                       =>
        throw new UnsupportedOperationException(INVOKE_INSTR_MSG)
    }

  protected override def getMaxValueNumber: WalaValueNumber = symbolTable.getMaxValueNumber

  protected override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = basicBlockToPhis(B)(index)

  protected override def getDef(inst: SSAInstruction, index: Int): Int =
    inst match {
      case i: SSAInvokeInstruction =>
        normalInstrToDefUses(i).defs(index).vn
      case p: SSAPhiInstruction    =>
        p.getDef(index)
      case _                       =>
        throw new UnsupportedOperationException(INVOKE_INSTR_MSG)
    }

  override def repairPhiUse(
    BB: SSACFG#BasicBlock,
    phiIndex: Int,
    rvalIndex: Int,
    newRval: Int
  ): Unit = {
    val phiInstruction = basicBlockToPhis(BB)(phiIndex)
    val oldInstr = phiInstruction
    val oldUses1 = 0 until rvalIndex map oldInstr.getUse
    val oldUses2 = rvalIndex until oldInstr.getNumberOfUses map oldInstr.getUse
    val newUses  = (oldUses1 :+ newRval) ++ oldUses2
    phiInstruction setValues newUses.toArray[WalaValueNumber]
    phiDefToOldVals += (SSVN(phiInstruction.getDef) -> getOldVals(SSVN(newRval))) // todo correct?
  }

  protected override def setPhi(B: SSACFG#BasicBlock, index: Int, inst: SSAPhiInstruction): Unit =
    basicBlockToPhis(B)(index) = inst

  protected override def placeNewPhiAt(value: Int, Y: SSACFG#BasicBlock): Unit = { // todo it's confusing that value doesn't indicate the position in the phi array, given the method name
    val params = Array[WalaValueNumber](CFG getPredNodeCount Y)
    params.indices foreach { params(_) = value }

    val phi     = new SSAPhiInstruction(SSAInstruction.NO_INDEX, value, params)
    val oldPhis = basicBlockToPhis(Y)
    val newPhis = new Array[SSAPhiInstruction](oldPhis.length + 1)
    oldPhis copyToArray (newPhis, 1)  // todo why do we put the new phi at the beginning? (saw in the other SSA implementation)
    newPhis(0) = phi

    basicBlockToPhis += (Y -> newPhis)
    val phiDef = SSVN(value)
    phiDefToOldVals  += (phiDef -> getOldVals(phiDef)) // todo correct?
  }

  protected override def repairPhiDefs(phi: SSAPhiInstruction, newDefs: Array[Int]): SSAPhiInstruction =
    phi.copyForSSA(ir.getMethod.getDeclaringClass.getClassLoader.getInstructionFactory, newDefs, null).asInstanceOf[SSAPhiInstruction]

  protected override def getNumberOfDefs(instr: SSAInstruction): Int =
    instr match {
      case i: SSAInvokeInstruction =>
        normalInstrToDefUses get i match {
          case Some(defUse) => defUse.defs.length
          case None         => 0
        }
      case p: SSAPhiInstruction    =>
        p.getDef
      case _                       =>
        0
    }

  protected override def getNumberOfUses(instr: SSAInstruction): Int =
    instr match {
      case i: SSAInvokeInstruction =>
        normalInstrToDefUses get i match {
          case Some(defUse) => defUse.uses.length
          case None         => 0
        }
      case p: SSAPhiInstruction    =>
        p.getNumberOfUses
      case _                       =>
        0
    }

  protected override def getUse(instr: SSAInstruction, index: Int): Int =
    instr match {
      case i: SSAInvokeInstruction =>
        normalInstrToDefUses(i).uses(index).vn
      case p: SSAPhiInstruction    =>
        p getUse index  // todo correct?
      case _                       =>
        throw new UnsupportedOperationException(INVOKE_INSTR_MSG)
    }

  protected override def isConstant(vn: Int): Boolean = symbolTable isConstant vn

  protected override def repairExit(): Unit = {}

  protected override def popAssignment(instr: SSAInstruction, index: Int): Unit = {}

  protected override def isAssignInstruction(inst: SSAInstruction): Boolean = false

  protected override def skip(vn: Int): Boolean = false

  protected override def isLive(Y: SSACFG#BasicBlock, V: Int): Boolean = true

  protected override def repairInstructionUses(instr: SSAInstruction, index: Int, newUses: Array[Int]): Unit = {}

  protected override def pushAssignment(instr: SSAInstruction, index: Int, newRhs: Int): Unit = {}

  protected override def initializeVariables(): Unit = {}
}
