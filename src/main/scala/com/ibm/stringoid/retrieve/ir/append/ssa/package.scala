package com.ibm.stringoid.retrieve.ir.append

package object ssa {

  case class SSVN(vn: Int) extends AnyVal
  
  type StringSsaValueNumber = SSVN
}
