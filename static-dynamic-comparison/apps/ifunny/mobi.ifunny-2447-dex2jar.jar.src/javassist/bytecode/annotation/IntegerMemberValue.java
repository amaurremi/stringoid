package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class IntegerMemberValue
        extends MemberValue {
    int valueIndex;

    public IntegerMemberValue(int paramInt, ConstPool paramConstPool) {
        super('I', paramConstPool);
        this.valueIndex = paramInt;
    }

    public IntegerMemberValue(ConstPool paramConstPool) {
        super('I', paramConstPool);
        setValue(0);
    }

    public IntegerMemberValue(ConstPool paramConstPool, int paramInt) {
        super('I', paramConstPool);
        setValue(paramInt);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitIntegerMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Integer.TYPE;
    }

    public int getValue() {
        return this.cp.getIntegerInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Integer(getValue());
    }

    public void setValue(int paramInt) {
        this.valueIndex = this.cp.addIntegerInfo(paramInt);
    }

    public String toString() {
        return Integer.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/IntegerMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */