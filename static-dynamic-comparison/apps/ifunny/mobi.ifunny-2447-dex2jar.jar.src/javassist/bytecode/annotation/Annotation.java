package javassist.bytecode.annotation;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

public class Annotation {
    LinkedHashMap members;
    ConstPool pool;
    int typeIndex;

    public Annotation(int paramInt, ConstPool paramConstPool) {
        this.pool = paramConstPool;
        this.typeIndex = paramInt;
        this.members = null;
    }

    public Annotation(String paramString, ConstPool paramConstPool) {
        this(paramConstPool.addUtf8Info(Descriptor.of(paramString)), paramConstPool);
    }

    public Annotation(ConstPool paramConstPool, CtClass paramCtClass) {
        this(paramConstPool.addUtf8Info(Descriptor.of(paramCtClass.getName())), paramConstPool);
        if (!paramCtClass.isInterface()) {
            throw new RuntimeException("Only interfaces are allowed for Annotation creation.");
        }
        paramCtClass = paramCtClass.getDeclaredMethods();
        if (paramCtClass.length > 0) {
            this.members = new LinkedHashMap();
        }
        int i = 0;
        while (i < paramCtClass.length) {
            CtClass localCtClass = paramCtClass[i].getReturnType();
            addMemberValue(paramCtClass[i].getName(), createMemberValue(paramConstPool, localCtClass));
            i += 1;
        }
    }

    private void addMemberValue(Annotation.Pair paramPair) {
        String str = this.pool.getUtf8Info(paramPair.name);
        if (this.members == null) {
            this.members = new LinkedHashMap();
        }
        this.members.put(str, paramPair);
    }

    public static MemberValue createMemberValue(ConstPool paramConstPool, CtClass paramCtClass) {
        if (paramCtClass == CtClass.booleanType) {
            return new BooleanMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.byteType) {
            return new ByteMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.charType) {
            return new CharMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.shortType) {
            return new ShortMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.intType) {
            return new IntegerMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.longType) {
            return new LongMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.floatType) {
            return new FloatMemberValue(paramConstPool);
        }
        if (paramCtClass == CtClass.doubleType) {
            return new DoubleMemberValue(paramConstPool);
        }
        if (paramCtClass.getName().equals("java.lang.Class")) {
            return new ClassMemberValue(paramConstPool);
        }
        if (paramCtClass.getName().equals("java.lang.String")) {
            return new StringMemberValue(paramConstPool);
        }
        if (paramCtClass.isArray()) {
            return new ArrayMemberValue(createMemberValue(paramConstPool, paramCtClass.getComponentType()), paramConstPool);
        }
        if (paramCtClass.isInterface()) {
            return new AnnotationMemberValue(new Annotation(paramConstPool, paramCtClass), paramConstPool);
        }
        paramConstPool = new EnumMemberValue(paramConstPool);
        paramConstPool.setType(paramCtClass.getName());
        return paramConstPool;
    }

    public void addMemberValue(int paramInt, MemberValue paramMemberValue) {
        Annotation.Pair localPair = new Annotation.Pair();
        localPair.name = paramInt;
        localPair.value = paramMemberValue;
        addMemberValue(localPair);
    }

    public void addMemberValue(String paramString, MemberValue paramMemberValue) {
        Annotation.Pair localPair = new Annotation.Pair();
        localPair.name = this.pool.addUtf8Info(paramString);
        localPair.value = paramMemberValue;
        if (this.members == null) {
            this.members = new LinkedHashMap();
        }
        this.members.put(paramString, localPair);
    }

    public boolean equals(Object paramObject) {
        if (paramObject == this) {
        }
        do {
            do {
                return true;
                if ((paramObject == null) || (!(paramObject instanceof Annotation))) {
                    return false;
                }
                paramObject = (Annotation) paramObject;
                if (!getTypeName().equals(((Annotation) paramObject).getTypeName())) {
                    return false;
                }
                paramObject = ((Annotation) paramObject).members;
            } while (this.members == paramObject);
            if (this.members != null) {
                break;
            }
        } while (paramObject == null);
        return false;
        if (paramObject == null) {
            return false;
        }
        return this.members.equals(paramObject);
    }

    public Set getMemberNames() {
        if (this.members == null) {
            return null;
        }
        return this.members.keySet();
    }

    public MemberValue getMemberValue(String paramString) {
        if (this.members == null) {
            return null;
        }
        paramString = (Annotation.Pair) this.members.get(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.value;
    }

    public String getTypeName() {
        return Descriptor.toClassName(this.pool.getUtf8Info(this.typeIndex));
    }

    public Object toAnnotationType(ClassLoader paramClassLoader, ClassPool paramClassPool) {
        return AnnotationImpl.make(paramClassLoader, MemberValue.loadClass(paramClassLoader, getTypeName()), paramClassPool, this);
    }

    public String toString() {
        StringBuffer localStringBuffer = new StringBuffer("@");
        localStringBuffer.append(getTypeName());
        if (this.members != null) {
            localStringBuffer.append("(");
            Iterator localIterator = this.members.keySet().iterator();
            while (localIterator.hasNext()) {
                String str = (String) localIterator.next();
                localStringBuffer.append(str).append("=").append(getMemberValue(str));
                if (localIterator.hasNext()) {
                    localStringBuffer.append(", ");
                }
            }
            localStringBuffer.append(")");
        }
        return localStringBuffer.toString();
    }

    public void write(AnnotationsWriter paramAnnotationsWriter) {
        Object localObject = this.pool.getUtf8Info(this.typeIndex);
        if (this.members == null) {
            paramAnnotationsWriter.annotation((String) localObject, 0);
        }
        for (; ; ) {
            return;
            paramAnnotationsWriter.annotation((String) localObject, this.members.size());
            localObject = this.members.values().iterator();
            while (((Iterator) localObject).hasNext()) {
                Annotation.Pair localPair = (Annotation.Pair) ((Iterator) localObject).next();
                paramAnnotationsWriter.memberValuePair(localPair.name);
                localPair.value.write(paramAnnotationsWriter);
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/bytecode/annotation/Annotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */