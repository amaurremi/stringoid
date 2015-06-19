package edu.illinois.wala.ssa

import com.ibm.wala.ipa.cha.IClassHierarchy
import com.ibm.wala.ssa.SSAFieldAccessInstruction
import edu.illinois.wala.Facade._
import edu.illinois.wala.classLoader.ArrayContents
import com.ibm.wala.ssa.SSAGetInstruction
import com.ibm.wala.types.TypeReference
import com.ibm.wala.ssa.SSAInvokeInstruction
import com.ibm.wala.ssa.SSAArrayLoadInstruction
import com.ibm.wala.ssa.SSAArrayLengthInstruction

class RichPutI(val i: PutI) extends AnyVal {
  def v = V(i.getVal())
}

class RichGetI(val i: GetI) extends AnyVal {
  def d = V(i.getDef())
}

class RichInvokeI(val i: InvokeI) extends AnyVal {
  def m(implicit cha: IClassHierarchy) = cha.resolveMethod(i.getDeclaredTarget())
}

trait IWithField extends Any {
  def f(implicit cha: IClassHierarchy): Option[F]
}

class RichAccessI(val i: AccessI) extends AnyVal with IWithField {
  /**
   * Returns None when the cha cannot resolve the field.
   */
  def f(implicit cha: IClassHierarchy) = Option(cha.resolveField(i.getDeclaredField()))
}

class RichArrayReferenceI(val i: ArrayReferenceI) extends AnyVal with IWithField {
  def f(implicit cha: IClassHierarchy): Some[F] = Some(ArrayContents)
}

class RichI(val i: I) extends AnyVal {
  def uses: List[V] = Range(0, i.getNumberOfUses()) map { index => V(i.getUse(index)) } toList
  def theDef = V(i.getDef())
  def f(implicit cha: IClassHierarchy): Option[F] = i match {
    case i: AccessI => i.f
    case i: ArrayReferenceI => i.f
    case _ => None
  }
  def defedType: Option[TypeReference] = if (i.hasDef()) Some(i match {
    case i: SSAGetInstruction => i.getDeclaredFieldType()
    case i: SSAInvokeInstruction => i.getDeclaredResultType()
    case i: SSAArrayLoadInstruction => i.getElementType()
    case i: SSAArrayLengthInstruction => TypeReference.Int
  })
  else
    None
}