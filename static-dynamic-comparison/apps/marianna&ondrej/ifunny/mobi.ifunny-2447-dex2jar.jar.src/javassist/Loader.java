package javassist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;
import java.util.Hashtable;
import java.util.Vector;

public class Loader
        extends ClassLoader {
    public boolean doDelegation = true;
    private ProtectionDomain domain;
    private Hashtable notDefinedHere;
    private Vector notDefinedPackages;
    private ClassPool source;
    private Translator translator;

    public Loader() {
        this(null);
    }

    public Loader(ClassLoader paramClassLoader, ClassPool paramClassPool) {
        super(paramClassLoader);
        init(paramClassPool);
    }

    public Loader(ClassPool paramClassPool) {
        init(paramClassPool);
    }

    private void init(ClassPool paramClassPool) {
        this.notDefinedHere = new Hashtable();
        this.notDefinedPackages = new Vector();
        this.source = paramClassPool;
        this.translator = null;
        this.domain = null;
        delegateLoadingOf("javassist.Loader");
    }

    public static void main(String[] paramArrayOfString) {
        new Loader().run(paramArrayOfString);
    }

    private boolean notDelegated(String paramString) {
        if (this.notDefinedHere.get(paramString) != null) {
            return true;
        }
        int j = this.notDefinedPackages.size();
        int i = 0;
        while (i < j) {
            if (paramString.startsWith((String) this.notDefinedPackages.elementAt(i))) {
                return true;
            }
            i += 1;
        }
        return false;
    }

    public void addTranslator(ClassPool paramClassPool, Translator paramTranslator) {
        this.source = paramClassPool;
        this.translator = paramTranslator;
        paramTranslator.start(paramClassPool);
    }

    public void delegateLoadingOf(String paramString) {
        if (paramString.endsWith(".")) {
            this.notDefinedPackages.addElement(paramString);
            return;
        }
        this.notDefinedHere.put(paramString, this);
    }

    protected Class delegateToParent(String paramString) {
        ClassLoader localClassLoader = getParent();
        if (localClassLoader != null) {
            return localClassLoader.loadClass(paramString);
        }
        return findSystemClass(paramString);
    }

    /* Error */
    protected Class findClass(String paramString) {
        // Byte code:
        //   0: aconst_null
        //   1: astore_3
        //   2: aload_0
        //   3: getfield 45	javassist/Loader:source	Ljavassist/ClassPool;
        //   6: ifnull +98 -> 104
        //   9: aload_0
        //   10: getfield 47	javassist/Loader:translator	Ljavassist/Translator;
        //   13: ifnull +17 -> 30
        //   16: aload_0
        //   17: getfield 47	javassist/Loader:translator	Ljavassist/Translator;
        //   20: aload_0
        //   21: getfield 45	javassist/Loader:source	Ljavassist/ClassPool;
        //   24: aload_1
        //   25: invokeinterface 123 3 0
        //   30: aload_0
        //   31: getfield 45	javassist/Loader:source	Ljavassist/ClassPool;
        //   34: aload_1
        //   35: invokevirtual 128	javassist/ClassPool:get	(Ljava/lang/String;)Ljavassist/CtClass;
        //   38: invokevirtual 134	javassist/CtClass:toBytecode	()[B
        //   41: astore_3
        //   42: aload_1
        //   43: bipush 46
        //   45: invokevirtual 138	java/lang/String:lastIndexOf	(I)I
        //   48: istore_2
        //   49: iload_2
        //   50: iconst_m1
        //   51: if_icmpeq +34 -> 85
        //   54: aload_1
        //   55: iconst_0
        //   56: iload_2
        //   57: invokevirtual 142	java/lang/String:substring	(II)Ljava/lang/String;
        //   60: astore 4
        //   62: aload_0
        //   63: aload 4
        //   65: invokevirtual 146	javassist/Loader:getPackage	(Ljava/lang/String;)Ljava/lang/Package;
        //   68: ifnonnull +17 -> 85
        //   71: aload_0
        //   72: aload 4
        //   74: aconst_null
        //   75: aconst_null
        //   76: aconst_null
        //   77: aconst_null
        //   78: aconst_null
        //   79: aconst_null
        //   80: aconst_null
        //   81: invokevirtual 150	javassist/Loader:definePackage	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/net/URL;)Ljava/lang/Package;
        //   84: pop
        //   85: aload_0
        //   86: getfield 49	javassist/Loader:domain	Ljava/security/ProtectionDomain;
        //   89: ifnonnull +102 -> 191
        //   92: aload_0
        //   93: aload_1
        //   94: aload_3
        //   95: iconst_0
        //   96: aload_3
        //   97: arraylength
        //   98: invokevirtual 154	javassist/Loader:defineClass	(Ljava/lang/String;[BII)Ljava/lang/Class;
        //   101: astore_3
        //   102: aload_3
        //   103: areturn
        //   104: new 156	java/lang/StringBuilder
        //   107: dup
        //   108: invokespecial 157	java/lang/StringBuilder:<init>	()V
        //   111: ldc -97
        //   113: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   116: aload_1
        //   117: bipush 46
        //   119: bipush 47
        //   121: invokevirtual 167	java/lang/String:replace	(CC)Ljava/lang/String;
        //   124: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   127: ldc -87
        //   129: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   135: astore 4
        //   137: aload_0
        //   138: invokevirtual 179	java/lang/Object:getClass	()Ljava/lang/Class;
        //   141: aload 4
        //   143: invokevirtual 185	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
        //   146: astore 4
        //   148: aload 4
        //   150: ifnull -48 -> 102
        //   153: aload 4
        //   155: invokestatic 191	javassist/ClassPoolTail:readStream	(Ljava/io/InputStream;)[B
        //   158: astore_3
        //   159: goto -117 -> 42
        //   162: astore_3
        //   163: new 193	java/lang/ClassNotFoundException
        //   166: dup
        //   167: new 156	java/lang/StringBuilder
        //   170: dup
        //   171: invokespecial 157	java/lang/StringBuilder:<init>	()V
        //   174: ldc -61
        //   176: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: aload_1
        //   180: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   186: aload_3
        //   187: invokespecial 198	java/lang/ClassNotFoundException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   190: athrow
        //   191: aload_0
        //   192: aload_1
        //   193: aload_3
        //   194: iconst_0
        //   195: aload_3
        //   196: arraylength
        //   197: aload_0
        //   198: getfield 49	javassist/Loader:domain	Ljava/security/ProtectionDomain;
        //   201: invokevirtual 201	javassist/Loader:defineClass	(Ljava/lang/String;[BIILjava/security/ProtectionDomain;)Ljava/lang/Class;
        //   204: areturn
        //   205: astore 4
        //   207: goto -122 -> 85
        //   210: astore_1
        //   211: aconst_null
        //   212: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	213	0	this	Loader
        //   0	213	1	paramString	String
        //   48	9	2	i	int
        //   1	158	3	localObject1	Object
        //   162	34	3	localException	Exception
        //   60	94	4	localObject2	Object
        //   205	1	4	localIllegalArgumentException	IllegalArgumentException
        // Exception table:
        //   from	to	target	type
        //   2	30	162	java/lang/Exception
        //   30	42	162	java/lang/Exception
        //   104	148	162	java/lang/Exception
        //   153	159	162	java/lang/Exception
        //   71	85	205	java/lang/IllegalArgumentException
        //   30	42	210	javassist/NotFoundException
    }

    protected Class loadClass(String paramString, boolean paramBoolean) {
        synchronized (paramString.intern()) {
            Object localObject = findLoadedClass( ???);
            paramString = (String) localObject;
            if (localObject == null) {
                paramString = loadClassByDelegation( ???);
            }
            localObject = paramString;
            if (paramString == null) {
                localObject = findClass( ???);
            }
            paramString = (String) localObject;
            if (localObject == null) {
                paramString = delegateToParent( ???);
            }
            if (paramBoolean) {
                resolveClass(paramString);
            }
            return paramString;
        }
    }

    protected Class loadClassByDelegation(String paramString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (this.doDelegation) {
            if ((!paramString.startsWith("java.")) && (!paramString.startsWith("javax.")) && (!paramString.startsWith("sun.")) && (!paramString.startsWith("com.sun.")) && (!paramString.startsWith("org.w3c.")) && (!paramString.startsWith("org.xml."))) {
                localObject1 = localObject2;
                if (!notDelegated(paramString)) {
                }
            } else {
                localObject1 = delegateToParent(paramString);
            }
        }
        return (Class) localObject1;
    }

    public void run(String paramString, String[] paramArrayOfString) {
        paramString = loadClass(paramString);
        try {
            paramString.getDeclaredMethod("main", new Class[]{String[].class}).invoke(null, new Object[]{paramArrayOfString});
            return;
        } catch (InvocationTargetException paramString) {
            throw paramString.getTargetException();
        }
    }

    public void run(String[] paramArrayOfString) {
        int j = paramArrayOfString.length - 1;
        if (j >= 0) {
            String[] arrayOfString = new String[j];
            int i = 0;
            while (i < j) {
                arrayOfString[i] = paramArrayOfString[(i + 1)];
                i += 1;
            }
            run(paramArrayOfString[0], arrayOfString);
        }
    }

    public void setClassPool(ClassPool paramClassPool) {
        this.source = paramClassPool;
    }

    public void setDomain(ProtectionDomain paramProtectionDomain) {
        this.domain = paramProtectionDomain;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */