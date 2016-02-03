package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class LongMemberValue
        extends MemberValue {
    int valueIndex;

    public LongMemberValue(int paramInt, ConstPool paramConstPool) {
        super('J', paramConstPool);
        this.valueIndex = paramInt;
    }

    public LongMemberValue(long paramLong, ConstPool paramConstPool) {
        super('J', paramConstPool);
        setValue(paramLong);
    }

    public LongMemberValue(ConstPool paramConstPool) {
        super('J', paramConstPool);
        setValue(0L);
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitLongMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Long.TYPE;
    }

    public long getValue() {
        return this.cp.getLongInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Long(getValue());
    }

    public void setValue(long paramLong) {
        this.valueIndex = this.cp.addLongInfo(paramLong);
    }

    public String toString() {
        return Long.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/LongMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */