package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.CodeIterator.Gap;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.Descriptor.Iterator;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public final class CtConstructor
        extends CtBehavior {
    public CtConstructor(CtConstructor paramCtConstructor, CtClass paramCtClass, ClassMap paramClassMap) {
        this((MethodInfo) null, paramCtClass);
        copy(paramCtConstructor, true, paramClassMap);
    }

    protected CtConstructor(MethodInfo paramMethodInfo, CtClass paramCtClass) {
        super(paramCtClass, paramMethodInfo);
    }

    public CtConstructor(CtClass[] paramArrayOfCtClass, CtClass paramCtClass) {
        this((MethodInfo) null, paramCtClass);
        this.methodInfo = new MethodInfo(paramCtClass.getClassFile2().getConstPool(), "<init>", Descriptor.ofConstructor(paramArrayOfCtClass));
        setModifiers(1);
    }

    private String getSuperclassName() {
        return this.declaringClass.getClassFile2().getSuperclass();
    }

    private static void removeConsCall(CodeAttribute paramCodeAttribute) {
        CodeIterator localCodeIterator = paramCodeAttribute.iterator();
        label144:
        for (; ; ) {
            try {
                int i = localCodeIterator.skipConstructor();
                if (i >= 0) {
                    int j = localCodeIterator.u16bitAt(i + 1);
                    paramCodeAttribute = paramCodeAttribute.getConstPool().getMethodrefType(j);
                    j = Descriptor.numOfParameters(paramCodeAttribute) + 1;
                    if (j <= 3) {
                        break label144;
                    }
                    i = localCodeIterator.insertGapAt(i, j - 3, false).position;
                    j = i + 1;
                    localCodeIterator.writeByte(87, i);
                    localCodeIterator.writeByte(0, j);
                    localCodeIterator.writeByte(0, j + 1);
                    paramCodeAttribute = new Descriptor.Iterator(paramCodeAttribute);
                    i = j;
                    paramCodeAttribute.next();
                    if (paramCodeAttribute.isParameter()) {
                        if (paramCodeAttribute.is2byte()) {
                            j = 88;
                            localCodeIterator.writeByte(j, i);
                            i += 1;
                            continue;
                        }
                        j = 87;
                        continue;
                    }
                }
                return;
            } catch (BadBytecode paramCodeAttribute) {
                throw new CannotCompileException(paramCodeAttribute);
            }
        }
    }

    public boolean callsSuper() {
        boolean bool2 = false;
        Object localObject = this.methodInfo.getCodeAttribute();
        boolean bool1 = bool2;
        if (localObject != null) {
            localObject = ((CodeAttribute) localObject).iterator();
        }
        try {
            int i = ((CodeIterator) localObject).skipSuperConstructor();
            bool1 = bool2;
            if (i >= 0) {
                bool1 = true;
            }
            return bool1;
        } catch (BadBytecode localBadBytecode) {
            throw new CannotCompileException(localBadBytecode);
        }
    }

    public String getLongName() {
        StringBuilder localStringBuilder = new StringBuilder().append(getDeclaringClass().getName());
        if (isConstructor()) {
        }
        for (String str = Descriptor.toString(getSignature()); ; str = ".<clinit>()") {
            return str;
        }
    }

    public String getName() {
        if (this.methodInfo.isStaticInitializer()) {
            return "<clinit>";
        }
        return this.declaringClass.getSimpleName();
    }

    int getStartPosOfBody(CodeAttribute paramCodeAttribute) {
        paramCodeAttribute = paramCodeAttribute.iterator();
        try {
            paramCodeAttribute.skipConstructor();
            int i = paramCodeAttribute.next();
            return i;
        } catch (BadBytecode paramCodeAttribute) {
            throw new CannotCompileException(paramCodeAttribute);
        }
    }

    public void insertBeforeBody(String paramString) {
        CtClass localCtClass = this.declaringClass;
        localCtClass.checkModify();
        if (isClassInitializer()) {
            throw new CannotCompileException("class initializer");
        }
        CodeAttribute localCodeAttribute = this.methodInfo.getCodeAttribute();
        CodeIterator localCodeIterator = localCodeAttribute.iterator();
        Bytecode localBytecode = new Bytecode(this.methodInfo.getConstPool(), localCodeAttribute.getMaxStack(), localCodeAttribute.getMaxLocals());
        localBytecode.setStackDepth(localCodeAttribute.getMaxStack());
        Javac localJavac = new Javac(localBytecode, localCtClass);
        try {
            localJavac.recordParams(getParameterTypes(), false);
            localJavac.compileStmnt(paramString);
            localCodeAttribute.setMaxStack(localBytecode.getMaxStack());
            localCodeAttribute.setMaxLocals(localBytecode.getMaxLocals());
            localCodeIterator.skipConstructor();
            int i = localCodeIterator.insertEx(localBytecode.get());
            localCodeIterator.insert(localBytecode.getExceptionTable(), i);
            this.methodInfo.rebuildStackMapIf6(localCtClass.getClassPool(), localCtClass.getClassFile2());
            return;
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        } catch (BadBytecode paramString) {
            throw new CannotCompileException(paramString);
        }
    }

    public boolean isClassInitializer() {
        return this.methodInfo.isStaticInitializer();
    }

    public boolean isConstructor() {
        return this.methodInfo.isConstructor();
    }

    public boolean isEmpty() {
        Object localObject = getMethodInfo2().getCodeAttribute();
        if (localObject == null) {
        }
        for (; ; ) {
            return false;
            ConstPool localConstPool = ((CodeAttribute) localObject).getConstPool();
            localObject = ((CodeAttribute) localObject).iterator();
            try {
                int i = ((CodeIterator) localObject).byteAt(((CodeIterator) localObject).next());
                if (i != 177) {
                    if (i == 42) {
                        i = ((CodeIterator) localObject).next();
                        if (((CodeIterator) localObject).byteAt(i) == 183) {
                            i = localConstPool.isConstructor(getSuperclassName(), ((CodeIterator) localObject).u16bitAt(i + 1));
                            if ((i != 0) && ("()V".equals(localConstPool.getUtf8Info(i))) && (((CodeIterator) localObject).byteAt(((CodeIterator) localObject).next()) == 177)) {
                                boolean bool = ((CodeIterator) localObject).hasNext();
                                if (bool) {
                                }
                            }
                        }
                    }
                } else {
                    return true;
                }
            } catch (BadBytecode localBadBytecode) {
            }
        }
        return false;
    }

    public void setBody(String paramString) {
        String str = paramString;
        if (paramString == null) {
            if (!isClassInitializer()) {
                break label23;
            }
        }
        label23:
        for (str = ";"; ; str = "super();") {
            super.setBody(str);
            return;
        }
    }

    public void setBody(CtConstructor paramCtConstructor, ClassMap paramClassMap) {
        setBody0(paramCtConstructor.declaringClass, paramCtConstructor.methodInfo, this.declaringClass, this.methodInfo, paramClassMap);
    }

    public CtMethod toMethod(String paramString, CtClass paramCtClass) {
        return toMethod(paramString, paramCtClass, null);
    }

    public CtMethod toMethod(String paramString, CtClass paramCtClass, ClassMap paramClassMap) {
        CtMethod localCtMethod = new CtMethod(null, paramCtClass);
        localCtMethod.copy(this, false, paramClassMap);
        if (isConstructor()) {
            paramClassMap = localCtMethod.getMethodInfo2().getCodeAttribute();
            if (paramClassMap != null) {
                removeConsCall(paramClassMap);
            }
        }
        try {
            this.methodInfo.rebuildStackMapIf6(paramCtClass.getClassPool(), paramCtClass.getClassFile2());
            localCtMethod.setName(paramString);
            return localCtMethod;
        } catch (BadBytecode paramString) {
            throw new CannotCompileException(paramString);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */