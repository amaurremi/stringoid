package javassist.util.proxy;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.bytecode.ClassFile;

public class FactoryHelper {
    public static final int[] dataSize;
    private static Method defineClass1;
    private static Method defineClass2;
    public static final Class[] primitiveTypes;
    public static final String[] unwarpMethods;
    public static final String[] unwrapDesc;
    public static final String[] wrapperDesc;
    public static final String[] wrapperTypes;

    static {
        try {
            Class localClass = Class.forName("java.lang.ClassLoader");
            defineClass1 = SecurityActions.getDeclaredMethod(localClass, "defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE});
            defineClass2 = SecurityActions.getDeclaredMethod(localClass, "defineClass", new Class[]{String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class});
            primitiveTypes = new Class[]{Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            wrapperTypes = new String[]{"java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.lang.Void"};
            wrapperDesc = new String[]{"(Z)V", "(B)V", "(C)V", "(S)V", "(I)V", "(J)V", "(F)V", "(D)V"};
            unwarpMethods = new String[]{"booleanValue", "byteValue", "charValue", "shortValue", "intValue", "longValue", "floatValue", "doubleValue"};
            unwrapDesc = new String[]{"()Z", "()B", "()C", "()S", "()I", "()J", "()F", "()D"};
            dataSize = new int[]{1, 1, 1, 1, 1, 2, 1, 2};
            return;
        } catch (Exception localException) {
            throw new RuntimeException("cannot initialize");
        }
    }

    private static byte[] toBytecode(ClassFile paramClassFile) {
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream localDataOutputStream = new DataOutputStream(localByteArrayOutputStream);
        try {
            paramClassFile.write(localDataOutputStream);
            return localByteArrayOutputStream.toByteArray();
        } finally {
            localDataOutputStream.close();
        }
    }

    public static Class toClass(ClassFile paramClassFile, ClassLoader paramClassLoader) {
        return toClass(paramClassFile, paramClassLoader, null);
    }

    /* Error */
    public static Class toClass(ClassFile paramClassFile, ClassLoader paramClassLoader, ProtectionDomain paramProtectionDomain) {
        // Byte code:
        //   0: aload_0
        //   1: invokestatic 197	javassist/util/proxy/FactoryHelper:toBytecode	(Ljavassist/bytecode/ClassFile;)[B
        //   4: astore 5
        //   6: aload_2
        //   7: ifnonnull +57 -> 64
        //   10: getstatic 48	javassist/util/proxy/FactoryHelper:defineClass1	Ljava/lang/reflect/Method;
        //   13: astore_2
        //   14: iconst_4
        //   15: anewarray 4	java/lang/Object
        //   18: astore_3
        //   19: aload_3
        //   20: iconst_0
        //   21: aload_0
        //   22: invokevirtual 201	javassist/bytecode/ClassFile:getName	()Ljava/lang/String;
        //   25: aastore
        //   26: aload_3
        //   27: iconst_1
        //   28: aload 5
        //   30: aastore
        //   31: aload_3
        //   32: iconst_2
        //   33: new 36	java/lang/Integer
        //   36: dup
        //   37: iconst_0
        //   38: invokespecial 203	java/lang/Integer:<init>	(I)V
        //   41: aastore
        //   42: aload_3
        //   43: iconst_3
        //   44: new 36	java/lang/Integer
        //   47: dup
        //   48: aload 5
        //   50: arraylength
        //   51: invokespecial 203	java/lang/Integer:<init>	(I)V
        //   54: aastore
        //   55: aload_3
        //   56: astore_0
        //   57: aload_2
        //   58: aload_1
        //   59: aload_0
        //   60: invokestatic 207	javassist/util/proxy/FactoryHelper:toClass2	(Ljava/lang/reflect/Method;Ljava/lang/ClassLoader;[Ljava/lang/Object;)Ljava/lang/Class;
        //   63: areturn
        //   64: getstatic 52	javassist/util/proxy/FactoryHelper:defineClass2	Ljava/lang/reflect/Method;
        //   67: astore_3
        //   68: iconst_5
        //   69: anewarray 4	java/lang/Object
        //   72: astore 4
        //   74: aload 4
        //   76: iconst_0
        //   77: aload_0
        //   78: invokevirtual 201	javassist/bytecode/ClassFile:getName	()Ljava/lang/String;
        //   81: aastore
        //   82: aload 4
        //   84: iconst_1
        //   85: aload 5
        //   87: aastore
        //   88: aload 4
        //   90: iconst_2
        //   91: new 36	java/lang/Integer
        //   94: dup
        //   95: iconst_0
        //   96: invokespecial 203	java/lang/Integer:<init>	(I)V
        //   99: aastore
        //   100: aload 4
        //   102: iconst_3
        //   103: new 36	java/lang/Integer
        //   106: dup
        //   107: aload 5
        //   109: arraylength
        //   110: invokespecial 203	java/lang/Integer:<init>	(I)V
        //   113: aastore
        //   114: aload 4
        //   116: iconst_4
        //   117: aload_2
        //   118: aastore
        //   119: aload 4
        //   121: astore_0
        //   122: aload_3
        //   123: astore_2
        //   124: goto -67 -> 57
        //   127: astore_0
        //   128: aload_0
        //   129: athrow
        //   130: astore_0
        //   131: new 209	javassist/CannotCompileException
        //   134: dup
        //   135: aload_0
        //   136: invokevirtual 213	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
        //   139: invokespecial 216	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   142: athrow
        //   143: astore_0
        //   144: new 209	javassist/CannotCompileException
        //   147: dup
        //   148: aload_0
        //   149: invokespecial 216	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   152: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	153	0	paramClassFile	ClassFile
        //   0	153	1	paramClassLoader	ClassLoader
        //   0	153	2	paramProtectionDomain	ProtectionDomain
        //   18	105	3	localObject	Object
        //   72	48	4	arrayOfObject	Object[]
        //   4	104	5	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   0	6	127	java/lang/RuntimeException
        //   10	26	127	java/lang/RuntimeException
        //   31	55	127	java/lang/RuntimeException
        //   57	64	127	java/lang/RuntimeException
        //   64	82	127	java/lang/RuntimeException
        //   88	114	127	java/lang/RuntimeException
        //   0	6	130	java/lang/reflect/InvocationTargetException
        //   10	26	130	java/lang/reflect/InvocationTargetException
        //   31	55	130	java/lang/reflect/InvocationTargetException
        //   57	64	130	java/lang/reflect/InvocationTargetException
        //   64	82	130	java/lang/reflect/InvocationTargetException
        //   88	114	130	java/lang/reflect/InvocationTargetException
        //   0	6	143	java/lang/Exception
        //   10	26	143	java/lang/Exception
        //   31	55	143	java/lang/Exception
        //   57	64	143	java/lang/Exception
        //   64	82	143	java/lang/Exception
        //   88	114	143	java/lang/Exception
    }

    private static Class toClass2(Method paramMethod, ClassLoader paramClassLoader, Object[] paramArrayOfObject) {
        try {
            SecurityActions.setAccessible(paramMethod, true);
            paramClassLoader = (Class) paramMethod.invoke(paramClassLoader, paramArrayOfObject);
            SecurityActions.setAccessible(paramMethod, false);
            return paramClassLoader;
        } finally {
            paramMethod =finally;
            throw paramMethod;
        }
    }

    public static final int typeIndex(Class paramClass) {
        Class[] arrayOfClass = primitiveTypes;
        int j = arrayOfClass.length;
        int i = 0;
        while (i < j) {
            if (arrayOfClass[i] == paramClass) {
                return i;
            }
            i += 1;
        }
        throw new RuntimeException("bad type:" + paramClass.getName());
    }

    public static void writeFile(ClassFile paramClassFile, String paramString) {
        try {
            writeFile0(paramClassFile, paramString);
            return;
        } catch (IOException paramClassFile) {
            throw new CannotCompileException(paramClassFile);
        }
    }

    private static void writeFile0(ClassFile paramClassFile, String paramString) {
        String str = paramClassFile.getName();
        paramString = paramString + File.separatorChar + str.replace('.', File.separatorChar) + ".class";
        int i = paramString.lastIndexOf(File.separatorChar);
        if (i > 0) {
            str = paramString.substring(0, i);
            if (!str.equals(".")) {
                new File(str).mkdirs();
            }
        }
        paramString = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
        try {
            paramClassFile.write(paramString);
            return;
        } catch (IOException paramClassFile) {
            throw paramClassFile;
        } finally {
            paramString.close();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/util/proxy/FactoryHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */