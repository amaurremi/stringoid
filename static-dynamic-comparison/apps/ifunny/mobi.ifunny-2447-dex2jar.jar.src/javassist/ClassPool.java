package javassist;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;

import javassist.bytecode.Descriptor;

public class ClassPool {
    private static final int COMPRESS_THRESHOLD = 100;
    private static final int INIT_HASH_SIZE = 191;
    private static ClassPool defaultPool;
    private static Method defineClass1;
    private static Method defineClass2;
    private static Method definePackage;
    public static boolean doPruning;
    public static boolean releaseUnmodifiedClassFile;
    private Hashtable cflow = null;
    public boolean childFirstLookup = false;
    protected Hashtable classes = new Hashtable(191);
    private int compressCount;
    private ArrayList importedPackages;
    protected ClassPool parent;
    protected ClassPoolTail source = new ClassPoolTail();

    static {
        try {
            AccessController.doPrivileged(new ClassPool .1 ());
            doPruning = false;
            releaseUnmodifiedClassFile = true;
            defaultPool = null;
            return;
        } catch (PrivilegedActionException localPrivilegedActionException) {
            throw new RuntimeException("cannot initialize ClassPool", localPrivilegedActionException.getException());
        }
    }

    public ClassPool() {
        this(null);
    }

    public ClassPool(ClassPool paramClassPool) {
        this.parent = paramClassPool;
        if (paramClassPool == null) {
            paramClassPool = CtClass.primitiveTypes;
            int i = 0;
            while (i < paramClassPool.length) {
                this.classes.put(paramClassPool[i].getName(), paramClassPool[i]);
                i += 1;
            }
        }
        this.cflow = null;
        this.compressCount = 0;
        clearImportedPackages();
    }

    public ClassPool(boolean paramBoolean) {
        this(null);
        if (paramBoolean) {
            appendSystemPath();
        }
    }

    static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static ClassPool getDefault() {
        try {
            if (defaultPool == null) {
                defaultPool = new ClassPool(null);
                defaultPool.appendSystemPath();
            }
            ClassPool localClassPool = defaultPool;
            return localClassPool;
        } finally {
        }
    }

    /* Error */
    private static Object toClass2(Method paramMethod, ClassLoader paramClassLoader, Object[] paramArrayOfObject) {
        // Byte code:
        //   0: ldc 2
        //   2: monitorenter
        //   3: aload_0
        //   4: iconst_1
        //   5: invokevirtual 136	java/lang/reflect/Method:setAccessible	(Z)V
        //   8: aload_0
        //   9: aload_1
        //   10: aload_2
        //   11: invokevirtual 140	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //   14: astore_1
        //   15: aload_0
        //   16: iconst_0
        //   17: invokevirtual 136	java/lang/reflect/Method:setAccessible	(Z)V
        //   20: ldc 2
        //   22: monitorexit
        //   23: aload_1
        //   24: areturn
        //   25: astore_1
        //   26: aload_0
        //   27: iconst_0
        //   28: invokevirtual 136	java/lang/reflect/Method:setAccessible	(Z)V
        //   31: aload_1
        //   32: athrow
        //   33: astore_0
        //   34: ldc 2
        //   36: monitorexit
        //   37: aload_0
        //   38: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	39	0	paramMethod	Method
        //   0	39	1	paramClassLoader	ClassLoader
        //   0	39	2	paramArrayOfObject	Object[]
        // Exception table:
        //   from	to	target	type
        //   8	15	25	finally
        //   3	8	33	finally
        //   15	20	33	finally
        //   26	33	33	finally
    }

    public ClassPath appendClassPath(String paramString) {
        return this.source.appendClassPath(paramString);
    }

    public ClassPath appendClassPath(ClassPath paramClassPath) {
        return this.source.appendClassPath(paramClassPath);
    }

    public void appendPathList(String paramString) {
        int j = File.pathSeparatorChar;
        int k;
        for (int i = 0; ; i = k + 1) {
            k = paramString.indexOf(j, i);
            if (k < 0) {
                appendClassPath(paramString.substring(i));
                return;
            }
            appendClassPath(paramString.substring(i, k));
        }
    }

    public ClassPath appendSystemPath() {
        return this.source.appendSystemPath();
    }

    protected void cacheCtClass(String paramString, CtClass paramCtClass, boolean paramBoolean) {
        this.classes.put(paramString, paramCtClass);
    }

    CtClass checkNotExists(String paramString) {
        CtClass localCtClass2 = getCached(paramString);
        CtClass localCtClass1 = localCtClass2;
        if (localCtClass2 == null) {
            localCtClass1 = localCtClass2;
            if (!this.childFirstLookup) {
                localCtClass1 = localCtClass2;
                if (this.parent == null) {
                }
            }
        }
        try {
            localCtClass1 = this.parent.get0(paramString, true);
            return localCtClass1;
        } catch (NotFoundException paramString) {
        }
        return localCtClass2;
    }

    void checkNotFrozen(String paramString) {
        Object localObject = getCached(paramString);
        if ((localObject != null) || ((!this.childFirstLookup) && (this.parent != null))) {
        }
        try {
            CtClass localCtClass = this.parent.get0(paramString, true);
            localObject = localCtClass;
        } catch (NotFoundException localNotFoundException) {
            for (; ; ) {
            }
        }
        if (localObject != null) {
            throw new RuntimeException(paramString + " is in a parent ClassPool.  Use the parent.");
            if (((CtClass) localObject).isFrozen()) {
                throw new RuntimeException(paramString + ": frozen class (cannot edit)");
            }
        }
    }

    void classNameChanged(String paramString, CtClass paramCtClass) {
        try {
            if (getCached(paramString) == paramCtClass) {
                removeCached(paramString);
            }
            paramString = paramCtClass.getName();
            checkNotFrozen(paramString);
            cacheCtClass(paramString, paramCtClass, false);
            return;
        } finally {
        }
    }

    public void clearImportedPackages() {
        this.importedPackages = new ArrayList();
        this.importedPackages.add("java.lang");
    }

    void compress() {
        int i = this.compressCount;
        this.compressCount = (i + 1);
        if (i > 100) {
            this.compressCount = 0;
            Enumeration localEnumeration = this.classes.elements();
            while (localEnumeration.hasMoreElements()) {
                ((CtClass) localEnumeration.nextElement()).compress();
            }
        }
    }

    protected CtClass createCtClass(String paramString, boolean paramBoolean) {
        String str = paramString;
        if (paramString.charAt(0) == '[') {
            str = Descriptor.toClassName(paramString);
        }
        if (str.endsWith("[]")) {
            paramString = str.substring(0, str.indexOf('['));
            if (((paramBoolean) && (getCached(paramString) != null)) || (find(paramString) != null)) {
            }
        }
        while (find(str) == null) {
            return null;
            return new CtArray(str, this);
        }
        return new CtClassType(str, this);
    }

    public URL find(String paramString) {
        return this.source.find(paramString);
    }

    public CtClass get(String paramString) {
        if (paramString == null) {
        }
        for (CtClass localCtClass = null; localCtClass == null; localCtClass = get0(paramString, true)) {
            throw new NotFoundException(paramString);
        }
        localCtClass.incGetCounter();
        return localCtClass;
    }

    public CtClass[] get(String[] paramArrayOfString) {
        int i = 0;
        Object localObject;
        if (paramArrayOfString == null) {
            localObject = new CtClass[0];
            return (CtClass[]) localObject;
        }
        int j = paramArrayOfString.length;
        CtClass[] arrayOfCtClass = new CtClass[j];
        for (; ; ) {
            localObject = arrayOfCtClass;
            if (i >= j) {
                break;
            }
            arrayOfCtClass[i] = get(paramArrayOfString[i]);
            i += 1;
        }
    }

    protected CtClass get0(String paramString, boolean paramBoolean) {
        if (paramBoolean) {
        }
        for (; ; ) {
            Object localObject;
            CtClass localCtClass;
            try {
                localObject = getCached(paramString);
                if (localObject != null) {
                    return (CtClass) localObject;
                }
                if ((!this.childFirstLookup) && (this.parent != null)) {
                    localCtClass = this.parent.get0(paramString, paramBoolean);
                    localObject = localCtClass;
                    if (localCtClass != null) {
                        continue;
                    }
                }
                localCtClass = createCtClass(paramString, paramBoolean);
                if (localCtClass != null) {
                    localObject = localCtClass;
                    if (!paramBoolean) {
                        continue;
                    }
                    cacheCtClass(localCtClass.getName(), localCtClass, false);
                    localObject = localCtClass;
                    continue;
                }
                localObject = localCtClass;
            } finally {
            }
            if (this.childFirstLookup) {
                localObject = localCtClass;
                if (this.parent != null) {
                    localObject = this.parent.get0(paramString, paramBoolean);
                }
            }
        }
    }

    public CtClass getAndRename(String paramString1, String paramString2) {
        CtClass localCtClass = get0(paramString1, false);
        if (localCtClass == null) {
            throw new NotFoundException(paramString1);
        }
        if ((localCtClass instanceof CtClassType)) {
            ((CtClassType) localCtClass).setClassPool(this);
        }
        localCtClass.setName(paramString2);
        return localCtClass;
    }

    protected CtClass getCached(String paramString) {
        return (CtClass) this.classes.get(paramString);
    }

    public ClassLoader getClassLoader() {
        return getContextClassLoader();
    }

    public CtClass getCtClass(String paramString) {
        if (paramString.charAt(0) == '[') {
            return Descriptor.toCtClass(paramString, this);
        }
        return get(paramString);
    }

    public Iterator getImportedPackages() {
        return this.importedPackages.iterator();
    }

    public CtMethod getMethod(String paramString1, String paramString2) {
        return get(paramString1).getDeclaredMethod(paramString2);
    }

    public CtClass getOrNull(String paramString) {
        Object localObject = null;
        if (paramString == null) {
            paramString = (String) localObject;
        }
        for (; ; ) {
            if (paramString != null) {
                paramString.incGetCounter();
            }
            return paramString;
            try {
                paramString = get0(paramString, true);
            } catch (NotFoundException paramString) {
                paramString = (String) localObject;
            }
        }
    }

    public void importPackage(String paramString) {
        this.importedPackages.add(paramString);
    }

    public ClassPath insertClassPath(String paramString) {
        return this.source.insertClassPath(paramString);
    }

    public ClassPath insertClassPath(ClassPath paramClassPath) {
        return this.source.insertClassPath(paramClassPath);
    }

    public Object[] lookupCflow(String paramString) {
        if (this.cflow == null) {
            this.cflow = new Hashtable();
        }
        return (Object[]) this.cflow.get(paramString);
    }

    public CtClass makeClass(InputStream paramInputStream) {
        return makeClass(paramInputStream, true);
    }

    public CtClass makeClass(InputStream paramInputStream, boolean paramBoolean) {
        compress();
        paramInputStream = new CtClassType(new BufferedInputStream(paramInputStream), this);
        paramInputStream.checkModify();
        String str = paramInputStream.getName();
        if (paramBoolean) {
            checkNotFrozen(str);
        }
        cacheCtClass(str, paramInputStream, true);
        return paramInputStream;
    }

    public CtClass makeClass(String paramString) {
        return makeClass(paramString, null);
    }

    public CtClass makeClass(String paramString, CtClass paramCtClass) {
        try {
            checkNotFrozen(paramString);
            paramCtClass = new CtNewClass(paramString, this, false, paramCtClass);
            cacheCtClass(paramString, paramCtClass, true);
            return paramCtClass;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public CtClass makeClassIfNew(InputStream paramInputStream) {
        compress();
        paramInputStream = new CtClassType(new BufferedInputStream(paramInputStream), this);
        paramInputStream.checkModify();
        String str = paramInputStream.getName();
        CtClass localCtClass = checkNotExists(str);
        if (localCtClass != null) {
            return localCtClass;
        }
        cacheCtClass(str, paramInputStream, true);
        return paramInputStream;
    }

    public CtClass makeInterface(String paramString) {
        return makeInterface(paramString, null);
    }

    public CtClass makeInterface(String paramString, CtClass paramCtClass) {
        try {
            checkNotFrozen(paramString);
            paramCtClass = new CtNewClass(paramString, this, true, paramCtClass);
            cacheCtClass(paramString, paramCtClass, true);
            return paramCtClass;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    CtClass makeNestedClass(String paramString) {
        try {
            checkNotFrozen(paramString);
            CtNewNestedClass localCtNewNestedClass = new CtNewNestedClass(paramString, this, false, null);
            cacheCtClass(paramString, localCtNewNestedClass, true);
            return localCtNewNestedClass;
        } finally {
            paramString =finally;
            throw paramString;
        }
    }

    public void makePackage(ClassLoader paramClassLoader, String paramString) {
        try {
            toClass2(definePackage, paramClassLoader, new Object[]{paramString, null, null, null, null, null, null, null});
            return;
        } catch (InvocationTargetException paramClassLoader) {
            paramString = paramClassLoader.getTargetException();
            if (paramString == null) {
            }
            for (; ; ) {
                throw new CannotCompileException(paramClassLoader);
                if ((paramString instanceof IllegalArgumentException)) {
                    break;
                }
                paramClassLoader = paramString;
            }
        } catch (Exception paramClassLoader) {
            for (; ; ) {
            }
        }
    }

    InputStream openClassfile(String paramString) {
        return this.source.openClassfile(paramString);
    }

    void recordCflow(String paramString1, String paramString2, String paramString3) {
        if (this.cflow == null) {
            this.cflow = new Hashtable();
        }
        this.cflow.put(paramString1, new Object[]{paramString2, paramString3});
    }

    public void recordInvalidClassName(String paramString) {
    }

    protected CtClass removeCached(String paramString) {
        return (CtClass) this.classes.remove(paramString);
    }

    public void removeClassPath(ClassPath paramClassPath) {
        this.source.removeClassPath(paramClassPath);
    }

    public Class toClass(CtClass paramCtClass) {
        return toClass(paramCtClass, getClassLoader());
    }

    public Class toClass(CtClass paramCtClass, ClassLoader paramClassLoader) {
        return toClass(paramCtClass, paramClassLoader, null);
    }

    /* Error */
    public Class toClass(CtClass paramCtClass, ClassLoader paramClassLoader, java.security.ProtectionDomain paramProtectionDomain) {
        // Byte code:
        //   0: aload_1
        //   1: invokevirtual 406	javassist/CtClass:toBytecode	()[B
        //   4: astore 6
        //   6: aload_3
        //   7: ifnonnull +66 -> 73
        //   10: getstatic 111	javassist/ClassPool:defineClass1	Ljava/lang/reflect/Method;
        //   13: astore_3
        //   14: iconst_4
        //   15: anewarray 4	java/lang/Object
        //   18: astore 4
        //   20: aload 4
        //   22: iconst_0
        //   23: aload_1
        //   24: invokevirtual 93	javassist/CtClass:getName	()Ljava/lang/String;
        //   27: aastore
        //   28: aload 4
        //   30: iconst_1
        //   31: aload 6
        //   33: aastore
        //   34: aload 4
        //   36: iconst_2
        //   37: new 408	java/lang/Integer
        //   40: dup
        //   41: iconst_0
        //   42: invokespecial 409	java/lang/Integer:<init>	(I)V
        //   45: aastore
        //   46: aload 4
        //   48: iconst_3
        //   49: new 408	java/lang/Integer
        //   52: dup
        //   53: aload 6
        //   55: arraylength
        //   56: invokespecial 409	java/lang/Integer:<init>	(I)V
        //   59: aastore
        //   60: aload 4
        //   62: astore_1
        //   63: aload_3
        //   64: aload_2
        //   65: aload_1
        //   66: invokestatic 367	javassist/ClassPool:toClass2	(Ljava/lang/reflect/Method;Ljava/lang/ClassLoader;[Ljava/lang/Object;)Ljava/lang/Object;
        //   69: checkcast 411	java/lang/Class
        //   72: areturn
        //   73: getstatic 114	javassist/ClassPool:defineClass2	Ljava/lang/reflect/Method;
        //   76: astore 4
        //   78: iconst_5
        //   79: anewarray 4	java/lang/Object
        //   82: astore 5
        //   84: aload 5
        //   86: iconst_0
        //   87: aload_1
        //   88: invokevirtual 93	javassist/CtClass:getName	()Ljava/lang/String;
        //   91: aastore
        //   92: aload 5
        //   94: iconst_1
        //   95: aload 6
        //   97: aastore
        //   98: aload 5
        //   100: iconst_2
        //   101: new 408	java/lang/Integer
        //   104: dup
        //   105: iconst_0
        //   106: invokespecial 409	java/lang/Integer:<init>	(I)V
        //   109: aastore
        //   110: aload 5
        //   112: iconst_3
        //   113: new 408	java/lang/Integer
        //   116: dup
        //   117: aload 6
        //   119: arraylength
        //   120: invokespecial 409	java/lang/Integer:<init>	(I)V
        //   123: aastore
        //   124: aload 5
        //   126: iconst_4
        //   127: aload_3
        //   128: aastore
        //   129: aload 5
        //   131: astore_1
        //   132: aload 4
        //   134: astore_3
        //   135: goto -72 -> 63
        //   138: astore_1
        //   139: aload_1
        //   140: athrow
        //   141: astore_1
        //   142: new 373	javassist/CannotCompileException
        //   145: dup
        //   146: aload_1
        //   147: invokevirtual 371	java/lang/reflect/InvocationTargetException:getTargetException	()Ljava/lang/Throwable;
        //   150: invokespecial 376	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   153: athrow
        //   154: astore_1
        //   155: new 373	javassist/CannotCompileException
        //   158: dup
        //   159: aload_1
        //   160: invokespecial 376	javassist/CannotCompileException:<init>	(Ljava/lang/Throwable;)V
        //   163: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	164	0	this	ClassPool
        //   0	164	1	paramCtClass	CtClass
        //   0	164	2	paramClassLoader	ClassLoader
        //   0	164	3	paramProtectionDomain	java.security.ProtectionDomain
        //   18	115	4	localObject	Object
        //   82	48	5	arrayOfObject	Object[]
        //   4	114	6	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   0	6	138	java/lang/RuntimeException
        //   10	28	138	java/lang/RuntimeException
        //   34	60	138	java/lang/RuntimeException
        //   63	73	138	java/lang/RuntimeException
        //   73	92	138	java/lang/RuntimeException
        //   98	124	138	java/lang/RuntimeException
        //   0	6	141	java/lang/reflect/InvocationTargetException
        //   10	28	141	java/lang/reflect/InvocationTargetException
        //   34	60	141	java/lang/reflect/InvocationTargetException
        //   63	73	141	java/lang/reflect/InvocationTargetException
        //   73	92	141	java/lang/reflect/InvocationTargetException
        //   98	124	141	java/lang/reflect/InvocationTargetException
        //   0	6	154	java/lang/Exception
        //   10	28	154	java/lang/Exception
        //   34	60	154	java/lang/Exception
        //   63	73	154	java/lang/Exception
        //   73	92	154	java/lang/Exception
        //   98	124	154	java/lang/Exception
    }

    public String toString() {
        return this.source.toString();
    }

    void writeClassfile(String paramString, OutputStream paramOutputStream) {
        this.source.writeClassfile(paramString, paramOutputStream);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/ClassPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */