package edu.illinois.wala

import com.ibm.wala.classLoader.{IClass, IField, IMethod}
import com.ibm.wala.ipa.callgraph.propagation.{InstanceKey, LocalPointerKey, PointerKey}
import com.ibm.wala.ipa.callgraph.{CGNode, CallGraph}
import com.ibm.wala.ipa.cfg.BasicBlockInContext
import com.ibm.wala.ssa.analysis.IExplodedBasicBlock
import com.ibm.wala.ssa.{SSAInstruction, _}

trait TypeAliases {
  type N = CGNode

  type BB = ISSABasicBlock
  type SS = BasicBlockInContext[IExplodedBasicBlock]

  type P = PointerKey
  type LocalP = LocalPointerKey

  type O = InstanceKey

  type F = IField

  type WithReference = { def ref: Int }

  type I = SSAInstruction
  type ReferenceI = I with WithReference
  type AccessI = SSAFieldAccessInstruction
  type PutI = SSAPutInstruction
  type GetI = SSAGetInstruction

  type PhiI = SSAPhiInstruction

  type ArrayStoreI = SSAArrayStoreInstruction
  type ArrayLoadI = SSAArrayLoadInstruction
  type ArrayReferenceI = SSAArrayReferenceInstruction

  type InvokeI = SSAInvokeInstruction

  type MonitorI = SSAMonitorInstruction

  type G = CallGraph
  type C = IClass
  type M = IMethod
  
  type ProgramCounter = com.ibm.wala.classLoader.ProgramCounter
}
