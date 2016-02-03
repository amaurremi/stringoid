package javassist.bytecode.annotation;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public abstract class MemberValue {
    ConstPool cp;
    char tag;

    MemberValue(char paramChar, ConstPool paramConstPool) {
        this.cp = paramConstPool;
        this.tag = paramChar;
    }

    private static String convertFromArray(String paramString) {
        int i = paramString.indexOf("[]");
        Object localObject = paramString;
        if (i != -1) {
            localObject = new StringBuffer(Descriptor.of(paramString.substring(0, i)));
            while (i != -1) {
                ((StringBuffer) localObject).insert(0, "[");
                i = paramString.indexOf("[]", i + 1);
            }
            localObject = ((StringBuffer) localObject).toString().replace('/', '.');
        }
        return (String) localObject;
    }

    static Class loadClass(ClassLoader paramClassLoader, String paramString) {
        try {
            paramClassLoader = Class.forName(convertFromArray(paramString), true, paramClassLoader);
            return paramClassLoader;
        } catch (LinkageError paramClassLoader) {
            throw new NoSuchClassError(paramString, paramClassLoader);
        }
    }

    public abstract void accept(MemberValueVisitor paramMemberValueVisitor);

    abstract Class getType(ClassLoader paramClassLoader);

    abstract Object getValue(ClassLoader paramClassLoader, ClassPool paramClassPool, Method paramMethod);

    public abstract void write(AnnotationsWriter paramAnnotationsWriter);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/MemberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */