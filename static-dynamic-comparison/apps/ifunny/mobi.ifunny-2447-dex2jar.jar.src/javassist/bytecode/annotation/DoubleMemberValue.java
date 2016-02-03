package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class DoubleMemberValue
        extends MemberValue {
    int valueIndex;

    public DoubleMemberValue(double paramDouble, ConstPool paramConstPool) {
        super('D', paramConstPool);
        setValue(paramDouble);
    }

    public DoubleMemberValue(int paramInt, ConstPool paramConstPool) {
        super('D', paramConstPool);
        this.valueIndex = paramInt;
    }

    public DoubleMemberValue(ConstPool paramConstPool) {
        super('D', paramConstPool);
        setValue(0.0D);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitDoubleMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Double.TYPE;
    }

    public double getValue() {
        return this.cp.getDoubleInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Double(getValue());
    }

    public void setValue(double paramDouble) {
        this.valueIndex = this.cp.addDoubleInfo(paramDouble);
    }

    public String toString() {
        return Double.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/DoubleMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */