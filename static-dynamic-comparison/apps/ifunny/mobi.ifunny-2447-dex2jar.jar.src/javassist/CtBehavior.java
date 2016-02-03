package javassist;

import java.util.List;

import javassist.bytecode.AccessFlag;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.AttributeInfo;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeAttribute.RuntimeCopyException;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.CodeIterator.Gap;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.ExceptionTable;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.LineNumberAttribute;
import javassist.bytecode.LineNumberAttribute.Pc;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.ParameterAnnotationsAttribute;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;
import javassist.expr.ExprEditor;

public abstract class CtBehavior
        extends CtMember {
    protected MethodInfo methodInfo;

    protected CtBehavior(CtClass paramCtClass, MethodInfo paramMethodInfo) {
        super(paramCtClass);
        this.methodInfo = paramMethodInfo;
    }

    private void addParameter2(int paramInt, CtClass paramCtClass, String paramString) {
        paramString = this.methodInfo.getCodeAttribute();
        int j;
        char c;
        int i;
        if (paramString != null) {
            if (!paramCtClass.isPrimitive()) {
                break label120;
            }
            paramCtClass = (CtPrimitiveType) paramCtClass;
            j = paramCtClass.getDataSize();
            c = paramCtClass.getDescriptor();
            i = 0;
        }
        for (; ; ) {
            paramString.insertLocalVar(paramInt, j);
            paramCtClass = (LocalVariableAttribute) paramString.getAttribute("LocalVariableTable");
            if (paramCtClass != null) {
                paramCtClass.shiftIndex(paramInt, j);
            }
            paramCtClass = (StackMapTable) paramString.getAttribute("StackMapTable");
            if (paramCtClass != null) {
                paramCtClass.insertLocal(paramInt, StackMapTable.typeTagOf(c), i);
            }
            paramCtClass = (StackMap) paramString.getAttribute("StackMap");
            if (paramCtClass != null) {
                paramCtClass.insertLocal(paramInt, StackMapTable.typeTagOf(c), i);
            }
            return;
            label120:
            i = this.methodInfo.getConstPool().addClassInfo(paramCtClass);
            j = 1;
            c = 'L';
        }
    }

    private Object[] getAnnotations(boolean paramBoolean) {
        Object localObject = getMethodInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.toAnnotationType(paramBoolean, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    private void insertAfterAdvice(Bytecode paramBytecode, Javac paramJavac, String paramString, ConstPool paramConstPool, CtClass paramCtClass, int paramInt) {
        if (paramCtClass == CtClass.voidType) {
            paramBytecode.addOpcode(1);
            paramBytecode.addAstore(paramInt);
            paramJavac.compileStmnt(paramString);
            paramBytecode.addOpcode(177);
            if (paramBytecode.getMaxLocals() < 1) {
                paramBytecode.setMaxLocals(1);
            }
            return;
        }
        paramBytecode.addStore(paramInt, paramCtClass);
        paramJavac.compileStmnt(paramString);
        paramBytecode.addLoad(paramInt, paramCtClass);
        if (paramCtClass.isPrimitive()) {
            paramBytecode.addOpcode(((CtPrimitiveType) paramCtClass).getReturnOp());
            return;
        }
        paramBytecode.addOpcode(176);
    }

    private int insertAfterHandler(boolean paramBoolean, Bytecode paramBytecode, CtClass paramCtClass, int paramInt, Javac paramJavac, String paramString) {
        if (!paramBoolean) {
            return 0;
        }
        int i = paramBytecode.getMaxLocals();
        paramBytecode.incMaxLocals(1);
        int j = paramBytecode.currentPc();
        paramBytecode.addAstore(i);
        int k;
        if (paramCtClass.isPrimitive()) {
            k = ((CtPrimitiveType) paramCtClass).getDescriptor();
            if (k == 68) {
                paramBytecode.addDconst(0.0D);
                paramBytecode.addDstore(paramInt);
            }
        }
        for (; ; ) {
            paramJavac.compileStmnt(paramString);
            paramBytecode.addAload(i);
            paramBytecode.addOpcode(191);
            return paramBytecode.currentPc() - j;
            if (k == 70) {
                paramBytecode.addFconst(0.0F);
                paramBytecode.addFstore(paramInt);
            } else if (k == 74) {
                paramBytecode.addLconst(0L);
                paramBytecode.addLstore(paramInt);
            } else if (k == 86) {
                paramBytecode.addOpcode(1);
                paramBytecode.addAstore(paramInt);
            } else {
                paramBytecode.addIconst(0);
                paramBytecode.addIstore(paramInt);
                continue;
                paramBytecode.addOpcode(1);
                paramBytecode.addAstore(paramInt);
            }
        }
    }

    private void insertBefore(String paramString, boolean paramBoolean) {
        CtClass localCtClass = this.declaringClass;
        localCtClass.checkModify();
        CodeAttribute localCodeAttribute = this.methodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
            throw new CannotCompileException("no method body");
        }
        CodeIterator localCodeIterator = localCodeAttribute.iterator();
        Javac localJavac = new Javac(localCtClass);
        try {
            localJavac.recordParamNames(localCodeAttribute, localJavac.recordParams(getParameterTypes(), Modifier.isStatic(getModifiers())));
            localJavac.recordLocalVariables(localCodeAttribute, 0);
            localJavac.recordType(getReturnType0());
            localJavac.compileStmnt(paramString);
            paramString = localJavac.getBytecode();
            int i = paramString.getMaxStack();
            int j = paramString.getMaxLocals();
            if (i > localCodeAttribute.getMaxStack()) {
                localCodeAttribute.setMaxStack(i);
            }
            if (j > localCodeAttribute.getMaxLocals()) {
                localCodeAttribute.setMaxLocals(j);
            }
            i = localCodeIterator.insertEx(paramString.get());
            localCodeIterator.insert(paramString.getExceptionTable(), i);
            if (paramBoolean) {
                this.methodInfo.rebuildStackMapIf6(localCtClass.getClassPool(), localCtClass.getClassFile2());
            }
            return;
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        } catch (BadBytecode paramString) {
            throw new CannotCompileException(paramString);
        }
    }

    private void insertGoto(CodeIterator paramCodeIterator, int paramInt1, int paramInt2) {
        paramCodeIterator.setMark(paramInt1);
        paramCodeIterator.writeByte(0, paramInt2);
        if (paramInt1 + 2 - paramInt2 > 32767) {
            paramInt1 = 1;
            if (paramInt1 == 0) {
                break label78;
            }
        }
        label78:
        for (int i = 4; ; i = 2) {
            paramInt2 = paramCodeIterator.insertGapAt(paramInt2, i, false).position;
            i = paramCodeIterator.getMark() - paramInt2;
            if (paramInt1 == 0) {
                break label84;
            }
            paramCodeIterator.writeByte(200, paramInt2);
            paramCodeIterator.write32bit(i, paramInt2 + 1);
            return;
            paramInt1 = 0;
            break;
        }
        label84:
        if (i <= 32767) {
            paramCodeIterator.writeByte(167, paramInt2);
            paramCodeIterator.write16bit(i, paramInt2 + 1);
            return;
        }
        paramInt1 = paramCodeIterator.insertGapAt(paramInt2, 2, false).position;
        paramCodeIterator.writeByte(200, paramInt1);
        paramCodeIterator.write32bit(paramCodeIterator.getMark() - paramInt1, paramInt1 + 1);
    }

    static void setBody0(CtClass paramCtClass1, MethodInfo paramMethodInfo1, CtClass paramCtClass2, MethodInfo paramMethodInfo2, ClassMap paramClassMap) {
        paramCtClass2.checkModify();
        paramClassMap = new ClassMap(paramClassMap);
        paramClassMap.put(paramCtClass1.getName(), paramCtClass2.getName());
        try {
            paramCtClass1 = paramMethodInfo1.getCodeAttribute();
            if (paramCtClass1 != null) {
                paramMethodInfo2.setCodeAttribute((CodeAttribute) paramCtClass1.copy(paramMethodInfo2.getConstPool(), paramClassMap));
            }
            paramMethodInfo2.setAccessFlags(paramMethodInfo2.getAccessFlags() & 0xFBFF);
            paramCtClass2.rebuildClassFile();
            return;
        } catch (CodeAttribute.RuntimeCopyException paramCtClass1) {
            throw new CannotCompileException(paramCtClass1);
        }
    }

    public void addCatch(String paramString, CtClass paramCtClass) {
        addCatch(paramString, paramCtClass, "$e");
    }

    public void addCatch(String paramString1, CtClass paramCtClass, String paramString2) {
        CtClass localCtClass = this.declaringClass;
        localCtClass.checkModify();
        ConstPool localConstPool = this.methodInfo.getConstPool();
        CodeAttribute localCodeAttribute = this.methodInfo.getCodeAttribute();
        CodeIterator localCodeIterator = localCodeAttribute.iterator();
        Bytecode localBytecode = new Bytecode(localConstPool, localCodeAttribute.getMaxStack(), localCodeAttribute.getMaxLocals());
        localBytecode.setStackDepth(1);
        Javac localJavac = new Javac(localBytecode, localCtClass);
        try {
            localJavac.recordParams(getParameterTypes(), Modifier.isStatic(getModifiers()));
            localBytecode.addAstore(localJavac.recordVariable(paramCtClass, paramString2));
            localJavac.compileStmnt(paramString1);
            int i = localBytecode.getMaxStack();
            int j = localBytecode.getMaxLocals();
            if (i > localCodeAttribute.getMaxStack()) {
                localCodeAttribute.setMaxStack(i);
            }
            if (j > localCodeAttribute.getMaxLocals()) {
                localCodeAttribute.setMaxLocals(j);
            }
            i = localCodeIterator.getCodeLength();
            j = localCodeIterator.append(localBytecode.get());
            localCodeAttribute.getExceptionTable().add(getStartPosOfBody(localCodeAttribute), i, i, localConstPool.addClassInfo(paramCtClass));
            localCodeIterator.append(localBytecode.getExceptionTable(), j);
            this.methodInfo.rebuildStackMapIf6(localCtClass.getClassPool(), localCtClass.getClassFile2());
            return;
        } catch (NotFoundException paramString1) {
            throw new CannotCompileException(paramString1);
        } catch (CompileError paramString1) {
            throw new CannotCompileException(paramString1);
        } catch (BadBytecode paramString1) {
            throw new CannotCompileException(paramString1);
        }
    }

    public void addLocalVariable(String paramString, CtClass paramCtClass) {
        this.declaringClass.checkModify();
        ConstPool localConstPool = this.methodInfo.getConstPool();
        CodeAttribute localCodeAttribute = this.methodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
            throw new CannotCompileException("no method body");
        }
        LocalVariableAttribute localLocalVariableAttribute2 = (LocalVariableAttribute) localCodeAttribute.getAttribute("LocalVariableTable");
        LocalVariableAttribute localLocalVariableAttribute1 = localLocalVariableAttribute2;
        if (localLocalVariableAttribute2 == null) {
            localLocalVariableAttribute1 = new LocalVariableAttribute(localConstPool);
            localCodeAttribute.getAttributes().add(localLocalVariableAttribute1);
        }
        int i = localCodeAttribute.getMaxLocals();
        paramCtClass = Descriptor.of(paramCtClass);
        localLocalVariableAttribute1.addEntry(0, localCodeAttribute.getCodeLength(), localConstPool.addUtf8Info(paramString), localConstPool.addUtf8Info(paramCtClass), i);
        localCodeAttribute.setMaxLocals(Descriptor.dataSize(paramCtClass) + i);
    }

    public void addParameter(CtClass paramCtClass) {
        this.declaringClass.checkModify();
        String str1 = this.methodInfo.getDescriptor();
        String str2 = Descriptor.appendParameter(paramCtClass, str1);
        if (Modifier.isStatic(getModifiers())) {
        }
        for (int i = 0; ; i = 1) {
            try {
                addParameter2(i + Descriptor.paramSize(str1), paramCtClass, str1);
                this.methodInfo.setDescriptor(str2);
                return;
            } catch (BadBytecode paramCtClass) {
                throw new CannotCompileException(paramCtClass);
            }
        }
    }

    void copy(CtBehavior paramCtBehavior, boolean paramBoolean, ClassMap paramClassMap) {
        CtClass localCtClass = this.declaringClass;
        MethodInfo localMethodInfo = paramCtBehavior.methodInfo;
        paramCtBehavior = paramCtBehavior.getDeclaringClass();
        ConstPool localConstPool = localCtClass.getClassFile2().getConstPool();
        ClassMap localClassMap = new ClassMap(paramClassMap);
        localClassMap.put(paramCtBehavior.getName(), localCtClass.getName());
        int j = 0;
        try {
            Object localObject = paramCtBehavior.getSuperclass();
            localCtClass = localCtClass.getSuperclass();
            paramClassMap = null;
            paramCtBehavior = paramClassMap;
            int i = j;
            if (localObject != null) {
                paramCtBehavior = paramClassMap;
                i = j;
                if (localCtClass != null) {
                    localObject = ((CtClass) localObject).getName();
                    paramClassMap = localCtClass.getName();
                    paramCtBehavior = paramClassMap;
                    i = j;
                    if (!((String) localObject).equals(paramClassMap)) {
                        if (!((String) localObject).equals("java.lang.Object")) {
                            break label175;
                        }
                        i = 1;
                        paramCtBehavior = paramClassMap;
                    }
                }
            }
            for (; ; ) {
                this.methodInfo = new MethodInfo(localConstPool, localMethodInfo.getName(), localMethodInfo, localClassMap);
                if ((!paramBoolean) || (i == 0)) {
                    break;
                }
                this.methodInfo.setSuperclass(paramCtBehavior);
                return;
                label175:
                localClassMap.putIfNone((String) localObject, paramClassMap);
                paramCtBehavior = paramClassMap;
                i = j;
            }
            return;
        } catch (NotFoundException paramCtBehavior) {
            throw new CannotCompileException(paramCtBehavior);
        } catch (BadBytecode paramCtBehavior) {
            throw new CannotCompileException(paramCtBehavior);
        }
    }

    protected void extendToString(StringBuffer paramStringBuffer) {
        paramStringBuffer.append(' ');
        paramStringBuffer.append(getName());
        paramStringBuffer.append(' ');
        paramStringBuffer.append(this.methodInfo.getDescriptor());
    }

    public Object getAnnotation(Class paramClass) {
        Object localObject = getMethodInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.getAnnotationType(paramClass, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public Object[] getAnnotations() {
        return getAnnotations(false);
    }

    public byte[] getAttribute(String paramString) {
        paramString = this.methodInfo.getAttribute(paramString);
        if (paramString == null) {
            return null;
        }
        return paramString.get();
    }

    public Object[] getAvailableAnnotations() {
        try {
            Object[] arrayOfObject = getAnnotations(true);
            return arrayOfObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("Unexpected exception", localClassNotFoundException);
        }
    }

    public Object[][] getAvailableParameterAnnotations() {
        try {
            Object[][] arrayOfObject = getParameterAnnotations(true);
            return arrayOfObject;
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new RuntimeException("Unexpected exception", localClassNotFoundException);
        }
    }

    public CtClass[] getExceptionTypes() {
        Object localObject = this.methodInfo.getExceptionsAttribute();
        if (localObject == null) {
        }
        for (localObject = null; ; localObject = ((ExceptionsAttribute) localObject).getExceptions()) {
            return this.declaringClass.getClassPool().get((String[]) localObject);
        }
    }

    public abstract String getLongName();

    public MethodInfo getMethodInfo() {
        this.declaringClass.checkModify();
        return this.methodInfo;
    }

    public MethodInfo getMethodInfo2() {
        return this.methodInfo;
    }

    public int getModifiers() {
        return AccessFlag.toModifier(this.methodInfo.getAccessFlags());
    }

    public Object[][] getParameterAnnotations() {
        return getParameterAnnotations(false);
    }

    Object[][] getParameterAnnotations(boolean paramBoolean) {
        MethodInfo localMethodInfo = getMethodInfo2();
        ParameterAnnotationsAttribute localParameterAnnotationsAttribute1 = (ParameterAnnotationsAttribute) localMethodInfo.getAttribute("RuntimeInvisibleParameterAnnotations");
        ParameterAnnotationsAttribute localParameterAnnotationsAttribute2 = (ParameterAnnotationsAttribute) localMethodInfo.getAttribute("RuntimeVisibleParameterAnnotations");
        return CtClassType.toAnnotationType(paramBoolean, getDeclaringClass().getClassPool(), localParameterAnnotationsAttribute1, localParameterAnnotationsAttribute2, localMethodInfo);
    }

    public CtClass[] getParameterTypes() {
        return Descriptor.getParameterTypes(this.methodInfo.getDescriptor(), this.declaringClass.getClassPool());
    }

    CtClass getReturnType0() {
        return Descriptor.getReturnType(this.methodInfo.getDescriptor(), this.declaringClass.getClassPool());
    }

    public String getSignature() {
        return this.methodInfo.getDescriptor();
    }

    int getStartPosOfBody(CodeAttribute paramCodeAttribute) {
        return 0;
    }

    public boolean hasAnnotation(Class paramClass) {
        Object localObject = getMethodInfo2();
        AnnotationsAttribute localAnnotationsAttribute = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeInvisibleAnnotations");
        localObject = (AnnotationsAttribute) ((MethodInfo) localObject).getAttribute("RuntimeVisibleAnnotations");
        return CtClassType.hasAnnotationType(paramClass, getDeclaringClass().getClassPool(), localAnnotationsAttribute, (AnnotationsAttribute) localObject);
    }

    public void insertAfter(String paramString) {
        insertAfter(paramString, false);
    }

    /* Error */
    public void insertAfter(String paramString, boolean paramBoolean) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 195	javassist/CtBehavior:declaringClass	Ljavassist/CtClass;
        //   4: astore 7
        //   6: aload 7
        //   8: invokevirtual 199	javassist/CtClass:checkModify	()V
        //   11: aload_0
        //   12: getfield 13	javassist/CtBehavior:methodInfo	Ljavassist/bytecode/MethodInfo;
        //   15: invokevirtual 76	javassist/bytecode/MethodInfo:getConstPool	()Ljavassist/bytecode/ConstPool;
        //   18: astore 8
        //   20: aload_0
        //   21: getfield 13	javassist/CtBehavior:methodInfo	Ljavassist/bytecode/MethodInfo;
        //   24: invokevirtual 22	javassist/bytecode/MethodInfo:getCodeAttribute	()Ljavassist/bytecode/CodeAttribute;
        //   27: astore 9
        //   29: aload 9
        //   31: ifnonnull +13 -> 44
        //   34: new 201	javassist/CannotCompileException
        //   37: dup
        //   38: ldc -53
        //   40: invokespecial 205	javassist/CannotCompileException:<init>	(Ljava/lang/String;)V
        //   43: athrow
        //   44: aload 9
        //   46: invokevirtual 209	javassist/bytecode/CodeAttribute:iterator	()Ljavassist/bytecode/CodeIterator;
        //   49: astore 10
        //   51: new 117	javassist/bytecode/Bytecode
        //   54: dup
        //   55: aload 8
        //   57: iconst_0
        //   58: aload 9
        //   60: invokevirtual 252	javassist/bytecode/CodeAttribute:getMaxLocals	()I
        //   63: iconst_1
        //   64: iadd
        //   65: invokespecial 359	javassist/bytecode/Bytecode:<init>	(Ljavassist/bytecode/ConstPool;II)V
        //   68: astore 11
        //   70: aload 11
        //   72: aload 9
        //   74: invokevirtual 248	javassist/bytecode/CodeAttribute:getMaxStack	()I
        //   77: iconst_1
        //   78: iadd
        //   79: invokevirtual 362	javassist/bytecode/Bytecode:setStackDepth	(I)V
        //   82: new 126	javassist/compiler/Javac
        //   85: dup
        //   86: aload 11
        //   88: aload 7
        //   90: invokespecial 365	javassist/compiler/Javac:<init>	(Ljavassist/bytecode/Bytecode;Ljavassist/CtClass;)V
        //   93: astore 12
        //   95: aload 12
        //   97: aload 9
        //   99: aload 12
        //   101: aload_0
        //   102: invokevirtual 214	javassist/CtBehavior:getParameterTypes	()[Ljavassist/CtClass;
        //   105: aload_0
        //   106: invokevirtual 217	javassist/CtBehavior:getModifiers	()I
        //   109: invokestatic 223	javassist/Modifier:isStatic	(I)Z
        //   112: invokevirtual 227	javassist/compiler/Javac:recordParams	([Ljavassist/CtClass;Z)I
        //   115: invokevirtual 231	javassist/compiler/Javac:recordParamNames	(Ljavassist/bytecode/CodeAttribute;I)Z
        //   118: pop
        //   119: aload_0
        //   120: invokevirtual 237	javassist/CtBehavior:getReturnType0	()Ljavassist/CtClass;
        //   123: astore 13
        //   125: aload 12
        //   127: aload 13
        //   129: iconst_1
        //   130: invokevirtual 552	javassist/compiler/Javac:recordReturnType	(Ljavassist/CtClass;Z)I
        //   133: istore 4
        //   135: aload 12
        //   137: aload 9
        //   139: iconst_0
        //   140: invokevirtual 234	javassist/compiler/Javac:recordLocalVariables	(Ljavassist/bytecode/CodeAttribute;I)Z
        //   143: pop
        //   144: aload_0
        //   145: iload_2
        //   146: aload 11
        //   148: aload 13
        //   150: iload 4
        //   152: aload 12
        //   154: aload_1
        //   155: invokespecial 554	javassist/CtBehavior:insertAfterHandler	(ZLjavassist/bytecode/Bytecode;Ljavassist/CtClass;ILjavassist/compiler/Javac;Ljava/lang/String;)I
        //   158: istore_3
        //   159: aload_0
        //   160: aload 11
        //   162: aload 12
        //   164: aload_1
        //   165: aload 8
        //   167: aload 13
        //   169: iload 4
        //   171: invokespecial 556	javassist/CtBehavior:insertAfterAdvice	(Ljavassist/bytecode/Bytecode;Ljavassist/compiler/Javac;Ljava/lang/String;Ljavassist/bytecode/ConstPool;Ljavassist/CtClass;I)V
        //   174: aload 9
        //   176: aload 11
        //   178: invokevirtual 247	javassist/bytecode/Bytecode:getMaxStack	()I
        //   181: invokevirtual 251	javassist/bytecode/CodeAttribute:setMaxStack	(I)V
        //   184: aload 9
        //   186: aload 11
        //   188: invokevirtual 133	javassist/bytecode/Bytecode:getMaxLocals	()I
        //   191: invokevirtual 253	javassist/bytecode/CodeAttribute:setMaxLocals	(I)V
        //   194: aload 10
        //   196: aload 11
        //   198: invokevirtual 257	javassist/bytecode/Bytecode:get	()[B
        //   201: invokevirtual 375	javassist/bytecode/CodeIterator:append	([B)I
        //   204: istore 4
        //   206: aload 10
        //   208: aload 11
        //   210: invokevirtual 267	javassist/bytecode/Bytecode:getExceptionTable	()Ljavassist/bytecode/ExceptionTable;
        //   213: iload 4
        //   215: invokevirtual 388	javassist/bytecode/CodeIterator:append	(Ljavassist/bytecode/ExceptionTable;I)V
        //   218: iload_2
        //   219: ifeq +22 -> 241
        //   222: aload 9
        //   224: invokevirtual 376	javassist/bytecode/CodeAttribute:getExceptionTable	()Ljavassist/bytecode/ExceptionTable;
        //   227: aload_0
        //   228: aload 9
        //   230: invokevirtual 380	javassist/CtBehavior:getStartPosOfBody	(Ljavassist/bytecode/CodeAttribute;)I
        //   233: iload 4
        //   235: iload 4
        //   237: iconst_0
        //   238: invokevirtual 386	javassist/bytecode/ExceptionTable:add	(IIII)V
        //   241: aload 10
        //   243: invokevirtual 372	javassist/bytecode/CodeIterator:getCodeLength	()I
        //   246: iload 4
        //   248: isub
        //   249: iload_3
        //   250: isub
        //   251: istore 4
        //   253: aload 10
        //   255: invokevirtual 372	javassist/bytecode/CodeIterator:getCodeLength	()I
        //   258: iload 4
        //   260: isub
        //   261: istore_3
        //   262: aload 10
        //   264: invokevirtual 559	javassist/bytecode/CodeIterator:hasNext	()Z
        //   267: ifeq +16 -> 283
        //   270: aload 10
        //   272: invokevirtual 562	javassist/bytecode/CodeIterator:next	()I
        //   275: istore 5
        //   277: iload 5
        //   279: iload_3
        //   280: if_icmplt +21 -> 301
        //   283: aload_0
        //   284: getfield 13	javassist/CtBehavior:methodInfo	Ljavassist/bytecode/MethodInfo;
        //   287: aload 7
        //   289: invokevirtual 103	javassist/CtClass:getClassPool	()Ljavassist/ClassPool;
        //   292: aload 7
        //   294: invokevirtual 275	javassist/CtClass:getClassFile2	()Ljavassist/bytecode/ClassFile;
        //   297: invokevirtual 279	javassist/bytecode/MethodInfo:rebuildStackMapIf6	(Ljavassist/ClassPool;Ljavassist/bytecode/ClassFile;)V
        //   300: return
        //   301: aload 10
        //   303: iload 5
        //   305: invokevirtual 565	javassist/bytecode/CodeIterator:byteAt	(I)I
        //   308: istore 6
        //   310: iload 6
        //   312: sipush 176
        //   315: if_icmpeq +43 -> 358
        //   318: iload 6
        //   320: sipush 172
        //   323: if_icmpeq +35 -> 358
        //   326: iload 6
        //   328: sipush 174
        //   331: if_icmpeq +27 -> 358
        //   334: iload 6
        //   336: sipush 173
        //   339: if_icmpeq +19 -> 358
        //   342: iload 6
        //   344: sipush 175
        //   347: if_icmpeq +11 -> 358
        //   350: iload 6
        //   352: sipush 177
        //   355: if_icmpne -93 -> 262
        //   358: aload_0
        //   359: aload 10
        //   361: iload_3
        //   362: iload 5
        //   364: invokespecial 567	javassist/CtBehavior:insertGoto	(Ljavassist/bytecode/CodeIterator;II)V
        //   367: aload 10
        //   369: invokevirtual 372	javassist/bytecode/CodeIterator:getCodeLength	()I
        //   372: istore_3
        //   373: iload_3
        //   374: iload 4
        //   376: isub
        //   377: istore_3
        //   378: goto -116 -> 262
        //   381: astore_1
        //   382: new 201	javassist/CannotCompileException
        //   385: dup
        //   386: aload_1
        //   387: invokespecial 282	javassist/CannotCompileException:<init>	(Ljavassist/NotFoundException;)V
        //   390: athrow
        //   391: astore_1
        //   392: new 201	javassist/CannotCompileException
        //   395: dup
        //   396: aload_1
        //   397: invokespecial 285	javassist/CannotCompileException:<init>	(Ljavassist/compiler/CompileError;)V
        //   400: athrow
        //   401: astore_1
        //   402: new 201	javassist/CannotCompileException
        //   405: dup
        //   406: aload_1
        //   407: invokespecial 288	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   410: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	411	0	this	CtBehavior
        //   0	411	1	paramString	String
        //   0	411	2	paramBoolean	boolean
        //   158	220	3	i	int
        //   133	244	4	j	int
        //   275	88	5	k	int
        //   308	48	6	m	int
        //   4	289	7	localCtClass1	CtClass
        //   18	148	8	localConstPool	ConstPool
        //   27	202	9	localCodeAttribute	CodeAttribute
        //   49	319	10	localCodeIterator	CodeIterator
        //   68	141	11	localBytecode	Bytecode
        //   93	70	12	localJavac	Javac
        //   123	45	13	localCtClass2	CtClass
        // Exception table:
        //   from	to	target	type
        //   95	218	381	javassist/NotFoundException
        //   222	241	381	javassist/NotFoundException
        //   241	262	381	javassist/NotFoundException
        //   262	277	381	javassist/NotFoundException
        //   283	300	381	javassist/NotFoundException
        //   301	310	381	javassist/NotFoundException
        //   358	373	381	javassist/NotFoundException
        //   95	218	391	javassist/compiler/CompileError
        //   222	241	391	javassist/compiler/CompileError
        //   241	262	391	javassist/compiler/CompileError
        //   262	277	391	javassist/compiler/CompileError
        //   283	300	391	javassist/compiler/CompileError
        //   301	310	391	javassist/compiler/CompileError
        //   358	373	391	javassist/compiler/CompileError
        //   95	218	401	javassist/bytecode/BadBytecode
        //   222	241	401	javassist/bytecode/BadBytecode
        //   241	262	401	javassist/bytecode/BadBytecode
        //   262	277	401	javassist/bytecode/BadBytecode
        //   283	300	401	javassist/bytecode/BadBytecode
        //   301	310	401	javassist/bytecode/BadBytecode
        //   358	373	401	javassist/bytecode/BadBytecode
    }

    public int insertAt(int paramInt, String paramString) {
        return insertAt(paramInt, true, paramString);
    }

    public int insertAt(int paramInt, boolean paramBoolean, String paramString) {
        CodeAttribute localCodeAttribute = this.methodInfo.getCodeAttribute();
        if (localCodeAttribute == null) {
            throw new CannotCompileException("no method body");
        }
        Object localObject = (LineNumberAttribute) localCodeAttribute.getAttribute("LineNumberTable");
        if (localObject == null) {
            throw new CannotCompileException("no line number info");
        }
        localObject = ((LineNumberAttribute) localObject).toNearPc(paramInt);
        paramInt = ((LineNumberAttribute.Pc) localObject).line;
        int i = ((LineNumberAttribute.Pc) localObject).index;
        if (!paramBoolean) {
            return paramInt;
        }
        localObject = this.declaringClass;
        ((CtClass) localObject).checkModify();
        CodeIterator localCodeIterator = localCodeAttribute.iterator();
        Javac localJavac = new Javac((CtClass) localObject);
        try {
            localJavac.recordLocalVariables(localCodeAttribute, i);
            localJavac.recordParams(getParameterTypes(), Modifier.isStatic(getModifiers()));
            localJavac.setMaxLocals(localCodeAttribute.getMaxLocals());
            localJavac.compileStmnt(paramString);
            paramString = localJavac.getBytecode();
            int j = paramString.getMaxLocals();
            int k = paramString.getMaxStack();
            localCodeAttribute.setMaxLocals(j);
            if (k > localCodeAttribute.getMaxStack()) {
                localCodeAttribute.setMaxStack(k);
            }
            i = localCodeIterator.insertAt(i, paramString.get());
            localCodeIterator.insert(paramString.getExceptionTable(), i);
            this.methodInfo.rebuildStackMapIf6(((CtClass) localObject).getClassPool(), ((CtClass) localObject).getClassFile2());
            return paramInt;
        } catch (NotFoundException paramString) {
            throw new CannotCompileException(paramString);
        } catch (CompileError paramString) {
            throw new CannotCompileException(paramString);
        } catch (BadBytecode paramString) {
            throw new CannotCompileException(paramString);
        }
    }

    public void insertBefore(String paramString) {
        insertBefore(paramString, true);
    }

    /* Error */
    public void insertParameter(CtClass paramCtClass) {
        // Byte code:
        //   0: aload_0
        //   1: getfield 195	javassist/CtBehavior:declaringClass	Ljavassist/CtClass;
        //   4: invokevirtual 199	javassist/CtClass:checkModify	()V
        //   7: aload_0
        //   8: getfield 13	javassist/CtBehavior:methodInfo	Ljavassist/bytecode/MethodInfo;
        //   11: invokevirtual 422	javassist/bytecode/MethodInfo:getDescriptor	()Ljava/lang/String;
        //   14: astore_3
        //   15: aload_1
        //   16: aload_3
        //   17: invokestatic 599	javassist/bytecode/Descriptor:insertParameter	(Ljavassist/CtClass;Ljava/lang/String;)Ljava/lang/String;
        //   20: astore 4
        //   22: aload_0
        //   23: invokevirtual 217	javassist/CtBehavior:getModifiers	()I
        //   26: invokestatic 223	javassist/Modifier:isStatic	(I)Z
        //   29: ifeq +22 -> 51
        //   32: iconst_0
        //   33: istore_2
        //   34: aload_0
        //   35: iload_2
        //   36: aload_1
        //   37: aload_3
        //   38: invokespecial 431	javassist/CtBehavior:addParameter2	(ILjavassist/CtClass;Ljava/lang/String;)V
        //   41: aload_0
        //   42: getfield 13	javassist/CtBehavior:methodInfo	Ljavassist/bytecode/MethodInfo;
        //   45: aload 4
        //   47: invokevirtual 434	javassist/bytecode/MethodInfo:setDescriptor	(Ljava/lang/String;)V
        //   50: return
        //   51: iconst_1
        //   52: istore_2
        //   53: goto -19 -> 34
        //   56: astore_1
        //   57: new 201	javassist/CannotCompileException
        //   60: dup
        //   61: aload_1
        //   62: invokespecial 288	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   65: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	66	0	this	CtBehavior
        //   0	66	1	paramCtClass	CtClass
        //   33	20	2	i	int
        //   14	24	3	str1	String
        //   20	26	4	str2	String
        // Exception table:
        //   from	to	target	type
        //   22	32	56	javassist/bytecode/BadBytecode
        //   34	41	56	javassist/bytecode/BadBytecode
    }

    public void instrument(CodeConverter paramCodeConverter) {
        this.declaringClass.checkModify();
        ConstPool localConstPool = this.methodInfo.getConstPool();
        paramCodeConverter.doit(getDeclaringClass(), this.methodInfo, localConstPool);
    }

    public void instrument(ExprEditor paramExprEditor) {
        if (this.declaringClass.isFrozen()) {
            this.declaringClass.checkModify();
        }
        if (paramExprEditor.doit(this.declaringClass, this.methodInfo)) {
            this.declaringClass.checkModify();
        }
    }

    public abstract boolean isEmpty();

    public void setAttribute(String paramString, byte[] paramArrayOfByte) {
        this.declaringClass.checkModify();
        this.methodInfo.addAttribute(new AttributeInfo(this.methodInfo.getConstPool(), paramString, paramArrayOfByte));
    }

    public void setBody(String paramString) {
        setBody(paramString, null, null);
    }

    public void setBody(String paramString1, String paramString2, String paramString3) {
        CtClass localCtClass = this.declaringClass;
        localCtClass.checkModify();
        try {
            Javac localJavac = new Javac(localCtClass);
            if (paramString3 != null) {
                localJavac.recordProceed(paramString2, paramString3);
            }
            paramString1 = localJavac.compileBody(this, paramString1);
            this.methodInfo.setCodeAttribute(paramString1.toCodeAttribute());
            this.methodInfo.setAccessFlags(this.methodInfo.getAccessFlags() & 0xFBFF);
            this.methodInfo.rebuildStackMapIf6(localCtClass.getClassPool(), localCtClass.getClassFile2());
            this.declaringClass.rebuildClassFile();
            return;
        } catch (CompileError paramString1) {
            throw new CannotCompileException(paramString1);
        } catch (BadBytecode paramString1) {
            throw new CannotCompileException(paramString1);
        }
    }

    public void setExceptionTypes(CtClass[] paramArrayOfCtClass) {
        this.declaringClass.checkModify();
        if ((paramArrayOfCtClass == null) || (paramArrayOfCtClass.length == 0)) {
            this.methodInfo.removeExceptionsAttribute();
            return;
        }
        String[] arrayOfString = new String[paramArrayOfCtClass.length];
        int i = 0;
        while (i < paramArrayOfCtClass.length) {
            arrayOfString[i] = paramArrayOfCtClass[i].getName();
            i += 1;
        }
        ExceptionsAttribute localExceptionsAttribute = this.methodInfo.getExceptionsAttribute();
        paramArrayOfCtClass = localExceptionsAttribute;
        if (localExceptionsAttribute == null) {
            paramArrayOfCtClass = new ExceptionsAttribute(this.methodInfo.getConstPool());
            this.methodInfo.setExceptionsAttribute(paramArrayOfCtClass);
        }
        paramArrayOfCtClass.setExceptions(arrayOfString);
    }

    public void setModifiers(int paramInt) {
        this.declaringClass.checkModify();
        this.methodInfo.setAccessFlags(AccessFlag.of(paramInt));
    }

    public void useCflow(String paramString) {
        int i = 0;
        CtClass localCtClass = this.declaringClass;
        localCtClass.checkModify();
        Object localObject = localCtClass.getClassPool();
        for (; ; ) {
            String str = "_cflow$" + i;
            try {
                localCtClass.getDeclaredField(str);
                i += 1;
            } catch (NotFoundException localNotFoundException) {
                ((ClassPool) localObject).recordCflow(paramString, this.declaringClass.getName(), str);
                try {
                    paramString = ((ClassPool) localObject).get("javassist.runtime.Cflow");
                    localObject = new CtField(paramString, str, localCtClass);
                    ((CtField) localObject).setModifiers(9);
                    localCtClass.addField((CtField) localObject, CtField.Initializer.byNew(paramString));
                    insertBefore(str + ".enter();", false);
                    insertAfter(str + ".exit();", true);
                    return;
                } catch (NotFoundException paramString) {
                    throw new CannotCompileException(paramString);
                }
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */