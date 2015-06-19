package edu.illinois.wala.ssa

import com.ibm.wala.ssa.SymbolTable
import edu.illinois.wala.Facade._

trait Wrapper {
  implicit def wrapSymbolTable(st: SymbolTable) = new RichSymbolTable(st)

  implicit def wrapI(i: I) = new RichI(i)
  implicit def wrapI(i: PutI) = new RichPutI(i)
  implicit def wrapI(i: GetI) = new RichGetI(i)
  implicit def wrapInvokeI(i: InvokeI) = new RichInvokeI(i)
  implicit def wrapAccessI(i: AccessI) = new RichAccessI(i)
  implicit def wrapArrayReferenceI(i: ArrayReferenceI) = new RichArrayReferenceI(i)

  implicit def unwrapV(v: V) = v.v
  implicit def unwrapIRNo(i: IRNo) = i.i
}