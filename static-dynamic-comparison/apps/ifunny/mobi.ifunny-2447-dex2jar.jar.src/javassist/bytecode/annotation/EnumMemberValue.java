package javassist.bytecode.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public class EnumMemberValue
        extends MemberValue {
    int typeIndex;
    int valueIndex;

    public EnumMemberValue(int paramInt1, int paramInt2, ConstPool paramConstPool) {
        super('e', paramConstPool);
        this.typeIndex = paramInt1;
        this.valueIndex = paramInt2;
    }

    public EnumMemberValue(ConstPool paramConstPool) {
        super('e', paramConstPool);
        this.valueIndex = 0;
        this.typeIndex = 0;
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitEnumMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return loadClass(paramClassLoader, getType());
    }

    public String getType() {
        return Descriptor.toClassName(this.cp.getUtf8Info(this.typeIndex));
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        try {
            paramClassLoader = getType(paramClassLoader).getField(getValue()).get(null);
            return paramClassLoader;
        } catch (NoSuchFieldException paramClassLoader) {
            throw new ClassNotFoundException(getType() + "." + getValue());
        } catch (IllegalAccessException paramClassLoader) {
            throw new ClassNotFoundException(getType() + "." + getValue());
        }
    }

    public String getValue() {
        return this.cp.getUtf8Info(this.valueIndex);
    }

    public void setType(String paramString) {
        this.typeIndex = this.cp.addUtf8Info(Descriptor.of(paramString));
    }

    public void setValue(String paramString) {
        this.valueIndex = this.cp.addUtf8Info(paramString);
    }

    public String toString() {
        return getType() + "." + getValue();
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.enumConstValue(this.cp.getUtf8Info(this.typeIndex), getValue());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/EnumMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */