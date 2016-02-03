package javassist.compiler;

import java.util.HashMap;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Bytecode;
import javassist.bytecode.ClassFile;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import javassist.bytecode.ExceptionsAttribute;
import javassist.bytecode.FieldInfo;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.SyntheticAttribute;

public class AccessorMaker {
    static final String lastParamType = "javassist.runtime.Inner";
    private HashMap accessors;
    private CtClass clazz;
    private int uniqueNumber;

    public AccessorMaker(CtClass paramCtClass) {
        this.clazz = paramCtClass;
        this.uniqueNumber = 1;
        this.accessors = new HashMap();
    }

    private String findAccessorName(ClassFile paramClassFile) {
        Object localObject;
        do {
            localObject = new StringBuilder().append("access$");
            int i = this.uniqueNumber;
            this.uniqueNumber = (i + 1);
            localObject = i;
        } while (paramClassFile.getMethod((String) localObject) != null);
        return (String) localObject;
    }

    public String getConstructor(CtClass paramCtClass, String paramString, MethodInfo paramMethodInfo) {
        int i = 0;
        paramCtClass = "<init>:" + paramString;
        String str = (String) this.accessors.get(paramCtClass);
        if (str != null) {
            return str;
        }
        str = Descriptor.appendParameter("javassist.runtime.Inner", paramString);
        ClassFile localClassFile = this.clazz.getClassFile();
        try {
            Object localObject = localClassFile.getConstPool();
            ClassPool localClassPool = this.clazz.getClassPool();
            MethodInfo localMethodInfo = new MethodInfo((ConstPool) localObject, "<init>", str);
            localMethodInfo.setAccessFlags(0);
            localMethodInfo.addAttribute(new SyntheticAttribute((ConstPool) localObject));
            paramMethodInfo = paramMethodInfo.getExceptionsAttribute();
            if (paramMethodInfo != null) {
                localMethodInfo.addAttribute(paramMethodInfo.copy((ConstPool) localObject, null));
            }
            paramMethodInfo = Descriptor.getParameterTypes(paramString, localClassPool);
            localObject = new Bytecode((ConstPool) localObject);
            ((Bytecode) localObject).addAload(0);
            int j = 1;
            while (i < paramMethodInfo.length) {
                j += ((Bytecode) localObject).addLoad(j, paramMethodInfo[i]);
                i += 1;
            }
            ((Bytecode) localObject).setMaxLocals(j + 1);
            ((Bytecode) localObject).addInvokespecial(this.clazz, "<init>", paramString);
            ((Bytecode) localObject).addReturn(null);
            localMethodInfo.setCodeAttribute(((Bytecode) localObject).toCodeAttribute());
            localClassFile.addMethod(localMethodInfo);
            this.accessors.put(paramCtClass, str);
            return str;
        } catch (CannotCompileException paramCtClass) {
            throw new CompileError(paramCtClass);
        } catch (NotFoundException paramCtClass) {
            throw new CompileError(paramCtClass);
        }
    }

    public MethodInfo getFieldGetter(FieldInfo paramFieldInfo, boolean paramBoolean) {
        str1 = paramFieldInfo.getName();
        String str2 = str1 + ":getter";
        Object localObject1 = this.accessors.get(str2);
        if (localObject1 != null) {
            return (MethodInfo) localObject1;
        }
        localObject1 = this.clazz.getClassFile();
        String str4 = findAccessorName((ClassFile) localObject1);
        try {
            localObject2 = ((ClassFile) localObject1).getConstPool();
            localClassPool = this.clazz.getClassPool();
            str3 = paramFieldInfo.getDescriptor();
            if (!paramBoolean) {
                break label220;
            }
            paramFieldInfo = "()" + str3;
        } catch (CannotCompileException paramFieldInfo) {
            for (; ; ) {
                Object localObject2;
                ClassPool localClassPool;
                String str3;
                throw new CompileError(paramFieldInfo);
                paramFieldInfo = "(" + Descriptor.of(this.clazz) + ")" + str3;
                continue;
                ((Bytecode) localObject2).addAload(0);
                ((Bytecode) localObject2).addGetfield(Bytecode.THIS, str1, str3);
                ((Bytecode) localObject2).setMaxLocals(1);
            }
        } catch (NotFoundException paramFieldInfo) {
            throw new CompileError(paramFieldInfo);
        }
        paramFieldInfo = new MethodInfo((ConstPool) localObject2, str4, paramFieldInfo);
        paramFieldInfo.setAccessFlags(8);
        paramFieldInfo.addAttribute(new SyntheticAttribute((ConstPool) localObject2));
        localObject2 = new Bytecode((ConstPool) localObject2);
        if (paramBoolean) {
            ((Bytecode) localObject2).addGetstatic(Bytecode.THIS, str1, str3);
            ((Bytecode) localObject2).addReturn(Descriptor.toCtClass(str3, localClassPool));
            paramFieldInfo.setCodeAttribute(((Bytecode) localObject2).toCodeAttribute());
            ((ClassFile) localObject1).addMethod(paramFieldInfo);
            this.accessors.put(str2, paramFieldInfo);
            return paramFieldInfo;
        }
    }

    public MethodInfo getFieldSetter(FieldInfo paramFieldInfo, boolean paramBoolean) {
        str1 = paramFieldInfo.getName();
        String str2 = str1 + ":setter";
        Object localObject1 = this.accessors.get(str2);
        if (localObject1 != null) {
            return (MethodInfo) localObject1;
        }
        localObject1 = this.clazz.getClassFile();
        String str4 = findAccessorName((ClassFile) localObject1);
        try {
            localObject2 = ((ClassFile) localObject1).getConstPool();
            localClassPool = this.clazz.getClassPool();
            str3 = paramFieldInfo.getDescriptor();
            if (!paramBoolean) {
                break label242;
            }
            paramFieldInfo = "(" + str3 + ")V";
        } catch (CannotCompileException paramFieldInfo) {
            for (; ; ) {
                Object localObject2;
                ClassPool localClassPool;
                String str3;
                throw new CompileError(paramFieldInfo);
                paramFieldInfo = "(" + Descriptor.of(this.clazz) + str3 + ")V";
                continue;
                ((Bytecode) localObject2).addAload(0);
                int i = ((Bytecode) localObject2).addLoad(1, Descriptor.toCtClass(str3, localClassPool)) + 1;
                ((Bytecode) localObject2).addPutfield(Bytecode.THIS, str1, str3);
            }
        } catch (NotFoundException paramFieldInfo) {
            throw new CompileError(paramFieldInfo);
        }
        paramFieldInfo = new MethodInfo((ConstPool) localObject2, str4, paramFieldInfo);
        paramFieldInfo.setAccessFlags(8);
        paramFieldInfo.addAttribute(new SyntheticAttribute((ConstPool) localObject2));
        localObject2 = new Bytecode((ConstPool) localObject2);
        if (paramBoolean) {
            i = ((Bytecode) localObject2).addLoad(0, Descriptor.toCtClass(str3, localClassPool));
            ((Bytecode) localObject2).addPutstatic(Bytecode.THIS, str1, str3);
            ((Bytecode) localObject2).addReturn(null);
            ((Bytecode) localObject2).setMaxLocals(i);
            paramFieldInfo.setCodeAttribute(((Bytecode) localObject2).toCodeAttribute());
            ((ClassFile) localObject1).addMethod(paramFieldInfo);
            this.accessors.put(str2, paramFieldInfo);
            return paramFieldInfo;
        }
    }

    /* Error */
    public String getMethodAccessor(String paramString1, String paramString2, String paramString3, MethodInfo paramMethodInfo) {
        // Byte code:
        //   0: iconst_0
        //   1: istore 5
        //   3: new 33	java/lang/StringBuilder
        //   6: dup
        //   7: invokespecial 34	java/lang/StringBuilder:<init>	()V
        //   10: aload_1
        //   11: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   14: ldc -40
        //   16: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   19: aload_2
        //   20: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   26: astore 7
        //   28: aload_0
        //   29: getfield 28	javassist/compiler/AccessorMaker:accessors	Ljava/util/HashMap;
        //   32: aload 7
        //   34: invokevirtual 65	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
        //   37: checkcast 67	java/lang/String
        //   40: astore 8
        //   42: aload 8
        //   44: ifnull +6 -> 50
        //   47: aload 8
        //   49: areturn
        //   50: aload_0
        //   51: getfield 21	javassist/compiler/AccessorMaker:clazz	Ljavassist/CtClass;
        //   54: invokevirtual 79	javassist/CtClass:getClassFile	()Ljavassist/bytecode/ClassFile;
        //   57: astore 8
        //   59: aload_0
        //   60: aload 8
        //   62: invokespecial 175	javassist/compiler/AccessorMaker:findAccessorName	(Ljavassist/bytecode/ClassFile;)Ljava/lang/String;
        //   65: astore 9
        //   67: aload 8
        //   69: invokevirtual 83	javassist/bytecode/ClassFile:getConstPool	()Ljavassist/bytecode/ConstPool;
        //   72: astore 12
        //   74: aload_0
        //   75: getfield 21	javassist/compiler/AccessorMaker:clazz	Ljavassist/CtClass;
        //   78: invokevirtual 87	javassist/CtClass:getClassPool	()Ljavassist/ClassPool;
        //   81: astore 10
        //   83: new 89	javassist/bytecode/MethodInfo
        //   86: dup
        //   87: aload 12
        //   89: aload 9
        //   91: aload_3
        //   92: invokespecial 93	javassist/bytecode/MethodInfo:<init>	(Ljavassist/bytecode/ConstPool;Ljava/lang/String;Ljava/lang/String;)V
        //   95: astore 11
        //   97: aload 11
        //   99: bipush 8
        //   101: invokevirtual 97	javassist/bytecode/MethodInfo:setAccessFlags	(I)V
        //   104: aload 11
        //   106: new 99	javassist/bytecode/SyntheticAttribute
        //   109: dup
        //   110: aload 12
        //   112: invokespecial 102	javassist/bytecode/SyntheticAttribute:<init>	(Ljavassist/bytecode/ConstPool;)V
        //   115: invokevirtual 106	javassist/bytecode/MethodInfo:addAttribute	(Ljavassist/bytecode/AttributeInfo;)V
        //   118: aload 4
        //   120: invokevirtual 110	javassist/bytecode/MethodInfo:getExceptionsAttribute	()Ljavassist/bytecode/ExceptionsAttribute;
        //   123: astore 4
        //   125: aload 4
        //   127: ifnull +16 -> 143
        //   130: aload 11
        //   132: aload 4
        //   134: aload 12
        //   136: aconst_null
        //   137: invokevirtual 116	javassist/bytecode/ExceptionsAttribute:copy	(Ljavassist/bytecode/ConstPool;Ljava/util/Map;)Ljavassist/bytecode/AttributeInfo;
        //   140: invokevirtual 106	javassist/bytecode/MethodInfo:addAttribute	(Ljavassist/bytecode/AttributeInfo;)V
        //   143: aload_3
        //   144: aload 10
        //   146: invokestatic 120	javassist/bytecode/Descriptor:getParameterTypes	(Ljava/lang/String;Ljavassist/ClassPool;)[Ljavassist/CtClass;
        //   149: astore 4
        //   151: new 122	javassist/bytecode/Bytecode
        //   154: dup
        //   155: aload 12
        //   157: invokespecial 123	javassist/bytecode/Bytecode:<init>	(Ljavassist/bytecode/ConstPool;)V
        //   160: astore 12
        //   162: iconst_0
        //   163: istore 6
        //   165: iload 5
        //   167: aload 4
        //   169: arraylength
        //   170: if_icmpge +29 -> 199
        //   173: iload 6
        //   175: aload 12
        //   177: iload 6
        //   179: aload 4
        //   181: iload 5
        //   183: aaload
        //   184: invokevirtual 130	javassist/bytecode/Bytecode:addLoad	(ILjavassist/CtClass;)I
        //   187: iadd
        //   188: istore 6
        //   190: iload 5
        //   192: iconst_1
        //   193: iadd
        //   194: istore 5
        //   196: goto -31 -> 165
        //   199: aload 12
        //   201: iload 6
        //   203: invokevirtual 133	javassist/bytecode/Bytecode:setMaxLocals	(I)V
        //   206: aload_2
        //   207: aload_3
        //   208: if_acmpne +57 -> 265
        //   211: aload 12
        //   213: aload_0
        //   214: getfield 21	javassist/compiler/AccessorMaker:clazz	Ljavassist/CtClass;
        //   217: aload_1
        //   218: aload_2
        //   219: invokevirtual 219	javassist/bytecode/Bytecode:addInvokestatic	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   222: aload 12
        //   224: aload_2
        //   225: aload 10
        //   227: invokestatic 222	javassist/bytecode/Descriptor:getReturnType	(Ljava/lang/String;Ljavassist/ClassPool;)Ljavassist/CtClass;
        //   230: invokevirtual 140	javassist/bytecode/Bytecode:addReturn	(Ljavassist/CtClass;)V
        //   233: aload 11
        //   235: aload 12
        //   237: invokevirtual 144	javassist/bytecode/Bytecode:toCodeAttribute	()Ljavassist/bytecode/CodeAttribute;
        //   240: invokevirtual 148	javassist/bytecode/MethodInfo:setCodeAttribute	(Ljavassist/bytecode/CodeAttribute;)V
        //   243: aload 8
        //   245: aload 11
        //   247: invokevirtual 152	javassist/bytecode/ClassFile:addMethod	(Ljavassist/bytecode/MethodInfo;)V
        //   250: aload_0
        //   251: getfield 28	javassist/compiler/AccessorMaker:accessors	Ljava/util/HashMap;
        //   254: aload 7
        //   256: aload 9
        //   258: invokevirtual 156	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   261: pop
        //   262: aload 9
        //   264: areturn
        //   265: aload 12
        //   267: aload_0
        //   268: getfield 21	javassist/compiler/AccessorMaker:clazz	Ljavassist/CtClass;
        //   271: aload_1
        //   272: aload_2
        //   273: invokevirtual 225	javassist/bytecode/Bytecode:addInvokevirtual	(Ljavassist/CtClass;Ljava/lang/String;Ljava/lang/String;)V
        //   276: goto -54 -> 222
        //   279: astore_1
        //   280: new 158	javassist/compiler/CompileError
        //   283: dup
        //   284: aload_1
        //   285: invokespecial 161	javassist/compiler/CompileError:<init>	(Ljavassist/CannotCompileException;)V
        //   288: athrow
        //   289: astore_1
        //   290: new 158	javassist/compiler/CompileError
        //   293: dup
        //   294: aload_1
        //   295: invokespecial 164	javassist/compiler/CompileError:<init>	(Ljavassist/NotFoundException;)V
        //   298: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	299	0	this	AccessorMaker
        //   0	299	1	paramString1	String
        //   0	299	2	paramString2	String
        //   0	299	3	paramString3	String
        //   0	299	4	paramMethodInfo	MethodInfo
        //   1	194	5	i	int
        //   163	39	6	j	int
        //   26	229	7	str1	String
        //   40	204	8	localObject1	Object
        //   65	198	9	str2	String
        //   81	145	10	localClassPool	ClassPool
        //   95	151	11	localMethodInfo	MethodInfo
        //   72	194	12	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   67	125	279	javassist/CannotCompileException
        //   130	143	279	javassist/CannotCompileException
        //   143	162	279	javassist/CannotCompileException
        //   165	190	279	javassist/CannotCompileException
        //   199	206	279	javassist/CannotCompileException
        //   211	222	279	javassist/CannotCompileException
        //   222	250	279	javassist/CannotCompileException
        //   265	276	279	javassist/CannotCompileException
        //   67	125	289	javassist/NotFoundException
        //   130	143	289	javassist/NotFoundException
        //   143	162	289	javassist/NotFoundException
        //   165	190	289	javassist/NotFoundException
        //   199	206	289	javassist/NotFoundException
        //   211	222	289	javassist/NotFoundException
        //   222	250	289	javassist/NotFoundException
        //   265	276	289	javassist/NotFoundException
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/AccessorMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */