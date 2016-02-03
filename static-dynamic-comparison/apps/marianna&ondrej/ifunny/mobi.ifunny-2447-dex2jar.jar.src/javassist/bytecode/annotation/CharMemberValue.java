package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;

public class CharMemberValue
        extends MemberValue {
    int valueIndex;

    public CharMemberValue(char paramChar, ConstPool paramConstPool) {
        super('C', paramConstPool);
        setValue(paramChar);
    }

    public CharMemberValue(int paramInt, ConstPool paramConstPool) {
        super('C', paramConstPool);
        this.valueIndex = paramInt;
    }

    public CharMemberValue(ConstPool paramConstPool) {
        super('C', paramConstPool);
        setValue('\000');
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitCharMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return Character.TYPE;
    }

    public char getValue() {
        return (char) this.cp.getIntegerInfo(this.valueIndex);
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        return new Character(getValue());
    }

    public void setValue(char paramChar) {
        this.valueIndex = this.cp.addIntegerInfo(paramChar);
    }

    public String toString() {
        return Character.toString(getValue());
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.constValueIndex(getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/CharMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */