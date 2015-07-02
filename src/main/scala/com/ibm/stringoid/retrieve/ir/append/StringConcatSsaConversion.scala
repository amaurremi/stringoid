package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.{breakOut, mutable}

class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  case class DefUses(defs: Array[ValueNumber], uses: Array[ValueNumber])

  private[this] val basicBlockToPhis =
    mutable.Map.empty[SSACFG#BasicBlock, Array[SSAPhiInstruction]] withDefaultValue Array.empty[SSAPhiInstruction]

  private[this] val defUses          = initialDefUses(ir)

  private[this] val VAL_NUM_START    = 1
  private[this] var newValNum        = Iterator.from(VAL_NUM_START)

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
  
  /**
   * Does this instruction correspond to a new StringBuilder constructor invocation?
   * If it does it returns a string whose prefix is the parameter type of the constructor.
   * todo StringBuffer
   */
  private[this] def sbConstructor(instr: SSAInvokeInstruction): Option[String] = {
    val string = instr.toString()
    val prefix: String = "invokespecial < Application, Ljava/lang/StringBuilder, <init>("
    if (string startsWith prefix)
      Some(string substring prefix.length)
    else None
  }

  /**
   * Does this instruction correspond to a StringBuilder.append() that takes exactly one argument?
   * todo this means we currently don't support appending objects to specified parts of a string; only appending to the end
   */
  private[this] def sbAppend(instr: SSAInvokeInstruction): Boolean = {
    instr.getNumberOfParameters == 2 && // one for 'this', one for argument
      (instr.toString() contains "invokevirtual < Application, Ljava/lang/StringBuilder, append(")
  }

  private[this] def getDefs(instr: SSAInvokeInstruction): Array[ValueNumber] =
    // original value number: Array[ValueNumber](instr getUse 0)
    defUses get instr match {
      case Some(DefUses(defs, _)) => defs
      case None                   => Array[ValueNumber](newValNum.next())
    }

  private[this] def getUses(instr: SSAInvokeInstruction): Array[ValueNumber] =
  // original value number: Array[ValueNumber](instr getUse 1)
    defUses get instr match {
      case Some(DefUses(defs, _)) => defs
      case None                   => Array[ValueNumber](newValNum.next())
    }

  private[this] def initialDefUses(ir: IR): mutable.Map[SSAInstruction, DefUses] = {
    val tuples: Iterator[(SSAInvokeInstruction, DefUses)] = ir.iterateAllInstructions collect {
      case instr: SSAInvokeInstruction if sbConstructor(instr).isDefined =>
        val uses = sbConstructor(instr) match {
          case Some(arg) if arg startsWith "L" =>   // new StringBuilder(String) or new StringBuilder(CharSequence)
            getUses(instr)
          case _                               =>   // new StringBuilder() or new StringBuilder(int)
            Array.empty[ValueNumber]
        }
        instr -> DefUses(getDefs(instr), uses)
      case instr: SSAInvokeInstruction if sbAppend(instr) =>
        instr -> DefUses(getDefs(instr), getUses(instr))
    }
    mutable.Map(tuples.toSeq: _*)
  }

  override def repairInstructionUses(
    inst: SSAInstruction,
    index: Int,
    newUses: Array[ValueNumber]
  ): Unit = {}

  override def initializeVariables(): Unit = {}

  override def getNextNewValueNumber: ValueNumber = newValNum.next()

  override def repairInstructionDefs(
    instr: SSAInstruction,
    index: Int, // todo why does it have both the index and instruction?
    newDefs: Array[ValueNumber],
    newUses: Array[ValueNumber]
  ): Unit = defUses += (instr -> DefUses(newDefs, newUses))

  override def getMaxValueNumber: ValueNumber = ???

  override def pushAssignment(inst: SSAInstruction, index: Int, newRhs: Int): Unit = {}

  override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = basicBlockToPhis(B)(index)

  override def isAssignInstruction(inst: SSAInstruction): Boolean = false
  
  override def skip(vn: ValueNumber): Boolean = false

  override def isLive(Y: SSACFG#BasicBlock, V: ValueNumber): Boolean = true

  override def getDef(inst: SSAInstruction, index: Int): Int = defUses(inst).defs(index)

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

  override def setPhi(B: SSACFG#BasicBlock, index: Int, inst: SSAPhiInstruction): Unit =
    basicBlockToPhis(B)(index) = inst

  override def placeNewPhiAt(value: ValueNumber, Y: SSACFG#BasicBlock): Unit = {
    val params: Array[ValueNumber] = Array[ValueNumber](CFG getPredNodeCount Y)
    0 to params.length foreach { params(_) = value }

    val phi     = new SSAPhiInstruction(SSAInstruction.NO_INDEX, value, params) // todo is no index correct?
    val oldPhis = basicBlockToPhis(Y)
    val newPhis = new Array[SSAPhiInstruction](oldPhis.length + 1)
    oldPhis copyToArray newPhis

    basicBlockToPhis += (Y -> newPhis)
  }

  override def repairPhiDefs(phi: SSAPhiInstruction, newDefs: Array[ValueNumber]): SSAPhiInstruction =
    phi.copyForSSA(ir.getMethod.getDeclaringClass.getClassLoader.getInstructionFactory, newDefs, null).asInstanceOf[SSAPhiInstruction] // todo correct?

  override def getNumberOfDefs(inst: SSAInstruction): Int =
    defUses get inst match {
      case Some(defUse) => defUse.defs.length
      case None         => ???
    }

  override def getNumberOfUses(inst: SSAInstruction): Int =
    defUses get inst match {
      case Some(defUse) => defUse.uses.length
      case None         => ???
    }

  override def repairExit(): Unit = {}

  override def popAssignment(inst: SSAInstruction, index: Int): Unit = {}

  override def getUse(inst: SSAInstruction, index: Int): Int = defUses(inst).uses(index)

  override def isConstant(vn: ValueNumber): Boolean = ir.getSymbolTable isConstant vn
}
