package edu.illinois.wala.ipa.slicer

import com.ibm.wala.ipa.slicer.StatementWithInstructionIndex
import edu.illinois.wala.S

trait Wrapper {
  implicit def makeSFromStatement(s: StatementWithInstructionIndex) = S(s.getNode(), s.getInstruction())
}