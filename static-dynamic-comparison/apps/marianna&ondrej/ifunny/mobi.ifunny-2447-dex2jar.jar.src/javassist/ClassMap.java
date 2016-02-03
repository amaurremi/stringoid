package javassist;

import java.util.HashMap;

import javassist.bytecode.Descriptor;

public class ClassMap
        extends HashMap {
    private ClassMap parent;

    public ClassMap() {
        this.parent = null;
    }

    ClassMap(ClassMap paramClassMap) {
        this.parent = paramClassMap;
    }

    public static String toJavaName(String paramString) {
        return Descriptor.toJavaName(paramString);
    }

    public static String toJvmName(String paramString) {
        return Descriptor.toJvmName(paramString);
    }

    public void fix(String paramString) {
        paramString = toJvmName(paramString);
        super.put(paramString, paramString);
    }

    public void fix(CtClass paramCtClass) {
        fix(paramCtClass.getName());
    }

    public Object get(Object paramObject) {
        Object localObject2 = super.get(paramObject);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
            localObject1 = localObject2;
            if (this.parent != null) {
                localObject1 = this.parent.get(paramObject);
            }
        }
        return localObject1;
    }

    public void put(String paramString1, String paramString2) {
        if (paramString1 == paramString2) {
        }
        String str;
        do {
            return;
            paramString1 = toJvmName(paramString1);
            str = (String) get(paramString1);
        } while ((str != null) && (str.equals(paramString1)));
        super.put(paramString1, toJvmName(paramString2));
    }

    public void put(CtClass paramCtClass1, CtClass paramCtClass2) {
        put(paramCtClass1.getName(), paramCtClass2.getName());
    }

    protected final void put0(Object paramObject1, Object paramObject2) {
        super.put(paramObject1, paramObject2);
    }

    public void putIfNone(String paramString1, String paramString2) {
        if (paramString1 == paramString2) {
        }
        do {
            return;
            paramString1 = toJvmName(paramString1);
        } while ((String) get(paramString1) != null);
        super.put(paramString1, toJvmName(paramString2));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */