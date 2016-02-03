package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class StringMemberValue
        extends MemberValue {
    int valueIndex;

    public StringMemberValue(int paramInt, ConstPool paramConstPool) {
        super('s', paramConstPool);
        this.valueIndex = paramInt;
    }

    public StringMemberValue(String paramString, ConstPool paramConstPool) {
        super('s', paramConstPool);
        setValue(paramString);
    }

    public StringMemberValue(ConstPool paramConstPool) {
        super('s', paramConstPool);
        setValue("");
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitStringMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return String.class;
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return getValue();
    }

    public String getValue() {
        return this.cp.getUtf8Info(this.valueIndex);
    }

    public void setValue(String paramString) {
        this.valueIndex = this.cp.addUtf8Info(paramString);
    }

    public String toString() {
        return "\"" + getValue() + "\"";
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/StringMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */