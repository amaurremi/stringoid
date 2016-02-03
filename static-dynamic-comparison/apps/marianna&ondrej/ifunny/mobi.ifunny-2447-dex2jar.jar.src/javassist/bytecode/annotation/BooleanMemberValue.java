package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class BooleanMemberValue
        extends MemberValue {
    int valueIndex;

    public BooleanMemberValue(int paramInt, ConstPool paramConstPool) {
        super('Z', paramConstPool);
        this.valueIndex = paramInt;
    }

    public BooleanMemberValue(ConstPool paramConstPool) {
        super('Z', paramConstPool);
        setValue(false);
    }

    public BooleanMemberValue(boolean paramBoolean, ConstPool paramConstPool) {
        super('Z', paramConstPool);
        setValue(paramBoolean);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitBooleanMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Boolean.TYPE;
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Boolean(getValue());
    }

    public boolean getValue() {
        return this.cp.getIntegerInfo(this.valueIndex) != 0;
    }

    public void setValue(boolean paramBoolean) {
        ConstPool localConstPool = this.cp;
        if (paramBoolean) {
        }
        for (int i = 1; ; i = 0) {
            this.valueIndex = localConstPool.addIntegerInfo(i);
            return;
        }
    }

    public String toString() {
        if (getValue()) {
            return "true";
        }
        return "false";
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/BooleanMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */