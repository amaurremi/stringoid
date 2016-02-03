package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class FloatMemberValue
        extends MemberValue {
    int valueIndex;

    public FloatMemberValue(float paramFloat, ConstPool paramConstPool) {
        super('F', paramConstPool);
        setValue(paramFloat);
    }

    public FloatMemberValue(int paramInt, ConstPool paramConstPool) {
        super('F', paramConstPool);
        this.valueIndex = paramInt;
    }

    public FloatMemberValue(ConstPool paramConstPool) {
        super('F', paramConstPool);
        setValue(0.0F);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitFloatMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Float.TYPE;
    }

    public float getValue() {
        return this.cp.getFloatInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Float(getValue());
    }

    public void setValue(float paramFloat) {
        this.valueIndex = this.cp.addFloatInfo(paramFloat);
    }

    public String toString() {
        return Float.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/FloatMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */