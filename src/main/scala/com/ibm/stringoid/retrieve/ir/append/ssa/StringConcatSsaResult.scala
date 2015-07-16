package com.ibm.stringoid.retrieve.ir.append.ssa

import com.ibm.stringoid.retrieve.ir.append._
import com.ibm.wala.ssa.{IR, SSAInstruction, SSAInvokeInstruction, SSAPhiInstruction}

import scala.collection.breakOut

class StringConcatSsaResult private(ir: IR) extends StringConcatSsaConversion(ir) {

  private def apply(): StringConcatSsaResult = {
    perform()
    this
  }

  /**
   * The immutable publicly visible result of instructions with their new defs and uses
   */
  def normalInstrToDefUsesMap = normalInstrToDefUses.toMap[SSAInvokeInstruction, DefUses]

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
        throw new UnsupportedOperationException(StringConcatUtil.INVOKE_INSTR_MSG)
    }
  }
}

object StringConcatSsaResult {

  def apply(ir: IR): StringConcatSsaResult =
    new StringConcatSsaResult(ir)()
}