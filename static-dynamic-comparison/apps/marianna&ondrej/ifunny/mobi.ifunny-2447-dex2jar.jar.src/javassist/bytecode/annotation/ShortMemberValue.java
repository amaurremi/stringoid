package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class ShortMemberValue
        extends MemberValue {
    int valueIndex;

    public ShortMemberValue(int paramInt, ConstPool paramConstPool) {
        super('S', paramConstPool);
        this.valueIndex = paramInt;
    }

    public ShortMemberValue(ConstPool paramConstPool) {
        super('S', paramConstPool);
        setValue((short) 0);
    }

    public ShortMemberValue(short paramShort, ConstPool paramConstPool) {
        super('S', paramConstPool);
        setValue(paramShort);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitShortMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Short.TYPE;
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Short(getValue());
    }

    public short getValue() {
        return (short) this.cp.getIntegerInfo(this.valueIndex);
    }

    public void setValue(short paramShort) {
        this.valueIndex = this.cp.addIntegerInfo(paramShort);
    }

    public String toString() {
        return Short.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/ShortMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */