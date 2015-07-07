package com.ibm.stringoid.retrieve.ir

package object append {

  case class SSVN(vn: Int) extends AnyVal
  
  type StringSsaValueNumber = SSVN
  type WalaValueNumber = Int
}
