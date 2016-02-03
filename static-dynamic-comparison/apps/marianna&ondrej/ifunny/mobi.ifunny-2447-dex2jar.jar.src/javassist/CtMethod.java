package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;

public final class CtMethod
        extends CtBehavior {
    protected String cachedStringRep = null;

    public CtMethod(CtClass paramCtClass1, String paramString, CtClass[] paramArrayOfCtClass, CtClass paramCtClass2) {
        this(null, paramCtClass2);
        this.methodInfo = new MethodInfo(paramCtClass2.getClassFile2().getConstPool(), paramString, Descriptor.ofMethod(paramCtClass1, paramArrayOfCtClass));
        setModifiers(1025);
    }

    public CtMethod(CtMethod paramCtMethod, CtClass paramCtClass, ClassMap paramClassMap) {
        this(null, paramCtClass);
        copy(paramCtMethod, false, paramClassMap);
    }

    CtMethod(MethodInfo paramMethodInfo, CtClass paramCtClass) {
        super(paramCtClass, paramMethodInfo);
    }

    public static CtMethod make(String paramString, CtClass paramCtClass) {
        return CtNewMethod.make(paramString, paramCtClass);
    }

    public static CtMethod make(MethodInfo paramMethodInfo, CtClass paramCtClass) {
        if (paramCtClass.getClassFile2().getConstPool() != paramMethodInfo.getConstPool()) {
            throw new CannotCompileException("bad declaring class");
        }
        return new CtMethod(paramMethodInfo, paramCtClass);
    }

    public boolean equals(Object paramObject) {
        return (paramObject != null) && ((paramObject instanceof CtMethod)) && (((CtMethod) paramObject).getStringRep().equals(getStringRep()));
    }

    public String getLongName() {
        return getDeclaringClass().getName() + "." + getName() + Descriptor.toString(getSignature());
    }

    public String getName() {
        return this.methodInfo.getName();
    }

    public CtClass getReturnType() {
        return getReturnType0();
    }

    final String getStringRep() {
        if (this.cachedStringRep == null) {
            this.cachedStringRep = (this.methodInfo.getName() + Descriptor.getParamDescriptor(this.methodInfo.getDescriptor()));
        }
        return this.cachedStringRep;
    }

    public int hashCode() {
        return getStringRep().hashCode();
    }

    public boolean isEmpty() {
        Object localObject = getMethodInfo2().getCodeAttribute();
        if (localObject == null) {
            if ((getModifiers() & 0x400) == 0) {
            }
        }
        for (; ; ) {
            return true;
            return false;
            localObject = ((CodeAttribute) localObject).iterator();
            try {
                if ((((CodeIterator) localObject).hasNext()) && (((CodeIterator) localObject).byteAt(((CodeIterator) localObject).next()) == 177)) {
                    boolean bool = ((CodeIterator) localObject).hasNext();
                    if (!bool) {
                    }
                } else {
                    return false;
                }
            } catch (BadBytecode localBadBytecode) {
            }
        }
        return false;
    }

    void nameReplaced() {
        this.cachedStringRep = null;
    }

    public void setBody(CtMethod paramCtMethod, ClassMap paramClassMap) {
        setBody0(paramCtMethod.declaringClass, paramCtMethod.methodInfo, this.declaringClass, this.methodInfo, paramClassMap);
    }

    public void setName(String paramString) {
        this.declaringClass.checkModify();
        this.methodInfo.setName(paramString);
    }

    public void setWrappedBody(CtMethod paramCtMethod, CtMethod.ConstParameter paramConstParameter) {
        this.declaringClass.checkModify();
        CtClass localCtClass1 = getDeclaringClass();
        try {
            CtClass[] arrayOfCtClass = getParameterTypes();
            CtClass localCtClass2 = getReturnType();
            paramCtMethod = CtNewWrappedMethod.makeBody(localCtClass1, localCtClass1.getClassFile2(), paramCtMethod, arrayOfCtClass, localCtClass2, paramConstParameter).toCodeAttribute();
            this.methodInfo.setCodeAttribute(paramCtMethod);
            this.methodInfo.setAccessFlags(this.methodInfo.getAccessFlags() & 0xFBFF);
            return;
        } catch (NotFoundException paramCtMethod) {
            throw new CannotCompileException(paramCtMethod);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */