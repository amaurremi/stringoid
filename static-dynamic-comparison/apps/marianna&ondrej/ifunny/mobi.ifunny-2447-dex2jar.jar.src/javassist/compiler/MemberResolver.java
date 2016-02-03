package javassist.compiler;

import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Symbol;

public class MemberResolver
        implements TokenId {
    private static final String INVALID = "<invalid>";
    private static final int NO = -1;
    private static final int YES = 0;
    private static WeakHashMap invalidNamesMap = new WeakHashMap();
    private ClassPool classPool;
    private Hashtable invalidNames = null;

    public MemberResolver(ClassPool paramClassPool) {
        this.classPool = paramClassPool;
    }

    private int compareSignature(String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        int j = 1;
        int i1 = paramArrayOfInt1.length;
        int i;
        if (i1 != Descriptor.numOfParameters(paramString)) {
            i = -1;
        }
        int n;
        char c;
        do {
            return i;
            int i2 = paramString.length();
            n = 0;
            i = 0;
            if (j >= i2) {
                break label457;
            }
            c = paramString.charAt(j);
            if (c != ')') {
                break;
            }
        } while (n == i1);
        return -1;
        if (n >= i1) {
            return -1;
        }
        j += 1;
        int k = 0;
        while (c == '[') {
            k += 1;
            c = paramString.charAt(j);
            j += 1;
        }
        int m;
        if (paramArrayOfInt1[n] == 412) {
            if ((k == 0) && (c != 'L')) {
                return -1;
            }
            m = i;
            k = j;
            if (c != 'L') {
                break label459;
            }
            j = paramString.indexOf(';', j);
            k = j + 1;
            j = i;
            i = k;
        }
        for (; ; ) {
            n += 1;
            k = i;
            i = j;
            j = k;
            break;
            if (paramArrayOfInt2[n] != k) {
                if ((k != 0) || (c != 'L') || (!paramString.startsWith("java/lang/Object;", j))) {
                    return -1;
                }
                j = paramString.indexOf(';', j) + 1;
                m = i + 1;
                k = j;
                if (j <= 0) {
                    return -1;
                }
            } else {
                if (c == 'L') {
                    k = paramString.indexOf(';', j);
                    if ((k < 0) || (paramArrayOfInt1[n] != 307)) {
                        return -1;
                    }
                    String str = paramString.substring(j, k);
                    j = i;
                    CtClass localCtClass;
                    if (!str.equals(paramArrayOfString[n])) {
                        localCtClass = lookupClassByJvmName(paramArrayOfString[n]);
                    }
                    try {
                        boolean bool = localCtClass.subtypeOf(lookupClassByJvmName(str));
                        if (!bool) {
                            break label365;
                        }
                        j = i + 1;
                    } catch (NotFoundException localNotFoundException) {
                        for (; ; ) {
                            j = i + 1;
                        }
                    }
                    i = k + 1;
                    continue;
                    label365:
                    return -1;
                }
                int i3 = descToType(c);
                int i4 = paramArrayOfInt1[n];
                m = i;
                k = j;
                if (i3 != i4) {
                    if ((i3 == 324) && ((i4 == 334) || (i4 == 303) || (i4 == 306))) {
                        k = i + 1;
                        i = j;
                        j = k;
                        continue;
                    }
                    return -1;
                    label457:
                    return -1;
                }
            }
            label459:
            j = m;
            i = k;
        }
    }

    public static int descToType(char paramChar) {
        switch (paramChar) {
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                fatal();
            case 'V':
                return 344;
            case 'Z':
                return 301;
            case 'C':
                return 306;
            case 'B':
                return 303;
            case 'S':
                return 334;
            case 'I':
                return 324;
            case 'J':
                return 326;
            case 'F':
                return 317;
            case 'D':
                return 312;
        }
        return 307;
    }

    private static void fatal() {
        throw new CompileError("fatal");
    }

    public static int getInvalidMapSize() {
        return invalidNamesMap.size();
    }

    private Hashtable getInvalidNames() {
        Hashtable localHashtable1 = this.invalidNames;
        if (localHashtable1 == null) {
            for (; ; ) {
                try {
                    Object localObject = (WeakReference) invalidNamesMap.get(this.classPool);
                    if (localObject != null) {
                        localHashtable1 = (Hashtable) ((WeakReference) localObject).get();
                        localObject = localHashtable1;
                        if (localHashtable1 == null) {
                            localObject = new Hashtable();
                            invalidNamesMap.put(this.classPool, new WeakReference(localObject));
                        }
                        this.invalidNames = ((Hashtable) localObject);
                        return (Hashtable) localObject;
                    }
                } finally {
                }
            }
        }
        return localHashtable2;
    }

    public static int getModifiers(ASTList paramASTList) {
        int i = 0;
        if (paramASTList != null) {
            Keyword localKeyword = (Keyword) paramASTList.head();
            paramASTList = paramASTList.tail();
            switch (localKeyword.get()) {
            }
            for (; ; ) {
                break;
                i |= 0x8;
                continue;
                i |= 0x10;
                continue;
                i |= 0x20;
                continue;
                i |= 0x400;
                continue;
                i |= 0x1;
                continue;
                i |= 0x4;
                continue;
                i |= 0x2;
                continue;
                i |= 0x40;
                continue;
                i |= 0x80;
                continue;
                i |= 0x800;
            }
        }
        return i;
    }

    public static CtClass getSuperclass(CtClass paramCtClass) {
        try {
            CtClass localCtClass = paramCtClass.getSuperclass();
            if (localCtClass != null) {
                return localCtClass;
            }
        } catch (NotFoundException localNotFoundException) {
            throw new CompileError("cannot find the super class of " + paramCtClass.getName());
        }
    }

    static String getTypeName(int paramInt) {
        switch (paramInt) {
            default:
                fatal();
                return "";
            case 301:
                return "boolean";
            case 306:
                return "char";
            case 303:
                return "byte";
            case 334:
                return "short";
            case 324:
                return "int";
            case 326:
                return "long";
            case 317:
                return "float";
            case 312:
                return "double";
        }
        return "void";
    }

    public static String javaToJvmName(String paramString) {
        return paramString.replace('.', '/');
    }

    public static String jvmToJavaName(String paramString) {
        return paramString.replace('/', '.');
    }

    private CtClass lookupClass0(String paramString, boolean paramBoolean) {
        CtClass localCtClass = null;
        Object localObject = paramString;
        paramString = localCtClass;
        for (; ; ) {
            try {
                localCtClass = this.classPool.get((String) localObject);
                paramString = localCtClass;
            } catch (NotFoundException localNotFoundException) {
                int i = ((String) localObject).lastIndexOf('.');
                if ((!paramBoolean) && (i >= 0)) {
                    continue;
                }
                throw localNotFoundException;
                localObject = new StringBuffer((String) localObject);
                ((StringBuffer) localObject).setCharAt(i, '$');
                localObject = ((StringBuffer) localObject).toString();
                continue;
            }
            if (paramString != null) {
                return paramString;
            }
        }
    }

    private MemberResolver.Method lookupMethod(CtClass paramCtClass, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString, boolean paramBoolean) {
        Object localObject2 = null;
        Object localObject1 = null;
        Object localObject3 = paramCtClass.getClassFile2();
        int j;
        int i;
        if (localObject3 != null) {
            localObject3 = ((ClassFile) localObject3).getMethods();
            j = ((List) localObject3).size();
            i = 0;
            localObject2 = localObject1;
            if (i < j) {
                localObject2 = (MethodInfo) ((List) localObject3).get(i);
                if (!((MethodInfo) localObject2).getName().equals(paramString)) {
                    break label329;
                }
                int k = compareSignature(((MethodInfo) localObject2).getDescriptor(), paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString);
                if (k == -1) {
                    break label329;
                }
                localObject2 = new MemberResolver.Method(paramCtClass, (MethodInfo) localObject2, k);
                if (k == 0) {
                    localObject1 = localObject2;
                    label118:
                    return (MemberResolver.Method) localObject1;
                }
                if ((localObject1 != null) && (((MemberResolver.Method) localObject1).notmatch <= k)) {
                    break label329;
                }
                localObject1 = localObject2;
            }
        }
        label282:
        label329:
        for (; ; ) {
            i += 1;
            break;
            if (!paramBoolean) {
                break label332;
            }
            localObject2 = null;
            i = paramCtClass.getModifiers();
            boolean bool = Modifier.isInterface(i);
            if (!bool) {
            }
            try {
                localObject1 = paramCtClass.getSuperclass();
                if (localObject1 != null) {
                    localObject3 = lookupMethod((CtClass) localObject1, paramString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, paramBoolean);
                    localObject1 = localObject3;
                    if (localObject3 != null) {
                        break label118;
                    }
                }
            } catch (NotFoundException localNotFoundException) {
                for (; ; ) {
                }
            }
            if ((bool) || (Modifier.isAbstract(i))) {
            }
            try {
                CtClass[] arrayOfCtClass = paramCtClass.getInterfaces();
                j = arrayOfCtClass.length;
                i = 0;
                for (; ; ) {
                    if (i >= j) {
                        break label282;
                    }
                    localObject3 = lookupMethod(arrayOfCtClass[i], paramString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, paramBoolean);
                    localObject1 = localObject3;
                    if (localObject3 != null) {
                        break;
                    }
                    i += 1;
                }
                if (bool) {
                    paramCtClass = paramCtClass.getSuperclass();
                    if (paramCtClass != null) {
                        paramCtClass = lookupMethod(paramCtClass, paramString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, paramBoolean);
                        localObject1 = paramCtClass;
                        if (paramCtClass != null) {
                            break label118;
                        }
                    }
                }
            } catch (NotFoundException paramCtClass) {
                for (; ; ) {
                }
            }
            return (MemberResolver.Method) localObject2;
        }
        label332:
        if (localObject2 != null) {
        }
        for (paramBoolean = true; ; paramBoolean = false) {
            break;
        }
    }

    private CtClass searchImports(String paramString) {
        Iterator localIterator;
        if (paramString.indexOf('.') < 0) {
            localIterator = this.classPool.getImportedPackages();
        }
        for (; ; ) {
            Object localObject1;
            if (localIterator.hasNext()) {
                localObject1 = (String) localIterator.next();
                Object localObject2 = (String) localObject1 + '.' + paramString;
                try {
                    localObject2 = this.classPool.get((String) localObject2);
                    return (CtClass) localObject2;
                } catch (NotFoundException localNotFoundException2) {
                }
            }
            try {
                if (!((String) localObject1).endsWith("." + paramString)) {
                    continue;
                }
                localObject1 = this.classPool.get((String) localObject1);
                return (CtClass) localObject1;
            } catch (NotFoundException localNotFoundException1) {
            }
            getInvalidNames().put(paramString, "<invalid>");
            throw new CompileError("no such class: " + paramString);
        }
    }

    public ClassPool getClassPool() {
        return this.classPool;
    }

    public CtClass lookupClass(int paramInt1, int paramInt2, String paramString) {
        if (paramInt1 == 307) {
            CtClass localCtClass = lookupClassByJvmName(paramString);
            paramString = localCtClass;
            if (paramInt2 > 0) {
                paramString = localCtClass.getName();
            }
        } else {
            while (paramInt2 > 0) {
                paramString = paramString + "[]";
                paramInt2 -= 1;
                continue;
                paramString = getTypeName(paramInt1);
            }
            paramString = lookupClass(paramString, false);
        }
        return paramString;
    }

    public CtClass lookupClass(String paramString, boolean paramBoolean) {
        Hashtable localHashtable = getInvalidNames();
        Object localObject = localHashtable.get(paramString);
        if (localObject == "<invalid>") {
            throw new CompileError("no such class: " + paramString);
        }
        if (localObject != null) {
            return (CtClass) localObject;
        }
        try {
            localObject = lookupClass0(paramString, paramBoolean);
            localHashtable.put(paramString, localObject);
            return (CtClass) localObject;
        } catch (NotFoundException localNotFoundException) {
            for (; ; ) {
                CtClass localCtClass = searchImports(paramString);
            }
        }
    }

    public CtClass lookupClass(Declarator paramDeclarator) {
        return lookupClass(paramDeclarator.getType(), paramDeclarator.getArrayDim(), paramDeclarator.getClassName());
    }

    public CtClass lookupClassByJvmName(String paramString) {
        return lookupClass(jvmToJavaName(paramString), false);
    }

    public CtClass lookupClassByName(ASTList paramASTList) {
        return lookupClass(Declarator.astToClassName(paramASTList, '.'), false);
    }

    public CtField lookupField(String paramString, Symbol paramSymbol) {
        paramString = lookupClass(paramString, false);
        try {
            paramString = paramString.getField(paramSymbol.get());
            return paramString;
        } catch (NotFoundException paramString) {
            throw new CompileError("no such field: " + paramSymbol.get());
        }
    }

    public CtField lookupFieldByJvmName(String paramString, Symbol paramSymbol) {
        return lookupField(jvmToJavaName(paramString), paramSymbol);
    }

    /* Error */
    public CtField lookupFieldByJvmName2(String paramString, Symbol paramSymbol, javassist.compiler.ast.ASTree paramASTree) {
        // Byte code:
        //   0: aload_2
        //   1: invokevirtual 331	javassist/compiler/ast/Symbol:get	()Ljava/lang/String;
        //   4: astore_2
        //   5: aload_0
        //   6: aload_1
        //   7: invokestatic 319	javassist/compiler/MemberResolver:jvmToJavaName	(Ljava/lang/String;)Ljava/lang/String;
        //   10: iconst_1
        //   11: invokevirtual 298	javassist/compiler/MemberResolver:lookupClass	(Ljava/lang/String;Z)Ljavassist/CtClass;
        //   14: astore 4
        //   16: aload 4
        //   18: aload_2
        //   19: invokevirtual 335	javassist/CtClass:getField	(Ljava/lang/String;)Ljavassist/CtField;
        //   22: astore_1
        //   23: aload_1
        //   24: areturn
        //   25: astore 4
        //   27: new 344	javassist/compiler/NoFieldException
        //   30: dup
        //   31: new 146	java/lang/StringBuilder
        //   34: dup
        //   35: invokespecial 147	java/lang/StringBuilder:<init>	()V
        //   38: aload_1
        //   39: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: ldc_w 346
        //   45: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   48: aload_2
        //   49: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   52: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   55: aload_3
        //   56: invokespecial 349	javassist/compiler/NoFieldException:<init>	(Ljava/lang/String;Ljavassist/compiler/ast/ASTree;)V
        //   59: athrow
        //   60: astore_1
        //   61: aload 4
        //   63: invokevirtual 157	javassist/CtClass:getName	()Ljava/lang/String;
        //   66: invokestatic 351	javassist/compiler/MemberResolver:javaToJvmName	(Ljava/lang/String;)Ljava/lang/String;
        //   69: astore_1
        //   70: new 344	javassist/compiler/NoFieldException
        //   73: dup
        //   74: new 146	java/lang/StringBuilder
        //   77: dup
        //   78: invokespecial 147	java/lang/StringBuilder:<init>	()V
        //   81: aload_1
        //   82: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   85: ldc_w 353
        //   88: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   91: aload_2
        //   92: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   95: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   98: aload_3
        //   99: invokespecial 349	javassist/compiler/NoFieldException:<init>	(Ljava/lang/String;Ljavassist/compiler/ast/ASTree;)V
        //   102: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	103	0	this	MemberResolver
        //   0	103	1	paramString	String
        //   0	103	2	paramSymbol	Symbol
        //   0	103	3	paramASTree	javassist.compiler.ast.ASTree
        //   14	3	4	localCtClass	CtClass
        //   25	37	4	localCompileError	CompileError
        // Exception table:
        //   from	to	target	type
        //   5	16	25	javassist/compiler/CompileError
        //   16	23	60	javassist/NotFoundException
    }

    public MemberResolver.Method lookupMethod(CtClass paramCtClass1, CtClass paramCtClass2, MethodInfo paramMethodInfo, String paramString, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString) {
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (paramMethodInfo != null) {
            localObject1 = localObject2;
            if (paramCtClass1 == paramCtClass2) {
                localObject1 = localObject2;
                if (paramMethodInfo.getName().equals(paramString)) {
                    int i = compareSignature(paramMethodInfo.getDescriptor(), paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString);
                    localObject1 = localObject2;
                    if (i != -1) {
                        paramCtClass2 = new MemberResolver.Method(paramCtClass1, paramMethodInfo, i);
                        if (i == 0) {
                            return paramCtClass2;
                        }
                        localObject1 = paramCtClass2;
                    }
                }
            }
        }
        if (localObject1 != null) {
        }
        for (boolean bool = true; ; bool = false) {
            paramCtClass1 = lookupMethod(paramCtClass1, paramString, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString, bool);
            paramCtClass2 = paramCtClass1;
            if (paramCtClass1 != null) {
                break;
            }
            return (MemberResolver.Method) localObject1;
        }
    }

    public String resolveClassName(ASTList paramASTList) {
        if (paramASTList == null) {
            return null;
        }
        return javaToJvmName(lookupClassByName(paramASTList).getName());
    }

    public String resolveJvmClassName(String paramString) {
        if (paramString == null) {
            return null;
        }
        return javaToJvmName(lookupClassByJvmName(paramString).getName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/javassist/compiler/MemberResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */