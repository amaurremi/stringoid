package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class ByteMemberValue
        extends MemberValue {
    int valueIndex;

    public ByteMemberValue(byte paramByte, ConstPool paramConstPool) {
        super('B', paramConstPool);
        setValue(paramByte);
    }

    public ByteMemberValue(int paramInt, ConstPool paramConstPool) {
        super('B', paramConstPool);
        this.valueIndex = paramInt;
    }

    public ByteMemberValue(ConstPool paramConstPool) {
        super('B', paramConstPool);
        setValue((byte) 0);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitByteMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Byte.TYPE;
    }

    public byte getValue() {
        return (byte) this.cp.getIntegerInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Byte(getValue());
    }

    public void setValue(byte paramByte) {
        this.valueIndex = this.cp.addIntegerInfo(paramByte);
    }

    public String toString() {
        return Byte.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/ByteMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */