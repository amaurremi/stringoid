package javassist;

import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.MethodInfo;
import javassist.compiler.CompileError;
import javassist.compiler.Javac;

public class CtNewMethod {
    public static CtMethod abstractMethod(CtClass paramCtClass1, String paramString, CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, CtClass paramCtClass2) {
        paramCtClass1 = new CtMethod(paramCtClass1, paramString, paramArrayOfCtClass1, paramCtClass2);
        paramCtClass1.setExceptionTypes(paramArrayOfCtClass2);
        return paramCtClass1;
    }

    public static CtMethod copy(CtMethod paramCtMethod, String paramString, CtClass paramCtClass, ClassMap paramClassMap) {
        paramCtMethod = new CtMethod(paramCtMethod, paramCtClass, paramClassMap);
        paramCtMethod.setName(paramString);
        return paramCtMethod;
    }

    public static CtMethod copy(CtMethod paramCtMethod, CtClass paramCtClass, ClassMap paramClassMap) {
        return new CtMethod(paramCtMethod, paramCtClass, paramClassMap);
    }

    public static CtMethod delegator(CtMethod paramCtMethod, CtClass paramCtClass) {
        try {
            paramCtMethod = delegator0(paramCtMethod, paramCtClass);
            return paramCtMethod;
        } catch (NotFoundException paramCtMethod) {
            throw new CannotCompileException(paramCtMethod);
        }
    }

    private static CtMethod delegator0(CtMethod paramCtMethod, CtClass paramCtClass) {
        Object localObject2 = paramCtMethod.getMethodInfo2();
        String str1 = ((MethodInfo) localObject2).getName();
        String str2 = ((MethodInfo) localObject2).getDescriptor();
        Object localObject1 = paramCtClass.getClassFile2().getConstPool();
        MethodInfo localMethodInfo = new MethodInfo((ConstPool) localObject1, str1, str2);
        localMethodInfo.setAccessFlags(((MethodInfo) localObject2).getAccessFlags());
        localObject2 = ((MethodInfo) localObject2).getExceptionsAttribute();
        if (localObject2 != null) {
            localMethodInfo.setExceptionsAttribute((ExceptionsAttribute) ((ExceptionsAttribute) localObject2).copy((ConstPool) localObject1, null));
        }
        localObject1 = new Bytecode((ConstPool) localObject1, 0, 0);
        boolean bool = Modifier.isStatic(paramCtMethod.getModifiers());
        localObject2 = paramCtMethod.getDeclaringClass();
        CtClass[] arrayOfCtClass = paramCtMethod.getParameterTypes();
        int i;
        if (bool) {
            i = ((Bytecode) localObject1).addLoadParameters(arrayOfCtClass, 0);
            ((Bytecode) localObject1).addInvokestatic((CtClass) localObject2, str1, str2);
        }
        for (; ; ) {
            ((Bytecode) localObject1).addReturn(paramCtMethod.getReturnType());
            int j = i + 1;
            ((Bytecode) localObject1).setMaxLocals(j);
            i = j;
            if (j < 2) {
                i = 2;
            }
            ((Bytecode) localObject1).setMaxStack(i);
            localMethodInfo.setCodeAttribute(((Bytecode) localObject1).toCodeAttribute());
            return new CtMethod(localMethodInfo, paramCtClass);
            ((Bytecode) localObject1).addLoad(0, (CtClass) localObject2);
            i = ((Bytecode) localObject1).addLoadParameters(arrayOfCtClass, 1);
            ((Bytecode) localObject1).addInvokespecial((CtClass) localObject2, str1, str2);
        }
    }

    /* Error */
    public static CtMethod getter(String paramString, CtField paramCtField) {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 160	javassist/CtField:getFieldInfo2	()Ljavassist/bytecode/FieldInfo;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 163	javassist/bytecode/FieldInfo:getDescriptor	()Ljava/lang/String;
        //   9: astore_3
        //   10: new 165	java/lang/StringBuilder
        //   13: dup
        //   14: invokespecial 166	java/lang/StringBuilder:<init>	()V
        //   17: ldc -88
        //   19: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   22: aload_3
        //   23: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   26: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   29: astore 5
        //   31: aload_2
        //   32: invokevirtual 176	javassist/bytecode/FieldInfo:getConstPool	()Ljavassist/bytecode/ConstPool;
        //   35: astore 4
        //   37: new 48	javassist/bytecode/MethodInfo
        //   40: dup
        //   41: aload 4
        //   43: aload_0
        //   44: aload 5
        //   46: invokespecial 70	javassist/bytecode/MethodInfo:<init>	(Ljavassist/bytecode/ConstPool;Ljava/lang/String;Ljava/lang/String;)V
        //   49: astore_0
        //   50: aload_0
        //   51: iconst_1
        //   52: invokevirtual 78	javassist/bytecode/MethodInfo:setAccessFlags	(I)V
        //   55: new 93	javassist/bytecode/Bytecode
        //   58: dup
        //   59: aload 4
        //   61: iconst_2
        //   62: iconst_1
        //   63: invokespecial 96	javassist/bytecode/Bytecode:<init>	(Ljavassist/bytecode/ConstPool;II)V
        //   66: astore 4
        //   68: aload_2
        //   69: invokevirtual 177	javassist/bytecode/FieldInfo:getName	()Ljava/lang/String;
        //   72: astore 5
        //   74: aload_2
        //   75: invokevirtual 178	javassist/bytecode/FieldInfo:getAccessFlags	()I
        //   78: bipush 8
        //   80: iand
        //   81: ifne +51 -> 132
        //   84: aload 4
        //   86: iconst_0
        //   87: invokevirtual 181	javassist/bytecode/Bytecode:addAload	(I)V
        //   90: aload 4
        //   92: getstatic 185	javassist/bytecode/Bytecode:THIS	Ljavassist/CtClass;
        //   95: aload 5
        //   97: aload_3
        //   98: invokevirtual 188	javassist/bytecode/Bytecode:addGetfield	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   101: aload 4
        //   103: aload_1
        //   104: invokevirtual 191	javassist/CtField:getType	()Ljavassist/CtClass;
        //   107: invokevirtual 128	javassist/bytecode/Bytecode:addReturn	(Ljavassist/CtClass;)V
        //   110: aload_0
        //   111: aload 4
        //   113: invokevirtual 138	javassist/bytecode/Bytecode:toCodeAttribute	()Ljavassist/bytecode/CodeAttribute;
        //   116: invokevirtual 142	javassist/bytecode/MethodInfo:setCodeAttribute	(Ljavassist/bytecode/CodeAttribute;)V
        //   119: new 13	javassist/CtMethod
        //   122: dup
        //   123: aload_0
        //   124: aload_1
        //   125: invokevirtual 192	javassist/CtField:getDeclaringClass	()Ljavassist/CtClass;
        //   128: invokespecial 145	javassist/CtMethod:<init>	(Ljavassist/bytecode/MethodInfo;Ljavassist/CtClass;)V
        //   131: areturn
        //   132: aload 4
        //   134: getstatic 185	javassist/bytecode/Bytecode:THIS	Ljavassist/CtClass;
        //   137: aload 5
        //   139: aload_3
        //   140: invokevirtual 195	javassist/bytecode/Bytecode:addGetstatic	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   143: goto -42 -> 101
        //   146: astore_0
        //   147: new 39	javassist/CannotCompileException
        //   150: dup
        //   151: aload_0
        //   152: invokespecial 42	javassist/CannotCompileException:<init>	(Ljavassist/NotFoundException;)V
        //   155: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	156	0	paramString	String
        //   0	156	1	paramCtField	CtField
        //   4	71	2	localFieldInfo	javassist.bytecode.FieldInfo
        //   9	131	3	str1	String
        //   35	98	4	localObject	Object
        //   29	109	5	str2	String
        // Exception table:
        //   from	to	target	type
        //   68	101	146	javassist/NotFoundException
        //   101	110	146	javassist/NotFoundException
        //   132	143	146	javassist/NotFoundException
    }

    public static CtMethod make(int paramInt, CtClass paramCtClass1, String paramString1, CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, String paramString2, CtClass paramCtClass2) {
        try {
            paramCtClass1 = new CtMethod(paramCtClass1, paramString1, paramArrayOfCtClass1, paramCtClass2);
            paramCtClass1.setModifiers(paramInt);
            paramCtClass1.setExceptionTypes(paramArrayOfCtClass2);
            paramCtClass1.setBody(paramString2);
            return paramCtClass1;
        } catch (NotFoundException paramCtClass1) {
            throw new CannotCompileException(paramCtClass1);
        }
    }

    public static CtMethod make(String paramString, CtClass paramCtClass) {
        return make(paramString, paramCtClass, null, null);
    }

    public static CtMethod make(String paramString1, CtClass paramCtClass, String paramString2, String paramString3) {
        paramCtClass = new Javac(paramCtClass);
        if (paramString3 != null) {
        }
        try {
            paramCtClass.recordProceed(paramString2, paramString3);
            paramString1 = paramCtClass.compile(paramString1);
            if ((paramString1 instanceof CtMethod)) {
                paramString1 = (CtMethod) paramString1;
                return paramString1;
            }
        } catch (CompileError paramString1) {
            throw new CannotCompileException(paramString1);
        }
        throw new CannotCompileException("not a method");
    }

    public static CtMethod make(CtClass paramCtClass1, String paramString1, CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, String paramString2, CtClass paramCtClass2) {
        return make(1, paramCtClass1, paramString1, paramArrayOfCtClass1, paramArrayOfCtClass2, paramString2, paramCtClass2);
    }

    /* Error */
    public static CtMethod setter(String paramString, CtField paramCtField) {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 160	javassist/CtField:getFieldInfo2	()Ljavassist/bytecode/FieldInfo;
        //   4: astore_2
        //   5: aload_2
        //   6: invokevirtual 163	javassist/bytecode/FieldInfo:getDescriptor	()Ljava/lang/String;
        //   9: astore_3
        //   10: new 165	java/lang/StringBuilder
        //   13: dup
        //   14: invokespecial 166	java/lang/StringBuilder:<init>	()V
        //   17: ldc -22
        //   19: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   22: aload_3
        //   23: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   26: ldc -20
        //   28: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   31: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   34: astore 5
        //   36: aload_2
        //   37: invokevirtual 176	javassist/bytecode/FieldInfo:getConstPool	()Ljavassist/bytecode/ConstPool;
        //   40: astore 4
        //   42: new 48	javassist/bytecode/MethodInfo
        //   45: dup
        //   46: aload 4
        //   48: aload_0
        //   49: aload 5
        //   51: invokespecial 70	javassist/bytecode/MethodInfo:<init>	(Ljavassist/bytecode/ConstPool;Ljava/lang/String;Ljava/lang/String;)V
        //   54: astore_0
        //   55: aload_0
        //   56: iconst_1
        //   57: invokevirtual 78	javassist/bytecode/MethodInfo:setAccessFlags	(I)V
        //   60: new 93	javassist/bytecode/Bytecode
        //   63: dup
        //   64: aload 4
        //   66: iconst_3
        //   67: iconst_3
        //   68: invokespecial 96	javassist/bytecode/Bytecode:<init>	(Ljavassist/bytecode/ConstPool;II)V
        //   71: astore 4
        //   73: aload_2
        //   74: invokevirtual 177	javassist/bytecode/FieldInfo:getName	()Ljava/lang/String;
        //   77: astore 5
        //   79: aload_2
        //   80: invokevirtual 178	javassist/bytecode/FieldInfo:getAccessFlags	()I
        //   83: bipush 8
        //   85: iand
        //   86: ifne +59 -> 145
        //   89: aload 4
        //   91: iconst_0
        //   92: invokevirtual 181	javassist/bytecode/Bytecode:addAload	(I)V
        //   95: aload 4
        //   97: iconst_1
        //   98: aload_1
        //   99: invokevirtual 191	javassist/CtField:getType	()Ljavassist/CtClass;
        //   102: invokevirtual 149	javassist/bytecode/Bytecode:addLoad	(ILjavassist/CtClass;)I
        //   105: pop
        //   106: aload 4
        //   108: getstatic 185	javassist/bytecode/Bytecode:THIS	Ljavassist/CtClass;
        //   111: aload 5
        //   113: aload_3
        //   114: invokevirtual 239	javassist/bytecode/Bytecode:addPutfield	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   117: aload 4
        //   119: aconst_null
        //   120: invokevirtual 128	javassist/bytecode/Bytecode:addReturn	(Ljavassist/CtClass;)V
        //   123: aload_0
        //   124: aload 4
        //   126: invokevirtual 138	javassist/bytecode/Bytecode:toCodeAttribute	()Ljavassist/bytecode/CodeAttribute;
        //   129: invokevirtual 142	javassist/bytecode/MethodInfo:setCodeAttribute	(Ljavassist/bytecode/CodeAttribute;)V
        //   132: new 13	javassist/CtMethod
        //   135: dup
        //   136: aload_0
        //   137: aload_1
        //   138: invokevirtual 192	javassist/CtField:getDeclaringClass	()Ljavassist/CtClass;
        //   141: invokespecial 145	javassist/CtMethod:<init>	(Ljavassist/bytecode/MethodInfo;Ljavassist/CtClass;)V
        //   144: areturn
        //   145: aload 4
        //   147: iconst_1
        //   148: aload_1
        //   149: invokevirtual 191	javassist/CtField:getType	()Ljavassist/CtClass;
        //   152: invokevirtual 149	javassist/bytecode/Bytecode:addLoad	(ILjavassist/CtClass;)I
        //   155: pop
        //   156: aload 4
        //   158: getstatic 185	javassist/bytecode/Bytecode:THIS	Ljavassist/CtClass;
        //   161: aload 5
        //   163: aload_3
        //   164: invokevirtual 242	javassist/bytecode/Bytecode:addPutstatic	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   167: goto -50 -> 117
        //   170: astore_0
        //   171: new 39	javassist/CannotCompileException
        //   174: dup
        //   175: aload_0
        //   176: invokespecial 42	javassist/CannotCompileException:<init>	(Ljavassist/NotFoundException;)V
        //   179: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	180	0	paramString	String
        //   0	180	1	paramCtField	CtField
        //   4	76	2	localFieldInfo	javassist.bytecode.FieldInfo
        //   9	155	3	str1	String
        //   40	117	4	localObject	Object
        //   34	128	5	str2	String
        // Exception table:
        //   from	to	target	type
        //   73	117	170	javassist/NotFoundException
        //   117	123	170	javassist/NotFoundException
        //   145	167	170	javassist/NotFoundException
    }

    public static CtMethod wrapped(CtClass paramCtClass1, String paramString, CtClass[] paramArrayOfCtClass1, CtClass[] paramArrayOfCtClass2, CtMethod paramCtMethod, CtMethod.ConstParameter paramConstParameter, CtClass paramCtClass2) {
        return CtNewWrappedMethod.wrapped(paramCtClass1, paramString, paramArrayOfCtClass1, paramArrayOfCtClass2, paramCtMethod, paramConstParameter, paramCtClass2);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/CtNewMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */