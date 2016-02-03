package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public class ClassMemberValue
        extends MemberValue {
    int valueIndex;

    public ClassMemberValue(int paramInt, ConstPool paramConstPool) {
        super('c', paramConstPool);
        this.valueIndex = paramInt;
    }

    public ClassMemberValue(String paramString, ConstPool paramConstPool) {
        super('c', paramConstPool);
        setValue(paramString);
    }

    public ClassMemberValue(ConstPool paramConstPool) {
        super('c', paramConstPool);
        setValue("java.lang.Class");
    }

    public void accept(MemberValueVisitor paramMemberValueVisitor) {
        paramMemberValueVisitor.visitClassMemberValue(this);
    }

    Class getType(ClassLoader paramClassLoader) {
        return loadClass(paramClassLoader, "java.lang.Class");
    }

    Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod) {
        paramClassPool = getValue();
        if (paramClassPool.equals("void")) {
            return Void.TYPE;
        }
        if (paramClassPool.equals("int")) {
            return Integer.TYPE;
        }
        if (paramClassPool.equals("byte")) {
            return Byte.TYPE;
        }
        if (paramClassPool.equals("long")) {
            return Long.TYPE;
        }
        if (paramClassPool.equals("double")) {
            return Double.TYPE;
        }
        if (paramClassPool.equals("float")) {
            return Float.TYPE;
        }
        if (paramClassPool.equals("char")) {
            return Character.TYPE;
        }
        if (paramClassPool.equals("short")) {
            return Short.TYPE;
        }
        if (paramClassPool.equals("boolean")) {
            return Boolean.TYPE;
        }
        return loadClass(paramClassLoader, paramClassPool);
    }

    public String getValue() {
        return Descriptor.toClassName(this.cp.getUtf8Info(this.valueIndex));
    }

    public void setValue(String paramString) {
        paramString = Descriptor.of(paramString);
        this.valueIndex = this.cp.addUtf8Info(paramString);
    }

    public String toString() {
        return "<" + getValue() + " class>";
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        paramAnnotationsWriter.classInfoIndex(this.cp.getUtf8Info(this.valueIndex));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/ClassMemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */