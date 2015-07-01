package com.ibm.stringoid.retrieve.ir.append

import com.ibm.wala.cast.ir.ssa.AbstractSSAConversion
import com.ibm.wala.ssa._

import scala.collection.JavaConversions._
import scala.collection.mutable

class StringConcatSsaConversion(ir: IR) extends AbstractSSAConversion(ir, new SSAOptions) {

  case class DefUses(df: Array[ValueNumber], uses: Array[ValueNumber])

  private[this] val basicBlockToPhis =
    mutable.Map.empty[SSACFG#BasicBlock, Array[SSAPhiInstruction]] withDefaultValue Array.empty[SSAPhiInstruction]

  private[this] val defUses          = initialDefUses(ir)

  private[this] var valNumIterator   = Iterator.from(getMaxValueNumber + 1)

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

  def initialDefUses(ir: IR): mutable.Map[SSAInstruction, DefUses] = {
    ir.iterateAllInstructions collect {
      case instr: SSAInvokeInstruction if ??? => ???
        // new StringBuilder:           invokespecial < Application, Ljava/lang/StringBuilder, <init>()V > 4 @7 exception:5
        // new StringBuilder(string):   invokespecial < Application, Ljava/lang/StringBuilder, <init>(Ljava/lang/String;)V > 6,3 @16 exception:7
                                    //  getUse(0) corresponds to "this" (and is what will be passed around if the SB gets appended)
                                    //  getUse(1) corresponds to the passed argument
        // sb.append(string)            9 = invokevirtual < Application, Ljava/lang/StringBuilder, append(Ljava/lang/String;)Ljava/lang/StringBuilder; > 4,3 @23 exception:8
        // sb.append(SB)                1 = invokevirtual < Application, Ljava/lang/StringBuilder, append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder; > 6,4 @29 exception:10\
                                    // getUse(0) corresponds to "this" (first SB)
                                    // getUse(1) to argument

//      case instr if isStringCreation(instr) =>
//        instr -> DefUses(getStringCreationDef(instr), Array.empty[ValueNumber])
//      case instr if isConcat(instr)         =>
//        instr -> DefUses(getConcatDef(instr), getConcatUses(instr))
    }
    ???
  }

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
  ): Unit = defUses += (instr -> DefUses(newDefs, newUses))

  override def getMaxValueNumber: ValueNumber = ???

  override def pushAssignment(inst: SSAInstruction, index: Int, newRhs: Int): Unit = {}

  override def getPhi(B: SSACFG#BasicBlock, index: Int): SSAPhiInstruction = basicBlockToPhis(B)(index)

  override def isAssignInstruction(inst: SSAInstruction): Boolean = false
  
  override def skip(vn: ValueNumber): Boolean = false

  override def isLive(Y: SSACFG#BasicBlock, V: ValueNumber): Boolean = true

  override def getDef(inst: SSAInstruction, index: Int): Int = defUses(inst).df(index)

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
      case Some(defUse) => defUse.df.length
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
